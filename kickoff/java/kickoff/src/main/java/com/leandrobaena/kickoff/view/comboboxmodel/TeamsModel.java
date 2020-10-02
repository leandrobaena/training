package com.leandrobaena.kickoff.view.comboboxmodel;

import com.leandrobaena.kickoff.entities.Team;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 * Modelo para el listado de todos los equipos que se pueden asociar a un grupo
 *
 * @author Leandro Baena Torres
 */
public class TeamsModel extends AbstractListModel implements ComboBoxModel {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un modelo de combobox para el listado de equipos
     */
    private TeamsModel() {
        this.teams = new ArrayList<>();
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae la única instancia de esta clase
     *
     * @return Única instancia de esta clase
     */
    public static TeamsModel getInstance() {
        if (instance == null) {
            instance = new TeamsModel();
        }
        return instance;
    }

    /**
     * Actualiza el listado de equipos
     *
     * @param teams Nuevo listado de equipos
     */
    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

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
     * Adiciona un equipo al listado
     *
     * @param team Equipo a insertar
     */
    @Override
    public void setSelectedItem(Object team) {
        selected = (Team) team;
    }

    /**
     * Adiciona un equipo al listado
     *
     * @param team Equipo a insertar
     */
    public void setSelectedItem(Team team) {
        selected = team;
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Única instancia del model del combobox de equipos
     */
    private static TeamsModel instance = null;

    /**
     * Listado de equipos que se pueden incluir en un grupo de un torneo
     */
    private ArrayList<Team> teams;

    /**
     * Equipo seleccionado en el combo
     */
    private Team selected;
    //</editor-fold>
}
