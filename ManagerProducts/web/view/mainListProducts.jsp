<%@ page import="model.Product" %>
<%@ page import="service.ReadProduct" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<% ArrayList<Product> ll = (ArrayList) request.getAttribute("productList"); %>
<!DOCTYPE html>
<html>
<head>
    <title>ProductsManager</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/templates/main.css">
    <%--  <link rel="script" href="<%=request.getContextPath()%>/">--%>
</head>

<body>
<button onclick="addProduct()">Thêm sản phẩm</button>
<button onclick="searchProduct()">Tìm Sản Phẩm</button>
<form method="POST" action="${pageContext.request.contextPath}/updateproduct">
    <button type="submit">Cập nhật</button>
</form>
<form id="formAdd" method="POST" action="${pageContext.request.contextPath}/addproduct"></form>
<form id="formSearch" method="POST" action="${pageContext.request.contextPath}/searchproduct"></form>
<form id="formEdit" method="POST" action="${pageContext.request.contextPath}/editproduct"></form>
<form id="formDelete" method="POST" action="${pageContext.request.contextPath}/deleteproduct"></form>
<h3>Display All Product</h3>
<div id="dssp"></div>
<form id="formSort" method="POST" action="${pageContext.request.contextPath}/productsmanager">
    <select name="sort" onchange="submitsort()">
        <option value="time" >Theo thởi gian</option>
        <option value="tg" >Theo giá</option>
        <option value="tt" >Theo tên</option>
        <option value="tsdt" >Theo số điện thoại</option>
    </select>
</form>
<%
    out.println(ll.size());
    String bang = "<table>";
    bang += "<tr>" + "<td width='150px'>" + "Tên sản phẩm " + "</td>";
    bang += "<td width='100px'>" + "Số điện thoại " + "</td>";
    bang += "<td width='100px'>" + "Giá " + "</td>";
    bang += "<td width='300px'>" + "Thông tin chi tiết " + "</td>";
    bang += "<td width='100'>" + "Sửa " + "</td>";
    bang += "<td width='100'>" + "Xóa " + "</td>" + "</tr>";
    for (int i = 0; i < ll.size(); i++) {
        bang += "<tr>" + "<td width='150px' id='name" + i + "' >" + ll.get(i).getName() + "</td>";
        bang += "<td width='100px'>" + ll.get(i).getPhoneNumber() + "</td>";
        bang += "<td width='100px'>" + ll.get(i).getPrice() + "</td>";
        bang += "<td width='300px'>" + ll.get(i).getDescripe() + "</td>";
        bang += "<td>" + "<input type='button' id=" + i + " value='edit' style='border-radius:3px' onclick='editdata(this.id)'>" + "</td>";
        bang += "<td>" + "<input type='button' id=" + i + " value='delete' style='border-radius:3px' onclick='deletedata(this.id)'>" + "</td>" + "</tr>";
    }
    bang = bang + "</table>";
    out.print(bang);

%>

<script>
    let status = -1;

    // function drawTable() {
    //     let bang = "</%";
    //     document.getElementById("dsspa").innerHTML = bang
    //     document.getElementById("span").innerHTML = arr.length + " Products"
    // }

    function deletedata(id) {
        let ans = prompt("nhap yes de xoa");
        if (ans == "yes") {
            let str = "<input type=\"text\" id='inputSua3' name=\"id\" style=\"border-radius:4px; border:none;\" value=\"" + id + "\" readonly>";
            document.getElementById("formDelete").innerHTML = str;
            document.getElementById("formDelete").submit();
        }
    }


    function editdata(id) {
        status = -status;
        if (status > 0) {
            let str = "<h3>Nhập thông tin</h3>\n" + "  <table width=\"50%\">\n" +
                "    <tr>\n" +
                "      <td>\n" +
                "        <input type=\"text\" id='inputSua0' name=\"id\" style=\"width:8px;border-radius:4px; border:none;\" value=\"" + id + "\" readonly>" +
                "      </td>\n" +
                "      <td>\n" +
                "        <input type=\"text\" id='inputSua1' name=\"name\" style=\"border-radius:4px; border:none;\" value=\"ten\">" +
                "      </td>\n" +
                "      <td>\n" +
                "        <input type=\"text\" id='inputSua2' name=\"phone\" style=\"border-radius:4px; border:none;\" value=\"so dien thoai\">" +
                "      <td>\n" +
                "      <td>\n" +
                "        <input type=\"text\" id='inputSua3' name=\"price\" style=\"border-radius:4px; border:none;\" value=\"gia\">" +
                "      <td>\n" +
                "      <td>\n" +
                "        <input type=\"text\" id='inputSua4' name=\"descripe\" style=\"border-radius:4px; border:none;\" value=\"thong tin chi tiet\">" +
                "      <td>\n" +
                "      <td>\n" +
                "        <input type=\"submit\" value=\"Lưu\">\n" +
                "      <td>\n" +
                "    </tr>\n" +
                "  </table>";
            document.getElementById("formEdit").innerHTML = str;
            arr.splice(parseInt(id), 1, a = prompt());
        } else {
            document.getElementById("formEdit").innerHTML = "";
        }
    }

    function addProduct() {
        status = -status;
        if (status > 0) {
            let str = "<h3>Thêm Sản Phẩm</h3>\n" +
                "  <table width=\"50%\">\n" +
                "    <tr>\n" +
                "      <td>\n" +
                "        <input type=\"text\" id='inputnhap1' name=\"name\" style=\"border-radius:4px; border:none;\" placeholder=\"ten san pham\">" +
                "      </td>\n" +
                "      <td>\n" +
                "        <input type=\"text\" id='inputnhap2' name=\"phone\" style=\"border-radius:4px; border:none;\" placeholder=\"so dien thoai\">" +
                "      <td>\n" +
                "      <td>\n" +
                "        <input type=\"text\" id='inputnhap3' name=\"price\" style=\"border-radius:4px; border:none;\" placeholder=\"gia\">" +
                "      <td>\n" +
                "      <td>\n" +
                "        <input type=\"text\" id='inputnhap4' name=\"descripe\" style=\"border-radius:4px; border:none;\" placeholder=\"thong tin chi tiet\">" +
                "      <td>\n" +
                "      <td>\n" +
                "        <input type=\"submit\" value=\"Thêm\">\n" +
                "      <td>\n" +
                "    </tr>\n" +
                "  </table>";
            document.getElementById("formAdd").innerHTML = str;
        } else {
            document.getElementById("formAdd").innerHTML = "";
        }
    }

    function searchProduct() {
        status = -status;
        if (status > 0) {
            let str = "<h3>Tìm Sản Phẩm</h3>\n" +
                "  <table width=\"50%\">\n" + "<input type=\"text\" id = \"textSearch\" name = \"search\" style=\"border-radius:4px; border:1px\" placeholder=\"nhap\">\n" +
                "    <input type=\"submit\" value = \"Tìm kiếm\">"
            "  </table>";
            document.getElementById("formSearch").innerHTML = str;
        } else {
            document.getElementById("formSearch").innerHTML = "";
        }
    }

    function submitsort() {
        document.getElementById("formSort").submit();
    }

</script>
</body>

</html>
