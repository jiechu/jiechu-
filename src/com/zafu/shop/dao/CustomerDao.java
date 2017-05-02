package com.zafu.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zafu.shop.db.DBHelper;
import com.zafu.shop.bean.Customer;

public class CustomerDao {
	/*
	 * 增加用户
	 */
	public static int InsertCustomer(Customer customer)
	{
		int result =DBHelper.executeNonQuery("insert into customer(cid,cphoto,cname,cbirth,"
				+ "cadd,cphone,cpass) values(?,?,?,?,?,?,?)", customer.getCid(),
				customer.getCphoto(),customer.getCname(),customer.getCbirth(),
				customer.getCaddress(),customer.getCphone(),customer.getCpassword());
		return result;
	}
	/*
	 * 查询最新的一条用户记录
	 */
	public static int SelectLastCustomer()
	{	
		try
		{
		String sql="select cid from customer order by cid desc ";
		ResultSet rs=DBHelper.executeQuery(sql);
		rs.next();
		int cid=rs.getInt(1);
		return cid;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
		/*
		 * 删除用户位置先留着
		 */
		
		/*
		 * 用户信息修改
		 */
	
		
		
		/*
		 * 用户登录
		 */
	
		
		/*
		 * 通过id查询用户
		 */
		
}
