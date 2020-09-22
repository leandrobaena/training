package com.leandrobaena.kickoff.logic;

import com.leandrobaena.kickoff.entities.Tournament;
import com.leandrobaena.kickoff.database.TournamentDB;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Maneja los torneos
 *
 * @author Leandro Baena Torres
 */
public class TournamentMgr {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de torneos
     *
     * @param properties Propiedades de la conexión a la base de datos
     * @throws IOException Si no puede abrir el archivo de propiedades de
     * conexión a la base de datos
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * de conexión a la base de datos
     * @throws SQLException Si hubo un problema en la conexión a la base de
     * datos
     */
    public TournamentMgr(Properties properties)
            throws IOException, FileNotFoundException, SQLException {
        tournamentDB = new TournamentDB(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de torneos desde la base de datos
     *
     * @return Listado de torneos
     * @throws SQLException Si hubo un error en la consulta
     */
    public ArrayList<Tournament> list()
            throws SQLException {
        return tournamentDB.list();
    }

    /**
     * Inserta un torneo en la base de datos
     *
     * @param tournament Nuevo torneo a insertar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(Tournament tournament) throws SQLException {
        tournamentDB.insert(tournament);
    }

    /**
     * Actualiza un torneo en la base de datos
     *
     * @param tournament Nuevo torneo a actualizar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Tournament tournament) throws SQLException {
        tournamentDB.update(tournament);
    }

    /**
     * Elimina un torneo en la base de datos
     *
     * @param tournament Nuevo torneo a eliminar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Tournament tournament) throws SQLException {
        tournamentDB.delete(tournament);
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Administrador de persistencia del torneo en la base de datos
     */
    private final TournamentDB tournamentDB;
    //</editor-fold>
}
