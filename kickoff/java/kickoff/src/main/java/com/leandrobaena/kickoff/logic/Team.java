package com.leandrobaena.kickoff.logic;

import com.leandrobaena.kickoff.database.TeamMgr;
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
public class Team {

    //<editor-fold desc="Atributos" defaultstate="collapsed">
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
    public Team(Properties properties)
            throws IOException, FileNotFoundException, SQLException {
        teamMgr = new TeamMgr(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de equipos desde la base de datos
     *
     * @return Listado de equipos
     * @throws SQLException Si hubo un error en la consulta
     */
    public ArrayList<com.leandrobaena.kickoff.entities.Team> list()
            throws SQLException {
        return teamMgr.list();
    }

    /**
     * Inserta un equipo en la base de datos
     *
     * @param team Nuevo equipo a insertar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(com.leandrobaena.kickoff.entities.Team team) throws SQLException {
        teamMgr.insert(team);
    }

    /**
     * Actualiza un equipo en la base de datos
     *
     * @param team Nuevo equipo a actualizar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(com.leandrobaena.kickoff.entities.Team team) throws SQLException {
        teamMgr.update(team);
    }

    /**
     * Elimina un equipo en la base de datos
     *
     * @param team Nuevo equipo a eliminar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(com.leandrobaena.kickoff.entities.Team team) throws SQLException {
        teamMgr.delete(team);
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Administrador de persistencia del equipo en la base de datos
     */
    private TeamMgr teamMgr;
    //</editor-fold>
}
