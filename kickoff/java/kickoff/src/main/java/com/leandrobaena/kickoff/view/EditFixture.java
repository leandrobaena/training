package com.leandrobaena.kickoff.view;

import com.leandrobaena.kickoff.entities.Fixture;
import com.leandrobaena.kickoff.entities.Group;
import com.leandrobaena.kickoff.logic.FixtureMgr;
import com.leandrobaena.kickoff.view.tablemodel.ListFixtureTableModel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Formulario de edición de una fecha de juego en un grupo de un torneo
 *
 * @author Leandro Baena Torres
 */
public class EditFixture extends javax.swing.JDialog {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un nuevo formulario de edición de una fecha
     *
     * @param fixture Fecha que va a editar o insertar
     * @param group Grupo al que pertenece la fecha
     * @param owner Ventana principal de la aplicación de la cual este
     * formulario es modal
     */
    public EditFixture(Fixture fixture, Group group, JFrame owner) {
        super(owner, true);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        initComponents();
        this.fixture = fixture;
        this.fixture.setGroup(group);
        this.txtIdentification.setText("" + this.fixture.getIdFixture());
        this.txtName.setText(this.fixture.getName());
        this.txtDate.setText(sdf.format(this.fixture.getDate()));
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
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JFormattedTextField();
        lblHome = new javax.swing.JLabel();
        cmbHome = new javax.swing.JComboBox<>();
        lblAway = new javax.swing.JLabel();
        cmbAway = new javax.swing.JComboBox<>();
        lblStadium = new javax.swing.JLabel();
        cmbStadium = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar parámetro");
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

        lblDate.setText("Fecha:");

        txtDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("y-MM-dd HH:mm:ss"))));

        lblHome.setText("Local:");

        cmbHome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblAway.setText("Visitante:");

        cmbAway.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblStadium.setText("Estadio:");

        cmbStadium.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdentification)
                            .addComponent(lblDate)
                            .addComponent(lblName)
                            .addComponent(lblHome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbHome, 0, 214, Short.MAX_VALUE)
                            .addComponent(txtDate)
                            .addComponent(txtName)
                            .addComponent(txtIdentification))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStadium)
                            .addComponent(lblAway))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbAway, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbStadium, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(btnOk)
                .addGap(55, 55, 55)
                .addComponent(btnCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdentification)
                    .addComponent(txtIdentification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAway, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAway))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbStadium, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStadium))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
     * Inserta o actualiza un jugador
     *
     * @param evt Evento de clic sobre el botón
     */
    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.fixture.setName(this.txtName.getText());
            this.fixture.setDate(sdf.parse(this.txtDate.getText()));
            Properties properties = new Properties();
            properties.load(new FileInputStream("settings_db.properties"));
            FixtureMgr fixtureMgr = new FixtureMgr(properties);
            if (this.fixture.getIdFixture() == 0) {
                fixtureMgr.insert(this.fixture);
                JOptionPane.showMessageDialog(null, "Fecha insertada con éxito");
            } else {
                fixtureMgr.update(this.fixture);
                JOptionPane.showMessageDialog(null, "Fecha actualizada con éxito");
            }
            ListFixtureTableModel model = ListFixtureTableModel.getInstance();
            model.setFixtures(fixtureMgr.list(this.fixture.getGroup()));
            this.dispose();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo encontrar el archivo de configuración de la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo leer el archivo de configuración de la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Hubo un error al conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Hubo un error al leer la fecha del encuentro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnOkActionPerformed
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JComboBox<String> cmbAway;
    private javax.swing.JComboBox<String> cmbHome;
    private javax.swing.JComboBox<String> cmbStadium;
    private javax.swing.JLabel lblAway;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblIdentification;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblStadium;
    private javax.swing.JFormattedTextField txtDate;
    private javax.swing.JTextField txtIdentification;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
    private final Fixture fixture;
    //</editor-fold>
}
