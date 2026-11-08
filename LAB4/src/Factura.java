public class Factura {

    private Oficina oficina;
    private double consumoValle;
    private double consumoNormal;
    private double consumoPunta;
    private double creditosAplicados;
    private double totalPagar;

    public Factura() {
    }

    public Factura(Oficina oficina, double consumoValle,
                   double consumoNormal, double consumoPunta,
                   double creditosAplicados) {
        this.oficina = oficina;
        this.consumoValle = consumoValle;
        this.consumoNormal = consumoNormal;
        this.consumoPunta = consumoPunta;
        this.creditosAplicados = creditosAplicados;
    }

    public double totalApagar() {
        // Pendiente: aplicar tarifas y créditos.
        return 0;
    }

    public String resumenFactura() {
        // Pendiente: mostrar desglose de facturación.
        return "";
    }

    public double getTotalPagar() {
        return totalPagar;
    }
}
