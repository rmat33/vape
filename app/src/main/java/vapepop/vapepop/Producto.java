package vapepop.vapepop;

import java.util.Date;

/**
 * Created by USER on 07/05/2018.
 */

public class Producto {
    private String descripcion;
    private String tipo;
    private String precioventa;
    private String formaenvio;
    private String provincia;
    private String email;
    private String whatsapp;
    private String fecha;

    public Producto(String descripcion, String tipo, String precioventa, String formaenvio, String provincia, String email, String whatsapp, String fecha) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.precioventa = precioventa;
        this.formaenvio = formaenvio;
        this.provincia = provincia;
        this.email = email;
        this.whatsapp = whatsapp;
        this.fecha = fecha;
    }

    public Producto() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Producto(String descripcion, String precioventa, String provincia) {
        this.descripcion = descripcion;
        this.precioventa = precioventa;
        this.provincia = provincia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(String precioventa) {
        this.precioventa = precioventa;
    }




    public String getFormaenvio() {
        return formaenvio;
    }

    public void setFormaenvio(String formaenvio) {
        this.formaenvio = formaenvio;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }
}
