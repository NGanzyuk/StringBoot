package springboot.authorizationservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private static Map<String, String> allUsers = new HashMap<>();
    private static Map<String, ArrayList<Authorities>> authorities = new HashMap<>();
    private static UserRepository userRepository = null;
    private UserRepository(Map<String, String> allUsers, Map<String, ArrayList<Authorities>> authorities){
        this.allUsers = allUsers;
        this.authorities = authorities;
    }
    public static UserRepository getUserRepository() {
        if (userRepository == null) {
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
            userRepository = new UserRepository(allUsers, authorities);
        }
        return userRepository;
    }

    public List<Authorities> getUserAuthorities(String user, String password) {

        for (String key : userRepository.allUsers.keySet()) {
            if (key.equals(user)) {
                if (userRepository.allUsers.get(user).equals(password)) {
                    return userRepository.authorities.get(user);
                }
            }
        }
        return null;
    }
}
