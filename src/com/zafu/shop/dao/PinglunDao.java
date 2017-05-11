package com.zafu.shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.text.DefaultEditorKit.CutAction;

import com.zafu.shop.bean.Customer;
import com.zafu.shop.bean.Pinglun;
import com.zafu.shop.bean.Tie;
import com.zafu.shop.db.DBHelper;

import sun.print.resources.serviceui;

public class PinglunDao {
	public static void InsertPinglun(Pinglun pl)
	{
		DBHelper.executeNonQuery("insert into pinglun(pid,content,cid,tid) values(?,?,?,?)",
				pl.getPid(),pl.getContent(),pl.getCid(),pl.getTid());
	}
	/*
	 * 根据cid查询评论
	 */
	public static ArrayList<Pinglun> SelectPinglunBycid(int cid)
	{	
		try{
			String sql="select pid,content,cid,tid from pinglun where cid="+cid;
			ArrayList<Pinglun> list=new ArrayList<Pinglun>();
			ResultSet rs=DBHelper.executeQuery(sql);
			while(rs.next())
			{
				Pinglun p=new Pinglun();
				p.setContent(rs.getString("content"));
				p.setPid(rs.getInt("pid"));
				Customer c=new Customer();
				c=CustomerDao.SelectCustomerByCid(cid);
				p.setCid(c);
				Tie t=new Tie();
				t=TieDao.SelectTieByCid(cid);
				p.setTid(t);
				list.add(p);
			}
			return list;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	 * 根据tid查询评论
	 */
	public static ArrayList<Pinglun> SelectPinglunBytid(int tid)
	{	try{
		String sql="select pid,content,cid,tid from pinglun where tid="+tid;
		ArrayList<Pinglun> list=new ArrayList<Pinglun>();
		ResultSet rs=DBHelper.executeQuery(sql);
		while(rs.next())
		{
			Pinglun p=new Pinglun();
			p.setContent(rs.getString("content"));
			p.setPid(rs.getInt("pid"));
			Customer c=new Customer();
			int cid=rs.getInt("cid");
			c=CustomerDao.SelectCustomerByCid(cid);
			p.setCid(c);
			Tie t=new Tie();
			t=TieDao.SelectTieByTid(tid);
			p.setTid(t);
			list.add(p);
		}
		return list;
	}catch(SQLException e)
	{
		e.printStackTrace();
	}
		return null;
	}
	
}
