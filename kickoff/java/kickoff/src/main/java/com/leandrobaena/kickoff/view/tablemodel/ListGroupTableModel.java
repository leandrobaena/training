package com.leandrobaena.kickoff.view.tablemodel;

import com.leandrobaena.kickoff.entities.Group;
import java.util.ArrayList;
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
     */
    private ListGroupTableModel() {
        this.groups = new ArrayList<>();
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae la única instancia de esta clase
     *
     * @return Única instancia de esta clase
     */
    public static ListGroupTableModel getInstance() {
        if (instance == null) {
            instance = new ListGroupTableModel();
        }
        return instance;
    }

    /**
     * Actualiza el listado de grupos
     *
     * @param groups Nuevo listado de grupos
     */
    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
        this.fireTableDataChanged();
    }

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
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Listado de grupos
     */
    private ArrayList<Group> groups;

    /**
     * Única instancia del modelo de la tabla de grupos
     */
    private static ListGroupTableModel instance = null;
    //</editor-fold>
}
