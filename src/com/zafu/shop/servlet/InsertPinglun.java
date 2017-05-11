package com.zafu.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zafu.shop.bean.Customer;
import com.zafu.shop.bean.Pinglun;
import com.zafu.shop.bean.Tie;
import com.zafu.shop.dao.CustomerDao;
import com.zafu.shop.dao.PinglunDao;
import com.zafu.shop.dao.TieDao;
import com.zafu.shop.db.DBHelper;

/**
 * Servlet implementation class InsertPinglun
 */
@WebServlet("/InsertPinglun")
public class InsertPinglun extends HttpServlet {
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
    public InsertPinglun() {
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
		Pinglun p=new Pinglun();
		if(request.getParameter("cid")!=null&&request.getParameter("cid")!="")
		{
			int cid=Integer.parseInt(request.getParameter("cid"));
			Customer c=new Customer();
			c=CustomerDao.SelectCustomerByCid(cid);
			p.setCid(c);
		}
		if(request.getParameter("pid")!=null&&request.getParameter("pid")!="")
		{
			int pid=Integer.parseInt(request.getParameter("pid"));
			p.setPid(pid);
		}
		if(request.getParameter("tid")!=null&&request.getParameter("tid")!="")
		{
			int tid=Integer.parseInt(request.getParameter("tid"));
			Tie t=new Tie();
			t=TieDao.SelectTieByTid(tid);
			p.setTid(t);
		}
		if(request.getParameter("content")!=null&&request.getParameter("content")!="")
		{
			String content=request.getParameter("content");
			p.setContent(content);
		}
		PinglunDao.InsertPinglun(p);
		PrintWriter w=response.getWriter();
		w.write(JSON.toJSONString(p));
		
	}

}
