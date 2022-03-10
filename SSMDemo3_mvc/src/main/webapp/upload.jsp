<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/quickstart22" method="post" enctype="multipart/form-data">
        <input type="text" name="username"><br>
        <input type="file" name="uploadFile"><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
