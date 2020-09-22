package com.leandrobaena.kickoff.view.tablemodel;

import com.leandrobaena.kickoff.entities.Tournament;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Modelo de la table de torneos
 *
 * @author Leandro Baena Torres
 */
public class ListTournamentTableModel extends DefaultTableModel {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un modelo de tabla para el listado de torneos
     */
    private ListTournamentTableModel() {
        this.tournament = new ArrayList<>();
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae la única instancia de esta clase
     *
     * @return Única instancia de esta clase
     */
    public static ListTournamentTableModel getInstance() {
        if (instance == null) {
            instance = new ListTournamentTableModel();
        }
        return instance;
    }

    /**
     * Actualiza el listado de torneos
     *
     * @param tournament Nuevo listado de torneos
     */
    public void setTournaments(ArrayList<Tournament> tournament) {
        this.tournament = tournament;
        this.fireTableDataChanged();
    }

    /**
     * Trae el número de filas de la tabla
     *
     * @return Número de filas de la tabla
     */
    @Override
    public int getRowCount() {
        return tournament != null ? tournament.size() : 0;
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
                tournament.get(row).getIdTournament();
            case 1 ->
                tournament.get(row).getName();
            default ->
                "";
        };
    }

    public Tournament getSelectedTeam(int row) {
        return tournament.get(row);
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Listado de torneos
     */
    private ArrayList<Tournament> tournament;

    /**
     * Única instancia del modelo de la tabla de equipos
     */
    private static ListTournamentTableModel instance = null;
    //</editor-fold>
}
