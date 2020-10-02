package com.leandrobaena.kickoff.view.tablemodel;

import com.leandrobaena.kickoff.entities.Tournament;
import com.leandrobaena.kickoff.logic.TournamentMgr;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
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
    private ListTournamentTableModel() throws FileNotFoundException, IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("settings_db.properties"));
        tournamentMgr = new TournamentMgr(properties);
        update();
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
            try {
                instance = new ListTournamentTableModel();
            } catch (IOException | SQLException ex) {
                return null;
            }
        }
        return instance;
    }

    /**
     * Trae el número de filas de la tabla
     *
     * @return Número de filas de la tabla
     */
    @Override
    public int getRowCount() {
        return tournaments != null ? tournaments.size() : 0;
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
                tournaments.get(row).getIdTournament();
            case 1 ->
                tournaments.get(row).getName();
            default ->
                "";
        };
    }

    /**
     * Trae el torneo seleccionado
     *
     * @param row Fila seleccionada
     * @return Torneo seleccionado
     */
    public Tournament getSelectedTournament(int row) {
        return tournaments.get(row);
    }

    /**
     * Inserta un torneo
     *
     * @param tournament Torneo a insertar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void insertTournament(Tournament tournament) throws SQLException {
        tournamentMgr.insert(tournament);
        update();
    }

    /**
     * Actualiza un torneo
     *
     * @param tournament Torneo a actualizar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void updateTournament(Tournament tournament) throws SQLException {
        tournamentMgr.update(tournament);
        update();
    }

    /**
     * Elimina un torneo en una ubicación determinada
     *
     * @param index Ubicación del torneo a eliminar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void deleteTournament(int index) throws SQLException {
        tournamentMgr.delete(tournaments.get(index));
        update();
    }

    /**
     * Actualiza el listado de torneos
     *
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    private void update() throws SQLException {
        this.tournaments = tournamentMgr.list();
        this.fireTableDataChanged();
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Listado de torneos
     */
    private ArrayList<Tournament> tournaments;

    /**
     * Única instancia del modelo de la tabla de equipos
     */
    private static ListTournamentTableModel instance = null;

    /**
     * Administrador de los torneos
     */
    private final TournamentMgr tournamentMgr;
    //</editor-fold>
}
