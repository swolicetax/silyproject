/*
 * Created on 2009-9-8
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.cthq.crm.order.dao.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author a
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ReplaceSpace {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("E:/bnet/DealResultReq.xml");
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			while((str = br.readLine())!= null ){
				str.replaceAll("\n","").replaceAll("\t","");
				System.out.print(str.trim());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
