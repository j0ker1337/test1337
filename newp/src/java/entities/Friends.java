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

public class Friends implements Identity {

    User uuser;
    User fuser;

    public Friends() {
        this.uuser = new User();
        this.fuser = new User();
    }

    public User getUuser() {
        return uuser;
    }

    public void setUuser(User uuser) {
        this.uuser = new User(uuser);
    }

     public Friends(User uuser,User fuser) {
        this.uuser = new User(uuser);
        this.fuser=new User(fuser);
    }
    
    public User getFuser() {

        return fuser;
    }

    public void setFuser(User fuser) {
        this.fuser = new User(fuser);
    }

   
    @Override
    public String toString() {
        return "Friends{" + "uuser=" + uuser + ", fuser=" + fuser + "}";
    }


}
