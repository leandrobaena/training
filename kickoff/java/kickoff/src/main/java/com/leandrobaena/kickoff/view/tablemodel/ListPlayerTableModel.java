package com.leandrobaena.kickoff.view.tablemodel;

import com.leandrobaena.kickoff.entities.Player;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Modelo de la table de jugadores
 *
 * @author Leandro Baena Torres
 */
public class ListPlayerTableModel extends DefaultTableModel {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un modelo de tabla para el listado de jugadores
     */
    private ListPlayerTableModel() {
        this.players = new ArrayList<>();
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae la única instancia de esta clase
     *
     * @return Única instancia de esta clase
     */
    public static ListPlayerTableModel getInstance() {
        if (instance == null) {
            instance = new ListPlayerTableModel();
        }
        return instance;
    }

    /**
     * Actualiza el listado de jugadores
     *
     * @param players Nuevo listado de jugadores
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
        this.fireTableDataChanged();
    }

    /**
     * Trae el número de filas de la tabla
     *
     * @return Número de filas de la tabla
     */
    @Override
    public int getRowCount() {
        return players != null ? players.size() : 0;
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
                "Dorsal";
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
                players.get(row).getIdPlayer();
            case 1 ->
                players.get(row).getName();
            case 2 ->
                players.get(row).getDorsal();
            default ->
                "";
        };
    }

    /**
     * Trae el jugador seleccionado
     *
     * @param row Fila seleccionada
     * @return Grupo seleccionado
     */
    public Player getSelectedGroup(int row) {
        return players.get(row);
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Listado de jugadores
     */
    private ArrayList<Player> players;

    /**
     * Única instancia del modelo de la tabla de jugadores
     */
    private static ListPlayerTableModel instance = null;
    //</editor-fold>
}
