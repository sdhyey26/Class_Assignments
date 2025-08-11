<%
    String error = (String) session.getAttribute("error");
%>
<h3 style="color:red">Error: Feedback Not Submitted</h3>
<p><%= error %></p>
