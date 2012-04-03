/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author administrador
 */
public class ComboTabla extends JComboBox {
    ArrayList<Integer> ids = new ArrayList<Integer>();
    public ComboTabla() {
        super();
    }
    public void addItem(Object item, Integer id){
        super.addItem(item);
        ids.add(id);
    }
    
    @Override
    public void addItem(Object item){
        addItem(item, 0);
    }
    
    public void removeItemAt(Integer index){
        super.removeItemAt(index);
        ids.remove(index);
    }
    public Integer getSelectedId(){
        return ids.get(this.getSelectedIndex());
    }
    
    public void setSelectedItemById(Integer id){
        super.setSelectedIndex(ids.indexOf(id));
    }
    
    public int getIdCount(){
        return ids.size();
    }
}
