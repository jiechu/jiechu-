package com.zafu.shop.bean;

import java.util.Date;

public class Tie {
	private int tid;
	private int ttype;
	private Date ttime;
	private String tcontent;
	private String tpic;
	private String tname;
	private int cid;
	public Tie()
	{
		super();
	}
	public Tie(int tid,int ttype,Date ttime,String tcontent,String tpic,
			String tname,Customer customer)
	{
		this.tid=tid;
		this.ttype=ttype;
		this.ttime=ttime;
		this.tcontent=tcontent;
		this.tpic=tpic;
		this.tname=tname;
		this.cid=customer.getCid();
	}
	public Tie(int tid,int ttype,Date ttime,String tcontent)
	{
		this.tid=tid;
		this.ttype=ttype;
		this.ttime=ttime;
		this.tcontent=tcontent;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getTtype() {
		return ttype;
	}
	public void setTtype(int ttype) {
		this.ttype = ttype;
	}
	public Date getTtime() {
		return ttime;
	}
	public void setTtime(Date ttime) {
		this.ttime = ttime;
	}
	public String getTcontent() {
		return tcontent;
	}
	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}
	public String getTpic() {
		return tpic;
	}
	public void setTpic(String tpic) {
		this.tpic = tpic;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(Customer customer) {
		this.cid = customer.getCid();
	}
}
