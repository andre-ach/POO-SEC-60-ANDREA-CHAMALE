import java.io.*;
import java.util.*;

public class Caso {

    private String nombreCaso;
    private int codigoCaso;
    private String nombreDetective;
    private Ubicacion [] ubicaciones;
    private ArrayList<Pista> pistas;

    public Caso(){
        nombreCaso = "";
        codigoCaso = 0;
        nombreDetective = "";
        ubicaciones = new Ubicacion[5];
        pistas = new ArrayList<Pista> ();
    }

    public Caso(String nombreCaso, int codigoCaso, String nombreDetective){
        this.nombreCaso = nombreCaso;
        this.codigoCaso = codigoCaso;
        this.nombreDetective = nombreDetective;
        
        ubicaciones = new Ubicacion[5];

        pistas = new ArrayList<Pista> ();

    }

    public  void setNombreCaso(String nombreCaso){
        this.nombreCaso = nombreCaso; 
    }

    public String getNombreCaso(){
        return this.nombreCaso;
    }

    public void setCodigCaso(int codigoCaso){
        this.codigoCaso = codigoCaso;
    }

    public int getCodigocaso(){
        return this.codigoCaso;
    }

    public void setNombreDetective(String nombreDetective){
        this.nombreDetective = nombreDetective;
    }

    public String getNombreDetective(){
        return this.nombreDetective;
    }

    public void setUbicacion(Ubicacion [] ubicaciones){
        this.ubicaciones = ubicaciones;
    }

    public Ubicacion [] getUbicaciones(){
        return ubicaciones;
    }

// Otros métods


    public void llenarUbicacion(int posicionOficial, int codigoUbicacion, String nombreUbicacion, String direccionUbicacion, int nivelRiesgo, String estadoUbicacion ){

        this.ubicaciones[posicionOficial] = new Ubicacion(codigoUbicacion, nombreUbicacion, direccionUbicacion, nivelRiesgo, estadoUbicacion);
        
    }


    public String consultarUbicaciones(){

        String ubicacionesLlevadas = "";

        if (this.ubicaciones == null) {
                return "No se han registrado ubicaciones en el sistema.";
        }

        for (int i = 0; i < this.ubicaciones.length; i++){
                if(this.ubicaciones[i] != null){
                    ubicacionesLlevadas = ubicacionesLlevadas + this.ubicaciones[i] + "\n";

                }
        }

        if (ubicacionesLlevadas.equals("")) {
            return "No se han registrado ubicaciones en el sistema.";
        }

        return "Los ubicaciones llevas son: "+ "\n"  + ubicacionesLlevadas;
    }
    

    public String consultarUbicacion(int posicion){

        try{

            String ubicacionBuscada = "";
            if (this.ubicaciones == null) {
                return "No se han registrado ubicaciones en el sistema.";
            }

             if(this.ubicaciones[posicion] != null){
                    ubicacionBuscada = this.ubicaciones[posicion] + "\n";
                 return "" + ubicaciones[posicion];
            }

        if (ubicaciones.equals("")) {
            return "No se encontró la ubicación: " + posicion;   
        }
         return "No se encontró la ubicación: " + posicion; 
        } catch(Exception e){
            return "No se encontró la ubicación: " + posicion;
        }
    }

    public String modificarUbicacion(int posicion,int nivelRiesgo, String estadoUbicacion ){

        this.ubicaciones[posicion].setNivelRiesgo(nivelRiesgo);
        this.ubicaciones[posicion].setEstadoUbicacion(estadoUbicacion);

        return "Listo";
    }

    public String descartarUbicacion(int posicion){


        this.ubicaciones[posicion] = null;
        return "¡Listo! La posicion " + posicion + " fue descartada";
    }

    public void registrarPista(int codigoPista, String descripcionPista, String tipoEvidencia, int nivelImportancia, int nivelConfiabilidad ){

        Pista pista = new Pista(codigoPista, descripcionPista, tipoEvidencia, nivelImportancia, nivelConfiabilidad);
        pistas.add(pista);

    }

    public String consultarPistas(){
        if (pistas.isEmpty()){
            return "No se han registrado pristas en el sistema.";
        }

        String pistasLlevadas = "";
            

            for (Pista p: pistas){

                pistasLlevadas = pistasLlevadas + "\n"+ "   |Codigo: " + p.getCodigoPista() + "\n"+  "   |Descipción: " + p.getDescripcionPista() + "\n"+ "   |Tipo Evidencia: " + p.getTipoEvidencia() + "\n" + "   |Nivel Importancia: " + p.getNivelImportancia() +"\n" + "   |Nivel Confiabilidad: " + p.getNivelConfiabilidad() + "\n ";
            }

        return pistasLlevadas;
    }

    public String buscarPistas(int codigo){
         try {
            if(pistas.isEmpty()){
                return "No se han registrado pistas en el sistema.";
            }

            for (Pista p: pistas){
                if(p.getCodigoPista()== codigo){
                    return "Código: " + p.getCodigoPista() + "\nDescipción: " + p.getDescripcionPista() + "\nTipo de Evidencia: " + p.getTipoEvidencia() + "\nNivel de importancia: " + p.getNivelImportancia() + "\nNivel de Confiabilidad: " + p.getNivelConfiabilidad();
                }
            }

            return "No se encontró la pista con el código: " + codigo;
        }catch(Exception e){
            return "No se encontró la pista con el código: " + codigo;
        }
        
    }

    public String modificarPista(int codigoPista, String descripcionPista, String tipoEvidencia, int nivelImportancia, int nivelConfiabilidad){

        try{
            for (Pista p: pistas){
                if(p.getCodigoPista() == codigoPista){
                    
                    p.setDescripcionPista(descripcionPista);
                    p.setTipoEvidencia(tipoEvidencia);
                    p.setNivelImportancia(nivelImportancia);
                    p.setNivelConfiabilidad(nivelConfiabilidad);

                    return "¡Proceso Exitoso!";
                }
                }
                
                return "¡Error! No se encontró pista con el código: " + codigoPista;

        }catch(Exception e){
            return "¡Error! No se logró realizar el cambio";

        }
    }

    public String eliminarPista(int codigo){
        if (pistas.isEmpty()){
            return "No se han registrado pistas en el sistema.";
        }

        try{

            for(int i = 0; i < pistas.size(); i++){

                if(pistas.get(i).getCodigoPista() == codigo){
                    pistas.remove(i);
                    return("Pista eliminada");
                }
            }

            return "No se encontró el código: " + codigo + "\n Es posible que no se hayan resitrado pistas.";

        }catch(Exception e){
            return "No se encontró el código: " + codigo + "\n Es posible que no se hayan resitrado pistas.";
        }
    }
    
    public String ubicacionMayorRiesgo(){

        if (estaVacio() == true){
            return "No se han registrado ubicaciones";
        }else{
        
        int num = 0;
        int posicion = 0;
        String posicionMostrar = "";

        for (int i = 0; i< ubicaciones.length; i++){
            
            if(ubicaciones[i]!= null){
                
                int riesgoActual = ubicaciones[i].getNivelRiesgo();
            
                if (riesgoActual > num){
                    num = riesgoActual;
                    posicionMostrar = " " + i;
                }else if (riesgoActual == num){
                    posicionMostrar = posicionMostrar + " " +i;
                }
            }
        }
        return posicionMostrar;
        }

    }

    public int cantidadPistas(){

        int conteoCantidad = 0;
        for(int i = 0; i < pistas.size(); i++){
            if(pistas != null){
                conteoCantidad = conteoCantidad + 1;
            }
        }
        return conteoCantidad;
    }

    public int cantidadUbicacionesRegistradas(){

        int conteoCantidad = 0;
        for(int i = 0; i < this.ubicaciones.length; i++){
            if(this.ubicaciones[i] != null){
                conteoCantidad = conteoCantidad + 1;
            }
        }
        return conteoCantidad;
    }

    public int cantidadUbicacionesLibres(){

        int cantidadOcupada = cantidadUbicacionesRegistradas();
        int  ubicacionesLibres = 5 - cantidadOcupada;

        return ubicacionesLibres;
    }

    public String pistaMayorImportancia(){

        try {
            if (pistas.isEmpty()){
                return "Pista con mayor importancia: No se han registrado pistas en el sitema.";
            }

            int num = 0;
            int pistaCodigo = 0;
            String pistaEmpatados = "";

            for(int i = 0; i < pistas.size(); i++){

                int pistaActual = pistas.get(i).getNivelImportancia();

                if(pistaActual > num){
                    num = pistaActual;

                    pistaCodigo = pistas.get(i).getCodigoPista();
                }
            }

            for(int h = 0; h < pistas.size(); h++){

                if(pistas.get(h).getNivelImportancia() == num){
                    pistaEmpatados = pistaEmpatados + pistas.get(h).getCodigoPista() + " | ";
                }
            }

            return "Pista/Pistas con mayor nivel de importancia (código):  " +  pistaEmpatados;

        }catch(Exception e){
            return "¡Error! Es posible que no se han registrados pistas";
        }

    }

    public String pistaMayorConfiabilidad(){
        try {
            if (pistas.isEmpty()){
                return "Pista con mayor confiabilidad: No se han registrado pistas en el sitema.";
            }

            int num = 0;
            int pistaCodigo = 0;
            String pistaEmpatados = "";

            for(int i = 0; i < pistas.size(); i++){

                int pistaActual = pistas.get(i).getNivelConfiabilidad();

                if(pistaActual > num){
                    num = pistaActual;

                    pistaCodigo = pistas.get(i).getCodigoPista();
                }
            }

            for(int h = 0; h < pistas.size(); h++){

                if(pistas.get(h).getNivelConfiabilidad() == num){
                    pistaEmpatados = pistaEmpatados + pistas.get(h).getCodigoPista() + " | ";
                }
            }

            return "Pista/Pistas con mayor nivel de confiabilidad (código):  " +  pistaEmpatados;

        }catch(Exception e){
            return "¡Error! Es posible que no se han registrados pistas";
        }
    }

    public String promedioNivelImportancia(){


         try {
            if (pistas.isEmpty()){
                return "No se han registrado pistas en el sitema.";
            }

            int sumaNivelImportancia = 0;
            int dividir = 0;

            for(Pista p: pistas){
                
                if(p != null){
                    
                    dividir= dividir + 1;

                    int nivelImportancia = p.getNivelImportancia();
                    sumaNivelImportancia = sumaNivelImportancia + nivelImportancia;
                }
            }

            float total = (float) sumaNivelImportancia/dividir;


            return " " + total;
            

        }catch(Exception e){
            return "¡Error! Es posible que no se han registrados pistas";
        }
    }


    // VALIDADORES

    public boolean validarCodigo(int codigo){
        
        for (Ubicacion ubicaciones : this.ubicaciones){

            if (ubicaciones !=null){
                if(ubicaciones.getCodigoUbicacion() == codigo){
                return true;
            }
            }
        } 
        return false;
    }


    public boolean validarRegistro(int posicion){
        return false;
    }

    public boolean posicionOcupada(int posicion){

        boolean estado = false;
            if (ubicaciones[posicion] != null){
                estado = false;
                return estado; 
            }else {
                estado= true;
            }
        return estado;
    }

    public boolean estaVacio() {
       
        for (int i = 0; i < this.ubicaciones.length; i++) {
            if (this.ubicaciones[i] != null) {
                return false;
            }
        }
        
        return true;
    }

    public boolean estaVacioPosicionUbicacion(int posicion){

        if (this.ubicaciones[posicion] != null){
            return false;
        }else{
            return true;
        }

    }

    public boolean seLlenoAreglo(){


        for(int i = 0; i < this.ubicaciones.length; i++){
             if (this.ubicaciones[i] == null) {
            return false; 
            }
        }

        return true;

    }

    public boolean validarCodigoPista(int codigoPista){

        for (Pista p: pistas){
            if (p.getCodigoPista() == codigoPista){
                return true;
            }
        }

        return false; 
    }

    public boolean estaLlenoPista(){

        if (pistas.isEmpty()) {
                return false;
            }
        return true;
    }

}