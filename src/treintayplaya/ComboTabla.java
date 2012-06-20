/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import sun.font.Font2D;

/**
 *
 * @author administrador
 */
public class ComboTabla extends JComboBox {
    ArrayList<Integer> ids = new ArrayList<Integer>();
    ArrayList<Integer> especialIndexes = new ArrayList<Integer>();
    public ComboTabla() {
        super();
        super.setRenderer(new ComboTablaRenderer());
    }
    
    public void addItem(Object item, Integer id, boolean especial){
        super.addItem(item);
        ids.add(id);
        if (especial){
            especialIndexes.add(getItemCount()-1);
        }
    }
    
    public void addItem(Object item, Integer id){
        addItem(item, id, false);
    }
    
    public void addItem(Object item, boolean especial){
        addItem(item, 0, especial);
    }
    
    @Override
    public void addItem(Object item){
        addItem(item, 0);
    }
    
    public void removeItemAt(Integer index){
        super.removeItemAt(index);
        ids.remove(index);
        if (especialIndexes.contains(index)){
            especialIndexes.remove(especialIndexes.indexOf(index)); 
        }
    }
    public Integer getSelectedId(){
        int selectedIndex = this.getSelectedIndex();
        if (selectedIndex < 0) return 0;
        if (ids.isEmpty() || ids.size() <= selectedIndex)
            return 0;
        return ids.get(selectedIndex);
    }
    
    public void setSelectedItemById(Integer id){
        if (! especialIndexes.contains(ids.indexOf(id)))
            super.setSelectedIndex(ids.indexOf(id));
    }
    
    @Override
    public void setSelectedIndex(int index){
        if (! especialIndexes.contains(index))
            super.setSelectedIndex(index);
    }
    
    public int getIdCount(){
        return ids.size();
    }
    
    @Override
    public void removeAllItems(){
        super.removeAllItems();
        ids.clear();
        especialIndexes.clear();
    }
    
    public boolean isItemAfterEspecial(int especial){
        //Devuelve si un index esta despues de un item especial
        if(especialIndexes.size() <= especial)
            return false;
        int index = getSelectedIndex();
        int especialIndex = especialIndexes.get(especial);
        return especialIndex <= index;
    }

    boolean isItemBeforeEspecial(int especial) {
       if(especialIndexes.size() <= especial)
            return false;
        int index = getSelectedIndex();
        int especialIndex = especialIndexes.get(especial);
        return especialIndex > index;
    }
    
    private class ComboTablaRenderer extends BasicComboBoxRenderer {

        public Component getListCellRendererComponent(JList list,
                                                    Object value,
                                                    int index,
                                                    boolean isSelected,
                                                    boolean cellHasFocus){
            Font font;
            if (especialIndexes.contains(index)){
                setForeground(Color.red);
                setBackground(list.getBackground());
                font = new Font(list.getFont().getFontName(), Font.BOLD, list.getFont().getSize());
            }else{
                font = list.getFont();
                if (isSelected) {
                    setBackground(list.getSelectionBackground());
                    setForeground(list.getSelectionForeground());
                } else {
                    setBackground(list.getBackground());
                    setForeground(list.getForeground());
                }
            }
            setFont(font);
            setText(value == null ? "": value.toString());
            return this;
        }
    
    }

}
