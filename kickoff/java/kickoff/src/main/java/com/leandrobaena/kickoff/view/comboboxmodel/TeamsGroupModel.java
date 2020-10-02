package com.leandrobaena.kickoff.view.comboboxmodel;

import com.leandrobaena.kickoff.entities.Group;
import com.leandrobaena.kickoff.entities.Team;
import com.leandrobaena.kickoff.logic.GroupMgr;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

/**
 * Modelo para el listado de todos los equipos que se pueden asociar a un grupo
 *
 * @author Leandro Baena Torres
 */
public class TeamsGroupModel extends AbstractListModel implements ComboBoxModel {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un modelo de combobox para el listado de equipos
     *
     * @param group Grupo por el que se filtran los equipos que pertenecen a él
     */
    public TeamsGroupModel(Group group) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("settings_db.properties"));
            groupMgr = new GroupMgr(properties);
            this.teams = groupMgr.listTeams(group);
        } catch (IOException | SQLException ex) {
            this.teams = new ArrayList<>();
            JOptionPane.showMessageDialog(null, "Hubo un error al traer el listado de equipos de este grupo");
        }
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Retorna el equipo seleccionado
     *
     * @return Equipo seleccionado
     */
    @Override
    public Team getSelectedItem() {
        return selected;
    }

    /**
     * Retorna el número de elementos del combobox
     *
     * @return Número de elementos del combobox
     */
    @Override
    public int getSize() {
        return teams.size();
    }

    /**
     * Trae un elemento del combobox en una posición determinada
     *
     * @param i Posición del elemento
     * @return Elemento del combobox en la posición determinada
     */
    @Override
    public Team getElementAt(int i) {
        return teams.get(i);
    }

    /**
     * Determina el equipo seleccionado
     *
     * @param team Equipo a seleccionar
     */
    @Override
    public void setSelectedItem(Object team) {
        selected = (Team) team;
    }

    /**
     * Determina el equipo seleccionado
     *
     * @param team Equipo a seleccionar
     */
    public void setSelectedItem(Team team) {
        selected = team;
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Listado de equipos que se pueden incluir en un grupo de un torneo
     */
    private ArrayList<Team> teams;

    /**
     * Equipo seleccionado en el combo
     */
    private Team selected;

    /**
     * Administrador de grupo
     */
    private GroupMgr groupMgr;
    //</editor-fold>
}
