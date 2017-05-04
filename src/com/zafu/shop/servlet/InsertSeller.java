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
import com.zafu.shop.bean.Seller;
import com.zafu.shop.dao.SellerDao;

/**
 * Servlet implementation class InsertSeller
 */
@WebServlet("/InsertSeller")
public class InsertSeller extends HttpServlet {
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
    public InsertSeller() {
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
		Seller rs=new Seller();
		int sid=SellerDao.SelectLastSeller()+1;
		rs.setSid(sid);
		if(request.getParameter("sphone")!=null&&request.getParameter("sphone")!="")
		{	
			String sphone=request.getParameter("sphone");
			rs.setSphone(sphone);
		}
		if(request.getParameter("sadd")!=null&&request.getParameter("sadd")!="")
		{	
			String saddress=request.getParameter("sadd");
			rs.setSaddress(saddress);
		}
		if(request.getParameter("spass")!=null&&request.getParameter("spass")!="")
		{	
			String spass=request.getParameter("spass");
			rs.setSpassword(spass);
		}
		if(request.getParameter("sphoto")!=null&&request.getParameter("sphoto")!="")
		{	
			String sphoto=request.getParameter("sphoto");
			rs.setSphoto(sphoto);
		}
		if(request.getParameter("sdesc")!=null&&request.getParameter("sdesc")!="")
		{	
			String sdesc=request.getParameter("sdesc");
			rs.setSdesc(sdesc);
		}
		if(request.getParameter("sscore")!=null&&request.getParameter("sscore")!="")
		{	
			float sscore= Float.parseFloat(request.getParameter("sscore"))  ;
			rs.setSscore(sscore);
		}
		if(request.getParameter("sname")!=null&&request.getParameter("sname")!="")
		{	
			String sname=request.getParameter("sname");
			rs.setSname(sname);
		}
		int result=SellerDao.InsertSeller(rs);
		PrintWriter writer=response.getWriter();
		if(result==0)
		{
			writer.println("false");
		}
		else 
		{
			writer.println("sucess");
			writer.write(JSON.toJSONString(rs));
		}
		
	}

}
