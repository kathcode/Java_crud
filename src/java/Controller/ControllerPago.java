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
import Model.ModelTarjetaXCliente;
import Model.ModelTipoTarjeta;
import java.sql.Date;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author esneiderserna
 */
public class ControllerPago extends HttpServlet {
    private DAOPago dao;
    private static String CREAR_PAGO = "Pago/Crear.jsp";
    private static String MOSTRAR_COMPRA = "Pago/Lista.jsp";
    private static String MOSTRAR_CUOTA = "Pago/MostrarPago.jsp";
    
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
        
        String opcion = (String) request.getParameter("opcion");
        
        if (opcion.equals("buscarPago")) {
            String numero_tarjeta = request.getParameter("numero_tarjeta");
            buscarCompraXTarjeta(request, response, numero_tarjeta);
        } else if (opcion.equals("pagoCuota")) {
            int idCompra = Integer.parseInt(request.getParameter("idCompra"));
            infopagos(request, response, idCompra);
        } else if (opcion.equals("realizarPago")) {
            realizarPago(request, response);
        } else if(opcion.equals("pagoTotal")){
            infoPagoTotal(request, response);
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
        
        DAOTarjetaXCliente daoTxc = new DAOTarjetaXCliente();
        ModelTarjetaXCliente modelTxc = daoTxc.GetInfoCard(numero_tarjeta);
        
        if(modelTxc != null)
        {
            List<ModelCompra>  listShoppings = dao.getInfoToPay(numero_tarjeta);
            RequestDispatcher vista = null;
            request.setAttribute("listShoppings", listShoppings);
            vista = request.getRequestDispatcher(MOSTRAR_COMPRA);
            vista.forward(request, response);
        }else{
            request.setAttribute("numero", numero_tarjeta);           
            request.setAttribute("errorMessage", "No existe ninguna tarjeta con el número ingresado.");
            request.getRequestDispatcher(CREAR_PAGO).forward(request, response);
        }
        
        
    }
    
    public void infopagos(HttpServletRequest request, HttpServletResponse response, int idCompra) throws SQLException, ServletException, IOException {
        
         //Trae la cuota a pagar
        ModelPago cuota = dao.getCuota(idCompra);
        List<ModelPago> listCuotas = new LinkedList<>();
        
        if(cuota != null){
            
            Calendar calendar = Calendar.getInstance();
            Date fecha_actual = new Date(calendar.getTime().getTime());

            if(fecha_actual.after(cuota.getFecha_de_Pago())){
         
                //Traigo la info de la compra para obtener el id del txc
                DAOCompra daoCompra = new DAOCompra();
                ModelCompra compra = daoCompra.DetailShopping(cuota.getId_Compra());

                //Traigo la info de txc pa obtener el id del tipo tarjeta
                DAOTarjetaXCliente daoTxc = new DAOTarjetaXCliente();
                ModelTarjetaXCliente txc = daoTxc.GetInfoCard(compra.getNumero_TarjetaXCliente());   
                
                //Traigo la info de tt para obtener el valor de la multa
                DAOTipoTarjeta daoTipoT = new DAOTipoTarjeta();
                ModelTipoTarjeta tt = daoTipoT.GetInfoTypeCard(txc.getCodigo_TipoTarjeta());
                
                cuota.setMulta_Mora(tt.getMulta_TipoTarjeta());
                double nuevaCuota = cuota.getValor_Cuota() + cuota.getMulta_Mora();
                cuota.setValor_Cuota(nuevaCuota);
                
            }else{
                cuota.setMulta_Mora(0);
            }

            listCuotas.add(cuota);
        
        }
        
        request.setAttribute("listCuotas", listCuotas);
        RequestDispatcher vista = null;
        vista = request.getRequestDispatcher(MOSTRAR_CUOTA);
        vista.forward(request, response);
    }
    
    public void realizarPago(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        

        try {
            
            int valorPago = 0;
            Boolean isTotal = Boolean.valueOf(request.getParameter("pagoTotal"));
            //Traigo la info de la primera cuota
            ModelPago pago = dao.SearchPayById(Integer.parseInt(request.getParameter("idPago")));
            
            if(isTotal){
                
                List<ModelPago> listCuotas = dao.GetCuotas(pago.getId_Compra());
                
                for (ModelPago cuota : listCuotas) {
                    
                    //Actualizo el estado del pago
                    cuota.setEstado_Pago(true);
                    dao.UpdatePay(cuota);
                    //Sumo el valor del abono a capital
                    valorPago += cuota.getAbono_Capital();
                }
            
            }else{
                
                //Actualizo el estado del pago
                pago.setEstado_Pago(true);
                dao.UpdatePay(pago);
                //Sumo el valor del abono a capital
                valorPago = pago.getAbono_Capital();
            }
            
            //Traigo la info de la compra para obtener el id del txc
            DAOCompra daoCompra = new DAOCompra();
            ModelCompra compra = daoCompra.DetailShopping(pago.getId_Compra());
            
            //Traigo la info de txc para actualizar el cupo disponible
            DAOTarjetaXCliente daoTxc = new DAOTarjetaXCliente();
            ModelTarjetaXCliente txc = daoTxc.GetInfoCard(compra.getNumero_TarjetaXCliente());   
            txc.setCupoDisp_TarjetaXCliente(txc.getCupoDisp_TarjetaXCliente() + valorPago);
            daoTxc.UpdateInfoCard(txc);
 

            RequestDispatcher vista = null;
            vista = request.getRequestDispatcher(CREAR_PAGO);
            vista.forward(request, response);
            
        } catch (IOException | NumberFormatException | ServletException e) {
            System.out.println(e.getMessage());
        }
        
        
    }

    private void infoPagoTotal(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            
            List<ModelPago> listCuotas = dao.GetCuotas(Integer.parseInt(request.getParameter("idCompra")));
            Calendar calendar = Calendar.getInstance();
            Date fecha_actual = new Date(calendar.getTime().getTime());
            
            for (ModelPago cuota : listCuotas) {

                if(fecha_actual.after(cuota.getFecha_de_Pago())){
                    
                    //Traigo la info de la compra para obtener el id del txc
                    DAOCompra daoCompra = new DAOCompra();
                    ModelCompra compra = daoCompra.DetailShopping(cuota.getId_Compra());

                    //Traigo la info de txc pa obtener el id del tipo tarjeta
                    DAOTarjetaXCliente daoTxc = new DAOTarjetaXCliente();
                    ModelTarjetaXCliente txc = daoTxc.GetInfoCard(compra.getNumero_TarjetaXCliente());   

                    //Traigo la info de tt para obtener el valor de la multa
                    DAOTipoTarjeta daoTipoT = new DAOTipoTarjeta();
                    ModelTipoTarjeta tt = daoTipoT.GetInfoTypeCard(txc.getCodigo_TipoTarjeta());
                    
                    cuota.setMulta_Mora(tt.getMulta_TipoTarjeta());
                    double nuevaCuota = cuota.getValor_Cuota() + cuota.getMulta_Mora();
                    cuota.setValor_Cuota(nuevaCuota);
                    
                }else{
                    cuota.setMulta_Mora(0);
                }
            }

            request.setAttribute("listCuotas", listCuotas);
            RequestDispatcher vista = null;
            vista = request.getRequestDispatcher(MOSTRAR_CUOTA);
            vista.forward(request, response);
  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
