import java.io.*;
import java.util.*;

public class Usuario{

    private String nombre;
    private String nombreUsuario;
    private int edad;
    private Pelicula [] calificacionPelicula;

    public Usuario(){
        nombre = "";
        nombreUsuario = "";
        edad = 0;
        calificacionPelicula = new Pelicula[10]; 
    }

// GET & SET

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario(){
        return this.nombreUsuario;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public int getEdad(){
        return edad;
    }

    public Pelicula [] getCalificacionPelicula(){
       return calificacionPelicula;
    }
//Otros métodos 

    public Usuario(String nombre, String nombreUsuario, int edad){
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.edad = edad;
        calificacionPelicula = new Pelicula[10];
    }

    public void llenarPelicula(int cual, String nombreP, float calificacion){
        calificacionPelicula[cual-1] = new Pelicula(nombreP, calificacion);
    }
    
    public String validarCant(int cantidad){
        if(cantidad >10){
            return "INVÁLIDO";
        } 
            return "VÁLIDO";
    }

    public String validarCalificacion(float calificacion){
       
        if(calificacion > 0 && calificacion <= 10){
            return "VÁLIDO";
        } 
            return "INVÁLIDO";
            
    }

    public String consultarCalificaciones(){
        String calificacionesLlevadas = "";

        for (Pelicula calificacionPelicula : this.calificacionPelicula){
            if (calificacionPelicula != null){
                calificacionesLlevadas = calificacionesLlevadas + calificacionPelicula.toString() + "\n";
            }
        }
            return calificacionesLlevadas;
    }

    public String consultarPelicula(int posiC){

            return  " " + calificacionPelicula[posiC];
    }

    public float promedio (){

        float suma = 0;
        int i = 0;

        while ((i<10) && calificacionPelicula[i] != null){
            suma = suma + calificacionPelicula[i].getCalificacion();
            i ++;
        }
        return suma/i;
    }

    public String validarPosicion(int cant2, int posicion){

            if(posicion >= 0 && posicion < cant2){

            return "VÁLIDO";

            } 
            return "INVÁLIDO";
    }
    
    public void modificacionCalificacion(int posicion, float nuevacalificacion){
        
        calificacionPelicula[posicion].setCalificacion(nuevacalificacion);
         
    }

    public int espacioDisponible(int cant2){
        
        int cantDisponible = 10 - cant2;

       return cantDisponible; 
    }

    public float calificacionAlta(int cant){

        float num = 0;

        for (int i = 0; i< cant; i++ ){

             float calificacionActual = calificacionPelicula[i].getCalificacion();

            if (calificacionActual > num) {
                num = calificacionActual;
            }
            
        }
        return num;
    } 

    public float calificacionBaja(int cant){

        float num= calificacionPelicula[0].getCalificacion();

        for (int i = 0; i< cant; i++ ){

            float calificacionActual = calificacionPelicula[i].getCalificacion();

            if (calificacionActual < num) {
            num = calificacionActual;
            } 
            
        }

        return num;
    } 

    }

