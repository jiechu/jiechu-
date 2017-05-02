package com.zafu.shop.bean;

import java.util.Date;

public class Customer {
	private int cid; //id
	private String cphoto; //照片
	private String cname; //名字
	private Date cbirth; //生日
	private String caddress; //地址
	private  String cphone; //电话
	private String  cpassword;//密码
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCphoto() {
		return cphoto;
	}
	public void setCphoto(String cphoto) {
		this.cphoto = cphoto;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public Date getCbirth() {
		return cbirth;
	}
	public void setCbirth(Date cbirth) {
		this.cbirth = cbirth;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Customer()
	{
		super();
	}
	public Customer(int cid,String cphoto,String cname,Date cbirth,
			String caddress,String cphone,String cpassword )
	{	
		super();
		this.cid=cid;
		this.cphoto=cphoto;
		this.cname=cname;
		this.cphone=cphone;
		this.cbirth=cbirth;
		this.cpassword=cpassword;
		this.caddress=caddress;
	}
	public Customer(int cid,String caddress,String cpassword)
	{
		super();
		this.cid=cid;
		this.caddress=caddress;
		this.cpassword=cpassword;
	}
}
