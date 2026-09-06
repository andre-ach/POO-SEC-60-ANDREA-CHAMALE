public class Pista{

    private int codigoPista;
    private String descripcionPista;
    private String tipoEvidencia;
    private int nivelImportancia;
    private int nivelConfiabilidad;

    public Pista(){
        codigoPista = 0;
        descripcionPista = "";
        tipoEvidencia = "";
        nivelImportancia = 0;
        nivelConfiabilidad = 0;
    }

    public Pista (int codigoPista, String descripcionPista, String tipoEvidencia, int nivelImportancia, int nivelConfiabilidad){

        this.codigoPista = codigoPista;
        this.descripcionPista = descripcionPista;
        this.tipoEvidencia = tipoEvidencia;
        this.nivelImportancia = nivelImportancia;
        this.nivelConfiabilidad = nivelConfiabilidad;

    }

      // Getters y Setters
    public void setCodigoPista(int codigoPista) {
        this.codigoPista = codigoPista;
    }

    public int getCodigoPista() {
        return this.codigoPista;
    }

    public void setDescripcionPista(String descripcionPista) {
        this.descripcionPista = descripcionPista;
    }

    public String getDescripcionPista() {
        return this.descripcionPista;
    }

    public void setTipoEvidencia(String tipoEvidencia) {
        this.tipoEvidencia = tipoEvidencia;
    }

    public String getTipoEvidencia() {
        return this.tipoEvidencia;
    }

    public void setNivelImportancia(int nivelImportancia) {
        this.nivelImportancia = nivelImportancia;
    }

    public int getNivelImportancia() {
        return this.nivelImportancia;
    }

    public void setNivelConfiabilidad(int nivelConfiabilidad) {
        this.nivelConfiabilidad = nivelConfiabilidad;
    }

    public int getNivelConfiabilidad() {
        return this.nivelConfiabilidad;
    }

    // Método 
    

    @Override
    public String toString() {
        return "Pista{" +
                "codigoPista=" + codigoPista +
                ", descripcionPista='" + descripcionPista + '\'' +
                ", tipoEvidencia='" + tipoEvidencia + '\'' +
                ", nivelImportancia=" + nivelImportancia +
                ", nivelConfiabilidad=" + nivelConfiabilidad +
                '}';
    }

}