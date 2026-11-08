public abstract class Dispositivo implements Comparable<Dispositivo>{

    
    protected int codigo;
    protected Oficina oficinaDondeEsta;
    protected double potenciaNominal;
    protected boolean estado;
    protected double consumoKWh;

    public Dispositivo() {
    }

    public Dispositivo(int codigo, Oficina oficinaDondeEsta,
                       double potenciaNominal) {
        this.codigo = codigo;
        this.oficinaDondeEsta = oficinaDondeEsta;
        this.potenciaNominal = potenciaNominal;
        this.estado = false;
        this.consumoKWh = 0;
    }

    public abstract double calcularConsumoHora(Sistema sistema);

    public void acumularConsumo(double consumo) {
        this.consumoKWh += consumo;
    }

    public void reiniciarConsumoDiario() {
        this.consumoKWh = 0;
    }

    @Override
    public int compareTo(Dispositivo otro) {
        return Integer.compare(this.codigo, otro.codigo);
    }

    public int getCodigo() {
        return codigo;
    }

    public Oficina getOficinaDondeEsta() {
        return oficinaDondeEsta;
    }

    public double getPotenciaNominal() {
        return potenciaNominal;
    }

    public boolean getEstado() {
        return estado;
    }

    protected void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getConsumoKWh() {
        return consumoKWh;
    }
}
