package com.zafu.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zafu.shop.db.DBHelper;
import com.zafu.shop.bean.Customer;

public class CustomerDao {
	/*
	 * �����û�
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
	 * ��ѯ���µ�һ���û���¼
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
		 * ɾ���û�λ��������
		 */
		
		/*
		 * �û���Ϣ�޸�
		 */
	
		
		
		/*
		 * �û���¼
		 */
	
		
		/*
		 * ͨ��id��ѯ�û�
		 */
		
}
