package com.leandrobaena.kickoff.database;

import com.leandrobaena.kickoff.entities.Stadium;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * Administra la persistencia de un estadio en la base de datos
 *
 * @author Leandro Baena Torres
 */
public class StadiumDB {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de persistencia en base de datos de un estadio
     *
     * @param properties Propiedades de conexión a la base de datos
     * @throws IOException Si no puede leer el archivo de propiedades
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public StadiumDB(Properties properties) throws IOException, FileNotFoundException, SQLException {
        connection = new Connection(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de estadios desde la base de datos
     *
     * @return Listado de estadios desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public ArrayList<Stadium> list() throws SQLException {
        ArrayList<HashMap<String, String>> table = connection.select("SELECT idstadium, name FROM stadium");
        ArrayList<Stadium> list = new ArrayList<>();
        table.stream().map(row -> new Stadium(Integer.parseInt(row.get("idstadium")), row.get("name"))).forEachOrdered(s -> {
            list.add(s);
        });
        return list;
    }

    /**
     * Inserta un nuevo estadio en la base de datos
     *
     * @param stadium Estadio a insertar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(Stadium stadium) throws SQLException {
        stadium.setIdStadium(connection.insert(
                "INSERT INTO stadium (name) "
                + "VALUES "
                + "('" + stadium.getName() + "')"));
    }

    /**
     * Carga un estadio desde la base de datos
     *
     * @param stadium Estadio a cargar desde la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void read(Stadium stadium) throws SQLException {
        ArrayList<HashMap<String, String>> table = connection.select(
                "SELECT name FROM stadium "
                + "WHERE idstadium = " + stadium.getIdStadium());
        table.forEach(row -> {
            stadium.setName(row.get("name"));
        });
    }

    /**
     * Actualiza un estadio en la base de datos
     *
     * @param stadium Estadio a actualizar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Stadium stadium) throws SQLException {
        connection.update(
                "UPDATE stadium SET "
                + "name = '" + stadium.getName() + "' "
                + "WHERE idstadium = " + stadium.getIdStadium());
    }

    /**
     * Elimina un estadio en la base de datos
     *
     * @param stadium Estadio a eliminar en la base de datos
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Stadium stadium) throws SQLException {
        connection.delete("DELETE FROM stadium WHERE idstadium = " + stadium.getIdStadium());
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Conexión a la base de datos
     */
    private final Connection connection;
    //</editor-fold>
}
