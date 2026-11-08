
public class Climatizador extends Dispositivo
        implements InterRegulable, InterEstado, InterMedible, InterAlerta {

    // Atributos
    private int nivel;
    private double medida;


    // Constructores
    public Climatizador() {
        super();
        this.nivel = 50;

    }

    public Climatizador(int codigo, Oficina oficinaDondeEsta,
                        double potenciaNominal) {
        super(codigo, oficinaDondeEsta, potenciaNominal);
        this.nivel = 50;
        this.medida = 0;
    }

    // InterRegulable
    @Override
     public String ajustarNivel(int nivel) {
        
        if (!getEstado()) {
        return "El dispositivo está apagado, no se puede modificar";
        }

        if (nivel > 21 && nivel < 101 ){
               this.nivel = nivel;
               return "Se modifico el nivel";
        }
        
        return "El nivel no es válido";
     
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    // Para permitir un mínimo diferente en el inverter
    protected int getNivelMinimo() {
        return 20;
    }

    // InterEstado
    @Override
    public void cambiarEstado(int estadoNuevo) {
        if (estadoNuevo == 1) {
        this.estado = true;
        } else {
        this.estado = false;
        }
    }

    // InterMedible
    @Override
    public String registrarMedicion(int medida) {

   
        if (!getEstado()) {
        return "El dispositivo está apagado, no se puede modificar";
        }
    
        if(medida > -11 && medida < 61){
            this.medida = medida;
            return "Se registró cambio";
        }

        return "El valor introducido no es válido";
    }

    // InterAlerta
    @Override
    public String evaluarAlerta(int valor) {
        if (!getEstado()) {
        return "El dispositivo está apagado, no se puede modificar";
        }
        return "";
    }

    // Dispositivo
    @Override
    public double calcularConsumoHora(Sistema sistema) {
        return ((0.30 + 0.70 * getNivel() / 100.0)) / 1000.0;
    }


    
    @Override
    public String toString() {
        return "";
    }
}
