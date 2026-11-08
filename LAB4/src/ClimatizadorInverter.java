
public class ClimatizadorInverter extends Climatizador {

    // Constructor vacío
    public ClimatizadorInverter() {
        super();
    }

    // Constructor con parámetros
    public ClimatizadorInverter(int codigo, Oficina oficinaDondeEsta,
                                double potenciaNominal) {
        super(codigo, oficinaDondeEsta, potenciaNominal);
    }


    @Override
     public String ajustarNivel(int nivel) {

        if (!getEstado()) {
        return "El dispositivo está apagado, no se puede modificar";
        }

        if (nivel > 20 && nivel < 101 ){
               setNivel(nivel);
               return "Se modifico el nivel";
        }
        
        return "El nivel no es válido";
    }

    // Cambia el cálculo del consumo
    public double calcularConsumoHora(Sistema sistema) {

       return (potenciaNominal * (0.30 + 0.70 * getNivel() / 100.0)) / 1000.0; // toma el metodo de climatizador
    }
}
