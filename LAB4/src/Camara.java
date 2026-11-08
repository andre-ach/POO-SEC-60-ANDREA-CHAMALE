
public class Camara extends Dispositivo implements InterEstado, InterAlerta {

    private  int hora;
    // Constructor vacío
    public Camara() {
        super();
        hora = 0;
    }

    // Constructor con parámetros
    public Camara(int codigo, Oficina oficinaDondeEsta,
                  double potenciaNominal) {
        super(codigo, oficinaDondeEsta, potenciaNominal);

        hora = 0;
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

    // Método propio de Camara
    public String registrarMovimiento(int hora) {
        
        if (!getEstado()) {
        return "El dispositivo está apagado, no se puede modificar";
        }
        
    
        if (hora < 24 && hora >0){
                this.hora = hora;
                            return "Ha sido registrado";

        }

    
         return "Valor no válido";

       
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
        double consumoRonda = potenciaNominal / 1000;

        consumoKWh = consumoKWh + consumoRonda;
        return consumoKWh;
    }

    @Override
    public String toString() {
        return "";
    }
}
