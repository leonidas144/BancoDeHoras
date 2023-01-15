/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package application;

import conexoes.GerarRelatorio;
import objetos.AddHoras;
import objetos.PapaMike;
import conexoes.MySQL;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetos.SubHoras;




/**
 *
 * @author leo_a
 */
public class Consulta extends javax.swing.JFrame {
    MySQL conectar = new MySQL();
    PapaMike PapaMike = new PapaMike();
    AddHoras AddHoras = new AddHoras();
    SubHoras SubHoras = new SubHoras();
   
    /**
     * Creates new form Consulta
     */
    public Consulta() {
        initComponents();
        
        
        
    }
     
    private void horasPM(PapaMike horasPM){
        this.conectar.conectaBanco();
        
        String buscaPM = txtRE.getText();
        
        try{
            this.conectar.executarSQL(
                    "SELECT "
                    + "horas "
                    + "FROM "
                    + "papaMike "
                    + "WHERE "
                    + "re = '" + buscaPM + "' ;");
            
            if(this.conectar.getResultSet().next()){
                PapaMike.setHoras(Float.parseFloat(this.conectar.getResultSet().getString(1)));
            }else{
                JOptionPane.showMessageDialog(null, "RE não localizado");
                txtHoras.setText("");
            }
            
        
        }catch (NumberFormatException | SQLException e){
            System.out.println("Erro ao consultar horas!" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao consultar horas!");
        
        }catch (InputMismatchException e){
            System.out.println("Digite um RE para consultar!" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Digite um RE para consultar!");
            
        }finally{
            txtHoras.setText(String.valueOf(horasPM.getHoras()));
            this.conectar.fechaBanco();
        }
    }
    
     private void addHorasPM(PapaMike addHorasPM){
        this.conectar.conectaBanco();
        
        String buscaPM = txtRE.getText();
          
        try{
            this.conectar.executarSQL(
                    "SELECT "
                    + "DATE_FORMAT "
                    + "(data, '%d/%m/%Y'), "
                    + "horas, "
                    + "obs "
                    + "FROM "
                    + "addHora "
                    + "WHERE "
                    + "re = '" + buscaPM + "' ;");
            
            
            while(this.conectar.getResultSet().next()){
                AddHoras.setData(this.conectar.getResultSet().getString(1));
                AddHoras.setHoras(Float.parseFloat(this.conectar.getResultSet().getString(2)));
                AddHoras.setObs(this.conectar.getResultSet().getString(3));
                
                DefaultTableModel modelo = (DefaultTableModel) jtableEntrada.getModel();
                Object[] addHoras = new Object[]{
                    AddHoras.getData(),
                    AddHoras.getHoras(),
                    AddHoras.getObs()
                };
                modelo.addRow(addHoras);
                
            }
        
        }catch (Exception e){
            System.out.println("Erro ao consultar horas!" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao consultar horas!");
        
        }finally{
            this.conectar.fechaBanco();
        }
    }
     
     
     private void subHorasPM(PapaMike subHorasPM){
        this.conectar.conectaBanco();
        
        String buscaPM = txtRE.getText();
          
        try{
            this.conectar.executarSQL(
                    "SELECT "
                    + "DATE_FORMAT "
                    + "(data, '%d/%m/%Y'), "
                    + "horas, "
                    + "obs "
                    + "FROM "
                    + "subHora "
                    + "WHERE "
                    + "re = '" + buscaPM + "' ;");
            
            
            while(this.conectar.getResultSet().next()){
                SubHoras.setData(this.conectar.getResultSet().getString(1));
                SubHoras.setHoras(Float.parseFloat(this.conectar.getResultSet().getString(2)));
                SubHoras.setObs(this.conectar.getResultSet().getString(3));
                
                DefaultTableModel modelo = (DefaultTableModel) jtableDescontos.getModel();
                Object[] subHoras = new Object[]{
                    SubHoras.getData(),
                    SubHoras.getHoras(),
                    SubHoras.getObs()
                };
                modelo.addRow(subHoras);
                
            }
        
        }catch (Exception e){
            System.out.println("Erro ao consultar horas!" + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao consultar horas!");
        
        }finally{
            this.conectar.fechaBanco();
        }
    }
     
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtableDescontos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtRE = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtHoras = new javax.swing.JTextField();
        btnConsulta = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtableEntrada = new javax.swing.JTable();
        lblFechar = new javax.swing.JLabel();
        lblVoltar = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Descontos no Banco de Horas"));

        jtableDescontos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtableDescontos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Horas", "Observações"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableDescontos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane4.setViewportView(jtableDescontos);
        if (jtableDescontos.getColumnModel().getColumnCount() > 0) {
            jtableDescontos.getColumnModel().getColumn(0).setPreferredWidth(79);
            jtableDescontos.getColumnModel().getColumn(1).setPreferredWidth(79);
            jtableDescontos.getColumnModel().getColumn(2).setPreferredWidth(265);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));

        txtRE.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtRE.setToolTipText("Digite seu RE e após clique em consultar.");
        txtRE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtREKeyPressed(evt);
            }
        });

        jLabel1.setText("Horas:");

        jLabel2.setText("Digite o R.E.:");

        txtHoras.setEditable(false);
        txtHoras.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        btnConsulta.setText("Consultar");
        btnConsulta.setToolTipText("Após digitar o RE clique aqui para consultar.");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print_resized (1).png"))); // NOI18N
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtRE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRE, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(txtHoras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrint))
                .addGap(12, 12, 12))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Entradas no Banco de Horas"));

        jtableEntrada.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jtableEntrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Horas", "Observações"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableEntrada.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane3.setViewportView(jtableEntrada);
        if (jtableEntrada.getColumnModel().getColumnCount() > 0) {
            jtableEntrada.getColumnModel().getColumn(0).setPreferredWidth(79);
            jtableEntrada.getColumnModel().getColumn(1).setPreferredWidth(79);
            jtableEntrada.getColumnModel().getColumn(2).setPreferredWidth(265);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/X.png"))); // NOI18N
        lblFechar.setToolTipText("Fechar");
        lblFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFecharMouseClicked(evt);
            }
        });

        lblVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/5172489_arrow_back_loop_icon.png"))); // NOI18N
        lblVoltar.setToolTipText("Voltar para Adição/Desconto no Banco.");
        lblVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVoltarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFechar)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Bolacha_BAv_SCB_-_Alta_Resolução-removebg-preview_resized.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Brasão CAvPM - NOVO - Sem Fundo_resized.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel4.setText("Banco de Horas");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        if("".equals(txtRE.getText())){
            txtHoras.setText("");
            JOptionPane.showMessageDialog(null, "Digite um RE para consultar");
        }else{
        txtHoras.setText("");
        ((DefaultTableModel) jtableDescontos.getModel()).setRowCount(0);
        ((DefaultTableModel) jtableEntrada.getModel()).setRowCount(0);
        horasPM (PapaMike);
        addHorasPM (PapaMike);
        subHorasPM (PapaMike);
        }
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        
        GerarRelatorio rel = new GerarRelatorio();
        try {
            this.conectar.conectaBanco();
            rel.ficha("C:\\Users\\leo_a\\Documents\\NetBeansProjects\\Banco de Horas\\src\\MyReports\\Horas_1.jasper");
            System.out.println("Successfully exported report to PDF.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
   
    }//GEN-LAST:event_btnPrintActionPerformed

    private void lblFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFecharMouseClicked
        dispose();
    }//GEN-LAST:event_lblFecharMouseClicked

    private void txtREKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtREKeyPressed
        int tecla = evt.getKeyCode();
        if(tecla == KeyEvent.VK_ENTER){
            if("".equals(txtRE.getText())){
                txtHoras.setText("");
                JOptionPane.showMessageDialog(null, "Digite um RE para consultar");
            }else{
                txtHoras.setText("");
                ((DefaultTableModel) jtableDescontos.getModel()).setRowCount(0);
                ((DefaultTableModel) jtableEntrada.getModel()).setRowCount(0);
                horasPM (PapaMike);
                addHorasPM (PapaMike);
                subHorasPM (PapaMike);
            }
        }
    }//GEN-LAST:event_txtREKeyPressed

    private void lblVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVoltarMouseClicked
        new EditaHoras().setVisible(true);
        dispose();
    }//GEN-LAST:event_lblVoltarMouseClicked

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
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jtableDescontos;
    private javax.swing.JTable jtableEntrada;
    private javax.swing.JLabel lblFechar;
    private javax.swing.JLabel lblVoltar;
    private javax.swing.JTextField txtHoras;
    private javax.swing.JTextField txtRE;
    // End of variables declaration//GEN-END:variables

    private ResultSet getResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void gerarRelatorio(PapaMike PapaMike) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
