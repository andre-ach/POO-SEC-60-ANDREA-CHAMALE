public class Prestamo {

    private int codigoPrestamo;
    private int carnetEstudiante;
    private String nombreEstudiante;
    private String tituloLibro;
    private int diasAutorizados;

    public Prestamo(){
        codigoPrestamo = 0;
        carnetEstudiante = 0;
        nombreEstudiante = "";
        tituloLibro = "";
        diasAutorizados = 0;
    }

    public Prestamo(int codigoPrestamo, int carnetEstudiante, String nombreEstudiante, String tituloLibro, int diasAutorizados ){
        this.codigoPrestamo = codigoPrestamo;
        this.carnetEstudiante = carnetEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.tituloLibro = tituloLibro;
        this.diasAutorizados = diasAutorizados;
    }
 // SETS & GETS

    public void setCodigoPrestamo(int codigoPrestamo){
        this.codigoPrestamo = codigoPrestamo;
    }

    public int getCodigoPrestamo(){
        return this.codigoPrestamo;
    }

    public void setCarnetEstudiante(int carnetEstudiante){
        this.carnetEstudiante = carnetEstudiante;
    }

    public int getCarnetEstudiante(){
        return this.carnetEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante){
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getNombreEstudiante(){
        return this.nombreEstudiante;
    }

    public void setTituloLibro(String tituloLibro){
        this.tituloLibro = tituloLibro;
    }

    public String getTituloLibro(){
        return this.tituloLibro;
    }

    public void setDiasAutorizados(int diasAutorizados){
        this.diasAutorizados = diasAutorizados;
    }

    public int getDiasAutorizados(){
        return this.diasAutorizados;
    }

    public String toString(){
        return this.codigoPrestamo + " ";
    }
}