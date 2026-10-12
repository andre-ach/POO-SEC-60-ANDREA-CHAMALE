public class SimulacionFisica extends Trabajo {

    private int resolucionMalla;

    public SimulacionFisica() {
        super();
    }

    // Constructor con parámetros
    public SimulacionFisica(int codigoTrabajo, String nombreEstudio, String nombreProyecto,float horasComputoEstimadas, int horarioEjecucion, int resolucionMalla) {
        
        // Pasa los atributos heredados al constructor de la clase padre (Trabajo)
        super(codigoTrabajo, nombreEstudio, nombreProyecto, horasComputoEstimadas, horarioEjecucion);
        this.resolucionMalla = resolucionMalla;

    }

    // Métodos Getter y Setter (+)
    public void setResolucionMalla(int resolucionMalla) {
        this.resolucionMalla = resolucionMalla;
    }

    public int getResolucionMalla() {
        return this.resolucionMalla;
    }

    // Implementación de métodos abstractos heredados (+)
    @Override
    public double cobro() {

        double cobro = 150 + (22*horasComputoEstimadas) + 65;

        return cobro;
    }

     @Override

       public  int getMaxIntentos(){
         return 1;
    }
    
      @Override
    public  String tiempoEntrega(){

        String entrega = "Tiempo estimado de entrega: " +  18;
        return entrega;

    }

    @Override
    public  boolean usaGPU(){
        return false;
    }




    public String toString() {

        String cadena = super.toString() + "\nResolución de Malla: " + resolucionMalla;
        return  cadena;
    }
}
