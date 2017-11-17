/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOUsuario;
import Model.ModelUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esneider.serna
 */
public class ControllerUsuario extends HttpServlet {
    
    private final DAOUsuario DAO = new DAOUsuario();
    private final String VIEW_LISTA = "Usuario/Lista.jsp";    
    private final String VIEW_RESULTADO = "Usuario/Resultado.jsp";
    private final String VIEW_EDITAR = "Usuario/Editar.jsp";
    private final String VIEW_CREAR = "Usuario/Crear.jsp";    
    private final String VIEW_VER = "Usuario/Ver.jsp";
    private ModelUsuario oldUser;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String option = (String) request.getParameter("opcion");
        
        if(option == null)
        {
            if(request.getParameter("create") != null)
            {
                CreateUser(request, response);
            }
            
            if(request.getParameter("search") != null)
            {
                SearchUser(request, response);
            }
            
            if(request.getParameter("update") != null)
            {
                Update(request, response);
            }
        }
        else
        {
            if(option.equals("listarUsuarios"))
            {
                ListUsers(request, response);
            }
            
            if(option.equals("edit") || option.equals("info"))
            {
                InfoUser(request, response);
            }
            
            if(option.equals("delete"))
            {
                DeleteUser(request, response);
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

    protected void CreateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
    {
        
        try {
            
            boolean user = DAO.ValidateByDocumentId(request.getParameter("Identificacion"));

            if(!user)
            {
                ModelUsuario newUser = new ModelUsuario();
                newUser.setId_Usuario(request.getParameter("Identificacion"));        
                newUser.setNombre_Usuario(request.getParameter("Nombre"));  
                newUser.setApellidos_Usuario(request.getParameter("Apellidos"));
                newUser.setTelefono_Usuario(request.getParameter("Telefono"));
                newUser.setDireccion_Usuario(request.getParameter("Direccion"));
                newUser.setEmail_Usuario(request.getParameter("Email"));
                newUser.setGenero_Usuario(request.getParameter("Genero"));
                newUser.setUsuario_Usuario(request.getParameter("Usuario"));
                newUser.setPassword_Usuario(request.getParameter("Password"));
                newUser.setId_TipoUsuario(Integer.parseInt(request.getParameter("TipoUsuario")));

                DAO.CreateUser(newUser);
                response.sendRedirect(VIEW_LISTA);

            }
            else
            {
                request.setAttribute("errorMessage", "Ya existe un usuario registrado con la misma identificación.");
                request.getRequestDispatcher(VIEW_CREAR).forward(request, response);

            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    protected void ListUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {

            List<ModelUsuario> listUsers = DAO.ListUsers();
            request.setAttribute("listUsers", listUsers);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    

    private void InfoUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
    {
        
        try {
            
            ModelUsuario user = DAO.InfoUser(request.getParameter("idUsuario"));
            RequestDispatcher vista;
            oldUser = user;
            request.setAttribute("oldUser", user);
            
            if(request.getParameter("opcion").equals("edit")){             
                vista = request.getRequestDispatcher(VIEW_EDITAR);
            }
            else{
                vista = request.getRequestDispatcher(VIEW_VER);
            }
            
            vista.forward(request, response);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    

    }

    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException 
    {
        
        try {
            
            ModelUsuario newUser = new ModelUsuario();
            newUser.setId_Usuario(request.getParameter("Identificacion"));        
            newUser.setNombre_Usuario(request.getParameter("Nombre"));  
            newUser.setApellidos_Usuario(request.getParameter("Apellidos"));
            newUser.setTelefono_Usuario(request.getParameter("Telefono"));
            newUser.setDireccion_Usuario(request.getParameter("Direccion"));
            newUser.setEmail_Usuario(request.getParameter("Email"));
            newUser.setGenero_Usuario(request.getParameter("Genero"));
            newUser.setUsuario_Usuario(request.getParameter("Usuario"));
            newUser.setPassword_Usuario(request.getParameter("Password"));
            newUser.setId_TipoUsuario(Integer.parseInt(request.getParameter("TipoUsuario")));

            DAO.UpdateUser(oldUser, newUser);
            response.sendRedirect(VIEW_LISTA);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    private void DeleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException 
    {
        try {

            DAO.DeleteUser(request.getParameter("idUsuario"));
            response.sendRedirect(VIEW_LISTA);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
          
    }

    private void SearchUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
    {
        
         try {

            List<ModelUsuario> listUsers;
            listUsers = DAO.SearchByDocumentId(request.getParameter("IdUsuario"));            
            request.setAttribute("listUsers", listUsers);

            RequestDispatcher vista;
            vista = request.getRequestDispatcher(VIEW_RESULTADO);
            vista.forward(request, response);
         
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

}
