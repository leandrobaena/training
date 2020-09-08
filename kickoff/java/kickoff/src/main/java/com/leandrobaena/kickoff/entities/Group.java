package com.leandrobaena.kickoff.entities;

/**
 * Grupo de equipos dentro de un torneo
 *
 * @author Leandro Baena Torres
 */
public class Group {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Constructor por defecto del grupo
     */
    public Group() {
        idGroup = 0;
        name = "";
        tournament = new Tournament();
    }

    /**
     * Crea un nuevo grupo con el identificador, nombre y torneo determinado
     *
     * @param idGroup Identificador del grupo
     * @param name Nombre del grupo
     * @param tournament Torneo al que pertenece el grupo
     */
    public Group(int idGroup, String name, Tournament tournament) {
        this.idGroup = idGroup;
        this.name = name;
        this.tournament = tournament;
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el identificador del grupo
     *
     * @return Identificador del grupo
     */
    public int getIdGroup() {
        return idGroup;
    }

    /**
     * Cambia el identificador del grupo
     *
     * @param idGroup Nuevo identificador del grupo
     */
    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    /**
     * Trae el nombre del grupo
     *
     * @return Nombre del grupo
     */
    public String getName() {
        return name;
    }

    /**
     * Cambia el nombre del grupo
     *
     * @param name Nuevo nombre del grupo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Trae el torneo al que pertenece el grupo
     *
     * @return Torneo al que pertenece el grupo
     */
    public Tournament getTournament() {
        return tournament;
    }

    /**
     * Cambia el torneo al que pertenece el grupo
     *
     * @param tournament Nuevo torneo al que pertenece el grupo
     */
    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Identificador del grupo
     */
    private int idGroup;

    /**
     * Nombre del grupo
     */
    private String name;

    /**
     * Torneo al qu pertenece el grupo
     */
    private Tournament tournament;
    //</editor-fold>
}
