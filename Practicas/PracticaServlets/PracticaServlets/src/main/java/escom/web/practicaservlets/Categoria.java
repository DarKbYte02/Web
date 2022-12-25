package escom.web.practicaservlets;
import java.io.Serializable;
public class Categoria implements Serializable{
    private int idCategoria;
    private String nombre;
    private String descripcion;
    
    public Categoria(){
    
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
            @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("idProducto = ").append(getIdCategoria()).append("\n");
        sb.append("Nombre = ").append(getNombre()).append("\n");
        sb.append("Descripcion = ").append(getDescripcion()).append("\n");
        return sb.toString();
    }
}
