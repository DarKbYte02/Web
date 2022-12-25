
package escom.web.practicaservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "CrearProducto", urlPatterns = {"/CrearProducto"})
public class CrearProducto extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='utf-8'/>");
            out.println("<title>Crear Producto</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js' ></script>");
            out.println("<h1 class='text-center text-white'> Práctica Servlets y Base de Datos</h1>");
            out.println("</head>");
            out.println("<body style='background-color: rgb(44,48,52)'>");
            out.println("<div class='mb-3'></div>");
            out.println("<div class='container'>");
            out.println("<div class='card text-bg-dark mb-3'>");
            out.println("<div class='card-header text-center'>");
            out.println("<h2 class='card-title'> Crear producto </h2>");
            out.println("</div>");
            out.println("<div class='card-body text-dark'>");


            out.println("<form action='CrearP'>"
                    + "<div class='row g-3 align-items-center'>"
                    + "<div class='col-auto'>"
                    + "<label class='form-label' style='color: #FFFFFF; font-weight: bold;'>Nombre</label>"
                    + "</div>"
                    + "<div class='col-md-3'>"
                    + "<input type='text' name='nombreProducto' class='form-control' style='background-color: rgb(56,62,67); border-style: none; color: #FFFFFF' required/>"
                    + "</div>"
                    + "<div class='col-auto'>"
                    + "<label class='form-label' style='color: #FFFFFF; font-weight: bold;'>Cantidad</label>"
                    + "</div>"
                    + "<div class='col-md-1'>"
                    + "<input type='number' name='cantidadProducto' class='form-control' style='background-color: rgb(56,62,67); border-style: none; color: #FFFFFF' required/>"
                    + "</div>"
                    + "<div class='col-auto'>"
                    + "<label class='form-label' style='color: #FFFFFF; font-weight: bold;'>Precio</label>"
                    + "</div>"
                    + "<div class='col-md-1'>"
                    + "<input type='text' name='precioProducto' class = 'form-control' style='background-color: rgb(56,62,67); border-style: none; color: #FFFFFF' required/>"
                    + "</div>"
                    + "<div class='col-auto'>"
                    + "</div>"
                    + "<div class='col-md-4'>"
                    + "</div>"
                    + "<div class='col-auto'>"
                    + "<label class='form-label' style='color: #FFFFFF; font-weight: bold;'>Descripción</label>"
                    + "</div>"
                    + "<div class='col-md-7'>"
                    + "<input type='text' name='descripcionProducto' class = 'form-control' style='background-color: rgb(56,62,67); border-style: none; color: #FFFFFF' required/>"
                    + "</div>"
                    + "<div class='col-auto'>"
                    + "<label class='form-label' style='color: #FFFFFF; font-weight: bold;'>Categoría</label>"
                    + "</div>"
                    + "<div class='col-md-2'>");

            try {
                out.println("<select class='form-select ' name='idCategoria' id='idCategoria' style='background-color: rgb(56,62,67);border-style: none;  color: #FFFFFF; background-image: url(https://vivesmart.com/wp-content/uploads/2019/03/white-down-arrow-png-2.png)' required>");
                CategoriaDAO dao2 = new CategoriaDAO();
                List categorias = dao2.mostrarTodo();
                if(categorias != null){
                for (int i = 0; i < categorias.size(); i++) {
                    Categoria c2 = (Categoria) categorias.get(i);
                    out.println("<option value='" + c2.getIdCategoria() + "' name='idCategoria'>" + c2.getNombre() + "</option>");
                    
                }
                }
                out.println("</select>");
            } catch (SQLException ex) {
                Logger.getLogger(ActualizarProducto.class.getName()).log(Level.SEVERE, null, ex);
            }

            out.println(
                    "</div>"
                    + "<div class='col-md-3'>"
                    + "<button type='submit' class='btn btn-outline-success me-3'>Crear</button>"
                    + "<a class='btn btn-outline-danger' onclick='history.back()'>Cancelar</a>"
                    + "</div>"
                    + "</div>"
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
