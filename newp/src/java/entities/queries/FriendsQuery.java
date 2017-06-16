/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.queries;

import entities.Friends;
import entities.Identity;
import entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joker
 */
public class FriendsQuery extends Query {

    @Override
    public Friends fill(ResultSet rs) {
        Friends x = new Friends();
        try {
            x.setFuser(new User(rs.getLong("u_id")));
            x.setUuser(new User(rs.getLong("f_id")));
        } catch (SQLException ex) {
            Logger.getLogger(Friends.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    @Override
    public ArrayList<Identity> fillAll(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User fillCreate(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Query create(User user, User friend) {
        setQuery("insert into friends (u_id,f_id) values(?,?)");
        add(1, user.getId());
        add(2, friend.getId());
        return this;
    }

    public Query find(User user, User friend) {
        setQuery("select * friends where u_id=? and f_id=?");
        add(1, user.getId());
        add(2, friend.getId());
        return this;
    }

    public Query delete(User user, User friend) {
        setQuery("delete from friends where u_id=? and f_id=?");
        add(1, user.getId());
        add(2, friend.getId());
        return this;
    }

    public Query findMyFriendRequests(User u) {
        setQuery("select u.id as u_id,u.name as uname, fr.id as f_id,fr.name as fname from user u join friends f on f.u_id=u.id join user fr on f.f_id=fr.id where u.id=?");
        add(1, u.getId());
        return this;
    }

    public Query findMyFriendRequestsPending(User u) {
        setQuery("select u.id as u_id,u.name as uname, fr.id as f_id,fr.name as fname from user u join friends f on f.u_id=u.id join user fr on f.f_id=fr.id where fr.id=?");
        add(1, u.getId());
        return this;

    }
    
    public Query findMyFriends(User u) {
        setQuery("select u.id as u_id,u.name as uname, fr.id as f_id,fr.name as fname from user u join friends f on f.u_id=u.id join user fr on f.f_id=fr.id where fr.id=?");
        add(1, u.getId());
        return this;

    }
}
