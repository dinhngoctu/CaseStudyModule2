package controller;

import model.Product;
import service.CrowIphoneTinhte;
import service.ReadProduct;
import service.WriteProduct;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class deleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ArrayList<Product> value = ReadProduct.getReadProduct().readFilesObject("/home/bbt/Git/java-new/ManagerProducts/files/Products.md");
        value.remove(Integer.parseInt(id));
        WriteProduct.getWriteProduct().overWriteListProducts(value);
        resp.sendRedirect(req.getContextPath() + "/productsmanager");
        return;
    }
}
