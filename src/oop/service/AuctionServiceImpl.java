
/**
 * OOP project 2018
 * @author Madhawa Jayagoda
 * Student name: N.M.Jayagoda
 * Student reg.No: IT17184304
 * Topic : Admin - Add / remove Auctions
 * SLIIT
 */

package oop.service;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import oop.service.AuctionServiceImpl;
import oop.util.CommonConstants;
import oop.util.DBConnectionUtil;
import oop.util.QueryUtil;
import oop.model.Auction;

public class AuctionServiceImpl implements IAuctionService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IAuctionService.class.getName());

	private static Connection connection;

	private static Statement statement;

	public static void createAuctionTable() {
		
		try {
			
			/**
			 * This method initially drop existing auction table in the database and
			 * recreate table structure to insert auction related entries
			 */
			
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			// Drop table if already exists and as per SQL query available in
			// Query.xml
			statement.executeUpdate(oop.util.QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			// Create new auction table as per SQL query available in
			// Query.xml
			statement.executeUpdate(oop.util.QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));
			
			/**
			 * @throws SQLException
			 *             - Thrown when database access error occurs or this method is
			 *             called on a closed connection
			 * @throws ClassNotFoundException
			 *             - Thrown when an application tries to load in a class through
			 *             its string name using
			 * @throws SAXException
			 *             - Encapsulate a general SAX error or warning
			 * @throws IOException
			 *             - Exception produced by failed or interrupted I/O operations.
			 * @throws ParserConfigurationException
			 *             - Indicates a serious configuration error
			 * @throws NullPointerException
			 *             - Service is not available
			 * 
			 */
			
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	
	private PreparedStatement preparedStatement;

	public int generateIDs(ArrayList<Integer> arrayList) {

		int id;
		int next = arrayList.size();
		next++;
		id = (int) next;
		if (arrayList.contains(id)) {
			next++;
			id = (int) next;
		}
		return id;
	}
	
	private ArrayList<Integer> getAuctionIDs() {

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		/*
		 * List of auction IDs will be retrieved from AuctionQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_AUCTION_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getInt(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
	
	private ArrayList<Integer> getSellerIDs() {

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		/*
		 * List of auction IDs will be retrieved from AuctionQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_SELLER_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getInt(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}

	@Override
	public void addAuction(Auction auction) {

		int auctionID = this.generateIDs(getAuctionIDs());
		int sellerID = this.generateIDs(getSellerIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in AuctionQuery.xml file 
			 */
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_AUCTIONS));
			connection.setAutoCommit(false);
			
			//Generate auction IDs
			auction.setAuctionID(auctionID);
			auction.setSellerID(sellerID);
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, auction.getAuctionID());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, auction.getSellerID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, auction.getProductName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, auction.getCategory());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, auction.get_no_of_bidders());
			preparedStatement.setDate(CommonConstants.COLUMN_INDEX_SIX, auction.getAddedDate());
			
			// Add auction
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	private ArrayList<Auction> actionOnAuction(int auctionID) {

		ArrayList<Auction> auctionList = new ArrayList<Auction>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching auction it checks whether auction ID is
			 * available
			 */
			String AuctionID = String.valueOf(auctionID);
			
			if ((AuctionID) != null && !AuctionID.isEmpty()) {
				/*
				 * Get auction by ID query will be retrieved from
				 * AuctionQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_AUCTION));
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, auctionID);
			}
			/*
			 * If auction ID is not provided for get auction option it display
			 * all auctions
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_AUCTIONS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Auction auction = new Auction();
				auction.setAuctionID(resultSet.getInt(CommonConstants.COLUMN_INDEX_ONE));
				auction.setSellerID(resultSet.getInt(CommonConstants.COLUMN_INDEX_TWO));
				auction.setProductName(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				auction.setCategory(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				auction.set_no_of_bidders(resultSet.getInt(CommonConstants.COLUMN_INDEX_FIVE));
				auction.setAddedDate(resultSet.getDate(CommonConstants.COLUMN_INDEX_SIX));
				auctionList.add(auction);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return auctionList;
	}

	@Override
	public Auction getAuctionByID(int auctionID) {
		return actionOnAuction(auctionID).get(0);
	}


	@Override
	public ArrayList<Auction> getAuctions() {
		
		return actionOnAuction(0);
	}

	@Override
	public Auction updateAuction(int auctionID, Auction auction){

		/*
		 * Before fetching auction, it checks whether auction ID is available
		 */
		String AuctionID = String.valueOf(auctionID);
		
		if (AuctionID != null && !AuctionID.isEmpty()) {
			/*
			 * Update auction query will be retrieved from AuctionQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_AUCTION));
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, auction.getAuctionID());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, auction.getSellerID());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, auction.getProductName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, auction.getCategory());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, auction.get_no_of_bidders());
				preparedStatement.setDate(CommonConstants.COLUMN_INDEX_SIX, auction.getAddedDate());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated auction details
		return getAuctionByID(auctionID);
	}

	@Override
	public void removeAuction(int auctionID) {
		
		// Before deleting check whether auctionID is available
		
		String AuctionID = String.valueOf(auctionID);

		if (AuctionID != null && !AuctionID.isEmpty()) {
			/*
			 * Remove auction query will be retrieved from AuctionQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_AUCTION));
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, auctionID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

}
