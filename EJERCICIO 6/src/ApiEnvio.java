public class ApiEnvio extends Api implements  Cotizar,ConsultarEstado{


    // Constructor por defecto
    public ApiEnvio() {
         super(); 
    }

    // Constructor con parámetros
    public ApiEnvio(int identificador, boolean estadoConexion, double latencia, boolean actividad) {
       super(identificador, estadoConexion, latencia, actividad); 
    }

    // Métodos
    public String cotizar() {
        return "El costo total del envío será de Q50";
    }

    public String consultarEstado() {
        return "El envío está en proceso";
    }
}
