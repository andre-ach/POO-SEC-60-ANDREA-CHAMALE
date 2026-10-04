public class ModuloEnergia extends Modulo{

    private int cantidadUnidadesPorCiclo;
    private int ciclosAcumulados;
  
    public ModuloEnergia() {
        super();
        cantidadUnidadesPorCiclo = 0;
        ciclosAcumulados = 0;


    }

    public ModuloEnergia(int id, String nombre, String estadoSalud, boolean actividad, float costoContruccion, int cantidadUnidadesPorCiclo,int ciclosAcumulados) {
       super(id, nombre, estadoSalud,actividad,costoContruccion);
       this.cantidadUnidadesPorCiclo  = cantidadUnidadesPorCiclo;
       this.ciclosAcumulados = ciclosAcumulados;
    
    }

    // Métodos Getters y Setters
    public void setCantidadUnidadesPorCiclo(int cantidadUnidadesPorCiclo) {
        this.cantidadUnidadesPorCiclo = cantidadUnidadesPorCiclo;
    }

    public int getCantidadUnidadesPorCiclo() {
        return this.cantidadUnidadesPorCiclo;
    }

    public void setCiclosAcumulados(int ciclosAcumulados) {
        this.ciclosAcumulados = ciclosAcumulados;
    }

    public int getCiclosAcumulados() {
        return this.ciclosAcumulados;
    }




    @Override
    public String procesarCiclo(CentroControl centroControl){
        
        if (actividad = true){
            int energiaTotalActual = centroControl.getEnergiaTotal() + cantidadUnidadesPorCiclo;

            centroControl.setEnergiaTotal(energiaTotalActual); 

            ciclosAcumulados = ciclosAcumulados + 1;

            return  "Modulo " + nombre + ":¡Energía recolectada exitosamente!";
        }else {
            return  "¡El Modulo"+ nombre + "se encuenta inactivo!";
        }

    }

    // Método toString
    @Override
    public String toString() {
        String cadena = super.toString() + "\nCantidad de unidades por Ciclo: " + this.cantidadUnidadesPorCiclo + "\nCiclos Acumulados: "+ this.ciclosAcumulados;
        return cadena;
    }
}
