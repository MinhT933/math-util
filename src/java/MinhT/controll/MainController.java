/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinhT.controll;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MinhT
 */
@WebServlet(name = "MainControler", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private String ERROR = "error.jsp";
    private String LOAD_DATA = "homecontroll";
    private String LOAD_DATA_BYCATE = "Categorycontroller";
    private String DETAIL = "DetailController";
    private String SEARCH = "SearchController";
    private String LOGIN = "LoginControll";
    private String SIGN_UP="SignUpController";
    private String LOGOUT="LogoutController";
    private String ADDTOCART="AddToCart";
    private String SHOWTOCART="ShowCartController";
    private String ROMOVECART="RemoveCartController";
    private String ADD="CongtoCartController";
    private String SUB="RemoveCartController";
    private String MANAGER_PRODUCT="ManagerController";
    private String DELETE_PRODUCT="DeletePhoneController";
    private String ADD_PRODUCT="AddProductController";
    private String LOAD_TO_EDIT="LoadToEditController";
    private String EDIT="EditController";
   

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String namebutton = request.getParameter("btnAction");
//        System.out.println(namebutton+"hihi");
        String url = ERROR;
        try {
            if (namebutton == null) {
                url = LOAD_DATA;
            }
            if(namebutton.equals("null")){
                url=LOAD_DATA;
            }
            if (namebutton.equals("select")) {
                url = LOAD_DATA_BYCATE;
            }
            if (namebutton.equals("detail")) {
                url = DETAIL;
            }
            if (namebutton.equals("search")) {
                url = SEARCH;
            }
            if (namebutton.equals("login")) {
                url = LOGIN;
            }if(namebutton.equals("SignUP")){
                url=SIGN_UP;
            }if(namebutton.equals("logout")){
                url=LOGOUT;
            }if(namebutton.equals("addCart")){
                url=ADDTOCART;
            }if(namebutton.equals("romovecart")){
                url=ROMOVECART;
            }if(namebutton.equals("add")){
                url=ADD;
            
            }if(namebutton.equals("sub")){
                url=SUB;
            }if(namebutton.equals("manager"))
            {
                url=MANAGER_PRODUCT;
                
            }if(namebutton.equals("delete")){
                url=DELETE_PRODUCT;
            }if(namebutton.equals("addproduct")){
                url=ADD_PRODUCT;
                
            }if(namebutton.equals("loadtoedit")){
                url=LOAD_TO_EDIT;
            }if(namebutton.equals("edit")){
                url=EDIT;
            }

        } catch (Exception e) {
        } finally {
//            System.out.println(url);
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
