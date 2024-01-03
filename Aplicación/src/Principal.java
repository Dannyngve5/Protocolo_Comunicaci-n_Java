//Versión final
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hogar
 */
public class Principal extends javax.swing.JFrame {

    private String semanticaTx, panel = "", semanticaRx;
    private String paquete[];
    private int  iteraciones = 0, nMensajes = 0, nFrames, nUsal = 0;
    private boolean tIniciada = false, ultima = false;
    private Transmisor tx;
    private Receptor rx = new Receptor();
    
    
    
            
    public Principal() {
        initComponents();
    }
    
    public void enviarTrama(int nFrames){
        paquete = tx.enviar();
        rx.recibir(paquete, nFrames);//Envia la trama
        iteraciones++;
        jLabelStartRx.setText(rx.getStartFrame());
        jLabelStopRx.setText(rx.getStopFrame());
        jLabelDataRx.setText(rx.getData());
        jLabelctrlRx.setText(rx.getHctrl());
        
        
    }
    
    
    
    
    public String labelSemantica(){
        
        
        
        semanticaTx = "";
        if(ck3.isSelected()==true){
            semanticaTx += " Trama de Control,";
        }
        if(ck4.isSelected()==true){
            semanticaTx += " Trama de Datos,";
        }
        if(ck1.isSelected()==true){
            semanticaTx += " Trama recibida con éxtio,";
        }
        if(ck2.isSelected()==true){
            semanticaTx += " Última trama enviada,";
        }
        if(ck5.isSelected()==true){
            semanticaTx += " Permiso para transmitir,";
        }
        if(ck6.isSelected()==true){
            semanticaTx += " Permiso transmsión aprobado,";
        }
        String nTram = jLabelCk7.getText();
        semanticaTx += " Trama N. "+nTram+ ", ";
        
        return semanticaTx;
    }
    
    public String labelSemanticaRx(String hctrl){
        semanticaRx = "";
        char separado[] = new char[10];
        for (int i=0; i <hctrl.length(); i++) { 
            char c = hctrl.charAt (i); 
            separado[i] = c;
        }
        
        
        jLabelCk11.setText(String.valueOf(separado[0]));
        jLabelCk12.setText(String.valueOf(separado[1]));
        jLabelCk13.setText(String.valueOf(separado[2]));
        jLabelCk14.setText(String.valueOf(separado[3]));
        jLabelCk15.setText(String.valueOf(separado[4]));
        jLabelCk16.setText(String.valueOf(separado[5]));    
        jLabelCk17.setText(String.valueOf(separado[6]));             
          
        //System.out.println("AAAA: " + jLabelCk11.getText()+ jLabelCk12.getText() + jLabelCk13.getText()+ jLabelCk14.getText() + jLabelCk15.getText() + jLabelCk16.getText() + jLabelCk17.getText() );
               
        if("1".equals(jLabelCk13.getText()) ){
            
            semanticaRx += " Trama de Control,";
        }
        if("1".equals(jLabelCk14.getText())){
            semanticaRx += " Trama de Datos,";
        }
        if("1".equals(jLabelCk11.getText())){
            semanticaRx += " Trama recibida con éxtio,";
        }
        if("1".equals(jLabelCk12.getText())){
            semanticaRx += " Última trama enviada,";
        }
        if("1".equals(jLabelCk15.getText())){
            semanticaRx += " Permiso para transmitir,";
        }
        if("1".equals(jLabelCk16.getText())){
            semanticaRx += " Permiso transmsión aprobado,";
        }
        
        String nTram = jLabelCk17.getText();
        semanticaRx += " Trama N. "+nTram+ ", ";
        
        
        
        return semanticaRx;
    }
    
    
    
    public boolean tramaCorrecta(String startFrame, String hctrl, String stopFrame){
        
        //Binario
       
        int intStartFrame =Integer.parseInt(startFrame);
        int intStopFrame = Integer.parseInt(stopFrame);
        int inthctrl =Integer.parseInt(2+hctrl);
        
        
        
        if((intStartFrame == 11000001) && (intStopFrame == 10000011 )){ //Comprueba indicadores
            
            if(tIniciada){
                
                nUsal++;
                System.out.println("Nusal "+nUsal);
                
                if(nFrames == nUsal){ //ultimo mensaje
                    System.out.println("Entro");
                    if(inthctrl == 2010100  ){
                    
                        return true;
                }else{
                    nUsal -= 1;
                        System.out.println("Nusal resta;:" + nUsal);
                        
                    return false;
                    
                     }
                }else{
                     
                    if(inthctrl == 2000100){
                        
                        return true;
                    }
                }
                
                
                
            }else{
                System.out.println("WTF");
                if(inthctrl == 2001010){ //Solicitando permiso para transmitir
                    
                    return true;
                }else{
                    
                    return false;
                }
            }
        }
        nUsal -= 1;
        return false;
    }   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        ck1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabelCk7 = new javax.swing.JLabel();
        jLabelSemanticaTx = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ck2 = new javax.swing.JCheckBox();
        jLabelCk6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        numFrames = new javax.swing.JTextField();
        textMensajeTx = new javax.swing.JTextField();
        textStartFrame = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        ck3 = new javax.swing.JCheckBox();
        ck4 = new javax.swing.JCheckBox();
        ck5 = new javax.swing.JCheckBox();
        ck6 = new javax.swing.JCheckBox();
        textStopFrame = new javax.swing.JTextField();
        jLabelCk1 = new javax.swing.JLabel();
        jLabelCk2 = new javax.swing.JLabel();
        jLabelCk3 = new javax.swing.JLabel();
        jLabelCk4 = new javax.swing.JLabel();
        jLabelCk5 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabelDataTx = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabelStartRx = new javax.swing.JLabel();
        jLabelStopRx = new javax.swing.JLabel();
        jLabelDataRx = new javax.swing.JLabel();
        jLabelctrlRx = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabelCk15 = new javax.swing.JLabel();
        jLabelCk17 = new javax.swing.JLabel();
        jLabelSemanticaRx = new javax.swing.JLabel();
        jLabelCk16 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        textStartFrame1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        textStopFrame1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        textMensajeTxTrama1 = new javax.swing.JTextField();
        jLabelCk11 = new javax.swing.JLabel();
        jLabelCk12 = new javax.swing.JLabel();
        jLabelCk13 = new javax.swing.JLabel();
        jLabelCk14 = new javax.swing.JLabel();
        responder = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        enviar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPanel = new javax.swing.JTextArea();
        jLabel33 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        mensaje_final = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ck1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Mensaje a transmitir:");

        jLabelCk7.setText("0");

        jLabelSemanticaTx.setText("Sin selección");

        jLabel2.setText("# Frames:");

        ck2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck2ActionPerformed(evt);
            }
        });

        jLabelCk6.setText("0");

        jLabel4.setText("Semántica:");

        numFrames.setText("2");
        numFrames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numFramesActionPerformed(evt);
            }
        });

        textMensajeTx.setText("Hola mundo");
        textMensajeTx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMensajeTxActionPerformed(evt);
            }
        });

        textStartFrame.setText("11000001");
        textStartFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textStartFrameActionPerformed(evt);
            }
        });

        ck3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck3ActionPerformed(evt);
            }
        });

        ck4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck4ActionPerformed(evt);
            }
        });

        ck5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck5ActionPerformed(evt);
            }
        });

        ck6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(ck3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ck4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ck5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ck6)
                .addGap(0, 23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ck3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ck4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ck5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ck6, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        textStopFrame.setText("10000011");
        textStopFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textStopFrameActionPerformed(evt);
            }
        });

        jLabelCk1.setText("0");

        jLabelCk2.setText("0");

        jLabelCk3.setText("0");

        jLabelCk4.setText("0");

        jLabelCk5.setText("0");

        jLabel5.setText("INDICADOR");

        jLabel6.setText("ACK");

        jLabel7.setText("NUM");

        jLabel8.setText("ENQ");

        jLabel9.setText("CTR");

        jLabel10.setText("DAT");

        jLabel11.setText("PPT");

        jLabel12.setText("LPR");

        jLabel13.setText("INFORMACIÓN");

        jLabel14.setText("INDICADOR");

        jLabel32.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel32.setText("Transmisor");

        jLabelDataTx.setText("Sin información");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSemanticaTx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textStartFrame)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabelCk1)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabelCk2)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabelCk3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabelCk4)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabelCk5)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabelCk6)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabelCk7))
                                            .addComponent(jLabel7))
                                        .addGap(79, 79, 79)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabelDataTx)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(ck1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ck2)
                                        .addGap(16, 16, 16)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(17, 17, 17)
                                .addComponent(textMensajeTx, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numFrames, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textStopFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(numFrames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textMensajeTx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(textStartFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCk1)
                            .addComponent(jLabelCk2)
                            .addComponent(jLabelCk3)
                            .addComponent(jLabelCk4)
                            .addComponent(jLabelCk5)
                            .addComponent(jLabelCk6)
                            .addComponent(jLabelCk7)
                            .addComponent(textStopFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDataTx))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ck2)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ck1))))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSemanticaTx)
                    .addComponent(jLabel4))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel15.setText("TRAILER");

        jLabel16.setText("Trama recibida :");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setText("Receptor");

        jLabel18.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel18.setText("HEADER");

        jLabel19.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel19.setText("INFORMACIÓN");

        jLabelStartRx.setText("00000000");

        jLabelStopRx.setText("00000000");

        jLabelDataRx.setText("00000000");

        jLabelctrlRx.setText("00000000");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelStartRx)
                                    .addComponent(jLabel16))
                                .addGap(32, 32, 32)
                                .addComponent(jLabelctrlRx)
                                .addGap(52, 52, 52)
                                .addComponent(jLabelDataRx)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelStopRx))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel18)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel19)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStartRx)
                    .addComponent(jLabelStopRx)
                    .addComponent(jLabelDataRx)
                    .addComponent(jLabelctrlRx))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel15))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel20.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel20.setText("Repuesta");

        jLabel21.setText("PPT");

        jLabel22.setText("LPR");

        jLabel23.setText("INFORMACIÓN");

        jLabel24.setText("INDICADOR");

        jLabelCk15.setText("0");

        jLabelCk17.setText("0");

        jLabelSemanticaRx.setText("Sin selección");

        jLabelCk16.setText("0");

        jLabel25.setText("Semántica:");

        jLabel26.setText("INDICADOR");

        jLabel27.setText("ACK");

        jLabel28.setText("NUM");

        jLabel29.setText("ENQ");

        textStartFrame1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textStartFrame1ActionPerformed(evt);
            }
        });

        jLabel30.setText("CTR");

        textStopFrame1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textStopFrame1ActionPerformed(evt);
            }
        });

        jLabel31.setText("DAT");

        jLabelCk11.setText("0");

        jLabelCk12.setText("0");

        jLabelCk13.setText("0");

        jLabelCk14.setText("0");

        responder.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        responder.setText("Responder");
        responder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                responderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSemanticaRx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(396, 396, 396))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textStartFrame1)
                                    .addComponent(jLabel26))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabelCk11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabelCk12)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabelCk13)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabelCk14)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabelCk15)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabelCk16)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabelCk17))
                                    .addComponent(jLabel28))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(textMensajeTxTrama1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23)
                                        .addGap(50, 50, 50)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(textStopFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(responder)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(textStartFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelCk11)
                                    .addComponent(jLabelCk12)
                                    .addComponent(jLabelCk13)
                                    .addComponent(jLabelCk14)
                                    .addComponent(jLabelCk15)
                                    .addComponent(jLabelCk16)
                                    .addComponent(jLabelCk17)
                                    .addComponent(textMensajeTxTrama1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textStopFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(responder, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSemanticaRx)
                    .addComponent(jLabel25))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        enviar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        enviar.setText("Enviar");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        jTextPanel.setColumns(20);
        jTextPanel.setRows(5);
        jScrollPane2.setViewportView(jTextPanel);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );

        jLabel33.setText("Secuencia de Tramas");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(enviar)
                .addGap(22, 22, 22)
                .addComponent(jLabel33)
                .addGap(6, 6, 6)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel34.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel34.setText("Mensaje recibido:");

        mensaje_final.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mensaje_final.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mensaje_finalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mensaje_final, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(mensaje_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textStartFrame1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textStartFrame1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textStartFrame1ActionPerformed

    private void textStopFrame1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textStopFrame1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textStopFrame1ActionPerformed

    private void textStopFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textStopFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textStopFrameActionPerformed

    private void ck6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck6ActionPerformed
        jLabelSemanticaTx.setText("");
        if(ck6.isSelected()==true){
            jLabelSemanticaTx.setText(labelSemantica());
            jLabelCk6.setText(String.valueOf(1));
        }else{
            jLabelSemanticaTx.setText(labelSemantica());
            jLabelCk6.setText(String.valueOf(0));
        }
    }//GEN-LAST:event_ck6ActionPerformed

    private void ck5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck5ActionPerformed
        jLabelSemanticaTx.setText("");
        if(ck5.isSelected()==true){
            jLabelSemanticaTx.setText(labelSemantica());
            jLabelCk5.setText(String.valueOf(1));
        }else{
            jLabelSemanticaTx.setText(labelSemantica());
            jLabelCk5.setText(String.valueOf(0));
        }
    }//GEN-LAST:event_ck5ActionPerformed

    private void ck4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck4ActionPerformed
        jLabelSemanticaTx.setText("");
        if(ck4.isSelected()==true){
            jLabelSemanticaTx.setText(labelSemantica());
            jLabelCk4.setText(String.valueOf(1));
        }else{
            jLabelSemanticaTx.setText(labelSemantica());
            jLabelCk4.setText(String.valueOf(0));
        }
    }//GEN-LAST:event_ck4ActionPerformed

    private void ck3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck3ActionPerformed
        jLabelSemanticaTx.setText("");
        if(ck3.isSelected()==true){
            jLabelSemanticaTx.setText(labelSemantica());
            jLabelCk3.setText(String.valueOf(1));
        }else{
            jLabelSemanticaTx.setText(labelSemantica());
            jLabelCk3.setText(String.valueOf(0));
        }
    }//GEN-LAST:event_ck3ActionPerformed

    private void textStartFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textStartFrameActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_textStartFrameActionPerformed

    private void textMensajeTxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMensajeTxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMensajeTxActionPerformed

    private void numFramesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numFramesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numFramesActionPerformed

    private void ck2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck2ActionPerformed
        jLabelSemanticaTx.setText("");
        if(ck2.isSelected()==true){
            jLabelSemanticaTx.setText(labelSemantica());
            jLabelCk2.setText(String.valueOf(1));
        }else{
            jLabelSemanticaTx.setText(labelSemantica());
            jLabelCk2.setText(String.valueOf(0));
        }
    }//GEN-LAST:event_ck2ActionPerformed

    private void ck1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck1ActionPerformed
        jLabelSemanticaTx.setText("");
        if(ck1.isSelected()==true){
            jLabelSemanticaTx.setText(labelSemantica());
            jLabelCk1.setText(String.valueOf(1));
        }else{
            jLabelSemanticaTx.setText(labelSemantica());
            jLabelCk1.setText(String.valueOf(0));
        }
    }//GEN-LAST:event_ck1ActionPerformed

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        
        String trama[] = new String[4];
        String hctrl = "";
        int nPalabras = 0;
        // Capturar campos
        String nFr = this.numFrames.getText();//Capturar Frames
        nFrames = Integer.parseInt(nFr); 
        String mensaje = this.textMensajeTx.getText();   //Capturar mensaje 
        String startFrame = textStartFrame.getText() ;   //Capturar StartFrame
        String stopFrame = textStopFrame.getText() ;     //Capturar StopFrame
        String partes[] = new String [nFrames];
        //Separa las palabras
        try {
            
            String[] newStr = mensaje.split("\\s+");
            for (int i = 0; i < newStr.length; i++) {
                partes[i] = newStr[i];
                nPalabras = newStr.length ;
                //System.out.println(partes[i]);
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            panel = jTextPanel.getText();
             //Que no se borre
            nPalabras = 0;
         }
        //Header control       
        hctrl = jLabelCk1.getText() +  jLabelCk2.getText() +  jLabelCk3.getText() + jLabelCk4.getText()+ jLabelCk5.getText() + jLabelCk6.getText()  ;
        
        //Comprueba que #frames # numero palabras
        
        
        System.out.println("palabra "+nPalabras+" n grames "+nFrames);
        if(nPalabras  == nFrames){
            //Comprobar la trama
            if(tramaCorrecta(startFrame, hctrl, stopFrame)){
                if(tIniciada){
                    
                    nMensajes++;
                    System.out.println("Nmensajes abajo: "+nMensajes);
                    trama[0] = startFrame; 
                    trama[1] = hctrl+(nMensajes);
                    trama[2] = partes[nMensajes-1];
                    trama[3] = stopFrame;
                    jLabelDataTx.setText(trama[2]);
                    
                    tx.setTrama(trama);        
                    enviarTrama(nFrames);
                    panel = jTextPanel.getText();
                    jTextPanel.setText(panel +  "\nTrama "+iteraciones+" (Tx) ");
                    panel = jTextPanel.getText();
                    jTextPanel.setText(panel + "\nDatos, trama "+nMensajes);
                    jLabelCk7.setText(String.valueOf(nMensajes)); 
                    
                    //
                }else{
                    System.out.println("no Está iniciada, llenando trama");
                                       
                    trama[0] = startFrame;
                    trama[1] = hctrl+(nMensajes);
                    trama[2] = "";
                    trama[3] = stopFrame;
                    
                    tx = new Transmisor(mensaje, nFrames,trama);
                    enviarTrama(nFrames);
                    panel = jTextPanel.getText();
                    jTextPanel.setText(panel +  "\nTrama "+iteraciones+" (Tx) ");
                    panel = jTextPanel.getText();
                    jTextPanel.setText(panel + "\nControl, Permiso para transmitir");
                    
                }
            }else{
                if(nFrames == nMensajes){
                    panel = jTextPanel.getText();
                    jTextPanel.setText(panel + "\nSe finalizó la transmisión");
                }else{
                    panel = jTextPanel.getText();
                    jTextPanel.setText(panel + "\nTramaError");
                }
                
            }
            
        }else{
            panel = jTextPanel.getText();
            jTextPanel.setText(panel + "\nFramesError");
            
        }
        
     
    
        
        
    
    
   

  
// TODO add yourhandling code here:
    }//GEN-LAST:event_enviarActionPerformed

    private void responderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_responderActionPerformed
        
        String tramaRx[] = new String[4];        
        
        
        tramaRx[1] = rx.responder()[1];
        String hctrl = tramaRx[1];
        System.out.println("Control 1: "+hctrl);
        
        
        int inthctrl = Integer.parseInt(2+hctrl);
        
        String intnMensajes= String.valueOf(nMensajes);
        hctrl += intnMensajes;
        
        
        
        textStartFrame1.setText(rx.responder()[0]);
        textMensajeTxTrama1.setText(rx.responder()[2]);
        textStopFrame1.setText(rx.responder()[3]);
        
        jLabelSemanticaRx.setText(labelSemanticaRx(hctrl));
        if((inthctrl/10) == 2001001){
            iteraciones++;
            panel = jTextPanel.getText();
            jTextPanel.setText(panel +  "\nTrama "+iteraciones+" (Rx) ");
            panel = jTextPanel.getText();
            jTextPanel.setText(panel + "\nControl, Permiso para transmitir concedido");
            tIniciada = true;
        }else{
            iteraciones++;
            
            panel = jTextPanel.getText();
            jTextPanel.setText(panel +  "\nTrama "+iteraciones+" (Rx) ");
            panel = jTextPanel.getText();
            jTextPanel.setText(panel + "\nControl, Trama "+nMensajes +"  recibida correctamente" );
            
            mensaje_final.setText(rx.getMensaje());
            //System.out.println(inthctrl%10);
            
            
            
        }
        //Cuanto responda 
        
        
    }//GEN-LAST:event_responderActionPerformed

    private void mensaje_finalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mensaje_finalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mensaje_finalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ck1;
    private javax.swing.JCheckBox ck2;
    private javax.swing.JCheckBox ck3;
    private javax.swing.JCheckBox ck4;
    private javax.swing.JCheckBox ck5;
    private javax.swing.JCheckBox ck6;
    private javax.swing.JButton enviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCk1;
    private javax.swing.JLabel jLabelCk11;
    private javax.swing.JLabel jLabelCk12;
    private javax.swing.JLabel jLabelCk13;
    private javax.swing.JLabel jLabelCk14;
    private javax.swing.JLabel jLabelCk15;
    private javax.swing.JLabel jLabelCk16;
    private javax.swing.JLabel jLabelCk17;
    private javax.swing.JLabel jLabelCk2;
    private javax.swing.JLabel jLabelCk3;
    private javax.swing.JLabel jLabelCk4;
    private javax.swing.JLabel jLabelCk5;
    private javax.swing.JLabel jLabelCk6;
    private javax.swing.JLabel jLabelCk7;
    private javax.swing.JLabel jLabelDataRx;
    private javax.swing.JLabel jLabelDataTx;
    private javax.swing.JLabel jLabelSemanticaRx;
    private javax.swing.JLabel jLabelSemanticaTx;
    private javax.swing.JLabel jLabelStartRx;
    private javax.swing.JLabel jLabelStopRx;
    private javax.swing.JLabel jLabelctrlRx;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextPanel;
    private javax.swing.JTextField mensaje_final;
    private javax.swing.JTextField numFrames;
    private javax.swing.JButton responder;
    private javax.swing.JTextField textMensajeTx;
    private javax.swing.JTextField textMensajeTxTrama1;
    private javax.swing.JTextField textStartFrame;
    private javax.swing.JTextField textStartFrame1;
    private javax.swing.JTextField textStopFrame;
    private javax.swing.JTextField textStopFrame1;
    // End of variables declaration//GEN-END:variables
}
