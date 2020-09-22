package com.leandrobaena.kickoff.logic;

import com.leandrobaena.kickoff.database.TeamDB;
import com.leandrobaena.kickoff.entities.Team;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Maneja los equipos que pertenecen a un torneo
 *
 * @author Leandro Baena Torres
 */
public class TeamMgr {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de equipos que pertenecen a un torneo
     *
     * @param properties Propiedades de la conexión a la base de datos
     * @throws IOException Si no puede abrir el archivo de propiedades de
     * conexión a la base de datos
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * de conexión a la base de datos
     * @throws SQLException Si hubo un problema en la conexión a la base de
     * datos
     */
    public TeamMgr(Properties properties)
            throws IOException, FileNotFoundException, SQLException {
        teamDB = new TeamDB(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de equipos desde la base de datos
     *
     * @return Listado de equipos
     * @throws SQLException Si hubo un error en la consulta
     */
    public ArrayList<Team> list()
            throws SQLException {
        return teamDB.list();
    }

    /**
     * Inserta un equipo en la base de datos
     *
     * @param team Nuevo equipo a insertar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(Team team) throws SQLException {
        teamDB.insert(team);
    }

    /**
     * Actualiza un equipo en la base de datos
     *
     * @param team Nuevo equipo a actualizar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Team team) throws SQLException {
        teamDB.update(team);
    }

    /**
     * Elimina un equipo en la base de datos
     *
     * @param team Nuevo equipo a eliminar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Team team) throws SQLException {
        teamDB.delete(team);
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Administrador de persistencia del equipo en la base de datos
     */
    private final TeamDB teamDB;
    //</editor-fold>
}
