import java.util.ArrayList;
import java.util.Collections;

public class Sistema {
    
    // Atributos
    private ArrayList<Api> apis;

    // Constructor
    public Sistema() {
        this.apis = new ArrayList<Api>();
    }

    // Métodos
    public String listaInteraccionesActivas() { // recore la lista y toma el identificador y el estado de conexion 
        
        String listar = "";

        for (Api a : apis){
            listar = listar + "\nIdentificador del servicio: " + a.getIdentificador() + "\nEstado conexión: " + a.getEstadoConexion() + "\n \n";
        }

        return listar;
    }

    public String buscarApi(int identificador) { // se busca un api por su identificador
        
        try{
            String info = "";
    
            for(Api a:  apis){ // recore toda la lista
                if(a.getIdentificador() == identificador){ // compara si el identificado de la cual va recorriendo es igual a al identificado ingresado por el usuario 
                    info = a.toString(); 
                    return info;

                }
            }

            return "No se encontró el Identificador " + identificador;
        }catch(Exception e){
            return "No se encontró el Identificador " + identificador;
        }

    }

    public String catalogo() {

        ordenarLatencia(); // ordena la lista de Api

        String info = "";
        for (Api a : apis){
            info = info + "\n" + a.toString() + "\n";

        }
        return info;

    }

    public String operaciones(int identificador, int accion2) {
        try{

            for(Api a:  apis){ // recore toda la lista
                if(a.getIdentificador() == identificador){ // compara si el identificado de la cual va recorriendo es igual a al identificado ingresado por el usuario 
                    
                    String mensaje = "";
                    switch (accion2) {
                        case 1: 
                            if (a instanceof Auditable){ // si es que tiene el métod de auditable ntonces 
                                Auditable auditable = (Auditable) a; //hace una referencia de tipo Auditable para utilizar los métodos de es ainterfaz 
                                 
                                mensaje = "Registro evento: " + auditable.registrarEvento() + "\nConsultar Historial" + auditable.consultarHistorialEventos();
                                
                                return mensaje;
                            }
                            
                            return "Esta operación no está disponible para " + identificador;
                            
                        case 2:
                            if(a instanceof Cobrar){
                                Cobrar c = (Cobrar) a; // hace una referencia para acceder a os métodos

                                mensaje = "Cobro: " + c.cobrar();

                                return mensaje;
                            }
                            return "Esta operación no está disponible para " + identificador;
                        case 3:
                            if(a instanceof ConsultarEstado){
                                ConsultarEstado consultar = (ConsultarEstado) a;// Hace referencia para acceder a los métodos

                                mensaje =  consultar.consultarEstado();

                                return mensaje;
                            }
                            
                            return "Esta operación no está disponible para " + identificador;
                        case 4:
                            if(a instanceof Cotizar){
                                Cotizar cotizar = (Cotizar) a;

                                return cotizar.cotizar();
                            }
                            return "Esta operación no está disponible para " + identificador;
                        case 5:
                            if(a instanceof Documentable){
                                Documentable doc = (Documentable) a;

                                return doc.generarDocumento();
                            }
                            return "Esta operación no está disponible para " + identificador;
                        case 6: 
                            if(a instanceof Reintegro){
                                Reintegro reintegro = (Reintegro) a;

                                return  reintegro.reintegro();
                            }
                            return "Esta operación no está disponible para " + identificador;

                    }

                }
            }

            // en caso que no este: 

            return "No se encontró el Identificador " + identificador;
        }catch(Exception e){
            return "No se encontró el Identificador " + identificador;
        }

    }
    
    public void ordenarLatencia() { //odenar latancia 
        // Collections.sort() es un método especialmente útil cuando se trabaja con compareTo() porque perminte organizar las coasa según el críterio que estable compareTo
        Collections.sort(apis); /// utiliza el orden que fue previamente establecido  y ordena la lista de api

    }

    public void cargarIntegraciones() { // Se establecen apis predeteminadas y se agregan a la lista
        ApiCajaVentana c1 = new ApiCajaVentana(101, false, 20, false );
        this.apis.add(c1);
        ApiCajaVentana c2 = new ApiCajaVentana(102, true, 85, true);
        this.apis.add(c2);
        ApiCajaVentana c3 = new ApiCajaVentana(103, true, 100, true);
        this.apis.add(c3);
        ApiBanco b1 = new ApiBanco(104, true, 150, true);
        this.apis.add(b1);
        ApiBanco b2 = new ApiBanco(105, false, 95, false);
        this.apis.add(b2);
        ApiEnvio e1 = new ApiEnvio(106, true, 200, true);
        this.apis.add(e1);
        ApiEnvio e2 = new ApiEnvio(107,true, 110, true);
        this.apis.add(e2);
        ApiEnvio e3 = new ApiEnvio(108, true, 110, true);
        this.apis.add(e3);
        ApiLogistica l1 = new ApiLogistica(109, true, 180, true);
        this.apis.add(l1);
        ApiFacturacion a1 = new ApiFacturacion(110, true, 75, true);
        this.apis.add(a1);
    
    }


}
