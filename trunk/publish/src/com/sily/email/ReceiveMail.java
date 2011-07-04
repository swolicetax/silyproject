package com.sily.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import javax.mail.BodyPart;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeUtility;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;

import com.sily.publish.PublishResourceBundle;
import com.sily.publish.WordPressPost;
import com.sily.util.StringUtils;
import com.sily.validate.CheckValidateException;

public class ReceiveMail {
	
	private Map<String,String> attaMap = new HashMap<String,String>();

	public static Logger log = Logger.getLogger("publish");
	
	private String host = "pop3.sina.com.cn";
	
	StringBuilder sb = new StringBuilder();
	StringBuilder sb_html = new StringBuilder();

	public static void main(String[] args) {
		new ReceiveMail().receive("sily_sae@sina.com", "sily_sae",
				"123456");
	}
	
	public static void logic(){
		new ReceiveMail().receive("sily_sae@sina.com", "sily_sae",
		"123456");
	}

	// 处理任何邮件时需要的方法
	private String handle(Message msg) throws MessagingException {
		log.info("邮件主题：" + msg.getSubject());
		log.info("邮件作者：" + msg.getFrom()[0].toString());
		log.info("发送日期：" + msg.getSentDate());
		return msg.getSubject();
	}

	// 处理文本邮件
	private void handleText(Message msg) throws MessagingException, IOException {
		System.out
				.println("----------------------------------------------------");
		this.handle(msg);
		System.out.println("邮件内容：" + msg.getContent());
		System.out
				.println("----------------------------------------------------");
	}

	// 文件名解码
	public String Base64Decoder(String s) throws Exception {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		} catch (Exception e) {
			return null;
		}
	}
	public static String toChinese(String strvalue){ 
	    try{ 
	      if(strvalue==null) 
	        return null; 
	      else{ 
	        strvalue = new String(strvalue.getBytes("ISO8859_1"), "GBK"); 
	        return strvalue; 
	      } 
	    }catch(Exception e){ 
	      return null; 
	    } 
	  } 

	// 保存附件
	private String saveAttach(Part part) throws Exception {
		// 得到未处理的附件名字
		String temp = part.getFileName();
		// 除去发送邮件时对中文附件名编码的头和尾，得到正确的附件名
		log.info(temp);
		// 文件名解码
		String fileName = "";
		temp = temp.toLowerCase();
		if ((temp.startsWith("=?utf-8?b?") && temp.endsWith("?="))
				|| (temp.startsWith("=?gbk?b?") && temp.endsWith("?="))) {
			temp = Base64Decoder(temp.substring(8, temp
					.indexOf("?=") - 1));
			fileName = MimeUtility.decodeText(temp);
		} else {
			temp = toChinese(temp);
			fileName = MimeUtility.decodeText(temp);
		}
		
		System.out.println("有附件：" + fileName);
		InputStream in = part.getInputStream();
		File path = new File(getSaveAttaPath() + File.separator + UUID.randomUUID());
		if(!path.exists()){
			path.mkdirs();
		}
		File attaStr  =  new File(getSaveAttaPath()+ File.separator + fileName);
		FileOutputStream writer = new FileOutputStream(attaStr);
		int read = 0;
		while ((read = in.read()) != -1) {
			writer.write(read);
		}
		writer.close();
		in.close();
		try {
			String url = WordPressPost.publishMedia(attaStr);
			if(StringUtils.isNotNull(url)){
				attaMap.put(fileName,url);
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}finally{
			attaStr.delete();
		}
		
		return "";
	}

	// 处理Multipart邮件，包括了保存附件的功能
	private void handleMultipart(Message msg) throws Exception {

		BodyPart bodyPart;
		
		String contentType = msg.getContentType();
		// 假如邮件内容是纯文本或者是Html，那么打印出信息
		log.info("CONTENT:" + contentType);
		if (contentType.startsWith("text/plain")
				|| contentType.startsWith("text/html")) {
			// System.out.println(msg.getContent());
			String title = this.handle(msg);
			String ss = msg.getContent().toString();
			if(ss.length()>0){
				WordPressPost.publishPost(title, ss);
			}
		}else{
			Object content = msg.getContent();
			// 附件
			Multipart mp = null;
			if (content instanceof Multipart) {
				mp = (Multipart) content;
				log.info("[ Multipart Message ]");
			}
			if (mp != null) {
				int mpCount = mp.getCount();
				String title = this.handle(msg);
				for (int i = 0; i < mpCount; i++) {
					bodyPart = mp.getBodyPart(i);
					handleMultipart(bodyPart);
				}
				if(sb_html.length()>0){
					String html = sb_html.toString();
					if(!attaMap.isEmpty()){
						html = publishAtta(attaMap,html);
					}
					WordPressPost.publishPost(title,html);
				}else{
					if(sb.length()>0){
						WordPressPost.publishPost(title, sb.toString());
					}
				}
				sb.setLength(0);
				sb_html.setLength(0);
			}
		}
	}
	
	public void handleMultipart(Part bodyPart) throws Exception {
		log.info(bodyPart.getContentType());
		String disposition = bodyPart.getDisposition();
		// 判断是否有附件
		if (disposition != null && (disposition.equals(Part.ATTACHMENT)||disposition.equals(Part.INLINE))) {
			//保存附件
			this.saveAttach(bodyPart);
			//handleText(msg);
		} else {
			if(bodyPart.getContentType().startsWith("text/plain")){
				sb.append(bodyPart.getContent());
			}else if(bodyPart.getContentType().startsWith("text/html")){
				sb_html.append(bodyPart.getContent());
			}else if(bodyPart.isMimeType("multipart/*")){
				Multipart multipart=(Multipart)bodyPart.getContent();
				int mpCount = multipart.getCount();
				for (int i = 0; i < mpCount; i++) {
					bodyPart = multipart.getBodyPart(i);
					handleMultipart(bodyPart);
				}
			}else if(bodyPart.isMimeType("message/rfc822")){
				handleMultipart((Part)bodyPart.getContent());
			}else if(bodyPart.isMimeType("image/jpeg")){
				this.saveAttach(bodyPart);
			}
		}
	}
	
	private String publishAtta(Map<String,String> attaMap, String html){
		String attaStr = "附件内容：";
		Set<String> set = attaMap.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String key = it.next();
			if(html.indexOf(key)>-1){
				html = html.replace("cid:__0@Foxmail.net", attaMap.get(key));
			}else{
				attaStr += "<a href='"+attaMap.get(key)+"' title='"+key+"'>"+key+"</a>  ";
			}
			
		}
		return html + attaStr;
	}
	

	// 接受邮件
	public void receive(String receiveMailBoxAddress, String userName,
			String password) {
		try {
			Properties pops = new Properties();
			pops.put("mail.pop3.host", host);
			pops.put("mail.pop.auth", "true");
			Session session = Session.getDefaultInstance(pops, null);
			Store store = session.getStore("pop3");
			store.connect(host, userName, password);
			Folder inbox = store.getDefaultFolder().getFolder("INBOX");
			// 设置inbox对象属性为可读写，这样可以控制读完邮件后直接删除该附件
			inbox.open(Folder.READ_WRITE);
			Message[] msg = inbox.getMessages();
			FetchProfile profile = new FetchProfile();
			profile.add(FetchProfile.Item.ENVELOPE);
			inbox.fetch(msg, profile);
			for (int i = 0; i < msg.length; i++) {
				// 标记此邮件的flag标志对象的DELETEED为true，可以在看完邮件后直接删
				//除该邮件，在调用inbox.close（）时
				//不支持其他的操作，pop3，有些服务器可能支持
				msg[i].setFlag(Flags.Flag.DELETED, true);
				handleMultipart(msg[i]);
				System.out.println("------------------------------------------");
			}
			if (inbox != null)
				inbox.close(true);
			if (store != null)
				store.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  static String getSaveAttaPath() throws CheckValidateException{
		String mailpath = PublishResourceBundle.getResourcesAbsolutePath("mail.properties");
		Properties prop  = new Properties();
		try {
			prop.load(new FileInputStream(new File(mailpath)));
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		String attaPath = prop.getProperty("attachment_path");
		if(StringUtils.isNotNull(attaPath)){
			return attaPath.endsWith("/")?attaPath:attaPath+"/";
		}else{
			new CheckValidateException("mail.properties文件中attachment_path的key不存在");
			return "";
		}
	}
}
