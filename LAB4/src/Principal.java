import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner teclado = new Scanner (System.in);
        Sistema sistema = new Sistema();

        // Pendiente:
        // Cargar las 3 oficinas iniciales.
        // Cargar al menos 2 dispositivos de cada tipo.
        // Mostrar el menú de consola.
    
    System.out.println("********* Bienvenid@ *********");

        sistema.cargarIntegraciones();

    int accion = 0;

        while(accion != 10){
            System.out.println("\n********* MENÚ *********");
            System.out.println("\n1. Registrar oficinas y dispositivos. \n2. Encender/Apagar Dispositivo \n3. Ajustar Nivel Dispositivo  \n4. Registrar lecturas y  movimientos detectados  \n5. Avanzar una hora de simulación \n6. Consultar oficina \n7. Consultar Dispositivo \n8. Consultar Alerta \n9. Generar Reporte\n10. Salir");
          
            boolean error = true;

            while (error == true){
                try{
                    accion = teclado.nextInt();
                    teclado.nextLine();
                    error = false;

                    if (accion > 11 || accion < 1) {
                        System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                        error = true;
                    }

                }catch(Exception e){
                    System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                    teclado.nextLine();
                    error = true;
                }
             }
    

            switch(accion){

                
                case 1:
                    int codigoDispositivo = 0;
                    int codigoOficina =0;
                    double potenciaNominal = 0;
                    int oficinaSeleccionadaCodigo = 0;
                    
                    
                    String nombreInquilino = "";
                    System.out.println("\n********* Registrar oficinas y dispositivos *********");

                    System.out.println("\n********* Datos oficina");

                    System.out.println("Ingrese el código: ");

                        error = true; 

                            while (error == true){
                                try {
                                codigoOficina = teclado.nextInt();
                                teclado.nextLine();

                                int validarCodigo = codigoOficina;

                                error =  sistema.validarCodigoOficina(validarCodigo);

                                if (error == true) {
                                    System.out.println("\n¡El código ya existe! Ingresa un número válido: ");

                                }
                            
                                }catch(InputMismatchException e){
                                    System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                    teclado.nextLine();
                                    error = true;          
                                } 
                            }

                            oficinaSeleccionadaCodigo = codigoOficina;

                    System.out.println("Ingrese el nombre del inquilino: ");
                       
                    error = true;
                        

                            while (error == true){
                                        
                                try{

                                    nombreInquilino = teclado.nextLine();

                                    error = false;
                                                
                                    if (nombreInquilino.isBlank()) {  //"Valida" que no este vacío
                                        System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                        error = true;
                                    }

                                }catch(Exception e){
                                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                                            teclado.nextLine();
                                            error = true;
                                }
                            }
                    
                    int opcion = 1;
                    while (opcion != 2){

                        System.out.println("¿Desea añadir dispositivo a esta oficina? (Ingrese el número) \n1. Sí \n2. No");
                        
                        error = true;
                        while (error == true){
                            try{
                                opcion = teclado.nextInt();
                                teclado.nextLine();
                                error = false;

                                if (opcion > 2 || opcion < 1) {
                                    System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                                    error = true;
                                }

                            }catch(Exception e){
                                System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                                teclado.nextLine();
                                error = true;
                            }
                        }

                        Oficina oficinaNueva = new Oficina(codigoOficina, nombreInquilino);
                        sistema.agregarOficina(oficinaNueva); 

                        Oficina oficina = sistema.buscarOficinaAgregar(oficinaSeleccionadaCodigo);

                        switch (opcion) {

                            case 1:
                                
                                System.out.println("¿Qué dispositivo desea registrar?  \n1.Cámara \n2. Climatizador \n3. Climatizador Inveter \n4. Lumina \n5. Sensor Humo");

                                error = true;

                                while (error == true){
            
                                            try{
                                                accion = teclado.nextInt();
                                                teclado.nextLine();
                                                error = false;

                                                if (accion > 5 || accion < 1) {
                                                    System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                                                    error = true;
                                                }

                                            }catch(Exception e){
                                                System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                                                teclado.nextLine();
                                                error = true;
                                            }
                                        }

                                System.out.println("Ingrese el código: ");

                                error = true; 


                                while (error == true){
                                    try {
                                    codigoDispositivo = teclado.nextInt();
                                    teclado.nextLine();

                                    int validarCodigo = codigoDispositivo;

                                    error =  sistema.validarCodigoDispositivo(validarCodigo);

                                    if (error == true) {
                                        System.out.println("\n¡El código ya existe! Ingresa un número válido: ");

                                    }
                                
                                    }catch(InputMismatchException e){
                                        System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                        teclado.nextLine();
                                        error = true;          
                                    } 
                                }

                                System.out.println("Ingrese la potencia nominal: ");

                                error = true;

                                while (error == true){
            
                                            try{
                                                potenciaNominal = teclado.nextInt();
                                                teclado.nextLine();
                                                error = false;

                                                if (potenciaNominal < 0) {
                                                    System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                                                    error = true;
                                                }

                                            }catch(Exception e){
                                                System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                                                teclado.nextLine();
                                                error = true;
                                            }
                                        }


                                switch (accion) {

                                    case 1:
                                        Camara dispositivoCamara = new Camara(codigoDispositivo,oficina,potenciaNominal);
                                        sistema.registrarDispositivo(dispositivoCamara);
                                        break;
                                    
                                    case 2:

                                        Climatizador dispositivoClima = new Climatizador(codigoDispositivo,oficina,potenciaNominal);
                                        sistema.registrarDispositivo(dispositivoClima);
                                        break;
                                        
                                    case 3:
                                        ClimatizadorInverter dispositivoClimaInve = new ClimatizadorInverter(codigoDispositivo,oficina,potenciaNominal);
                                        sistema.registrarDispositivo(dispositivoClimaInve);
                                        
                                        break;
                                    
                                    case 4:
                                        Lumina dispositivoLumi = new Lumina(codigoDispositivo,oficina,potenciaNominal);
                                        sistema.registrarDispositivo(dispositivoLumi);
                                        break;
                                    case 5:

                                        SensorHumo dispositivoSensor = new SensorHumo(codigoDispositivo,oficina,potenciaNominal);
                                        sistema.registrarDispositivo(dispositivoSensor);
                                        break;
                                }
                                
                                break;

                                case 2:
                                    System.out.println("No se agregaron dispositivos");
                                    break;
                        }
                    }

                    break;
                case 2:
                    int codigoDispositivoEstado = 0;
                    System.out.println("\n********* Encender/Apagar Dispositivo *********");
                    

                    opcion = 1;
                    while (opcion != 2){

                        System.out.println("¿Qué desea hacer? (Ingrese el número) \n1.Encender \n2. Apagar");
                        
                        error = true;
                        while (error == true){
                            try{
                                opcion = teclado.nextInt();
                                teclado.nextLine();
                                error = false;

                                if (opcion > 2 || opcion < 1) {
                                    System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                                    error = true;
                                }

                            }catch(Exception e){
                                System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                                teclado.nextLine();
                                error = true;
                            }
                        }

    

                        System.out.println("Ingrese el código del dispositivo: ");

                        error = true; 

                            while (error == true){
                                try {

                                codigoDispositivoEstado = teclado.nextInt();
                                teclado.nextLine();
                                error= false;

                                }catch(InputMismatchException e){
                                    System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                    teclado.nextLine();
                                    error = true;          
                                } 
                            }

                        System.out.println(sistema.cambiarEstado(codigoDispositivoEstado,opcion ));
                      break;
                    }


                case 3:
                int codigoDispositivoNivel = 0;
                int nivelCambio = 0; 
                    
                System.out.println("\n********* Adjustar Nivel *********");

                    System.out.println("Ingrese el código del dispositivo: ");

                        error = true; 

                            while (error == true){
                                try {

                                codigoDispositivoNivel = teclado.nextInt();
                                teclado.nextLine();
                                error= false;

                                }catch(InputMismatchException e){
                                    System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                    teclado.nextLine();
                                    error = true;          
                                } 
                            }
                    System.out.println("Ingrese el nuevo nivel: ");

                        error = true; 

                            while (error == true){
                                try {

                                nivelCambio = teclado.nextInt();
                                teclado.nextLine();
                                error= false;

                                }catch(InputMismatchException e){
                                    System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                    teclado.nextLine();
                                    error = true;          
                                } 
                            }

                        System.out.println(sistema.ajustarNivel(codigoDispositivoNivel, nivelCambio));
                    break;
                case 4:
                    
                    int codigoRegistrar = 0;
                    int opcio2 =1;
                    int lectura = 0;
                    int movimiento= 0;

                    System.out.println("\n********* Registrar lecturas y  movimientos detectados *********");
                    
                    
                    System.out.println("Ingrese el código del dispositivo: ");

                        error = true; 

                            while (error == true){
                                try {

                                codigoRegistrar = teclado.nextInt();
                                teclado.nextLine();
                                error= false;

                                }catch(InputMismatchException e){
                                    System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                    teclado.nextLine();
                                    error = true;          
                                } 
                            }
                    
                        System.out.println("¿Qué desea hacer? (Ingrese el número) \n1.Registrar Lectura \n2. Registrar movimiento");
                        
                        error = true;
                        while (error == true){
                            try{
                                opcio2 = teclado.nextInt();
                                teclado.nextLine();
                                error = false;

                                if (opcio2 > 2 || opcio2 < 1) {
                                    System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                                    error = true;
                                }

                            }catch(Exception e){
                                System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                                teclado.nextLine();
                                error = true;
                            }

                        }
                        
                            switch (opcio2) {
                                case 1:
                                    
                                    System.out.println("Ingrese la lectura:  ");

                                    error = true; 

                                        while (error == true){
                                            try {

                                            lectura = teclado.nextInt();
                                            teclado.nextLine();
                                            error= false;

                                            }catch(InputMismatchException e){
                                                System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                                teclado.nextLine();
                                                error = true;          
                                            } 
                                        }

                                       System.out.println(sistema.registrarMedicion(codigoRegistrar, lectura));
                                  
                                    break;

                                case 2: 
                                     System.out.println("Ingrese la hora (como 0, 2, 12, 19): ");

                                    error = true; 

                                        while (error == true){
                                            try {

                                            movimiento = teclado.nextInt();
                                            teclado.nextLine();
                                            error= false;

                                            }catch(InputMismatchException e){
                                                System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                                teclado.nextLine();
                                                error = true;          
                                            } 
                                        }

                                       System.out.print(sistema.registrarMovimiento(codigoRegistrar,movimiento )); 
                                  
                                    break;
                        
                            }
                    break;
                case 5:
                    System.out.println("\n********* Avanzar una hora de simulación *********");

                    System.out.println(sistema.avanzarHora());

                    break;
                case 6:
                    System.out.println("\n********* Consultar oficina *********");



                    break;
                case 7:
                    System.out.println("\n********* Consultar Dispositivo *********");

                    break;
                case 8:
                    System.out.println("\n********* Consultar Alerta *********");

                    break;
                case 9:
                    System.out.println("\n********* Generar Reporte *********");

                    break;
                case 10:
                    System.out.println("\n********* Saliendo del programa *********");
                    System.out.println("\n*****************************************");
                    break;

           
               
            }
        } 
    }
    }
