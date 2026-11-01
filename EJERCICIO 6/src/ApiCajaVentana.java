public class ApiCajaVentana extends Api implements Cobrar, Documentable{


    // Constructor por defecto
    public ApiCajaVentana() {
        super();
    }

    // Constructor con parámetros
    public ApiCajaVentana(int identificador, boolean estadoConexion, double latencia, boolean actividad) {
        super(identificador, estadoConexion, latencia, actividad); 
    }

    // Métodos
    public String cobrar() {
        return " Se cobró Q.35";
    }

    public String generarDocumento() {
        return "Recibo generado de compra";
    }

}
