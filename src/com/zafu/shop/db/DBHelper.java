package com.zafu.shop.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DBHelper {
	public static String driver = null;
	public static String url = null;
	public static String user = null;
	public static String password = null;
	static {
		Properties pro = new Properties();
		try {
			pro.load(DBHelper.class.getClassLoader().getResourceAsStream(
					"jdbc.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		url = pro.getProperty("jdbc.url");
		user = pro.getProperty("jdbc.username");
		password = pro.getProperty("jdbc.password");
		driver = pro.getProperty("jdbc.driver");
	}

	// �˷���Ϊ��ȡ���ݿ�����
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);// �������ݿ�����
			if (null == conn) {
				conn = DriverManager.getConnection(url,
						user, password);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry,can't find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * ��ɾ�ġ�Add��Del��Update��
	 *
	 * @param sql
	 * @return int
	 */
	public static int executeNonQuery(String sql)
	{
		int result=0;
		Connection conn=null;
		Statement stmt=null;
		try{
			conn=getConnection();
			stmt=conn.createStatement();
			result=stmt.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			free(null,stmt,conn);
		}
		
		return result;
	}
	/**
	 * ��ɾ�ġ�Add��Delete��Update��
	 *
	 * @param sql
	 * @param obj
	 * @return int
	 */
	public static int executeNonQuery(String sql,Object... obj)
	{
		int result=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<obj.length;i++)
			{
				pstmt.setObject(i+1, obj[i]);
			}
			result=pstmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
			free(null,pstmt,conn);
		}
		
		return result;
	}
	/**
	 * �顾Query��
	 *
	 * @param sql
	 * @return ResultSet
	 */
	public static ResultSet executeQuery(String sql)
	{
		ResultSet rs=null;
		Connection conn=null;
		Statement stmt=null;
		try{			
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery(sql);
			/**ResultSet.TYPE_SCROLL_INSENSITIVE 
			��������α���������ƶ��������ݿ�仯ʱ����ǰ��������䡣
			ResultSet.CONCUR_READ_ONLY �����ý�����������ݿ��еı�
			**/
		}catch(SQLException e)
		{
			e.printStackTrace();
			free(rs,stmt,conn);
		}
		
		return rs;
	}
	/**
	 * �顾Query��
	 *
	 * @param sql
	 * @param obj
	 * @return ResultSet
	 */
	public static ResultSet executeQuery(String sql,Object... obj)
	{
		ResultSet rs=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE
					,ResultSet.CONCUR_READ_ONLY);
			for(int i=0;i<obj.length;i++)
				pstmt.setObject(i+1, obj[i]);
			rs=pstmt.executeQuery();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
			free(rs,pstmt,conn);
		}
		
		return rs;
	}
	/**
	 * �жϼ�¼�Ƿ����
	 *
	 * @param sql
	 * @return Boolean
	 */
	public static Boolean isExist(String sql)
	{
		ResultSet rs=null;
		
		try {
			rs=executeQuery(sql);
			rs.last();
			int count=rs.getRow();
			if(count>0)
			{
				return true;
			}
			else return false;
		}catch(SQLException e)
		{
			e.printStackTrace();
			free(rs);
			return false;
		}
		
	}
	/**
	 * �жϼ�¼�Ƿ����
	 *
	 * @param sql ,obj...
	 *
	 * @return Boolean
	 */
public static Boolean isExist(String sql,Object... obj)
{
	ResultSet rs=null;
	try 
	{
		rs=executeQuery(sql, obj);
		rs.last();
		int count=rs.getRow();
		if(count>0)
		{
			return true;
		}
		else return false;	
	}catch(SQLException e)
	{
		e.printStackTrace();
		free(rs);
		return false;
	}
	
}	
/**
 * ��ȡ��ѯ��¼��������
 *
 * @param sql
 * @return int
 */
public static int getCount(String sql)
{	
	int count=0;
	ResultSet rs=null;
	try{
		rs=executeQuery(sql);
		rs.last();
		count=rs.getRow();
	}catch(SQLException e)
	{
		e.printStackTrace();
		free(rs);	
	}
	
	return count;
}
/**
 * ��ȡ��ѯ��¼��������
 *
 * @param sql
 * @param obj
 * @return int
 */
public static int getCount(String sql, Object... obj) {
	int result = 0;
	ResultSet rs = null;
	try {
		rs = executeQuery(sql, obj);
		rs.last();
		result = rs.getRow();
	} catch (SQLException err) {
		err.printStackTrace();
		free(rs);
	} 
	return result;
}
	/**
	 * �ͷš�ResultSet����Դ
	 *
	 * @param rs
	 */
	public static void free(ResultSet rs)
	{
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}
	/**
	 * �ͷš�Connection����Դ
	 *
	 * @param conn
	 */
	public static void free(Connection conn)
	{
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
		/**
	 * �ͷš�Statement����Դ
	 *
	 * @param st
	 */
	public static void free(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}
	/**
	 * �ͷ�����������Դ
	 *
	 * @param rs
	 * @param st
	 * @param conn
	 * @param pst
	 */
	public static void free(ResultSet rs, Statement st, Connection conn) {
		free(rs);
		free(st);
		free(conn);
	
	}

}
