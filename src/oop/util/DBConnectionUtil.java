
/**
 * OOP project 2018
 * @author Madhawa Jayagoda
 * Student name: N.M.Jayagoda
 * Student reg.No: IT17184304
 * Topic : Admin - Add / remove Auctions
 * SLIIT
 */

package oop.util;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import oop.util.QueryUtil;

import oop.service.IAuctionService;
import oop.util.CommonConstants;

/**
 * This is the Database connection creation class .
	
 */

public class DBConnectionUtil{
	
		  
		private static Connection connection;

		// This works according to singleton pattern
		private DBConnectionUtil() {
		}

		/** Initialize logger */
		public static final Logger log = Logger.getLogger(IAuctionService.class.getName());

		public static final Properties properties = new Properties();
		
		static {
			try {
				
				// Read the property only once when load the class
				properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
				
			} catch (IOException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		/**
		 * Create Database connection for the given URL, Username and Password
		 * 
		 * @return Connection this returns SQL connection for MySql Database
		 * 
		 * @throws ClassNotFoundException
		 *             - Thrown when an application tries to load in a class through
		 *             its string name
		 * @throws SQLException
		 *             - An exception that provides information on a database access
		 *             error or other errors
		 */
		public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
			/*
			 * This create new connection objects when connection is closed or it is
			 * null
			 */
			if (connection == null || connection.isClosed()) {

				Class.forName(properties.getProperty(CommonConstants.DRIVER_NAME));
				connection = DriverManager.getConnection(properties.getProperty(CommonConstants.URL),
						properties.getProperty(CommonConstants.USERNAME), properties.getProperty(CommonConstants.PASSWORD));
			}
			return connection;
		}

}



