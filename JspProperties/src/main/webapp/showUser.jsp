<jsp:useBean id="user" class="com.tss.model.User" scope="request" />
<jsp:setProperty name="user" property="username" />

<html>
<body>
    <h3>Welcome, <jsp:getProperty name="user" property="username" />!</h3>
</body>
</html>
