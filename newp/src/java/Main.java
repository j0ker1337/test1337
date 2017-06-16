
import entities.User;
import repo.UserController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author joker
 */
public class Main {

    public static void main(String[] args) {

        UserController uc = new UserController();
        User t = uc.find(6L);
        System.err.println(t);


        /*
        User x = new User();
        x.setName("DON");
         */
    }
    /*
        UserRepo repo = new UserRepo(new Repo());
        User x = repo.findUser(16L);
        System.err.println(x.getId());
        System.err.println(x.getName());
        for (Friends a : x.getFriendpending()) {
            System.err.println(a.getFuser().getId());
            System.err.println(a.getUuser().getId());
            System.err.println("___pending___");
        }

        for (Friends a : x.getFriendrequest()) {
            System.err.println(a.getFuser().getId());
            System.err.println(a.getUuser().getId());
            System.err.println("___request___");
        }
        
           for (Friends a : x.getFriends()) {
            System.err.println(a.getFuser().getId());
            System.err.println(a.getUuser().getId());
            System.err.println("___friends___");
        }

    }
     */
}
