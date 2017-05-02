package com.zafu.shop.bean;

import java.util.Date;

public class Orders {
	private int oid;
	private String ophone;
	private Date otime;
	private int oamount;
	private float oprice;
	private int ostate;
	private int oscore;
	private int gid;
	private int cid;
	public Orders()
	{
		super();
	}
	public Orders(int oid,String ophone,Date otime,int oamount,
			float oprice,int ostate,int oscore,Good good,
			Customer customer)
	{
		this.oid=oid;
		this.ophone=ophone;
		this.otime=otime;
		this.oamount=oamount;
		this.oprice=oprice;
		this.ostate=ostate;
		this.oscore=oscore;
		this.gid=good.getGid();
		this.cid=customer.getCid();
	}
	public Orders(int oid,String ophone,int oamount,float oprice )
	{
		this.oid=oid;
		this.ophone=ophone;
		this.oamount=oamount;
		this.oprice=oprice;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOphone() {
		return ophone;
	}
	public void setOphone(String ophone) {
		this.ophone = ophone;
	}
	public Date getOtime() {
		return otime;
	}
	public void setOtime(Date otime) {
		this.otime = otime;
	}
	public int getOamount() {
		return oamount;
	}
	public void setOamount(int oamount) {
		this.oamount = oamount;
	}
	public float getOprice() {
		return oprice;
	}
	public void setOprice(float oprice) {
		this.oprice = oprice;
	}
	public int getOstate() {
		return ostate;
	}
	public void setOstate(int ostate) {
		this.ostate = ostate;
	}
	public int getOscore() {
		return oscore;
	}
	public void setOscore(int oscore) {
		this.oscore = oscore;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(Good good) {
		this.gid = good.getGid();
	}
	public int getCid() {
		return cid;
	}
	public void setCid(Customer customer) {
		this.cid = customer.getCid();
	}
}
