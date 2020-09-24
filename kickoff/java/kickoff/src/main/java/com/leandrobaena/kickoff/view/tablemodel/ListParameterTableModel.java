package com.leandrobaena.kickoff.view.tablemodel;

import com.leandrobaena.kickoff.entities.Parameter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Modelo de la table de parámetros
 *
 * @author Leandro Baena Torres
 */
public class ListParameterTableModel extends DefaultTableModel {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un modelo de tabla para el listado de parámetros
     */
    private ListParameterTableModel() {
        this.parameters = new ArrayList<>();
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae la única instancia de esta clase
     *
     * @return Única instancia de esta clase
     */
    public static ListParameterTableModel getInstance() {
        if (instance == null) {
            instance = new ListParameterTableModel();
        }
        return instance;
    }

    /**
     * Actualiza el listado de parámetros
     *
     * @param parameters Nuevo listado de parámetros
     */
    public void setTeams(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
        this.fireTableDataChanged();
    }

    /**
     * Trae el número de filas de la tabla
     *
     * @return Número de filas de la tabla
     */
    @Override
    public int getRowCount() {
        return parameters != null ? parameters.size() : 0;
    }

    /**
     * Trae el número de columnas de la tabla
     *
     * @return Número de columnas de la tabla
     */
    @Override
    public int getColumnCount() {
        return 3;
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
            case 2 ->
                "Valor";
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
                parameters.get(row).getIdParameter();
            case 1 ->
                parameters.get(row).getName();
            case 2 ->
                parameters.get(row).getValue();
            default ->
                "";
        };
    }

    /**
     * Trae el parámetro seleccionado
     *
     * @param row Fila seleccionada
     * @return Parámetro seleccionado
     */
    public Parameter getSelectedParameter(int row) {
        return parameters.get(row);
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Listado de parámetros
     */
    private ArrayList<Parameter> parameters;

    /**
     * Única instancia del modelo de la tabla de parámetros
     */
    private static ListParameterTableModel instance = null;
    //</editor-fold>
}
