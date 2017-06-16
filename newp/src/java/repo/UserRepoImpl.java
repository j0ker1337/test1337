/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import entities.User;
import entities.queries.UserQuery;

/**
 *
 * @author joker
 */
public class UserRepoImpl extends Repo implements UserRepo{

    private UserQuery userQuery;
    
    public UserRepoImpl(){
        userQuery= new UserQuery();
    }

    @Override
    public User find(User u) {
        return (User) super.find(userQuery.find(u));
    }

    @Override
    public User update(User u) {
       super.update(userQuery.update(u));
       return find(u);
    }

    @Override
    public User create(User u) {
        return find((User)super.create(userQuery.create(u)));
    }
    
    
 
}
