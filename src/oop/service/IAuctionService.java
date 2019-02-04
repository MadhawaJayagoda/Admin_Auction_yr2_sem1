
/**
 * OOP project 2018
 * @author Madhawa Jayagoda
 * Student name: N.M.Jayagoda
 * Student reg.No: IT17184304
 * Topic : Admin - Add / remove Auctions
 * SLIIT
 */

package oop.service;
import java.util.ArrayList;
import java.util.logging.Logger;
import oop.model.Auction;

public interface IAuctionService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IAuctionService.class.getName());

	/**
	 * Add Auction for auction table
	 * @param auction
	 */
	public void addAuction(Auction auction);

	/**
	 * Get a particular Auction details
	 * 
	 * @param auctionID
	 * @return auction
	 */
	public Auction getAuctionByID(int auctionID);
	
	/**
	 * Get all list of Auction
	 * 
	 * @return ArrayList<Auction>
	 */
	public ArrayList<Auction> getAuctions();
	
	/**
	 * Update existing auction
	 * @param auctionID
	 * @param auction
	 * 
	 * @return
	 */
	public Auction updateAuction(int auctionID, Auction auction);

	/**
	 * Remove/cancel an existing auction
	 * 
	 * @param auctionID
	 */
	public void removeAuction(int auctionID);

}
