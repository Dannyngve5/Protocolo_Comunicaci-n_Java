public class Receptor {
    
  
    private String mensaje="",data="",hctrl,startFrame,stopFrame;
    
    private int nFrames, iteraciones = 0,inthctrl,intStartFrame,intStopFrame, palabrasRecibidas = 0;
    private String[] trama = new String[4];
    private boolean iniciado = false;
    private String[] tramaRespuesta = new String[4];
    int fnCont = 0;
    

    public void recibir(String[] trama, int nFrames){
        this.nFrames = nFrames;
        System.out.println("Trama recibida");
        
        this.trama = trama;
        System.out.println("Trama al momento de recibir");
        for(int i=0;i<this.trama.length;i++){
            System.out.print(this.trama[i]+" - ");
        }
        separar();
    }
    
    public void separar(){
                
        startFrame = trama[0];
        stopFrame = trama[3];
        hctrl = trama[1];
        data = trama[2];
        
               
        intStartFrame =Integer.parseInt(startFrame);
        intStopFrame =Integer.parseInt(stopFrame);
        inthctrl =Integer.parseInt(2+hctrl);
    }
    
    public String[] armarTramaR(String hctrl){
        String tramaRespuesta[] = new String[4];
        tramaRespuesta[0] = startFrame;
        tramaRespuesta[1] = hctrl+palabrasRecibidas;
        tramaRespuesta[2] = data;
        tramaRespuesta[3] = stopFrame;
        return tramaRespuesta;
    }
    
    public void reinicio(){
        iteraciones = 0;
        iniciado = false;
        data = "";
        nFrames = 0;
        mensaje = "";
    }
    
    public void mensajeFinal(){
        fnCont++;
        if(fnCont==3){
            mensaje += (" "+tramaRespuesta[2]);
            fnCont = 0;
        }
        
    }
    
    public String[] responder(){
        separar();
        inthctrl /= 10;
        
        if(inthctrl == 2001010){ //solicitando permiso para transmitir
            tramaRespuesta = armarTramaR("001001"); // Conceder permiso
            
            return tramaRespuesta;
        }else{
            
                tramaRespuesta = armarTramaR("101000"); //Todo piola y ctrl
                mensajeFinal();
                String[] num = mensaje.split("\\s+");
                palabrasRecibidas = num.length;
            }
        
        
        return tramaRespuesta;
    }
        
        
        /*
        if(hctrl ){
            iteraciones++;
            
        }else{
            
        }
        if(iteraciones == nFrames){
            //ultima transmisión
            iteraciones = 0;
            iniciado = false;
            data = "";
        }
        */
        
     
               
        
    

    public String getMensaje() {
        return mensaje;
    }

    public String getData() {
        return data;
    }

    public String getHctrl() {
        return hctrl;
    }

    public String getStopFrame() {
        return stopFrame;
    }
    public String getStartFrame() {
        return startFrame;
    }
    
    
    
   
}