/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import entities.User;

/**
 *
 * @author joker
 */
public interface UserRepo {

    User find(User u);

    User update(User u);
    
    User create(User u);
}
