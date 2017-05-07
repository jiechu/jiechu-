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
import com.zafu.shop.bean.Good;
import com.zafu.shop.bean.Orders;
import com.zafu.shop.bean.Seller;
import com.zafu.shop.dao.CustomerDao;
import com.zafu.shop.dao.GoodDao;
import com.zafu.shop.dao.OrdersDao;
import com.zafu.shop.dao.SellerDao;

/**
 * Servlet implementation class InsertOrder
 */
@WebServlet("/InsertOrder")
public class InsertOrder extends HttpServlet {
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
    public InsertOrder() {
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
		Orders o=new Orders();
		int oid=OrdersDao.SelectLastOrder()+1;
		o.setOid(oid);
		o.setOstate(0);
		int oamount=0;
		if(request.getParameter("oamount")!=null&&request.getParameter("oamount")!="")
		{
			 oamount=Integer.parseInt(request.getParameter("oamount"));
			o.setOamount(oamount);
		}
		SimpleDateFormat str=new SimpleDateFormat("yyyy-MM-dd");
		Date otime=null;
			try {
				otime=str.parse(str.format(new Date()));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			o.setOtime(otime);
		Good g=new Good();
		Customer c=new Customer();
		int gid=Integer.parseInt(request.getParameter("gid"));
		g=GoodDao.SelectGoodById(gid); //获取商品信息
		int cid=Integer.parseInt(request.getParameter("cid"));
		c=CustomerDao.SelectCustomerByCid(cid); //获取顾客信息
		o.setCid(c);
		o.setGid(g);
		int oprice= (int) g.getGmen() *oamount;
		o.setOprice(oprice);
		o.setOphone(c.getCphone());
		int result=OrdersDao.InsertOrder(o);
		PrintWriter w=response.getWriter();
		if(result==0)
		{
			w.println("插入失败");
		}
		else
		{
			w.println("插入成功");
		}
	}

}
