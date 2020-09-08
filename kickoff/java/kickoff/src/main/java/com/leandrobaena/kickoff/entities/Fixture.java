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
        position = new Position();
        date = new Date();
        stadium = new Stadium();
    }

    /**
     * Crea un nuevo calendario de juegos con el identificador, el equipo en el
     * grupo, la fecha y el estadio donde se juega
     *
     * @param idFixture Identificador del calendario
     * @param position Posición del equipo y su grupo
     * @param date Fecha del juego
     * @param stadium Estadio donde se juega
     */
    public Fixture(int idFixture, Position position, Date date, Stadium stadium) {
        this.idFixture = idFixture;
        this.position = position;
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
     * Trae la posición del equipo en el grupo
     *
     * @return Posición del equipo en el grupo
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Cambia la posición del equipo en el grupo
     *
     * @param position Nueva posición del equipo en el grupo
     */
    public void setPosition(Position position) {
        this.position = position;
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
     * Equipo y grupo dentro del torneo
     */
    private Position position;

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
