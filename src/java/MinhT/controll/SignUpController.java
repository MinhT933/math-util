/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinhT.controll;

import MinhT.dao.PhoneDao;
import MinhT.dao.UserDAO;
import MinhT.dto.Phone;
import MinhT.dto.UserDTO;
import MinhT.dto.UserError;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MinhT
 */
public class SignUpController extends HttpServlet {

    private static final String ERROR = "ErrorSignUP.jsp";
    private static final String SUCCESS = "login.jsp";

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
        String url = ERROR;
        UserError error = new UserError("", "", "", "");
        try {
            UserDAO dao = new UserDAO();
            String userID = request.getParameter("user");
            String fullName = request.getParameter("FullName");
            String password = request.getParameter("pass");
            String confirm = request.getParameter("repass");
            if (!password.equals(confirm)) {
                url = ERROR;
            } else {
                UserDTO a = dao.checkDuplicate(userID);
                if (a == null) {
                    dao.insert(userID, password, fullName);
                    request.setAttribute("mess", "SignUp successs!!!");
                    url = SUCCESS;
                } else {
                    url = ERROR;
                }
            }

        } catch (Exception e) {
            if (e.toString().contains("duplicate")) {
                error.setUserIDError("Duplicate User ID");
                request.setAttribute("ERROR", error);
            }
        } finally {
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
