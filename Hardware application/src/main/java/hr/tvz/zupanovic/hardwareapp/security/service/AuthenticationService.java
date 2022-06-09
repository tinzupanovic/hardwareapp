package hr.tvz.zupanovic.hardwareapp.security.service;

import hr.tvz.zupanovic.hardwareapp.security.command.LoginCommand;
import hr.tvz.zupanovic.hardwareapp.security.dto.LoginDTO;

import java.util.Optional;

public interface AuthenticationService {

    Optional<LoginDTO> login(LoginCommand command);

}
