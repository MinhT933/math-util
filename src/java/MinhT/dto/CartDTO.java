/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinhT.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class CartDTO implements Serializable {

    private Map<String, Integer> list;

    public Map<String, Integer> getList() {
        return list;
    }

    public void setList(Map<String, Integer> list) {
        this.list = list;
    }

    public void addItemCart(String idShoes) {
        if (this.list == null) {
            list = new HashMap<>();
        }
        int quanlity = 1;
        Set<String> listKeys = list.keySet();
        for (String key : listKeys) {
//            System.out.println("keydasda " + this.list.get(key));
// ví dụ : key 1 value 5 , key 2 value 6 , 
            if (key.equals(idShoes)) {
                quanlity = this.list.get(key) + 1;
            }
        }

        this.list.put(idShoes, quanlity);
    }

    public void removeItemCart(String idShoes) {
        Set<String> listKeys = list.keySet();
        int quanlity;
        Iterator keys = this.list.entrySet().iterator();
        while (keys.hasNext()) {
            Entry item = (Entry) keys.next();
//            String next = keys.next();
            if (item.getKey().equals(idShoes)) {
                if ((Integer)item.getValue()> 1) {
                    quanlity = (Integer)item.getValue() - 1;
//                    this.list.put((String)item.getKey(), quanlity);
                    item.setValue(quanlity);
                } else {
                    keys.remove();
                }
            }

        }
    }

}
