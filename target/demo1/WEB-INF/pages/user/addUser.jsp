<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh-CN">
<head>

    <meta charset="utf-8"/>
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width" initial-scale="1"/>
    <title>添加用户</title>

    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"/>

</head>
<body>
<div class="container">
    <h1>添加用户</h1>
    <hr/>
    <form:form action="/user/addP" method="post" commandName="user" role="form">

    <div class="form-group">
        <label for="nickname">Nickname:</label>
        <input type="text" class="form-control" id="nickname" name="nickname" placeholder="Enter Nickname:"/>
    </div>

    <div class="form-group">
        <label for="password">Password:</label>
        <input type="text" class="form-control" id="password" name="password" placeholder="Enter Password:"/>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-sm btn-success">提交</button>
    </div>
    </form:form>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>