public class  Comprador{
    private String  nombre;
    private String email;
    private int cantidadBoletos;
    private int presupuesto;
    private String userLocalidad;


    public Comprador(){
        nombre = " "; 
        email = " ";
        cantidadBoletos = 0;
        presupuesto = 0;
        userLocalidad = "";
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getUserLocalidad(){
        return userLocalidad;
    }
    public void setUserLocalidad(String userLocalidad){
        this.userLocalidad = userLocalidad;
    }


    public String getEmail(){
        return email;
    }


    public void setEmail(String email){
        this.email = email;
    }

    public int getCantidadBoletos(){
        return cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidadBoletos ){
        this.cantidadBoletos = cantidadBoletos;
    }

    public int getPresupuesto(){
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto){
        this.presupuesto = presupuesto;
        
    }

    public void setCompradorC (String nom, String emai, int boletos, int presu){
        this.nombre = nom;
         this.email = emai;
        this.cantidadBoletos = boletos;
        this.presupuesto = presu;
    }

    public int Usuarioticket(){
         int numTitcket = (int) (Math.random() * 15000) + 1;
         return numTitcket;
    }
   


    
}