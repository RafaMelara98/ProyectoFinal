/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DATABASE.ConsultaCuentas;
import ENTIDADES.Cuenta;
import ENTIDADES.Usuario;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HERNANDEZ
 */
public class Cuentas extends javax.swing.JFrame {
    private JFrame window;
    private Usuario user;
    private ConsultaCuentas cuenta2;
    private List<Cuenta> listaCuentas;
    private JFrame window2;
    /**
     * Creates new form Menu
     */
    public Cuentas(JFrame window2,Usuario user) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(Cuentas.this);
        this.setResizable(false);
        this.setTitle("Cuentas");
        this.window2 = window2;
        this.window = this;
        this.user = user;
        cuenta2 = new ConsultaCuentas();
        int m = cuenta2.obtnerIdUsuario(user.getUsername());
        lblTotal1.setText("Total: " + cuenta2.totalSegunCuenta(m,"Abono"));
        lblTotal2.setText("Total: " + cuenta2.totalSegunCuenta(m, "Cargo"));
        
        String headers[] = {"Nombre de la cuenta","Tipo de cuenta","Monto"};
        String dataAbono[][] = getDataAbono();
        String dataCargo[][] = getDataCargo();   

        
        DefaultTableModel model = new DefaultTableModel(dataAbono,headers);
        DefaultTableModel model2 = new DefaultTableModel(dataCargo,headers);
        tbAbono.setModel(model);
        tbCargo.setModel(model2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnActualizar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCargo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAbono = new javax.swing.JTable();
        lblTotal1 = new javax.swing.JLabel();
        lblTotal2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnActualizarPag = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnActualizar.setText("Actualizar cuenta");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar cuenta");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Abono");

        tbCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbCargo);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cargo");

        tbAbono.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbAbono);

        lblTotal1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTotal1.setText("Total :");

        lblTotal2.setBackground(new java.awt.Color(255, 0, 0));
        lblTotal2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTotal2.setForeground(new java.awt.Color(255, 0, 0));
        lblTotal2.setText("Total :");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel5.setText("CUENTAS");

        btnEliminar.setText("Eliminar cuenta");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizarPag.setText("Actualizar pagina");
        btnActualizarPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPagActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarPag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(272, 272, 272))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarPag, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

            ActualizarCuenta actualizar = new ActualizarCuenta(window);
            setVisible(false);
            actualizar.setVisible(true);
            
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
            AgregarCuenta cuenta = new AgregarCuenta(window,user);
            setVisible(false);
            cuenta.setVisible(true);

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

            EliminarCuenta cuenta = new EliminarCuenta(window,user);
            setVisible(false);
            cuenta.setVisible(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPagActionPerformed

        try {
            int m = cuenta2.obtnerIdUsuario(user.getUsername());
            lblTotal1.setText("Total: $" + cuenta2.totalSegunCuenta(m,"Abono"));
            lblTotal2.setText("Total: $" + cuenta2.totalSegunCuenta(m, "Cargo"));
            String headers[] = {"Nombre de la cuenta","Tipo de cuenta","Monto"};
            
            String dataAbono[][] = getDataAbono();
            String dataCargo[][] = getDataCargo();
            DefaultTableModel model = new DefaultTableModel(dataAbono,headers);
            DefaultTableModel model2 = new DefaultTableModel(dataCargo,headers);            
            tbAbono.setModel(model);
            tbCargo.setModel(model2);
            
        } catch (SQLException ex) {
            Logger.getLogger(Cuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnActualizarPagActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        window2.setVisible(true);
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(Cuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizarPag;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTotal1;
    private javax.swing.JLabel lblTotal2;
    private javax.swing.JTable tbAbono;
    private javax.swing.JTable tbCargo;
    // End of variables declaration//GEN-END:variables
    private String[][] getDataAbono() {
        int m = cuenta2.obtnerIdUsuario(user.getUsername());
        listaCuentas = cuenta2.obtenerCuentasUsuario(m,"Abono");
        String[][] mData = new String[listaCuentas.size()][3];
        BigDecimal mn[][]= getMontoAbono();
        
        for (int i = 0; i < mData.length; i++) {
            if(listaCuentas.get(i).getOperacion().equals("Abono")){
                mData[i][0] = listaCuentas.get(i).getNombreCuenta();
                mData[i][1] = listaCuentas.get(i).getTipoCuenta();
                mData[i][2] = mn[i][0].toString();
            }
        }
        return mData;
    }
        private String[][] getDataCargo() {
        int m = cuenta2.obtnerIdUsuario(user.getUsername());
        listaCuentas = cuenta2.obtenerCuentasUsuario(m,"Cargo");
        String[][] mData = new String[listaCuentas.size()][3];
        BigDecimal mn[][]= getMontoCargo();
        
        for (int i = 0; i < mData.length; i++) {
            if(listaCuentas.get(i).getOperacion().equals("Cargo")){
                mData[i][0] = listaCuentas.get(i).getNombreCuenta();
                mData[i][1] = listaCuentas.get(i).getTipoCuenta();
                mData[i][2] = mn[i][0].toString();
            }
        }
        return mData;
    }
        private BigDecimal[][] getMontoAbono(){
            int m = cuenta2.obtnerIdUsuario(user.getUsername());
            listaCuentas = cuenta2.obtenerCuentasUsuario(m,"Abono");
            BigDecimal[][] mData = new BigDecimal[listaCuentas.size()][1];

            for (int i = 0; i < mData.length; i++) {
                if(listaCuentas.get(i).getOperacion().equals("Abono")){
                    mData[i][0] = listaCuentas.get(i).getSaldo();
                }
            }
            return mData;            
        }
        
        private BigDecimal[][] getMontoCargo(){
            int m = cuenta2.obtnerIdUsuario(user.getUsername());
            listaCuentas = cuenta2.obtenerCuentasUsuario(m,"Cargo");
            BigDecimal[][] mData = new BigDecimal[listaCuentas.size()][1];

            for (int i = 0; i < mData.length; i++) {
                if(listaCuentas.get(i).getOperacion().equals("Cargo")){
                    mData[i][0] = listaCuentas.get(i).getSaldo();
                }
            }
            return mData;            
        }
}
