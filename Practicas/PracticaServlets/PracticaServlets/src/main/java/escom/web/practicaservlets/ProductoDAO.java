package escom.web.practicaservlets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
public class ProductoDAO {
    private static final String SQL_INSERTAR
            = "insert into Producto(nombreProducto,descripcionProducto,existencia,precio,idCategoria) values (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE
            = "update Producto set nombreProducto = ?, descripcionProducto = ?, existencia = ?, precio = ?, idCategoria = ? where idProducto = ?";
    private static final String SQL_DELETE = "delete from Producto where idProducto =?";
    private static final String SQL_SELECT = "select * from Producto where idProducto =?";
    private static final String SQL_SELECT1 = "select * from Producto where idCategoria =?";
    private static final String SQL_SELECT_ALL = "select * from Producto";
    private Connection con;
    
        private void obtenerConexion() {
        String usuario = "root";
        String clave = "root";
        String url = "jdbc:mysql://localhost:3306/PracticaServlets";
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
        public void insertarProducto(Producto c) throws SQLException {
        PreparedStatement ps = null;
        obtenerConexion();
        try {
            ps = con.prepareStatement(SQL_INSERTAR);
            ps.setString(1, c.getNombreProducto());
            ps.setString(2, c.getDescripcionProducto());
            ps.setInt(3,c.getExistencia());
            ps.setDouble(4,c.getPrecio());
            ps.setInt(5,c.getIdCategoria());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
        
        public void actualizarProducto(Producto c) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, c.getNombreProducto());
            ps.setString(2, c.getDescripcionProducto());
            ps.setInt(3,c.getExistencia());
            ps.setDouble(4,c.getPrecio());
            ps.setInt(5,c.getIdCategoria());
            ps.setInt(6,c.getIdProducto());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
        
    public void eliminarProducto(Producto c) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, c.getIdProducto());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public List mostrarTodo() throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (!resultados.isEmpty()) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
        public List mostrarVarios(Producto c) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(SQL_SELECT1);
            ps.setInt(1, c.getIdProducto());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (!resultados.isEmpty()) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    
        public Producto mostrarUno(Producto c) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, c.getIdProducto());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (Producto) resultados.get(0);
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while (rs.next()) {
            Producto c = new Producto();
            c.setIdProducto(rs.getInt("idProducto"));
            c.setNombreProducto(rs.getString("nombreProducto"));
            c.setDescripcionProducto(rs.getString("descripcionproducto"));
            c.setExistencia(rs.getInt("existencia"));
            c.setPrecio(rs.getDouble("precio"));
            c.setIdCategoria(rs.getInt("idCategoria"));
            resultados.add(c);
        }
        return resultados;
    }
      
            public static void main(String[] args) {
        Producto c = new Producto();
        c.setIdProducto(18);
         
        ProductoDAO dao = new ProductoDAO();
        try {
            //dao.insertarCarrera(c);
            //dao.actualizarCategoria(c);
            //dao.eliminarCarrera(c);
            System.out.println(dao.mostrarUno(c));
            //System.out.println(dao.mostrarUno(c));
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
