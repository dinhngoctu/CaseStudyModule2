<%@ page import="java.util.ArrayList" %>
<%@ page import="service.SearchProduct" %>
<%--
  Created by IntelliJ IDEA.
  User: bbt
  Date: 12/02/2020
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<SearchProduct> ar = (ArrayList<SearchProduct>) request.getAttribute("searchProductList"); %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/templates/main.css">
    <%--  <link rel="script" href="<%=request.getContextPath()%>/">--%>
</head>
<body>
<%
    out.println(ar.size());
    String bang = "<table>";
    bang += "<tr>" + "<td width='150px'>" + "Tên sản phẩm " + "</td>";
    bang += "<td width='100px'>" + "Số điện thoại " + "</td>";
    bang += "<td width='100px'>" + "Giá " + "</td>";
    bang += "<td width='300px'>" + "Thông tin chi tiết " + "</td>" + "</tr>";
    for (int i = 0; i < ar.size(); i++) {
        bang += "<tr>" + "<td width='150px' id='name" + i + "' >" + ar.get(i).getProduct().getName() + "</td>";
        bang += "<td width='100px'>" + ar.get(i).getProduct().getPhoneNumber() + "</td>";
        bang += "<td width='100px'>" + ar.get(i).getProduct().getPrice() + "</td>";
        bang += "<td width='300px'>" + ar.get(i).getProduct().getDescripe() + "</td>"+"</tr>";
    }
    bang = bang + "</table>";
    out.print(bang);

%>
</body>
</html>
