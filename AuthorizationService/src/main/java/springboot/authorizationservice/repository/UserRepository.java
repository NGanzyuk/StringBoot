package springboot.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import springboot.authorizationservice.model.RepositoryModel;

import java.util.List;

@Repository
public class UserRepository {
    RepositoryModel repositoryModel;

    public List<Authorities> getUserAuthorities(String user, String password) {
        for (String key : repositoryModel.getAllUsers().keySet()) {
            if (key.equals(user)) {
                if (repositoryModel.getAllUsers().get(user).equals(password)) {
                    return repositoryModel.getAuthorities().get(user);
                }
            }
        }
        return null;
    }
}
