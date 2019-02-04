
<!-- by Madhawa Jayagoda -  ( IT17184304 )  SLIIT 2018 OOP project
	OOP project 2018
 * @author Madhawa Jayagoda
 * Student name: N.M.Jayagoda
 * Student reg.No: IT17184304
 * Topic : Admin - Add / remove Auctions
 * SLIIT -->

<%@page import="oop.model.Auction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auction Management</title>
	<style>
		.firstInput {
		    background-color: red; 
		    border: black;
		    color: black;
		    padding: 15px 32px;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 16px;
		}
				
		.submit1 {
			padding: 14px 40px;
			border-radius: 12px;
		}
		
		.button {
			background-color: white;
			color: black;
			border: 2px solid #555555;
		}
		
		.button:hover {
			background-color: #555555;
			color: white;
		}
	</style>
</head>
<body>
	<br/>
	<form action="homeView.jsp">
  		<input type="submit" value="Go back!" class="firstInput">
	</form>
	<br/>
	<h2 class="h2">Get Auction Page</h2>

	Auction Management App for OOP jsp servlet.
	<br>
	<br>
	<%
		Auction auction = (Auction) request.getAttribute("auction");
	%>

	<form method="POST" action="UpdateAuctionServlet">
		<table>
			<tr>
				<td>Auction ID</td>
				<td><input type="text" name="auctionID" disabled="disabled" value="<%=auction.getAuctionID()%>" /></td>
			</tr>
			<tr>
				<td>Seller ID</td>
				<td><input type="text" name="sellerID" disabled="disabled" value="<%=auction.getSellerID()%>" /></td>
			</tr>
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="product_name" value="<%=auction.getProductName()%>" /></td>
			</tr>
			<tr>
				<td>Auction Category</td>
				<td><input type="text" name="category" value="<%=auction.getCategory()%>" /></td>
			</tr>
			<tr>
				<td>Number of Bidders</td>
				<td><input type="text" name="no_of_bidders" value="<%=auction.get_no_of_bidders()%>" /></td>
			</tr>
			<tr>
				<td>Auction added Date</td>
				<td><input type="text" name="addedDate" value="<%=auction.getAddedDate()%>" /></td>
			</tr>
			
			</tr>
			<tr>
				<td colspan="2">
				<input type="hidden" name="auctionID" value="<%=auction.getAuctionID()%>" />
				<input type="submit" value="Update Auction" class="submit1 button"/></td>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="DeleteAuctionServlet">
					<input type="hidden" name="auctionID" value="<%=auction.getAuctionID()%>" /> 
					<input type="submit" value="Delete Auction" class="submit1 button"/>
				</form>
			</td>
		</tr>
	</table>
	
	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="FineCalculationServlet">
					<input type="hidden" name="auctionID" value="<%=auction.getAuctionID()%>" /> 
					<input type="submit" value="Calculate Fine" class="submit1 button"/>
				</form>
			</td>
		</tr>
	</table>
	<br/>
	<footer>
		<p align="center">
			<pre>                        <B>produced by : N.M.Jayagoda                           Student reg.No: IT17184303.</B></pre>
		</p>
	</footer>
</body>
</html> 