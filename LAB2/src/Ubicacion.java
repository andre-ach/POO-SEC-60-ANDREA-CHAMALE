public class Ubicacion {

    private int codigoUbicacion;
    private String nombreUbicacion;
    private String direccionUbicacion;
    private int nivelRiesgo;
    private String estadoUbicacion;

    public Ubicacion(){
        codigoUbicacion = 0;
        nombreUbicacion = "";
        direccionUbicacion = "";
        nivelRiesgo = 0;
        estadoUbicacion = "";
    }

    public Ubicacion(int codigoUbicacion, String nombreUbicacion, String direccionUbicacion, int nivelRiesgo, String estadoUbicacion) {
        this.codigoUbicacion = codigoUbicacion;
        this.nombreUbicacion = nombreUbicacion;
        this.direccionUbicacion = direccionUbicacion;
        this.nivelRiesgo = nivelRiesgo;
        this.estadoUbicacion = estadoUbicacion;
    }

    // Getter y Setter

    public void setCodigoUbicacion(int codigoUbicacion) {
        this.codigoUbicacion = codigoUbicacion;
    }

    public int getCodigoUbicacion() {
        return this.codigoUbicacion;
    }

    public void setNombreUbicacion(String nombreUbicacion) {
        this.nombreUbicacion = nombreUbicacion;
    }

    public String getNombreUbicacion() {
        return this.nombreUbicacion;
    }

    public void setDireccionUbicacion(String direccionUbicacion) {
        this.direccionUbicacion = direccionUbicacion;
    }

    public String getDireccionUbicacion() {
        return this.direccionUbicacion;
    }

    public void setNivelRiesgo(int nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public int getNivelRiesgo() {
        return this.nivelRiesgo;
    }

    public void setEstadoUbicacion(String estadoUbicacion) {
        this.estadoUbicacion = estadoUbicacion;
    }

    public String getEstadoUbicacion() {
        return this. estadoUbicacion;
    }

    // Otros métodos 
    
    @Override
    public String toString() {
        return "Ubicacion {" +
                "codigoUbicacion=" + codigoUbicacion +
                ", nombreUbicacion='" + nombreUbicacion + '\'' +
                ", direccionUbicacion='" + direccionUbicacion + '\'' +
                ", nivelRiesgo=" + nivelRiesgo +
                ", estadoUbicacion='" + estadoUbicacion + '\'' +
                '}';
    }

}