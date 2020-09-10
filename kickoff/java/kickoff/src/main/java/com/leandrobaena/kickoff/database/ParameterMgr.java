package com.leandrobaena.kickoff.database;

import com.leandrobaena.kickoff.entities.Parameter;
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
public class ParameterMgr {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de persistencia en base de datos de un parámetro
     *
     * @param properties Propiedades de conexión a la base de datos
     * @throws IOException Si no puede leer el archivo de propiedades
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public ParameterMgr(Properties properties) throws IOException, FileNotFoundException, SQLException {
        connection = new Connection(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de parámetros desde la base de datos
     *
     * @return Listado de parámetros desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public ArrayList<Parameter> list() throws SQLException {
        ArrayList<HashMap<String, String>> table = connection.select("SELECT idparameter, name, value FROM parameter");
        ArrayList<Parameter> list = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            Parameter p = new Parameter(Integer.parseInt(row.get("idparameter")), row.get("name"), row.get("value"));
            list.add(p);
        }
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
                "INSERT INTO parameter (name, value) "
                + "VALUES "
                + "('" + parameter.getName() + "', '" + parameter.getValue() + "')"));
    }

    /**
     * Carga un parámetro desde la base de datos
     *
     * @param parameter Parámetro a cargar desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void read(Parameter parameter) throws SQLException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT name, value FROM parameter "
                + "WHERE idparameter = " + parameter.getIdParameter());
        for (HashMap<String, String> row : table) {
            parameter.setName(row.get("name"));
            parameter.setValue(row.get("value"));
        }
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
                + "value = '" + parameter.getValue() + "' "
                + "WHERE idparameter = " + parameter.getIdParameter());
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
