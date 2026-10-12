
import java.util.ArrayList;

public class Nodo {
    private int codigoNodo;
    private int capacidadMaximaHorasCompuLote;
    private boolean cuentaGPU;

 
    public Nodo() {
        codigoNodo = 0;
        capacidadMaximaHorasCompuLote = 0;
        cuentaGPU = false;
       
    }

   
    public Nodo(int codigoNodo, int capacidadMaximaHorasCompuLote, boolean cuentaGPU) {
        this.codigoNodo = codigoNodo;
        this.capacidadMaximaHorasCompuLote = capacidadMaximaHorasCompuLote;
        this.cuentaGPU = cuentaGPU;

    }

    // Getter y Setter 
    public void setCodigoNodo(int codigoNodo) {
        this.codigoNodo = codigoNodo;
    }

    public int getCodigoNodo() {
        return this.codigoNodo;
    }

    public void setCapacidadMaximaHorasCompuLote(int capacidadMaximaHorasCompuLote) {
        this.capacidadMaximaHorasCompuLote = capacidadMaximaHorasCompuLote;
    }

    public int getCapacidadMaximaHorasCompuLote() {
        return this.capacidadMaximaHorasCompuLote;
    }

    public void setCuentaGPU(boolean cuentaGPU) {
        this.cuentaGPU = cuentaGPU;
    }

    public boolean getCuentaGPU() {
        return this.cuentaGPU;
    }

    public String toString() {

        String cadena = "Codigo: " + codigoNodo + "\nCapacidad Maximas Horas Computo Lote: " + capacidadMaximaHorasCompuLote + "Cuenta con GPU: " + cuentaGPU;
        return cadena;
    }
}