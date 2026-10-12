public abstract class Trabajo {
   
    protected int codigoTrabajo;
    protected String nombreEstudio;
    protected String nombreProyecto;
    protected double horasComputoEstimadas;
    protected int horarioEjecucion;
    protected String estadoTrabajo;
    protected int cantVecesEjecutar;
    protected int maxintentos;

    // Constructor por defecto (+)
    public Trabajo() {
        codigoTrabajo = 0;
        nombreEstudio = "";
        nombreProyecto = "";
        horasComputoEstimadas = 0;
        horarioEjecucion = 0;
        estadoTrabajo = "EN_COLA";
        cantVecesEjecutar = 0;
        maxintentos = 0;

        
    }

    // Constructor con parámetros (+)
    public Trabajo(int codigoTrabajo, String nombreEstudio, String nombreProyecto, 
                   double horasComputoEstimadas, int horarioEjecucion) {
        this.codigoTrabajo = codigoTrabajo;
        this.nombreEstudio = nombreEstudio;
        this.nombreProyecto = nombreProyecto;
        this.horasComputoEstimadas = horasComputoEstimadas;
        this.horarioEjecucion = horarioEjecucion;
        this.estadoTrabajo = "EN_COLA";
    }

    // Métodos Getter y Setter (+)
    public void setCodigoTrabajo(int codigoTrabajo) {
        this.codigoTrabajo = codigoTrabajo;
    }

    public int getCodigoTrabajo() {
        return this.codigoTrabajo;
    }

    public void setNombreEstudio(String nombreEstudio) {
        this.nombreEstudio = nombreEstudio;
    }

    public String getNombreEstudio() {
        return this.nombreEstudio;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getNombreProyecto() {
        return this.nombreProyecto;
    }

    public void setHorasComputoEstimadas(double horasComputoEstimadas) {
        this.horasComputoEstimadas = horasComputoEstimadas;
    }

    public double getHorasComputoEstimadas() {
        return this.horasComputoEstimadas;
    }

    public void setHorarioEjecucion(int horarioEjecucion) {
        this.horarioEjecucion = horarioEjecucion;
    }

    public int getHorarioEjecucion() {
        return this.horarioEjecucion;
    }

    public void setEstadoTrabajo(String estadoTrabajo) {
        this.estadoTrabajo = estadoTrabajo;
    }

    public String getEstadoTrabajo() {
        return this.estadoTrabajo;
    }

    public void setCantVecesEjecutar(int cantVecesEjecutar) {
        this.cantVecesEjecutar = cantVecesEjecutar;
    }

    public int getCantVecesEjecutar() {
        return this.cantVecesEjecutar;
    }

    public void setMaxintentos(int maxintentos) {
        this.maxintentos = maxintentos;
    }

    public int getMaxintentos() {
        return this.maxintentos;
    }

    // Métodos abstractos (+)



    public abstract double cobro();


    public abstract int getMaxIntentos();

    public abstract String tiempoEntrega();

    public abstract boolean usaGPU();

     public String toString() {

    String cadena = "Código del Trabajo:" + codigoTrabajo + "\nNombre Estudio: " + nombreEstudio + "\nNombre Proyecto: "+ nombreProyecto + "\nHoras estimadas de Computo: " + horasComputoEstimadas + "\nHorario: " + horarioEjecucion +"\nEstado del Trabajo: " + estadoTrabajo+ "\nCantidad de Veces por Ejecutar " + cantVecesEjecutar + "\nIntentos: "+maxintentos;
    
    return cadena;
    }
}
