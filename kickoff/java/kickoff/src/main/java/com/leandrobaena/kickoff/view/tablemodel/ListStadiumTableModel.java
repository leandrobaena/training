package com.leandrobaena.kickoff.view.tablemodel;

import com.leandrobaena.kickoff.entities.Stadium;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Modelo de la table de estadios
 *
 * @author Leandro Baena Torres
 */
public class ListStadiumTableModel extends DefaultTableModel {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un modelo de tabla para el listado de estadios
     */
    private ListStadiumTableModel() {
        this.stadiums = new ArrayList<>();
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae la única instancia de esta clase
     *
     * @return Única instancia de esta clase
     */
    public static ListStadiumTableModel getInstance() {
        if (instance == null) {
            instance = new ListStadiumTableModel();
        }
        return instance;
    }

    /**
     * Actualiza el listado de estadios
     *
     * @param stadiums Nuevo listado de estadios
     */
    public void setStadiums(ArrayList<Stadium> stadiums) {
        this.stadiums = stadiums;
        this.fireTableDataChanged();
    }

    /**
     * Trae el número de filas de la tabla
     *
     * @return Número de filas de la tabla
     */
    @Override
    public int getRowCount() {
        return stadiums != null ? stadiums.size() : 0;
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
                stadiums.get(row).getIdStadium();
            case 1 ->
                stadiums.get(row).getName();
            default ->
                "";
        };
    }

    /**
     * Trae el estadio seleccionado
     *
     * @param row Fila seleccionada
     * @return Estadio seleccionado
     */
    public Stadium getSelectedTeam(int row) {
        return stadiums.get(row);
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Listado de estadios
     */
    private ArrayList<Stadium> stadiums;

    /**
     * Única instancia del modelo de la tabla de estadios
     */
    private static ListStadiumTableModel instance = null;
    //</editor-fold>
}
