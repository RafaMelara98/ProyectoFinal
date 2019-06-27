/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import ENTIDADES.Usuario;
import DATABASE.User;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author Van
 */
public class CategoriasIngreso extends javax.swing.JFrame {

    
    JFrame window;
    private Usuario user;
    /**
     * Creates new form Categorias
     */
    public CategoriasIngreso(JFrame window, Usuario user) {
        initComponents();
        this.window = window;
        this.user = user;
    }
    
    
    public String[] infos(String infos){
        String[] dato = new String[3];
        if(infos.equals("Apoyos de gobierno")){
            dato[0] = "Agua";
            dato[1] = "Energía";
            dato[2] = "Seguridad";
        }
        if(infos.equals("Arrendamientos")){
            dato[0] = "Carro";
            dato[1] = "Computadora";
            dato[2] = "Casa";
        }
        if(infos.equals("Becas")){
            dato[0] = "Post-Grado";
            dato[1] = "Pre-Grado";
            dato[2] = "Maestría";
        }
        if(infos.equals("Pensión")){
            dato[0] = "Casa San Benito";
            dato[1] = "Hostal Café San Andres";
            dato[2] = "Hostal Doña Marta";
        }
        if(infos.equals("Préstamos")){
            dato[0] = "Banco BAC Credomatic";
            dato[1] = "Banco Cuscatlán";
            dato[2] = "Banco Davivienda";
        }
        if(infos.equals("Sueldo")){
            dato[0] = "Bonos";
            dato[1] = "Aguinaldo";
            dato[2] = "Salario";
        }
        return dato;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCategoria = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcomboCategorias = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcomboSubCategorias = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        btnSelect2 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CATEGORIAS INGRESO");

        jcomboCategorias.setMaximumRowCount(7);
        jcomboCategorias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Apoyos de gobierno", "Arrendamientos", "Becas", "Pensión", "Préstamos", "Sueldo" }));
        jcomboCategorias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcomboCategoriasItemStateChanged(evt);
            }
        });
        jcomboCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboCategoriasActionPerformed(evt);
            }
        });

        jLabel2.setText("Categoria:");

        jLabel3.setText("Subcategoría:");

        jcomboSubCategorias.setMaximumRowCount(3);
        jcomboSubCategorias.setToolTipText("");
        jcomboSubCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboSubCategoriasActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        btnSelect2.setText("Seleccionar");
        btnSelect2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelect2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCategoriaLayout = new javax.swing.GroupLayout(jPanelCategoria);
        jPanelCategoria.setLayout(jPanelCategoriaLayout);
        jPanelCategoriaLayout.setHorizontalGroup(
            jPanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCategoriaLayout.createSequentialGroup()
                .addGroup(jPanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCategoriaLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCategoriaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcomboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelCategoriaLayout.createSequentialGroup()
                                .addComponent(jcomboSubCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSelect2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelCategoriaLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanelCategoriaLayout.setVerticalGroup(
            jPanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCategoriaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCategoriaLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcomboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addComponent(jLabel3))
                    .addGroup(jPanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcomboSubCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSelect2)))
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcomboCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboCategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcomboCategoriasActionPerformed

    private void jcomboSubCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboSubCategoriasActionPerformed
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_jcomboSubCategoriasActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void btnSelect2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelect2ActionPerformed
        // TODO add your handling code here:
        

            if(jcomboSubCategorias.getSelectedItem().equals("Agua")){
            jTextField2.setText("Agua");}
            else if(jcomboSubCategorias.getSelectedItem().equals("Energía"))
            jTextField2.setText("Energía");
            else if(jcomboSubCategorias.getSelectedItem().equals("Seguridad"))
            jTextField2.setText("Seguridad");
       
            if(jcomboSubCategorias.getSelectedItem().equals("Carro")){
            jTextField2.setText("Carro");}
            else if(jcomboSubCategorias.getSelectedItem().equals("Computadora"))
            jTextField2.setText("Computadora");
            else if(jcomboSubCategorias.getSelectedItem().equals("Casa"))
            jTextField2.setText("Casa");
           
            if(jcomboSubCategorias.getSelectedItem().equals("Post-Grado")){
            jTextField2.setText("Post-Grado");}
            else if(jcomboSubCategorias.getSelectedItem().equals("Pre-Grado"))
            jTextField2.setText("Pre-Grado");
            else if(jcomboSubCategorias.getSelectedItem().equals("Maestría"))
            jTextField2.setText("Maestría");
  
            if(jcomboSubCategorias.getSelectedItem().equals("Casa San Benito")){
            jTextField2.setText("Casa San Benito");}
            else if(jcomboSubCategorias.getSelectedItem().equals("Hostal Café San Andres"))
            jTextField2.setText("Hostal Café San Andres");
            else if(jcomboSubCategorias.getSelectedItem().equals("Hostal Doña Marta"))
            jTextField2.setText("Hostal Doña Marta");
            
            if(jcomboSubCategorias.getSelectedItem().equals("Banco BAC Credomatic")){
            jTextField2.setText("Banco BAC Credomatic");}
            else if(jcomboSubCategorias.getSelectedItem().equals("Banco Cuscatlán"))
            jTextField2.setText("Banco Cuscatlán");
            else if(jcomboSubCategorias.getSelectedItem().equals("Banco Davivienda"))
            jTextField2.setText("Banco Davivienda");
            
            if(jcomboSubCategorias.getSelectedItem().equals("Bonos")){
            jTextField2.setText("Bonos");}
            else if(jcomboSubCategorias.getSelectedItem().equals("Aguinaldo"))
            jTextField2.setText("Aguinaldo");
            else if(jcomboSubCategorias.getSelectedItem().equals("Salario"))
            jTextField2.setText("Salario");
         
        
       String subcategoria = jcomboSubCategorias.getSelectedItem().toString();
       String categoria = jcomboCategorias.getSelectedItem().toString();
       Ingresos ingresos = new Ingresos(user);
       ingresos.setVisible(true);
       
       Ingresos.txtCategoria.setText(categoria + "-" + subcategoria);
       dispose();
    }//GEN-LAST:event_btnSelect2ActionPerformed

    private void jcomboCategoriasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcomboCategoriasItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(this.jcomboCategorias.getSelectedIndex()>=0){
                this.jcomboSubCategorias.setModel(new DefaultComboBoxModel(infos(this.jcomboCategorias.getSelectedItem().toString())));
            }
        }
      
    }//GEN-LAST:event_jcomboCategoriasItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnSelect2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelCategoria;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JComboBox jcomboCategorias;
    private javax.swing.JComboBox<String> jcomboSubCategorias;
    // End of variables declaration//GEN-END:variables


}
