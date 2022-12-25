/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package escom.web.practicaservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet(name = "ActualizarCategoria", urlPatterns = {"/ActualizarCategoria"})
public class ActualizarCategoria extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='utf-8'/>");
            out.println("<title>Servlet CrearCategoria</title>");  
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js' ></script>");
            out.println("<h1 class='text-center text-white'> Práctica Servlets y Base de Datos</h1>");
            out.println("</head>");
            out.println("<body style='background-color: rgb(44,48,52)'>");
             out.println("<div class='mb-3'></div>");
            out.println("<div class='container'>");
            out.println("<div class='card text-bg-dark mb-3'>");
            out.println("<div class='card-header text-center'>");
            out.println("<h2 class='card-title'> Modificar categoría </h2>");
            out.println("</div>");
            out.println("<div class='card-body text-dark'>");
            
            String id = request.getParameter("id");
            CategoriaDAO dao = new CategoriaDAO();
            Categoria c = new Categoria();
            c.setIdCategoria(Integer.parseInt(id));
            try {
                c = dao.mostrarUno(c);
                String nombreCat = c.getNombre();
                String descripCat = c.getDescripcion();
            } catch (SQLException ex) {
                Logger.getLogger(ActualizarCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
                                        
            out.println("<form action='ActualizarC'>"
                    + "<div class='row g-3 align-items-center'>"
                    + "<div class='col-auto'>"
                    + "<label class='form-label' style='color: #FFFFFF; font-weight: bold;'>idCategoria</label>"
                    + "</div>"
                    + "<div class='col-auto'>"
                    + "<input type='text' id='idCategoria' class = 'form-control' name= 'idCategoria' placeholder='id' style='background-color: rgb(56,62,67); border-style: none; color: #FFFFFF'"+"value='"+id+"'"+" readonly/>"
                    + "</div>"
                    + "<div class='col-auto'>"
                    + "<label class='form-label' style='color: #FFFFFF; font-weight: bold;'>Nombre</label>"
                    + "</div>"
                    + "<div class='col-auto'>"
                    + "<input type='text' id='nombre' class = 'form-control' name= 'nombre' placeholder='Ingrese el nombre de la categoría' style='background-color: rgb(56,62,67); border-style: none; color: #FFFFFF'"+"value='"+c.getNombre()+"' required/>"
                    + "</div>"
                    + "<div class='mb-3'>"
                    + "<label class='form-label' style='color: #FFFFFF; font-weight: bold;'>Descripción</label>"
                    + "<input type='text' id='descripcion' class = 'form-control' name= 'descripcion' placeholder='Ingrese la descripción' style='background-color: rgb(56,62,67); border-style: none; color: #FFFFFF'"+"value='"+c.getDescripcion()+"'"+"required/>"
                    + "</div>"
                    + "</div>"
                    + "<button type='submit' class='btn btn-outline-success me-3'>Actualizar</button>"
                    + "<a class='btn btn-outline-danger' href='/PracticaServlets/CRUD_Categorias'>Cancelar</a>"
                    + "</form>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
