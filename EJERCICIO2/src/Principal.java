import java.util.Scanner;
import java.text.DecimalFormat;

public class   Principal {


    public Principal(){

    }

    public static void main(String [] args){
        Scanner teclado = new Scanner(System.in);

        System.out.println("\n \n ************** Bienvenido **************");

        System.out.println("Ingrese su nombre: ");
        String nombre = teclado.nextLine();

        System.out.println("Ingrese su nombre de usuario: ");
        String nombreUsuario = teclado.nextLine();

        System.out.println("Ingrese su edad: ");
        int edad = teclado.nextInt();
        teclado.nextLine();

        System.out.println("\nIngrese la cantidad de películas que desea registrar (máx 10): ");
        int cant = teclado.nextInt();
        teclado.nextLine();
        

        Usuario usuario = new Usuario (nombre, nombreUsuario, edad);

        String resultadoVerificacion = usuario.validarCant(cant);

        usuario.validarCant(cant);

        while (!resultadoVerificacion.equals("VÁLIDO")){
            System.out.println("\nParametro ¡NO VALIDO! \nIngrese la cantidad de películas que desea registrar (máx 10):");
            cant = teclado.nextInt();
            teclado.nextLine();
            resultadoVerificacion = usuario.validarCant(cant);
            usuario.validarCant(cant);
        }

//  PEDIR DATOS PARA PELICULA

        System.out.println("\n ************** CALIFICACIÓN MOVIES **************");
        System.out.println("Ingrese el titulo de la película e ingrese su \ncalifcación  de 1 a 10");

        
        for (int i = 1; i<= cant; i++){
        System.out.println("\n--------- Película "+ i + "---------");

        System.out.println("Ingrese el nombre de la película");
        String nombreP = teclado.nextLine();
        
        System.out.println("Ingrese la calificación (1 a 10): ");
        float calificacion = teclado.nextFloat();
        teclado.nextLine();


        String verificacionCalificacion = usuario.validarCalificacion(calificacion);

        usuario.validarCalificacion(calificacion);

        while (!verificacionCalificacion.equals("VÁLIDO")){
            System.out.println("\nParametro ¡NO VALIDO! \nIngrese la calificación (1 a 10): ");
            calificacion = teclado.nextInt();
            teclado.nextLine();

            verificacionCalificacion = usuario.validarCalificacion(calificacion);
            usuario.validarCalificacion(calificacion);
        }
        usuario.llenarPelicula(i, nombreP, calificacion);
    }

//Datos
        System.out.println("\n ************** DATOS **************");
    
    //La calificaciones que lleva
        System.out.println("\n ------ Ingresados Hasta Ahora ------ ");

        System.out.println("Las calificaciones llevas son:\n" + usuario.consultarCalificaciones());
    
    //Buscar película 
        System.out.println("\n ------ Consultar Película ------ ");
        
        int cant2 = cant; 

        for (int i = 0; i< cant2; i++){ 

            Pelicula pelicula = usuario.getCalificacionPelicula()[i];
            
            System.out.println(i +" --> " + pelicula.getNombre());
        }
        
        System.out.println("Ingrese el NÚMERO de la película: ");
        int posicionC = teclado.nextInt();
        teclado.nextLine();


        String  validarCantidad2 =  usuario.validarPosicion(cant2, posicionC);
        usuario.validarPosicion(cant2, posicionC);


        while (!validarCantidad2.equals("VÁLIDO")){
            System.out.println("\nParametro ¡NO VALIDO! \nIngrese el NÚMERO de la película: ");
            posicionC = teclado.nextInt();
            teclado.nextLine();
            validarCantidad2 = usuario.validarPosicion(cant2, posicionC);
            usuario.validarPosicion(cant2, posicionC);
        }

        int peliculaP = posicionC;

        System.out.println("La calificacion de esta película es de: " + usuario.consultarPelicula(peliculaP));
    
    //CAMBIAR NOTA 
        System.out.println("\n ------ Cambiar Calificación ------ ");
        
        for (int i = 0; i< cant2; i++){ 

            Pelicula pelicula = usuario.getCalificacionPelicula()[i];
            
            System.out.println(i +" --> " + pelicula.getNombre());
        }

        System.out.println("Ingrese el NÚMERO de la película que desea cambiar la nota: ");
        int posicionC3 = teclado.nextInt();
        teclado.nextLine();
        
        String  validarCantidad3 =  usuario.validarPosicion(cant2, posicionC3);
        usuario.validarPosicion(cant2, posicionC3);

        while (!validarCantidad3.equals("VÁLIDO")){
            System.out.println("\nParametro ¡NO VALIDO! \nIngrese el NÚMERO de la película: ");
            posicionC3 = teclado.nextInt();
            teclado.nextLine();
            validarCantidad3 = usuario.validarPosicion(cant2, posicionC3);
            usuario.validarPosicion(cant2, posicionC3);
        }

        usuario.validarPosicion(cant2, posicionC3);

        int cambiarCalificacion = posicionC3;

        System.out.println("Por cual desea cambiar la calificación: ");
        float nuevaCalificacion = teclado.nextFloat();

        usuario.validarCalificacion(nuevaCalificacion);
        
        String verificacionCalificacion2 = usuario.validarCalificacion(nuevaCalificacion);
        
        usuario.validarCalificacion(nuevaCalificacion);

        while (!verificacionCalificacion2.equals("VÁLIDO")){
            System.out.println("\nParametro ¡NO VALIDO! \nIngrese la nueva calificación  (1 a 10): ");
            nuevaCalificacion = teclado.nextInt();
            teclado.nextLine();
            verificacionCalificacion2 = usuario.validarCalificacion(nuevaCalificacion);
            usuario.validarCalificacion(nuevaCalificacion);
        }

        float enviar = nuevaCalificacion;

        usuario.modificacionCalificacion(cambiarCalificacion,enviar);
        
        
        Pelicula calificacion = usuario.getCalificacionPelicula()[cambiarCalificacion];
        
        System.out.println("¡El cambio ha sido exitso! \nAhora la calificacion es: "+ calificacion.getCalificacion());

        System.out.println("\n ------ ACTUALIZACION DE CALIFICACIONES ------ ");

        System.out.println("Las nuevas calificaciones son:\n"+usuario.consultarCalificaciones());
        
    //Promedio  
        System.out.println("\n ------ Promedio ------ ");

        float promedio = usuario.promedio();
            DecimalFormat formato = new DecimalFormat("0.00");

            System.out.println("El promedio de las películas es de " + formato.format(promedio));
        
    // Calificación alta 
        System.out.println("\n ------ Mejor y Peor Calificación ------ ");


        System.out.println("\n La calificación más alta es de: " + usuario.calificacionAlta(cant));
        System.out.println("\n La calificación más baja es de: " + usuario.calificacionBaja(cant));
    
    //Disponibilidad
        System.out.println("\n ------ Espacios Disponibles ------ ");

        System.out.println("Has clasificado: " + cant2 + "\nPosiciones disponbiles: " + usuario.espacioDisponible(cant));

        
}
}
