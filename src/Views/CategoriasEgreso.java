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
public class CategoriasEgreso extends javax.swing.JFrame {

    
    JFrame window;
    /**
     * Creates new form Categorias
     */
    public CategoriasEgreso(JFrame window) {
        initComponents();
        this.window = window;
    }
    
    
    public String[] infos(String infos){
        String[] dato = new String[3];
        if(infos.equals("Ahorro")){
            dato[0] = "Casa";
            dato[1] = "Comida";
            dato[2] = "Vestimenta";
        }
        if(infos.equals("Educación")){
            dato[0] = "Colegiatura";
            dato[1] = "Uniforme";
            dato[2] = "Útiles Escolares";
        }
        if(infos.equals("Electrodomésticos")){
            dato[0] = "Laptop";
            dato[1] = "Refrigeradora";
            dato[2] = "Microondas";
        }
        if(infos.equals("Entretenimiento")){
            dato[0] = "Peliculas";
            dato[1] = "Videojuegos";
            dato[2] = "Televisión";
        }
        if(infos.equals("Mascotas")){
            dato[0] = "Alimento";
            dato[1] = "Medicamentos";
            dato[2] = "Veterinaria";
        }
        if(infos.equals("Servicios Hogar")){
            dato[0] = "Internet";
            dato[1] = "Cable TV";
            dato[2] = "Teléfono";
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

        jLabel1.setText("CATEGORIAS EGRESO");

        jcomboCategorias.setMaximumRowCount(7);
        jcomboCategorias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Ahorro", "Educación", "Electrodomésticos", "Entretenimiento", "Mascotas", "Servicios Hogar", " " }));
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
        

            if(jcomboSubCategorias.getSelectedItem().equals("Casa")){
            jTextField2.setText("Casa");}
            else if(jcomboSubCategorias.getSelectedItem().equals("Comida"))
            jTextField2.setText("Comida");
            else if(jcomboSubCategorias.getSelectedItem().equals("Vestimenta"))
            jTextField2.setText("Vestimenta");
      
            if(jcomboSubCategorias.getSelectedItem().equals("Colegiatura")){
            jTextField2.setText("Colegiatura");}
            else if(jcomboSubCategorias.getSelectedItem().equals("Uniforme"))
            jTextField2.setText("Uniforme");
            else if(jcomboSubCategorias.getSelectedItem().equals("Útiles Escolares"))
            jTextField2.setText("Útiles Escolares");
     
            if(jcomboSubCategorias.getSelectedItem().equals("Laptop")){
            jTextField2.setText("Laptop");}
            else if(jcomboSubCategorias.getSelectedItem().equals("Refrigeradora"))
            jTextField2.setText("Refrigeradora");
            else if(jcomboSubCategorias.getSelectedItem().equals("Microondas"))
            jTextField2.setText("Microondas");
    
            if(jcomboSubCategorias.getSelectedItem().equals("Peliculas")){
            jTextField2.setText("Peliculas");}
            else if(jcomboSubCategorias.getSelectedItem().equals("Videojuegos"))
            jTextField2.setText("Videojuegos");
            else if(jcomboSubCategorias.getSelectedItem().equals("Televisión"))
            jTextField2.setText("Televisión");
            
            if(jcomboSubCategorias.getSelectedItem().equals("Alimento")){
            jTextField2.setText("Alimento");}
            else if(jcomboSubCategorias.getSelectedItem().equals("Medicamentos"))
            jTextField2.setText("Medicamentos");
            else if(jcomboSubCategorias.getSelectedItem().equals("Veterinaria"))
            jTextField2.setText("Veterinaria");
      
            if(jcomboSubCategorias.getSelectedItem().equals("Internet")){
            jTextField2.setText("Internet");}
            else if(jcomboSubCategorias.getSelectedItem().equals("Cable TV"))
            jTextField2.setText("Cable TV");
            else if(jcomboSubCategorias.getSelectedItem().equals("Teléfono"))
            jTextField2.setText("Teléfono");
        
       String subcategoria = jcomboSubCategorias.getSelectedItem().toString();
       String categoria = jcomboCategorias.getSelectedItem().toString();
       Egresos egresos = new Egresos();
       egresos.setVisible(true);
       
       Egresos.txtCategoria.setText(categoria + "-" + subcategoria);
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
