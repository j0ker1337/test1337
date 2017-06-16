/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import entities.Friends;
import entities.User;

/**
 *
 * @author joker
 */
public class UserController {
    private UserRepo userrepo;
    private FriendRepo friendrepo;
    
    public UserController(){
        this.userrepo=new UserRepoImpl();
        this.friendrepo = new FriendRepoImpl();
    }
    
    public User find(Long id){
        User t= new User();
        t.setId(id);
        t= userrepo.find(t);
        t.setFriendpending(friendrepo.findFriendPending(t));
        t.setFriendrequest(friendrepo.findRequests(t));
        for (Friends j : t.getFriendpending()) {
            for (Friends k : t.getFriendrequest()) {
                if (j.getFuser().getId() == k.getUuser().getId() && j.getUuser().getId() == k.getFuser().getId()) {
                    t.getFriends().add(k);
                }
            }
        }
        return t;
    }
}
