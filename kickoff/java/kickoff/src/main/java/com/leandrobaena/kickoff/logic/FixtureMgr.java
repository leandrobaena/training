package com.leandrobaena.kickoff.logic;

import com.leandrobaena.kickoff.database.FixtureDB;
import com.leandrobaena.kickoff.entities.Fixture;
import com.leandrobaena.kickoff.entities.Group;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Maneja las fechas de juego de los equipos de un grupo que pertenecen a un
 * torneo
 *
 * @author Leandro Baena Torres
 */
public class FixtureMgr {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de fechas de juegos entre equipos de un grupo que
     * pertenecen a un torneo
     *
     * @param properties Propiedades de la conexión a la base de datos
     * @throws IOException Si no puede abrir el archivo de propiedades de
     * conexión a la base de datos
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * de conexión a la base de datos
     * @throws SQLException Si hubo un problema en la conexión a la base de
     * datos
     */
    public FixtureMgr(Properties properties)
            throws IOException, FileNotFoundException, SQLException {
        fixtureDB = new FixtureDB(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de fechas desde la base de datos
     *
     * @param group Grupo al que se le consultan las fechas
     * @return Listado de fechas
     * @throws SQLException Si hubo un error en la consulta
     * @throws java.text.ParseException Si hubo un error al leer la fecha del
     * encuentro
     */
    public ArrayList<Fixture> list(Group group)
            throws SQLException, ParseException {
        return fixtureDB.list(group);
    }

    /**
     * Inserta una fecha en la base de datos
     *
     * @param fixture Nueva fecha a insertar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(Fixture fixture) throws SQLException {
        fixtureDB.insert(fixture);
    }

    /**
     * Actualiza una fecha en la base de datos
     *
     * @param fixture Nueva fecha a actualizar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Fixture fixture) throws SQLException {
        fixtureDB.update(fixture);
    }

    /**
     * Elimina una fecha en la base de datos
     *
     * @param fixture Nueva fecha a eliminar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Fixture fixture) throws SQLException {
        fixtureDB.delete(fixture);
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Administrador de persistencia de la fecha en la base de datos
     */
    private final FixtureDB fixtureDB;
    //</editor-fold>
}
