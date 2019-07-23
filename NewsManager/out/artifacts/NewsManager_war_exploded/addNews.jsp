<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/14
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新闻</title>
    <script type="text/javascript" src="kindeditor/kindeditor-all.js"></script>
    <script type="text/javascript">
         KindEditor.ready(function (K) {
             K.create('#content',{
                 uploadJson : 'kindeditor/jsp/upload_json.jsp',
                 fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
                 allowFileManager : true
             });
         });
    </script>
</head>
<body>
    <form action="NewsServlet" method="post">
        <input type="hidden" name="oprate" value="addnews">
        <input type="text" name="newsTitle" placeholder="请输入标题">
        新闻栏目
        <select name="newsType">
            <option value="html">html</option>
            <option value="java">java</option>
            <option value="oracle">oracle</option>
        </select>
        <br>
        <textarea id="content" name="newsContent" rows="50" cols="8"></textarea>
        <br>
        <input type="submit" value="添加">
    </form>
</body>
</html>
