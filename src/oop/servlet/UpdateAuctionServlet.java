
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
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oop.model.Auction;
import oop.service.AuctionServiceImpl;
import oop.service.IAuctionService;

/**
 * Servlet implementation class UpdateAuctionServlet
 */
@WebServlet("/UpdateAuctionServlet")
public class UpdateAuctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAuctionServlet() {
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

		Auction auction = new Auction();
		int auctionID = Integer.parseInt(request.getParameter("auctionID"));	
		auction.setAuctionID(auctionID);
		auction.setSellerID(Integer.parseInt(request.getParameter("sellerID")));
		auction.setProductName(request.getParameter("product_name"));
		auction.setCategory(request.getParameter("category"));
		auction.set_no_of_bidders(Integer.parseInt(request.getParameter("no_of_bidders")));
		auction.setAddedDate(Date.valueOf(request.getParameter("addedDate")));
		
		IAuctionService iAuctionService = new AuctionServiceImpl();
		iAuctionService.updateAuction(auctionID, auction);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListAuction.jsp");
		dispatcher.forward(request, response);
	}

}
