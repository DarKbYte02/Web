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
public class CategoriaDAO {
        private static final String SQL_INSERTAR
            = "insert into Categoria(nombre,descripcion) values (?, ?)";
    private static final String SQL_UPDATE
            = "update Categoria set nombre = ?, descripcion = ? where idCategoria =?";
    private static final String SQL_DELETE = "delete from Categoria where idCategoria =?";
    private static final String SQL_SELECT = "select * from Categoria where idCategoria =?";
    private static final String SQL_SELECT_ALL = "select * from Categoria";
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
        
        public void insertarCategoria(Categoria c) throws SQLException {
        PreparedStatement ps = null;
        obtenerConexion();
        try {
            ps = con.prepareStatement(SQL_INSERTAR);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
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
        
        public void actualizarCategoria(Categoria c) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.setInt(3, c.getIdCategoria());
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
        
    public void eliminarCategoria(Categoria c) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, c.getIdCategoria());
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
            if (resultados.size() > 0) {
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
 
        public Categoria mostrarUno(Categoria c) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, c.getIdCategoria());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (Categoria) resultados.get(0);
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
            Categoria c = new Categoria();
            c.setIdCategoria(rs.getInt("idCategoria"));
            c.setNombre(rs.getString("nombre"));
            c.setDescripcion(rs.getString("descripcion"));
            resultados.add(c);
        }
        return resultados;
    }

        public static void main(String[] args) {
        Categoria c = new Categoria();
        c.setIdCategoria(4);
        
        c.setNombre("Electrónicos");
        c.setDescripcion("Aparatos electrónicos");
         
        CategoriaDAO dao = new CategoriaDAO();
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
