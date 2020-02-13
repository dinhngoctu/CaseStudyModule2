package controller;

import model.Product;
import service.WriteProduct;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class addProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "iphone";
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String phoneNumber = req.getParameter("phone");
        String descripe = req.getParameter("descripe");
        if (name != null && price != null && phoneNumber != null && descripe != null) {
            ArrayList<Product> ll = new ArrayList<>();
            Product product = new Product(link, name, price, phoneNumber, descripe);
            ll.add(product);
            WriteProduct.getWriteProduct().writeListProducts(ll);
        }
        resp.sendRedirect(req.getContextPath() + "/productsmanager");
        return;
    }
}
