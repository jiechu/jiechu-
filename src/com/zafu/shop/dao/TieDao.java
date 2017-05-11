package com.zafu.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zafu.shop.bean.Customer;
import com.zafu.shop.bean.Tie;
import com.zafu.shop.db.DBHelper;



public class TieDao {
	/*
	 * 增加帖子
	 */
	public static void InsertTie(Tie tie)
	{
		
		DBHelper.executeNonQuery("insert into tie(tid,ttype,ttime,tcontent,tpic,tname,cid) values(?,?,?,?,?,?,?)",
				tie.getTid(),tie.getTtype(),tie.getTtime(),tie.getTcontent(),tie.getTpic(),tie.getTname(),tie.getCid());
		
	}
	public static int SelectLastTie()
	{
		try
		{
		String sql="select tid from tie order by tid desc ";
		ResultSet rs=DBHelper.executeQuery(sql);
		rs.next();
		int tid=rs.getInt(1);
		return tid;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
		
	}
		 /*
		  * 通过id得到帖子
		  */
	public static ArrayList<Tie> SelectTieBytid(int tid)
	{	
		try{
			String sql="select tid,ttype,ttime,tcontent,tpic,tname,cid from tie where tid="+tid;
			ResultSet rs=DBHelper.executeQuery(sql);
			ArrayList<Tie> list=new ArrayList<Tie>();
			while(rs.next())
			{
				Tie t=new Tie();
				Customer c=new Customer();
				c=CustomerDao.SelectCustomerByCid(rs.getInt("cid"));
				t.setCid(c);
				t.setTid(rs.getInt("tid"));
				t.setTcontent(rs.getString("tcontent"));
				t.setTname(rs.getString("tname"));
				t.setTpic(rs.getString("tpic"));
				t.setTtime(rs.getDate("ttime"));
				t.setTtype(rs.getInt("ttype"));
				list.add(t);
			}
			return list;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
		 
		 /*
		  * 查询所有帖子
		  */
	public static ArrayList<Tie> GetAllTie()
	{	
		try{
			String sql="select tid,ttype,ttime,tcontent,tpic,tname,cid from tie";
			ResultSet rs=DBHelper.executeQuery(sql);
			ArrayList<Tie> list=new ArrayList<Tie>();
			while(rs.next())
			{
				Tie t=new Tie();
				Customer c=new Customer();
				c=CustomerDao.SelectCustomerByCid(rs.getInt("cid"));
				t.setCid(c);
				t.setTid(rs.getInt("tid"));
				t.setTcontent(rs.getString("tcontent"));
				t.setTname(rs.getString("tname"));
				t.setTpic(rs.getString("tpic"));
				t.setTtime(rs.getDate("ttime"));
				t.setTtype(rs.getInt("ttype"));
				list.add(t);
			}
			return list;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
		 /*
		  * 根据类型查询
		  */
	public static ArrayList<Tie> SelectTieByType(int ttype) 
	{	
		try{
			String sql="select tid,ttype,ttime,tcontent,tpic,tname,cid from tie where ttype="+ttype;
			ResultSet rs=DBHelper.executeQuery(sql);
			ArrayList<Tie> list=new ArrayList<Tie>();
			while(rs.next())
			{
				Tie t=new Tie();
				Customer c=new Customer();
				c=CustomerDao.SelectCustomerByCid(rs.getInt("cid"));
				t.setCid(c);
				t.setTid(rs.getInt("tid"));
				t.setTcontent(rs.getString("tcontent"));
				t.setTname(rs.getString("tname"));
				t.setTpic(rs.getString("tpic"));
				t.setTtime(rs.getDate("ttime"));
				t.setTtype(rs.getInt("ttype"));
				list.add(t);
			}
			return list;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
		 /*
		  * 根据cid查询
		  */
	public static ArrayList<Tie> SelectTieBycid(int cid)
	{	
		try{
			String sql="select tid,ttype,ttime,tcontent,tpic,tname,cid from tie where cid="+cid;
			ResultSet rs=DBHelper.executeQuery(sql);
			ArrayList<Tie> list=new ArrayList<Tie>();
			while(rs.next())
			{
				Tie t=new Tie();
				Customer c=new Customer();
				c=CustomerDao.SelectCustomerByCid(rs.getInt("cid"));
				t.setCid(c);
				t.setTid(rs.getInt("tid"));
				t.setTcontent(rs.getString("tcontent"));
				t.setTname(rs.getString("tname"));
				t.setTpic(rs.getString("tpic"));
				t.setTtime(rs.getDate("ttime"));
				t.setTtype(rs.getInt("ttype"));
				list.add(t);
			}
			return list;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}	
	public static Tie SelectTieByCid(int cid)
	{	
		try{
			String sql="select tid,ttype,ttime,tcontent,tpic,tname,cid from tie where cid="+cid;
			ResultSet rs=DBHelper.executeQuery(sql);
			Tie t=new Tie();
			if(rs.next())
			{
				
				Customer c=new Customer();
				c=CustomerDao.SelectCustomerByCid(rs.getInt("cid"));
				t.setCid(c);
				t.setTid(rs.getInt("tid"));
				t.setTcontent(rs.getString("tcontent"));
				t.setTname(rs.getString("tname"));
				t.setTpic(rs.getString("tpic"));
				t.setTtime(rs.getDate("ttime"));
				t.setTtype(rs.getInt("ttype"));
				
			}
			return t;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}	
	public static Tie SelectTieByTid(int tid)
	{	
		try{
			String sql="select tid,ttype,ttime,tcontent,tpic,tname,cid from tie where tid="+tid;
			ResultSet rs=DBHelper.executeQuery(sql);
			Tie t=new Tie();
			if(rs.next())
			{
				
				Customer c=new Customer();
				c=CustomerDao.SelectCustomerByCid(rs.getInt("cid"));
				t.setCid(c);
				t.setTid(rs.getInt("tid"));
				t.setTcontent(rs.getString("tcontent"));
				t.setTname(rs.getString("tname"));
				t.setTpic(rs.getString("tpic"));
				t.setTtime(rs.getDate("ttime"));
				t.setTtype(rs.getInt("ttype"));
				
			}
			return t;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
		
}
