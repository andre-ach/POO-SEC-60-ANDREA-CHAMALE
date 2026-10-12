import java.util.Scanner;

public class Principal {

    public Principal(){}

    public static void main(String[] arg){

        Scanner teclado = new Scanner (System.in);

        System.out.println("********* Bienvenido a Proyectos *********");

        int accion = 0;

        while(accion != 6){
            System.out.println("\n********* MENÚ *********");
            System.out.println("\n1. Cotizar \n2. Registrar Trabajo \n3. Registrar Nodo \n4. Crear Lote \n5. Asignar trabajo a lote \n6. Retirar trabajo de lote \n7. Iniciar Lote \n8. Registrar resultado de trabajo\n9. Consultar trabajos y nodos \n10. Generar reportes \n11. Salir");
            boolean error= true;

            while (error == true){
                try{
                    accion = teclado.nextInt();
                    teclado.nextLine();
                    error = false;
                    
                    if(accion > 7 || accion <1){
                        System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                            error = true;
                        }

                }catch(Exception e){

                    System.out.println("\n¡Intente de nuevo! Ingresa una opción válida: ");
                    teclado.nextLine();
                    error = true;
                     
                }
            }
        }



    }

}