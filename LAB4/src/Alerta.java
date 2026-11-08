
public class Alerta implements Comparable<Alerta> {

    private int codigo;
    private Dispositivo dispositivo;
    private int horaGeneracion;
    private String severidad;
    private String mensaje;
    private boolean atendida;

    public Alerta() {
    }

    public Alerta(int codigo, Dispositivo dispositivo,
                  int horaGeneracion, String severidad,
                  String mensaje) {
        this.codigo = codigo;
        this.dispositivo = dispositivo;
        this.horaGeneracion = horaGeneracion;
        this.severidad = severidad;
        this.mensaje = mensaje;
        this.atendida = false;
    }

    public void estadoAtendida() {
        // Pendiente: marcar como atendida.
    }

    public double calcularCredito(int horaAtencion) {
        // Pendiente: calcular retraso y crédito.
        return 0;
    }

    public boolean estaAtendida() {
        return atendida;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    @Override
    public int compareTo(Alerta otra) {
        // Pendiente: severidad, hora y código.
        return 0;
    }

    @Override
    public String toString() {
        return "Alerta " + codigo + " - " + severidad;
    }
}
