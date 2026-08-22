import java.util.Scanner;

public class Principal{

    public Principal() {
    }

    /**
     * @param args
     */
    
    public static void main(String [] args){
        Scanner teclado = new Scanner(System.in);

        System.out.println("¡Bienvenid@ al PRESTAMOS de libros!");
        
        Admin admin = new Admin();
        int accion = 0;

        while (accion != 10) {
        
            System.out.println("\n********* MENÚ *********");
            System.out.println("\n1.  Registrar préstamo \n2.  Consultar préstamos \n3.  Buscar Préstamo \n4.  Modificar Préstamo \n5.  Regristrar Devolución de Prestamo \n6.  Consultar Prestamo por Estudiante \n7.  Reporte de Días Autorizados \n8.  Prestamo con Mayor Duración \n9.  Cantidad de Préstamos \n10. Salir \n");
            System.out.println("Ingrese el número de la opción que desee: ");
            
            boolean error = true;

            while (error == true){
                
                try{
                    accion = teclado.nextInt();
                    teclado.nextLine();
                    error = false;

                    if (accion > 10 || accion < 1) {
                        System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                        error = true;
                    }

                }catch(Exception e){
                    System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                    teclado.nextLine();
                    error = true;
                     
                }
            }

        /// Ejecución de del MENÚ 

            switch (accion){
                case 1: 

                    int codigo = 0;
                    int carnet = 0;
                    String nombre = "";
                    String titulo = "";
                    int diasPrestados = 0;


                    System.out.println("\n********* Registro de prestamo *********");


                    System.out.println("\nIngrese el código de prestamo (solo números):");
                    error = true; 

                    while (error == true){
                        
                        try {
                            codigo = teclado.nextInt();
                            teclado.nextLine();

                            int validarCodigo = codigo;

                            error =  admin.validarCodigo(validarCodigo);

                            if (error == true) {
                                System.out.println("\n¡El código ya existe! Ingresa un número válido: ");

                            }

         
                        }catch(Exception e){
                            System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                            teclado.nextLine();
                            error = true;

                            
                        } 
                    }

                    System.out.println("\nIngrese su número de carnet: ");
                    error = true;

                    while (error == true){
                        try{

                            carnet = teclado.nextInt();
                            teclado.nextLine();
                            error = false;
                            
                        }catch(Exception e){
                            System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                            teclado.nextLine();
                            error = true;
                        }
                    }
                
                    System.out.println("\nIngrese su nombre: ");
                    error = true;

                    while (error == true){
                        try{

                            nombre = teclado.nextLine();
                            error = false;
                            
                            if (nombre.isBlank()) {  //"Valida" que no este vacío
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                 error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }

                    System.out.println("\nIngrese el titulo del libro: ");
                    error = true;

                    while (error == true){
                        try{

                            titulo = teclado.nextLine();
                            error = false;
                            
                            if (titulo.isBlank()) {  //"Valida" que no este vacío
                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                 error = true;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                            teclado.nextLine();
                            error = true;
                        }
                    }
                    

                    System.out.println("\nIngrese la cantidad de días autorizados para el préstamo: ");
                    error = true;

                    while (error == true){
                        try{

                            diasPrestados = teclado.nextInt();
                            teclado.nextLine();
                            error = false;
                            
                            if (diasPrestados == 0 || diasPrestados < 0){
                                System.out.println("\n¡Intente de nuevo! Ingresa un número mayor a 0: ");
                                error = true;
                            }
                            
                        }catch(Exception e){
                            System.out.println("\n¡Intente de nuevo! Ingresa un número mayor a 0: ");
                            teclado.nextLine();
                            error = true;
                        }finally{
                            System.out.println("\n Este es el último dato por ingresar\n");
                        }
                    }

                    admin.llenarPrestamo(codigo, carnet, nombre, titulo, diasPrestados);

                    break;


                case 2:
                    System.out.println("\n********* Consulta de préstamos *********");
                    System.out.println("\nLos prestamos llevados son:\n \n"+ admin.consultaPrestamo());
                    break;

                case 3:

                    int buscarCodigo = 0;
                    System.out.println("\n********* Buscar Préstamo *********");

                    System.out.println("\nIngrese el código de prestamo (solo números):");
                    error = true; 


                    while (error == true){
                        
                        try {
                            buscarCodigo = teclado.nextInt();
                            teclado.nextLine();
                            error = false;

                            //validar si exite o no existe 
                            
                        }catch(Exception e){
                            System.out.println("\n¡Intente de nuevo! Ingresa un código válido: ");
                            teclado.nextLine();
                            error = true;
                        } 
                    }

                    System.out.println(admin.buscarPrestamo(buscarCodigo));

                    break;

                case 4: 

                    int ModificarPrestamo = 0;
                    String nuevoTitulo = "";
                    int nuevoDiasAutirizado = 0;
                    System.out.println("\n********* Modificar Prestamo *********");
                    boolean error2 = true;      

                    if (admin.estaLleno() == true){
                    
                        error = true; 

                        while (error == true){
                
                            System.out.println("\nIngrese el código de prestamo (solo números):");

                            try {
                                ModificarPrestamo = teclado.nextInt();
                                teclado.nextLine();
                                error = false;

                                int validarModificarPrestamo =  ModificarPrestamo;
                                boolean existe = admin.validarCodigo(validarModificarPrestamo);


                                if(existe == true){

                                    //NUEVO TITULO

                                    System.out.println("Ingrese el nuevo titulo: ");
                                    error2 = true;


                                    while (error2 == true){

                                        try{ 
                                            nuevoTitulo = teclado.nextLine();
                                            error2 = false;
                                
                                            if (nuevoTitulo.isBlank()) {  //"Valida" que no este vacío
                                                System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                                error2 = true;
                                            }

                                        }catch(Exception e){
                                            System.out.println("¡Intente de nuevo! Ingrese un título válido: ");
                                            teclado.nextLine();
                                            error2 = true;
                                        }
                                    }
                                    
                                    //NUEVOS DIAS
                                    System.out.println("Ingrese los nuevos días autorizados (mayor a 0): ");
                                    error2 = true;

                                    while (error2 == true){
                                        try{

                                            nuevoDiasAutirizado = teclado.nextInt();
                                            teclado.nextLine();
                                            error2 = false;
                                
                                            if (nuevoDiasAutirizado == 0 || nuevoDiasAutirizado < 0){
                                                System.out.println("\n¡Intente de nuevo! Ingresa un número mayor a 0: ");
                                                error2 = true;
                                            }
                                
                                        }catch(Exception e){
                                            System.out.println("\n¡Intente de nuevo! Ingresa un número mayor a 0: ");
                                            teclado.nextLine();
                                            error2 = true;
                                        }finally{
                                            System.out.println("\n Este es el último dato por ingresar\n");
                                        }
                                    }

                                    System.out.println(admin.modificarPrestamo(ModificarPrestamo,nuevoTitulo,nuevoDiasAutirizado));
                                    error = false;
                                }else {
                                    
                                    System.out.println("¡El código ingresado no existe en los registros!");
                                    error = true;
                                }

                            }catch(Exception e){
                                System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                teclado.nextLine();
                                error = true;
                            } 
                        }
                    }else {
                        System.out.println("No se han registrado préstamos");
                    }

                    break;
                case 5:

                    int devolucionCodigo = 0;

                    System.out.println("\n********* Registrar Devolucion *********");
                    
                    error = admin.estaLleno();

                    while (error == true){

                        System.out.println("Ingrese el código del préstamo: ");
                        error = true; 

                        while (error == true){
                            try{

                                devolucionCodigo = teclado.nextInt();
                                teclado.nextLine();

                                int validarDevolucionCodigo =  devolucionCodigo;

                                error = !admin.validarCodigo(validarDevolucionCodigo);

                                if (error == true) {
                                    System.out.println("El código no existe. Intente de nuevo. Ingrese un código válido:");
                                }


                            }catch (Exception e){
                                System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                teclado.nextLine();
                                error = true;
                            }
                        }

                        System.out.println(admin.registrarDevolucion(devolucionCodigo));
                    }
                    System.out.println("No se han registrado préstamos");

                    break;
            
                case 6:

                    int carnetEstudiante = 0;

                    System.out.println("\n********* Consultar Prestamo por Estudiante *********");

                    System.out.println("Ingrese el carnet del estudiante:");
                    error = true;

                    while (error == true){
                        try{
                            carnetEstudiante = teclado.nextInt();
                            teclado.nextLine();

                            int validarCarnet = carnetEstudiante;

                            error= !admin.validarCarnet(validarCarnet);

                            if (error == true) {
                                System.out.println("\nNo se encontró el carnet " + carnetEstudiante);
                                error = false;
                            }

                        }catch(Exception e){
                            System.out.println("\n¡Intente de nuevo! Ingresa un carnet válido: ");
                            teclado.nextLine();
                            error = true;
                        }

                    }

                    System.out.println("Los prestamos por el carnet "+ carnetEstudiante + " son: \n");
                    System.out.println(admin.consultarPrestamoEstudiante(carnetEstudiante));
                    
                    break;
                case 7:
                    System.out.println("\n********* Reporte de Días Autorizados *********");
                    
                    System.out.println("\n Total de dias autorizados: " + admin.reporteDiasAutorizados()+ " días");

                    break;
                case 8:
                    System.out.println("\n********* Prestamo con Mayor Duración *********");

                    System.out.println("\n " + admin.prestamoMayorDuracion());

                    break;
                case 9:
                    System.out.println("\n********* Cantidad de Préstamos *********");

                    System.out.println("\n Se han registrado " + admin.cantidadPrestamos() + " hasta el momento");
                    break;
                case 10:
                    System.out.println("\n********* Saliendo del programa *********");
                    System.out.println("\n*****************************************");
                    break;
            }
        
        }
    //teclado.close();
    }
}