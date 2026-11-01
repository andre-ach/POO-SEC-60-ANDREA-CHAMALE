public class ApiLogistica  extends Api implements Auditable,Documentable{
   
    public ApiLogistica() {
        super();
    }

    // Constructor con parámetros
    public ApiLogistica(int identificador, boolean estadoConexion, double latencia, boolean actividad) {
         super(identificador, estadoConexion, latencia, actividad); 
    }

    // Métodos
     @Override
    public String generarDocumento() {
        return "******** Guía ******** \n1. Revisar \n2. Empacar \n3. Entregar";
    }

     @Override
    public String registrarEvento() {
        return "Paquete 001 fue entregado ";
    }

     @Override
    public String consultarHistorialEventos() {
        return "El útlimo paquete fue entregado ayer a las 11:00 AM";
    }

}

