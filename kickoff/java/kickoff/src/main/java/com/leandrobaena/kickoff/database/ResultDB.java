package com.leandrobaena.kickoff.database;

import com.leandrobaena.kickoff.entities.Fixture;
import com.leandrobaena.kickoff.entities.Group;
import com.leandrobaena.kickoff.entities.Result;
import com.leandrobaena.kickoff.entities.Stadium;
import com.leandrobaena.kickoff.entities.Team;
import com.leandrobaena.kickoff.entities.Tournament;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * Administra la persistencia de un equipo en la base de datos
 *
 * @author Leandro Baena Torres
 */
public class ResultDB {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de persistencia en base de datos de un equipo
     *
     * @param properties Propiedades de conexión a la base de datos
     * @throws IOException Si no puede leer el archivo de propiedades
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public ResultDB(Properties properties) throws IOException, FileNotFoundException, SQLException {
        connection = new Connection(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de resultados de un grupo desde la base de datos
     *
     * @param group Grupo al que se le listan los resultados
     * @return Listado de equipos desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     * @throws ParseException Si hubo un error en consultar la fecha del partido
     */
    public ArrayList<Result> list(Group group) throws SQLException, ParseException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT "
                + "idresult, idfixture, idteam_home, "
                + "home, idteam_away, away, "
                + "`name`, idgroup, `group`, "
                + "idtournament, tournament, `date`, "
                + "idstadium, stadium, goal_home, "
                + "goal_away, penalty_home, penalty_away "
                + "FROM vw_result "
                + "WHERE idgroup = " + group.getIdGroup());
        ArrayList<Result> list = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            list.add(
                    new Result(
                            Integer.parseInt(row.get("idresult")),
                            new Fixture(
                                    Integer.parseInt(row.get("idfixture")),
                                    row.get("name"),
                                    new Team(
                                            Integer.parseInt(row.get("idteam_home")),
                                            row.get("home")),
                                    new Team(
                                            Integer.parseInt(row.get("idteam_away")),
                                            row.get("away")),
                                    new Group(
                                            Integer.parseInt(row.get("idgroup")),
                                            row.get("group"),
                                            new Tournament(
                                                    Integer.parseInt(row.get("idtournament")),
                                                    row.get("tournament"))),
                                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(row.get("date")),
                                    new Stadium(
                                            Integer.parseInt(row.get("idstadium")),
                                            row.get("stadium")
                                    )),
                            Integer.parseInt(row.get("goal_home")),
                            Integer.parseInt(row.get("goal_away")),
                            Integer.parseInt(row.get("penalty_home")),
                            Integer.parseInt(row.get("penalty_away"))));
        }
        return list;
    }

    /**
     * Inserta un nuevo resultado en la base de datos
     *
     * @param result Resultado a insertar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(Result result) throws SQLException {
        result.setIdTeam(connection.insert(
                "INSERT INTO result "
                + "(idfixture, goal_home, goal_away, "
                + "penalty_home, penalty_away) "
                + "VALUES "
                + "(" + result.getFixture().getIdFixture() + ", "
                + result.getGoalHome() + ", "
                + result.getGoalAway() + ", "
                + result.getPenaltyHome() + ", "
                + result.getPenaltyAway() + ")"));
    }

    /**
     * Carga un resultado desde la base de datos
     *
     * @param result Resultado a cargar desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     * @throws ParseException Si hubo un error en consultar la fecha del partido
     */
    public void read(Result result) throws SQLException, ParseException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT "
                + "idresult, idfixture, idteam_home, "
                + "home, idteam_away, away, "
                + "`name`, idgroup, `group`, "
                + "idtournament, tournament, `date`, "
                + "idstadium, stadium, goal_home, "
                + "goal_away, penalty_home, penalty_away "
                + "FROM vw_result "
                + "WHERE idresult = " + result.getIdResult());
        for (HashMap<String, String> row : table) {
            result.setFixture(new Fixture(
                    Integer.parseInt(row.get("idfixture")),
                    row.get("name"),
                    new Team(
                            Integer.parseInt(row.get("idteam_home")),
                            row.get("home")),
                    new Team(
                            Integer.parseInt(row.get("idteam_away")),
                            row.get("away")),
                    new Group(
                            Integer.parseInt(row.get("idgroup")),
                            row.get("group"),
                            new Tournament(
                                    Integer.parseInt(row.get("idtournament")),
                                    row.get("tournament"))),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(row.get("date")),
                    new Stadium(
                            Integer.parseInt(row.get("idstadium")),
                            row.get("stadium")
                    )));
            result.setGoalHome(Integer.parseInt(row.get("goal_home")));
            result.setGoalAway(Integer.parseInt(row.get("goal_away")));
            result.setPenaltyHome(Integer.parseInt(row.get("penalty_home")));
            result.setPenaltyAway(Integer.parseInt(row.get("penalty_away")));
        }
    }

    /**
     * Actualiza un resultado en la base de datos
     *
     * @param result Resultado a actualizar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Result result) throws SQLException {
        connection.update(
                "UPDATE result SET "
                + "idfixture = " + result.getFixture().getIdFixture() + ", "
                + "goal_home = " + result.getGoalHome() + ", "
                + "goal_away = " + result.getGoalAway() + ", "
                + "penalty_home = " + result.getPenaltyHome() + ", "
                + "penalty_away = " + result.getPenaltyAway() + " "
                + "WHERE idresult = " + result.getIdResult());
    }

    /**
     * Elimina un resultado en la base de datos
     *
     * @param result Resultado a eliminar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Result result) throws SQLException {
        connection.delete("DELETE FROM result WHERE idresult = " + result.getIdResult());
    }

    /**
     * Trae el resultado de una fecha determinada
     *
     * @param fixture Fecha determinada de la cual se quiere traer el resultado
     * @return Resultado de una fecha determinada
     * @throws SQLException Si hubo un error en la consulta
     * @throws ParseException Si hubo un error en consultar la fecha del partido
     */
    public Result readByFixture(Fixture fixture) throws SQLException, ParseException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT "
                + "idresult, idfixture, idteam_home, "
                + "home, idteam_away, away, "
                + "`name`, idgroup, `group`, "
                + "idtournament, tournament, `date`, "
                + "idstadium, stadium, goal_home, "
                + "goal_away, penalty_home, penalty_away "
                + "FROM vw_result "
                + "WHERE idfixture = " + fixture.getIdFixture());
        Result result = new Result();
        for (HashMap<String, String> row : table) {
            result = new Result(
                    Integer.parseInt(row.get("idresult")),
                    new Fixture(
                            Integer.parseInt(row.get("idfixture")),
                            row.get("name"),
                            new Team(
                                    Integer.parseInt(row.get("idteam_home")),
                                    row.get("home")),
                            new Team(
                                    Integer.parseInt(row.get("idteam_away")),
                                    row.get("away")),
                            new Group(
                                    Integer.parseInt(row.get("idgroup")),
                                    row.get("group"),
                                    new Tournament(
                                            Integer.parseInt(row.get("idtournament")),
                                            row.get("tournament"))),
                            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(row.get("date")),
                            new Stadium(
                                    Integer.parseInt(row.get("idstadium")),
                                    row.get("stadium")
                            )),
                    Integer.parseInt(row.get("goal_home")),
                    Integer.parseInt(row.get("goal_away")),
                    Integer.parseInt(row.get("penalty_home")),
                    Integer.parseInt(row.get("penalty_away")));
        }
        return result;
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Conexión a la base de datos
     */
    private final Connection connection;
    //</editor-fold>
}
