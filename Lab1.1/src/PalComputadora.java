public class PalComputadora{

    private Pal[] palsComputadora;

    public PalComputadora(){

        palsComputadora =  new Pal[3];

        palsComputadora[0] = new Pal("CHARMANDER", 1,"ETERNATUS", 3 );
        palsComputadora[1] = new Pal("SQUIRTLE", 2, "MEGA", 2);
        palsComputadora[2] = new Pal("VULPIX", 4, "THUNDER", 1);
    }

    public Pal elegirPal(){

        int posicionCPU = (int) (Math.random() * 3);
        
        return palsComputadora[posicionCPU];
    }

    public int elegirAccion(){
        return (int) (Math.random() * 3)+ 1;
    }

}