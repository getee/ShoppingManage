package com.getee.shopmange.action;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.getee.shopmanage.model.bean.User;
import com.getee.shopmanage.model.dao.UserDaoImp;

public class UserAction{
    private User u;
    private User add;
    private UserDaoImp ud;
    
    private File myfile;
    //struts2在文件上传时提供的属性	
    private String myfileFileName;//上传的文件名。上传字段名称+FileName  注意大小写
   	private String myfileContentType;//上传文件的MIME类型。上传字段名称+ContentType 注意大小写
	public File getMyfile() {
		return myfile;
	}

	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}

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
    	String realPath = servletContext.getRealPath("/WEB-INF/file");
    	   //3.如果这个真实的目录不存在，需要创建
    	 		File file = new File(realPath );
    			if(!file.exists()){
    			file.mkdirs();
    			}
    		//4.把文件存过去
    			//拷贝：把文件的临时文件复制到指定的位置。注意：临时文件还在
    		//FileUtils.copyFile(myfile, new File(file,myfileFileName));
    		//剪切：把临时文件剪切指定的位置，并且给他重命名。 注意：临时文件没有了
   		myfile.renameTo(new File(file,myfileFileName));
   		System.out.println(myfile.getAbsolutePath());
   		return "success";
}
}
