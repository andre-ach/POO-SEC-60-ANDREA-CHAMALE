public abstract class Api implements Comparable<Api> { // el comprable está aquí porque entonces todas las clases hijas lo heredan 

    protected int identificador;
    protected boolean estadoConexion;
    protected double latencia;
    protected boolean actividad;

    public Api() {
    }

    public Api(int identificador, boolean estadoConexion, double latencia, boolean actividad) {
        this.identificador = identificador;
        this.estadoConexion = estadoConexion;
        this.latencia = latencia;
        this.actividad = actividad;
    }

    // Getters y Setters
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getIdentificador() {
        return this.identificador;
    }

    public void setEstadoConexion(boolean estadoConexion) {
        this.estadoConexion = estadoConexion;
    }

    public boolean getEstadoConexion() {
        return this.estadoConexion;
    }

    public void setLatencia(double latencia) {
        this.latencia = latencia;
    }

    public double getLatencia() {
        return this.latencia;
    }

    public void setActividad(boolean actividad) {
        this.actividad = actividad;
    }

    public boolean getActividadad() { 
        return this.actividad;
    }

    // Métodos heredados
    @Override
    public String toString() {

        String cadena = "\nIdentificador: " + identificador + "\nEstado Conexión: " + estadoConexion +"\nLatencia: "+ latencia + "\nActividad: " + actividad;

        return cadena;
    }

    @Override
    public int compareTo(Api otras) {
        
        int resultado = Double.compare(latencia, otras.getLatencia()); //métod par compoara primero las latancias

        if ( resultado == 0){ // si devuelve 0, entonces dice que son iguales 
            int desempate = Integer.compare(identificador, otras.getIdentificador()); // desempata usando los identificadores  y usa ese valor para desempatar 
 
            return desempate; // retorna este resultado 
        }

        return resultado; // si no es 0 entonces retnra esto 
    }
}
