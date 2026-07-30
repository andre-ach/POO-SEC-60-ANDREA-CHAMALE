public class  Localidad{

    private int localidad1;
    private int localidad5; 
    private int localidad10;


    public Localidad() {
    
    localidad1 = 20;
    localidad5 = 20;
    localidad10 = 20;

    }
    


    public int getLocalidad1(){
        return localidad1;
    }

    public void setLocalidad1(int localidad1){
        this.localidad1 = localidad1;
    }

    public int getLocalidad5(){
        return localidad5;
    }

    public void setLocalidad5(int localidad5){
        this.localidad5 = localidad5;
    }

    public int getLocalidad10(){
        return localidad10;
    }

    public void setLocalidad10(int localidad10){
        this.localidad10 = localidad10;
    }


    public String verDisponiblidadLocalidad (String userLocalidad){
        if(userLocalidad.equals("1")){
            return "En localidad 1 hay: " + getLocalidad1() + " boletos disponbles.";
       } else if (userLocalidad.equals("5")){
            return "En localidad 5 hay: " + getLocalidad5() + " boletos disponbles.";
       }else if (userLocalidad.equals("10")){
            return "En localidad 10 hay: " + getLocalidad10() + " boletos disponbles.";
       }else
            return "No encontrado";
    }

    public int VentidosLocalidad1(){
        int totalVentidos1 = 20 - localidad1;
        return totalVentidos1; 
    }

    public int VendidosLocalidad5(){
        int totalVentidos5 = 20 - localidad5;
        return totalVentidos5; 
    }

    public int VentidosLocalidad10(){
        int totalVentidos10 = 20 - localidad10;
        return totalVentidos10; 
    }

    public int DineroGanado1(){
        int dGanado1 = VentidosLocalidad1() * 100;
        return dGanado1;
    }

    public int DineroGanado5(){
        int dGanado5 = VendidosLocalidad5() * 500;
        return dGanado5;
    }

    public int DineroGanado10(){
        int dGanado10 = VentidosLocalidad10() * 1000;
        return dGanado10;
    }




    public int DisponibilidadBoletos(){
       
       int disponibilidadBoletos = localidad1 + localidad5 + localidad10;

       return disponibilidadBoletos;
    }

    public int Verificador (int Determinador, Comprador comprador){

        if(Determinador == 0){
            return 0; 
        }else{

             int randomLocalidad = (int) (Math.random() * 3) + 1;

            if (randomLocalidad == 1){
            if (getLocalidad1() == 0){
                return 0;
            }else {
                if (comprador.getCantidadBoletos() > getLocalidad1()) {
                      int nuevoPedidio1 =  comprador.getCantidadBoletos() - getLocalidad1();
                       return nuevoPedidio1;
                }else {
                    return 1;
                }
            }
                      
        }else if (randomLocalidad == 2){
            if (getLocalidad5() == 0){
                return 0;
            }else {
                if (comprador.getCantidadBoletos() > getLocalidad5()) {
                      int nuevoPedidio5 = comprador.getCantidadBoletos() - getLocalidad5();
                       return nuevoPedidio5;
                }else {
                    return 5;
                }
            } 
        }else {
            if (getLocalidad10() == 0){
                return 0;
            }else {
                if (comprador.getCantidadBoletos() > getLocalidad10()) {
                      int nuevoPedidio10 = comprador.getCantidadBoletos() - getLocalidad10();

                      return nuevoPedidio10;
                }else {
                    return 10;
                }
           } 
           } 
           }      }
}
