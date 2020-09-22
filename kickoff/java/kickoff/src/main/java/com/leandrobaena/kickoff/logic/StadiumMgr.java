package com.leandrobaena.kickoff.logic;

import com.leandrobaena.kickoff.entities.Stadium;
import com.leandrobaena.kickoff.database.StadiumDB;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Maneja los estadios
 *
 * @author Leandro Baena Torres
 */
public class StadiumMgr {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de estadios
     *
     * @param properties Propiedades de la conexión a la base de datos
     * @throws IOException Si no puede abrir el archivo de propiedades de
     * conexión a la base de datos
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * de conexión a la base de datos
     * @throws SQLException Si hubo un problema en la conexión a la base de
     * datos
     */
    public StadiumMgr(Properties properties)
            throws IOException, FileNotFoundException, SQLException {
        stadiumDB = new StadiumDB(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de estadios desde la base de datos
     *
     * @return Listado de estadios
     * @throws SQLException Si hubo un error en la consulta
     */
    public ArrayList<Stadium> list()
            throws SQLException {
        return stadiumDB.list();
    }

    /**
     * Inserta un estadio en la base de datos
     *
     * @param stadium Nuevo estadio a insertar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(Stadium stadium) throws SQLException {
        stadiumDB.insert(stadium);
    }

    /**
     * Actualiza un estadio en la base de datos
     *
     * @param stadium Nuevo estadio a actualizar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Stadium stadium) throws SQLException {
        stadiumDB.update(stadium);
    }

    /**
     * Elimina un estadio en la base de datos
     *
     * @param stadium Nuevo estadio a eliminar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Stadium stadium) throws SQLException {
        stadiumDB.delete(stadium);
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Administrador de persistencia del estadio en la base de datos
     */
    private final StadiumDB stadiumDB;
    //</editor-fold>
}
