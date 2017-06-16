/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;

public class User implements Identity {

    private Long id;
    private String name;
    private ArrayList<Friends> friendrequest;
    private ArrayList<Friends> friendpending;
    private ArrayList<Friends> friends;

    public User() {
        this.friends = new ArrayList<>();
        this.friendpending = new ArrayList<>();
        this.friendrequest = new ArrayList<>();
    }

    public User(Long id) {
        this.id = id;

        this.friends = new ArrayList<>();
        this.friendpending = new ArrayList<>();
        this.friendrequest = new ArrayList<>();
    }

    public User(User u) {
        this.id = u.getId();
        this.name = u.getName();
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
        this.friends = new ArrayList<>();
        this.friendpending = new ArrayList<>();
        this.friendrequest = new ArrayList<>();
    }

    /*  public ArrayList<Identity> fillAll(ResultSet rs) {
        int j = 0;
        int i = 0;
        try {
            ArrayList<Identity> identitys = new ArrayList<>();
            while (rs.next()) {
                ArrayList<Friends> friends = new ArrayList<Friends>();
                i = 0;
                User x = new User();
                x.setId(rs.getLong("uid"));
                x.setName(rs.getString("uname"));
                if (rs.getLong("fid") != 0) {
                    i = setUser(rs, i, x, friends);
                }
                while (rs.next()) {
                    if(rs.getLong("uid")==x.getId()){
                        i= setUser(rs, i, x, friends);
                    }
                }
                if (i == 0) {
                    i++;
                }
                x.setFriends(friends);
                identitys.add(x);
                j = j + i;
                rs.absolute(j);
            }
            return identitys;
        } catch (SQLException ex) {
            try {
                rs.close();
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return null;
    }*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", friendrequest=" + friendrequest + ", friendpending=" + friendpending + ", friends=" + friends + '}';
    }



    public void setFriends(ArrayList<Friends> friends) {
        this.friends = friends;
    }


    public ArrayList<Friends> getFriendrequest() {
        return friendrequest;
    }

    public void setFriendrequest(ArrayList<Friends> friendrequest) {
        this.friendrequest = friendrequest;
    }

    public ArrayList<Friends> getFriendpending() {
        return friendpending;
    }

    public void setFriendpending(ArrayList<Friends> friendpending) {
        this.friendpending = friendpending;
    }

    public ArrayList<Friends> getFriends() {
        return friends;
    }

}
