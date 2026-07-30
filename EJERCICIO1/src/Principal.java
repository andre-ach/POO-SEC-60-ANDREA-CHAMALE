import java.util.Scanner;

public class Principal{

    public static void main(String[] args){

        
        System.out.println("\n ******************** Bienvenidos ********************\n");
        
        Scanner teclado = new Scanner(System.in);
        Comprador datos = new Comprador();
        Validador validador = new Validador(); 
        Localidad locali = new Localidad();

        Localidad local = new Localidad();

        System.out.println("Ingrese sus datos: \n");

        System.out.println("\nNombre:");
        String nom = teclado.nextLine(); 

        System.out.println("\nEmail:");
        String emai = teclado.nextLine();

        System.out.println("\nCantidad de boletos que desea adquirir:");
        int boletos = teclado.nextInt(); 
        teclado.nextLine();

        System.out.println("\nPresupuesto disponible en dolares (no ingresar símbolo): ");
        int presu = teclado.nextInt(); 
        teclado.nextLine();

        System.out.println("\n ****************************************************\n");
        System.out.println("\n *********    Diponibilidad de voletos    *********  \n");

        datos.setCompradorC(nom, emai, boletos,presu);
        

        int vendidosLocal1 = locali.VentidosLocalidad1();
        System.out.println("Voletos vendidos en LOCALIDAD 1:"+vendidosLocal1);

        int vendidosLocal5 = locali.VendidosLocalidad5();
        System.out.println("Voletos vendidos en LOCALIDAD 5:"+vendidosLocal5);

        int vendidosLocal10 = locali.VentidosLocalidad10();
        System.out.println("Voletos vendidos en LOCALIDAD 10:"+vendidosLocal10 + "\n");

        int totalboletos = locali.DisponibilidadBoletos();
        System.out.println("Boletos disponibles: "+ totalboletos);

        System.out.println("\n ****************************************************\n");
        System.out.println("\n *********    Consultar Disponiblidad    *********  \n");

        System.out.println("¿Qué localidad le interesa ver? \n (Ingrese 1, 5 o  10)");
        String userLocalidad = teclado.nextLine();
        String userLocalidadVEr = locali.verDisponiblidadLocalidad(userLocalidad); 

        System.out.println(userLocalidadVEr);

        System.out.println("\n ****************************************************\n");
        System.out.println("\n ***************    Válidad ticket    ***************  \n");

        System.out.println("\n 1 -> Ticket SÍ válido para realizar compra \n 0 -> Ticke NO válido para realizar compra");

        int Verificador = validador.Determinador(datos.Usuarioticket());
        System.out.println("El ticket es: " + Verificador);

        System.out.println("\n ****************************************************\n");
        System.out.println("\n ***************    Estado de Compra    ***************  \n");

        int nuevoPedidio1 = 0;  
        int nuevoPedidio5 = 0;  
        int nuevoPedidio10 = 0;

        if (userLocalidad.equals("1") || userLocalidad.equals("5") || userLocalidad.equals("10")) {
            
            System.out.println(validador.Compra(Verificador, nuevoPedidio1, nuevoPedidio5, nuevoPedidio10, datos, locali));
        } else {
            System.out.println("ERROR!");
        }



        System.out.println("\n ****************************************************\n");
        System.out.println("\n *********    REPORTE CAJA    *********  \n");

        datos.setCompradorC(nom, emai, boletos,presu);
        

        int dineroLocal1 = locali.DineroGanado1();
        System.out.println("LOCALIDAD 1:"+ dineroLocal1);

        int dineroLocal5 = locali.DineroGanado5();
        System.out.println("LOCALIDAD 5:" + dineroLocal5);

        int dineroLocal10 = locali.DineroGanado10();
        System.out.println("LOCALIDAD 10:" + dineroLocal10 + "\n");

    }
}