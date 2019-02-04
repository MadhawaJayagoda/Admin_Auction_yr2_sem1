
<!-- by Madhawa Jayagoda -  ( IT17184304 )  SLIIT 2018 OOP project
	OOP project 2018
 * @author Madhawa Jayagoda
 * Student name: N.M.Jayagoda
 * Student reg.No: IT17184304
 * Topic : Admin - Add / remove Auctions
 * SLIIT -->

<%@page import="oop.model.Auction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="oop.service.AuctionServiceImpl"%>
<%@page import="oop.service.IAuctionService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auction Details</title>
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
			
			.header1 {
		text-align: center;
		text-transform: uppercase;
		color: black;
		font-size: 5vw;
		background-color: orange;
		font: bold italic serif;
		margin: 0;
		padding: 0;
		text-shadow: -1px -1px 1px green;
		0
		px
		4px
		1px
		rgba(0,0,0,0.5),
		4px
		4px
		5px
		rgba(0,0,0,0.7),
	}
	</style>
</head>
<body style="background-color: #a6a6a6";>
	<br/>
	<form action="homeView.jsp">
  		<input type="submit" value="Go back!" class="firstInput">
	</form>
	<br/>
	
	<caption><h3 class ="header1" align="center">List of Auctions</h3></caption>
	<br/>
	<br/>
	
	<div align="left">
		<table border="1" cellpadding="12">
		  	<tr>
                <th>Auction ID</th>
                <th>Seller ID</th>
                <th>Product name</th>
                <th>Category</th>
                <th>Number of Bidders</th>
                <th>Added date</th>
            </tr>
            <%
            IAuctionService iAuctionService = new AuctionServiceImpl();
			ArrayList<Auction> arrayList = iAuctionService.getAuctions();
			
			for(Auction auction : arrayList){
			%>
			 <tr>
				<td> <%=auction.getAuctionID() %> </td>
				<td> <%=auction.getSellerID() %> </td>
				<td> <%=auction.getProductName() %> </td>
				<td> <%=auction.getCategory() %> </td>
				<td> <%=auction.get_no_of_bidders() %> </td>
				<td> <%=auction.getAddedDate() %> </td>
				
					<td> 
						<form method="POST" action="GetAuctionServlet">
							<input type="hidden" name="auctionID" value="<%=auction.getAuctionID()%>"/>
				 			<input type="submit" value= "Select Auction" /> 
				 		</form>
				 	</td>	
				</tr>			
			<%	
			   }
            %>     
		</table>
		</div>
		<br/>
		<br/>
		<br/>
		<br/>
		<footer>
		<p align="center">
			<pre>                        <B>produced by : N.M.Jayagoda                           Student reg.No: IT17184303.</B></pre>
		</p>
	</footer>
</body>
</html>