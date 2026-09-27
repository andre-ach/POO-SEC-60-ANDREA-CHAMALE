public class MAlgodon extends Maquina {

   private int potenciaVatios;

    public MAlgodon() {
        super(); 
        this.potenciaVatios = 0; 
    }

    public MAlgodon(int codigoInventario, String marca, float tarifa, boolean disponibilidad, int potenciaVatios) {
        super( codigoInventario,  marca,  tarifa,  disponibilidad); 
        this.potenciaVatios = potenciaVatios;
    }

    public void setPotenciaVatios(int potenciaVatios) {
        
        this.potenciaVatios = potenciaVatios;
    }

    public int getPotenciaVatios() {
        return this.potenciaVatios;
    }
    
     @Override

    public  float cotizar(int dias){
        float diasFloat = dias;
        float recargo = 0.0f;
        float total = 0.0f;

        if(potenciaVatios > 1000){
            recargo = 60;
        }else{
            recargo = 0;
        }

        total = (this.tarifa * diasFloat) + recargo;

        return total;
    }
}