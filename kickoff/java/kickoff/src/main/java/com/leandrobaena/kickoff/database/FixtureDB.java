package com.leandrobaena.kickoff.database;

import com.leandrobaena.kickoff.entities.Fixture;
import com.leandrobaena.kickoff.entities.Group;
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
 * Administra la persistencia de una fecha en la base de datos
 *
 * @author Leandro Baena Torres
 */
public class FixtureDB {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de persistencia en base de datos de una fecha
     *
     * @param properties Propiedades de conexión a la base de datos
     * @throws IOException Si no puede leer el archivo de propiedades
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public FixtureDB(Properties properties) throws IOException, FileNotFoundException, SQLException {
        connection = new Connection(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de fechas de un grupo determinado desde la base de datos
     *
     * @param group Grupo al que se le traen las fechas
     * @return Listado de fechas desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     * @throws java.text.ParseException Si hay un error al procesar la fecha
     */
    public ArrayList<Fixture> list(Group group) throws SQLException, ParseException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT idfixture, idteam_home, home, "
                + "idteam_away, away, name, "
                + "idgroup, `group`, idtournament, "
                + "tournament, date, idstadium, "
                + "stadium "
                + "FROM vw_fixture");
        ArrayList<Fixture> list = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            Fixture f = new Fixture(
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
                    )
            );
            list.add(f);
        }
        return list;
    }

    /**
     * Inserta una nueva fecha en la base de datos
     *
     * @param fixture Fecha a insertar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(Fixture fixture) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fixture.setIdFixture(connection.insert(
                "INSERT INTO fixture (name, home, away, idgroup, date, idstadium) "
                + "VALUES "
                + "('" + fixture.getName() + "', " + fixture.getHome().getIdTeam() + ", " + fixture.getAway().getIdTeam() + ", "
                + fixture.getGroup().getIdGroup() + ", '" + sdf.format(fixture.getDate()) + "', " + fixture.getStadium().getIdStadium() + ")"));
    }

    /**
     * Carga una fecha desde la base de datos
     *
     * @param fixture Fecha a cargar desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     * @throws java.text.ParseException Si hay un error al procesar la fecha
     */
    public void read(Fixture fixture) throws SQLException, ParseException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT idfixture, idteam_home, home, "
                + "idteam_away, away, name, "
                + "idgroup, `group`, idtournament, "
                + "tournament, date, idstadium, "
                + "stadium "
                + "FROM vw_fixture "
                + "WHERE idfixture = " + fixture.getIdFixture());
        for (HashMap<String, String> row : table) {
            fixture.setName(row.get("name"));
            fixture.setHome(new Team(Integer.parseInt(row.get("idteam_home")), row.get("home")));
            fixture.setAway(new Team(Integer.parseInt(row.get("idteam_away")), row.get("away")));
            fixture.setGroup(new Group(
                    Integer.parseInt(row.get("idgroup")),
                    row.get("group"),
                    new Tournament(
                            Integer.parseInt(row.get("idtournament")),
                            row.get("tournament"))));
            fixture.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(row.get("date")));
            fixture.setStadium(new Stadium(
                    Integer.parseInt(row.get("idstadium")),
                    row.get("stadium")));
        }
    }

    /**
     * Actualiza una fecha en la base de datos
     *
     * @param fixture Fecha a actualizar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Fixture fixture) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        connection.update(
                "UPDATE fixture SET "
                + "name = '" + fixture.getName() + "', "
                + "home = " + fixture.getHome().getIdTeam() + ", "
                + "away = " + fixture.getAway().getIdTeam() + ", "
                + "`group` = " + fixture.getGroup().getIdGroup() + ", "
                + "date = '" + sdf.format(fixture.getDate()) + "', "
                + "idstadium = " + fixture.getStadium().getIdStadium() + " "
                + "WHERE idfixture = " + fixture.getIdFixture());
    }

    /**
     * Elimina una fecha en la base de datos
     *
     * @param fixture Fecha a eliminar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Fixture fixture) throws SQLException {
        connection.delete("DELETE FROM fixture WHERE idfixture = " + fixture.getIdFixture());
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Conexión a la base de datos
     */
    private final Connection connection;
    //</editor-fold>
}
