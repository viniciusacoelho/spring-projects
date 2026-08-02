package com.login_system.controller;

import com.login_system.dtos.Login;
import com.login_system.dtos.Sessao;
import com.login_system.model.User;
import com.login_system.repository.UserRepository;
import com.login_system.security.JWTCreator;
import com.login_system.security.JWTObject;
import com.login_system.security.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginController {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public Sessao logar(@RequestBody Login login) {
        User user = repository.findUserByUsername(login.getUsername());
        if (user != null) {
            boolean passwordOk = encoder.matches(login.getPassword(), user.getPassword());

            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
            }

            Sessao sessao = new Sessao();
            sessao.setLogin(user.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration(new Date(System.currentTimeMillis() + securityConfig.EXPIRATION));
            jwtObject.setRoles(user.getRoles());

            sessao.setToken(JWTCreator.create(securityConfig.PREFIX, securityConfig.KEY, jwtObject));

            return sessao;
        } else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }

}
