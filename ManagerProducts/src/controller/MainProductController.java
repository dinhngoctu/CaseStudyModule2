package controller;

import model.Product;
import service.ReadProduct;
import service.SortProduct;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class MainProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Product> value = ReadProduct.getReadProduct().readFilesObject("/home/bbt/Git/java-new/ManagerProducts/files/Products.md");
        req.setAttribute("productList", value);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/mainListProducts.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Product> value= null;
        String str = request.getParameter("sort");
        if (str.equalsIgnoreCase("tt")) {
            value = ReadProduct.getReadProduct().readFilesObject("/home/bbt/Git/java-new/ManagerProducts/files/Products.md");
            SortProduct.sortByName(value);
        }
        if (str.equalsIgnoreCase("time")) {
             value = ReadProduct.getReadProduct().readFilesObject("/home/bbt/Git/java-new/ManagerProducts/files/Products.md");
        }
        if (str.equalsIgnoreCase("tg")) {
            value = ReadProduct.getReadProduct().readFilesObject("/home/bbt/Git/java-new/ManagerProducts/files/Products.md");
            SortProduct.sortByPrice(value);
        }
        if (str.equalsIgnoreCase("tsdt")) {
            value = ReadProduct.getReadProduct().readFilesObject("/home/bbt/Git/java-new/ManagerProducts/files/Products.md");
            SortProduct.sortByPhone(value);
        }
        request.setAttribute("productList", value);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/mainListProducts.jsp");
        dispatcher.forward(request, response);
    }
}
