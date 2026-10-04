import java.util.Scanner;

public class Principal {

    public Principal(){}

    public static void main(String[] arg){

        Scanner teclado = new Scanner (System.in);

        CentroControl centro = new CentroControl();

        System.out.println("¡Bienvenido al Simulador del Centro de Control QUETZAL-2!");


        int accion = 0;

         centro.modulosDisponibles();

        while(accion != 6){
            System.out.println("\n********* MENÚ *********");
            System.out.println("\n1. Lista de Modulos \n2. Buscar Módulo \n3. Catálogo de Costo de Construcción \n4. Avanzar un Ciclo del Simulador \n5. Resumen \n6. Salir");
          
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

            switch(accion){
                case 1:
                    System.out.println("\n********* Lista de Módulos *********");

                   
                    String resultado = centro.mostrarModulos();
                    System.out.println(resultado);

                    break;
                case 2:
                    System.out.println("\n********* Buscar Módulo *********");

                    int idBuscar = 0;

                    System.out.println("\nIngrese el ID del módulo que desea buscar: ");

                    error = true;

                    while (error == true){
                        try{
                            idBuscar = teclado.nextInt();
                            teclado.nextLine();
                            error = false;

                        }catch(Exception e){
                            System.out.println("\n¡Intente de nuevo! Ingrese un ID válido: ");
                            teclado.nextLine();
                            error = true;
                        }
                    }

                    System.out.println(centro.buscarModulo(idBuscar));
                    
    
                    break;
                case 3:
                    System.out.println("\n********* Catálogo de Costo de Construcción *********");
                    
                    System.out.println("\nDe mayor a menor \n");
                    String resultado3 = centro.catalogoPorCostoContruccio();
                    System.out.println(resultado3);

                    break;
                case 4:
                    System.out.println("\n********* Avanzar un Ciclo del Simulador *********");

                    String resultado4 = centro.correrSimulacion();
                    System.out.print(resultado4);

                    System.out.println("\nEnegía total: " + centro.getEnergiaTotal());
                    System.out.println("\nDatos en Órbita: " + centro.getDatosPendientesDescarga());
                    
                    

                    break;
                case 5:
                    System.out.println("\n********* Resumen *********");
                    System.out.println(centro.resumen());
                    break;
                case 6:
                    System.out.println("\n********* Saliendo del programa *********");
                    System.out.println("\n*****************************************");
                    break;

            }


        }
    }

    
}
