package com.zafu.shop.bean;

public class Good {
	private int gid;//��Ʒid
	private String gname;//��Ʒ����
	private float gtuan;//�Ź���
	private float gmen;//�ŵ��
	private int  gsold;//����
	private float gscore;//��Ʒ����
	private String gcombo;//�ײ;���
	private String gnotice;//ע������
	private String gphoto;
	private Seller seller;///���id
	public Good()
	{
		super();
	}
	public Good(int gid,String gname,float gtuan,float gmen,
			int gsold,float gscore,String gcombo,String gnotice,
			String gphoto,Seller seller)
	{
		this.gid=gid;
		this.gname=gname;
		this.gtuan=gtuan;
		this.gmen=gmen;
		this.gsold=gsold;
		this.gscore=gscore;
		this.gcombo=gcombo;
		this.gnotice=gnotice;
		this.gphoto=gphoto;
		this.seller=seller;
	}
	public Good(int gid,String gname,float gtuan,float gmen,
			String gcombo )
	{
		this.gid= gid;
		this.gname=gname;
		this.gtuan=gtuan;
		this.gmen=gmen;
		this.gcombo=gcombo;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getGsold() {
		return gsold;
	}
	public void setGsold(int gsold) {
		this.gsold = gsold;
	}
	public String getGphoto() {
		return gphoto;
	}
	public void setGphoto(String gphoto) {
		this.gphoto = gphoto;
	}
	public String getGnotice() {
		return gnotice;
	}
	public void setGnotice(String gnotice) {
		this.gnotice = gnotice;
	}
	public String getGcombo() {
		return gcombo;
	}
	public void setGcombo(String gcombo) {
		this.gcombo = gcombo;
	}
	public float getGscore() {
		return gscore;
	}
	public void setGscore(float gscore) {
		this.gscore = gscore;
	}
	public float getGtuan() {
		return gtuan;
	}
	public void setGtuan(float gtuan) {
		this.gtuan = gtuan;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public float getGmen() {
		return gmen;
	}
	public void setGmen(float gmen) {
		this.gmen = gmen;
	}

	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
}
