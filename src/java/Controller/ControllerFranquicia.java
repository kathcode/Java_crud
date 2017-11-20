/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOFranquicia;
import Model.ModelFranquicias;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerFranquicia extends HttpServlet {
    
    private static String LISTA_FRANQUICIA = "Franquicia/listarFranquicia.jsp";
    private static String CREAR_FRANQUICIA = "Franquicia/crearFranquicia.jsp";
    private static String EDITAR_FRANQUICIA = "Franquicia/editarFranquicia.jsp";
    private static String VER_FRANQUICIA = "Franquicia/verFranquicia.jsp";
    private DAOFranquicia dao;
    private ModelFranquicias oldFranquicia;
    private Integer CodigoFranquicia = 12;
    Calendar calendar = Calendar.getInstance();
    
    public ControllerFranquicia() {
        super();
        dao = new DAOFranquicia();
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
        
        if (opcion != null) {
            System.out.println("El valor de la opcion es " + opcion);
            if (opcion.equals("listarFranquicia")) {
                try {
                    request.setAttribute(opcion, dao.getFranquicias());
                    forward = LISTA_FRANQUICIA;
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerFranquicia.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (opcion.equals("crearFranquicia")) {
                forward = CREAR_FRANQUICIA;
                crearFranquicia(request, response);
            } else if (opcion.equals("eliminarFranquicia")) {
                int franquiciaId = Integer.parseInt(request.getParameter("idfranquicia"));
                dao.eliminarFranquicia(franquiciaId);
                response.sendRedirect(LISTA_FRANQUICIA);
            } else if (opcion.equals("actualizarFranquicias")) {
                actualizarFranquicia(request, response);
            } else {
                getFranquiciaById(request, response);
            }
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
            Logger.getLogger(ControllerUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControllerUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    protected void crearFranquicia(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
    {
        Integer codigo = CodigoFranquicia + 1;
        String nombre = request.getParameter("nombre");
        String acronimo = request.getParameter("acronimo");
        int max = Integer.parseInt(request.getParameter("max"));
        int min = Integer.parseInt(request.getParameter("min"));
        java.sql.Date fecha_creacion = new java.sql.Date(calendar.getTime().getTime());
        
        Model.ModelFranquicias franquicia = new Model.ModelFranquicias(codigo, nombre, acronimo, max, min, fecha_creacion);
        
        dao.validateRango(max, min);
        
        dao.crearFranquicia(franquicia);
     
        response.sendRedirect(LISTA_FRANQUICIA);
    }
    
    private void actualizarFranquicia(HttpServletRequest request, HttpServletResponse response) throws IOException 
    {
        try {
            String nombre = request.getParameter("nombre");
            String acronimo = request.getParameter("acronimo");
            int max = Integer.parseInt(request.getParameter("max"));
            int min = Integer.parseInt(request.getParameter("min"));
            java.sql.Date fecha_creacion = new java.sql.Date(calendar.getTime().getTime());

            Model.ModelFranquicias franquicia = new Model.ModelFranquicias(null, nombre, acronimo, max, min, fecha_creacion);
        

            dao.actualizarFranquicia(oldFranquicia, franquicia);
            response.sendRedirect(LISTA_FRANQUICIA);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void getFranquiciaById(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
    {
        
        try {
            int idFranquicia = Integer.parseInt(request.getParameter("idfranquicia"));
            Model.ModelFranquicias franquicia = dao.getFranquiciaByid(idFranquicia);
            RequestDispatcher vista = null;
            oldFranquicia = franquicia;
            request.setAttribute("oldFranquicia", franquicia);
            
            if(request.getParameter("opcion").equals("editarFranquicia")){
                vista = request.getRequestDispatcher(EDITAR_FRANQUICIA);
            } else {
                vista = request.getRequestDispatcher(VER_FRANQUICIA);
            }
            
            vista.forward(request, response);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    

    }
}
