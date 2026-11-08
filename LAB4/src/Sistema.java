
import java.util.ArrayList;

public class Sistema {

    private ArrayList<Oficina> oficinas;
    private int horasEjecucion;
    private ArrayList<Alerta> alertas;

    public Sistema() {
        oficinas = new ArrayList<>();
        alertas = new ArrayList<>();
        horasEjecucion = 0;
    }

    public void setHorasEjecucion(int horasEjecucion) {
        this.horasEjecucion = horasEjecucion;
    }

    public void cargarIntegraciones(){
        
        Oficina oficina1 = new Oficina(11, "Admin");
        registrarOficina(oficina1);
        Oficina oficina2 = new Oficina(12, "Contq");
        registrarOficina(oficina2);
        Oficina oficina3 = new Oficina(13, "Facturas");
        registrarOficina(oficina3);

        registrarDispositivo(new Camara(21, oficina1, 100));
        registrarDispositivo(new Lumina(22, oficina1, 60));
        registrarDispositivo(new SensorHumo(23, oficina1, 20));
        registrarDispositivo(new Climatizador(24, oficina1, 150));
        

        registrarDispositivo(new Camara(25, oficina2, 120));
        registrarDispositivo(new ClimatizadorInverter(26, oficina2, 180));
        registrarDispositivo(new Lumina(27, oficina2, 80));
        registrarDispositivo(new Climatizador(10, oficina2, 150));


        registrarDispositivo(new SensorHumo(20, oficina3, 20));
        registrarDispositivo(new Camara(28, oficina3, 25));
        registrarDispositivo(new Lumina(29, oficina3, 2012));
        registrarDispositivo(new ClimatizadorInverter(30, oficina3,200));

    }

    public void agregarAlerta(Alerta alerta) {
        alertas.add(alerta);
    }

    public void agregarOficina(Oficina oficina){
        this.oficinas.add(oficina);
    }

    public ArrayList<Alerta> obtenerAlertasPendientes() {
        return new ArrayList<>();
    }

    public String consultarAlertasRetrasadas() {
        return "";
    }

    public String reporte() {
        return "";
    }

    public String dispositivosOrganizados() {
        return "";
    }

    public String bandejaAlertasOrdenada() {
        return "";
    }

    public String facturasGeneradasPorOficina() {
        return "";
    }

    public String totalFacturadoPorFranja() {
        return "";
    }

    public String totalCreditosAplicados() {
        return "";
    }

    public void registrarOficina(Oficina oficina) {
        // Pendiente: validar código y registrar.
    }

    public void registrarDispositivo(Dispositivo dispositivo) { // registra el dispitivo en la oficna 

        Oficina oficina = dispositivo.getOficinaDondeEsta(); // busca la oficnina donde esta
        oficina.agregarDispositivo(dispositivo); // lo manda a ofocina para que se agergue al arraylist

    }

    public String buscarOficina(int codigo) {
        return "";
    }

    public String buscarDispositivo(int codigo) {
        return "";
    }

    public String muestraSuInformacion() {
        return "";
    }

    public String buscarAlerta(int codigo) {
        return "";
    }

    public String atenderAlertaUrgente() {
        return "";
    }

    public void cerrarDia() {
        // Pendiente: generar facturas y reiniciar acumulados.
    }

    public String cambiarEstado(int codigo, int opcion) {
        try{
            
            for(Oficina o: oficinas){
            for (Dispositivo d : o.getDispositivos()) { // Busca en el arraylist en la parte de dispositivos, porque trabajo tiene un arraylist de dispositivos, entonces busca en oficinas y dentro de oficinas busca en dispositivos

                if (d.getCodigo() == codigo) {
                    if(d instanceof InterEstado){ // si tiene la interfaz
                        InterEstado estado = (InterEstado) d ; // Hace una referncia de tipo para acceder a los métodos
                        estado.cambiarEstado(opcion);
                        return "Se cambio el estado";
                    }
                     return "El dipositivo no tiene permitido moficar su estado";
                    }             
            }
        }
        
        return "El dispositivo no está registrado";

    }catch(Exception e){
            return  "No se encontró el dispositvo " + codigo;
        }
}

    public String ajustarNivel(int codigo, int nivel) {

        String mensaje = "";
        try{
            
            for(Oficina o: oficinas){
            for (Dispositivo d : o.getDispositivos()) { // Busca en el arraylist en la parte de dispositivos, porque trabajo tiene un arraylist de dispositivos, entonces busca en oficinas y dentro de oficinas busca en dispositivos

                if (d.getCodigo() == codigo) {
                    if(d instanceof InterRegulable){ // si tiene la interfaz
                        InterRegulable nivelCambio = (InterRegulable) d ; // Hace una referncia de tipo para acceder a los métodos

                        mensaje = nivelCambio.ajustarNivel(nivel);

                        return  mensaje;
                    }
                     return "El dipositivo no tiene permitido moficar su nivel";
                    }             
            }
        }
        
        return "El dispositivo no está registrado";

    }catch(Exception e){
            return  "No se encontró el dispositvo " + codigo;
        }
    }

    public String registrarMedicion(int codigo, int nivel) {

        String mensaje = "";
            try{
                
                for(Oficina o: oficinas){
                for (Dispositivo d : o.getDispositivos()) { // Busca en el arraylist en la parte de dispositivos, porque trabajo tiene un arraylist de dispositivos, entonces busca en oficinas y dentro de oficinas busca en dispositivos

                    if (d.getCodigo() == codigo) {
                        if(d instanceof InterMedible){ // si tiene la interfaz
                            InterMedible medir = (InterMedible) d ; // Hace una referncia de tipo para acceder a los métodos
                             mensaje = medir.registrarMedicion(nivel);

                             return  mensaje;
                        }
                        return "El dipositivo no tiene permitido moficar su nivel";
                        }             
                }
            }
            
            return "El dispositivo no está registrado";

        }catch(Exception e){
                return  "No se encontró el dispositvo " + codigo;
            }
        
    }

    public String registrarMovimiento(int codigo, int hora) {

         String mensaje = "";
            try{
                
                for(Oficina o: oficinas){
                for (Dispositivo d : o.getDispositivos()) { // Busca en el arraylist en la parte de dispositivos, porque trabajo tiene un arraylist de dispositivos, entonces busca en oficinas y dentro de oficinas busca en dispositivos

                    if (d.getCodigo() == codigo) {
                        if(d instanceof Camara){ // si tiene o vien de es alcase 
                            Camara camara = (Camara) d; // Hace una referncia de tipo para acceder a los métodos
                             mensaje = camara.registrarMovimiento(hora);
                             return  mensaje;
                        }
                        return "El dipositivo no tiene permitido moficar su nivel";
                        }             
                }
            }
            
            return "El dispositivo no está registrado";

        }catch(Exception e){
                return  "No se encontró el dispositvo " + codigo;
            }
       
}
   
    public String avanzarHora() {

        double totalConsumo =  0;

        if (horasEjecucion<24){
        
        for (Oficina o : oficinas) {
            for (Dispositivo d : o.getDispositivos()) {
                d.calcularConsumoHora();
                double consumo = d.getConsumoKWh();
                totalConsumo = totalConsumo + consumo;
            }
        }

        horasEjecucion = horasEjecucion + 1;
        return "Se ha ejecutado una hora más ("+horasEjecucion+") y el consumo total es de" + totalConsumo;

        }
       
        return "Ya se se completo un día";


       
    }

    public boolean validarCodigoOficina (int codigo){

        for(Oficina o: oficinas){
            if(o.getCodigo()== codigo){
                return true;
            }
        }

        return false;
    }

    public boolean validarCodigoDispositivo(int codigoDispositivo){
        
        for(Oficina o: oficinas){
            for (Dispositivo d : o.getDispositivos()) { // Busca en el arraylist en la parte de dispositivos, porque trabajo tiene un arraylist de dispositivos, entonces busca en oficinas y dentro de oficinas busca en dispositivos

                if (d.getCodigo() == codigoDispositivo) {
                    return true;
                }       
            }
        }
         return false;
    }

    public Oficina buscarOficinaAgregar(int codigo) { // busca que si exista la focina

    for (Oficina oficina : oficinas) {

        if (oficina.getCodigo() == codigo) {
            return oficina;
        }
    }
    return null;

    }
}
