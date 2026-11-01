import java.util.Scanner;

public class Principal {

    public Principal(){}

    public static void main(String[] arg){

        Scanner teclado = new Scanner (System.in);

        Sistema sistema = new Sistema();

        sistema.cargarIntegraciones();


        System.out.println("********* Bienvenid@ *********");



        int accion = 0;

        while(accion != 5){
            System.out.println("\n********* MENÚ *********");
            System.out.println("\n1. Listar integraciones activas \n2. Buscar API por identificador \n3. Ordenar integraciones por latencia \n4. Solicitar operación de una API \n5. Salir");
          
            boolean error = true;

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

            switch(accion){
                case 1:
                    System.out.println("\n********* Listar Integraciones Activas *********");

                    String resultado = sistema.listaInteraccionesActivas();
                    System.out.println(resultado);
                    
                    break;
                case 2:
                    System.out.println("\n********* Buscar API por identidicador *********");
                    
                    int identificadorBuscar = 0;

                    System.out.println("\nIngrese el Identificador que desea buscar: ");

                    error = true;

                    while(error == true){
                        try{
                            identificadorBuscar = teclado.nextInt();
                            teclado.nextLine();
                            error= false;
                        }catch(Exception e){
                            System.out.println("\n¡Intente de nuevo! Ingrese un Identificador válido: ");
                            teclado.nextLine();
                            error = true;
                        }
                    }
                    
                    System.out.println(sistema.buscarApi(identificadorBuscar));

                    break;
            
                case 3: 
                    System.out.println("\n********* Ordenar integraciones por latencia *********");

                    String ordenar = sistema.catalogo();
                    System.out.println(ordenar);
                    
                    break;
                case 4:
                    System.out.println("\n********* Solicitar Operación *********");

                        System.out.println("\nIngrese el Identificador que desea buscar: ");
                        int identificadorBuscarExiste =0;
                        error = true;
                        while(error == true){
                            try{
                                identificadorBuscarExiste = teclado.nextInt();
                                teclado.nextLine();
                                error= false;
                            }catch(Exception e){
                                System.out.println("\n¡Intente de nuevo! Ingrese un Identificador válido: ");
                                teclado.nextLine();
                                error = true;
                            }
                        }


                        int accion2 = 0;

                            System.out.println("\n********* ¿Qué desea realizar? *********");
                            System.out.println("\n1. Aditable \n2. Cobrar \n3. Consultar Estado \n4. Cotizar \n5. Documetable \n6. Reintegro");
                        
                            error = true;

                            while (error == true){
                                try{
                                    accion2 = teclado.nextInt();
                                    teclado.nextLine();
                                    error = false;

                                    if (accion2 > 7 || accion2 < 1) {
                                        System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                                        error = true;
                                    }

                                }catch(Exception e){
                                    System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                                    teclado.nextLine();
                                    error = true;
                                }
                            }

                            String resultado2 = sistema.operaciones(identificadorBuscarExiste,accion2);

                            System.out.print(resultado2);
                        

                
                        
                        

                    break;

                case 5:

                    System.out.println("\n********* Saliendo del programa *********");

                    System.out.println("\n*****************************************");

                    break;

            }
      
        }
    }

}