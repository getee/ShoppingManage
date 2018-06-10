package com.getee.shopmange.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.getee.shopmanage.model.bean.Wine;
import com.getee.shopmanage.model.dao.WineDaoImp;

public class WineAction {
	private Wine w;
	private WineDaoImp wdp;
	private File myFile;
	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}
	private String myFileContentType;
	private String myFileFileName;
	private String destPath;

	

	public WineAction() {
		wdp=new WineDaoImp();
	}

	public Wine getW() {
		return w;
	}

	public void setW(Wine w) {
		this.w = w;
	}

		public void uploadFileAction() {
			destPath = "C:/work/";

		      try{
		     	 System.out.println("Src File name: " + myFile);
		     	 System.out.println("Dst File name: " + myFileFileName);
		     	    	 
		     	 File destFile  = new File(destPath, myFileFileName);
		    	 FileUtils.copyFile(myFile, destFile);
		  
		      }catch(IOException e){
		         e.printStackTrace();
		       
		      }
			
		}
	/**
	 * 添加wine的方法
	 */
	public void addWine() {
		uploadFileAction();
		Wine addWine=new Wine();
		addWine.setName(w.getName());
		addWine.setKind(w.getKind());
		addWine.setPrice(w.getPrice());
		addWine.setDetail(w.getDetail());
		addWine.setPicture(w.getPicture());
		addWine.setPicture4(w.getPicture4());
		System.out.println(addWine.toString());
		boolean addResult=wdp.addWine(addWine);
		if(addResult) {
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			try {
				PrintWriter out=ServletActionContext.getResponse().getWriter();
				out.write("true");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}

}
