/**
 * OOP project 2018
 * @author Madhawa Jayagoda
 * Student name: N.M.Jayagoda
 * Student reg.No: IT17184304
 * Topic : Admin - Add / remove Auctions
 * SLIIT
 */

package oop.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Auction {

	private int auctionID;
	
	private int sellerID;

	private String product_name;

	private String category;

	private int no_of_bidders;
	
	private Date addedDate;
	
	private double fine;
	
	
	
	/**
	 * @return the auctionID
	 */
	public int getAuctionID() {
		return auctionID;
	}

	/**
	 * @param auctionID the auctionID to set
	 */
	public void setAuctionID(int auctionID) {
		this.auctionID = auctionID;
	}
	
	/**
	 * @return the sellerID of the seller in the Auction
	 */
	public int getSellerID() {
		return sellerID;
	}
	
	/**
	 * @param sellerID the sellerID to set
	 */
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}

	/**
	 * @return the Product name in the Auction
	 */
	public String getProductName() {
		return product_name;
	}

	/**
	 * @param Product name the Product name to set
	 */
	public void setProductName(String product_name) {
		this.product_name = product_name;
	}

	/**
	 * @return the category of a Auction
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the number of bidders on a particular Auction
	 */
	public int get_no_of_bidders() {
		return no_of_bidders;
	}

	/**
	 * @param Number of Bidders the no_of_bidders to set
	 */
	public void set_no_of_bidders(int no_of_bidders) {
		this.no_of_bidders = no_of_bidders;
	}

	/**
	 * @return the added date of the Auction
	 */
	public Date getAddedDate() {
		return addedDate;
	}

	/**
	 * @param Auction added date the addedDate to set
	 */
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	
	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}


	
	@Override
	public String toString() {
		
		return "Auction ID = " + auctionID + "\n" + "sellerID = " + sellerID + "\n" + "Product = " + product_name + "\n"
				+ "Category = " + category + "\n" + "Number of Bidders = " + no_of_bidders + "\n" + "Auction added date = "
				+ addedDate + "\n" + "Auction Fine (if any) : " + fine;
	}
}