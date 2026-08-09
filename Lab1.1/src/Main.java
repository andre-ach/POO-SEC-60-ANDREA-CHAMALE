import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        //Contructores 
        Pal[] palsUsuario = new Pal[3]; // Arreglo de objetos 
        PalComputadora palComputadora = new PalComputadora();
        
        System.out.println("\n ******************** ¡BIENVENID@! ********************\n \n Cree 3 PALS");

         for (int i = 0; i <= 2; i++){ 
        System.out.println("\n******************** PAL " + (i+1) + " ********************");

        System.out.println("Ingrese el nombre de su Pal: ");
        String nombre = teclado.nextLine();

        System.out.println("Ingrese el tipo de tu Pal:  \n 1. Fuego \n 2. Agua \n 3. Planta \n 4. Eléctrico");
        int tipo = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Ingrese el nombre del Armamento Especial: ");
        String nombreArmamento = teclado.nextLine();

        System.out.println("Ingrese la acción del Armamento: \n 1. Aumenta ataque \n 2. Defensa \n 3. Daña directamente al enemigo");
        int accionArmamento = teclado.nextInt();
        teclado.nextLine();
        
        palsUsuario [i] = new Pal(nombre, tipo, nombreArmamento, accionArmamento);

        }

        System.out.println("\n \n ******************** TUS PALS ********************");

        for (int i = 0; i <= 2; i++){
            System.out.println("\nPAL " + (i + 1));

            System.out.println("Nombre: " + palsUsuario[i].getNombre());
            System.out.println("Tipo: "+ palsUsuario[i].getNombreTipo());
            System.out.println("Armamentos: " + palsUsuario[i].getNombreArmamento());
            System.out.println("Acción armamento: " + palsUsuario[i].getAccionArmamento());
            System.out.println("Probabilidades de armamentos: "+ palsUsuario[i].getProbabilidadArmamento()+ "%");
            System.out.println("Valor del Armamento: " + palsUsuario[i].getValorArmamento());
            System.out.println("Ataque: " + palsUsuario[i].getAtaque());
            System.out.println("Defensa: " + palsUsuario[i].getDefensa());
            
         }

        Ronda ronda = new Ronda();

        for (int numeroRonda = 1; numeroRonda <= 4; numeroRonda++){
            System.out.println("\n ******************** Ronda "+ numeroRonda + "********************");

            System.out.println("\nElige tu PAL (INTRUDUCE EL NÚMERO!): ");

            for (int i = 0; i < 3; i++){
                System.out.println((i+1) + ". " + palsUsuario[i].getNombre());
            }

            int opcionPal = teclado.nextInt(); 
            teclado.nextLine();

            int posicionPal = opcionPal -1;

            Pal palElegidoUsuario = palsUsuario[posicionPal];

            while (numeroRonda <= 3 && palElegidoUsuario.getActividad()){

                System.out.println("Ese Pal ya fue elegido. Elige otro: ");
                opcionPal = teclado.nextInt(); 
                teclado.nextLine();

                posicionPal = opcionPal -1;
                palElegidoUsuario = palsUsuario[posicionPal];
            }

            if (numeroRonda <= 3){
                palElegidoUsuario.setActividad(true);
            }

            System.out.println("Seleccionaste a: " + palElegidoUsuario.getNombre());

            Pal palElegidoCPU = palComputadora.elegirPal();

            System.out.println("CPU eligió: " + palElegidoCPU.getNombre());

            System.out.println("\nElige tu acción:");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            System.out.println("3. Intentar Armamento Especial");

            int accionUsuario = teclado.nextInt();
            teclado.nextLine();

            
            int accionCPU = palComputadora.elegirAccion();

            Efecto efecto = new Efecto(palElegidoUsuario, palElegidoCPU);

            efecto.setAccionUsuario(accionUsuario);
            efecto.setAccionComputadora(accionCPU);

            int ataqueTotalUsuario = efecto.procesarAccion(palElegidoUsuario, palElegidoCPU,accionUsuario, accionCPU);

            int ataqueTotalCompu = efecto.procesarAccion( palElegidoCPU, palElegidoUsuario, accionCPU, accionUsuario);

            ronda.setAtaqueTotalUsuario(ataqueTotalUsuario);
            ronda.setAtaqueTotalCompu(ataqueTotalCompu);
            ronda.registrarPuntos();



            System.out.println("\n------ DATOS DE GENERALES ------");

            System.out.println("Usuario ataque base: " + palElegidoUsuario.getAtaque());
            System.out.println("Usuario defensa base: " + palElegidoUsuario.getDefensa());
            System.out.println("CPU ataque base: " + palElegidoCPU.getAtaque());
            System.out.println("CPU defensa base: " + palElegidoCPU.getDefensa());
            System.out.println("Acción usuario: " + accionUsuario);
            System.out.println("Acción CPU: " + accionCPU);

            System.out.println("Efecto tipo usuario: " + efecto.calcularEfectoTipo(palElegidoUsuario,palElegidoCPU));
            System.out.println("Efecto tipo CPU: " + efecto.calcularEfectoTipo(palElegidoCPU, palElegidoUsuario ));

            System.out.println("\n ------ RESULTADOS RONDA ------");

            System.out.println("Tu pal: " + palElegidoUsuario.getNombre());
            System.out.println("Pal CPU: " + palElegidoCPU.getNombre());
            System.out.println("Tu ataque total: " + ronda.getAtaqueTotalUsuario());
            System.out.println("Ataque total CPU: " + ronda.getAtaqueTotalCompu());
            System.out.println("Ganador: " + ronda.determinarGanadorRonda()); 
            System.out.println("\nTus puntos: " + ronda.getPuntosUsuario());
            System.out.println("Puntos CPU: "+ ronda.getPuntosCompu());

        }
        
        System.out.println("\n \n \n ******************** GANADOR FINAL ********************");
        
        System.out.println("Tus puntos: " + ronda.getPuntosUsuario());
        System.out.println("Puntos CPU: " + ronda.getPuntosCompu());
        System.out.println("GANADOR del JUEGO: " + ronda.determinarGanadorFinal());
    }
    }
    