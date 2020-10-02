package com.leandrobaena.kickoff.view.tablemodel;

import com.leandrobaena.kickoff.entities.Player;
import com.leandrobaena.kickoff.entities.Team;
import com.leandrobaena.kickoff.logic.PlayerMgr;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
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
     *
     * @param team Equipo al que pertenecen los jugadores
     */
    private ListPlayerTableModel(Team team) throws FileNotFoundException, IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("settings_db.properties"));
        playerMgr = new PlayerMgr(properties);
        this.team = team;
        update();
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae la única instancia de esta clase
     *
     * @param team Equipo al que pertenecen los jugadores
     * @return Única instancia de esta clase
     */
    public static ListPlayerTableModel getInstance(Team team) {
        if (instance == null) {
            try {
                instance = new ListPlayerTableModel(team);
            } catch (IOException | SQLException ex) {
                return null;
            }
        } else {
            instance.team = team;
            try {
                instance.update();
            } catch (SQLException ex) {
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

    /**
     * Inserta un jugador
     *
     * @param player Jugador a insertar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void insertPlayer(Player player) throws SQLException {
        playerMgr.insert(player);
        update();
    }

    /**
     * Actualiza un jugador
     *
     * @param player Jugador a actualizar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void updatePlayer(Player player) throws SQLException {
        playerMgr.update(player);
        update();
    }

    /**
     * Elimina un jugador en una ubicación determinada
     *
     * @param index Ubicación del jugador a eliminar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void deletePlayer(int index) throws SQLException {
        playerMgr.delete(players.get(index));
        update();
    }

    /**
     * Actualiza el listado de jugadores
     *
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    private void update() throws SQLException {
        this.players = playerMgr.list(team);
        this.fireTableDataChanged();
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

    /**
     * Administrador del jugador
     */
    private final PlayerMgr playerMgr;

    /**
     * Equipo al que pertenecen los jugadores
     */
    private Team team;
    //</editor-fold>
}
