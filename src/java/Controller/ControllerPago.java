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

import Model.ModelPago;
import Model.ModelCompra;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author esneiderserna
 */
public class ControllerPago extends HttpServlet {
    private DAOPago dao;
    private static String CREAR_PAGO = "Pago/Crear.jsp";
    private static String MOSTRAR_COMPRA = "Compra/Listar.jsp";
    private static String MOSTRAR_CUOTA = "Pago/MostrarPago.jsp";
    private static String LISTAT_PAGOS = "Pago/Listar.jsp";
    
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
            String numero_tarjeta = request.getParameter("numero_tarjeta");
            buscarCompraXTarjeta(request, response, numero_tarjeta);
        } else if (opcion.equals("pagoCuota")) {
            int idCompra = Integer.parseInt(request.getParameter("idCompra"));
            infopagos(request, response, idCompra);
        } else if (opcion.equals("realizarPago")) {
            int idPago = Integer.parseInt(request.getParameter("idPago"));
            int valor_pago = Integer.parseInt(request.getParameter("valor_pago"));
            realizarPago(request, response, idPago, valor_pago);
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
    
    public void buscarCompraXTarjeta(HttpServletRequest request, HttpServletResponse response, String numero_tarjeta) throws SQLException, ServletException, IOException {
        
        RequestDispatcher vista = null;
        request.setAttribute("listShoppings", dao.getInfoToPay(numero_tarjeta));
        vista = request.getRequestDispatcher(MOSTRAR_COMPRA);
        vista.forward(request, response);
    }
    
    public void infopagos(HttpServletRequest request, HttpServletResponse response, int idCompra) throws SQLException, ServletException, IOException {
        
        // Traer la lista de pagos de la compra con este ID
        RequestDispatcher vista = null;
        request.setAttribute("pago_cuota", dao.getCuota(idCompra));
        vista = request.getRequestDispatcher(MOSTRAR_CUOTA);
        vista.forward(request, response);
    }
    
    public void realizarPago(HttpServletRequest request, HttpServletResponse response, int idPago, int valor_pago) throws SQLException, ServletException, IOException {
        
        // Traer la lista de pagos de la compra con este ID
        RequestDispatcher vista = null;
        dao.realizarPago(idPago, valor_pago);
        vista = request.getRequestDispatcher(LISTAT_PAGOS);
        vista.forward(request, response);
    }
}
