/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import entities.Friends;
import entities.User;
import java.util.ArrayList;

/**
 *
 * @author joker
 */
public interface FriendRepo  {
    ArrayList<Friends> findRequests(User user);
    ArrayList<Friends> findFriendPending(User user);
    ArrayList<Friends> findFriends(User user);
    Friends findFriendShip(User user,User friend);
    boolean deleteFriendShip(User user,User friend);
    Friends create(User user,User friend);
}
