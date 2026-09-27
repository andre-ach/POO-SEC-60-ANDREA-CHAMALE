import java.util.ArrayList;

public class DulceEstacion {
    
    private float montoAcumulado;
    private ArrayList<Maquina> maquina;

    public DulceEstacion() {

        this.montoAcumulado = 0;
        this.maquina = new ArrayList<>();

        maquinasDemostracion();

    }

    //VALIDAR
    
    public boolean validarCodigo(int validarCodigo){

        for (Maquina m : maquina){

            if(m.getCodigoInventario() == validarCodigo){
                return true;
            }
        }

        return false;
    }

    // Get & Set

    public float getMontoAcumulado() {
        return montoAcumulado;
    }

    public void setMontoAcumulado(float montoAcumulado) {
        this.montoAcumulado = montoAcumulado;
    }

    public ArrayList<Maquina> getMaquina() {
        return maquina;
    }

    public void setMaquina(ArrayList<Maquina> maquina) {
        this.maquina = maquina;
    }

    public void agregarMaquina(Maquina nuevaMaquina) {
        this.maquina.add(nuevaMaquina);     
    }


    public String consultarInventario(int codigo) {
        try{
            String info = "";
            for(Maquina m: maquina){
                if(m.getCodigoInventario() == codigo){
                    info =  "Código Inventario: " + m.getCodigoInventario() + "\nMarca: " + m.getMarca() + "\nTarifa: " + m.getTarifa() + "\nDisponibilidad: " + m.getDisponibilidad() ;
                
                    if (m instanceof MPalomitas) {
                        MPalomitas p = (MPalomitas) m; 
                        return info + "\nPorciones por Hora: " + p.getPorcionesHora() + "\nCarrito: " + p.getExhibicionIntegrado(); 
                    }else if(m instanceof MChocolate){
                        MChocolate c = (MChocolate) m;
                        return info + "\nCapacida Máxima: "+ c.getCapacidadMaxima();
                    }else{
                        MAlgodon a = (MAlgodon) m;
                        return info + "\nPotencia: " + a.getPotenciaVatios(); 
                    }                   
                } 
                }

                return "No se encontró la máquina con el código: " + codigo;
        }catch(Exception e){
            return "No se encontró la máquina con el código: " + codigo;
        }

    }

    public String cotizar(int codigo, int dias) {
        try{
            String totalMostrar = "";
            float preTotal = 0.0f;
            float total = 0.0f;
            for(Maquina m: maquina){

                if(m.getCodigoInventario() == codigo){
                    
                    if(m instanceof MPalomitas){
                        MPalomitas p = (MPalomitas) m;
                        preTotal = p.cotizar(dias);
                        total = preTotal;

                    }else if(m instanceof MChocolate){
                        MChocolate c = (MChocolate) m;
                        preTotal = c.cotizar(dias);
                        total = preTotal;

                    }else{
                        MAlgodon a = (MAlgodon) m;
                        preTotal = a.cotizar(dias);
                        total = preTotal;
                    }      
                    
                    totalMostrar = "Deberá pagar: Q." + total;
                    
                    return totalMostrar;
                }
            }
                    return "No se encontró la máquina con el código: " + codigo;
        }catch(Exception e){
            return "No se encontró la máquina con el código: " + codigo;
        }

    }

    public String confirmarAlquilres(int codigo, int dias) {

        try{
            float preTotal = 0.0f;
            float total = 0.0f;
            String mensaje = "";

            for(Maquina m: maquina){

                if(m.getCodigoInventario() == codigo && m.getDisponibilidad() == true){
                    
                    if(m instanceof MPalomitas){
                        MPalomitas p = (MPalomitas) m;
                        preTotal = p.cotizar(dias);
                        total = preTotal;

                        montoAcumulado = montoAcumulado + total;

                        p.setDisponibilidad(false);
                        
                        mensaje = "¡Listo! Se a alquilado la máquina" + codigo + "y se han cobrado Q" + total;
                        return  mensaje; 

                    }else if(m instanceof MChocolate){
                        MChocolate c = (MChocolate) m;
                        preTotal = c.cotizar(dias);
                        total = preTotal;
                        montoAcumulado = montoAcumulado + total;

                        c.setDisponibilidad(false);

                        mensaje = "¡Listo! Se a alquilado la máquina" + codigo + "y se han cobrado Q" + total;
                        return  mensaje; 

                    }else if (m instanceof MAlgodon){
                        MAlgodon a = (MAlgodon) m;
                        preTotal = a.cotizar(dias);
                        total = preTotal;
                        montoAcumulado = montoAcumulado + total;

                        a.setDisponibilidad(false);

                        mensaje = "¡Listo! Se a alquilado la máquina" + codigo + "y se han cobrado Q" + total;
                        return  mensaje; 

                    }else{
                        return "La máquina con el código " + codigo + "NO está disponible.";
                    }    
                }
            }
                    return "No se encontró la máquina con el código: " + codigo;
        }catch(Exception e){
            return "No se encontró la máquina con el código: " + codigo;
        }
       
    }

    public String registrarDevoluciones(int codigo) {

        try{
            String info = "";

            for(Maquina m: maquina){

                if(m.getCodigoInventario() == codigo) 
                
                    if(m.getDisponibilidad() == false){
                        m.setDisponibilidad(true);
                        return "¡Devolución exitosa!";
                    }else{
                        return "¡Está intentado devolver una máquina que no ha sido alquilada!";
                    }

            }
                return "No se encontró la máquina con el código: " + codigo;
        }catch(Exception e){
            return "No se encontró la máquina con el código: " + codigo;
        }

    }
    


    

    public String reporteGeneral() {

        String maquinasRegistradas =  maquinasRegistradas();
        String maquinasDisponibles = maquinasDiponibles();
        String maquinasAlquiladas = maquinasAlquiladas();
        String mostar = maquinasRegistradas + "\n" + maquinasDisponibles + "\n" + maquinasAlquiladas;
        return mostar;
    }

    public String maquinasRegistradas() {

        int conteoMaquinasRegistradaGeneral = 0;
        int conteoMaquinaPalomitas = 0;
        int conteoMaquinaAlgodon = 0;
        int conteoMaquinaChocolate = 0;
        String mostrar = "";

        for(Maquina m: maquina) {

            if(m.getDisponibilidad() == true || m.getDisponibilidad() ==  false){
                 
                if (m instanceof MPalomitas) {
                        MPalomitas p = (MPalomitas) m;

                        if(p.getDisponibilidad() ==  true || p.getDisponibilidad() ==  false){
                            conteoMaquinaPalomitas =  conteoMaquinaPalomitas + 1;
                        } 
                        
                }else if(m instanceof MChocolate){
                        MChocolate c = (MChocolate) m;

                        if(c.getDisponibilidad() == true || c.getDisponibilidad() ==  false){
                            conteoMaquinaChocolate = conteoMaquinaChocolate + 1;
                        }

                }else{
                        MAlgodon a = (MAlgodon) m;
                        if(a.getDisponibilidad() == true || a.getDisponibilidad() ==  false){
                         conteoMaquinaAlgodon =  conteoMaquinaAlgodon + 1;
                        }
                }     

            }
        }

        conteoMaquinasRegistradaGeneral = conteoMaquinaPalomitas +conteoMaquinaChocolate+conteoMaquinaAlgodon;

        mostrar = "\nTotal Máquinas Registradas: " + conteoMaquinasRegistradaGeneral + "\n  Máquina de Algodón: " + conteoMaquinaAlgodon + "\n  Máquina de Chocolate: " + conteoMaquinaChocolate + "\n  Máquina de Palomitas: " + conteoMaquinaPalomitas;
        
        return mostrar;
    }
        
    


    public String maquinasDiponibles() {
        
        int conteoMaquinasDisponibleGeneral = 0;
        int conteoMaquinaPalomitas = 0;
        int conteoMaquinaAlgodon = 0;
        int conteoMaquinaChocolate = 0;
        String mostrar = "";

        for(Maquina m: maquina) {

            if(m.getDisponibilidad() == true){
                 
                if (m instanceof MPalomitas) {
                        MPalomitas p = (MPalomitas) m;

                        if(p.getDisponibilidad() == true){
                            conteoMaquinaPalomitas =  conteoMaquinaPalomitas + 1;
                        } 
                        
                }else if(m instanceof MChocolate){
                        MChocolate c = (MChocolate) m;

                        if(c.getDisponibilidad() == true){
                            conteoMaquinaChocolate = conteoMaquinaChocolate + 1;
                        }

                }else{
                        MAlgodon a = (MAlgodon) m;
                        if(a.getDisponibilidad() == true){
                         conteoMaquinaAlgodon =  conteoMaquinaAlgodon + 1;
                        }
                }     

            }
        }

        conteoMaquinasDisponibleGeneral = conteoMaquinaPalomitas +conteoMaquinaChocolate+conteoMaquinaAlgodon;

        mostrar = "\nTotal Máquinas Disponibles: " + conteoMaquinasDisponibleGeneral + "\n  Máquina de Algodón: " + conteoMaquinaAlgodon + "\n  Máquina de Chocolate: " + conteoMaquinaChocolate + "\n  Máquina de Palomitas: " + conteoMaquinaPalomitas;
        
        return mostrar;
    }

    public String maquinasAlquiladas() {

        int conteoMaquinasAlquiladasGeneral = 0;
        int conteoMaquinaPalomitas = 0;
        int conteoMaquinaAlgodon = 0;
        int conteoMaquinaChocolate = 0;
        String mostrar = "";

        for(Maquina m: maquina) {

            if(m.getDisponibilidad() == false){
                 
                if (m instanceof MPalomitas) {
                        MPalomitas p = (MPalomitas) m;

                        if(p.getDisponibilidad() == false){
                            conteoMaquinaPalomitas =  conteoMaquinaPalomitas + 1;
                        } 
                        
                }else if(m instanceof MChocolate){
                        MChocolate c = (MChocolate) m;

                        if(c.getDisponibilidad() == false){
                            conteoMaquinaChocolate = conteoMaquinaChocolate + 1;
                        }

                }else{
                        MAlgodon a = (MAlgodon) m;
                        if(a.getDisponibilidad() == false){
                         conteoMaquinaAlgodon =  conteoMaquinaAlgodon + 1;
                        }
                }     

            }
        }

        conteoMaquinasAlquiladasGeneral = conteoMaquinaPalomitas +conteoMaquinaChocolate+conteoMaquinaAlgodon;

        mostrar = "\nTotal Máquinas Alquiladas: " + conteoMaquinasAlquiladasGeneral + "\n  Máquina de Algodón: " + conteoMaquinaAlgodon + "\n  Máquina de Chocolate: " + conteoMaquinaChocolate + "\n  Máquina de Palomitas: " + conteoMaquinaPalomitas;
        
        return mostrar;

    }

    // Métodos

    private void maquinasDemostracion(){

        //Categoria palomitas
    
        MPalomitas p1 = new MPalomitas(1,"Oster",200,true, 50, true);
        this.maquina.add(p1);

        MPalomitas p2 = new MPalomitas(2, "Ganzo", 300, true, 100, false);
        this.maquina.add(p2);

        // Categoria Algodon

        MAlgodon a1 = new MAlgodon(5,"Oster", 250,true, 1200);
        this.maquina.add(a1);

        MAlgodon a2 = new MAlgodon(6,"Euofar", 176, true, 900);

        this.maquina.add(a2);

        // Categoria fuente chocolate

        MChocolate c1 = new MChocolate(3,"Suzuki",450,true,2.0f);
        this.maquina.add(c1);

        MChocolate c2 = new MChocolate(4,"Ninja",450,true,9.3f);
        this.maquina.add(c2);
    }

    public float precioMaquina() {
        return 0;
    }



}