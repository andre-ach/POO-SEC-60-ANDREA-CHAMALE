public abstract class  Maquina {

    protected int codigoInventario;
    protected String marca;
    protected float tarifa;
    protected boolean disponibilidad;


    public Maquina() {
        this.codigoInventario = 0;
        this.marca = "";
        this.tarifa = 0;
        this.disponibilidad = false;
    }

    // Constructor parametrizado (Corrige 'diponibilidad' del diagrama a 'disponibilidad')
    public Maquina(int codigoInventario, String marca, float tarifa, boolean disponibilidad) {
        this.codigoInventario = codigoInventario;
        this.marca = marca;
        this.tarifa = tarifa;
        this.disponibilidad = disponibilidad;
    }

    
    public void setCodigoInventario(int codigoInventario) {
        this.codigoInventario = codigoInventario;
    }

    public int getCodigoInventario() {
        return this.codigoInventario;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }

    public float getTarifa() {
        return this.tarifa;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public boolean getDisponibilidad() {
        return this.disponibilidad;
    }


    public abstract float cotizar(int dias);

    @Override
    public String toString() {
        return "Maquina{" +
                "codigoInventario=" + codigoInventario +
                ", marca='" + marca + '\'' +
                ", tarifa=" + tarifa +
                ", disponibilidad=" + disponibilidad +
                '}';
    }



}