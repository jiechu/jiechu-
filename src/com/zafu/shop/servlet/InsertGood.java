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
import com.zafu.shop.bean.Good;
import com.zafu.shop.dao.GoodDao;
import com.zafu.shop.dao.SellerDao;
import com.zafu.shop.db.DBHelper;

/**
 * Servlet implementation class InsertGood
 */
@WebServlet("/InsertGood")
public class InsertGood extends HttpServlet {
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
    public InsertGood() {
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
//		gid,gname,gtuan,gmen,gsold,"
//				+ "gscore,gcombo,gnotice,gphoto,sid
		utf8(response,request);
		Good good=new Good();
		int sid=Integer.parseInt(request.getParameter("sid"));
		int gid=GoodDao.SelectLastGood()+1;
		good.setGid(gid);
		good.setSeller(SellerDao.getSellerByid(sid));
		if(request.getParameter("gtuan")!=null&&request.getParameter("gtuan")!="")
		{	
			int gtuan=Integer.parseInt(request.getParameter("gtuan"));
			good.setGtuan(gtuan);
		}
		if(request.getParameter("gsold")!=null&&request.getParameter("gsold")!="")
		{	
			int gsold=Integer.parseInt(request.getParameter("gsold"));
			good.setGsold(gsold);
		}
		if(request.getParameter("gmen")!=null&&request.getParameter("gmen")!="")
		{	
			int gmen=Integer.parseInt(request.getParameter("gmen"));
			good.setGmen(gmen);
		}
		
		if(request.getParameter("gname") != null&&request.getParameter("gname")!="")
		{	
			String gname=request.getParameter("gname");
			good.setGname(gname);
		}
		
		if(request.getParameter("gcombo") != null&&request.getParameter("gcombo")!="")
		{	
			String gcombo=request.getParameter("gcombo");
			good.setGcombo(gcombo);
		}
		
		if(request.getParameter("gnotice") != null&&request.getParameter("gnotice")!="")
		{	
			String gnotice=request.getParameter("gnotice");
			good.setGnotice(gnotice);
		}
		
		if(request.getParameter("gphoto") != null&&request.getParameter("gphoto")!="")
		{	
			String gphoto=request.getParameter("gphoto");
			good.setGphoto(gphoto);
		}
		good.setGscore(0);
		GoodDao.insertGood(good);
		PrintWriter writer=response.getWriter();		
		writer.write(JSON.toJSONString(good));
	}

}
