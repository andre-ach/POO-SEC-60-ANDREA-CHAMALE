public class ModuloVuelo extends Modulo {

    // Atributos privados
    private String tipoInstrumento;
    private int datosRecolectadosPorCiclos;
    private int consumoEnergia;
    private int cantCiclosAcumulados;
    private int cantDatosRecolectadosHistorico;
  

    // Constructor vacío
    public ModuloVuelo() {
        super();
        tipoInstrumento = "";
        datosRecolectadosPorCiclos = 0;
        consumoEnergia = 0;
        cantCiclosAcumulados = 0;
        cantDatosRecolectadosHistorico = 0;




        
    }

    // Constructor parametrizado completo
    public ModuloVuelo(int id, String nombre, String estadoSalud, boolean actividad, float costoContruccion, 
                       String tipoInstrumento, int datosRecolectadosPorCiclos, int consumoEnergia, int cantCiclosAcumulados) {
        // Inicializa los atributos de la clase padre (Modulo)
        super(id, nombre, estadoSalud, actividad, costoContruccion);
        // Inicializa los atributos propios de ModuloVuelo
        this.tipoInstrumento = tipoInstrumento;
        this.datosRecolectadosPorCiclos = datosRecolectadosPorCiclos;
        this.consumoEnergia = consumoEnergia;
        this.cantCiclosAcumulados = cantCiclosAcumulados;


    }

    // Métodos Getters y Setters
    public void setTipoInstrumento(String tipoInstrumento) {
        this.tipoInstrumento = tipoInstrumento;
    }

    public String getTipoInstrumento() {
        return this.tipoInstrumento;
    }

    public void setDatosRecolectadosPorCiclos(int datosRecolectadosPorCiclos) {
        this.datosRecolectadosPorCiclos = datosRecolectadosPorCiclos;
    }

    public int getDatosRecolectadosPorCiclos() {
        return this.datosRecolectadosPorCiclos;
    }

    public void setConsumoEnergia(int consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    public int getConsumoEnergia() {
        return this.consumoEnergia;
    }

    public void setCantCiclosAcumulados(int cantCiclosAcumulados) {
        this.cantCiclosAcumulados = cantCiclosAcumulados;
    }

    public int getCantCiclosAcumulados() {
        return this.cantCiclosAcumulados;
    }

    public void setCantDatosRecolectadosHistorico(int cantDatosRecolectadosHistorico){
        this.cantDatosRecolectadosHistorico =cantDatosRecolectadosHistorico;
    }

    public int getCantDatosRecolectadosHistorico(){
        return cantDatosRecolectadosHistorico;
    }

    // OTRO MÉTODOS 

    public String procesarCiclo(CentroControl centroControl) {

  
        if (actividad == false && consumoEnergia <= centroControl.getEnergiaTotal()){
            actividad = true;
        }
        
       

        try{
            if (actividad == true && consumoEnergia <= centroControl.getEnergiaTotal()){
            int energiaTotalActual = centroControl.getEnergiaTotal()  - consumoEnergia;

                centroControl.setEnergiaTotal(energiaTotalActual);

                //DATOS RECOLECTODS POR ESTR MODULO
                cantDatosRecolectadosHistorico = cantDatosRecolectadosHistorico + datosRecolectadosPorCiclos  ;
            
                //ENVIA LOS DATOS PARA QUE SE PUEDAN DESCARGAR
                int subirDatosPendiente = centroControl.getDatosPendientesDescarga();

                subirDatosPendiente = subirDatosPendiente + datosRecolectadosPorCiclos;

                centroControl.setDatosPendientesDescarga(subirDatosPendiente);

                cantCiclosAcumulados = cantCiclosAcumulados + 1;

                return "Modulo " + nombre + ": ¡Porceso Exitoso! Hasta el momento se han realizado " + cantCiclosAcumulados + "ciclos";
            }else if (actividad == false ){
                return "Modulo "+ nombre+ ": ¡Se encuenta inactivo!";
            }else{
                 return "Modulo" + nombre + " ¡No se cuenta con sufiente energía!";
            }
        }catch(Exception e){
             return "Modulo " + nombre + ": ¡ERROR DEL SISTEMA! Intente de nuevo";
        }

    }

    // Método toString
    @Override
    public String toString() {

        String cadena = super.toString() + "\nTipo Instrumento: " + this.tipoInstrumento + "\nDatos Recolectados por Ciclo: " + this.datosRecolectadosPorCiclos + "\nConsumo de Energía: " + this.consumoEnergia + "\nCiclos acumulados: " + this.cantCiclosAcumulados;
        return cadena;
    }
}
