package controller;

import model.Product;
import service.ReadProduct;
import service.SearchProduct;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class searchProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("UTF-8");
        String value = req.getParameter("search");
        ArrayList<Product> al = ReadProduct.getReadProduct().readFilesObject("/home/bbt/Git/java-new/ManagerProducts/files/Products.md");
        ArrayList<SearchProduct> ar = SearchProduct.search(value,al);
        req.setAttribute("searchProductList",ar);
        RequestDispatcher rd = req.getRequestDispatcher("/view/searchProducts.jsp");
        rd.forward(req,resp);
    }
}
