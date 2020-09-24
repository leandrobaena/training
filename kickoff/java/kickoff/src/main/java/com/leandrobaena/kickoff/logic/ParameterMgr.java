package com.leandrobaena.kickoff.logic;

import com.leandrobaena.kickoff.entities.Parameter;
import com.leandrobaena.kickoff.database.ParameterDB;
import com.leandrobaena.kickoff.entities.Tournament;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Maneja los parámetros de la aplicación
 *
 * @author Leandro Baena Torres
 */
public class ParameterMgr {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de parámetros
     *
     * @param properties Propiedades de la conexión a la base de datos
     * @throws IOException Si no puede abrir el archivo de propiedades de
     * conexión a la base de datos
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * de conexión a la base de datos
     * @throws SQLException Si hubo un problema en la conexión a la base de
     * datos
     */
    public ParameterMgr(Properties properties)
            throws IOException, FileNotFoundException, SQLException {
        parameterDB = new ParameterDB(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de parámetros desde la base de datos
     *
     * @param tournament Torneo por el que se quiere filtrar los parámetros o
     * null para traer los parámetros generales
     * @return Listado de parámetros
     * @throws SQLException Si hubo un error en la consulta
     */
    public ArrayList<Parameter> list(Tournament tournament)
            throws SQLException {
        return parameterDB.list(tournament);
    }

    /**
     * Inserta un parámetro en la base de datos
     *
     * @param parameter Nuevo parámetro a insertar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(Parameter parameter) throws SQLException {
        parameterDB.insert(parameter);
    }

    /**
     * Actualiza un parámetro en la base de datos
     *
     * @param parameter Nuevo parámetro a actualizar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Parameter parameter) throws SQLException {
        parameterDB.update(parameter);
    }

    /**
     * Elimina un parámetro en la base de datos
     *
     * @param parameter Nuevo parámetro a eliminar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Parameter parameter) throws SQLException {
        parameterDB.delete(parameter);
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Administrador de persistencia del parámetro en la base de datos
     */
    private final ParameterDB parameterDB;
    //</editor-fold>
}
