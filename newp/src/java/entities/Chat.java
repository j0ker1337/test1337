/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author joker
 */
public class Chat implements Identity {
}/*
    private Long id;
    private Date date;
    private Query query;

    public Chat() {
        this.query = new Query();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public Query delete() {
        this.query.setQuery("delete from chat where id=?");
        query.getArgs().put(1, id);
        return query;
    }

    @Override
    public Query update() {
        this.query.setQuery("update chat set date=? where id=?");
        query.getArgs().put(1, date);
        query.getArgs().put(2, id);
        return query;
    }

    @Override
    public Query create() {
        this.query.setQuery("insert into chat () values ()");

        return query;
    }

    @Override
    public Query find() {
        this.query.setQuery("select * from chat where id=?");
        query.getArgs().put(1, id);
        return query;
    }

    @Override
    public Query findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Identity fill(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Query getQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Identity> fillAll(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Identity fillCreate(ResultSet rs) {
        try{
        while (rs.next()) {
            id = rs.getLong(1);
        }
        }catch(SQLException ex){
            
        }
        return this;
    }

}
*/