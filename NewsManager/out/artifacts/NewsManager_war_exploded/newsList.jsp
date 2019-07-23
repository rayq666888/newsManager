<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/12
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>新闻列表</title>
    <style type="text/css">
        .td, #footer {
            text-align: center;
            vertical-align: middle;
        }
        #pishan{
            margin-left: 260px;
            margin-bottom: 10px;
        }

    </style>
    <script type="text/javascript">
        function quanxuan(qx) {
            var deleteId = document.getElementsByName("deleteId");
            for (var i = 0; i < deleteId.length; i++) {
                deleteId[i].checked = qx.checked;
            }
        }
        function changeForm() {
            document.getElementById("oprate").value = "pishenhe" ;
            document.forms[0].submit();
        }
        function changeForm1() {
            document.getElementById("oprate").value = "pishan" ;
            document.forms[0].submit();
        }
    </script>
</head>
<body>
<form action="NewsServlet" method="post" onsubmit="javascript: if(confirm('是否提交')){return true}else{return false}">
    <input id="pishan" type="submit" value="批量删除" onclick="changeForm1()">
    <input type="button" value="批量审核" onclick="changeForm()">
    <input type="hidden" id="oprate" name="oprate" value="pishan">
    <table align="center" width="1000px" cellpadding="0px" cellspacing="0px" border="1px"
           style="border: 1px solid gray;border-collapse:collapse">
        <tr>
            <th><input type="checkbox" name="qx" onclick="quanxuan(this)"></th>
            <th>文章ID</th>
            <th>文章标题</th>
            <th>所属栏目</th>
            <th>创建时间</th>
            <th>是否审核</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${newsList}" var="news">
            <tr>
                <td class="td"><input type="checkbox" name="deleteId" value="${news.newsId}"></td>
                <td class="td">${news.newsId}</td>
                <td class="td">${news.newsTitle}</td>
                <td class="td">${news.newsType}</td>
                <td class="td">${news.createTime}</td>
                <td class="td">${news.newsStatus}</td>
                <td class="td">
                    <a href="NewsServlet?oprate=toupdate&newsId=${news.newsId}">编辑</a>
                    |
                    <a href="NewsServlet?oprate=delete&newsId=${news.newsId}">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="7" id="footer">
                <a href="NewsServlet?pageNumber=1">首页</a>
                <a href="NewsServlet?pageNumber=${pageNumber-1}">上页</a>
                <a href="NewsServlet?pageNumber=${pageNumber+1}">下页</a>
                <a href="NewsServlet?pageNumber=${pageTotal}">尾页</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
