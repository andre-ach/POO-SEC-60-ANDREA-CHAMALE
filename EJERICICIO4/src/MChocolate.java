public class MChocolate extends Maquina {

    
     private float capacidadMaxima;

    public MChocolate() {
        super(); 
        this.capacidadMaxima = 0.0f;
    }

    
    public MChocolate(int codigoInventario, String marca, float tarifa, boolean disponibilidad, float capacidadMaxima) {
        super( codigoInventario,  marca,  tarifa,  disponibilidad); 
        
        this.capacidadMaxima = capacidadMaxima;
        
    }

    public void setCapacidadMaxima(float capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public float getCapacidadMaxima() {
        return this.capacidadMaxima;
    }

     @Override

    public  float cotizar(int dias){
        float diasFloat = dias;
        float recargo = 0.0f;
        float total = 0.0f;

        
        recargo = 40.0f * capacidadMaxima;
        

        total = (this.tarifa * diasFloat) + (recargo * diasFloat);

        return total;
    }
}
