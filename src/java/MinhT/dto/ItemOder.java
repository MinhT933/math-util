/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinhT.dto;

import MinhT.dto.Phone;

/**
 *
 * @author MinhT
 */
public class ItemOder{
    String oderDetailID;
    Phone name;
    int quanlity;
    long price;

    public ItemOder(String oderDetailID, Phone name, int quanlity, long price) {
        this.oderDetailID = oderDetailID;
        this.name = name;
        this.quanlity = quanlity;
        this.price = price;
    }

    public String getOderDetailID() {
        return oderDetailID;
    }

    public void setOderDetailID(String oderDetailID) {
        this.oderDetailID = oderDetailID;
    }

    public Phone getName() {
        return name;
    }

    public void setName(Phone name) {
        this.name = name;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
    
    
}
