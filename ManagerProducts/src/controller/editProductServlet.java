package controller;

import model.Product;
import service.ReadProduct;
import service.WriteProduct;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class editProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));

        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String phoneNumber = req.getParameter("phone");
        String descripe = req.getParameter("descripe");
        if (name != null && price != null && phoneNumber != null && descripe != null) {
            ArrayList<Product> value = ReadProduct.getReadProduct().readFilesObject("/home/bbt/Git/java-new/ManagerProducts/files/Products.md");
            value.get(id).setName(name);
            value.get(id).setPrice(price);
            value.get(id).setPhoneNumber(phoneNumber);
            value.get(id).setDescripe(descripe);
            WriteProduct.getWriteProduct().overWriteListProducts(value);
        }
        resp.sendRedirect(req.getContextPath() + "/productsmanager");
        return;
    }
}