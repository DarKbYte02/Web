
package escom.web.practicaservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ActualizarP", urlPatterns = {"/ActualizarP"})
public class ActualizarP extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='utf-8'/>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js' ></script>");
            out.println("<title>ActualizarC</title>");
            out.println("<h1 class='text-center text-white'> Práctica Servlets y Base de Datos</h1>");
            out.println("</head>");
            out.println("<body style='background-color: rgb(44,48,52)'>");
            
            int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            String nombreProducto = request.getParameter("nombreProducto");
            int cantidadProducto = Integer.parseInt(request.getParameter("cantidadProducto"));
            double precioProducto = Double.parseDouble(request.getParameter("precioProducto"));
            String descripcionProducto = request.getParameter("descripcionProducto");
            
            /*
            out.println(idCategoria);
            out.println(idProducto);
            out.println(nombreProducto);
            out.println(cantidadProducto);
            out.println(precioProducto);
            out.println(descripcionProducto);
            */
           
            ProductoDAO dao = new ProductoDAO();
            Producto c = new Producto();
            
            c.setDescripcionProducto(descripcionProducto);
            c.setExistencia(cantidadProducto);
            c.setIdCategoria(idCategoria);
            c.setIdProducto(idProducto);
            c.setNombreProducto(nombreProducto);
            c.setPrecio(precioProducto);
            
            try {
                dao.actualizarProducto(c);
            } catch (SQLException ex) {
                Logger.getLogger(ActualizarP.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            out.println("<center>");
            out.println("<div class='container'>");
            out.println("<div class='card text-bg-dark mb-3' style='max-width: 21rem;'>");
            out.println("<h5 class='card-header'>Actualización realizada con éxito</h5>");
            out.println("<div class='card-body'>");
            out.println("<p class='card-text text-start'>La modificación al producto se realizó con éxito.</p>");
            out.println("<div class='d-grid gap-2'>");
            out.println(" <script> function goBack() { window.history.go(-2);} </script>");
            out.println("<a class='btn btn-outline-warning' onclick='goBack()'>Regresar</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</center>");
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
