import java.io.*;
import java.util.*;


public class Pelicula {

    private String nombre;
    private float calificacion;

    public Pelicula(){
        nombre = "";
        calificacion = 0;
    }

    public Pelicula (String nombre, float calificacion){
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }
    
    public void setCalificacion(float calificacion){
        this.calificacion = calificacion;
    }

    public float getCalificacion(){
        return this.calificacion;
    }

    public String toString(){
        return this.calificacion + " ";
    }


}