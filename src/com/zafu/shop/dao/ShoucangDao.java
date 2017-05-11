package com.zafu.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.zafu.shop.bean.Customer;
import com.zafu.shop.bean.Tie;
import com.zafu.shop.bean.favorite;
import com.zafu.shop.db.DBHelper;


public class ShoucangDao {
	
	public static void InsertShoucang(int cid,int tid)
	{
		
			String sql="insert into shoucang(cid,tid) values('"+cid+"','"+tid+"')";
			DBHelper.executeNonQuery(sql);	
	}
	public static ArrayList<favorite> SelectShoucangBycid(int cid)
	{
		try{
			ArrayList<favorite> fa=new ArrayList<favorite>();
			String sql="select tid,cid from shoucang where cid="+cid;
		ResultSet rs=DBHelper.executeQuery(sql);
		while(rs.next())
		{
			favorite f=new favorite();
			Customer c=new Customer();
			c=CustomerDao.SelectCustomerByCid(cid);
			f.setCid(c);
			Tie t=new Tie();
			t=TieDao.SelectTieByCid(cid);
			f.setTid(t);
			fa.add(f);
		}
		return fa;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
