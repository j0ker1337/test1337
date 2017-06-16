/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.queries;

import entities.Identity;
import entities.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author joker
 */
public abstract class Query {

    private String query;
    private HashMap<Integer, Object> args;

    public Query() {
        this.args = new HashMap<>();
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public HashMap<Integer, Object> getArgs() {
        return args;
    }

    public void setArgs(HashMap<Integer, Object> args) {
        this.args = args;
    }

    public void add(int x, Object l) {
        
        this.args.put(x, l);
    }

    public void clear(){
        this.args=new HashMap<>();
    }
    public abstract Identity fill(ResultSet rs);

    public abstract ArrayList<Identity> fillAll(ResultSet rs);

    public abstract User fillCreate(ResultSet rs);
}
