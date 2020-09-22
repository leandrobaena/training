package com.leandrobaena.kickoff.database;

import com.leandrobaena.kickoff.entities.Group;
import com.leandrobaena.kickoff.entities.Position;
import com.leandrobaena.kickoff.entities.Team;
import com.leandrobaena.kickoff.entities.Tournament;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * Administra la persistencia de una tabla de posiciones en la base de datos
 *
 * @author Leandro Baena Torres
 */
public class PositionDB {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de persistencia en base de datos de una tabla de
     * posiciones
     *
     * @param properties Propiedades de conexión a la base de datos
     * @throws IOException Si no puede leer el archivo de propiedades
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public PositionDB(Properties properties) throws IOException, FileNotFoundException, SQLException {
        connection = new Connection(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de posiciones desde la base de datos
     *
     * @return Listado de posiciones desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public ArrayList<Position> list() throws SQLException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT idposition, idgroup, `group`, "
                + "idtournament, tournament, idteam, "
                + "team, win, draw, "
                + "lost, goal_for, goal_against FROM vw_position");
        ArrayList<Position> list = new ArrayList<>();
        table.stream().map(row -> new Position(
                Integer.parseInt(row.get("idposition")),
                new Group(
                        Integer.parseInt(row.get("idgroup")),
                        row.get("group"),
                        new Tournament(
                                Integer.parseInt(row.get("idtournament")),
                                row.get("tournament"))),
                new Team(
                        Integer.parseInt(row.get("idteam")),
                        row.get("team")),
                Integer.parseInt(row.get("win")),
                Integer.parseInt(row.get("draw")),
                Integer.parseInt(row.get("lost")),
                Integer.parseInt(row.get("goal_for")),
                Integer.parseInt(row.get("goal_against")))).forEachOrdered(p -> {
                    list.add(p);
        });
        return list;
    }

    /**
     * Inserta una nueva posición en la base de datos
     *
     * @param position Posición a insertar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(Position position) throws SQLException {
        position.setIdPosition(connection.insert(
                "INSERT INTO position (idgroup, idteam, win, "
                + "draw, lost, goal_for, goal_against) "
                + "VALUES "
                + "(" + position.getGroup().getIdGroup() + "," + position.getTeam().getIdTeam() + ", " + position.getWin() + ","
                + position.getDraw() + ", " + position.getLost() + ", " + position.getGoalFor() + ","
                + position.getGoalAgainst() + ")"));
    }

    /**
     * Carga una tabla de posiciones desde la base de datos
     *
     * @param position Posición a cargar desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void read(Position position) throws SQLException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT idposition, idgroup, `group`, "
                + "idtournament, tournament, idteam, "
                + "team, win, draw, "
                + "lost, goal_for, goal_against FROM vw_position "
                + "WHERE idposition = " + position.getIdPosition());
        table.stream().map(row -> {
            position.setGroup(new Group(
                    Integer.parseInt(row.get("idgroup")),
                    row.get("group"),
                    new Tournament(
                            Integer.parseInt(row.get("idtournament")),
                            row.get("tournament"))));
            return row;
        }).map(row -> {
            position.setTeam(new Team(
                    Integer.parseInt(row.get("idteam")),
                    row.get("team")));
            return row;
        }).map(row -> {
            position.setWin(Integer.parseInt(row.get("win")));
            return row;
        }).map(row -> {
            position.setDraw(Integer.parseInt(row.get("draw")));
            return row;
        }).map(row -> {
            position.setLost(Integer.parseInt(row.get("lost")));
            return row;
        }).map(row -> {
            position.setGoalFor(Integer.parseInt(row.get("goal_for")));
            return row;
        }).forEachOrdered(row -> {
            position.setGoalAgainst(Integer.parseInt(row.get("goal_against")));
        });
    }

    /**
     * Actualiza una tabla de posiciones en la base de datos
     *
     * @param position Posición a actualizar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Position position) throws SQLException {
        connection.update(
                "UPDATE position SET "
                + "idgroup = " + position.getGroup().getIdGroup() + ", "
                + "idteam = " + position.getTeam().getIdTeam() + ", "
                + "win = " + position.getWin() + ", "
                + "draw = " + position.getDraw() + ", "
                + "lost = " + position.getLost() + ", "
                + "goal_for = " + position.getGoalFor() + ", "
                + "goal_against = " + position.getGoalAgainst() + " "
                + "WHERE idposition = " + position.getIdPosition());
    }

    /**
     * Elimina una tabla de posiciones en la base de datos
     *
     * @param position Posición a eliminar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Position position) throws SQLException {
        connection.delete("DELETE FROM position WHERE idposition = " + position.getIdPosition());
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Conexión a la base de datos
     */
    private final Connection connection;
    //</editor-fold>
}
