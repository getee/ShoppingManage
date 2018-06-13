package com.getee.shopmange.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


import org.apache.struts2.ServletActionContext;


/**
 * 获取省市信息的action
 * */
public class ProCityAction {

public  String  getProCityMess() {
	System.out.println("进入到获取省市级联action");
	HashMap<String, ArrayList<String>> map=readFileByLines();
	ArrayList<String> pro=new ArrayList<>();
	for(String s:map.keySet()) {
		pro.add(s);
	}
	ServletActionContext.getRequest().getSession().setAttribute("shen",pro);
	ServletActionContext.getRequest().getSession().setAttribute("shenshi",map);
	return "success";
}


public static HashMap<String, ArrayList<String>> readFileByLines() {  
			HashMap<String, ArrayList<String>> map=new HashMap<>();
			//web项目中获取文本文件路径
			File file=new File(ProCityAction.class.getClassLoader().getResource("../../1.txt").getPath());  
	        BufferedReader reader=null;  
	        String temp=null;  
	        try{  
	                reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));  
	                while((temp=reader.readLine())!=null){  
	                    String[] a=temp.split(" ");
	                    ArrayList<String> value=new ArrayList<>();
	                    for (int i = 1; i < a.length; i++) {
							value.add(a[i]);
						}
	                   map.put(a[0], value);
	                }  
	        }  
	        catch(Exception e){  
	            e.printStackTrace();  
	        }  
	        finally{  
	            if(reader!=null){  
	                try{  
	                    reader.close();  
	                }  
	                catch(Exception e){  
	                    e.printStackTrace();  
	                }  
	            }  
	        } 
	     return map;   
    }  
//public static void main(String[] args) {
//	HashMap<String, ArrayList<String>> map=readFileByLines("1.txt");
//	System.out.println(map);
//}
}
