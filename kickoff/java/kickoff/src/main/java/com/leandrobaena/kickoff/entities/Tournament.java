package com.leandrobaena.kickoff.entities;

/**
 * Torneo en el que participan varios equipos
 *
 * @author Leandro Baena Torres
 */
public class Tournament {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Constructor por defecto del torneo
     */
    public Tournament() {
        idTournament = 0;
        name = "";
    }

    /**
     * Crea un torneo con un identificador y nombre determinado
     *
     * @param idTournament Identificador del torneo
     * @param name Nombre del torneo
     */
    public Tournament(int idTournament, String name) {
        this.idTournament = idTournament;
        this.name = name;
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el identificador del torneo
     *
     * @return Identificador del torneo
     */
    public int getIdTournament() {
        return idTournament;
    }

    /**
     * Cambia el identificador del torneo
     *
     * @param idTournament Nuevo identificador del torneo
     */
    public void setIdTournament(int idTournament) {
        this.idTournament = idTournament;
    }

    /**
     * Trae el nombre del torneo
     *
     * @return Nombre del torneo
     */
    public String getName() {
        return name;
    }

    /**
     * Cambia el nombre del torneo
     *
     * @param name Nuevo nombre del torneo
     */
    public void setName(String name) {
        this.name = name;
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Identificador del torneo
     */
    private int idTournament;

    /**
     * Nombre del torneo
     */
    private String name;
    //</editor-fold>
}
