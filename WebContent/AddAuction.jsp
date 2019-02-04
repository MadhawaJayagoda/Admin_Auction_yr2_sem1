
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
<title>Add Auction</title>
<style>
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

.firstInput {
    background-color: red; 
    border: black;
    color: black;
    padding: 15px 32px;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}

input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=date], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
	align-content: center;
}

.submit1 {
	padding: 14px 40px;
	border-radius: 12px;
	width: 175px;
	height: 50px;
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
<body style="background-color: silver;">
	<br/>
	<form action="homeView.jsp">
  		<input type="submit" value="Go back!" class="firstInput">
	</form>
	<br/>

	<nav>
		<h2 class="header1" align="center">Enter Auction Details</h2>
	</nav>
	<br />
	<br />
	<br />
	<div>
		
	</div>
	<div align="center">
	<form method="POST" action="AddAuctionServlet">
		<table>
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="product_name" /></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><input type="text" name="category" /></td>
			</tr>
			<tr>
				<td>Number of Bidders</td>
				<td><input type="text" name="no_of_bidders" /></td>
			</tr>
			<tr>
				<td>Date added</td>
				<td><input type="date"  name="addedDate" placeholder="2018-10-30"/></td>
			</tr>
			
			<div align="center">
				<tr>
					<td colspan="2"><input type="submit" value="Add Auction"
						class="button submit1" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="reset" value="Reset"
						class="button submit1" /></td>
				</tr>
			</div>
			</table>
	</form>
	</div>
	<footer>
		<p align="center">
			<pre>                        <B>produced by : N.M.Jayagoda                           Student reg.No: IT17184303.</B></pre>
		</p>
	</footer>
</body>
</html>