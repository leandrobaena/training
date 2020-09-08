package com.leandrobaena.kickoff.entities;

/**
 * Jugador de un equipo
 *
 * @author Leandro Baena Torres
 */
public class Player {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Construtor por defecto
     */
    public Player() {
        idPlayer = 0;
        name = "";
        dorsal = "0";
        team = new Team();
    }

    /**
     * Constructor de un jugador con su identificador, nombre, dorsal y equipo
     *
     * @param idPlayer Identificador del jugador
     * @param name Nombre del jugador
     * @param dorsal Dorsal del jugador
     * @param team Equipo al que pertenece el jugador
     */
    public Player(int idPlayer, String name, String dorsal, Team team) {
        this.idPlayer = idPlayer;
        this.name = name;
        this.dorsal = dorsal;
        this.team = team;
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el identificador del jugador
     *
     * @return Identificador del jugador
     */
    public int getIdPlayer() {
        return idPlayer;
    }

    /**
     * Cambia el identifcador del jugador
     *
     * @param idPlayer Nuevo identificador del jugador
     */
    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    /**
     * Trae el nombre del jugador
     *
     * @return Nombre del jugador
     */
    public String getName() {
        return name;
    }

    /**
     * Cambia el nombre del jugador
     *
     * @param name Nuevo nombre del jugador
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Trae el número con que juega el jugador
     *
     * @return Número con que juega el jugador
     */
    public String getDorsal() {
        return dorsal;
    }

    /**
     * Cambia el número con que juega el jugador
     *
     * @param dorsal Nuevo número con que juega el jugador
     */
    public void setDorsal(String dorsal) {
        this.dorsal = dorsal;
    }

    /**
     * Trae el equipo al que pertenece el jugador
     *
     * @return Equipo al que pertenece el jugador
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Cambia el equipo al que pertenece el jugador
     *
     * @param team Nuevo equipo al que pertenece el jugador
     */
    public void setTeam(Team team) {
        this.team = team;
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Identificador del jugador
     */
    private int idPlayer;

    /**
     * Nombre del jugador
     */
    private String name;

    /**
     * Número con que juega el jugador
     */
    private String dorsal;

    /**
     * Equipo al que pertenece el jugador
     */
    private Team team;
    //</editor-fold>
}
