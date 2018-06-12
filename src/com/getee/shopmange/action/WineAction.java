package com.getee.shopmange.action;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import com.getee.shopmange.util.Responser;
import com.getee.shopmanage.model.bean.Wine;
import com.getee.shopmanage.model.dao.WineDaoImp;


public class WineAction {
	private Wine w;
	private WineDaoImp wdp;
	private File myFile; //得到上传的文件
	private String myFileContentType;//得到文件的类型
	private String myFileFileName;//得到文件的名称
	
	

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

	public WineAction() {
		wdp=new WineDaoImp();
	}

	public Wine getW() {
		return w;
	}

	public void setW(Wine w) {
		this.w = w;
	}
	/**
	 * 实现文件的上传
	 */
	public void  fileUploadAction() {
		//myFile为临时的路径名+文件名
		//myFileFileName为文件名
		String dir=ServletActionContext.getServletContext().getRealPath("/");//获取真实路径
		String saveDir=dir+"picture";//上传文件的保存的相对路径
		//用UUID随机生成一个不重复的字符串来重命名
		String uuid=UUID.randomUUID().toString().replaceAll("-", "");
		//用UUID命名文件+获取文件的后缀名
		myFileFileName=uuid+"."+myFileFileName.substring(myFileFileName.lastIndexOf(".")+1);
		File destFile=new File(saveDir, myFileFileName);
		System.out.println("myFile:"+myFile);
		System.out.println("myFileFileName:"+myFileFileName);
		
		 //if(!destFile.exists())destFile.mkdirs();
		try {
			FileUtils.copyFile(myFile, destFile);
			System.out.println("上传成功");
		} catch (IOException e) {
			System.out.println("上传失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加wine的方法
	 */
	public void addWine() {
		fileUploadAction();
		Wine addWine=new Wine();
		addWine.setName(w.getName());
		addWine.setKind(w.getKind());
		addWine.setPrice(w.getPrice());
		addWine.setDetail(w.getDetail());
		addWine.setPicture("picture/"+myFileFileName);
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

	public void searchWine() {
		System.out.println("进入 修改"+w.getId());
		Wine willUpdateWine=wdp.getIDWine(w.getId());
		if(willUpdateWine!=null) {
			JSONArray jsonarr=new JSONArray();
			JSONObject jsono=new JSONObject();
			try {
				jsono.put("name", willUpdateWine.getName());
				jsono.put("kind", willUpdateWine.getKind());
				jsono.put("price", willUpdateWine.getPrice());
				jsono.put("detail", willUpdateWine.getDetail());
				jsono.put("picture", willUpdateWine.getPicture());
				jsono.put("picture", willUpdateWine.getPicture4());
				jsonarr.put(jsono);
				System.out.println(jsonarr.toString());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
			try {
				PrintWriter out=ServletActionContext.getResponse().getWriter();
				out.write(jsonarr.toString());
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			try {
				PrintWriter out=ServletActionContext.getResponse().getWriter();
				out.write("null");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	public void updateWine() {
		try {
			
			fileUploadAction();
			Wine  updateWine=new Wine();
			updateWine.setId(w.getId());
			updateWine.setName(w.getName().trim());
			updateWine.setKind(w.getKind().trim());
			updateWine.setPrice(w.getPrice());
			updateWine.setDetail(w.getDetail().trim());
			updateWine.setPicture("picture/"+myFileFileName);
			updateWine.setPicture4(w.getPicture4());
			System.out.println(updateWine.toString());
			boolean updateResult=wdp.update(updateWine);
			if(updateResult) {
				System.out.println("修改成功");
			}else {
				System.out.println("修改失败");
				
			}
		}catch(Exception e) {
				e.printStackTrace();
				Wine  updateWine=new Wine();
				updateWine.setId(w.getId());
				updateWine.setName(w.getName().trim());
				updateWine.setKind(w.getKind().trim());
				updateWine.setPrice(w.getPrice());
				updateWine.setDetail(w.getDetail().trim());
				updateWine.setPicture("picture/"+myFileFileName);
				updateWine.setPicture4(w.getPicture4());
				System.out.println(updateWine.toString());
				boolean updateResult=wdp.update(updateWine);
				if(updateResult) {
					System.out.println("修改成功");
				}else {
					System.out.println("修改失败");
					
				}
		}
		
		
			
		}
		



	private Wine wine;
	private String searchValue;
	private String searchKind;

	private String page;
	private String rows;
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	WineDaoImp dao=null;
	
	
	public WineAction() {
		dao=new WineDaoImp();
	}

	public Wine getWine() {
		return wine;
	}

	public void setWine(Wine wine) {
		this.wine = wine;
	}
	
	
	
	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getSearchKind() {
		return searchKind;
	}

	public void setSearchKind(String searchKind) {
		this.searchKind = searchKind;
	}


	
	private int page;
	private int rows;
	private int id;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 分页显示查询酒信息的方法
	 */
	public void listWinesByPage() {
		ArrayList<Wine> wines=dao.listWineByPage(page, rows);
		System.out.println(page);
		System.out.println(rows);
		JSONArray  js=new JSONArray();
		for(Wine c:wines) {
			try {
				JSONObject  j=new JSONObject();
				j.put("wine_id", c.getId());
				j.put("wine_name", c.getName());
				j.put("kind", c.getKind());
				j.put("price", c.getPrice());
				j.put("detail", c.getDetail());
				j.put("picture", "<img src='"+c.getPicture()+"'  style='width:20px;height:20px'/>");
				j.put("picture4", "<img src='"+c.getPicture4()+"'  style='width:20px;height:20px'/>");
				js.put(j);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), js.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据id删除酒信息的方法
	 */
	public void deleteWineInfoByWineId() {
		System.out.println(id);
		boolean result=dao.delete(id);

		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), result+"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String execute() {
		
		return "success";
	}

	/**
	 * 这是商品管理->搜索商品业务
	 * 可以按照种类与名字查询
	 */
	public void searchWine() {
		//String value=null;
		ArrayList<Wine> winelist=null;
		System.out.println(searchValue);
		/*try {//easyui传过来的种类kind是乱码的，故转了一下
			value=new String(searchValue.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}*/
		
System.out.println(page);
System.out.println(rows);

		//用来判断搜索的方式,为kind是按种类，否则为名字
		if(searchKind.equals("kind")) {
			winelist=dao.getKindPage(searchValue,Integer.parseInt(page), Integer.parseInt(rows));
		}else {
			System.out.println("name");
			winelist=dao.getNamePage(searchValue,Integer.parseInt(page), Integer.parseInt(rows));
		}
		//将查出来的数据放到json中
System.out.println("1----");
		JSONArray  js=new JSONArray();
		for(Wine c:winelist) {
			try {
		System.out.println("2----");
				JSONObject  j=new JSONObject();
				j.put("wine_id", c.getId());
				j.put("wine_name", c.getName());
				j.put("kind", c.getKind());
				j.put("price", c.getPrice());
				j.put("detail", c.getDetail());
				j.put("picture", "<img src='"+c.getPicture()+"'  style='width:20px;height:20px'/>");
				j.put("picture4", "<img src='"+c.getPicture4()+"'  style='width:20px;height:20px'/>");
				js.put(j);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
System.out.println("3----");
		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), js.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}

