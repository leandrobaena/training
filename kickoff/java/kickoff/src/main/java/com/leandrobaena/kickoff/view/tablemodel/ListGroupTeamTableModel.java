package com.leandrobaena.kickoff.view.tablemodel;

import com.leandrobaena.kickoff.entities.Team;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Modelo de la tabla de equipos en un grupo de un torneo
 *
 * @author Leandro Baena Torres
 */
public class ListGroupTeamTableModel extends DefaultTableModel {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un modelo de tabla para el listado de equipos en un grupo
     */
    private ListGroupTeamTableModel() {
        this.teams = new ArrayList<>();
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae la única instancia de esta clase
     *
     * @return Única instancia de esta clase
     */
    public static ListGroupTeamTableModel getInstance() {
        if (instance == null) {
            instance = new ListGroupTeamTableModel();
        }
        return instance;
    }

    /**
     * Actualiza el listado de equipos
     *
     * @param teams Nuevo listado de equipos
     */
    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
        this.fireTableDataChanged();
    }

    /**
     * Trae el número de filas de la tabla
     *
     * @return Número de filas de la tabla
     */
    @Override
    public int getRowCount() {
        return teams != null ? teams.size() : 0;
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
                teams.get(row).getIdTeam();
            case 1 ->
                teams.get(row).getName();
            default ->
                "";
        };
    }

    /**
     * Trae el equipo seleccionado
     *
     * @param row Fila seleccionada
     * @return Grupo seleccionado
     */
    public Team getSelectedTeam(int row) {
        return teams.get(row);
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Listado de posiciones
     */
    private ArrayList<Team> teams;

    /**
     * Única instancia del modelo de la tabla de posiciones
     */
    private static ListGroupTeamTableModel instance = null;
    //</editor-fold>
}
