/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOFranquicia;
import DAO.DAOTipoTarjeta;
import Model.ModelFranquicias;
import Model.ModelTipoTarjeta;
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
 * @author esneider.serna
 */
public class ControllerTipoTarjeta extends HttpServlet {
    
    private final DAOTipoTarjeta DAO = new DAOTipoTarjeta();
    private final String VIEW_LISTA = "Tarjeta/Lista.jsp";
    private final String VIEW_RESULTADO = "Tarjeta/Resultado.jsp";
    private final String VIEW_EDITAR = "Tarjeta/Editar.jsp";
    private final String VIEW_CREAR = "Tarjeta/Crear.jsp";
    private final String VIEW_VER = "Tarjeta/Ver.jsp";
    private ModelTipoTarjeta oldTarjeta;
    
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
            if (request.getParameter("create") != null) {
                CreateTarjeta(request, response);
            }
            
            if (request.getParameter("search") != null) {
                SearchTarjeta(request, response);
            }
            
            if(request.getParameter("update") != null)
            {
                Update(request, response);
            }
        }
        else
        {
            if(option.equals("listarTipoTarjeta"))
            {
                ListTipoTarjeta(request, response);
            }
            
            if (option.equals("edit") || option.equals("info")) {
                InfoTarjeta(request, response);
            }

            if (option.equals("delete")) {
                DeleteTarjeta(request, response);
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

    private void ListTipoTarjeta(HttpServletRequest request, HttpServletResponse response) {
        
        try {   

            List<ModelTipoTarjeta> listTipoTarjeta = DAO.ListTipoTarjeta();
            request.setAttribute("listTipoTarjeta", listTipoTarjeta);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void InfoTarjeta(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {

            ModelTipoTarjeta Tarjeta = DAO.GetInfoTypeCard(Integer.parseInt(request.getParameter("Codigo_TipoTarjeta")));
            RequestDispatcher vista;
            oldTarjeta = Tarjeta;
            request.setAttribute("oldTarjeta", Tarjeta);

            if (request.getParameter("opcion").equals("edit")) {
                vista = request.getRequestDispatcher(VIEW_EDITAR);
            } else {
                vista = request.getRequestDispatcher(VIEW_VER);
            }

            vista.forward(request, response);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    


    private void SearchTarjeta(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {

            List<ModelTipoTarjeta> listTarjeta;
            listTarjeta = DAO.SearchByCodigoId(Integer.parseInt(request.getParameter("Codigo_TipoTarjeta")));
            request.setAttribute("listTipoTarjeta", listTarjeta);

            RequestDispatcher vista;
            vista = request.getRequestDispatcher(VIEW_RESULTADO);
            vista.forward(request, response);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private void CreateTarjeta(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    
        try {

            boolean tarjeta = DAO.ValidateByCodigoId(Integer.parseInt(request.getParameter("Codigo_TipoTarjeta")));
            
            ModelTipoTarjeta newTarjeta = new ModelTipoTarjeta();
                newTarjeta.setCodigo_TipoTarjeta(Integer.parseInt(request.getParameter("Codigo_TipoTarjeta")));
                newTarjeta.setNombre_TipoTarjeta(request.getParameter("Nombre_TipoTarjeta"));
                newTarjeta.setAcronimo_TipoTarjeta(request.getParameter("Acronimo_TipoTarjeta"));
                newTarjeta.setInteres_TipoTarjeta(Double.parseDouble(request.getParameter("Interes_TipoTarjeta")));
                newTarjeta.setPlazoMax_TipoTarjeta(Integer.parseInt(request.getParameter("PlazoMax_TipoTarjeta")));
                newTarjeta.setCupoMax_TipoTarjeta(Double.parseDouble(request.getParameter("CupoMax_TipoTarjeta")));
                newTarjeta.setMulta_TipoTarjeta(Integer.parseInt(request.getParameter("Multa_TipoTarjeta")));
                newTarjeta.setCodigo_Franquicia(Integer.parseInt(request.getParameter("Codigo_Franquicia")));
            
            if (!tarjeta) {
                
                DAOFranquicia df = new DAOFranquicia();
                ModelFranquicias mf = df.getFranquiciaByid(Integer.parseInt(request.getParameter("Codigo_Franquicia")));

                if(newTarjeta.getCodigo_TipoTarjeta()>= mf.getRangoPingMin_Franquicia() && newTarjeta.getCodigo_TipoTarjeta() <= mf.getRangoPingMax_Franquicia()){
                  
                    DAO.CreateTarjeta(newTarjeta);
                    response.sendRedirect(VIEW_LISTA);
                    
                }else{
                    request.setAttribute("newTarjeta", newTarjeta);
                    request.setAttribute("errorMessage","El codigo de la tarjeta debe estar entre: " + mf.getRangoPingMin_Franquicia() + " - " + mf.getRangoPingMax_Franquicia());
                    request.getRequestDispatcher(VIEW_CREAR).forward(request, response);
                }
                
            } else {
                
                request.setAttribute("newTarjeta", newTarjeta);
                request.setAttribute("errorMessage","Ya existe una tarjeta con el codigo ingresado.");
                request.getRequestDispatcher(VIEW_CREAR).forward(request, response);
            }
            
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void Update(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            
            ModelTipoTarjeta newTarjeta = new ModelTipoTarjeta();
            newTarjeta.setCodigo_TipoTarjeta(Integer.parseInt(request.getParameter("Codigo_TipoTarjeta")));
            newTarjeta.setNombre_TipoTarjeta(request.getParameter("Nombre_TipoTarjeta"));
            newTarjeta.setAcronimo_TipoTarjeta(request.getParameter("Acronimo_TipoTarjeta"));
            newTarjeta.setInteres_TipoTarjeta(Double.parseDouble(request.getParameter("Interes_TipoTarjeta")));
            newTarjeta.setPlazoMax_TipoTarjeta(Integer.parseInt(request.getParameter("PlazoMax_TipoTarjeta")));
            newTarjeta.setCupoMax_TipoTarjeta(Double.parseDouble(request.getParameter("CupoMax_TipoTarjeta")));
            newTarjeta.setMulta_TipoTarjeta(Integer.parseInt(request.getParameter("Multa_TipoTarjeta")));
            newTarjeta.setCodigo_Franquicia(Integer.parseInt(request.getParameter("Codigo_Franquicia")));

            DAO.UpdateTarjeta(oldTarjeta, newTarjeta);
            response.sendRedirect(VIEW_LISTA);
            
        } catch (Exception e) {
        }
    
    }

    private void DeleteTarjeta(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            DAO.DeleteTarjeta(Integer.parseInt(request.getParameter("Codigo_TipoTarjeta")));
            response.sendRedirect(VIEW_LISTA);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
