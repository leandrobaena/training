package com.leandrobaena.kickoff.entities;

/**
 * Estadio donde se juega un encuentro deportivo
 *
 * @author Leandro Baena Torres
 */
public class Stadium {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Constructor por defecto del estadio
     */
    public Stadium() {
        idStadium = 0;
        name = "";
    }

    /**
     * Crea un estadio con un identificador y un nombre determinado
     *
     * @param idStadium Identificador del estadio
     * @param name Nombre del estadio
     */
    public Stadium(int idStadium, String name) {
        this.idStadium = idStadium;
        this.name = name;
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el identificador del estadio
     *
     * @return Identificador del estadio
     */
    public int getIdStadium() {
        return idStadium;
    }

    /**
     * Cambia el identificador del estadio
     *
     * @param idStadium Nuevo identificador del estadio
     */
    public void setIdStadium(int idStadium) {
        this.idStadium = idStadium;
    }

    /**
     * Trae el nombre del estadio
     *
     * @return Nombre del estadio
     */
    public String getName() {
        return name;
    }

    /**
     * Cambia el nombre del estadio
     *
     * @param name Nuevo nombre del estadio
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna el nombre del estadio
     *
     * @return Nombre del estadio
     */
    @Override
    public String toString() {
        return name;
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Identificador del estadio
     */
    private int idStadium;

    /**
     * Nombre del estadio
     */
    private String name;
    //</editor-fold>
}
