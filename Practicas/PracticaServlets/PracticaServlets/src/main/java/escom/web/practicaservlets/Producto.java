package escom.web.practicaservlets;

import java.io.Serializable;

public class Producto implements Serializable{
    private int idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private int existencia;
    private double precio;
    private int idCategoria;
    
    public Producto(){
        
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
        @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("idProducto = ").append(getIdProducto()).append("\n");
        sb.append("Nombre = ").append(getNombreProducto()).append("\n");
        sb.append("Descripcion = ").append(getDescripcionProducto()).append("\n");
        sb.append("Existencia = ").append(getExistencia()).append("\n");
        sb.append("Precio= ").append(getPrecio()).append("\n");
        sb.append("Categoria= ").append(getIdCategoria()).append("\n");
        return sb.toString();
    }
}
