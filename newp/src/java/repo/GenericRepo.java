/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import entities.queries.Query;
import java.util.ArrayList;

/**
 *
 * @author joker
 * @param <Identity>
 */
 interface GenericRepo<Identity> {
    Identity find(Query q);
    ArrayList<Identity>findAll(Query q);
    boolean delete(Query q);
    boolean update(Query q);
    Identity create(Query q);
    ArrayList<Identity> findBy(Query query);

           
}
