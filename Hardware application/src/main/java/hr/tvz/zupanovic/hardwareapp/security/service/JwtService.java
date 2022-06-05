package hr.tvz.zupanovic.hardwareapp.security.service;

import hr.tvz.zupanovic.hardwareapp.security.domain.User;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(User user);

}
