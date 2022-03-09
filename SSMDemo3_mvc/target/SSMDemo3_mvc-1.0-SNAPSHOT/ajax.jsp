<%--
  Created by IntelliJ IDEA.
  User: YsY
  Date: 2022/3/8
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"/>
    <script>
        var userList = new Array();
        userList.push({username:"zhangsan",age:13})
        userList.push({username:"lisi",age:14})

        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/quickstart15",
            data:JSON.stringify(userList),
            contentType:"application/json,charset=utf-8"
        });
    </script>
</head>
<body>

</body>
</html>
