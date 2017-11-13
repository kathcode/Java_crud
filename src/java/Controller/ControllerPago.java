/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOPago;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelProyeccion;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author esneiderserna
 */
public class ControllerPago extends HttpServlet {
    private DAOPago dao;
    private static String CREAR_PAGO = "Pago/Crear.jsp";
    private static String MOSTRAR_PAGO = "Pago/MostrarPago.jsp";
    
    public ControllerPago() {
        super();
        dao = new DAOPago();
    }

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String forward="";
        String opcion = (String) request.getParameter("opcion");
        
        if (opcion.equals("buscarPago")) {
            int numero_tarjeta = Integer.parseInt(request.getParameter("numero_tarjeta"));
            buscarPago(request, response, numero_tarjeta);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPago.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPago.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public void buscarPago(HttpServletRequest request, HttpServletResponse response, int numero_tarjeta) throws SQLException, ServletException, IOException {
        ModelProyeccion proyeccion = dao.getInfoToPay(numero_tarjeta);
        
        RequestDispatcher vista = null;
        request.setAttribute("proyeccion", proyeccion);
        vista = request.getRequestDispatcher(MOSTRAR_PAGO);
        vista.forward(request, response);
    }
    
}
