/** 
 * 文件名：		DemoPost.java 
 * 
 * 版本信息: 	v1.0
 * 日期：		2011-6-29 
 * Copyright:  	Copyright(c) 2010
 * Corporation:	2011 
 * Company：		广州正道科技有限公司  
 */
package cn.com.sily;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import com.cthq.crm.webservice.util.ReadFile;

/**
 * 名称： DemoPost 
 * 描述： 创建人： sily 
 * 创建时间： 2011-6-29 上午08:38:56 
 * 修改人：
 *  修改时间： 
 *  修改备注：
 * 
 * @version 1.0
 */
public class DemoPost {
	
	public static Logger log = Logger.getLogger("publish");

	public static void main(String[] args){

		ReadFile rf =  new ReadFile();
		
		String desc = rf.getFileContent("C:/Users/sily/Desktop/test.txt", "GBK");
		
		try {
//			String desc = new String(readFromFile("C:/Users/sily/Desktop/test.txt"));
//			publishPost("知识扩充：企业博客、MetaWeblog 和 XML-RPC",desc);
			File file = new File("D:/我的桌面/clock.avi");
			byte[] bytes = getOutExcelByteCon(file);
			publishMedia(file.getName(),FileType.getMineType(file),bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取excel数据的二进制数组
	 * 
	 * @return
	 */
	private  static byte[] getOutExcelByteCon(File excelFile) {
		byte[] attachBytes = null;
		try {
			FileInputStream inputStream = new FileInputStream(excelFile);
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			int cb = 0;
			while ((cb = inputStream.read()) != -1) {
				outStream.write(cb);
			}
			inputStream.close();
			attachBytes = outStream.toByteArray();
			outStream.close();
			return attachBytes;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	
	public static void publishMedia(String name,String type,byte[] bytes) throws Exception{
		// Set up XML-RPC connection to server
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL(
				"http://sily.sinaapp.com/xmlrpc.php"));
		XmlRpcClient client = new XmlRpcClient();
		client.setConfig(config);

		// Set up parameters required by newPost method
		Map<String, Object> post = new HashMap<String, Object>();
		post.put("name", name);
		post.put("type", type);
		post.put("bits",bytes);
		Object[] params = new Object[] { "1", "sily", "jishijun", post};

		// Call newPost
		Map<String,String> result = (Map<String,String>) client.execute("metaWeblog.newMediaObject", params);
		System.out.println(" metaWeblog.newMediaObject url: " + result.get("url"));
		log.info(" metaWeblog.newMediaObject url: " + result.get("url"));
	}
	
	
	
	
	
	
	
	
	
	
	public static void publishPost(String title,String desc) throws Exception {
		// Set up XML-RPC connection to server
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL(
				"http://sily.sinaapp.com/xmlrpc.php"));
		XmlRpcClient client = new XmlRpcClient();
		client.setConfig(config);

		// Set up parameters required by newPost method
		Map<String, String> post = new HashMap<String, String>();
		post.put("title", title);
//		post.put("link", "http://sily.sinaapp.com/");
		post.put("description",desc);
		Object[] params = new Object[] { "1", "sily", "jishijun", post,
				Boolean.TRUE };

		// Call newPost
		String result = (String) client.execute("metaWeblog.newPost", params);
		log.info(" Created with blogid " + result);
	}

	
	private static byte[] readFromFile(String src) throws Exception {
        byte data[];
        File file = new File(src);
        InputStream in = new FileInputStream(src);
        data = new byte[(int)file.length()];
        in.read(data);
        in.close();
        return data;
    }
	
}
