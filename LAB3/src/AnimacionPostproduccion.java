
public class AnimacionPostproduccion extends Animacion {
    // Atributos privados
    private double recursosLicenciados;

    // Constructor por defecto 
    public AnimacionPostproduccion() {
        recursosLicenciados= 0;
    }

    // Constructor con parámetros 
    public AnimacionPostproduccion(int codigoTrabajo, String nombreEstudio, String nombreProyecto, double horasComputoEstimadas, int horarioEjecucion,int cantFotogramas, double recursosLicenciados) {
        // Pasa los atributos heredados al constructor de la clase padre (Trabajo)
        super(codigoTrabajo, nombreEstudio, nombreProyecto, horasComputoEstimadas, horarioEjecucion, cantFotogramas);
        this.recursosLicenciados = recursosLicenciados;
    }

    // Métodos Getter y Setter 
    public void setRecursosLicenciados(double recursosLicenciados) {
        this.recursosLicenciados = recursosLicenciados;
    }

    // Corregido según las buenas prácticas (el diagrama repetía getComposicionFinal)
    public double getRecursosLicenciados() {
        return this.recursosLicenciados;
    }


    // Implementación de métodos 
    @Override
    public  double cobro() {

        double costoAnimacion = super.cobro();

        double cobrar =  costoAnimacion + 80 + (recursosLicenciados * 0.05); 
        return cobrar;
    }

    @Override
    public  int getMaxIntentos(){
         return 2;
    }

    @Override
    public  String tiempoEntrega(){

       int  tiempoEntrega = 0;
         if(horarioEjecucion == 1){
            tiempoEntrega = 36;
        }else{
            tiempoEntrega = 48;
        }

        String entrega = "Tiempo estimado de entrega: " +  tiempoEntrega;
        return entrega;

    }

    @Override
    public boolean usaGPU() {
    return false;
    }
    public String toString() {
        
        String cadena = super.toString()  + "\nRecursos Licenciados: "+ recursosLicenciados;
        return cadena;
    }
}
