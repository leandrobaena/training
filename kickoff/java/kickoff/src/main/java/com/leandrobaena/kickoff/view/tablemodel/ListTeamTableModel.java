package com.leandrobaena.kickoff.view.tablemodel;

import com.leandrobaena.kickoff.entities.Team;
import com.leandrobaena.kickoff.logic.TeamMgr;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 * Modelo de la table de equipos
 *
 * @author Leandro Baena Torres
 */
public class ListTeamTableModel extends DefaultTableModel {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un modelo de tabla para el listado de equipos
     *
     * @throws IOException Si no puede leer el archivo de propiedades
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    private ListTeamTableModel() throws FileNotFoundException, IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("settings_db.properties"));
        teamMgr = new TeamMgr(properties);
        update();
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae la única instancia de esta clase
     *
     * @return Única instancia de esta clase
     */
    public static ListTeamTableModel getInstance() {
        if (instance == null) {
            try {
                instance = new ListTeamTableModel();
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
     * @return Equipo seleccionado
     */
    public Team getSelectedTeam(int row) {
        return teams.get(row);
    }

    /**
     * Inserta un equipo
     *
     * @param team Equipo a insertar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void insertTeam(Team team) throws SQLException {
        teamMgr.insert(team);
        update();
    }

    /**
     * Actualiza un equipo
     *
     * @param team Equipo a actualizar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void updateTeam(Team team) throws SQLException {
        teamMgr.update(team);
        update();
    }

    /**
     * Elimina un equipo en una ubicación determinada
     *
     * @param index Ubicación del equipo a eliminar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void deleteTeam(int index) throws SQLException {
        teamMgr.delete(teams.get(index));
        update();
    }

    /**
     * Actualiza el listado de equipos
     *
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    private void update() throws SQLException {
        this.teams = teamMgr.list();
        this.fireTableDataChanged();
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Listado de equipos
     */
    private ArrayList<Team> teams;

    /**
     * Única instancia del modelo de la tabla de equipos
     */
    private static ListTeamTableModel instance = null;

    /**
     * Administrador de los equipos
     */
    private final TeamMgr teamMgr;
    //</editor-fold>
}
