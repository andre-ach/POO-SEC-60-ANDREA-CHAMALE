public class Ronda{

    private int ataqueTotalUsuario;
    private int ataqueTotalCompu;
    private int puntosUsuario;
    private int puntosCompu;

    public Ronda() {
        ataqueTotalUsuario = 0;
        ataqueTotalCompu = 0;

        puntosUsuario = 0;
        puntosCompu = 0;

    }

    //get and set

    public void setAtaqueTotalUsuario (int ataqueTotalUsuario){
        this.ataqueTotalUsuario = ataqueTotalUsuario;
    }

    public int getAtaqueTotalUsuario (){
        return ataqueTotalUsuario;
    }

    public void setAtaqueTotalCompu (int ataqueTotalCompu){
        this.ataqueTotalCompu = ataqueTotalCompu;
    }

    public int getAtaqueTotalCompu() {
        return ataqueTotalCompu;
    }

    public int getPuntosUsuario(){
        return puntosUsuario;
    }

    public int getPuntosCompu(){
        return puntosCompu;
    }

    public String determinarGanadorRonda(){
        if(ataqueTotalUsuario > ataqueTotalCompu){
            return "TU";
        } else if ( ataqueTotalUsuario < ataqueTotalCompu ){
            return "CPU";
        } else {
            return "EMPATE";
        }
    }
    public void registrarPuntos(){

        String ganador = determinarGanadorRonda();

        if (ganador.equals("TU")){
            puntosUsuario++; 
        }else if (ganador.equals("CPU")){
            puntosCompu++;
        }
    }

        public String determinarGanadorFinal(){
        if(puntosUsuario > puntosCompu){
            return "TU";
        } else if ( puntosUsuario < puntosCompu ){
            return "CPU";
        } else {
            return "EMPATE";
        }
    }
}