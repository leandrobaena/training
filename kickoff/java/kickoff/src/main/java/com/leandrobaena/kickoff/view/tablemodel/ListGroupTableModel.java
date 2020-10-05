package com.leandrobaena.kickoff.view.tablemodel;

import com.leandrobaena.kickoff.entities.Group;
import com.leandrobaena.kickoff.entities.Tournament;
import com.leandrobaena.kickoff.logic.GroupMgr;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Modelo de la table de grupos
 *
 * @author Leandro Baena Torres
 */
public class ListGroupTableModel extends DefaultTableModel {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un modelo de tabla para el listado de grupos
     *
     * @param tournament Torneo al que pertenecen los grupos
     */
    public ListGroupTableModel(Tournament tournament) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("settings_db.properties"));
            groupMgr = new GroupMgr(properties);
            this.tournament = tournament;
            update();
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al conectar a la base de datos");
        }
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el número de filas de la tabla
     *
     * @return Número de filas de la tabla
     */
    @Override
    public int getRowCount() {
        return groups != null ? groups.size() : 0;
    }

    /**
     * Trae el número de columnas de la tabla
     *
     * @return Número de columnas de la tabla
     */
    @Override
    public int getColumnCount() {
        return 2;
    }

    /**
     * Trae el encabezado de cada columna
     *
     * @param i Índice de la columna
     * @return Encabezado de cada columna
     */
    @Override
    public String getColumnName(int i) {
        return switch (i) {
            case 0 ->
                "ID";
            case 1 ->
                "Nombre";
            default ->
                "";
        };
    }

    /**
     * Trae el valor de una celda
     *
     * @param row Fila
     * @param col Columna
     * @return Valor de una celda
     */
    @Override
    public Object getValueAt(int row, int col) {
        return switch (col) {
            case 0 ->
                groups.get(row).getIdGroup();
            case 1 ->
                groups.get(row).getName();
            default ->
                "";
        };
    }

    /**
     * Trae el grupo seleccionado
     *
     * @param row Fila seleccionada
     * @return Grupo seleccionado
     */
    public Group getSelectedGroup(int row) {
        return groups.get(row);
    }

    /**
     * Inserta un grupo
     *
     * @param group Grupo a insertar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void insertGroup(Group group) throws SQLException {
        groupMgr.insert(group);
        update();
    }

    /**
     * Actualiza un grupo
     *
     * @param group Grupo a actualizar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void updateGroup(Group group) throws SQLException {
        groupMgr.update(group);
        update();
    }

    /**
     * Elimina un grupo en una ubicación determinada
     *
     * @param index Ubicación del grupo a eliminar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void deleteGroup(int index) throws SQLException {
        groupMgr.delete(groups.get(index));
        update();
    }

    /**
     * Actualiza el listado de grupos
     *
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    private void update() throws SQLException {
        this.groups = groupMgr.list(tournament);
        this.fireTableDataChanged();
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Listado de grupos
     */
    private ArrayList<Group> groups;

    /**
     * Administrador de grupos de un grupo
     */
    private GroupMgr groupMgr;

    /**
     * Torneo al que pertenecen los grupos
     */
    private Tournament tournament;
    //</editor-fold>
}
