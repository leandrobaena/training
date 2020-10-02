package com.leandrobaena.kickoff.view;

import com.leandrobaena.kickoff.entities.Group;
import com.leandrobaena.kickoff.entities.Team;
import com.leandrobaena.kickoff.logic.GroupMgr;
import com.leandrobaena.kickoff.view.tablemodel.ListGroupTeamTableModel;
import java.awt.Container;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Listado de equipos de un grupo de un torneo
 *
 * @author Leandro Baena Torres
 */
public class ListGroupTeams extends javax.swing.JPanel implements ListSelectionListener {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Inicializa los componentes del listado de equipos del grupo
     *
     * @param group Grupo al que pertenecen los equipos
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     */
    public ListGroupTeams(Group group) throws FileNotFoundException, IOException, SQLException {
        initComponents();
        this.group = group;
        Properties properties = new Properties();
        properties.load(new FileInputStream("settings_db.properties"));
        groupMgr = new GroupMgr(properties);
        ((ListGroupTeamTableModel) tblGroupTeams.getModel()).setTeams(groupMgr.listTeams(this.group));
        tblGroupTeams.getSelectionModel().addListSelectionListener(this);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblGroupTeams = new javax.swing.JTable();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        tblGroupTeams.setModel(ListGroupTeamTableModel.getInstance());
        tblGroupTeams.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblGroupTeams);

        btnInsert.setText("Insertar");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClose.setText("Cerrar");
        btnClose.setToolTipText("");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnInsert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnDelete)
                    .addComponent(btnClose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Muestra el formulario de inserción de un grupo
     *
     * @param evt Evento al hacer clic en el botón Insertar
     */
    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try {
            EditGroupTeam editGroupTeam = new EditGroupTeam(group, getJFrame());
            editGroupTeam.setVisible(true);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo leer el archivo de configuración de la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Hubo un error al conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    /**
     * Elimina un equipo de un grupo
     *
     * @param evt Evento al hacer clic en el botón Eliminar
     */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el equipo del grupo?", "Borrar equipo", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                Team selected = ((ListGroupTeamTableModel) tblGroupTeams.getModel()).getSelectedTeam(tblGroupTeams.getSelectedRow());
                groupMgr.deleteTeam(selected, group);
                ListGroupTeamTableModel model = ListGroupTeamTableModel.getInstance();
                model.setTeams(groupMgr.listTeams(group));
                JOptionPane.showMessageDialog(null, "Equipo eliminado con éxito");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el equipo");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * Cierra la pestaña de grupos
     *
     * @param evt Evento al hacer clic en el botón Actualizar
     */
    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        getTabbedPane().remove(this);
    }//GEN-LAST:event_btnCloseActionPerformed

    /**
     * Dibuja el componente del listado de grupos
     *
     * @param g Área gráfica a pintar
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    /**
     * Trae el formulario principal de la aplicación
     *
     * @return Formulario principal de la aplicación
     */
    private JFrame getJFrame() {
        Container current = this;
        Class c = current.getClass();
        while (!"com.leandrobaena.kickoff.view.Main".equals(c.getName())) {
            current = current.getParent();
            c = current.getClass();
        }
        return (JFrame) current;
    }

    /**
     * Ejecuta una acción al seleccionar un registro de la tabla
     *
     * @param evt Evento al seleccionar un registro de la tabla
     */
    @Override
    public void valueChanged(ListSelectionEvent evt) {
        if (tblGroupTeams.getSelectedRow() != -1) {
            btnDelete.setEnabled(true);
        }
    }

    /**
     * Trae el panel tabulado al que pertenece este panel
     *
     * @return Panel tabulado al que pertenece este panel
     */
    private JTabbedPane getTabbedPane() {
        Container current = this;
        Class c = current.getClass();
        while (!"javax.swing.JTabbedPane".equals(c.getName())) {
            current = current.getParent();
            c = current.getClass();
        }
        return ((JTabbedPane) current);
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblGroupTeams;
    // End of variables declaration//GEN-END:variables
    private final GroupMgr groupMgr;
    private final Group group;
    //</editor-fold>
}
