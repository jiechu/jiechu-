package com.zafu.shop.servlet;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zafu.shop.bean.Good;
import com.zafu.shop.dao.GoodDao;

/**
 * Servlet implementation class SelectGoodById
 */
@WebServlet("/SelectGoodById")
public class SelectGoodById extends HttpServlet {
	private static final long serialVersionUID = 1L;
      public void utf8(HttpServletRequest request,HttpServletResponse response)
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
      public void flush(Flushable flushable)
      {
      	if(flushable!=null)
      	{
  	    	try {
  				flushable.flush();
  			} catch (IOException e) {
  				e.printStackTrace();
  			}
      	}
      }
      
      public void close(Closeable closeable) {
          if (closeable != null) {
              try {
                  closeable.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      } 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectGoodById() {
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
		utf8(request,response);
		int id=Integer.parseInt(request.getParameter("gid"));
		Good gd=GoodDao.SelectGoodById(id);
		PrintWriter writer=response.getWriter();
		writer.write(JSON.toJSONString(gd));
		flush(writer);
		close(writer);
	}

}
