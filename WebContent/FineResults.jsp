
<!-- by Madhawa Jayagoda -  ( IT17184304 )  SLIIT 2018 OOP project
	OOP project 2018
 * @author Madhawa Jayagoda
 * Student name: N.M.Jayagoda
 * Student reg.No: IT17184304
 * Topic : Admin - Add / remove Auctions
 * SLIIT -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fine for the Auction</title>
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
</style>
</head>
<body>
	<br/>
	<form action="homeView.jsp">
  		<input type="submit" value="Go back!" class="firstInput">
	</form>
	<br/>
	<p style="color:red">** Fine is penalized, when a auctioneer request to remove the auction or when the product is illegal to sell or when several customers report the item on Auction**</p>
	<p style="color:red">** Note that this auction can be performed ONLY by the administrator of the system **</p>
	
	<% Integer no_of_bidders = (Integer) request.getAttribute("no_of_bidders"); 
		Integer dateDiff = (Integer) request.getAttribute("dateDiff");
		Float fine = (Float) request.getAttribute("fine");
	%>
	<div align="center">
		<table>
			<tr>
				<td>
					<h3>
					<ul><li>
						Number of Bidders ( At the moment of cancellation ) :
						<%=no_of_bidders%></h3>
					</li>
					</ul>
				</td>
			</tr>
			<tr>
				<td>
					<h3>
					<ul><li>
						Date difference ( Difference between auction added date and the
						current date ) :
						<%=dateDiff%></h3>
					</li>
					</ul>
				</td>
			</tr>
			<tr>
				<td>
					<h2>
					<ul><li>
						Total Fine imposed on the Auction =
						<%=fine %></h2>
					</li>
					</ul>
				</td>
			</tr>
		</table>
	</div>
	<footer>
		<p align="center">
			<pre>                        <B>produced by : N.M.Jayagoda                           Student reg.No: IT17184303.</B></pre>
		</p>
	</footer>

</body>
</html>