import java.util.ArrayList;

public class CentroControl {


    private int energiaTotal;
    private int datosPendientesDescarga;
    private ArrayList<Modulo> modulo;


    public CentroControl() {
        this.energiaTotal = 0;
        this.datosPendientesDescarga = 0;
        this.modulo = new ArrayList<>();
    }

    //GET y SET

    public void setEnergiaTotal(int energiaTotal) {
        this.energiaTotal = energiaTotal;
    }

    public int getEnergiaTotal() {
        return this.energiaTotal;
    }

    public void setDatosPendientesDescarga(int datosPendientesDescarga) {
        this.datosPendientesDescarga = datosPendientesDescarga;
    }

    public int getDatosPendientesDescarga() {
        return this.datosPendientesDescarga;
    }

    //Métodos 

    public void modulosDisponibles(){
        
        ModuloEnergia e1 = new ModuloEnergia(100, "FUENTE00", "Bueno", true, 22000,20000,0);
        this.modulo.add(e1);

        ModuloEnergia e2 = new ModuloEnergia(101, "FUENTE01","Regular",true, 15000, 12000, 0);
        this.modulo.add(e2);

        ModuloEnergia e3 = new ModuloEnergia(102, "FUENTE02", "Bueno", true, 20000, 17000,0);
        this.modulo.add(e3);

        ModuloEnergia e4 = new ModuloEnergia(103, "FUENTE03","Regular", true, 15000, 10000, 0);
        this.modulo.add(e4);

        ModuloVuelo v1 = new ModuloVuelo(201, "AGUILA", "Bueno", false, 50000, "Cámara", 10000, 14000,0);
        this.modulo.add(v1);

        ModuloVuelo v2 = new ModuloVuelo(202, "GORRION", "Bueno", true, 150000, "Sensor", 45000, 30000, 0);
        this.modulo.add(v2);

        ModuloVuelo v3 = new ModuloVuelo(203, "BUHO", "Regular",false, 25000, "Sensor", 5000,8000, 0);
        this.modulo.add(v3);

        ModuloTierra t1 = new ModuloTierra(301, "RECEPTOR01", "Bueno", true, 20000, 9000, 10000,0);
        this.modulo.add(t1);

        ModuloTierra t2 = new ModuloTierra(302, "RECEPTOR02","Regular", false, 25000, 19000, 18000,0 );
        this.modulo.add(t2);

        ModuloTierra t3 = new ModuloTierra(303, "RECEPTOR03", "Bueno", true, 20000, 19500, 19999, 0);
        this.modulo.add(t3);

    }

    public String mostrarModulos(){

        String moduloMostrar = "";

        for (Modulo m: modulo){
     
                moduloMostrar =moduloMostrar + "\n" + m.toString()+ "\n";
        }

        
        return moduloMostrar;
    }

    public String buscarModulo(int id){
        try{
            String info = "";

            for(Modulo m : modulo){
                if(m.getId() == id){

                    info = "\n"+ m.toString();
                    return info;
                }
            }

            return "No se encontró el módulo con el ID: "+ id;

        }catch(Exception e){
            return "No se encontró el módulo con el ID: " + id;
        }
    }

    public String catalogoPorCostoContruccio(){

        String listado = "";
        String idAgregados= "";
        int contador = 0;


        float moduloActual = 0.0f;
        int moduloActualId = 0;
        int numId = 0;

        while (contador < modulo.size()){
            
            float num = -1.0f; // Se reinicia cada en cada vuelta
            int indiceGanador = -1;  // Se reinicia cada en cada vuelta

            for(int i = 0; i < modulo.size(); i++){
            
            moduloActual = modulo.get(i).getCostoConstruccion();
            moduloActualId = modulo.get(i).getId();

                if (moduloActual > num && !idAgregados.contains(moduloActualId + ",")) //compara que el número sea mayor a 0 y que no se encuentre agregado en "listado"
                {
                    num = moduloActual;
                    numId = moduloActualId;

                    indiceGanador = i;
                }
            }

            if (indiceGanador != -1){ // Compara que el idice sea difernte a -1 y aquí es donde se agrega al listado. 
                listado = listado +  "\n" + modulo.get(indiceGanador).toString()+ "\n";
                
                idAgregados = idAgregados + modulo.get(indiceGanador).getId()+ ",";
            }

            contador = contador + 1;
        }

        return listado;
    }

    public String correrSimulacion(){

        String reporte = "";

        for (Modulo m : modulo) {
            reporte = reporte + "\n" + m.procesarCiclo(this); 
        }

        return reporte;

    }

    //Métodos para RESUMEN 

    public String cantidadModuloTierra(){

        String mostrar = ""; 
        int cantModuloTierra = 0;

        for(Modulo m: modulo){

            if(m instanceof ModuloTierra){
                ModuloTierra t = (ModuloTierra) m;

                cantModuloTierra= cantModuloTierra + 1;
            }
        }

        mostrar = "Módulos Tierra: " +  cantModuloTierra;

        return mostrar;
    }

    public String cantModuloTierraActivos(){

        String mostrar = ""; 
        int cantModuloTierraActivos = 0;

        for(Modulo m: modulo){

            if(m instanceof ModuloTierra){
                ModuloTierra t = (ModuloTierra) m;

                if(t.getActividad() == true){
                    
                    cantModuloTierraActivos= cantModuloTierraActivos + 1;
                }
               
            }
        }

        mostrar = "Módulos Tierra: " +  cantModuloTierraActivos;

        return mostrar;
    }

    public String capacidadTotalDescargaTierraActivos(){

        String mostrar = ""; 

        for(int i = 0; i< modulo.size(); i++){

            if(modulo.get(i) instanceof ModuloTierra){
                ModuloTierra t = (ModuloTierra) modulo.get(i);

                if(t.getActividad() == true){
                    mostrar = mostrar + "\n"+ "\nModulo "+ t.getNombre() + ": \n" + "Capacidad descarga: " + t.getCapacidadDescarga() + "\nTotal Descarga: " + t.getTotalDescarga() + "\n \n";
                }
               
            }
        }

        return mostrar;
    }

    public String totalHistóricoDatosDescargados(){

        String mostrar = "";
        int desgargaHistorica = 0;

         for(Modulo m: modulo){

            if(m instanceof ModuloTierra){
                ModuloTierra t = (ModuloTierra) m;

                desgargaHistorica = desgargaHistorica + t.getTotalDescarga();
            }
        }
        mostrar = "Se han descargado: " + desgargaHistorica + " MB";
        return mostrar;

    }

    public String mayorDescaergaModuloTierra(){

        String empatados = "";
        int num= -1;
  



        for(int i = 0; i< modulo.size(); i++){

             if (modulo.get(i) instanceof ModuloTierra){ //compara si el modulo que evalua se encuentra/es tipo ModuloTierra

                ModuloTierra t = (ModuloTierra) modulo.get(i); //variab le temporar para que podamos accerder a los atributos propios de ModuloTierra

                int moduloActual = t.getTotalDescarga();
                
                if (moduloActual > num ){
                    num = moduloActual;
                }
             }
        
            }
        for (int h = 0; h < modulo.size() ; h ++){

            if (modulo.get(h) instanceof ModuloTierra){
                 ModuloTierra t = (ModuloTierra) modulo.get(h);
                if(t.getTotalDescarga() == num){
                    empatados = empatados +"\n"+ t.toString()  + "\n";
                }
            }
      
        }

        return "Modulo tierra con mayor cantidad histórica de datos descargados: \n " + empatados;

    }


    public String resumen(){
        String uno = cantidadModuloTierra();
        String dos = cantModuloTierraActivos();
        String tres =capacidadTotalDescargaTierraActivos();
        String cuatro =  totalHistóricoDatosDescargados();
        String cinco = mayorDescaergaModuloTierra();
        String mostrar = "\n \n*** Cantidad de Modulos Tierra \n " + uno + "\n \n*** Cantidad de Modulos Tierra ACTIVOS\n " + dos + "\n \n*** Capacidad Descarga Modulos Tierra\n " + tres + "\n \n*** Total Histórico de Descargas\n " + cuatro + "\n \n*** Modulo(s) Tierra con mayor descarga\n " + cinco;

        return mostrar;
    }


}