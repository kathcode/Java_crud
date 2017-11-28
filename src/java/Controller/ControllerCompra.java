/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOCompra;
import DAO.DAOPago;
import DAO.DAOTarjetaXCliente;
import DAO.DAOTipoTarjeta;
import Model.ModelCompra;
import Model.ModelListProyeccion;
import Model.ModelPago;
import Model.ModelProyeccion;
import Model.ModelTarjetaXCliente;
import Model.ModelTipoTarjeta;
import Model.ModelgetDuesPaid;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *
 * @author esneiderserna
 */
public class ControllerCompra extends HttpServlet {

    private final DAOCompra DAO = new DAOCompra();
    private final String VIEW_LISTA = "Compra/Lista.jsp";
    private final String VIEW_PROYECCION = "Compra/Proyeccion.jsp";
    private final String VIEW_CREAR = "Compra/Crear.jsp";
    private final String VIEW_RESULTADO = "Compra/Resultado.jsp";
    private DecimalFormat twoDForm = new DecimalFormat("#.00");
    NumberFormat nf = NumberFormat.getInstance();
    private ModelCompra shopping;

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

        if (option == null) {
            if (request.getParameter("create") != null) {
                CreateShopping(request, response);
            }
            
            if(request.getParameter("search") != null)
            {
                SearchShoppingByIdUser(request, response);
            }

        } else {
            if (option.equals("listarCompras")) {
                ListShopping(request, response);
            }

            if (option.equals("proyeccion")) {
                Proyection(request, response);
            }
            
            if (option.equals("consultarCuotasPagadas")) {
                int id_compra = Integer.parseInt(request.getParameter("idCompra"));
                getDuesPaid(request, response, id_compra);
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

    private void ListShopping(HttpServletRequest request, HttpServletResponse response) {

        try {

            List<ModelCompra> listShoppings = DAO.ListShopping();
            request.setAttribute("listShoppings", listShoppings);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private void Proyection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            ModelCompra compra = DAO.DetailShopping(Integer.parseInt(request.getParameter("idCompra")));
            RequestDispatcher vista;

            ModelListProyeccion proyec = GenerateProyection(compra, false);

            request.setAttribute("proyec", proyec);
            vista = request.getRequestDispatcher(VIEW_PROYECCION);
            vista.forward(request, response);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private ModelListProyeccion GenerateProyection(ModelCompra compra, boolean newShopping) {

        try {

            DAOPago daoPago = new DAOPago();
            ModelListProyeccion proyection = new ModelListProyeccion();
            List<ModelPago> infoProyec = new LinkedList<>();

            int cuotas = compra.getNumeroCuotas_Compra();
            int valorCompra = compra.getDeudaInicial_Compra();
            double interes = compra.getInteres_Compra();
            int cuotaMensual = valorCompra / cuotas;
            int vSaldo = compra.getDeudaInicial_Compra();
            
            Calendar calendar = Calendar.getInstance();
            
            if(compra.getFecha_Compra() == null)
            {
                compra.setFecha_Compra(Calendar.getInstance().getTime());
            }


            proyection.setInfoCompra(compra);
            proyection.setCuota_Mensual(cuotaMensual);

            for (int i = 1; i <= cuotas; i++) {
                ModelPago m = new ModelPago();
                double vInteres = nf.parse(twoDForm.format(vSaldo * interes)).doubleValue();
                int nSaldo = vSaldo - cuotaMensual;
                double vCuota = cuotaMensual + vInteres;
                
                calendar.setTime(compra.getFecha_Compra());
                calendar.add(Calendar.MONTH, i);    
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                Date fechaPago = new Date(calendar.getTime().getTime());
                        
                m.setId_Pago(i);
                m.setFecha_de_Pago(fechaPago);
                m.setValor_Saldo(vSaldo);
                m.setAbono_Capital(cuotaMensual);
                m.setValor_Interes(vInteres);
                m.setNuevo_Saldo(nSaldo);
                m.setValor_Cuota(vCuota);
                m.setId_Compra(compra.getId_Compra());
                vSaldo = nSaldo;
                infoProyec.add(m);

                if (newShopping) {
                    m.setId_Pago(0);
                    m.setId_Compra(compra.getId_Compra());
                    m.setEstado_Pago(false);
                    daoPago.CreatePay(m);
                }

            }

            proyection.setInfoProyeccion(infoProyec);

            return proyection;

        } catch (ParseException e) {
        }
        
        return null;

    }

    private void CreateShopping(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            boolean error = false;
            DAOTarjetaXCliente daoTarjetaXC = new DAOTarjetaXCliente();
            DAOTipoTarjeta daoTipoTarjeta = new DAOTipoTarjeta();

            ModelCompra model = new ModelCompra();
            model.setId_Compra(0);
            model.setDescripcion_Compra(request.getParameter("Descripcion"));
            model.setNumero_TarjetaXCliente(request.getParameter("NoTarjeta"));
            model.setDeudaInicial_Compra(Integer.parseInt(request.getParameter("VCompra")));
            model.setDeudaActual_Compra(Integer.parseInt(request.getParameter("VCompra")));
            model.setNumeroCuotas_Compra(Integer.parseInt(request.getParameter("NCuotas")));

            request.setAttribute("idCliente", request.getParameter("IdClient"));
            request.setAttribute("modelCompra", model);

            //Consulta la tarjeta del cliente
            ModelTarjetaXCliente mTarjetaXC = daoTarjetaXC.GetInfoCard(model.getNumero_TarjetaXCliente());

            //Valida que exista una tarjata asignada al cliente con el numero
            if (mTarjetaXC != null) {

                //Consulta el tipo de tarjeta
                ModelTipoTarjeta mTipoTarjeta = daoTipoTarjeta.GetInfoTypeCard(mTarjetaXC.getCodigo_TipoTarjeta());
                // asigno el interes
                model.setInteres_Compra(mTipoTarjeta.getInteres_TipoTarjeta());

                //Valida que la tarjeta si pertenezca al cliente
                if (mTarjetaXC.getId_Usuario().equals(request.getParameter("IdClient"))) {

                    //Valida que el valor de la compra no sea superior al disponible
                    if (mTarjetaXC.getCupoDisp_TarjetaXCliente() >= model.getDeudaInicial_Compra() && model.getDeudaInicial_Compra() > 0) {

                        if (model.getNumeroCuotas_Compra() <= mTipoTarjeta.getPlazoMax_TipoTarjeta() && model.getNumeroCuotas_Compra() > 0) {
                            //Guarda la compra
                            int idShopping = DAO.CreateShopping(model);

                            model.setId_Compra(idShopping);
                            GenerateProyection(model, true);

                            //Actualiza el cupo disponible de la tarjeta
                            mTarjetaXC.setCupoDisp_TarjetaXCliente(mTarjetaXC.getCupoDisp_TarjetaXCliente() - model.getDeudaInicial_Compra());
                            daoTarjetaXC.UpdateInfoCard(mTarjetaXC);

                            //Muestra la proyeccion
                            response.sendRedirect("Compra?opcion=proyeccion&idCompra=" + idShopping);

                        } else {
                            request.setAttribute("errorMessage", "El numero de cuotas debe ser mayor a 0 e inferior o igual a " + mTipoTarjeta.getPlazoMax_TipoTarjeta());
                            error = true;
                        }

                    } else {
                        request.setAttribute("errorMessage", "Cupo insuficiente.");
                        error = true;
                    }

                } else {
                    request.setAttribute("errorMessage", "La tarjeta no pertece al cliente.");
                    error = true;
                }

            } else {
                request.setAttribute("errorMessage", "El número de la tarjeta no es valido.");
                error = true;
            }

            if (error) {
                request.getRequestDispatcher(VIEW_CREAR).forward(request, response);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    private void getDuesPaid(HttpServletRequest request, HttpServletResponse response, int id_compra) throws ServletException, IOException {
        try {
            DAOCompra compra = new DAOCompra();
            RequestDispatcher vista = null;
            
            request.setAttribute("listPays", compra.getDuesPaid(id_compra));

            vista = request.getRequestDispatcher("Compra/listarPagosRealizados.jsp");
            vista.forward(request, response);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void SearchShoppingByIdUser(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            
            List<ModelCompra> listShoppings = DAO.SearchShoppingByIdUser(request.getParameter("IdUsuario"));
            request.setAttribute("listShoppings", listShoppings);

            RequestDispatcher vista;
            vista = request.getRequestDispatcher(VIEW_RESULTADO);
            vista.forward(request, response);
            
        } catch (Exception e) {
        }
    
    }

}
