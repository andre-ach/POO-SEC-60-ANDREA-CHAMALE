
public class Animacion extends Trabajo {
    // Atributos privados (-)
    private int cantFotogramas;

    public Animacion() {
        cantFotogramas = 0;
  
    }

    // Constructor con parámetros (+)
    public Animacion(int codigoTrabajo, String nombreEstudio, String nombreProyecto, double horasComputoEstimadas, int horarioEjecucion, int cantFotogramas) {
    
        super(codigoTrabajo, nombreEstudio, nombreProyecto, horasComputoEstimadas,horarioEjecucion);
        this.cantFotogramas = cantFotogramas;

    }

    // Getter y Setter 
    public void setCantFotogramas(int cantFotogramas) {
        this.cantFotogramas = cantFotogramas;
    }

    public int getCantFotogramas() {
        return this.cantFotogramas;
    }



    @Override
    public double cobro() {

        double tarifaBase = 0;

        if(horarioEjecucion == 1){
            tarifaBase = 60;
        }else{
            tarifaBase = 40;
        }

       double horasFotograma = cantFotogramas * 0.02;

        double pagarHoras = 0;
       if(horasFotograma == horasComputoEstimadas){
            pagarHoras = horasComputoEstimadas;
       }else if(horasFotograma > horasComputoEstimadas){
            pagarHoras = horasFotograma;
       }else if (horasFotograma < horasComputoEstimadas){
            pagarHoras = horasComputoEstimadas;
       }else {
            pagarHoras = 0;
       }

       double horasFacturables = Math.ceil(pagarHoras);


        double cobrar = tarifaBase + (horasFacturables * 15) ; 

        return  cobrar ;
    }

    @Override
    public  int getMaxIntentos(){
         return 3;
    }
    @Override
    public  String  tiempoEntrega(){

       int  tiempoEntrega = 0;
         if(horarioEjecucion == 1){
            tiempoEntrega = 24;
        }else{
            tiempoEntrega = 36;
        }

         String entrega = "Tiempo estimado de entrega: " +  tiempoEntrega;
        return entrega;


    public boolean usaGPU() {
    return false;
    }

    
    public String toString() {
        String cadena = super.toString() + "\nCantidad Fotogramas" + cantFotogramas ; 
        return  cadena;
    }
}
