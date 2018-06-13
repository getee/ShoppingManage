package com.getee.shopmange.action;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;


import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.getee.shopmanage.model.bean.User;
import com.getee.shopmanage.model.dao.UserDaoImp;

public class UserAction implements RequestAware{
    private User u;
    private User add;
    private User update;
    private UserDaoImp ud;
    
    private File myfile;
    //struts2在文件上传时提供的属性	
    private String myfileFileName;//上传的文件名。上传字段名称+FileName  注意大小写
   	private String myfileContentType;//上传文件的MIME类型。上传字段名称+ContentType 注意大小写
    private File upload;
    private String uploadFileName;
   	private String uploadContentType;
   	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}


    private Map<String, Object> request=new HashMap<>();
    private UserDAO dao; 
    private String key;//搜索用户的列名
    private String val;//搜索用户输入的值

	public String getUploadFileName() {
		return uploadFileName;
	}


	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public File getMyfile() {
		return myfile;
	}

	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}


	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;

	public String getMyfileFileName() {
		return myfileFileName;
	}

	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;

	}

	public String getMyfileContentType() {
		return myfileContentType;
	}

	public void setMyfileContentType(String myfileContentType) {
		this.myfileContentType = myfileContentType;
	}

	public UserAction() {
    	ud=new UserDaoImp();
	}

	public User getAdd() {
		return add;
	}

	public void setAdd(User add) {
		this.add = add;
	}

	public User getUpdate() {
		return update;
	}

	public void setUpdate(User update) {
		this.update = update;
	}

	public User getU() {

        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public String login(){

        System.out.println(u.getName()+"$$"+u.getPassword());
        return "success";
    }

    public String AddUser() {
    	//1.拿到ServletContext
    	ServletContext servletContext = ServletActionContext.getServletContext();
    	//2.调用realPath方法，获取根据一个虚拟目录得到的真实目录	
    	String realPath = servletContext.getRealPath("/images/file");
    	   //3.如果这个真实的目录不存在，需要创建
    	 		File file = new File(realPath );
    			if(!file.exists()){
    				System.out.println("创建文件夹");
    			file.mkdirs();
    			}
    		//4.把文件存过去
    			//拷贝：把文件的临时文件复制到指定的位置。注意：临时文件还在
    		/*try {
				FileUtils.copyFile(myfile, new File(file,myfileFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}*/
    		//剪切：把临时文件剪切指定的位置，并且给他重命名。 注意：临时文件没有了
    			File newfile=new File(file,myfileFileName);
    			myfile.renameTo(newfile);
   		System.out.println(newfile.getAbsolutePath());
		String  urlPath=newfile.getAbsolutePath().substring(newfile.getAbsolutePath().indexOf("images"),newfile.getAbsolutePath().length());
   		System.out.println(urlPath);
   		add.setPicture(urlPath);
   		boolean b=ud.addUser(add);   		
   		ServletActionContext.getRequest().setAttribute("jieguo", b);
		return "success";
}
    public void uploadImg() {
    	String path=ServletActionContext.getRequest().getRealPath("images");//用request获取服务器上的upload目录绝对地址
		String lastFileName=UUID.randomUUID()+uploadFileName.substring(uploadFileName.lastIndexOf("."),	 uploadFileName.length());
		File  dest=new File(path,lastFileName);//新建一个文件对象，准备将上传的文件存储到这个文件位置上
		try {
			FileUtils.copyFile(upload, dest);//用apache的fileupload组件里面的文件帮助类直接讲上传的文件拷贝到我们想放置的文件位置上
			System.out.println("upload  ok");
			//ajax response text
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			PrintWriter  out=ServletActionContext.getResponse().getWriter();
			System.out.println("images/"+lastFileName);
			out.write("images/"+lastFileName);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    public String updateUser() {
    	boolean b=ud.update(update);
    	ServletActionContext.getRequest().setAttribute("update", b);
    	return "success";
    }

    
    
    /**
     * 这是显示所有用户的方法
     * @param page
     * @param count
     */
   public String listUser() {
	   System.out.println(page+count);
	   UserDAOImp dao=new  UserDAOImp();
	   ArrayList<User> user=dao.getUserPage( page, count);
	   JSONArray ja=new JSONArray();
	   for(User u:user) {
		   JSONObject j=new JSONObject();
		   try {
			j.put("userid", u.getId());
			j.put("username", u.getName());
			j.put("phone", u.getPhone());
			j.put("province", u.getProvince());
			j.put("city", u.getCity());
			j.put("picture", "<img src='"+u.getPicture()+"' style='width:20px;height:20px' />");
			ja.put(j);
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		   }
	   System.out.println(ja.toString());

		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), ja.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "listUsers";
   }
    
   /**
    * 这是搜索用户的方法
    */
   public String searchUsers() {
	 
		try {
			val=new String(val.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   System.out.println(key);
	   System.out.println(val);
	  
	   UserDAOImp dao=new  UserDAOImp();
	   ArrayList<User> users=new ArrayList<User>();
	   if(key.equals("username")){
		 users=dao.searchNameUser(val, page, count);
	   }else if (key.equals("userid")) {
		   users=dao.getIDUser(val);
	   }else if(key.equals("province")) {
		   users=dao.searchProvinceUser(val, page, count);
	   }else if(key.equals("city")) {
		   users=dao.searchCityUser(val, page, count);
	   }
	   JSONArray ja=new JSONArray();
	
	for(User u:users) {
		   JSONObject j=new JSONObject();
		   try {
			j.put("userid", u.getId());
			j.put("username", u.getName());
			j.put("phone", u.getPhone());
			j.put("province", u.getProvince());
			j.put("city", u.getCity());
			String image="<img src='"+u.getPicture()+"' style='width:20px;height:20px' />";
			j.put("picture", image);
			ja.put(j);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   }
	   System.out.println(ja.toString());

		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), ja.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "searchUsers";
   }
    
	@Override
	public void setRequest(Map<String, Object> arg0) {
	
		
	}


}
