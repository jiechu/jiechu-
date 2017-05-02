package com.zafu.shop.bean;

public class Pinglun {
	private int pid;
	private int cid;
	private int tid;
	private String content;
	public Pinglun()
	{
		super();
	}
	public Pinglun(int pid,Customer cust,Tie tie,String content)
	{
		this.pid=pid;
		this.cid=cust.getCid();
		this.tid=tie.getTid();
		this.content=content;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(Tie tie) {
		this.tid = tie.getTid();
	}
	public int getCid() {
		return cid;
	}
	public void setCid(Customer customer) {
		this.cid = customer.getCid();
	}
	
}
