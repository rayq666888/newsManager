<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/14
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑新闻</title>
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
        <input type="hidden" value="${news.newsId}" name="newsId">
        <input type="hidden" name="oprate" value="updatenews">
        <input type="text" name="newsTitle" value="${news.newsTitle}" placeholder="请输入标题">
        新闻栏目
        <select name="newsType">
            <option <c:if test="${news.newsType==\"html\"}">selected</c:if> value="html">html</option>
            <option <c:if test="${news.newsType==\"java\"}">selected</c:if> value="java">java</option>
            <option <c:if test="${news.newsType==\"oracle\"}">selected</c:if> value="oracle">oracle</option>
            <option <c:if test="${(news.newsType!=\"html\")&&(news.newsType!=\"java\")&&(news.newsType!=\"oracle\")}">selected</c:if> value="oracle">其他</option>
        </select>
        <br>
        <textarea id="content" name="newsContent" rows="50" cols="8">${news.newsContent}</textarea>
        <br>
        <input type="submit" value="修改">
    </form>
</body>
</html>
