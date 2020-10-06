package com.leandrobaena.kickoff.logic;

import com.leandrobaena.kickoff.database.ResultDB;
import com.leandrobaena.kickoff.entities.Fixture;
import com.leandrobaena.kickoff.entities.Result;
import com.leandrobaena.kickoff.entities.Group;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Maneja los resultados de las fechas de juego de los equipos de un grupo que
 * pertenecen a un torneo
 *
 * @author Leandro Baena Torres
 */
public class ResultMgr {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de resultados de fechas de juegos entre equipos de
     * un grupo que pertenecen a un torneo
     *
     * @param properties Propiedades de la conexión a la base de datos
     * @throws IOException Si no puede abrir el archivo de propiedades de
     * conexión a la base de datos
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * de conexión a la base de datos
     * @throws SQLException Si hubo un problema en la conexión a la base de
     * datos
     */
    public ResultMgr(Properties properties)
            throws IOException, FileNotFoundException, SQLException {
        resultDB = new ResultDB(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de resultados desde la base de datos
     *
     * @param group Grupo al que se le consultan los resultados
     * @return Listado de resultados
     * @throws SQLException Si hubo un error en la consulta
     * @throws java.text.ParseException Si hubo un error al leer la fecha del
     * encuentro
     */
    public ArrayList<Result> list(Group group)
            throws SQLException, ParseException {
        return resultDB.list(group);
    }

    /**
     * Inserta un resultado en la base de datos
     *
     * @param result Nuevo resultado a insertar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(Result result) throws SQLException {
        resultDB.insert(result);
    }

    /**
     * Actualiza un resultado en la base de datos
     *
     * @param result Nuevo resultado a actualizar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Result result) throws SQLException {
        resultDB.update(result);
    }

    /**
     * Elimina un resultado en la base de datos
     *
     * @param result Nuevo resultado a eliminar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Result result) throws SQLException {
        resultDB.delete(result);
    }

    /**
     * Trae el resultado de una fecha específica
     *
     * @param fixture Fecha específica de la que se trae el resultado
     * @return Resultado de la fecha
     * @throws SQLException Si hubo un error en la consulta
     * @throws ParseException Si hubo un error en consultar la fecha del partido
     */
    public Result getResultByFixture(Fixture fixture) throws SQLException, ParseException {
        return resultDB.readByFixture(fixture);
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Administrador de persistencia del resultado en la base de datos
     */
    private final ResultDB resultDB;
    //</editor-fold>
}
