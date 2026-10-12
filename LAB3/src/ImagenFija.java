
public class ImagenFija extends Trabajo {

    // Constructor por defecto (+)
    public ImagenFija() {

    }

    // Constructor con parámetros (+)
    public ImagenFija(int codigoTrabajo, String nombreEstudio, String nombreProyecto, float horasComputoEstimadas, int horarioEjecucion) {
        super(codigoTrabajo, nombreEstudio, nombreProyecto, horasComputoEstimadas, horarioEjecucion);

    }

    // Implementación de métodos abstractos heredados (+)
    @Override
    public double cobro() {

        int  cobroHorario = 0;
         if(horarioEjecucion == 1){
            cobroHorario = 45;
        }else{
            cobroHorario = 30;
        }
        return cobroHorario;
    }

    @Override
    public  int getMaxIntentos(){
         return 3;
    }

    @Override
    public  String tiempoEntrega(){

        int  tiempoEntrega = 0;
         if(horarioEjecucion == 1){
            tiempoEntrega = 4;
        }else{
            tiempoEntrega = 10;
        }

        String entrega = "Tiempo estimado de entrega: " +  tiempoEntrega;
        return entrega;

    }

    @Override
    public boolean usaGPU() {
    return false;
    }
    
    public String toString() {
        return super.toString();
    }
}
