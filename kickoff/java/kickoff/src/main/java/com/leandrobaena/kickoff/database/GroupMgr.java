package com.leandrobaena.kickoff.database;

import com.leandrobaena.kickoff.entities.Group;
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
public class GroupMgr {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de persistencia en base de datos de un grupo
     *
     * @param properties Propiedades de conexión a la base de datos
     * @throws IOException Si no puede leer el archivo de propiedades
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public GroupMgr(Properties properties) throws IOException, FileNotFoundException, SQLException {
        connection = new Connection(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de grupos desde la base de datos
     *
     * @return Listado de grupos desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public ArrayList<Group> list() throws SQLException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT idgroup, name, idtournament, tournament FROM vw_group");
        ArrayList<Group> list = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            Group g = new Group(
                    Integer.parseInt(row.get("idgroup")),
                    row.get("name"),
                    new Tournament(
                            Integer.parseInt(row.get("idtournament")),
                            row.get("tournament")));
            list.add(g);
        }
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
                "INSERT INTO group (name, idtournament) "
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
        for (HashMap<String, String> row : table) {
            group.setName(row.get("name"));
            group.setTournament(new Tournament(Integer.parseInt(row.get("idtournament")), row.get("tournament")));
        }
    }

    /**
     * Actualiza un grupo en la base de datos
     *
     * @param group Grupo a actualizar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Group group) throws SQLException {
        connection.update(
                "UPDATE group SET "
                + "name = '" + group.getName() + "', "
                + "idtournament = " + group.getName()
                + " WHERE idgroup = " + group.getIdGroup());
    }

    /**
     * Elimina un grupo en la base de datos
     *
     * @param group Grupo a eliminar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Group group) throws SQLException {
        connection.delete("DELETE FROM group WHERE idgroup = " + group.getIdGroup());
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Conexión a la base de datos
     */
    private final Connection connection;
    //</editor-fold>
}
