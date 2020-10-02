package com.leandrobaena.kickoff.entities;

/**
 * Equipo al que pertenecen varios jugadores y que compite en un torneo
 *
 * @author Leandro Baena Torres
 */
public class Team {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Constructor por defecto
     */
    public Team() {
        idTeam = 0;
        name = "";
    }

    /**
     * Crea un equipo con un identificador y nombre determinado
     *
     * @param idTeam Identificador del equipo
     * @param name Nombre del equipo
     */
    public Team(int idTeam, String name) {
        this.idTeam = idTeam;
        this.name = name;
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el identificador del equipo
     *
     * @return Identificador del equipo
     */
    public int getIdTeam() {
        return idTeam;
    }

    /**
     * Cambia el identificador del equipo
     *
     * @param idTeam Nuevo identificador del equipo
     */
    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    /**
     * Trae el nombre del equipo
     *
     * @return Nombre del equipo
     */
    public String getName() {
        return name;
    }

    /**
     * Cambia el nombre del equipo
     *
     * @param name Nuevo nombre del equipo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Muestra el nombre del equipo cuando el objeto se trata de mostrar como
     * una cadena de texto
     *
     * @return Nombre del equipo
     */
    public String toString() {
        return name;
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Identificador del equipo
     */
    private int idTeam;

    /**
     * Nombre del equipo
     */
    private String name;
    //</editor-fold>
}
