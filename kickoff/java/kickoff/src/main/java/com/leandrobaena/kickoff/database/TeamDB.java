package com.leandrobaena.kickoff.database;

import com.leandrobaena.kickoff.entities.Team;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * Administra la persistencia de un equipo en la base de datos
 *
 * @author Leandro Baena Torres
 */
public class TeamDB {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de persistencia en base de datos de un equipo
     *
     * @param properties Propiedades de conexión a la base de datos
     * @throws IOException Si no puede leer el archivo de propiedades
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public TeamDB(Properties properties) throws IOException, FileNotFoundException, SQLException {
        connection = new Connection(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de equipos desde la base de datos
     *
     * @return Listado de equipos desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public ArrayList<Team> list() throws SQLException {
        ArrayList<HashMap<String, String>> table = connection.select("SELECT idteam, name FROM team");
        ArrayList<Team> list = new ArrayList<>();
        table.stream().map(row -> new Team(Integer.parseInt(row.get("idteam")), row.get("name"))).forEachOrdered(t -> {
            list.add(t);
        });
        return list;
    }

    /**
     * Inserta un nuevo equipo en la base de datos
     *
     * @param team Equipo a insertar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(Team team) throws SQLException {
        team.setIdTeam(connection.insert(
                "INSERT INTO team (name) "
                + "VALUES "
                + "('" + team.getName() + "')"));
    }

    /**
     * Carga un equipo desde la base de datos
     *
     * @param team Equipo a cargar desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void read(Team team) throws SQLException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT name FROM team "
                + "WHERE idteam = " + team.getIdTeam());
        table.forEach(row -> {
            team.setName(row.get("name"));
        });
    }

    /**
     * Actualiza un equipo en la base de datos
     *
     * @param team Equipo a actualizar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Team team) throws SQLException {
        connection.update(
                "UPDATE team SET "
                + "name = '" + team.getName() + "' "
                + "WHERE idteam = " + team.getIdTeam());
    }

    /**
     * Elimina un equipo en la base de datos
     *
     * @param team Equipo a eliminar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Team team) throws SQLException {
        connection.delete("DELETE FROM team WHERE idteam = " + team.getIdTeam());
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Conexión a la base de datos
     */
    private final Connection connection;
    //</editor-fold>
}
