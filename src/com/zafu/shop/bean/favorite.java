package com.zafu.shop.bean;

public class favorite {
	private  int cid;
	private int tid;
	public favorite()
	{
		super();
	}
	public favorite(Customer customer,Tie tie)
	{
		this.cid=customer.getCid();
		this.tid=tie.getTid();
	}
	public int getCid() {
		return cid;
	}
	public void setCid(Customer customer) {
		this.cid = customer.getCid();
	}
	public int getTid() {
		return tid;
	}
	public void setTid(Tie tie) {
		this.tid = tie.getTid();
	}
}
