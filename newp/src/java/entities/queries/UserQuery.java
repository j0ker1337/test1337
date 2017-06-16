/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.queries;

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
public class UserQuery extends Query {

    /*@Override
    public User fill(ResultSet rs) {
        int i = 0;
        User x = new User();
        ArrayList<Friends> request = new ArrayList<Friends>();
        ArrayList<Friends> pending = new ArrayList<>();
        try {
            while (rs.next()) {
                i = 0;
                x.setId(rs.getLong("u.id"));
                x.setName(rs.getString("u.name"));
                User y = new User();
                if (rs.getLong("f.id") != 0) {
                    y.setId(rs.getLong("f.id"));
                    y.setName(rs.getString("f.name"));
                }
                request.add(new Friends(x, y));
                while (rs.next()) {
                    User k = new User();
                    if (rs.getLong("f.id") != 0) {
                        k.setId(rs.getLong("f.id"));
                        k.setName(rs.getString("f.name"));
                    }
                    request.add(new Friends(x, k));
                }
            }
            x.setFriendrequest(request);

        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
     */
    public Query delete(User u) {
        setQuery("delete from user where id=?");
        add(1, u.getId());
        return this;
    }

    public Query update(User u) {
        setQuery("update user set name=? where id=?");
        add(1, u.getName());
        add(2, u.getId());
        return this;
    }

    public Query create(User u) {
        setQuery("insert into user (name) values(?)");
        add(1, u.getName());
        return this;
    }



    public Query find(User u) {
        setQuery("select * from user where id=?");
        add(1, u.getId());
        return this;
    }

    @Override
    public User fillCreate(ResultSet rs) {
        User x = new User();
        try {
            while (rs.next()) {
                x.setId(rs.getLong(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    @Override
    public ArrayList<Identity> fillAll(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User fill(ResultSet rs) {
        User x = new User();
        try {
            while (rs.next()) {
                x.setId(rs.getLong("id"));
                x.setName(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;

    }
}
