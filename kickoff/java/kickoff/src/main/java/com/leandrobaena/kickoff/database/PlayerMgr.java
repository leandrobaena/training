package com.leandrobaena.kickoff.database;

import com.leandrobaena.kickoff.entities.Player;
import com.leandrobaena.kickoff.entities.Team;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * Administra la persistencia de un jugador en la base de datos
 *
 * @author Leandro Baena Torres
 */
public class PlayerMgr {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de persistencia en base de datos de un jugador
     *
     * @param properties Propiedades de conexión a la base de datos
     * @throws IOException Si no puede leer el archivo de propiedades
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public PlayerMgr(Properties properties) throws IOException, FileNotFoundException, SQLException {
        connection = new Connection(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de jugadores desde la base de datos
     *
     * @return Listado de jugadores desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public ArrayList<Player> list() throws SQLException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT idplayer, name, dorsal, idteam, team FROM vw_player");
        ArrayList<Player> list = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            Player t = new Player(Integer.parseInt(row.get("idplayer")),
                    row.get("name"),
                    row.get("dorsal"),
                    new Team(Integer.parseInt(row.get("idteam")), row.get("team")));
            list.add(t);
        }
        return list;
    }

    /**
     * Inserta un nuevo jugador en la base de datos
     *
     * @param player Jugador a insertar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(Player player) throws SQLException {
        player.setIdPlayer(connection.insert(
                "INSERT INTO player (name, dorsal, idteam) "
                + "VALUES "
                + "('" + player.getName() + "', '" + player.getDorsal() + "', " + player.getTeam().getIdTeam() + ")"));
    }

    /**
     * Carga un jugador desde la base de datos
     *
     * @param player Jugador a cargar desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void read(Player player) throws SQLException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT idplayer, name, dorsal, idteam, team FROM vw_player "
                + "WHERE idplayer = " + player.getIdPlayer());
        for (HashMap<String, String> row : table) {
            player.setName(row.get("name"));
            player.setDorsal(row.get("dorsal"));
            player.setTeam(new Team(Integer.parseInt(row.get("idteam")), row.get("team")));
        }
    }

    /**
     * Actualiza un jugador en la base de datos
     *
     * @param player Jugador a actualizar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Player player) throws SQLException {
        connection.update(
                "UPDATE player SET "
                + "name = '" + player.getName() + "', "
                + "dorsal = '" + player.getDorsal() + "', "
                + "idteam = " + player.getTeam().getIdTeam() + " "
                + "WHERE idplayer = " + player.getIdPlayer());
    }

    /**
     * Elimina un jugador en la base de datos
     *
     * @param player Jugador a eliminar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Player player) throws SQLException {
        connection.delete("DELETE FROM player WHERE idplayer = " + player.getIdPlayer());
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Conexión a la base de datos
     */
    private final Connection connection;
    //</editor-fold>
}
