
import java.util.ArrayList;

public class Oficina {

    private int codigo;
    private String nombreInquilino;
    private ArrayList<Dispositivo> dispositivos;
    private double consumoValle;
    private double consumoNormal;
    private double consumoPunta;
    private double creditos;
    private ArrayList<Factura> facturas;

    public Oficina() {
        dispositivos = new ArrayList<>();
        facturas = new ArrayList<>();
    }

    public Oficina(int codigo, String nombreInquilino) {
        this();
        this.codigo = codigo;
        this.nombreInquilino = nombreInquilino;
    }

    public void agregarDispositivo(Dispositivo dispositivo) {
        dispositivos.add(dispositivo);
    }

    public void registrarConsumo() {
        // Pendiente: acumular por franja.
    }

    public void reiniciarAcumulados() {
        // Pendiente: reiniciar consumos y créditos.
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreInquilino() {
        return nombreInquilino;
    }

    public void setNombreInquilino(String nombreInquilino) {
        this.nombreInquilino = nombreInquilino;
    }

    public void aplicarCredito(double monto) {
        // Pendiente: acumular crédito.
    }

    public Factura generarFactura() {
        // Pendiente: crear y conservar factura.
        return null;
    }

    public ArrayList<Dispositivo> getDispositivos() {
        return new ArrayList<Dispositivo>(dispositivos);
    }

    @Override
    public String toString() {
        return "Oficina " + codigo + " - " + nombreInquilino;
    }
}
