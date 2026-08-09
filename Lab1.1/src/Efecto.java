public class Efecto {

    private Pal palUsuario;
    private Pal palComputadora;
    private int accionUsuario;
    private int accionComputadora;

    public Efecto( Pal palUsuario, Pal palComputadora){
        this.palUsuario = palUsuario;
        this.palComputadora = palComputadora;
        this.accionUsuario = 0;
        this.accionComputadora = 0;

    }

    // get y set

    public void setAccionUsuario(int accionUsuario){
        this.accionUsuario = accionUsuario;
    }

    public int getAccionUsuario(){
        return accionUsuario;
    }

    public void setAccionComputadora(int accionComputadora){
        this.accionComputadora = accionComputadora;
    }

    public int getAccionComputadora(){
        return accionComputadora;
    }

    public Pal getPalUsuario(){
        return palUsuario;
    }

    public Pal getPalComputadora(){
        return palComputadora;
    }

    //métodos

    public int ataqueUsuario(){
        return palUsuario.getAtaque();
    }

    public int ataqueComputadora(){
        return palComputadora.getAtaque();
    }


    //otros métodos

    public int calcularEfectoTipo(Pal atacante, Pal defensor){

        int tipoAtancante = atacante.getTipo();
        int tipoDefensor = defensor.getTipo();

        if (tipoAtancante == 1 && tipoDefensor == 3){
            return 20;
        } else if (tipoAtancante ==  3 && tipoDefensor == 2){
            return 20;
        } else if (tipoAtancante == 2  && tipoDefensor ==  1 ){
            return 20;
        } else if (tipoAtancante ==  4 && tipoDefensor == 2 ){
            return 20;
        } else if ( tipoAtancante == 3  && tipoDefensor ==  1){
            return -10;
        } else if (tipoAtancante == 2 && tipoDefensor == 3 ){
            return -10;
        } else if (tipoAtancante == 1 && tipoDefensor ==  2){
            return -10;
        } else if (tipoAtancante == 2 && tipoDefensor ==4 ){
            return -10;
        } else {
            return 0;
        }
    }

    public int calcularAtaqueTotal(Pal atacante, Pal defensor, boolean estaDefendiendo){
        
        int ataque = atacante.getAtaque() + atacante.getBonoAtaque();

        int defensa = 0;

        if (estaDefendiendo){
            defensa = defensor.getDefensa()+ defensor.getBonoDefensa(); 
        }

        int efectoTipo = calcularEfectoTipo(atacante, defensor);

        int ataqueTotal = ataque - defensa + efectoTipo + atacante.getBonoDanoDirecto();

        ///

        if (ataqueTotal < 0){
            return 0;
        } return ataqueTotal;
    }

    public boolean intentarAtacar(Pal pal){

        int intento = (int) (Math.random()*100) + 1;

        if (intento <= pal.getProbabilidadArmamento()){
            return true;
        }else{
            return false;
        }
    }

    public void aplicarArmamento(Pal pal){
        int accion = pal.getAccionArmamento();
        int valor = pal.getValorArmamento();

        if (accion == 1){

            pal.agregarBonoAtaque(valor);

        }else if (accion == 2){
            pal.agregarBonoDefensa(valor);
        }else if (accion == 3){
            pal.agregarBonoDanoDirecto(valor);
        }
    }

    public boolean usarArmamento (Pal pal){

        boolean activado = intentarAtacar(pal);

        if (activado){
            aplicarArmamento(pal);
            return true;
        }

        return false;
    }

    public int procesarAccion(Pal pal, Pal rival, int accion, int accionRival) {

        if (accion == 1){

            boolean rivalDefiende = accionRival == 2;

            return calcularAtaqueTotal(pal, rival, rivalDefiende);
        }else if  (accion == 3){

            boolean activado = usarArmamento(pal);

            if (activado && pal.getAccionArmamento() == 3){
                return pal.getBonoDanoDirecto();
            }

            return pal.getBonoDanoDirecto();

        }
            return pal.getBonoDanoDirecto();

    }

}