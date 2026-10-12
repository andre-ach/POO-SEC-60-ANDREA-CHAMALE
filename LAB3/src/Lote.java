import java.util.ArrayList;

public class Lote {
    private int codigoLote;
    private ArrayList <Trabajo>trabajos;
    private String estado;
    private Nodo nodo;
    private double recargosReintentos = 0;

    public Lote() {
        codigoLote = 0;
        this.trabajos = new ArrayList<Trabajo>();
        estado = "EN_PREPARACION";

    }

    // Constructor con parámetros (+)
    public Lote(int codigoLote, Nodo nodo) {
        this.codigoLote = codigoLote;
        this.trabajos = new ArrayList<Trabajo>(); // Inicialización de la lista de trabajos
        this.estado = "EN_PREPARACION";
        this.nodo = nodo;
    }

    // Métodos Getter y Setter (+)
    public void setCodigoLote(int codigoLote) {
        this.codigoLote = codigoLote;
    }

    public int getCodigoLote() {
        return this.codigoLote;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setRecargoReintentos(double recargosReintentos) {
        this.recargosReintentos = recargosReintentos;
    }

    public double getRecargosReintentos(){
        return recargosReintentos;
    } 

    public double calcularHorasAsignadas(){ // suma las horas de todos los trabajos que se han agregado a la lista
        
        double total = 0;

        for (Trabajo t : trabajos){
            total = total + t.getHorasComputoEstimadas();
        }
        return total;
    }

    public double capacidadDisponible() { //Calcula la cantidad de horas que todavia están disponibles 

        double totalDisponible = nodo.getCapacidadMaximaHorasCompuLote() - calcularHorasAsignadas();

        return totalDisponible;
    }


    public String agregarTrabajo(Trabajo trabajo) {// Agrega el trabajo a lista 

        try{ 

            if (trabajo == null){
                return "El trabajo no existe";
            }
            if(!estado.equals("EN_PREPARACION")){ /// Si es distinto al estado "EN_PREPARACIÓN"
                return "El lote no está en preparación";
            }

            if(!trabajo.getEstadoTrabajo().equals("EN_COLA")){ // Revisia que si es estado del trabajo es disnto de  "En cola"
                return "El trabajo no esá en cola"; 
            }

            double horasTotal = calcularHorasAsignadas() + trabajo.getHorasComputoEstimadas(); // calcula el tiempo total si se usa el trabajo 

            if (horasTotal > nodo.getCapacidadMaximaHorasCompuLote()){ //Evalua que las horas sean enor a la capacidad
                return "El nodo no cuenta con la capacidad suficiente";
            }

            if(trabajo.usaGPU() && !nodo.getCuentaGPU()){ // Evalua si no se requiere de gpu 
                return "El nodo no tiene GPU para este trabajo";
            }

            trabajos.add(trabajo);
            trabajo.setEstadoTrabajo("ASIGNADO");

            return "El proceso se ha compeltado"; 
        } catch(Exception e){
            return "Error! Intente de nuevo ";
        }
      
    }

    public String retirarTrabajo(int codigoTrabajo){ //Aquitar trabajo
        if(!estado.equals("EN_PREPARACION")){ // verifica si el estado del lote está en preparacion para poder quitar un trabajo 
            return "El lote no está en preparación";
        }

        for (int i = 0; i< trabajos.size(); i++){
            if (trabajos.get(i).getCodigoTrabajo() == codigoTrabajo){
                Trabajo encontrado = trabajos.get(i);

                trabajos.remove(encontrado);

                encontrado.setEstadoTrabajo("EN_COLA");

                return "Trabajo con el código "+ codigoTrabajo+ " retirado";
            }
        }

        return "El trabajo no pertenece a este lote";
    }

    public String iniciarLote(){ 


        if(!estado.equals("EN_PREPARACION")){// Verifica si el estado del lote es disinto de en preparacion
            return "El lote no está en preparación";
            }

        if (trabajos.isEmpty()){ // vefica que no este vacia la lista
            return "El lote está vacío";
        }

        for (int h = 0; h < trabajos.size(); h++){

            Trabajo verificar = trabajos.get(h); 

            if (verificar.getCantVecesEjecutar() >= verificar.getMaxIntentos()){
                
                return  "\nEl trabajo " + verificar.getCodigoTrabajo() + "ha alcanzo su máximo de intentos. ¡Se cancela la ejecución del lote!";
            }

            if(!verificar.getEstadoTrabajo().equals("ASIGNADO")){
                return "\nEl trabajo no está asignado";
            }

        }

        
        double totalReintentos = 0;


        for (int i = 0; i< trabajos.size(); i++){

            Trabajo cambiar = trabajos.get(i); 

            if (cambiar.getCantVecesEjecutar()>0){
                
                totalReintentos = totalReintentos + 25; // sumamos en caso 
                recargosReintentos = recargosReintentos + 25; 
            }
                cambiar.setCantVecesEjecutar(cambiar.getCantVecesEjecutar() + 1);
                cambiar.setEstadoTrabajo("EN_EJECUCION"); // Cambia el estado del trabajo
        }

        estado = "EN_EJECUCION";


        return"Lote iniciado correctamente. Recargos reintentos: Q" + totalReintentos;
    }
            

    public String toString() {
        String cadena = "Codigo: " + codigoLote + "\nEstado: " + estado;
        return cadena;
    }
}

