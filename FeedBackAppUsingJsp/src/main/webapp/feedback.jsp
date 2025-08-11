<%@ page language="java"%>
<html>
<head>
<title>Feedback Form</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f3f3f3;
	padding: 30px;
}

h2 {
	color: #333;
}

form {
	background-color: #fff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px #ccc;
	width: 400px;
	margin: auto;
}

input[type="text"], input[type="date"], input[type="number"] {
	width: 100%;
	padding: 8px;
	margin: 6px 0;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px;
	width: 100%;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}

input[type="submit"] {
    background: linear-gradient(to right, #1e90ff, #00bfff); 
    color: white;
    padding: 10px;
    width: 100%;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    transition: background 0.3s ease;
}

input[type="submit"]:hover {
    background: linear-gradient(to right, #00bfff, #1e90ff); 
}
</style>
</head>
<body>
	<h2 style="text-align: center;">Feedback App</h2>

	<form action="FeedbackServlet" method="post">
		Name: <input type="text" name="name" required /> Session Date: <input
			type="date" name="sessionDate" required /> Session Content: <input
			type="number" name="sessionContent" min="1" max="10" required />

		Query Resolution/Feedback: <input type="number" name="queryFeedback"
			min="1" max="10" required /> Interactivity/Engagement: <input
			type="number" name="interactivity" min="1" max="10" required />

		Impactful Learning: <input type="number" name="impactfulLearning"
			min="1" max="10" required /> Content Delivery Skills: <input
			type="number" name="deliverySkills" min="1" max="10" required /> <input
			type="submit" value="Submit Feedback" />
	</form>
</body>
</html>
