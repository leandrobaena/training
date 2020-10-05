package com.leandrobaena.kickoff.view;

import com.leandrobaena.kickoff.entities.Tournament;
import com.leandrobaena.kickoff.view.tablemodel.ListTournamentTableModel;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Formulario de edición de un torneo
 *
 * @author Leandro Baena Torres
 */
public class EditTournament extends javax.swing.JDialog {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un nuevo formulario de edición de un equipo
     *
     * @param tournament Equipo que va a editar o insertar
     * @param model Modelo de la tabla de torneos
     * @param owner Ventana principal de la aplicación de la cual este
     * formulario es modal
     */
    public EditTournament(Tournament tournament, ListTournamentTableModel model, JFrame owner) {
        super(owner, true);
        initComponents();
        this.model = model;
        this.tournament = tournament;
        this.txtIdentification.setText("" + this.tournament.getIdTournament());
        this.txtName.setText(this.tournament.getName());
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIdentification = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtIdentification = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar torneo");
        setResizable(false);

        lblIdentification.setText("Identificador:");

        lblName.setText("Nombre:");

        txtIdentification.setEditable(false);

        btnOk.setText("Aceptar");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdentification)
                            .addComponent(lblName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(txtIdentification)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnOk)
                        .addGap(55, 55, 55)
                        .addComponent(btnCancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdentification)
                    .addComponent(txtIdentification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cierra el formulario
     *
     * @param evt Evento de clic sobre el botón
     */
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * Inserta o actualiza un torneo
     *
     * @param evt Evento de clic sobre el botón Aceptar
     */
    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        this.tournament.setName(this.txtName.getText());
        try {
            if (this.tournament.getIdTournament() == 0) {
                model.insertTournament(this.tournament);
                JOptionPane.showMessageDialog(null, "Torneo insertado con éxito");
            } else {
                model.updateTournament(this.tournament);
                JOptionPane.showMessageDialog(null, "Torneo actualizado con éxito");
            }
            this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Hubo un error al conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnOkActionPerformed
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel lblIdentification;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextField txtIdentification;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
    private final Tournament tournament;
    ListTournamentTableModel model;
    //</editor-fold>
}
