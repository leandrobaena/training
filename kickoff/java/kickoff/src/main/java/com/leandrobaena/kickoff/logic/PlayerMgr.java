package com.leandrobaena.kickoff.logic;

import com.leandrobaena.kickoff.entities.Player;
import com.leandrobaena.kickoff.database.PlayerDB;
import com.leandrobaena.kickoff.entities.Team;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Maneja los jugadores de un equipo
 *
 * @author Leandro Baena Torres
 */
public class PlayerMgr {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de jugadores
     *
     * @param properties Propiedades de la conexión a la base de datos
     * @throws IOException Si no puede abrir el archivo de propiedades de
     * conexión a la base de datos
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * de conexión a la base de datos
     * @throws SQLException Si hubo un problema en la conexión a la base de
     * datos
     */
    public PlayerMgr(Properties properties)
            throws IOException, FileNotFoundException, SQLException {
        playerDB = new PlayerDB(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de jugadores desde la base de datos
     *
     * @param team Equipo por el que se quiere filtrar los jugadores
     * @return Listado de jugadores
     * @throws SQLException Si hubo un error en la consulta
     */
    public ArrayList<Player> list(Team team)
            throws SQLException {
        return playerDB.list(team);
    }

    /**
     * Inserta un jugador en la base de datos
     *
     * @param player Nuevo jugador a insertar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(Player player) throws SQLException {
        playerDB.insert(player);
    }

    /**
     * Actualiza un jugador en la base de datos
     *
     * @param player Nuevo jugador a actualizar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Player player) throws SQLException {
        playerDB.update(player);
    }

    /**
     * Elimina un jugador en la base de datos
     *
     * @param player Nuevo jugador a eliminar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Player player) throws SQLException {
        playerDB.delete(player);
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Administrador de persistencia del jugador en la base de datos
     */
    private final PlayerDB playerDB;
    //</editor-fold>
}
