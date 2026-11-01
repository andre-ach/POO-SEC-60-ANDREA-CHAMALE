public class ApiFacturacion  extends Api implements Documentable{
   
    public ApiFacturacion() {
        super();
    }

    // Constructor con parámetros
    public ApiFacturacion(int identificador, boolean estadoConexion, double latencia, boolean actividad) {
         super(identificador, estadoConexion, latencia, actividad); 
    }

    // Métodos
     @Override
    public String generarDocumento() {
        return "******** Factura ******** \n Nit: 0000000 -0 \n Total: Q. 100.00";

    }


}
