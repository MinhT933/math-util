/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinhT.dto;

import java.util.List;

/**
 *
 * @author MinhT
 */
public class OrderDto {
    String id;
    UserDTO user;
    List<ItemOder> item;
    int status;

    public OrderDto(String id, UserDTO user, List<ItemOder> item, int status) {
        this.id = id;
        this.user = user;
        this.item = item;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<ItemOder> getItem() {
        return item;
    }

    public void setItem(List<ItemOder> item) {
        this.item = item;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
