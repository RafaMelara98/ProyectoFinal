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
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HERNANDEZ
 */
public class AgregarCuenta extends javax.swing.JFrame {
    private JFrame window;
    private Usuario user;
    private Cuenta cuenta;
    private ConsultaCuentas Cuenta;
    /**
     * Creates new form AgregarCuenta
     */
    public AgregarCuenta(JFrame window, Usuario user) {
        initComponents();
        this.setLocationRelativeTo(AgregarCuenta.this);
        this.setResizable(false);
        this.window = window;
        this.user = user;
        Cuenta = new ConsultaCuentas();
        cuenta = new Cuenta();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCuenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbTipoCuenta = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbOperacion = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        spMonto = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel1.setText("Agregar Cuenta");

        jLabel2.setText("Tipo de cuenta:");

        txtNombreCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCuentaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre de la cuenta: ");

        cbTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Debito", "Credito", "Efectivo" }));

        jLabel4.setText("Operacion: ");

        cbOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abono", "Cargo" }));
        cbOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOperacionActionPerformed(evt);
            }
        });

        jLabel5.setText("Monto: ");

        jLabel6.setText("Descripcion : ");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        spMonto.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbOperacion, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbTipoCuenta, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 137, Short.MAX_VALUE))
                    .addComponent(txtDescripcion))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(11, 11, 11)
                .addComponent(spMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCuentaActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        long time = System.currentTimeMillis();
        int m = cbOperacion.getSelectedIndex() + 1;
        
        if(txtNombreCuenta.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Fields can not be empty","Alert",JOptionPane.WARNING_MESSAGE);
        }else{
            try{
                if(cbOperacion.getSelectedItem().equals("Cargo")){
                    double value = (double) spMonto.getValue() * (-1);
                    cuenta.setSaldo(BigDecimal.valueOf(value));
                }else{
                    double value = (double) spMonto.getValue();
                    cuenta.setSaldo(BigDecimal.valueOf(value));
                }
                Date fecha = new Date(time);
                cuenta.setNombreCuenta(txtNombreCuenta.getText());
                cuenta.setTipoCuenta((String) cbTipoCuenta.getSelectedItem());
                cuenta.setOperacion((String) cbOperacion.getSelectedItem());
                cuenta.setDescripcion(txtDescripcion.getText());
                cuenta.setFecha(fecha);

                int idUsuario = Cuenta.obtnerIdUsuario(user.getUsername());
                if(Cuenta.agregarCuentasUsuario(idUsuario, cuenta, m)){
                    JOptionPane.showMessageDialog(this,"Se ha agregado correctamente","Exitoso",JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                    window.setVisible(true);
                }else
                    JOptionPane.showMessageDialog(this,"Hubo un problema al agregar cuenta","Error",JOptionPane.ERROR_MESSAGE);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }        
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(false);
        window.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOperacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbOperacionActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cbOperacion;
    private javax.swing.JComboBox<String> cbTipoCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner spMonto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombreCuenta;
    // End of variables declaration//GEN-END:variables
}
