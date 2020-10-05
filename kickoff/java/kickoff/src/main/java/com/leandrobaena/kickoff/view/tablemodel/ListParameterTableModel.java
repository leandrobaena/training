package com.leandrobaena.kickoff.view.tablemodel;

import com.leandrobaena.kickoff.entities.Parameter;
import com.leandrobaena.kickoff.entities.Tournament;
import com.leandrobaena.kickoff.logic.ParameterMgr;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Modelo de la table de parámetros
 *
 * @author Leandro Baena Torres
 */
public class ListParameterTableModel extends DefaultTableModel {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un modelo de tabla para el listado de parámetros
     *
     * @param tournament Torneo al que pertenecen los parámetros o null si son
     * generales
     */
    public ListParameterTableModel(Tournament tournament) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("settings_db.properties"));
            parameterMgr = new ParameterMgr(properties);
            this.tournament = tournament;
            update();
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al conectar a la base de datos");
        }
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae el número de filas de la tabla
     *
     * @return Número de filas de la tabla
     */
    @Override
    public int getRowCount() {
        return parameters != null ? parameters.size() : 0;
    }

    /**
     * Trae el número de columnas de la tabla
     *
     * @return Número de columnas de la tabla
     */
    @Override
    public int getColumnCount() {
        return 3;
    }

    /**
     * Trae el encabezado de cada columna
     *
     * @param i Índice de la columna
     * @return Encabezado de cada columna
     */
    @Override
    public String getColumnName(int i) {
        return switch (i) {
            case 0 ->
                "ID";
            case 1 ->
                "Nombre";
            case 2 ->
                "Valor";
            default ->
                "";
        };
    }

    /**
     * Trae el valor de una celda
     *
     * @param row Fila
     * @param col Columna
     * @return Valor de una celda
     */
    @Override
    public Object getValueAt(int row, int col) {
        return switch (col) {
            case 0 ->
                parameters.get(row).getIdParameter();
            case 1 ->
                parameters.get(row).getName();
            case 2 ->
                parameters.get(row).getValue();
            default ->
                "";
        };
    }

    /**
     * Trae el parámetro seleccionado
     *
     * @param row Fila seleccionada
     * @return Parámetro seleccionado
     */
    public Parameter getSelectedParameter(int row) {
        return parameters.get(row);
    }

    /**
     * Inserta un parámetro
     *
     * @param parameter Parámetro a insertar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void insertParameter(Parameter parameter) throws SQLException {
        parameterMgr.insert(parameter);
        update();
    }

    /**
     * Actualiza un parámetro
     *
     * @param parameter Parámetro a actualizar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void updateParameter(Parameter parameter) throws SQLException {
        parameterMgr.update(parameter);
        update();
    }

    /**
     * Elimina un parámetro en una ubicación determinada
     *
     * @param index Ubicación del parámetro a eliminar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void deleteParameter(int index) throws SQLException {
        parameterMgr.delete(parameters.get(index));
        update();
    }

    /**
     * Actualiza el listado de parámetros
     *
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    private void update() throws SQLException {
        this.parameters = parameterMgr.list(tournament);
        this.fireTableDataChanged();
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Listado de parámetros
     */
    private ArrayList<Parameter> parameters;

    /**
     * Administrador de parámetros
     */
    private ParameterMgr parameterMgr;

    /**
     * Torneo al que pertenecen los parámetros o null si son generales
     */
    private Tournament tournament;
    //</editor-fold>
}
