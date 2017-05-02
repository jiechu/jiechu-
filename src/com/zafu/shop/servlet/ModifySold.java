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

import com.alibaba.fastjson.JSONArray;
import com.zafu.shop.bean.Good;
import com.zafu.shop.dao.GoodDao;
import com.zafu.shop.db.DBHelper;

/**
 * Servlet implementation class ModifySold
 */
@WebServlet("/ModifySold")
public class ModifySold extends HttpServlet {
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
    public ModifySold() {
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
		utf8(response,request);
		int gid=Integer.parseInt(request.getParameter("gid"));
		int amount=Integer.parseInt(request.getParameter("gsold"));
		int result=GoodDao.ModifySold(gid, amount);
		PrintWriter writer=response.getWriter();
		if(result!=0)
		{
			Good good=GoodDao.SelectGoodById(gid);
			
			writer.print("修改商品数量成功");
			writer.write(JSONArray.toJSONString(good));
			flush(writer);
			close(writer);
		}
		else {
			writer.println("不存在该商品");	
		}
	
	}

}
