package com.leandrobaena.kickoff.view.tablemodel;

import com.leandrobaena.kickoff.entities.Stadium;
import com.leandrobaena.kickoff.logic.StadiumMgr;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.table.DefaultTableModel;

/**
 * Modelo de la table de estadios
 *
 * @author Leandro Baena Torres
 */
public class ListStadiumTableModel extends DefaultTableModel {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un modelo de tabla para el listado de estadios
     *
     * @throws IOException Si no puede leer el archivo de propiedades
     * @throws FileNotFoundException Si no encuentra el archivo de propiedades
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    private ListStadiumTableModel() throws FileNotFoundException, IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("settings_db.properties"));
        stadiumMgr = new StadiumMgr(properties);
        update();
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Trae la única instancia de esta clase
     *
     * @return Única instancia de esta clase
     */
    public static ListStadiumTableModel getInstance() {
        if (instance == null) {
            try {
                instance = new ListStadiumTableModel();
            } catch (IOException | SQLException ex) {
                return null;
            }
        }
        return instance;
    }

    /**
     * Trae el estadio seleccionado
     *
     * @param row Fila seleccionada
     * @return Estadio seleccionado
     */
    public Stadium getSelectedStadium(int row) {
        return stadiums.get(row);
    }

    /**
     * Trae el número de filas de la tabla
     *
     * @return Número de filas de la tabla
     */
    @Override
    public int getRowCount() {
        return stadiums != null ? stadiums.size() : 0;
    }

    /**
     * Trae el número de columnas de la tabla
     *
     * @return Número de columnas de la tabla
     */
    @Override
    public int getColumnCount() {
        return 2;
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
                stadiums.get(row).getIdStadium();
            case 1 ->
                stadiums.get(row).getName();
            default ->
                "";
        };
    }

    /**
     * Inserta un estadio
     *
     * @param stadium Estadio a insertar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void insertStadium(Stadium stadium) throws SQLException {
        stadiumMgr.insert(stadium);
        update();
    }

    /**
     * Actualiza un estadio
     *
     * @param stadium Estadio a actualizar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void updateStadium(Stadium stadium) throws SQLException {
        stadiumMgr.update(stadium);
        update();
    }

    /**
     * Elimina un estadio en una ubicación determinada
     *
     * @param index Ubicación del estadio a eliminar
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    public void deleteStadium(int index) throws SQLException {
        stadiumMgr.delete(stadiums.get(index));
        update();
    }

    /**
     * Actualiza el listado de estadios
     *
     * @throws SQLException Si hay un error en la conexión a la base de datos
     */
    private void update() throws SQLException {
        this.stadiums = stadiumMgr.list();
        this.fireTableDataChanged();
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Listado de estadios
     */
    private ArrayList<Stadium> stadiums;

    /**
     * Única instancia del modelo de la tabla de estadios
     */
    private static ListStadiumTableModel instance = null;

    /**
     * Administrador de los estadios
     */
    private final StadiumMgr stadiumMgr;
    //</editor-fold>
}
