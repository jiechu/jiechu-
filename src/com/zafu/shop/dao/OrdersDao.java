package com.zafu.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
		
		
		/*
		 * ���Ķ���״̬
		 */
	
		
		/*
		 * ͬʱ����״̬�Լ����֣�������תΪ��ɣ�
		 */
		
	
		
		/*
		 * ͨ��Id�õ���������ϸ���
		 */

		
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
