package com.zafu.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zafu.shop.dao.OrdersDao;

/**
 * Servlet implementation class ModifyOrderscore
 */
@WebServlet("/ModifyOrderscore")
public class ModifyOrderscore extends HttpServlet {
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
    public ModifyOrderscore() {
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
		int oid=Integer.parseInt(request.getParameter("oid"));
		int ostate=Integer.parseInt(request.getParameter("ostate"));
		int oscore=Integer.parseInt(request.getParameter("oscore"));
		int result=OrdersDao.ModifyOrderscore(oid, ostate, oscore);
		PrintWriter w=response.getWriter();
		if(result==0)
		{
			w.println("更新失败");
		}
		else
		{
			w.print("更新成功");
		}
	}

}
