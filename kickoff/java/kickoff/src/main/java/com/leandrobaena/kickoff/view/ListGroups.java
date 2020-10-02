package com.leandrobaena.kickoff.view;

import com.leandrobaena.kickoff.entities.Group;
import com.leandrobaena.kickoff.entities.Tournament;
import com.leandrobaena.kickoff.view.tablemodel.ListGroupTableModel;
import java.awt.Container;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Listado de grupos de un torneo
 *
 * @author Leandro Baena Torres
 */
public class ListGroups extends javax.swing.JPanel implements ListSelectionListener {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Inicializa los componentes del listado de grupos
     *
     * @param tournament Torneo al que pertenecen los grupos
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     */
    public ListGroups(Tournament tournament) throws FileNotFoundException, IOException, SQLException {
        this.tournament = tournament;
        initComponents();
        tblGroups.getSelectionModel().addListSelectionListener(this);
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
        tblGroups = new javax.swing.JTable();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnTeams = new javax.swing.JButton();
        btnFixtures = new javax.swing.JButton();

        tblGroups.setModel(ListGroupTableModel.getInstance(this.tournament));
        tblGroups.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblGroups);

        btnInsert.setText("Insertar");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Editar");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
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

        btnTeams.setText("Equipos");
        btnTeams.setEnabled(false);
        btnTeams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeamsActionPerformed(evt);
            }
        });

        btnFixtures.setText("Fechas");
        btnFixtures.setEnabled(false);
        btnFixtures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFixturesActionPerformed(evt);
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
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTeams)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFixtures)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClose)
                    .addComponent(btnTeams)
                    .addComponent(btnFixtures))
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
        EditGroup editGroup = new EditGroup(new Group(), this.tournament, getJFrame());
        editGroup.setVisible(true);
    }//GEN-LAST:event_btnInsertActionPerformed

    /**
     * Muestra el formulario de edición de un grupo
     *
     * @param evt Evento al hacer clic en el botón Editar
     */
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Group selected = ((ListGroupTableModel) tblGroups.getModel()).getSelectedGroup(tblGroups.getSelectedRow());
        if (selected != null) {
            EditGroup editGroup = new EditGroup(selected, this.tournament, getJFrame());
            editGroup.setVisible(true);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    /**
     * Elimina un grupo
     *
     * @param evt Evento al hacer clic en el botón Eliminar
     */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el grupo?", "Borrar grupo", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                ((ListGroupTableModel) tblGroups.getModel()).deleteGroup(tblGroups.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Grupo eliminado con éxito");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el grupo");
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

    private void btnTeamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeamsActionPerformed
        Group selected = ((ListGroupTableModel) tblGroups.getModel()).getSelectedGroup(tblGroups.getSelectedRow());
        if (selected != null) {
            int index = getTabbedPane().indexOfTab("Listado de equipos del grupo " + selected.getName());
            if (index == -1) {
                ListGroupTeams listGroupTeams;
                try {
                    listGroupTeams = new ListGroupTeams(selected);
                    getTabbedPane().add("Listado de equipos del grupo " + selected.getName(), listGroupTeams);
                    getTabbedPane().setSelectedComponent(listGroupTeams);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "No se pudo encontrar el archivo de configuración de la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "No se pudo leer el archivo de configuración de la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Hubo un error al conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                getTabbedPane().setSelectedIndex(index);
            }
        }
    }//GEN-LAST:event_btnTeamsActionPerformed

    private void btnFixturesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFixturesActionPerformed
        Group selected = ((ListGroupTableModel) tblGroups.getModel()).getSelectedGroup(tblGroups.getSelectedRow());
        if (selected != null) {
            int index = getTabbedPane().indexOfTab("Listado de fechas del grupo " + selected.getName());
            if (index == -1) {
                ListFixtures listFixtures;
                try {
                    listFixtures = new ListFixtures(selected);
                    getTabbedPane().add("Listado de grupos del torneo " + selected.getName(), listFixtures);
                    getTabbedPane().setSelectedComponent(listFixtures);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "No se pudo encontrar el archivo de configuración de la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "No se pudo leer el archivo de configuración de la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Hubo un error al conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this, "Hubo un error al leer una fecha", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                getTabbedPane().setSelectedIndex(index);
            }
        }
    }//GEN-LAST:event_btnFixturesActionPerformed

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
        if (tblGroups.getSelectedRow() != -1) {
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            btnTeams.setEnabled(true);
            btnFixtures.setEnabled(true);
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
    private javax.swing.JButton btnFixtures;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnTeams;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblGroups;
    // End of variables declaration//GEN-END:variables
    private final Tournament tournament;
    //</editor-fold>
}
