public class  Validador{

   
    
    public int Determinador(int Usuarioticket){

        int rango1 = (int) (Math.random() * 15000) + 1;
        int rango2 = (int) (Math.random() * 15000) + 1;

        if (Usuarioticket <= rango1 && Usuarioticket >= rango2){
            return 1;
        } else if (Usuarioticket <= rango2 && Usuarioticket >= rango1){
            return 1;
        }else {
            return 0;
        }
        

    }

    public String Compra (int Verificador, int nuevoPedidio1, int nuevoPedidio5, int nuevoPedidio10, Comprador comprador, Localidad localidad){
        
        if (Verificador == 0){
            return "No es posible realizar el proceso de compra, el ticket no es válido :)";
        }
        else if (Verificador == 1 ){
            
            int total = comprador.getCantidadBoletos() * 100;

            if(comprador.getPresupuesto() >= (total)){

                int nuevaCantidad = localidad.getLocalidad1() - comprador.getCantidadBoletos();
                    localidad.setLocalidad1(nuevaCantidad);

                return "Compra realizada!";

            }else {
                return "Presupuesto insuficiente!";
            }
        }
        else if (Verificador == nuevoPedidio1){

            int total = nuevoPedidio1 * 100;

            if(comprador.getPresupuesto() >= (total)){
                int nuevaCantidad = localidad.getLocalidad1() - nuevoPedidio1;
                    localidad.setLocalidad1(nuevaCantidad);
                return "Compra realizada!";

            }else {
                return "Presupuesto insuficiente!";
            }
        }
         else if (Verificador == 5 ){
            
            int total = comprador.getCantidadBoletos() * 500;

            if(comprador.getPresupuesto() >= (total)){
                int nuevaCantidad = localidad.getLocalidad5() - comprador.getCantidadBoletos();
                    localidad.setLocalidad5(nuevaCantidad);
                return "Compra realizada!";

            }else {
                return "Presupuesto insuficiente!";
            }
        }
        else if (Verificador == nuevoPedidio5){

            int total = nuevoPedidio5 * 500;

            if(comprador.getPresupuesto() >= (total)){
                int nuevaCantidad = localidad.getLocalidad5() - nuevoPedidio5;
                    localidad.setLocalidad5(nuevaCantidad);
                return "Compra realizada!";

            }else {
                return "Presupuesto insuficiente!";
            }
        }
        else if (Verificador == 10 ){
            
            int total = comprador.getCantidadBoletos() * 1000;

            if(comprador.getPresupuesto() >= (total)){
                int nuevaCantidad = localidad.getLocalidad10() - comprador.getCantidadBoletos();
                    localidad.setLocalidad10(nuevaCantidad);
                return "Compra realizada!";

            }else {
                return "Presupuesto insuficiente!";
            }
        }
        else if (Verificador == nuevoPedidio10){

            int total = nuevoPedidio10 * 1000;

            if(comprador.getPresupuesto() >= (total)){
                int nuevaCantidad = localidad.getLocalidad10() - nuevoPedidio10;
                    localidad.setLocalidad10(nuevaCantidad);
                return "Compra realizada!";

            }else {
                return "Presupuesto insuficiente!";
            }
    }else {
        return "Error!";
    }
         
}}