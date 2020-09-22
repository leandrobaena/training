package com.leandrobaena.kickoff.database;

import com.leandrobaena.kickoff.entities.Tournament;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * Administra la persistencia de un torneo en la base de datos
 *
 * @author Leandro Baena Torres
 */
public class TournamentDB {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de persistencia en base de datos de un torneo
     *
     * @param properties Propiedades de conexión a la base de datos
     * @throws IOException Si no puede leer el archivo de propiedades
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public TournamentDB(Properties properties) throws IOException, FileNotFoundException, SQLException {
        connection = new Connection(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de torneos desde la base de datos
     *
     * @return Listado de torneos desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public ArrayList<Tournament> list() throws SQLException {
        ArrayList<HashMap<String, String>> table = connection.select("SELECT idtournament, name FROM tournament");
        ArrayList<Tournament> list = new ArrayList<>();
        table.stream().map(row -> new Tournament(Integer.parseInt(row.get("idtournament")), row.get("name"))).forEachOrdered(t -> {
            list.add(t);
        });
        return list;
    }

    /**
     * Inserta un nuevo torneo en la base de datos
     *
     * @param tournament Torneo a insertar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(Tournament tournament) throws SQLException {
        tournament.setIdTournament(connection.insert(
                "INSERT INTO tournament (name) "
                + "VALUES "
                + "('" + tournament.getName() + "')"));
    }

    /**
     * Carga un torneo desde la base de datos
     *
     * @param tournament Torneo a cargar desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void read(Tournament tournament) throws SQLException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT name FROM tournament "
                + "WHERE idtournament = " + tournament.getIdTournament());
        table.forEach(row -> {
            tournament.setName(row.get("name"));
        });
    }

    /**
     * Actualiza un torneo en la base de datos
     *
     * @param tournament Torneo a actualizar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Tournament tournament) throws SQLException {
        connection.update(
                "UPDATE tournament SET "
                + "name = '" + tournament.getName() + "' "
                + "WHERE idtournament = " + tournament.getIdTournament());
    }

    /**
     * Elimina un torneo en la base de datos
     *
     * @param tournament Torneo a eliminar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Tournament tournament) throws SQLException {
        connection.delete("DELETE FROM tournament WHERE idtournament = " + tournament.getIdTournament());
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Conexión a la base de datos
     */
    private final Connection connection;
    //</editor-fold>
}
