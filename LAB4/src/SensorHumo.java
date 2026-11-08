
public class SensorHumo extends Dispositivo
        implements InterMedible, InterAlerta {

    // Constructor vacío

    public double medida ;

    public SensorHumo() {
        super();
        this.estado = true;
        this.medida = 0;
        
    }

    // Constructor con parámetros
    public SensorHumo(int codigo, Oficina oficinaDondeEsta,
                      double potenciaNominal) {
        super(codigo, oficinaDondeEsta, potenciaNominal);
        this.estado = true;
    }

    // InterMedible
    @Override
    public String registrarMedicion(int medida) {

        if (!getEstado()) {
        return "El dispositivo está apagado, no se puede modificar";
        }

        if(medida > -1 && medida < 1001){
            this.medida = medida;
            return "Se registró cambio";
        }

        return "El valor introducido no es válido";
    }

    // InterAlerta
    @Override
    public String evaluarAlerta(int valor) {
        return "";
    }

    // Dispositivo
    @Override
    public void calcularConsumoHora() {

        double consumoRonda = potenciaNominal / 1000;
        consumoKWh = consumoKWh + consumoRonda;
    }

    @Override
    public String toString() {
        return "";
    }
}
