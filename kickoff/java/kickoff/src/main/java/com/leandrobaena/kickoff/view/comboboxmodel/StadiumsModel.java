package com.leandrobaena.kickoff.view.comboboxmodel;

import com.leandrobaena.kickoff.entities.Stadium;
import com.leandrobaena.kickoff.logic.StadiumMgr;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

/**
 * Modelo para el listado de todos los estadios
 *
 * @author Leandro Baena Torres
 */
public class StadiumsModel extends AbstractListModel implements ComboBoxModel {

    //<editor-fold desc="Constructores" defaultstate="collapsed">
    /**
     * Crea un modelo de combobox para el listado de estadios
     */
    public StadiumsModel() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("settings_db.properties"));
            stadiumMgr = new StadiumMgr(properties);
            this.stadiums = stadiumMgr.list();
        } catch (IOException | SQLException ex) {
            this.stadiums = new ArrayList<>();
            JOptionPane.showMessageDialog(null, "Hubo un error al traer el listado de estadios");
        }
    }
    //</editor-fold>

    //<editor-fold desc="Métodos" defaultstate="collapsed">
    /**
     * Retorna el estadio seleccionado
     *
     * @return Estadio seleccionado
     */
    @Override
    public Stadium getSelectedItem() {
        return selected;
    }

    /**
     * Retorna el número de elementos del combobox
     *
     * @return Número de elementos del combobox
     */
    @Override
    public int getSize() {
        return stadiums.size();
    }

    /**
     * Trae un elemento del combobox en una posición determinada
     *
     * @param i Posición del elemento
     * @return Elemento del combobox en la posición determinada
     */
    @Override
    public Stadium getElementAt(int i) {
        return stadiums.get(i);
    }

    /**
     * Determina el estadio seleccionado
     *
     * @param stadium Estadio a seleccionar
     */
    @Override
    public void setSelectedItem(Object stadium) {
        selected = (Stadium) stadium;
    }

    /**
     * Determina el estadio seleccionado
     *
     * @param stadium Estadio a seleccionar
     */
    public void setSelectedItem(Stadium stadium) {
        selected = stadium;
    }
    //</editor-fold>

    //<editor-fold desc="Atributos" defaultstate="collapsed">
    /**
     * Listado de estadios
     */
    private ArrayList<Stadium> stadiums;

    /**
     * Estadio seleccionado en el combo
     */
    private Stadium selected;

    /**
     * Administrador de estadio
     */
    private StadiumMgr stadiumMgr;
    //</editor-fold>
}
