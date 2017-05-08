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
		
	public static ArrayList<Orders> SelectOrdersBySid(int sid)
	{	
		try{
			ArrayList<Good> g=new ArrayList<Good>();
			ArrayList<Orders> o=new ArrayList<Orders>();
			g=GoodDao.GetGoodBySid(sid);
			int gid;
			for(int i=0;i<g.size();i++)
			{
				 gid=g.get(i).getGid();
			
			String sql=" select oid,ophone,otime,oamount,oprice,ostate,oscore,cid  from orders where gid="+gid;
			ResultSet rs=DBHelper.executeQuery(sql);
			while(rs.next())
			{
				Orders os=new Orders();
				os.setGid(g.get(i));
				os.setOamount(rs.getInt("oamount"));
				os.setOid(rs.getInt("oid"));
				os.setOphone(rs.getString("ophone"));
				os.setOprice(rs.getFloat("oprice"));
				os.setOscore(rs.getInt("oscore"));
				os.setOstate(rs.getInt("ostate"));
				os.setOtime(rs.getDate("otime"));
				Customer c=new Customer();
				c=CustomerDao.SelectCustomerByCid(rs.getInt("cid"));
				os.setCid(c);
				o.add(os);
			}
			}
			return o;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
		/*
		 * 
		 * ͨ���̼�sid�Ͷ���״̬
		 */
	public static ArrayList<Orders> SelectOrdersBySidAndOstate(int sid,int ostate)
	{
		try{
			ArrayList<Good> g=new ArrayList<Good>();
			ArrayList<Orders> o=new ArrayList<Orders>();
			g=GoodDao.GetGoodBySid(sid);
			int gid;
			for(int i=0;i<g.size();i++)
			{
				 gid=g.get(i).getGid();
			ResultSet rs=DBHelper.executeQuery(" select oid,ophone,otime,oamount,oprice,ostate,oscore,cid  from orders where gid=? and ostate=?",gid,ostate);
			while(rs.next())
			{
				Orders os=new Orders();
				os.setGid(g.get(i));
				os.setOamount(rs.getInt("oamount"));
				os.setOid(rs.getInt("oid"));
				os.setOphone(rs.getString("ophone"));
				os.setOprice(rs.getFloat("oprice"));
				os.setOscore(rs.getInt("oscore"));
				os.setOstate(ostate);
				os.setOtime(rs.getDate("otime"));
				Customer c=new Customer();
				c=CustomerDao.SelectCustomerByCid(rs.getInt("cid"));
				os.setCid(c);
				o.add(os);
			}
			}
			return o;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
		
		
		/*
		 * �û�Id��ѯ����
		 */
		public static ArrayList<Orders> SelectOrdersByCid(int cid)
		{
			try{
				ArrayList<Orders> o=new ArrayList<Orders>();
				String sql="select oid,ophone,otime,oamount,oprice,ostate,oscore,cid,gid  from orders where cid="+cid;
				ResultSet rs=DBHelper.executeQuery(sql);
				while(rs.next())
				{
					Orders os=new Orders();
					Good g=new Good();
					g=GoodDao.SelectGoodById(rs.getInt("gid"));
					os.setGid(g);
					os.setOamount(rs.getInt("oamount"));
					os.setOid(rs.getInt("oid"));
					os.setOphone(rs.getString("ophone"));
					os.setOprice(rs.getFloat("oprice"));
					os.setOscore(rs.getInt("oscore"));
					os.setOstate(rs.getInt("ostate"));
					os.setOtime(rs.getDate("otime"));
					Customer c=new Customer();
					c=CustomerDao.SelectCustomerByCid(rs.getInt("cid"));
					os.setCid(c);
					o.add(os);
				}
				return o;
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			return null;
		}
		
		/*
		 * �û�id�Լ�״̬
		 */
		
		
}
