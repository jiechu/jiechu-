package com.zafu.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.zafu.shop.bean.Good;
import com.zafu.shop.bean.Orders;
import com.zafu.shop.bean.Seller;
import com.zafu.shop.db.DBHelper;
import com.zafu.shop.dao.SellerDao;

public class GoodDao {
	//获得全部商品
	public static ArrayList< Good> GetGood()
	{	
		try{
			ArrayList< Good> list=new ArrayList<Good>();
			String sql="select gid,gname,gtuan,gmen,gsold,gscore,gcombo"
					+ ",gnotice,gphoto,sid from good";
			
			ResultSet rs=DBHelper.executeQuery(sql);
			while(rs.next())
			{
				System.out.println("查询成功");
				Good good=new Good();
				good.setGid(rs.getInt("gid"));
				good.setGname(rs.getString("gname"));
				good.setGtuan(rs.getFloat("gtuan"));
				good.setGmen(rs.getFloat("gmen"));
				good.setGsold(rs.getInt("gsold"));
				good.setGscore(rs.getFloat("gscore"));
				good.setGcombo(rs.getString("gcombo"));
				good.setGnotice(rs.getString("gnotice"));
				good.setGphoto(rs.getString("gphoto"));
				int sid=rs.getInt("sid");
				SellerDao sd=new SellerDao();
				good.setSeller(sd.getSellerByid(sid));
				list.add( good);							
			}
			return list;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<Good> GetGoodBySid(int Sid)
	{
		try {
			ArrayList<Good> list=new ArrayList<Good>();
			String sql="select gid,gname,gtuan,gmen,gsold,gscore,gcombo,"
					+ "gnotice,gphoto,sid from good where sid="+Sid;
			ResultSet resultset=DBHelper.executeQuery(sql);
	         while(resultset.next()){
	        	 System.out.println("查询成功");
		         Good result=new Good();
		         result.setGid(resultset.getInt("gid"));
		         result.setGname(resultset.getString("gname"));
		         result.setGtuan(resultset.getFloat("gtuan"));
		         result.setGmen(resultset.getFloat("gmen"));
		         result.setGsold(resultset.getInt("gsold"));
		         result.setGscore(resultset.getFloat("gscore"));
		         result.setGcombo(resultset.getString("gcombo"));
		         result.setGnotice(resultset.getString("gnotice"));
		         result.setGphoto(resultset.getString("gphoto"));
		         int sid=resultset.getInt("sid");
		         SellerDao sd=new SellerDao();
		         Seller seller=sd.getSellerByid(sid);
		         result.setSeller(seller);
		         list.add(result);
	         }
	         return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static ArrayList<Good> SelectGoodLikeName(String name)
	{	
		try{
			ArrayList<Good> list=new ArrayList<Good>();
			String sql="select gid,gname,gtuan,gmen,gsold,gscore,gcombo,"
					+ "gnotice,gphoto,sid from good where gname like'%"+name+"%'";
			ResultSet rs=DBHelper.executeQuery(sql);
			while(rs.next())
			{
				System.out.println("查询成功");
		         Good result=new Good();
		         result.setGid(rs.getInt("gid"));
		         result.setGname(rs.getString("gname"));
		         result.setGtuan(rs.getFloat("gtuan"));
		         result.setGmen(rs.getFloat("gmen"));
		         result.setGsold(rs.getInt("gsold"));
		         result.setGscore(rs.getFloat("gscore"));
		         result.setGcombo(rs.getString("gcombo"));
		         result.setGnotice(rs.getString("gnotice"));
		         result.setGphoto(rs.getString("gphoto"));
		         int sid=rs.getInt("sid");
		         SellerDao sd=new SellerDao();
		         Seller seller=sd.getSellerByid(sid);
		         result.setSeller(seller);
		         list.add(result);
			}
			return list;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public static Good SelectGoodById(int Id)
	{
		try{
			
			String sql="select gid,gname,gtuan,gmen,gsold,gscore,gcombo,"
					+ "gnotice,gphoto,sid from good where gid="+Id;
			ResultSet rs=DBHelper.executeQuery(sql);
			if(rs.next())
			{
				System.out.println("查询成功");
		         Good result=new Good();
		         result.setGid(rs.getInt("gid"));
		         result.setGname(rs.getString("gname"));
		         result.setGtuan(rs.getFloat("gtuan"));
		         result.setGmen(rs.getFloat("gmen"));
		         result.setGsold(rs.getInt("gsold"));
		         result.setGscore(rs.getFloat("gscore"));
		         result.setGcombo(rs.getString("gcombo"));
		         result.setGnotice(rs.getString("gnotice"));
		         result.setGphoto(rs.getString("gphoto"));
		         int sid=rs.getInt("sid");
		         SellerDao sd=new SellerDao();
		         Seller seller=sd.getSellerByid(sid);
		         result.setSeller(seller);
		         return result;
			}
			

		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public static int SelectLastGood()
	{	
		try
		{
		String sql="select gid from good order by gid desc ";
		ResultSet rs=DBHelper.executeQuery(sql);
		rs.next();
		int gid=rs.getInt(1);
		return gid;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	public static int  ModifySold(int gid,int amount)
	{	
		
		String sql="update good set gsold='"+amount+"' where gid="+gid;
		  //int result= DBHelper.executeNonQuery("update good set gsold=? where gid=?",amount,gid);
		int result=DBHelper.executeNonQuery(sql);  
		return result;
	}
	public static int deleteGood(Good good)
	{	
		//String sql="delete good where gid="+good.getGid();
		int result=DBHelper.executeNonQuery("delete from good where gid=?",good.getGid());
		return result;
	}
	public static int updateGood(Good good)
	{
		int result=DBHelper.executeNonQuery("update good set gname=?,gtuan=?,gmen=?,"
				+ "gcombo=?,gnotice=?,gphoto=? where gid=?",good.getGname(),
				good.getGtuan(),good.getGmen(),good.getGcombo(),
				good.getGnotice(),good.getGphoto(),good.getGid());
		return result;
	}
	public static int insertGood(Good good)
	{
		int result=DBHelper.executeNonQuery("insert into good(gid,gname,gtuan,gmen,gsold,"
				+ "gscore,gcombo,gnotice,gphoto,sid) values(?,?,?,?,?,?,?,?,?,?)",
				good.getGid(),good.getGname(),good.getGtuan(),good.getGmen(),
				good.getGsold(),good.getGscore(),good.getGcombo(),good.getGnotice(),
				good.getGphoto(),good.getSeller().getSid());
		return result;
	}
	//获取所有的相应订单，然后求平均 
	public static int SetGoodScore(int gid)
	{
		int result=0;
		try{
			String sql="select gid,oscore from orders where gid="+gid;
			ResultSet rs=DBHelper.executeQuery(sql);
			float sum=0;
			while(rs.next())
			{
				int oscore=rs.getInt("oscore");
				sum+=oscore;
			}
			rs.last();
			int count=rs.getRow();
			sum=sum/count;
			String sql1="update good set gscore='"+sum+"'where gid='"+gid+"'";
			result=DBHelper.executeNonQuery(sql1);
			return result;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
