/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

//Librerias que utilizamos
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel
 */
public class ConversorGenerico extends javax.swing.JFrame {

    //Declaramos Variables:
    //"conversores" es una lista de tipo "Conversor" (Conversor es una Clase)
    private List<Conversor> conversores;
    //selectedConversor es una variable de tipo "Conversor" (Conversor es una Clase)
    private Conversor selectedConversor;

    public ConversorGenerico() {
        initComponents();
        //Titulo de la Aplicacion
        setTitle("Conversor");
        //Centra el Formulario
        setLocationRelativeTo(null);
            
        // Llenar combo de tipos de Conversores
        conversores = new ArrayList<Conversor>();
        //Agregamos las Clases a la lista        
        conversores.add(new CentimetrosPulgadasConversor());
        conversores.add(new MetrosKMConversor());
        conversores.add(new KilometrosMillasConversor());
        conversores.add(new CelciusFahrenheitConversor());
        conversores.add(new SegundosMinutosConversor());
        

        //Iteracion de la lista "conversores", se crea un objeto "conversor" 
        //de tipo "Conversor" (Siempre el elemento que se va a iterar 
        //tiene que ser del mismo tipo que la lista
        for (Conversor conversor : conversores) {
            jComboBoxConversores.addItem(conversor.toString());
        }

        // Valores por Defecto
        selectedConversor = conversores.get(0);
        jLabel1.setText(selectedConversor.getLabelValor1());
        jLabel2.setText(selectedConversor.getLabelValor2());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldValor1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonConvertir = new javax.swing.JButton();
        jTextFieldValor2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxConversores = new javax.swing.JComboBox<>();
        jButtonIntegrantes = new javax.swing.JButton();
        jLabelUnidades = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextFieldValor1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldValor1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldValor1FocusLost(evt);
            }
        });
        jTextFieldValor1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldValor1KeyPressed(evt);
            }
        });

        jLabel1.setText("Valor 1");

        jButtonConvertir.setText("Convertir");
        jButtonConvertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConvertirActionPerformed(evt);
            }
        });

        jTextFieldValor2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldValor2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldValor2FocusLost(evt);
            }
        });

        jLabel2.setText("Valor 2");

        jComboBoxConversores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxConversoresItemStateChanged(evt);
            }
        });

        jButtonIntegrantes.setBackground(new java.awt.Color(51, 153, 255));
        jButtonIntegrantes.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButtonIntegrantes.setForeground(new java.awt.Color(0, 0, 51));
        jButtonIntegrantes.setText("Integrantes");
        jButtonIntegrantes.setFocusable(false);
        jButtonIntegrantes.setMargin(new java.awt.Insets(2, 6, 2, 6));
        jButtonIntegrantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIntegrantesActionPerformed(evt);
            }
        });

        jLabelUnidades.setText("Unidades");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxConversores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonConvertir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelUnidades)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonIntegrantes))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldValor1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldValor2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButtonIntegrantes, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUnidades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxConversores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldValor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldValor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonConvertir)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jButtonIntegrantes.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConvertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConvertirActionPerformed

        //Dependiendo que jTextField haya perdido el foco, se actualiza el valor de
        //"conviertoValor1Valor2" para pasar del valor 1 al 2 o viseversa
        if (jTextFieldValor1.getText().isEmpty() && jTextFieldValor2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un n??mero", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            if (conviertoValor1Valor2) {
                convertirValor1Valor2();
            } else {
                convertirValor2Valor1();
            }
        }
    }//GEN-LAST:event_jButtonConvertirActionPerformed

    private void convertirValor1Valor2() throws HeadlessException {
        Double valor1;

        //Remplaza ',' por '.' en caso de que se haya ingresado mal un numero decimal (ej: 8,5 = > 8.5)
        try {
            valor1 = Double.valueOf(jTextFieldValor1.getText().replace(',', '.'));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Formato no v??lido", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Double valor2 = selectedConversor.convertirValor1Valor2(valor1);
        jTextFieldValor2.setText(String.format("%.2f", valor2));
    }

    private void convertirValor2Valor1() {
        Double valor2;

        //Remplaza ',' por '.' en caso de que se haya ingresado mal un numero decimal (ej: 8,5 = > 8.5)
        try {
            valor2 = Double.valueOf(jTextFieldValor2.getText().replace(',', '.'));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Formato no v??lido", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Double valor1 = selectedConversor.convertirValor2Valor1(valor2);
        jTextFieldValor1.setText(String.format("%.2f", valor1));
    }


    private void jTextFieldValor1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldValor1FocusLost
        conviertoValor1Valor2 = true;
    }//GEN-LAST:event_jTextFieldValor1FocusLost

    private void jTextFieldValor2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldValor2FocusLost
        conviertoValor1Valor2 = false;
    }//GEN-LAST:event_jTextFieldValor2FocusLost

    private void jTextFieldValor1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValor1KeyPressed
        // Se presiono CRLF?
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            convertirValor1Valor2();
        }

        if (evt.getKeyChar() == KeyEvent.VK_COMMA) {
            if ((jTextFieldValor1.getText().contentEquals(",") && evt.getKeyChar() == KeyEvent.VK_COMMA) && (evt.getKeyChar() != KeyEvent.VK_BACK_SPACE)) {
                getToolkit().beep();
                evt.consume();
            }
        }

    }//GEN-LAST:event_jTextFieldValor1KeyPressed

    private void jComboBoxConversoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxConversoresItemStateChanged
        int selectedIndex = jComboBoxConversores.getSelectedIndex();
        jLabel1.setText(conversores.get(selectedIndex).getLabelValor1());
        jLabel2.setText(conversores.get(selectedIndex).getLabelValor2());
        selectedConversor = conversores.get(selectedIndex);
        limpiarControles();
    }//GEN-LAST:event_jComboBoxConversoresItemStateChanged

    private void jTextFieldValor2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldValor2FocusGained
        jTextFieldValor1.setText("");
    }//GEN-LAST:event_jTextFieldValor2FocusGained

    private void jTextFieldValor1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldValor1FocusGained
        jTextFieldValor2.setText("");
    }//GEN-LAST:event_jTextFieldValor1FocusGained

    private void jButtonIntegrantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIntegrantesActionPerformed
        JOptionPane.showMessageDialog(this, ". : GRUPO 4 : .\n\nCAZAL, Fernando\nCERETO, Sebastian\nCORREA, Lucas\nFERRARI, Gerardo\nTORRES, Cristian", "PROGRAMACION AVANZADA 1",
                    JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_jButtonIntegrantesActionPerformed

    private void limpiarControles() {
        jTextFieldValor1.setText("");
        jTextFieldValor2.setText("");
    }

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
            java.util.logging.Logger.getLogger(ConversorGenerico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConversorGenerico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConversorGenerico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConversorGenerico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConversorGenerico().setVisible(true);
            }
        });
    }

    private boolean conviertoValor1Valor2;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConvertir;
    private javax.swing.JButton jButtonIntegrantes;
    private javax.swing.JComboBox<String> jComboBoxConversores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelUnidades;
    private javax.swing.JTextField jTextFieldValor1;
    private javax.swing.JTextField jTextFieldValor2;
    // End of variables declaration//GEN-END:variables

}
