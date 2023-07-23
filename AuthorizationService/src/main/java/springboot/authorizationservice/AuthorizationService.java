package springboot.authorizationservice;

import org.springframework.http.HttpStatus;

import java.util.List;

public class AuthorizationService {
    UserRepository userRepository;

    List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        userRepository = UserRepository.getUserRepository();
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
