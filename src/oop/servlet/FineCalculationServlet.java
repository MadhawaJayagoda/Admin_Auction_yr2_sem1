
/**
 * OOP project 2018
 * @author Madhawa Jayagoda
 * Student name: N.M.Jayagoda
 * Student reg.No: IT17184304
 * Topic : Admin - Add / remove Auctions
 * SLIIT
 */

package oop.servlet;
import java.io.IOException;
import oop.model.Auction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
    
import java.util.Date; 
import com.sun.jmx.snmp.Timestamp;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import java.sql.*;
/**
 * Servlet implementation class FineCalculationServlet
 */
@WebServlet("/FineCalculationServlet")
public class FineCalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FineCalculationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double fine;
		
		int no_of_bidders = Integer.parseInt(request.getParameter("no_of_bidders"));
		java.sql.Date addedDate = java.sql.Date.valueOf(request.getParameter("addedDate"));
		
		/** converting Timestamp to Date type */ 
		Date added_date = new Date(addedDate.getTime());
		
		/** Getting current Date */
		Date now = new Date(); 
		
		/** getting the difference of the two dates by converting them to long data type */
		long diff = now.getTime() - added_date.getTime();
		
		/** getting the difference in only Days */
		int dateDiff = (int)(diff / (1000 * 60 * 60 * 24));
		
		if(dateDiff < 30) {
			fine = (float)((no_of_bidders * dateDiff) * ( 5.0 / 100 ));
		}
		else if(dateDiff < 60) {
			fine = (float)((no_of_bidders * dateDiff) * ( 10.0 / 100 ));
		}
		else {
			fine = (float)((no_of_bidders * dateDiff) * ( 15.0 / 100 ));
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FineResults.jsp");
		
		request.setAttribute("fine", fine);
		request.setAttribute("no_of_bidders", no_of_bidders);
		request.setAttribute("dateDiff", dateDiff);
		
		dispatcher.forward( request, response);
	}

}
