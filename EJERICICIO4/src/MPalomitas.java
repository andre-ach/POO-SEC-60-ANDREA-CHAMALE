public class MPalomitas extends Maquina {

    
    private int porcionesHora;
    private boolean exhibicionIntegrado;


    public MPalomitas() {
        super(); 
        this.porcionesHora = 0;
        this.exhibicionIntegrado = false;
    }

    
    public MPalomitas(int codigoInventario, String marca, float tarifa, boolean disponibilidad, int porcionesHora, boolean exhibicionIntegrado) {
        super(codigoInventario,  marca,  tarifa,  disponibilidad); 
        this.porcionesHora = porcionesHora;
        this.exhibicionIntegrado = exhibicionIntegrado;
    }


    public void setPorcionesHora(int porcionesHora) {
        this.porcionesHora = porcionesHora;
    }

    public int getPorcionesHora() {
        return this.porcionesHora;
    }

    public void setExhibicionIntegrado(boolean exhibicionIntegrado) {
        this.exhibicionIntegrado = exhibicionIntegrado;
    }

    public boolean getExhibicionIntegrado() {
        return this.exhibicionIntegrado;
    }


    //OTRO METODOS

    @Override

    public  float cotizar(int dias){
        
        float diasFloat = dias;
        float recargo = 0.0f;
        float total = 0.0f;

        if(exhibicionIntegrado == true){
            recargo = 40.0f;
        }else{
            recargo = 0.0f;
        }

        total = (this.tarifa * diasFloat) + (recargo * diasFloat);

        return total;
    }
}