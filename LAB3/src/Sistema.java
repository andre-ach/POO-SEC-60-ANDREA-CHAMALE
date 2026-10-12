import java.util.ArrayList;

public class Sistema {

    private ArrayList <Trabajo> trabajos;
    private ArrayList <Lote>  lotes;
    private ArrayList<Nodo> nodos;
    private double montoAcumulado;
    private double montoReintento;
    private double montoAnimacion;
    private double montoImagenFija;
    private double montoAnimacionPostProduccion;
    private double montoSimulacion;

    // Constructor (+)
    public Sistema() {
        this.trabajos = new ArrayList <Trabajo>();
        this.lotes = new ArrayList<Lote>();
        this.nodos = new ArrayList<Nodo>();
        this.montoAcumulado = 0;
        this.montoReintento = 0;
        this.montoAnimacion = 0;
        this.montoImagenFija = 0;
        this.montoAnimacionPostProduccion = 0;
        this.montoSimulacion = 0;
    }

    // Métodos públicos (+)
    public boolean existeCodigoTrabajo() {
        return false;
    }

    public boolean existeCodigoNodo() {
        return false;
    }

    public boolean existeCodigoLote() {
        return false;
    }

    public void agregarTrabajo(Trabajo trabajo) {
        trabajos.add(trabajo);
    }

    public void agregarLote(Lote lote) {
        lotes.add(lote);
    }

    public void agregarNodo(Nodo nodo) {
        nodos.add(nodo);
    }

    public String precio(int codigoTrabajo) {
        return "";
    }

    public String realizarPago(int codigoTrabajo, int horario) {
        return "";
    }

    public void realizarPagoExtra() {
    }

    public String registrarTrabajoLote(int codigoTrabajo, int codigoLote) {

        for (int h = 0; h< lotes.size(); h++){
            
            if (lotes.get(h).getCodigoLote() == codigoLote){
                Lote encontrado = lotes.get(h);

            for(int i = 0; i< trabajos.size();  i++){

            if(trabajos.get(i).getCodigoTrabajo()== codigoTrabajo){
                Trabajo encontradoT = trabajos.get(i);

                return encontrado.agregarTrabajo(encontradoT);
            }

            }
            
        }

        }

        return "No fue posible completar el proceso. ¡Intente de nuevo! Asegurese de ingresar datos existentes";
    }

    public String quitarTrabajoLote(int codigoTrabajo, int codigoLote){ 
        for (int h = 0; h < lotes.size(); h++){ // recorre todo las lista de lotes 
            if (lotes.get(h).getCodigoLote() == codigoLote){

                Lote trabajoQuitar = lotes.get(h);

                return trabajoQuitar.retirarTrabajo(codigoTrabajo);
            }
        }

        return "No fue posible retirar el trabajo del lote " + codigoLote;
    }

 

    public String consultarTrabajo(int codigoTrabajo) {
        return "";
    }

    public String consultarNodo(int codigoNodo) {
        return "";
    }

    public String reporte() {
        return "";
    }

    public String TotalCategoria() {
        return "";
    }

    public String cantrabajoEstadoCatetoria() {
        return "";
    }

    public String ingresos() {
        return "";
    }

    public String lotesNoCerrados() {
        return "";
    }

    public void trabajosDisponibles(){
        
    }


}
