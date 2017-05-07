package com.zafu.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zafu.shop.bean.Customer;
import com.zafu.shop.bean.Good;
import com.zafu.shop.bean.Orders;
import com.zafu.shop.db.DBHelper;



public class OrdersDao {
	/*
	 * ��ȡ���һ��������oid
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
	 * ���Ӷ���
	 */
	public static int InsertOrder(Orders o)
	{
		int result=DBHelper.executeNonQuery("insert into orders(oid,ophone,otime,oamount,oprice,ostate,oscore,gid,cid) values(?,?,?,?,?,?,?,?,?)",
				o.getOid(),o.getOphone(),o.getOtime(),o.getOamount(),o.getOprice(),o.getOstate(),o.getOscore(),o.getGid(),o.getCid());
		return result;
	}
		
		
		/*
		 * ɾ������
		 */
	public static int DeleteOrder(int oid)
	{
		String sql="delete from orders where oid="+oid;
		int result=DBHelper.executeNonQuery(sql);
		return result;
	}
		
		
		/*
		 * ���Ķ���״̬
		 */
	public static int ModifyOrder(int oid,int ostate)
	{
		int result=DBHelper.executeNonQuery("update orders set ostate=? where oid=?",ostate,oid);
		return result;
	}
		/*
		 * ͬʱ����״̬�Լ����֣�������תΪ��ɣ�
		 */
	public static int ModifyOrderscore(int oid,int ostate,int oscore)
	{
		int result=DBHelper.executeNonQuery("update orders set ostate=?,oscore=? where oid=?",ostate,oscore,oid);
		return result;
	}
		
	
		
		/*
		 * ͨ��Id�õ���������ϸ���
		 */
	public static Orders SelectOrdersByOid(int oid)
	{
		try{
			String sql="select ophone,otime,oamount,oprice,ostate,oscore,gid,cid  from orders where oid="+oid;
			ResultSet rs=DBHelper.executeQuery(sql);
			if(rs.next())
			{
				Orders o=new Orders();
				o.setOid(oid);
				o.setOamount(rs.getInt("oamount"));
				o.setOphone(rs.getString("ophone"));
				o.setOprice(rs.getInt("oprice"));
				o.setOscore(rs.getInt("oscore"));
				o.setOstate(rs.getInt("ostate"));
				o.setOtime(rs.getDate("otime"));
				Customer c=new Customer();
				c=CustomerDao.SelectCustomerByCid(rs.getInt("cid"));
				o.setCid(c);
				Good g=new Good();
				g=GoodDao.SelectGoodById(rs.getInt("gid"));
				o.setGid(g);
				return o;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
		
		
		//�����̼�sid��ѯ����
		
		/*
		 * ͨ���̼�sid�Ͷ���״̬
		 */
		
		
		/*
		 * �û�Id��ѯ����
		 */
		
		
		/*
		 * �û�id�Լ�״̬
		 */
		
		
}
