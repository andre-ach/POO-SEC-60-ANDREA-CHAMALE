import java.util.ArrayList;
import java.util.List;

public class Admin{

    private ArrayList<Prestamo> prestamos;

    public Admin(){
        prestamos = new ArrayList<Prestamo>();
    }

    public void llenarPrestamo(int codigoPrestamo, int carnetEstudiante, String nombreEstudiante, String tituloLibro, int diasAutorizados){
        
        Prestamo prestamo = new Prestamo (codigoPrestamo, carnetEstudiante, nombreEstudiante, tituloLibro, diasAutorizados);
        prestamos.add(prestamo);
    }


    public boolean validarCodigo(int validarCodigo){

        for (Prestamo p : prestamos){

            if(p.getCodigoPrestamo() == validarCodigo){
                return true;
            }
        }

        return false;
    }

    public boolean estaLleno(){

        if (prestamos.isEmpty()) {
                return false;
            }
        return true;
    }


    public String consultaPrestamo(){

        if (prestamos.isEmpty()) {
                return "No se han registrado préstamos en el sistema.";
            }
        
        String prestamosLlevados = "";

        for (Prestamo p : prestamos){
                prestamosLlevados = prestamosLlevados + "Código: "+ p.getCodigoPrestamo() + "   | Carnet:" + p.getCarnetEstudiante()+ "   | Nombre: "+ p.getNombreEstudiante()+ "   | Libro: " + p.getTituloLibro() + "   |  Días prestado: "+ p.getDiasAutorizados() + "\n "+ "\n";
        }
        return prestamosLlevados;
    }

    public String buscarPrestamo(int codigo){

        try {

            if (prestamos.isEmpty()) {
                return "No se han registrado préstamos en el sistema.";
            }

            for (Prestamo p : prestamos){

                if (p.getCodigoPrestamo() == codigo){

                    return "Código: "+ p.getCodigoPrestamo() + "         Carnet:" + p.getCarnetEstudiante()+ "         Nombre: "+ p.getNombreEstudiante()+ "         Libro: " + p.getTituloLibro() + "         Días prestado: "+ p.getDiasAutorizados();

                }
            }

            return  "\nNo se encontró el préstamo con el código: " + codigo;

        }catch(Exception e){
            return "No se encontró el préstamo con el código: " + codigo;
        }
        
    }

    public String modificarPrestamo(int codigo, String titulo, int cantidadDiasAutorizados){


        try{

            for (Prestamo p : prestamos){

                if (p.getCodigoPrestamo() == codigo){

                    p.setTituloLibro(titulo);
                    p.setDiasAutorizados(cantidadDiasAutorizados);
                    return "Proceso exitoso!";
                    
                }
            }

            return "¡Erro! No se econtró ningun prestmo código: " + codigo;
            
            
        }
        catch(Exception e){
            return "!Error¡ No se logró realizar el cambio";
        }

    } 

    public String registrarDevolucion(int codigo){

        if (prestamos.isEmpty()) {
                return "No se han registrado préstamos en el sistema.";
            }

        try{
            
            for (int i = 0; i < prestamos.size(); i++){

                if (prestamos.get(i).getCodigoPrestamo() == codigo){

                    prestamos.remove(i);
                    
                    return "Devolución registrada";
                    
                    }
            }

            return "No se encontró ningún prestamo con el código: " + codigo;

        }
        catch(Exception e){
            return "No se encontró el código: " + codigo + "\n Es posible que no se hayan resitrado prestamos";
        }
    }

    public boolean validarCarnet(int carnet){

        for (Prestamo p : prestamos){

            if(p.getCarnetEstudiante() == carnet){
                return true;
            }
        }

        return false;
    }

    public String consultarPrestamoEstudiante(int carnet){

        if (prestamos.isEmpty()) {
                return "No se han registrado préstamos en el sistema.";
            }

        try {
            
            String prestamosLlevadosEstudiante = "";

            for (int i = 0; i < prestamos.size(); i++){
                
                if (prestamos.get(i).getCarnetEstudiante() == carnet){
                    prestamosLlevadosEstudiante= prestamosLlevadosEstudiante +"Código: "+ prestamos.get(i).getCodigoPrestamo() + "  | Carnet:" + prestamos.get(i).getCarnetEstudiante()+ "  | Nombre: "+ prestamos.get(i).getNombreEstudiante()+ "  | Libro: " + prestamos.get(i).getTituloLibro() + "  | Días prestado: "+ prestamos.get(i).getDiasAutorizados() + "\n";
                }
            }
                return prestamosLlevadosEstudiante;

        }catch(Exception e){
            return "No se encontró el carnet: " + carnet + "\n Es posible que no se hayan resitrado prestamos";
        }
    }

    public int reporteDiasAutorizados(){

        int totalDiasAutorizados = 0;

        for (Prestamo p : prestamos){
                totalDiasAutorizados = totalDiasAutorizados + p.getDiasAutorizados();
        }
        return totalDiasAutorizados;

    }

    public String prestamoMayorDuracion(){

        try {

            if (prestamos.isEmpty()) {
                return "No se han registrado préstamos en el sistema.";
            }

            int num = 0;
            int prestamoCodigo= 0;
            String prestamo = "";
             String prestamosEmpatados = "";

            for (int i = 0; i < prestamos.size(); i++){

                int prestamoActual = prestamos.get(i).getDiasAutorizados();
                
                if (prestamoActual >num ){
                    num = prestamoActual;

                    prestamoCodigo = prestamos.get(i).getCodigoPrestamo(); 
                }
            }

             for (int h = 0; h < prestamos.size(); h++){

                if (prestamos.get(h).getDiasAutorizados() == num){
                    prestamosEmpatados = prestamosEmpatados + " [" + prestamos.get(h).getCodigoPrestamo() + "] ";
                }
            }

            return "El préstamo (o préstamos) con mayor duración (" + num + " días) corresponde a los códigos:" + prestamosEmpatados;

        }catch (Exception e){
            return "¡ERROR! Es posible que no se han registrado prestámos";
        }
    }

    public int cantidadPrestamos(){
        int cantidadPrestamos = prestamos.size();

        return cantidadPrestamos;
    }


}
