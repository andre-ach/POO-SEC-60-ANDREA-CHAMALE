import java.util.Scanner;
import java.util.InputMismatchException;

public class Principal{

    public Principal(){}

    /**
     * @param args
     */
    
    public static void main(String [] args){
        Scanner teclado = new Scanner(System.in);

        String nombreCaso = "";
        int codigoCaso = 0;
        String nombreDetective = "";
        boolean error3 = true;
        
        System.out.println("¡Bienvenid@ a Agencias de Detectives!");

        

        System.out.println("\n********* CASO INFORMACIÓN *********");

      

        System.out.println("\nIngrese el nombre del caso: ");
        
            error3 = true;

            while (error3 == true){
                        
                try{

                            nombreCaso = teclado.nextLine();
                            error3 = false;
                                
                            if (nombreCaso.isBlank()) {  //"Valida" que no este vacío
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                error3 = true;
                            }

                }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error3 = true;
                }
            }

        System.out.println("\nIngrese el codigo del caso: ");
                        error3 = true;

            while (error3 == true){
                try{
                                codigoCaso = teclado.nextInt();
                                teclado.nextLine();
                                error3 = false;
                                
                }catch(InputMismatchException e){
                                System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                teclado.nextLine();
                                error3 = true;
                            }finally{
                                System.out.println("\n Este es el último dato por ingresar\n");
                            }
                }
        
        System.out.println("\nIngrese el nombre del detective: ");
                        
            error3 = true;

            while (error3 == true){
                        
                try{

                            nombreDetective = teclado.nextLine();
                            error3 = false;
                                
                            if (nombreDetective.isBlank()) {  //"Valida" que no este vacío
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                error3 = true;
                            }

                }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error3 = true;
                }
            }

        Caso caso = new Caso(nombreCaso, codigoCaso, nombreDetective);

        /////////////// MENÚ 

        int accion = 0;

        while(accion != 13){

            System.out.println("\n********* MENÚ *********");
            System.out.println("\n1. Nuevo caso \n2. Registrar ubicación  \n3. Consultar ubicaciones \n4. Consultar una ubicación  \n5. Modificar ubicación  \n6. Descartar ubicación   \n7. Registrar pista  \n8. Consultar pistas  \n9. Buscar pista  \n10. Modificar pista \n11. Eliminar pista \n12. Mostrar reporte de investigación \n13. Salir ");
            System.out.println("Ingrese el número de la opción que desee: ");
            
            boolean error = true;

            while (error == true){
                try{
                    accion = teclado.nextInt();
                    teclado.nextLine();
                    error = false;

                    if (accion > 13 || accion < 1) {
                        System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                        error = true;
                    }

                }catch(Exception e){
                    System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                    teclado.nextLine();
                    error = true;
                     
                }
            }

             switch (accion){
                case 1:

                    System.out.println("\n********* Nuevo Caso *********");

                    System.out.println("\nIngrese el nombre del caso: ");
                
                    error3 = true;

                    while (error3 == true){
                                
                        try{

                                    nombreCaso = teclado.nextLine();
                                    error3 = false;
                                        
                                    if (nombreCaso.isBlank()) {  //"Valida" que no este vacío
                                        System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                        error3 = true;
                                    }

                        }catch(Exception e){
                                    System.out.println("\n¡Error inesperado, intenta de nuevo!");
                                    teclado.nextLine();
                                    error3 = true;
                        }
                    }

                System.out.println("\nIngrese el codigo del caso: ");
                                error3 = true;

                    while (error3 == true){
                        try{
                                        codigoCaso = teclado.nextInt();
                                        teclado.nextLine();
                                        error3 = false;
                                        
                        }catch(InputMismatchException e){
                                        System.out.println("\n¡Intente de nuevo! Ingresa un valor válido: ");
                                        teclado.nextLine();
                                        error3 = true;
                                    }finally{
                                        System.out.println("\n Este es el último dato por ingresar\n");
                                    }
                        }
                
                System.out.println("\nIngrese el nombre del detective: ");
                                
                    error3 = true;

                    while (error3 == true){
                                
                        try{

                                    nombreDetective = teclado.nextLine();
                                    error3 = false;
                                        
                                    if (nombreDetective.isBlank()) {  //"Valida" que no este vacío
                                        System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                        error3 = true;
                                    }

                        }catch(Exception e){
                                    System.out.println("\n¡Error inesperado, intenta de nuevo!");
                                    teclado.nextLine();
                                    error3 = true;
                        }
                    }

                caso = new Caso(nombreCaso, codigoCaso, nombreDetective);
                
                
                    break;

                case 2:


                    System.out.println("\n********* Registrar Ubicación *********");


                    int codigoUbicacion = 0;
                    String nombreUbicacion = "";
                    String direccionUbicacion = "";
                    int nivelRiesgo = 0;
                    String estadoUbicacion = "";
                    int posicionubicacion =0;


                    boolean LlenoAreglo = caso.seLlenoAreglo();

                    if (LlenoAreglo == false){

                    error = true; 
            
                    while (error == true){
                            try{
                                System.out.println("\nIngrese la posición de la ubicación: ");
                                posicionubicacion = teclado.nextInt();
                                teclado.nextLine();
                                error = false;
                                
                                if (posicionubicacion < 0 || posicionubicacion > 4){
                                    System.out.println("\n¡Intente de nuevo! Ingresa una posición entre 0 a 4: ");
                                    error = true;
                                }else {
                                    
                                    int validarPosicion = posicionubicacion;
                                    boolean ocupado = caso.posicionOcupada(validarPosicion);
                                    
                                    if (ocupado == false ){

                                    System.out.println("\n¡Esa posición ya fue llenada!");
                                    error = true;
                                    }else{
                                        System.out.println("¡Posición aceptada!");
                                        error = false;
                                    }

                                }
                                
                            }catch(InputMismatchException e){
                                System.out.println("\n¡Intente de nuevo! Ingresa una posición entre 0 a 4: ");
                                teclado.nextLine();
                                error = true;
                            }
                    }



                    System.out.println("\nIngrese el código de la ubicación: ");

                    error = true; 

                    while (error == true){
                        
                        try {
                            codigoUbicacion = teclado.nextInt();
                            teclado.nextLine();

                            int validarCodigo = codigoUbicacion;

                            error =  caso.validarCodigo(validarCodigo);

                            if (error == true) {
                                System.out.println("\n¡El código ya existe! Ingresa un número válido: ");

                            }
         
                        }catch(InputMismatchException e){
                            System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                            teclado.nextLine();
                            error = true;          
                        } 
                    }

                    System.out.println("\nIngrese el nombre de la ubicación: ");
                        
                    error = true;

                    while (error == true){
                        
                        try{

                            nombreUbicacion = teclado.nextLine();
                            error = false;
                                
                            if (nombreUbicacion.isBlank()) {  //"Valida" que no este vacío
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }


                    System.out.println("\nIngrese la dirección: ");
                        
                    error = true;

                    while (error == true){
                        
                        try{

                            direccionUbicacion = teclado.nextLine();
                            error = false;
                                
                            if (direccionUbicacion.isBlank()) { 
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }

                    System.out.println("\nIngrese el nivel de riesgo de 1 a 10 : ");
                        error = true;

                    while (error == true){
                            try{
                                nivelRiesgo = teclado.nextInt();
                                teclado.nextLine();
                                error = false;
                                
                                if (nivelRiesgo < 1 || nivelRiesgo > 10){
                                    System.out.println("\n¡Intente de nuevo! Ingresa un número (1 a 10): ");
                                    error = true;
                                }
                                
                            }catch(InputMismatchException e){
                                System.out.println("\n¡Intente de nuevo! Ingresa un número (1 a 10): ");
                                teclado.nextLine();
                                error = true;
                            }finally{
                                System.out.println("\n Este es el último dato por ingresar\n");
                            }
                    }

                    System.out.println("\nIngrese el estado de la ubicación: ");
                        
                    error = true;

                    while (error == true){
                        
                        try{

                            estadoUbicacion = teclado.nextLine();
                            error = false;
                                
                            if (estadoUbicacion.isBlank()) { 
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }
                    
                    caso.llenarUbicacion(posicionubicacion,codigoUbicacion, nombreUbicacion, direccionUbicacion, nivelRiesgo, estadoUbicacion);

                    }else{
                        System.out.println("¡Ya todas las posiciones fueron usadas!");
                    }

                break;

                case 3:
                    
                    System.out.println("\n********* Consultar Ubicaciones *********");

                    System.out.println(caso.consultarUbicaciones());

                    break;

                case 4:
                    int posicionBuscar = 0;
                    System.out.println("\n********* Consultar Una Ubicación *********");

                    System.out.println("\nIngrese la posición (0 a 4): ");
                    error = true;

                    while (error == true){

                        try { 
                            posicionBuscar = teclado.nextInt();
                            teclado.nextLine();

                            if (posicionBuscar < 0 || posicionBuscar > 4){
                                    System.out.println("\n¡Intente de nuevo! Ingresa una posición entre 0 a 4: ");
                                    error = true;
                            }else {
                                error = false;
                            }

                        }catch (InputMismatchException e){
                            System.out.println("\n¡Intente de nuevo! Ingresa un código válido: ");
                            teclado.nextLine();
                            error = true;
                        }
                    }

                    System.out.println("Estos son los dato: \n" + caso.consultarUbicacion(posicionBuscar));
                    break;

                case 5:
                    
                    int codigoUbicacionNuevo = 0;
                    String nombreUbicacionNuevo = "";
                    String direccionUbicacionNuevo = "";
                    int nivelRiesgoNuevo = 0;
                    String estadoUbicacionNuevo = "";
                    int posicionubicacionNuevo =0;

                    System.out.println("\n********* Modificar ubicación *********");

                    if(caso.estaVacio() == false){

                            error = true;

                            while(error == true){
                            
                            System.out.println("\nIngrese la posición de la ubicación (0 a 4): ");

                                try{
                                    posicionubicacionNuevo = teclado.nextInt();
                                    teclado.nextLine();
                                    error = false;

                                    int validar = posicionubicacionNuevo;
                                    
                                    if (posicionubicacionNuevo < 0 || posicionubicacionNuevo > 4){
                                        System.out.println("\n¡Intente de nuevo! Ingresa una posición entre 0 a 4: ");
                                        error = true;
                                    }else  if(caso.estaVacioPosicionUbicacion(validar) == true){
                                        System.out.println("\n¡Intente de nuevo! Ingresa una posición entre 0 a 4 que ya fue registrada: ");
                                        error = true;
                                    }else {
                                        System.out.println("¡Posición aceptada!");
                                        error = false;
                                    }
                                }catch(InputMismatchException e){
                                    System.out.println("\n¡Intente de nuevo! Ingresa una posición entre 0 a 4: ");
                                    teclado.nextLine();
                                    error = true;
                                }
                            }

                            
                            System.out.println("\nIngrese el nivel de riesgo de 1 a 10 : ");
                                error = true;

                            while (error == true){
                                    try{
                                        nivelRiesgoNuevo = teclado.nextInt();
                                        teclado.nextLine();
                                        error = false;
                                        
                                        if (nivelRiesgoNuevo < 1 || nivelRiesgoNuevo > 10){
                                            System.out.println("\n¡Intente de nuevo! Ingresa un número 1 al 10: ");
                                            error = true;
                                        }
                                        
                                    }catch(InputMismatchException e){
                                        System.out.println("\n¡Intente de nuevo! Ingresa un número 1 al 10: ");
                                        teclado.nextLine();
                                        error = true;
                                    }finally{
                                        System.out.println("\n Este es el último dato por ingresar\n");
                                    }
                            }

                            System.out.println("\nIngrese el estado de la ubicación: ");
                                
                            error = true;

                            while (error == true){
                                
                                try{

                                    estadoUbicacionNuevo = teclado.nextLine();
                                    error = false;
                                        
                                    if (estadoUbicacionNuevo.isBlank()) { 
                                        System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                        error = true;
                                    }

                                }catch(Exception e){
                                    System.out.println("\n¡Error inesperado, intenta de nuevo!");
                                    teclado.nextLine();
                                    error = true;
                                }
                            }

                            System.out.println(caso.modificarUbicacion(posicionubicacionNuevo,nivelRiesgoNuevo,estadoUbicacionNuevo)) ; 
                            
        
                        }else {
                            System.out.println("No se han registrado ubicaciones.");
                        }

    
                    break;
                case 6: 
                    System.out.println("\n********* Descartar ubicación *********");

                    int posicionubicacionDescartar = 0;

                     if(caso.estaVacio() == false){

                            error = true;

                            while(error == true){
                            
                            System.out.println("\nIngrese la posición de la ubicación (0 a 4): ");

                                try{
                                    posicionubicacionDescartar = teclado.nextInt();
                                    teclado.nextLine();
                                    error = false;

                                    int validar = posicionubicacionDescartar;
                                    
                                    if (posicionubicacionDescartar < 0 || posicionubicacionDescartar > 4){
                                        System.out.println("\n¡Intente de nuevo! Ingresa una posición entre 0 a 4: ");
                                        error = true;
                                    }else  if(caso.estaVacioPosicionUbicacion(validar) == true){
                                        System.out.println("\n¡Intente de nuevo! Ingresa una posición entre 0 a 4 que ya fue registrada: ");
                                        error = true;
                                    }else {
                                        System.out.println("¡Posición aceptada!");
                                        error = false;
                                    }
                                }catch(InputMismatchException e){
                                    System.out.println("\n¡Intente de nuevo! Ingresa una posición entre 0 a 4: ");
                                    teclado.nextLine();
                                    error = true;
                                }
                            }

                        System.out.println(caso.descartarUbicacion(posicionubicacionDescartar));


                     }else{
                        System.out.println("No se han registrado ubicaciones.");
                     }

                    break;

                case 7:

                    System.out.println("\n********* Registar Pista *********");

                    int codigoPista = 0;
                    String descripcionPista = "";
                    String tipoEvidencia = "";
                    int nivelImportancia = 0;
                    int nivelConfiabilidad = 0;

                    error = true; 

                    System.out.println("\nIngrese el codigo de la Pista: ");

                    while (error == true){
                        
                        try {
                            codigoPista = teclado.nextInt();
                            teclado.nextLine();

                            int validarCodigo = codigoPista;

                            error =  caso.validarCodigoPista(validarCodigo);

                            if (error == true) {
                                System.out.println("\n¡El código ya existe! Ingresa un número válido: ");
                            }

         
                        }catch(Exception e){
                            System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                            teclado.nextLine();
                            error = true;
                        } 
                    }

                    System.out.println("\nIngrese la descripción: ");
                    error = true;

                    while (error == true){
                        try{
                            descripcionPista = teclado.nextLine();
                            error = false;
                            
                            if (descripcionPista.isBlank()) {  //"Valida" que no este vacío
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                 error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }


                    System.out.println("\nIngrese el tipo de evidencia: ");
                    error = true;

                    while (error == true){
                        try{
                            tipoEvidencia = teclado.nextLine();
                            error = false;
                            
                            if (tipoEvidencia.isBlank()) {  //"Valida" que no este vacío
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                 error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }

                    System.out.println("Ingrese el nivel de Importancia 1 a 10: ");
                    error = true;

                    while (error == true){
                
                        try{
                            nivelImportancia = teclado.nextInt();
                            teclado.nextLine();
                            error = false;

                            if (nivelImportancia > 10 || nivelImportancia < 1) {
                                System.out.println("\n¡Intente de nuevo! Ingresa una opción válida (1 a 10): ");
                                error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                            teclado.nextLine();
                            error = true;
                        }
                    }

                    System.out.println("Ingrese el nivel de confiabilidad 1 a 100: ");
                    error = true;

                    while (error == true){
                
                        try{
                            nivelConfiabilidad = teclado.nextInt();
                            teclado.nextLine();
                            error = false;

                            if (nivelConfiabilidad > 100 || nivelConfiabilidad < 1) {
                                System.out.println("\n¡Intente de nuevo! Ingresa una opción válida (1 a 10): ");
                                error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                            teclado.nextLine();
                            error = true;
                        }
                    }

                    caso.registrarPista(codigoPista,descripcionPista,tipoEvidencia,nivelImportancia,nivelConfiabilidad);

                    System.out.println("¡Pista registrada!");
                    break;

                case 8: 
                    System.out.println("\n********* Consultar pistas *********");
                    
                    System.out.println("\nLas pistas llevadas son:\n \n"+ caso.consultarPistas());

                    break;

                case 9:
                    System.out.println("\n********* Buscar pista *********");

                    int buscarCodigoPista = 0;
                    System.out.println("\nIngrese el codigo de la pista que desea buscar: ");
                    error = true;

                    while(error == true){
                        try{
                            buscarCodigoPista = teclado.nextInt();
                            teclado.nextLine();
                            error = false;
                        }catch(Exception e){
                            System.out.println("\n¡Intente de nuevo! Ingresa un código válido: ");
                            teclado.nextLine();
                            error = true;
                        }
                    }

                    System.out.println(caso.buscarPistas(buscarCodigoPista));

                    break;
                
                case 10:
                    System.out.println("\n********* Modificar Pista *********");

                    int codigoPistaModificar = 0;
                    String descripcionPistaNuevo = "";
                    String tipoEvidenciaNuevo = "";
                    int nivelImportanciaNuevo = 0;
                    int nivelConfiabilidadNuevo = 0;

                    boolean error2 = true;

                    if(caso.estaLlenoPista() == true){
                        error = true; 

                        while(error == true){
                            
                            System.out.println("\nIngrese el código de la pista que sea modificar");

                            try{

                                codigoPistaModificar = teclado.nextInt();
                                teclado.nextLine();
                                error = false;

                                int validarCodigo = codigoPistaModificar;
                                boolean existe = caso.validarCodigoPista(validarCodigo);

                                if(existe == true){

                                    System.out.println("\nIngrese la descripción: ");
                                    error2 = true;

                                    while (error2 == true){
                                        try{
                                            descripcionPistaNuevo = teclado.nextLine();
                                            error2 = false;
                                            
                                            if (descripcionPistaNuevo.isBlank()) {  //"Valida" que no este vacío
                                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                                error2 = true;
                                            }

                                        }catch(Exception e){
                                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                                            teclado.nextLine();
                                            error2 = true;
                                        }
                                    }


                                    System.out.println("\nIngrese el tipo de evidencia: ");
                                    error2 = true;

                                    while (error2 == true){
                                        try{
                                            tipoEvidenciaNuevo = teclado.nextLine();
                                            error2 = false;
                                            
                                            if (tipoEvidenciaNuevo.isBlank()) {  //"Valida" que no este vacío
                                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                                error2 = true;
                                            }

                                        }catch(Exception e){
                                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                                            teclado.nextLine();
                                            error2 = true;
                                        }
                                    }

                                    System.out.println("Ingrese el nivel de Importancia 1 a 10: ");
                                    error2 = true;

                                    while (error2 == true){
                                
                                        try{
                                            nivelImportanciaNuevo = teclado.nextInt();
                                            teclado.nextLine();
                                            error2 = false;

                                            if (nivelImportanciaNuevo > 10 || nivelImportanciaNuevo < 1) {
                                                System.out.println("\n¡Intente de nuevo! Ingresa una opción válida (1 a 10): ");
                                                error2 = true;
                                            }

                                        }catch(Exception e){
                                            System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                                            teclado.nextLine();
                                            error2 = true;
                                        }
                                    }

                                    System.out.println("Ingrese el nivel de confiabilidad 1 a 100: ");
                                    error2 = true;

                                    while (error2 == true){
                                
                                        try{
                                            nivelConfiabilidadNuevo = teclado.nextInt();
                                            teclado.nextLine();
                                            error2 = false;

                                            if (nivelConfiabilidadNuevo > 100 || nivelConfiabilidadNuevo < 1) {
                                                System.out.println("\n¡Intente de nuevo! Ingresa una opción válida (1 a 10): ");
                                                error2 = true;
                                            }

                                        }catch(Exception e){
                                            System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                                            teclado.nextLine();
                                            error2 = true;
                                        }
                                    }

                                    caso.modificarPista(codigoPistaModificar,descripcionPistaNuevo,tipoEvidenciaNuevo,nivelImportanciaNuevo,nivelConfiabilidadNuevo);

                                    System.out.println("¡Pista modificada!");

                                }
                                
                            }catch(Exception e){
                                System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                teclado.nextLine();
                                error = true;
                            } 
                        }
                    }else {
                        System.out.println("No se han registrado pistas");
                    }
                    break;

                case 11:
                    System.out.println("\n********* Eliminar Pista *********");
                    int codigoPistaEliminar = 0;
                    error = caso.estaLlenoPista();

                    if (error == false){
                        System.out.println("No se han registrado pistas");
                    }                    

                    while(error == true){
                        System.out.println("Ingrese el código de la pista que desea eliminar: ");
                        error = true;

                        while (error == true){
                            try{
                                codigoPistaEliminar = teclado.nextInt();
                                teclado.nextLine();

                                int validarDevolucionCodigoPista = codigoPistaEliminar;

                                error = !caso.validarCodigoPista(validarDevolucionCodigoPista);

                                if (error == true){
                                    System.out.println("El código no existe.Intente de nuevo. Ingrese un código válido: ");
                                }
                            }catch(Exception e){
                                System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                teclado.nextLine();
                                error = true;
                            }
                        }
                        
                        System.out.println(caso.eliminarPista(codigoPistaEliminar));
                    }

                
            
                    break;

                case 12:
                    System.out.println("\n********* Modificar ubicación *********");

                    System.out.println("\nTotal ubicaciones registradas: " + caso.cantidadUbicacionesRegistradas());
                    System.out.println("\nTotal de espacios disponibles: " + caso.cantidadUbicacionesLibres());
                    System.out.println("\nUbicacación con mayor de riegos: " + caso.ubicacionMayorRiesgo());
                    System.out.println("\nTotal pistas registradas: " + caso.cantidadPistas());
                    System.out.println("\n" + caso.pistaMayorImportancia());
                    System.out.println("\n" + caso.pistaMayorConfiabilidad());
                    System.out.println("\nPromedio de nivel importancia de pistas registradas: " + caso.promedioNivelImportancia());
                    
                    break;

                case 13: 
                    System.out.println("\n********* Saliendo del programa *********");
                    System.out.println("\n*****************************************");
                    break;
                }
        
        }
    }
}
