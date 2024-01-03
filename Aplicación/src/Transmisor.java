public class Transmisor {
    
    private String mensaje;
    private int nFrames;
    private String[] trama;

    public Transmisor(String mensaje, int nFrames, String[] trama) {
        this.mensaje = mensaje;
        this.nFrames = nFrames;
        this.trama = trama;
    }
    
    public String[] enviar(){
        System.out.println("Enviando trama");
        return trama;
    }

    public void setTrama(String[] trama) {
        this.trama = trama;
        
    }
    
    
    
    
    
    
    
}
