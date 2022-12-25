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

@WebServlet(name = "MostrarCategoria", urlPatterns = {"/MostrarCategoria"})
public class MostrarCategoria extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CRUD de Productos</title>");            
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js' ></script>");
            out.println("<script>var perfEntries = performance.getEntriesByType(\"navigation\");\n" +
"\n" +
"if (perfEntries[0].type === \"back_forward\") {\n" +
"    location.reload(true);\n" +
"}</script>");
            out.println("<h1 class='text-center text-white'> Práctica Servlets y Base de Datos</h1>");
            out.println("</head>");
            out.println("<body style='background-color: rgb(44,48,52)'>");
            out.println("<div class='container'>");
            out.println("<div class='text-bg-dark mb-3'></div>");
            out.println("<div class='card text-bg-dark mb-3'>");
            out.println("<div class='card-header text-center text-primary'>");
            out.println("<h2 class='card-title text-bg-dark'> Listado de Productos por categoría</h2>");
            out.println("</div>");
            out.println("<div class='card-body text-primary'>");
            out.println("<table class='table table-dark table-striped'>");
            out.println("<tr>");
            out.println("<th> idProducto </th>");
            out.println("<th> Categoria </th>");
            out.println("<th> Nombre </th>");
            out.println("<th> Acciones </th>");
            out.println("</tr>");
            
            ProductoDAO dao = new ProductoDAO();
            Producto producto = new Producto();
            int id = Integer.parseInt(request.getParameter("id"));
            producto.setIdProducto(id);
            try {
                List lista = dao.mostrarVarios(producto);
                    if(lista != null){ 
                    for(int i=0;i<lista.size();i++){
                    Producto c = (Producto) lista.get(i);
                    out.println("<tr>");
                    out.println("<td>");
                    out.println("<a href='MostrarProducto?id="+c.getIdProducto()+"'class='btn btn-outline-primary'>"+c.getIdProducto()+"</a>");
                    out.println("</td>");
                    
                    CategoriaDAO dao1 = new CategoriaDAO();
                    Categoria c1 = new Categoria();
                    c1.setIdCategoria(c.getIdCategoria());
                    
                    c1 = dao1.mostrarUno(c1);
                    
                    out.println("<td>"+c1.getNombre()+"</td>");
                    out.println("<td>"+c.getNombreProducto()+"</td>");
                    out.println("<td>");
                    out.println("<a href='EliminarProducto?id="+c.getIdProducto()+"'class='btn btn-outline-danger me-3'>Eliminar</a>");
                    out.println("<a href='ActualizarProducto?id="+c.getIdProducto()+"'class='btn btn-outline-info'>Actualizar</a>");
                    out.println("</td>");
                    out.println("</tr>");
                }
            }
            } catch (SQLException ex) {
                Logger.getLogger(CRUD_Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            out.println("</table>");
            out.println("<a href='CrearProducto' class='btn btn-outline-success me-3'>Crear producto</a>");
            out.println("<a href='/PracticaServlets/CRUD_Categorias' class='btn btn-outline-warning'>Regresar</a>");
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
