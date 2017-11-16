package Controller;

import DAO.DAOTarjetaXCliente;
import Model.ModelTarjetaXCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esneiderserna
 */
public class ControllerTarjetaXCliente extends HttpServlet {
    
    private final DAOTarjetaXCliente DAO = new DAOTarjetaXCliente();
    private final String VIEW_EDITAR = "TarjetaCliente/Editar.jsp"; 
    private final String VIEW_VER = "TarjetaCliente/Ver.jsp";
    private ModelTarjetaXCliente oldModel = new ModelTarjetaXCliente();

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
        
        String option = (String) request.getParameter("opcion");
        
        if(option == null)
        {
            if(request.getParameter("create") != null)
            {
                //CreateUser(request, response);
            }
            
        }
        else
        {
            if(option.equals("listarTarjetasCliente"))
            {
                ListCardXUser(request, response);
            }
            
            if(option.equals("edit") || option.equals("info"))
            {
                InfoCardXUser(request, response);
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

    private void ListCardXUser(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            
            List<ModelTarjetaXCliente> listCards = DAO.ListCards();
            request.setAttribute("listCards", listCards);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
    }

    private void InfoCardXUser(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            
            ModelTarjetaXCliente model = DAO.GetInfoCard(request.getParameter("noTarjeta"));
            RequestDispatcher vista;
            oldModel = model;
            request.setAttribute("oldModel", oldModel);
            
            if(request.getParameter("opcion").equals("edit")){             
                vista = request.getRequestDispatcher(VIEW_EDITAR);
            }
            else{
                vista = request.getRequestDispatcher(VIEW_VER);
            }
            
            vista.forward(request, response);
            
            
        } catch (IOException | SQLException | ServletException e) {
            System.out.println(e.getMessage());
        }
        
    }

}
