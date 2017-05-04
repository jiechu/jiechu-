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
		int result =DBHelper.executeNonQuery("insert into customer(cid,cphoto,cname,cbirth,cadd,cphone,cpass) values(?,?,?,?,?,?,?)", customer.getCid(),
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
	public static int UpdateCustomer(Customer customer)
	{
		int result=DBHelper.executeNonQuery("update customer set cphoto=?,cname=?,cbirth=?"
				+ ",cadd=?,cphone=?,cpass=? where cid =?", 
				customer.getCphoto(),customer.getCname(),customer.getCbirth(),
				customer.getCaddress(),customer.getCphone(),customer.getCpassword(),
				customer.getCid());
		return result;
	}
		
		/*
		 * �û���¼
		 * 
		 */
	public static Boolean CustomerLogin(String name,String password)
	{	
		try{
		String sql="select cname,cpass from customer where cname='"+name+"' and cpass='"+password+"'";
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
		 * ͨ��id��ѯ�û�
		 */
	public static Customer SelectCustomerByCid(int cid)
	{	
		try{
		String sql="select cphoto,cname,cbirth,cadd,cphone,cpass from customer where cid="+cid;
		ResultSet rs=DBHelper.executeQuery(sql);
		if(rs.next())
		{
			Customer result=new Customer();
			result.setCid(cid);
			result.setCname(rs.getString("cname"));
			result.setCaddress(rs.getString("cadd"));
			result.setCpassword(rs.getString("cpass"));
			result.setCphone(rs.getString("cphone"));
			result.setCphoto(rs.getString("cphoto"));		
			result.setCbirth(rs.getDate("cbirth"));
			return result;
		}
			
		}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
		}
		return null;
	}
		
}
