package com.zafu.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zafu.shop.bean.Orders;
import com.zafu.shop.db.DBHelper;



public class OrdersDao {
	/*
	 * 获取最后一条订单的oid
	 */
	public static int SelectLastOrder()
	{
		try
		{
		String sql="select oid from orders order by oid desc ";
		ResultSet rs=DBHelper.executeQuery(sql);
		rs.next();
		int oid=rs.getInt(1);
		return oid;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	/*
	 * 增加订单
	 */
	public static int InsertOrder(Orders o)
	{
		int result=DBHelper.executeNonQuery("insert into orders(oid,ophone,otime,oamount,oprice,ostate,oscore,gid,cid) values(?,?,?,?,?,?,?,?,?)",
				o.getOid(),o.getOphone(),o.getOtime(),o.getOamount(),o.getOprice(),o.getOstate(),o.getOscore(),o.getGid(),o.getCid());
		return result;
	}
		
		
		/*
		 * 删除订单
		 */
	public static int DeleteOrder(int oid)
	{
		String sql="delete from orders where oid="+oid;
		int result=DBHelper.executeNonQuery(sql);
		return result;
	}
		
		
		/*
		 * 更改订单状态
		 */
	public static int ModifyOrder(int oid,int ostate)
	{
		int result=DBHelper.executeNonQuery("update orders set ostate=? where oid=?",ostate,oid);
		return result;
	}
		/*
		 * 同时更改状态以及评分（待评价转为完成）
		 */
		
	
		
		/*
		 * 通过Id得到订单的详细情况
		 */

		
		//根据商家sid查询订单
		
		/*
		 * 通过商家sid和订单状态
		 */
		
		
		/*
		 * 用户Id查询订单
		 */
		
		
		/*
		 * 用户id以及状态
		 */
		
		
}
