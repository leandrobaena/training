package com.leandrobaena.kickoff.view.tablemodel;

import com.leandrobaena.kickoff.entities.Fixture;
import com.leandrobaena.kickoff.entities.Group;
import com.leandrobaena.kickoff.logic.FixtureMgr;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Modelo de la tabla de fechas de juego entre equipos de un grupo de un torneo
 *
 * @author Leandro Baena Torres
 */
public class ListFixtureTableModel extends DefaultTableModel {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un modelo de tabla para el listado de fechas de juegos de equipos de
     * un grupo
     *
     * @param group Grupo al que pertenecen las fechas
     */
    public ListFixtureTableModel(Group group) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("settings_db.properties"));
            fixtureMgr = new FixtureMgr(properties);
            this.group = group;
            update();
        } catch (IOException | SQLException | ParseException ex) {
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
        return fixtures != null ? fixtures.size() : 0;
    }

    /**
     * Trae el número de columnas de la tabla
     *
     * @return Número de columnas de la tabla
     */
    @Override
    public int getColumnCount() {
        return 6;
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
                "Local";
            case 3 ->
                "Visitante";
            case 4 ->
                "Fecha";
            case 5 ->
                "Estadio";
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return switch (col) {
            case 0 ->
                fixtures.get(row).getIdFixture();
            case 1 ->
                fixtures.get(row).getName();
            case 2 ->
                fixtures.get(row).getHome().getName();
            case 3 ->
                fixtures.get(row).getAway().getName();
            case 4 ->
                sdf.format(fixtures.get(row).getDate());
            case 5 ->
                fixtures.get(row).getStadium().getName();
            default ->
                "";
        };
    }

    /**
     * Trae la fecha seleccionado
     *
     * @param row Fila seleccionada
     * @return Grupo seleccionado
     */
    public Fixture getSelectedFixture(int row) {
        return fixtures.get(row);
    }

    /**
     * Inserta una fecha
     *
     * @param fixture Fecha a insertar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void insertFixture(Fixture fixture) throws SQLException, ParseException {
        fixtureMgr.insert(fixture);
        update();
    }

    /**
     * Actualiza una fecha
     *
     * @param fixture Fecha a actualizar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void updateFixture(Fixture fixture) throws SQLException, ParseException {
        fixtureMgr.update(fixture);
        update();
    }

    /**
     * Elimina una fecha en una ubicación determinada
     *
     * @param index Ubicación de la fecha a eliminar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void deleteFixture(int index) throws SQLException, ParseException {
        fixtureMgr.delete(fixtures.get(index));
        update();
    }

    /**
     * Actualiza el listado de fecha de un grupo
     *
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    private void update() throws SQLException, ParseException {
        this.fixtures = fixtureMgr.list(group);
        this.fireTableDataChanged();
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Listado de fechas de un grupo
     */
    private ArrayList<Fixture> fixtures;

    /**
     * Administrador de fechas
     */
    private FixtureMgr fixtureMgr;

    /**
     * Grupo al que pertenecen las fechas
     */
    private Group group;
    //</editor-fold>
}
