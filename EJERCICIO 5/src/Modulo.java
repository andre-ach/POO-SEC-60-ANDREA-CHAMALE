public abstract class Modulo {
  
    protected int id;
    protected String nombre;
    protected String estadoSalud;
    protected boolean actividad;
    protected float costoConstruccion; 

    
    public Modulo() {
        id = 0;
        nombre = "";
        estadoSalud = "";
        actividad = false;
        costoConstruccion = 0.0f;
    }

    public Modulo(int id, String nombre, String estadoSalud, boolean actividad, float costoConstruccion) {
        this.id = id;
        this.nombre = nombre;
        this.estadoSalud = estadoSalud;
        this.actividad = actividad;
        this.costoConstruccion = costoConstruccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

      public void setEstadoSalud(String estadoSalud) {
        this.estadoSalud = estadoSalud;
    }


    public String getEstadoSalud() {
        return this.estadoSalud;
    }

    public void setActividad(boolean actividad) {
        this.actividad = actividad;
    }

    public boolean getActividad() {
        return this.actividad;
    }


    public void setCostoConstruccion(float costoConstruccion) {
        this.costoConstruccion = costoConstruccion;
    }

    public float getCostoConstruccion() {
        return this.costoConstruccion;
    }

    public abstract String procesarCiclo(CentroControl centroControl);


    public String toString() {
        String cadena = "ID: " + this.id + "\nNombre: " + this.nombre +"\nEstado de Salud: " + this.estadoSalud + "\nActividad: " + this.actividad + "\nCosto de Construcción: "+ this.costoConstruccion;
        return cadena;
    }
}
