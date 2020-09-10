package com.leandrobaena.kickoff.entities;

/**
 * Parámetro del sistema
 *
 * @author Leandro Baena Torres
 */
public class Parameter {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Constructor por defecto
     */
    public Parameter() {
        idParameter = 0;
        name = "";
        value = "";
    }

    /**
     * Crea un parámetro del sistema con un identificador, nombre y valor
     *
     * @param idParameter Identificador del parámetro
     * @param name Nombre del parámetro
     * @param value Valor del parámetro
     */
    public Parameter(int idParameter, String name, String value) {
        this.idParameter = idParameter;
        this.name = name;
        this.value = value;
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el identificador del parámetro
     *
     * @return Identificador del parámetro
     */
    public int getIdParameter() {
        return idParameter;
    }

    /**
     * Cambia el identificador del parámetro
     *
     * @param idParameter Nuevo identificador del parámetro
     */
    public void setIdParameter(int idParameter) {
        this.idParameter = idParameter;
    }

    /**
     * Trae el nombre del parámetro
     *
     * @return Nombre del parámetro
     */
    public String getName() {
        return name;
    }

    /**
     * Cambia el nombre del parámetro
     *
     * @param name Nuevo nombre del parámetro
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Trae el valor del parámetro
     *
     * @return Valor del parámetro
     */
    public String getValue() {
        return value;
    }

    /**
     * Cambia el valor del parámetro
     *
     * @param value Nuevo valor del parámetro
     */
    public void setValue(String value) {
        this.value = value;
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Identificador del parámetro
     */
    private int idParameter;
    
    /**
     * Nombre del parámetro
     */
    private String name;
    
    /**
     * Valor del parámetro
     */
    private String value;
    //</editor-fold>
}
