package com.leandrobaena.kickoff.entities;

/**
 * Resultado de un partido
 *
 * @author Leandro Baena Torres
 */
public class Result {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Constructor por defecto
     */
    public Result() {
        idResult = 0;
        fixture = new Fixture();
        goalHome = 0;
        goalAway = 0;
        penaltyHome = 0;
        penaltyAway = 0;
    }

    /**
     * Crea un equipo con los datos determinados
     *
     * @param idResult Identificador del resultado
     * @param fixture Fecha de la cual es resultado
     * @param goalHome Goles del local
     * @param goalAway Goles del visitante
     * @param penaltyHome Penaltis convertidos por el local si es el caso
     * @param penaltyAway Penaltis convertidos por el visitante si es el caso
     */
    public Result(int idResult, Fixture fixture, int goalHome, int goalAway, int penaltyHome, int penaltyAway) {
        this.idResult = idResult;
        this.fixture = fixture;
        this.goalHome = goalHome;
        this.goalAway = goalAway;
        this.penaltyHome = penaltyHome;
        this.penaltyAway = penaltyAway;
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el identificador del resultado
     *
     * @return Identificador del resultado
     */
    public int getIdResult() {
        return idResult;
    }

    /**
     * Cambia el identificador del resultado
     *
     * @param idResult Nuevo identificador del resultado
     */
    public void setIdTeam(int idResult) {
        this.idResult = idResult;
    }

    /**
     * Trae la fecha a la que pertenece el resultado
     *
     * @return Fecha a la que pertenece el resultado
     */
    public Fixture getFixture() {
        return fixture;
    }

    /**
     * Cambia la fecha a la que pertenece el resultado
     *
     * @param fixture Nueva fecha a la que pertenece el resultado
     */
    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }

    /**
     * Trae los goles del local
     *
     * @return Goles del local
     */
    public int getGoalHome() {
        return goalHome;
    }

    /**
     * Cambia los goles del local
     *
     * @param goalHome Nuevos goles del local
     */
    public void setGoalHome(int goalHome) {
        this.goalHome = goalHome;
    }

    /**
     * Trael los goles del visitante
     *
     * @return Goles del visitante
     */
    public int getGoalAway() {
        return goalAway;
    }

    /**
     * Cambia los goles del visitante
     *
     * @param goalAway Nuevos goles del visitante
     */
    public void setGoalAway(int goalAway) {
        this.goalAway = goalAway;
    }

    /**
     * Trae los penaltis convertidos por el local si es el caso
     *
     * @return Penaltis convertidos por el local si es el caso
     */
    public int getPenaltyHome() {
        return penaltyHome;
    }

    /**
     * Cambia los penaltis convertidos por el local si es el caso
     *
     * @param penaltyHome Nuevos penaltis convertidos por el local si es el caso
     */
    public void setPenaltyHome(int penaltyHome) {
        this.penaltyHome = penaltyHome;
    }

    /**
     * Trae los penaltis convertidos por el visitante si es el caso
     *
     * @return Penaltis convertidos por el visitante si es el caso
     */
    public int getPenaltyAway() {
        return penaltyAway;
    }

    /**
     * Cambia los penaltis convertidos por el visitante si es el caso
     *
     * @param penaltyAway Nuevos penaltis convertidos por el visitante si es el
     * caso
     */
    public void setPenaltyAway(int penaltyAway) {
        this.penaltyAway = penaltyAway;
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Identificador del resultado
     */
    private int idResult;

    /**
     * Fecha de la cual es el resultado
     */
    private Fixture fixture;

    /**
     * Goles anotados por el local
     */
    private int goalHome;

    /**
     * Goles anotados por el visitante
     */
    private int goalAway;

    /**
     * Penaltis anotados por el local si es el caso
     */
    private int penaltyHome;

    /**
     * Penaltis anotados por el visitante si es el caso
     */
    private int penaltyAway;
    //</editor-fold>
}
