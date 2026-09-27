import java.util.Scanner;
import java.util.InputMismatchException;

public class Principal {

    public Principal(){}

    /**
     * @param args
     */

    
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        DulceEstacion estacion = new DulceEstacion();

        
        System.out.println("¡Bienvenido a Dulce Estación! \n");



        int accion = 0; 
        


        while(accion !=7){

            System.out.println("\n********* MENÚ *********");
            System.out.println("\n1. Registrar máquina \n2. Consultar inventario \n3. Cotizar \n4. Confirmar Alquiler \n5.Registrar devoluciones \n6. Reporte General \n7. Salir");

            System.out.println("Ingrese el número de la opción que desee: ");

            boolean error = true;

            while (error == true){
                try{
                    accion = teclado.nextInt();
                    teclado.nextLine();
                    error = false;

                    if (accion > 7 || accion < 1) {
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
                    
                    int codigoInventario = 0;
                    String marca = "";
                    float tarifa = 0;
                    boolean disponibilidad = false;

                    System.out.println("\n********* Registrar Máquina *********");
                    
                    //DATOS GENERALES

                    System.out.println("\nIngrese el código de inventario: ");

                            error = true; 

                            while (error == true){
                                try {
                                codigoInventario = teclado.nextInt();
                                teclado.nextLine();

                                int validarCodigo = codigoInventario;

                                error =  estacion.validarCodigo(validarCodigo);

                                if (error == true) {
                                    System.out.println("\n¡El código ya existe! Ingresa un número válido: ");

                                }
                            
                                }catch(InputMismatchException e){
                                    System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                    teclado.nextLine();
                                    error = true;          
                                } 
                            }

                    System.out.println("\nIngrese la marca:");

                            error = true;

                            while (error == true){
                                        
                                try{

                                    marca = teclado.nextLine();

                                    error = false;
                                                
                                    if (marca.isBlank()) {  //"Valida" que no este vacío
                                        System.out.println("\n¡Intenta de nuevo! No puedes dejar espacios vacíos.");
                                        error = true;
                                    }

                                }catch(Exception e){
                                            System.out.println("\n¡Error inesperado, intenta de nuevo!");
                                            teclado.nextLine();
                                            error = true;
                                }
                            }
                    
                    System.out.println("\nIngrese la tarifa:");
                            
                            error = true;
                            while (error == true){
                                try {
                                tarifa = teclado.nextInt();
                                teclado.nextLine();
                                error = false;

                                if (tarifa < 1){

                                    System.out.println("\n¡Intente de nuevo! Ingrese un valor mayor a 0: ");
                                    error = true;

                                }

                                }catch(InputMismatchException e){
                                    System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                    teclado.nextLine();
                                    error = true;          
                                } 
                            }
                    
                    System.out.println("\n¿Está disponible? (SI o NO):");
                            error = true;

                            while (error == true){
                                try {
                                String disponibilidadCliente = teclado.nextLine();

                                error = false;

                                if(disponibilidadCliente.toUpperCase().equals("NO")){
                                    disponibilidad = false;
                                }else if(disponibilidadCliente.toUpperCase().equals("SI")){
                                    disponibilidad = true;
                                }else{
                                    System.out.println("\n¡Intenta de nuevo! Ingrese SI o NO: ");
                                    error = true; 
                                }

                                }catch(InputMismatchException e){
                                    System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                    teclado.nextLine();
                                    error = true;          
                                } 
                            }

                    System.out.println("\n¿Qué categoría de máquina desea ingresar? (Ingrese el número)");
                    System.out.println("\n1.Máquina de Palomitas \n2.Máquina/Fuente de Chocolate \n3.Máquina de Algodón");  
  
                        boolean error2 = true;

                        int accion2 = 0; 
                        while (error2 == true){
                            try{
                                accion2 = teclado.nextInt();
                                teclado.nextLine();
                                error2 = false;

                                if (accion2 > 3 || accion2 < 1) {
                                    System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                                    error2 = true;
                                }

                            }catch(Exception e){
                                System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                                teclado.nextLine();
                                error2 = true;
                                
                            }
                        }

                        switch(accion2){
                            case 1: 

                                int porcionesHora = 0;
                                boolean exhibicionIntegrado = false;

                                System.out.println("\n********* Registrar Máquina de Palomitas *********");

                                System.out.println("\nIngrese la cantidad de porciones por hora: ");

                                    error = true;

                                    while (error == true){
                                        try {
                                        porcionesHora = teclado.nextInt();
                                        teclado.nextLine();
                                        error = false;

                                        if (porcionesHora < 1){

                                            System.out.println("\n¡Intente de nuevo! Ingrese un valor mayor a 0: ");
                                            error = true;

                                        }

                                        }catch(InputMismatchException e){
                                            System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                            teclado.nextLine();
                                            error = true;          
                                        } 
                                    }

                                System.out.println("\n¿Tiene carrito de exhibición? (SI o No): ");

                                    error = true;

                                    while (error == true){
                                        try {
                                        String exhibicionIntegradoCliente = teclado.nextLine();

                                        error = false;

                                        if(exhibicionIntegradoCliente.toUpperCase().equals("NO")){
                                            exhibicionIntegrado = false;
                                        }else if(exhibicionIntegradoCliente.toUpperCase().equals("SI")){
                                            exhibicionIntegrado = true;
                                        }else{
                                            System.out.println("\n¡Intenta de nuevo! Ingrese SI o NO: ");
                                            error = true; 
                                        }

                                        }catch(InputMismatchException e){
                                            System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                            teclado.nextLine();
                                            error = true;          
                                        } 
                                    }


                                MPalomitas palomitas = new MPalomitas (codigoInventario, marca,tarifa, disponibilidad, porcionesHora,exhibicionIntegrado );
                                estacion.agregarMaquina(palomitas);

                                break;
                            case 2:
                                
                                System.out.println("\n********* Registrar Máquina/Fuente de Chocolate *********");
                                
                               float capacidadMaxima = 0.0f;

                               System.out.println("Ingrese la cantidad máxima: ");

                                    error = true;

                                        while (error == true){
                                            try {
                                            capacidadMaxima = teclado.nextInt();
                                            teclado.nextLine();
                                            error = false;

                                            if (capacidadMaxima < 1){

                                                System.out.println("\n¡Intente de nuevo! Ingrese un valor mayor a 0: ");
                                                error = true;

                                            }

                                            }catch(InputMismatchException e){
                                                System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                                teclado.nextLine();
                                                error = true;          
                                            } 
                                        }

                                MChocolate chocolate  = new MChocolate (codigoInventario, marca,tarifa, disponibilidad,capacidadMaxima);
                                estacion.agregarMaquina(chocolate);

                                break;
                            case 3: 
                                int potenciaVatios = 0 ;

                                System.out.println("\n********* Registrar Máquina de Algodón *********");

                                System.out.println("\nIngrese la potencia de voltios: ");

                                    error = true;

                                        while (error == true){
                                            try {
                                            potenciaVatios = teclado.nextInt();
                                            teclado.nextLine();
                                            error = false;

                                            if (potenciaVatios < 1){

                                                System.out.println("\n¡Intente de nuevo! Ingrese un valor mayor a 0: ");
                                                error = true;

                                            }

                                            }catch(InputMismatchException e){
                                                System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                                teclado.nextLine();
                                                error = true;          
                                            } 
                                        }

                                MAlgodon algodon  = new MAlgodon (codigoInventario, marca,tarifa, disponibilidad,potenciaVatios);
                                estacion.agregarMaquina(algodon);

                                break;
                        }

                    break;

                case 2:

                    System.out.print("\n********* Consultar inventario *********");

                    int buscarMaquina = 0;

                    System.out.println("\nIngrese el código de invetario de la máquina que desea buscar: ");
                    
                    error = true;

                    while(error == true){
                        try{
                            buscarMaquina = teclado.nextInt();
                            teclado.nextLine();
                            error = false;
                        }catch(Exception e){
                            System.out.println("\n¡Intente de nuevo! Ingresa un código válido: ");
                            teclado.nextLine();
                            error = true;
                        }
                    }

                    System.out.println(estacion.consultarInventario(buscarMaquina));

                    break;

                case 3: 
                    System.out.print("\n********* Cotizar *********");

                    int cotizarMaquina = 0;
                    int diasAlquiler = 0;

                    System.out.println("\nIngrese el código de inventario de la máquina que desea cotizar: ");
                    
                    error = true;

                    while(error == true){
                        try{
                            cotizarMaquina = teclado.nextInt();
                            teclado.nextLine();
                            error = false;
                        }catch(Exception e){
                            System.out.println("\n¡Intente de nuevo! Ingresa un código válido: ");
                            teclado.nextLine();
                            error = true;
                        }
                    }

                    System.out.println("\nIngrese la cantida de días que le gustaría alquilar: ");
                    error = true;

                        while (error == true){
                            try {
                                diasAlquiler = teclado.nextInt();
                                teclado.nextLine();
                                error = false;

                                if (diasAlquiler < 1){

                                    System.out.println("\n¡Intente de nuevo! Ingrese un valor mayor a 0: ");
                                    error = true;

                                }

                            }catch(InputMismatchException e){
                                System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                teclado.nextLine();
                                error = true;          
                            } 
                        }

                    System.out.println(estacion.cotizar(cotizarMaquina, diasAlquiler));

                    break;
                
                case 4: 
                    String deseaConfirmar = ""; 
                    int codigo = 0;
                    int diasAlquilerPagar = 0;

                    System.out.print("\n********* Confirmar Alquiler *********");

                    System.out.println("\n¿Está seguro que desea confirmar y realizar pago? (SI o NO)"); 
                    error = true;

                        while (error == true){
                            
                            try {
                                
                                deseaConfirmar = teclado.nextLine();

                                error = false;

                                if(deseaConfirmar.toUpperCase().equals("SI")){

                                    System.out.println("\nIngrese el código de inventario de la máquina que desea alquilar: ");
                    
                                    error = true;

                                    while(error == true){
                                        try{
                                            codigo = teclado.nextInt();
                                            teclado.nextLine();
                                            error = false;
                                        }catch(Exception e){
                                            System.out.println("\n¡Intente de nuevo! Ingresa un código válido: ");
                                            teclado.nextLine();
                                            error = true;
                                        }
                                    }

                                    System.out.println("\nIngrese la cantida de días que le gustaría alquilar: ");
                                    error = true;

                                        while (error == true){
                                            try {
                                                diasAlquilerPagar = teclado.nextInt();
                                                teclado.nextLine();
                                                error = false;

                                                if (diasAlquilerPagar < 1){

                                                    System.out.println("\n¡Intente de nuevo! Ingrese un valor mayor a 0: ");
                                                    error = true;

                                                }

                                            }catch(InputMismatchException e){
                                                System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                                teclado.nextLine();
                                                error = true;          
                                            } 
                                        }
                                        
                                    System.out.println(estacion.confirmarAlquilres(codigo, diasAlquilerPagar));

                                }else if(deseaConfirmar.toUpperCase().equals("NO")){
                                        System.out.println("¡Estamos para servirle!");
                                }else{
                                    System.out.println("\n¡Intenta de nuevo! Ingrese SI o NO: ");
                                    error = true; 
                                }

                                }catch(InputMismatchException e){
                                            System.out.println("\n¡Intente de nuevo! Ingresa un número válido: ");
                                            teclado.nextLine();
                                            error = true;          
                                } 
                        }
                    
                    break;
                
                case 5:

                    System.out.print("\n********* Registrar Devoluciones *********");

                    int codigoMaquinaDevolver = 0;

                    System.out.println("\nIngrese el código de inventario de la máquina que desea devoler: ");
                    
                    error = true;

                        while(error == true){
                            
                            try{
                                codigoMaquinaDevolver = teclado.nextInt();
                                teclado.nextLine();
                                error = false;
                            }catch(Exception e){
                                System.out.println("\n¡Intente de nuevo! Ingresa un código válido: ");
                                teclado.nextLine();
                                error = true;
                            }
                    }

                    System.out.println(estacion.registrarDevoluciones(codigoMaquinaDevolver));

                    break;
                
                case 6:
                    System.out.println("\n********* Resumen General *********");

                    System.out.println("\n"+ estacion.reporteGeneral());

                    break;
                
                case 7:
                    System.out.println("\n********* Saliendo del programa *********");
                    System.out.println("\n*****************************************");
                    break;
            }
        } 
    }
}
