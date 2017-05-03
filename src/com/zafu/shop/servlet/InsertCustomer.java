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

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.zafu.shop.bean.Customer;
import com.zafu.shop.dao.CustomerDao;
import com.zafu.shop.dao.GoodDao;

/**
 * Servlet implementation class InsertCustomer
 */
@WebServlet("/InsertCustomer")
public class InsertCustomer extends HttpServlet {
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
    public InsertCustomer() {
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
		/*
		 * cid,cphoto,cname,cbirth"
				+ "cadd,cphone,cpass
		 */
		utf8(response,request);
		Customer customer=new Customer();
		int cid=CustomerDao.SelectLastCustomer()+1;
		customer.setCid(cid);
		if(request.getParameter("cphoto")!=null&&request.getParameter("cphoto")!="")
		{
			String cphoto=request.getParameter("cphoto");
			customer.setCphoto(cphoto);
		}
		if(request.getParameter("cname")!=null&&request.getParameter("cname")!="")
		{
			String cname=request.getParameter("cname");
			customer.setCname(cname);
		}
		if(request.getParameter("cadd")!=null&&request.getParameter("cadd")!="")
		{
			String cadd=request.getParameter("cadd");
			customer.setCaddress(cadd);
		}
		if(request.getParameter("cphone")!=null&&request.getParameter("cphone")!="")
		{
			String cphone=request.getParameter("cphone");
			customer.setCphone(cphone);
		}
		if(request.getParameter("cpass")!=null&&request.getParameter("cpass")!="")
		{
			String cpass=request.getParameter("cpass");
			customer.setCpassword(cpass);
		}
		if(request.getParameter("cbirth")!=null&&request.getParameter("cbirth")!="")
		{	
			SimpleDateFormat str=new SimpleDateFormat("yyyy-MM-dd");
			Date cbirth=null;
			try {
				cbirth=str.parse(request.getParameter("cbirth"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			customer.setCbirth(cbirth);
		}
		int rs=CustomerDao.InsertCustomer(customer);
		PrintWriter writer=response.getWriter();
		if(rs==0)
		 {
			 writer.println("插入失败");
		 }
		 else {
			 writer.println("插入成功");
		 }
	}

}
