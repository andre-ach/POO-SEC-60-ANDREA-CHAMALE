public class ModuloTierra extends Modulo {

    // Atributos privados
    private int capacidadDescarga;
    private int energiaDescarga;
    private int totalDescarga;

    // Constructor vacío
    public ModuloTierra() {
        super();
        this.capacidadDescarga = 0;
        this.energiaDescarga = 0;
        this.totalDescarga = 0;

    }

    // Constructor parametrizado
    public ModuloTierra(int id, String nombre, String estadoSalud, boolean actividad, float costoContruccion, int capacidadDescarga,  int energiaDescarga, int totalDescarga) {
        super(id, nombre, estadoSalud, actividad, costoContruccion);
        this.capacidadDescarga = capacidadDescarga;
        this.energiaDescarga = energiaDescarga;
        this.totalDescarga = totalDescarga;
    }

    // Métodos Getters y Setters
    public void setCapacidadDescarga(int capacidadDescarga) {
        this.capacidadDescarga = capacidadDescarga;
    }

    public int getCapacidadDescarga() {
        return this.capacidadDescarga;
    }

    public void setEnergiaDescarga(int energiaDescarga) {
        this.energiaDescarga = energiaDescarga;
    }

    public int getEnergiaDescarga() {
        return this.energiaDescarga;
    }

    public int getTotalDescarga(){
        return totalDescarga;
    }

    public void setTotalDescarga(int totalDescarga) {
        this.totalDescarga = totalDescarga;
    }

   

    // Métodos de lógica del módulo

    @Override
    public String procesarCiclo(CentroControl centroControl){
        
        if (actividad == false && energiaDescarga <= centroControl.getEnergiaTotal()){
            actividad = true;
        }

        try{
            if (actividad == true && energiaDescarga <= centroControl.getEnergiaTotal()){
        

                int datosDescargar = centroControl.getDatosPendientesDescarga();

                if( capacidadDescarga > datosDescargar){
                    return "¡La capacidad de descarga supera la cantidad de datos disponbles para descargar en óbita!";
                }else{
                    //Descuenta energía 
                    int energiaTotalActual = centroControl.getEnergiaTotal()  - energiaDescarga;

                    centroControl.setEnergiaTotal(energiaTotalActual);

                    //Descarga archivos
                    datosDescargar = datosDescargar - capacidadDescarga;

                    centroControl.setDatosPendientesDescarga(datosDescargar);

                    //Modifica su historia
                    totalDescarga =  totalDescarga + capacidadDescarga; 
                        return "Modulo " + nombre + ":¡Proceso Exitoso!" + "\n"+ "Total Descargado (Histórico): "+ totalDescarga;

                }
          
            }else if (actividad == false){
                return "Modulo Tierra: ¡El Modulo "+ nombre+ " se encuenta inactivo!";
            }else if (energiaDescarga > centroControl.getEnergiaTotal()){
                 return "Modulo " + nombre + ": ¡No se cuenta con sufiente energía!";
            }else{
                return "Modulo " + nombre + ": ¡ERROR DEL SISTEMA! Intente de nuevo";
            }
        }catch(Exception e){
             return "Modulo " + nombre + ": ¡ERROR DEL SISTEMA! Intente de nuevo";
        }
    }

    // Método toString
    @Override
    public String toString() {
        String cadena = super.toString() + "\nCapacidad Descarga: "+ this.capacidadDescarga + "\nEnergía por Descarga: " + this.energiaDescarga + "\nRegistro de descargas: " + this.totalDescarga ;
        return cadena;
    }
}

