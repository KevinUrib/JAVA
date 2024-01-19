
package modelo;

/**
 *
 * @author Kevin Uribe
 */
public class Producto {
    private int id;
    private String nombres;
    private float precio;
    private int stock;
    private String estado;

    public Producto() {
    }

    public Producto(int id, String nombres, float precio, int stock, String estado) {
        this.id = id;
        this.nombres = nombres;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
