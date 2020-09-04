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
    }

    /**
     * Constructor de un jugador con su identificador, nombre y dorsal
     *
     * @param idPlayer Identificador del jugador
     * @param name Nombre del jugador
     * @param dorsal Dorsal del jugador
     */
    public Player(int idPlayer, String name, String dorsal) {
        this.idPlayer = idPlayer;
        this.name = name;
        this.dorsal = dorsal;
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
    //</editor-fold>
}
