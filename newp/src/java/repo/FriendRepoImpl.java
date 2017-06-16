/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import entities.Friends;
import entities.User;
import entities.queries.FriendsQuery;
import java.util.ArrayList;

/**
 *
 * @author joker
 */
public class FriendRepoImpl extends Repo implements FriendRepo {

    private FriendsQuery friendsQuery;
    public FriendRepoImpl() {
           this.friendsQuery=new FriendsQuery();
    }

    @Override
    public ArrayList<Friends> findRequests(User user) {
        return (ArrayList<Friends>)(ArrayList<?>)findBy(friendsQuery.findMyFriendRequests(user));
    }

    @Override
    public ArrayList<Friends> findFriendPending(User user) {
        return (ArrayList<Friends>)(ArrayList<?>)findBy(friendsQuery.findMyFriendRequestsPending(user));
    }

    @Override
    public Friends findFriendShip(User user, User friend) {
        return (Friends) findBy(friendsQuery.find(user, friend)).get(0);
    }

    @Override
    public boolean deleteFriendShip(User user, User friend) {
        return delete(friendsQuery.delete(user, friend));
    }

    @Override
    public Friends create(User user, User friend) {
        return (Friends) create(friendsQuery.create(user, friend));
    }

    @Override
    public ArrayList<Friends> findFriends(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
