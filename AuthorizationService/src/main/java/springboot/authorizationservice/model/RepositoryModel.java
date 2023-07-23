package springboot.authorizationservice.model;

import springboot.authorizationservice.repository.Authorities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RepositoryModel {
    private static Map<String, String> allUsers = new HashMap<>();
    private static Map<String, ArrayList<Authorities>> authorities = new HashMap<>();
    private static RepositoryModel userRepository = null;

    private RepositoryModel() {
        allUsers.put("qwer", "123");
        allUsers.put("asd", "123");
        allUsers.put("rrrr", "123");
        ArrayList<Authorities> list = new ArrayList<>();
        list.add(Authorities.READ);
        list.add(Authorities.WRITE);
        list.add(Authorities.DELETE);
        authorities.put("qwer", list);
        list.clear();
        list.add(Authorities.READ);
        list.add(Authorities.WRITE);
        authorities.put("asd", list);
        list.clear();
        list.add(Authorities.READ);
        authorities.put("rrrr", list);
        list.clear();
    }

    public Map<String, String> getAllUsers() {
        return allUsers;
    }

    public  Map<String, ArrayList<Authorities>> getAuthorities() {
        return authorities;
    }
}
