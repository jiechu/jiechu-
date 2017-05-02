package com.zafu.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zafu.shop.bean.Seller;
import com.zafu.shop.db.DBHelper;

public class SellerDao {
	/*
	 * 通过id查询商家信息
	 */
	public  static Seller getSellerByid(int sid)
	{	
		try{
			System.out.println("商家信息查询:");
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
}
