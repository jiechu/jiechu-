package com.zafu.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zafu.shop.bean.Customer;
import com.zafu.shop.bean.Tie;
import com.zafu.shop.dao.CustomerDao;
import com.zafu.shop.dao.TieDao;

import sun.org.mozilla.javascript.internal.json.JsonParser;

/**
 * Servlet implementation class InsertTie
 */
@WebServlet("/InsertTie")
public class InsertTie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void utf8(HttpServletResponse response,HttpServletRequest request)
    {
    	response.setContentType("text/html;charset=UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	 if (request != null) {
             try {
                 request.setCharacterEncoding("UTF-8");
             } catch (UnsupportedEncodingException e) {
                 e.printStackTrace();
             }
         }
    } 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertTie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		utf8(response, request);
		Tie t=new Tie();
		int tid=TieDao.SelectLastTie()+1;
		t.setTid(tid);
		if(request.getParameter("ttype")!=null&&request.getParameter("ttype")!="")
		{	
			int  ttype=Integer.parseInt(request.getParameter("ttype"));
			t.setTtype(ttype);
		}
		if(request.getParameter("tcontent")!=null&&request.getParameter("tcontent")!="")
		{	
			String tcontent=request.getParameter("tcontent");
			t.setTcontent(tcontent);
		}
		if(request.getParameter("tname")!=null&&request.getParameter("tname")!="")
		{	
			String tname=request.getParameter("tname");
			t.setTname(tname);
		}
		if(request.getParameter("tpic")!=null&&request.getParameter("tpic")!="")
		{	
			String tpic=request.getParameter("tpic");
			t.setTpic(tpic);
		}
		SimpleDateFormat str=new SimpleDateFormat("yyyy-MM-dd");
		Date ttime=null;
			try {
				ttime=str.parse(str.format(new Date()));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			t.setTtime(ttime);
			Customer c=new Customer();
			int cid=Integer.parseInt(request.getParameter("cid"));
			c=CustomerDao.SelectCustomerByCid(cid);
			t.setCid(c);
			TieDao.InsertTie(t);
			PrintWriter w=response.getWriter();
			w.write(JSON.toJSONString(t));
	}

}
