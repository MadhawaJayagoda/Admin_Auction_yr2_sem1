
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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oop.model.Auction;
import oop.service.AuctionServiceImpl;
import oop.service.IAuctionService;

import oop.model.Auction;
import oop.service.AuctionServiceImpl;
import oop.service.IAuctionService;

/**
 * Servlet implementation class GetAuctionServlet
 */
@WebServlet("/GetAuctionServlet")
public class GetAuctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAuctionServlet() {
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
		response.setContentType("text/html");

 		int auctionID = Integer.parseInt(request.getParameter("auctionID"));	
		IAuctionService iAuctionService = new AuctionServiceImpl();
		Auction auction = iAuctionService.getAuctionByID(auctionID);

		request.setAttribute("auction", auction);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GetAuction.jsp");
		dispatcher.forward(request, response);
	}

}
