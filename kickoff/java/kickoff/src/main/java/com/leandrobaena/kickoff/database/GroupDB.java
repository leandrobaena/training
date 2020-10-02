package com.leandrobaena.kickoff.database;

import com.leandrobaena.kickoff.entities.Group;
import com.leandrobaena.kickoff.entities.Team;
import com.leandrobaena.kickoff.entities.Tournament;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * Administra la persistencia de un grupo en la base de datos
 *
 * @author Leandro Baena Torres
 */
public class GroupDB {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de persistencia en base de datos de un grupo
     *
     * @param properties Propiedades de conexión a la base de datos
     * @throws IOException Si no puede leer el archivo de propiedades
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public GroupDB(Properties properties) throws IOException, FileNotFoundException, SQLException {
        connection = new Connection(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de grupos desde la base de datos
     *
     * @param tournament Torneo por el que se fltran los grupos
     * @return Listado de grupos desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public ArrayList<Group> list(Tournament tournament) throws SQLException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT idgroup, name, idtournament, tournament FROM vw_group WHERE idtournament = " + tournament.getIdTournament());
        ArrayList<Group> list = new ArrayList<>();
        table.stream().map(row -> new Group(
                Integer.parseInt(row.get("idgroup")),
                row.get("name"),
                new Tournament(
                        Integer.parseInt(row.get("idtournament")),
                        row.get("tournament")))).forEachOrdered(g -> {
            list.add(g);
        });
        return list;
    }

    /**
     * Inserta un nuevo grupo en la base de datos
     *
     * @param group Grupo a insertar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(Group group) throws SQLException {
        group.setIdGroup(connection.insert(
                "INSERT INTO `group` (name, idtournament) "
                + "VALUES "
                + "('" + group.getName() + "', " + group.getTournament().getIdTournament() + ")"));
    }

    /**
     * Carga un grupo desde la base de datos
     *
     * @param group Grupo a cargar desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void read(Group group) throws SQLException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT idgroup, name, idtournament, tournament FROM vw_group "
                + "WHERE idgroup = " + group.getIdGroup());
        table.stream().map(row -> {
            group.setName(row.get("name"));
            return row;
        }).forEachOrdered(row -> {
            group.setTournament(new Tournament(Integer.parseInt(row.get("idtournament")), row.get("tournament")));
        });
    }

    /**
     * Actualiza un grupo en la base de datos
     *
     * @param group Grupo a actualizar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Group group) throws SQLException {
        connection.update(
                "UPDATE `group` SET "
                + "name = '" + group.getName() + "', "
                + "idtournament = " + group.getTournament().getIdTournament()
                + " WHERE idgroup = " + group.getIdGroup());
    }

    /**
     * Elimina un grupo en la base de datos
     *
     * @param group Grupo a eliminar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Group group) throws SQLException {
        connection.delete("DELETE FROM `group` WHERE idgroup = " + group.getIdGroup());
    }

    /**
     * Trae el listado de equipos perteneceinetes a un grupo desde la base de
     * datos
     *
     * @param group Grupo por el que se filtran los equipos
     * @return Listado de equipos que pertenecen a un grupo desde la base de
     * datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public ArrayList<Team> listTeams(Group group) throws SQLException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT t.idteam, t.name "
                + "FROM team t "
                + "INNER JOIN group_team gt ON t.idteam = gt.idteam "
                + "WHERE gt.idgroup = " + group.getIdGroup());
        ArrayList<Team> list = new ArrayList<>();
        table.stream().map(row -> new Team(
                Integer.parseInt(row.get("idteam")),
                row.get("name"))).forEachOrdered(g -> {
            list.add(g);
        });
        return list;
    }

    /**
     * Inserta un nuevo equipo en un grupo en la base de datos
     *
     * @param team Equipo a insertar en la base de datos
     * @param group Grupo al que se quiere insertar el equipo en la base de
     * datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insertTeam(Team team, Group group) throws SQLException {
        connection.insert(
                "INSERT INTO group_team (idteam, idgroup) "
                + "VALUES "
                + "(" + team.getIdTeam() + ", " + group.getIdGroup() + ")");
    }

    /**
     * Elimina un equipo de un grupo en la base de datos
     *
     * @param team Equipo a eliminar en la base de datos
     * @param group Grupo donde se elimina el equipo en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void deleteTeam(Team team, Group group) throws SQLException {
        connection.delete("DELETE FROM group_team WHERE idgroup = " + group.getIdGroup() + " AND idteam = " + team.getIdTeam());
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Conexión a la base de datos
     */
    private final Connection connection;
    //</editor-fold>
}
