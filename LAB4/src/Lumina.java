
public class Lumina extends Dispositivo implements InterRegulable, InterEstado {

    // Atributos
    private int nivel;

    // Constructor vacío
    public Lumina() {
        super();
        this.nivel = 100;
    }

    // Constructor con parámetros
    public Lumina(int codigo, Oficina oficinaDondeEsta, double potenciaNominal) {
        super(codigo, oficinaDondeEsta, potenciaNominal);
        this.nivel = 100;
    }

    // Métodos de InterRegulable
    @Override
    public String ajustarNivel(int nivel) {

        if (!getEstado()) {
        return "El dispositivo está apagado, no se puede modificar";
        }

        if (nivel > 11 && nivel < 101 ){
               this.nivel = nivel;
               return "Se modifico el nivel";
        }
        
        return "El nivel no es válido";
     
    }

    public int getNivel() {
        return nivel;
    }

    // Métodos de InterEstado
    @Override
    public void cambiarEstado(int estadoNuevo) {
        if (estadoNuevo == 1) {
        this.estado = true;
        } else {
        this.estado = false;
        }
    }

    // Método abstracto heredado de Dispositivo
    @Override
    public void calcularConsumoHora() {
        double cosumoRonda =(potenciaNominal* (0.30 + 0.70 * nivel / 100) )/(100);

        consumoKWh = consumoKWh + cosumoRonda;
    }

    // Mostrar información
    @Override
    public String toString() {
        return "";
    }

}
