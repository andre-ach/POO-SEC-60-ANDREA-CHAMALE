public class  Pal{

    private String nombre;
    private int tipo;
    private String nombreArmamento;
    private int accionArmamento;
    private int ataque;
    private int defensa;
    private int probabilidadArmamento;
    private int valorArmamento;
    private int bonoAtaque;
    private int bonoDefensa;
    private int bonoDanoDirecto;
    private boolean armamentoActivado;
    private boolean actividad;

    
    public Pal(){
        nombre = " ";
        tipo = 0;
        nombreArmamento = " ";
        accionArmamento = 0;
        ataque = 0;
        defensa = 0;
        probabilidadArmamento = 0;
        accionArmamento = 0;
        accionArmamento = 0;
        accionArmamento =  0;
        armamentoActivado = false;
        actividad = false;
    }

    public Pal(String nombre, int tipo, String nombreArmamento, int accionArmamento) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nombreArmamento = nombreArmamento;
        this.accionArmamento = accionArmamento;

        this.ataque = (int) (Math.random() * 100) + 1;
        this.defensa = (int) (Math.random() * 70) + 1;
        this.probabilidadArmamento = (int) (Math.random() * 100) + 1;

        if (accionArmamento == 1){
            this.valorArmamento = (int) (Math.random() * 200) + 100;
        }else if (accionArmamento == 2){
            this.valorArmamento = (int) (Math.random() * 140) + 100;
        }else {
            this.valorArmamento = (int) (Math.random() * 200) + 160;
        }
    }

/// GET & SET
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTipo(int tipo){
        this.tipo = tipo;
    }

    public int getTipo(){
        return tipo;
    }

    public void setNombreArmamento (String nombreArmamento){
        this.nombreArmamento = nombreArmamento;
    }

    public String getNombreArmamento(){
        return nombreArmamento;
    }

    public void setAccionArmamento(int accionArmamento){
        this.accionArmamento = accionArmamento;
    }

    public int getAccionArmamento(){
        return accionArmamento;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getProbabilidadArmamento(){
        return probabilidadArmamento;
    }

    public int getValorArmamento(){
        return valorArmamento;
    }
    
    public int getBonoAtaque() {
        return bonoAtaque;
    }

    public int getBonoDefensa() {
        return bonoDefensa;
    }

    public int getBonoDanoDirecto() {
        return bonoDanoDirecto;
    }

    public boolean getActividad(){
        return actividad;
    }

    public void setActividad(boolean actividad){
        this.actividad = actividad;
    }


//otros Métodos

    public String getNombreTipo(){
        if( tipo == 1){
            return "Fuego";
        } else if ( tipo == 2){
            return "Agua";
        } else if (tipo == 3){
            return "Planta";
        } else if ( tipo == 4){
            return "Electrico";
        }else {
            return "Tipo no establecido";
        }        
    }

    public void agregarBonoAtaque(int cantidad){
        bonoAtaque = bonoAtaque + cantidad;    }

    public void agregarBonoDefensa(int cantidad){
        bonoDefensa = bonoDefensa + cantidad;
    }

    public void agregarBonoDanoDirecto(int cantidad){
        bonoDanoDirecto = bonoDanoDirecto + cantidad;
    }


    
}