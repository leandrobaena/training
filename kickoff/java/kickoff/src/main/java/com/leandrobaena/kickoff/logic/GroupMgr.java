package com.leandrobaena.kickoff.logic;

import com.leandrobaena.kickoff.entities.Group;
import com.leandrobaena.kickoff.database.GroupDB;
import com.leandrobaena.kickoff.entities.Tournament;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Maneja los grupos de un torneo
 *
 * @author Leandro Baena Torres
 */
public class GroupMgr {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un administrador de grupos
     *
     * @param properties Propiedades de la conexión a la base de datos
     * @throws IOException Si no puede abrir el archivo de propiedades de
     * conexión a la base de datos
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * de conexión a la base de datos
     * @throws SQLException Si hubo un problema en la conexión a la base de
     * datos
     */
    public GroupMgr(Properties properties)
            throws IOException, FileNotFoundException, SQLException {
        groupDB = new GroupDB(properties);
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el listado de grupos desde la base de datos
     *
     * @param tournament Torneo por el que se quiere filtrar los grupos
     * @return Listado de grupos
     * @throws SQLException Si hubo un error en la consulta
     */
    public ArrayList<Group> list(Tournament tournament)
            throws SQLException {
        return groupDB.list(tournament);
    }

    /**
     * Inserta un grupo en la base de datos
     *
     * @param group Nuevo grupo a insertar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void insert(Group group) throws SQLException {
        groupDB.insert(group);
    }

    /**
     * Actualiza un grupo en la base de datos
     *
     * @param group Nuevo grupo a actualizar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void update(Group group) throws SQLException {
        groupDB.update(group);
    }

    /**
     * Elimina un grupo en la base de datos
     *
     * @param group Nuevo grupo a eliminar
     * @throws SQLException Si hubo un error en la consulta
     */
    public void delete(Group group) throws SQLException {
        groupDB.delete(group);
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Administrador de persistencia del grupo en la base de datos
     */
    private final GroupDB groupDB;
    //</editor-fold>
}
