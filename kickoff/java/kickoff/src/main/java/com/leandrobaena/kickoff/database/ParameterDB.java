package com.leandrobaena.kickoff.database;

import com.leandrobaena.kickoff.entities.Parameter;
import com.leandrobaena.kickoff.entities.Tournament;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * Administra la persistencia de un parámetro en la base de datos
 *
 * @author Leandro Baena Torres
 */
public class ParameterDB {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de persistencia en base de datos de un parámetro
     *
     * @param properties Propiedades de conexión a la base de datos
     * @throws IOException Si no puede leer el archivo de propiedades
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public ParameterDB(Properties properties) throws IOException, FileNotFoundException, SQLException {
        connection = new Connection(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de parámetros desde la base de datos
     *
     * @param tournament Torneo por el cual se quiere filtrar o null si se
     * quiere traer los parámetros generales
     * @return Listado de parámetros desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public ArrayList<Parameter> list(Tournament tournament) throws SQLException {
        String sql = "SELECT idparameter, name, value, idtournament, tournament FROM vw_parameter";
        if(tournament != null){
            sql += " WHERE idtournament = " + tournament.getIdTournament();
        }
        ArrayList<HashMap<String, String>> table = connection.select(sql);
        ArrayList<Parameter> list = new ArrayList<>();
        table.stream().map(
                row -> new Parameter(
                        Integer.parseInt(row.get("idparameter")),
                        row.get("name"),
                        row.get("value"),
                        (row.get("idtournament") == null ? null : new Tournament(
                        Integer.parseInt(row.get("idtournament")),
                        row.get("tournament")))
                )).forEachOrdered(
                        p -> {
                            list.add(p);
                        });
        return list;
    }

    /**
     * Inserta un nuevo parámetro en la base de datos
     *
     * @param parameter Parámetro a insertar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(Parameter parameter) throws SQLException {
        parameter.setIdParameter(connection.insert(
                "INSERT INTO parameter (name, value, idtournament) "
                + "VALUES "
                + "('" + parameter.getName() + "', "
                + "'" + parameter.getValue() + "', "
                + (parameter.getTournament() == null ? "NULL" : parameter.getTournament().getIdTournament()) + ")"));
    }

    /**
     * Carga un parámetro desde la base de datos
     *
     * @param parameter Parámetro a cargar desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void read(Parameter parameter) throws SQLException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT name, value, idtournament, tournament FROM vw_parameter "
                + "WHERE idparameter = " + parameter.getIdParameter());
        table.stream().map(row -> {
            return row;
        }).forEachOrdered(row -> {
            parameter.setName(row.get("name"));
            parameter.setValue(row.get("value"));
            if (row.get("value") == null) {
                parameter.setTournament(null);
            } else {
                parameter.setTournament(new Tournament(Integer.parseInt(row.get("idTournament")), row.get("tournament")));
            }
        });
    }

    /**
     * Actualiza un parámetro en la base de datos
     *
     * @param parameter Parámetro a actualizar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Parameter parameter) throws SQLException {
        connection.update(
                "UPDATE parameter SET "
                + "name = '" + parameter.getName() + "', "
                + "value = '" + parameter.getValue() + "', "
                + "idtournament = " + (parameter.getTournament() == null ? "NULL" : parameter.getTournament().getIdTournament())
                + " WHERE idparameter = " + parameter.getIdParameter());
    }

    /**
     * Elimina un parámetro en la base de datos
     *
     * @param parameter Parámetro a eliminar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Parameter parameter) throws SQLException {
        connection.delete("DELETE FROM parameter WHERE idparameter = " + parameter.getIdParameter());
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Conexión a la base de datos
     */
    private final Connection connection;
    //</editor-fold>
}
