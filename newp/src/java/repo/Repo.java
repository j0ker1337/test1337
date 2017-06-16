/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import connection.DBverbindung;
import entities.Identity;
import entities.queries.Query;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joker
 */
class Repo implements GenericRepo<Identity> {

    @Override
    public Identity find(Query i) {
        PreparedStatement x = null;
        Identity y = null;
        try {
            x = DBverbindung.getConnection().prepareStatement(i.getQuery());
            int j=1;
            for (Object k : i.getArgs().values()) {
                x.setObject(j, k);
                j++;
            }
            x.executeQuery();

            y = i.fill(x.executeQuery());
            i.clear();
        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
        }
        i.clear();
        return y;
    }

    @Override
    public ArrayList<Identity> findAll(Query i) {
        ArrayList<Identity> a = null;
        try {
            PreparedStatement x = DBverbindung.getConnection().prepareStatement(i.getQuery());
            x.executeQuery();
            a = i.fillAll(x.executeQuery());
            x.close();
            i.clear();
        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
        }
        i.clear();
        return a;
    }

    @Override
    synchronized public boolean delete(Query i) {
        boolean x = true;
        try {
            PreparedStatement preparedStatement = DBverbindung.getConnection().prepareStatement(i.getQuery());
            int j = 1;
            for (Object k : i.getArgs().values()) {
                preparedStatement.setObject(j, k);
                j++;
            }
            preparedStatement.execute();
            i.clear();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
            i.clear();
            return false;

        }
    }

    @Override
   synchronized public boolean update(Query i) {
        try {
            PreparedStatement preparedStatement = DBverbindung.getConnection().prepareStatement(i.getQuery());
            int j = 1;
            for (Object k : i.getArgs().values()) {
                preparedStatement.setObject(j, k);
                j++;
            }
            preparedStatement.executeUpdate();
            i.clear();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
            i.clear();
            return false;
        }
    }

    @Override
    public ArrayList<Identity> findBy(Query query) {
        ArrayList<Identity> identitys = new ArrayList<Identity>();
        try {
            PreparedStatement preparedStatement = DBverbindung.getConnection().prepareStatement(query.getQuery());
            int j = 1;
            for (Object k : query.getArgs().values()) {
                preparedStatement.setObject(j, k);
                j++;
            }
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                identitys.add(query.fill(rs));
            }
            query.clear();
        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
        }
        query.clear();
        return identitys;
    }

    @Override
    synchronized public Identity create(Query i) {
        try {
            PreparedStatement preparedStatement = DBverbindung.getConnection().prepareStatement(i.getQuery(), Statement.RETURN_GENERATED_KEYS);
            int j = 1;
            for (Object k : i.getArgs().values()) {
                preparedStatement.setObject(j, k);
                j++;
            }
            preparedStatement.executeUpdate();
            i.clear();
            return i.fillCreate(preparedStatement.getGeneratedKeys());
        } catch (SQLException ex) {
            Logger.getLogger(Repo.class.getName()).log(Level.SEVERE, null, ex);
        }
        i.clear();
        return null;
    }

}
