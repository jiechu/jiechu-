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
import com.zafu.shop.dao.CustomerDao;

/**
 * Servlet implementation class UpdateCustomer
 */
@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {
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
    public UpdateCustomer() {
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
//		update cphoto,cname,cbirth,cadd,cphone,cpass from customer where cid
		utf8(response,request);
		Customer rs=new Customer();
		int cid=Integer.parseInt(request.getParameter("cid"));
		rs=CustomerDao.SelectCustomerByCid(cid);
		if(request.getParameter("cphoto")!=null&&request.getParameter("cphoto")!="")
		{	
			String cphoto=request.getParameter("cphoto");
			rs.setCphoto(cphoto);
		}
		if(request.getParameter("cname")!=null&&request.getParameter("cname")!="")
		{	
			String cname=request.getParameter("cname");
			rs.setCname(cname);
		}
		if(request.getParameter("cbirth")!=null&&request.getParameter("cbirth")!="")
		{	
			SimpleDateFormat str=new SimpleDateFormat("yyyy-MM-dd");
			Date cbirth=rs.getCbirth();
			try {
				cbirth=str.parse(request.getParameter("cbirth"));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs.setCbirth(cbirth);
		}
		if(request.getParameter("cadd")!=null&&request.getParameter("cadd")!="")
		{
			String cadd=request.getParameter("cadd");
			rs.setCaddress(cadd);
		}
		if(request.getParameter("cphone")!=null&&request.getParameter("cphone")!="")
		{
			String cphone=request.getParameter("cphone");
			rs.setCphone(cphone);
		}
		if(request.getParameter("cpass")!=null&&request.getParameter("cpass")!="")
		{
			String cpass=request.getParameter("cpass");
			rs.setCpassword(cpass);
		}
		int result=CustomerDao.UpdateCustomer(rs);
		PrintWriter writer=response.getWriter();
		if(result==0)
		 {
			 writer.write(JSON.toJSONString(rs));
			 writer.println("修改失败");
		 }
		 else {
			 writer.println("修改成功");
		 }
	}

}
