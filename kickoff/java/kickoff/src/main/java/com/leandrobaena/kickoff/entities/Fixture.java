package com.leandrobaena.kickoff.entities;

import java.util.Date;

/**
 * Calendario de juegos
 *
 * @author Leandro Baena Torres
 */
public class Fixture {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Constructor por defecto
     */
    public Fixture() {
        idFixture = 0;
        name = "";
        home = new Position();
        away = new Position();
        date = new Date();
        stadium = new Stadium();
    }

    /**
     * Crea un nuevo calendario de juegos con el identificador, el equipo en el
     * grupo, la fecha y el estadio donde se juega
     *
     * @param idFixture Identificador del calendario
     * @param name Nombre de la fecha del calendario
     * @param home Equipo que juega de local
     * @param away Equipo que juega de visitante
     * @param date Fecha del juego
     * @param stadium Estadio donde se juega
     */
    public Fixture(int idFixture, String name, Position home,
            Position away, Date date, Stadium stadium) {
        this.idFixture = idFixture;
        this.name = name;
        this.home = home;
        this.away = away;
        this.date = date;
        this.stadium = stadium;
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el identificador del calendario
     *
     * @return Identificador del calendario
     */
    public int getIdFixture() {
        return idFixture;
    }

    /**
     * Cambia el identificador del calendario
     *
     * @param idFixture Nuevo identificador del calendario
     */
    public void setIdFixture(int idFixture) {
        this.idFixture = idFixture;
    }

    /**
     * Trae el nombre de la fecha del calendario
     *
     * @return Nombre de la fecha del calendario
     */
    public String getName() {
        return name;
    }

    /**
     * Cambia el nombre de la fecha del calendario
     *
     * @param name Nuevo nombre de la fecha del calendario
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Trae el equipo que juega de local
     *
     * @return Equipo que juega de local
     */
    public Position getHome() {
        return home;
    }

    /**
     * Cambia el equipo que juega de local
     *
     * @param home Nuevo equipo que juega de local
     */
    public void setHome(Position home) {
        this.home = home;
    }

    /**
     * Trae el equipo que juega de visitante
     *
     * @return Equipo que juega de visitante
     */
    public Position getAway() {
        return away;
    }

    /**
     * Cambia el equipo que juega de visitante
     *
     * @param away Nuevo equipo que juega de visitante
     */
    public void setAway(Position away) {
        this.away = away;
    }

    /**
     * Trae la fecha del juego
     *
     * @return Fecha del juego
     */
    public Date getDate() {
        return date;
    }

    /**
     * Cambia la fecha del juego
     *
     * @param date Nueva fecha del juego
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Trae el estadio donde se realiza el juego
     *
     * @return Estadio donde se realiza el juego
     */
    public Stadium getStadium() {
        return stadium;
    }

    /**
     * Cambia el estadio donde se realiza el juego
     *
     * @param stadium Nuevo estadio donde se realiza el juego
     */
    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Identificador del calendario
     */
    private int idFixture;

    /**
     * Nombre de la fecha dentro del calendario
     */
    private String name;

    /**
     * Equipo dentro del grupo y del torneo que juega de local
     */
    private Position home;

    /**
     * Equipo dentro del grupo y del torneo que juega de visitante
     */
    private Position away;

    /**
     * Fecha del juego
     */
    private Date date;

    /**
     * Estadio donde se realiza el juego
     */
    private Stadium stadium;
    //</editor-fold>
}
