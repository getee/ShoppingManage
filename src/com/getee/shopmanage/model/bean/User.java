package com.getee.shopmanage.model.bean;


public class User {
    private int id;
    private String name;
    private String password;
    private String province;//省
    private String city;//市
    private int phone;
    private String picture;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public User() {
		super();
	}
	public User(int id, String name, String password, String province, String city, int phone, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.province = province;
		this.city = city;
		this.phone = phone;
		this.picture = picture;
	}
	
	public User(String name, String password, String province, String city, int phone, String picture) {
		super();
		this.name = name;
		this.password = password;
		this.province = province;
		this.city = city;
		this.phone = phone;
		this.picture = picture;
	}
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password
                + ", province=" + province + ", city=" + city + ", phone="
                + phone + ", picture=" + picture + "]";
    }
    
    
}
