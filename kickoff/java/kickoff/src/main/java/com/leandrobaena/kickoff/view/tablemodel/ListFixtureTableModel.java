package com.leandrobaena.kickoff.view.tablemodel;

import com.leandrobaena.kickoff.entities.Fixture;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Modelo de la tabla de fechas de juego entre equipos de un grupo de un torneo
 *
 * @author Leandro Baena Torres
 */
public class ListFixtureTableModel extends DefaultTableModel {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un modelo de tabla para el listado de fechas de juegos de equipos de
     * un grupo
     */
    private ListFixtureTableModel() {
        this.fixtures = new ArrayList<>();
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae la única instancia de esta clase
     *
     * @return Única instancia de esta clase
     */
    public static ListFixtureTableModel getInstance() {
        if (instance == null) {
            instance = new ListFixtureTableModel();
        }
        return instance;
    }

    /**
     * Actualiza el listado de fechas
     *
     * @param fixtures Nuevo listado de fechas
     */
    public void setFixtures(ArrayList<Fixture> fixtures) {
        this.fixtures = fixtures;
        this.fireTableDataChanged();
    }

    /**
     * Trae el número de filas de la tabla
     *
     * @return Número de filas de la tabla
     */
    @Override
    public int getRowCount() {
        return fixtures != null ? fixtures.size() : 0;
    }

    /**
     * Trae el número de columnas de la tabla
     *
     * @return Número de columnas de la tabla
     */
    @Override
    public int getColumnCount() {
        return 6;
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
                "Local";
            case 3 ->
                "Visitante";
            case 4 ->
                "Fecha";
            case 5 ->
                "Estadio";
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return switch (col) {
            case 0 ->
                fixtures.get(row).getIdFixture();
            case 1 ->
                fixtures.get(row).getName();
            case 2 ->
                fixtures.get(row).getHome().getName();
            case 3 ->
                fixtures.get(row).getAway().getName();
            case 4 ->
                sdf.format(fixtures.get(row).getDate());
            case 5 ->
                fixtures.get(row).getStadium().getName();
            default ->
                "";
        };
    }

    /**
     * Trae la fecha seleccionado
     *
     * @param row Fila seleccionada
     * @return Grupo seleccionado
     */
    public Fixture getSelectedFixture(int row) {
        return fixtures.get(row);
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Listado de fechas de un grupo
     */
    private ArrayList<Fixture> fixtures;

    /**
     * Única instancia del modelo de la tabla de fechas
     */
    private static ListFixtureTableModel instance = null;
    //</editor-fold>
}
