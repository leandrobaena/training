package com.leandrobaena.kickoff.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * Conexión a la base de datos
 *
 * @author Leandro Baena Torres
 */
public class Connection {

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Connection(Properties propiedadesBd) throws FileNotFoundException, IOException, SQLException {
        this.urlConnection = propiedadesBd.getProperty("url");
        this.user = propiedadesBd.getProperty("user");
        this.password = propiedadesBd.getProperty("password");
        this.timeZone = propiedadesBd.getProperty("timeZone");
        mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(this.urlConnection);
        mysqlDataSource.setUser(this.user);
        mysqlDataSource.setPassword(this.password);
        mysqlDataSource.setServerTimezone(this.timeZone);
        mysqlDataSource.setUseSSL(false);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae un conjunto de resultados
     *
     * @param sql Consulta ejecutada
     * @return Conjunto de resultados producto de la consulta
     * @throws SQLException Si hay un error en la consulta
     */
    public ArrayList<HashMap<String, String>> select(String sql) throws SQLException {
        ArrayList<HashMap<String, String>> table = new ArrayList<>();
        try ( java.sql.Connection connection = mysqlDataSource.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                HashMap<String, String> row = new HashMap<>();
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    row.put(rs.getMetaData().getColumnLabel(i + 1), rs.getString(i + 1));
                }
                table.add(row);
            }
        }
        return table;
    }

    /**
     * Realiza una inserción en la base de datos
     *
     * @param sql Sentencia con la instrucción de la inserción
     * @return Identificador generado por la base de datos
     * @throws SQLException
     */
    public int insert(String sql) throws SQLException {
        int id = 0;

        try ( java.sql.Connection connection = mysqlDataSource.getConnection()) {
            Statement st = connection.createStatement();
            st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id = rs.getInt(1);
            }
        }
        return id;
    }

    /**
     * Realiza una acualización en la base de datos
     *
     * @param sql Sentencia con la instrucción de la actualización
     * @throws SQLException
     */
    public void update(String sql) throws SQLException {
        try ( java.sql.Connection connection = mysqlDataSource.getConnection()) {
            Statement st = connection.createStatement();
            st.executeUpdate(sql);
        }
    }

    /**
     * Realiza una eliminación en la base de datos
     *
     * @param sql Sentencia con la instrucción de la eliminación
     * @throws SQLException
     */
    public void delete(String sql) throws SQLException {
        try ( java.sql.Connection connection = mysqlDataSource.getConnection()) {
            Statement st = connection.createStatement();
            st.executeUpdate(sql);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Url de conexión a la base de datos
     */
    private final String urlConnection;

    /**
     * Usuario con que se conecta a la base de datos
     */
    private final String user;

    /**
     * Contraseña con que se conecta a la base de datos
     */
    private final String password;

    /**
     * Zona horaria con que se conecta al servidor de base de datos
     */
    private final String timeZone;

    /**
     * Conexión a la base de datos como tal
     */
    private final MysqlDataSource mysqlDataSource;
    //</editor-fold>   
}
