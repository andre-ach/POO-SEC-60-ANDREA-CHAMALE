public class ApiBanco extends Api implements Reintegro,  Auditable {


    public ApiBanco() {
        super();
    }

    // Constructor con parámetros
    public ApiBanco(int identificador, boolean estadoConexion, double latencia, boolean actividad) {
        
        super(identificador, estadoConexion, latencia, actividad); 

    }

    // Métodos

    public String reintegro() {
        return "Se realizó  reintegro de Q35";
    }
    
    public String registrarEvento() {
        return "Se registró reintegro";
    }


    public String consultarHistorialEventos() {
        return "Hoy se realizó un reintegro de Q35";
    }

}
