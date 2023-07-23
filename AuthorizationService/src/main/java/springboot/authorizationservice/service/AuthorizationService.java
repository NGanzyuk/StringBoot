package springboot.authorizationservice.service;

import org.springframework.stereotype.Service;
import springboot.authorizationservice.exception.InvalidCredentials;
import springboot.authorizationservice.exception.UnauthorizedUser;
import springboot.authorizationservice.repository.Authorities;
import springboot.authorizationservice.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        System.out.println(userAuthorities.toString());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
