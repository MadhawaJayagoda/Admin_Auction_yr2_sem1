
<!-- by Madhawa Jayagoda -  ( IT17184304 )  SLIIT 2018 OOP project
	OOP project 2018
 * @author Madhawa Jayagoda
 * Student name: N.M.Jayagoda
 * Student reg.No: IT17184304
 * Topic : Admin - Add / remove Auctions
 * SLIIT -->
	
<!DOCTYPE html>
<html>
<head>
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

input[type=text], select {
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
	width: 200px;
	height: 50px;
}

.button {
	background-color: white;
	color: black;
	border: 2px solid #555555;
}

.submit2 {
	padding: 14px 40px;
	border-radius: 12px;
	width: 275px;
	height: 60px;
}

.button2 {
	background-color: #ff0066;
	color: black;
	border: 2px solid #555555;
}

.button:hover {
	background-color: #555555;
	color: white;
}

.button2:hover {
	background-color: #555555;
	color: white;
}
</style>
</head>
<title>Auction Details</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<body style="background-color: silver;">
	<nav>
		<h2 class="header1" align="center">Enter Auction Details</h2>
	</nav>
	<br />
	<br />
	<br />
	
	<div><h1 style="font-family:verdana; text-align:center; color:#800000"; font-size:250%;> Admin Home Page </h1></div>

	<div>
		<form method="post" action="GetAuctionServlet">
			<table align="center">
				<tr>
					<td><span style="font-size: 20px; color: black;"><ul><li>Enter Auction ID : </li></ul></span></td>
					<td><input type="text" name="auctionID"
						placeholder="Please enter a number of four digits" size=35
						maxlength="4">
					</td>
					<pre>          </pre>	
					<td><input class="submit1 button " type="submit"
						value="View Auction Details">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div align="center">
		<form method="post" action="DeleteAuctionServlet">
			<table align="center">
				<tr>
					<td><span style="font-size: 20px; color: black;"><ul><li>Enter Auction ID : </li></ul></span></td>
					<td><input type="text" name="auctionID"
						placeholder="Please enter a number of four digits" size=35
						maxlength="4">
					</td>
					<td><input type="submit" value="Cancel Auction" class="submit1 button" ></td>
				</tr>
			</table>
		</form>
	</div>
	<div align="center">
		<form action="AddAuction.jsp">
			<input type="submit" value="Add a new Auction to the Database" class="submit2 button2">
		</form>
	</div>
	<footer>
		<p align="center">
			<pre>                        <B>produced by : N.M.Jayagoda                           Student reg.No: IT17184303.</B></pre>
		</p>
	</footer>
</body>
</html>