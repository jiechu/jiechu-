package com.zafu.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zafu.shop.bean.Seller;
import com.zafu.shop.db.DBHelper;

public class SellerDao {
	/*
	 * ͨ��id��ѯ�̼���Ϣ
	 */
	public  static Seller getSellerByid(int sid)
	{	
		try{
			System.out.println("�̼���Ϣ��ѯ:");
			String sql="select  sid,sphone,spass,sname,sadd,sscore,"
					+ "sdesc,sphoto from seller where sid="+sid;
			ResultSet rs=DBHelper.executeQuery(sql);
			
			if(rs.next())
			{
				Seller result=new Seller();
				result.setSid(rs.getInt("sid"));
				result.setSphone(rs.getString("sphone"));
				result.setSpassword(rs.getString("spass"));
				result.setSname(rs.getString("sname"));
				result.setSaddress(rs.getString("sadd"));
				result.setSscore(rs.getFloat("sscore"));
				result.setSdesc(rs.getString("sdesc"));
				result.setSphoto(rs.getString("sphoto"));
				System.out.println("getSeller:"+result);
				return result;

			}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		
		return null;
	}
	/*
	 * �����̼�
	 */
	public static int InsertSeller(Seller seller)
	{		
		 int result=DBHelper.executeNonQuery("insert into seller(sid,sphone,spass,sname,sadd,sscore,sphoto,sdesc) values(?,?,?,?,?,?,?,?)",
		seller.getSid(),seller.getSphone(),seller.getSpassword(),seller.getSname(),
		seller.getSaddress(),seller.getSscore(),seller.getSphoto(),seller.getSdesc());	
		return result;
	}
	/*
	 * ��ѯ���µ�һ���û���¼
	 */
	public static int SelectLastSeller()
	{	
		try
		{
		String sql="select sid from seller order by sid desc ";
		ResultSet rs=DBHelper.executeQuery(sql);
		rs.next();
		int sid=rs.getInt(1);
		return sid;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	
	/*
	 * �̼ҵ�½
	 */
	public static Boolean SellerLogin(String sphone,String spass)
	{
		int result;
		try{
			String sql="select sphone,spass from seller where sphone='"+sphone+"' and spass='"+spass+"'";
			//�ַ������ͱ����""
			ResultSet rs=DBHelper.executeQuery(sql);
			if(rs.next())
			{
					return true;
			}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		return false;
	}
	
	
	
	/*
	 * �ж��Ƿ��Ѿ������ַ
	 */
	
	
	
	/*
	 * �̼�չʾ
	 */
	public static ArrayList<Seller> SelectSeller()
	{
		try{
			ArrayList<Seller> list=new ArrayList<Seller>();
			String sql="select sid,sphone,spass,sname,sadd,sscore,sphoto,sdesc from seller";
			ResultSet rs=DBHelper.executeQuery(sql);
			
			while(rs.next()){
				Seller result=new Seller();
				result.setSaddress(rs.getString("sadd"));
				result.setSdesc(rs.getString("sdesc"));
				result.setSid(rs.getInt("sid"));
				result.setSname(rs.getString("sname"));
				result.setSpassword(rs.getString("spass"));
				result.setSphone(rs.getString("sphone"));
				result.setSphoto(rs.getString("sphoto"));
				result.setSscore(rs.getFloat("sscore"));
				list.add(result);
			}
			return list;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	 * �޸��̼�����
	 */
}
