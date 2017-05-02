package com.zafu.shop.bean;

public class Seller {
	private int sid;
	private String sphone;
	private String spassword;
	private String sname;
	private String saddress;
	private float sscore;
	private String sphoto;
	private String sdesc;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public float getSscore() {
		return sscore;
	}
	public void setSscore(float sscore) {
		this.sscore = sscore;
	}
	public String getSphoto() {
		return sphoto;
	}
	public void setSphoto(String sphoto) {
		this.sphoto = sphoto;
	}
	public String getSdesc() {
		return sdesc;
	}
	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}
	public  Seller()
	{
		super();
	}
	public Seller(int sid,String sphone,String spassword,
			String sname,String saddress,float sscore,String sphoto,
			String sdesc )
	{
		super();
		this.sid=sid;
		this.sphone=sphone;
		this.spassword=spassword;
		this.sname=sname;
		this.sphoto=sphoto;
		this.sscore=sscore;
		this.sdesc=sdesc;
		this.saddress=saddress;
	}
	public Seller(int sid,String sphone,String spassword)
	{
		this.sid=sid;
		this.sphone=sphone;
		this.spassword=spassword;
	}
}
