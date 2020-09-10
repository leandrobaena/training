package com.leandrobaena.kickoff.entities;

/**
 * Tabla de posiciones de los equipos de un grupo en un torneo
 *
 * @author Leandro Baena Torres
 */
public class Position {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Constuctor por defecto
     */
    public Position() {
        idPosition = 0;
        group = new Group();
        team = new Team();
        win = 0;
        draw = 0;
        lost = 0;
        goalFor = 0;
        goalAgainst = 0;
    }

    /**
     * Crea una tabla de posiciones con el identificador, grupo, equipo,
     * partidos ganados, empatados, perdidos, goles a favor y en contra
     *
     * @param idPosition
     * @param group
     * @param team
     */
    public Position(int idPosition, Group group, Team team, int win, int draw, int lost, int goalsFor, int goalsAgainst) {
        this.idPosition = idPosition;
        this.group = group;
        this.team = team;
        this.win = win;
        this.draw = draw;
        this.lost = lost;
        this.goalFor = goalsFor;
        this.goalAgainst = goalsAgainst;
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el identificador de la posición del equipo en el grupo
     *
     * @return Identificador de la posición del equipo en el grupo
     */
    public int getIdPosition() {
        return idPosition;
    }

    /**
     * Cambia el identificador de la posición del equipo en el grupo
     *
     * @param idPosition Nuevo identificador de la posición del equipo en el
     * grupo
     */
    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    /**
     * Trae el grupo del equipo en el que tiene una posición
     *
     * @return Grupo del equipo en el que tiene una posición
     */
    public Group getGroup() {
        return group;
    }

    /**
     * Cambia el grupo del equipo en el que tiene una posición
     *
     * @param group Nuevo grupo del equipo en el que tiene una posición
     */
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * Trae el equipo que pertenece a un grupo y tiene una posición
     *
     * @return Equipo que pertenece a un grupo y tiene una posición
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Cambia el equipo que pertenece a un grupo y tiene una posición
     *
     * @param team Nuevo equipo que pertenece a un grupo y tiene una posición
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * Trae el número de partidos ganados
     *
     * @return Número de partidos ganados
     */
    public int getWin() {
        return win;
    }

    /**
     * Cambia el número de partidos ganados
     *
     * @param win Nuevo número de partidos ganados
     */
    public void setWin(int win) {
        this.win = win;
    }

    /**
     * Trae el número de partidos empatados
     *
     * @return Número de partidos empatados
     */
    public int getDraw() {
        return draw;
    }

    /**
     * Cambia el número de partidos empatados
     *
     * @param draw Nuevo número de partidos empatados
     */
    public void setDraw(int draw) {
        this.draw = draw;
    }

    /**
     * Trae el número de partidos perdidos
     *
     * @return Número de partidos perdidos
     */
    public int getLost() {
        return lost;
    }

    /**
     * Cambia el número de partidos perdidos
     *
     * @param lost Nuevo número de partidos perdidos
     */
    public void setLost(int lost) {
        this.lost = lost;
    }

    /**
     * Trae el número de goles a favor
     *
     * @return Número de goles a favor
     */
    public int getGoalFor() {
        return goalFor;
    }

    /**
     * Cambie el número de goles a favor
     *
     * @param goalsFor Nuevo número de goles a favor
     */
    public void setGoalFor(int goalsFor) {
        this.goalFor = goalsFor;
    }

    /**
     * Trae el número de goles en contra
     *
     * @return Número de goles en contra
     */
    public int getGoalAgainst() {
        return goalAgainst;
    }

    /**
     * Cambia el número de goles en contra
     *
     * @param goalsAgainst Nuevo número de goles en contra
     */
    public void setGoalAgainst(int goalsAgainst) {
        this.goalAgainst = goalsAgainst;
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    private int idPosition;

    /**
     * Grupo al que pertenece la posicion del equipo
     */
    private Group group;

    /**
     * Equipo que ocupa la posición en el grupo
     */
    private Team team;

    /**
     * Número de partidos ganados
     */
    private int win;

    /**
     * Número de partidos empatados
     */
    private int draw;

    /**
     * Número de partidos empatados
     */
    private int lost;

    /**
     * Goles a favor
     */
    private int goalFor;

    /**
     * Goles en contra
     */
    private int goalAgainst;
    //</editor-fold>
}
