package springboot.authorizationservice.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<String, String> allUsers = new HashMap<>();
    private final Map<String, ArrayList<Authorities>> authorities = new HashMap<>();

    public UserRepository() {
        this.allUsers.put("qwer", "123");
        this.allUsers.put("asd", "123");
        this.allUsers.put("rrrr", "123");
        ArrayList<Authorities> list = new ArrayList<>();
        list.add(Authorities.READ);
        list.add(Authorities.WRITE);
        list.add(Authorities.DELETE);
        this.authorities.put("qwer", list);
        list.clear();
        list.add(Authorities.READ);
        list.add(Authorities.WRITE);
        this.authorities.put("asd", list);
        list.clear();
        list.add(Authorities.READ);
        this.authorities.put("rrrr", list);
        list.clear();
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        for (String key : this.allUsers.keySet()) {
            if (key.equals(user)) {
                if (this.allUsers.get(user).equals(password)) {
                    return this.authorities.get(user);
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.allUsers.toString() + " " + this.authorities.toString();
    }
}

