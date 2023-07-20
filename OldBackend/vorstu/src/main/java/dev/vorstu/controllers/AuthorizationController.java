package dev.vorstu.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j // log.info

public class AuthorizationController {

    @PostMapping(value = "/login")
    public Principal Login(Principal user) {
        log.info("Login user");
        UsernamePasswordAuthenticationToken token = ((UsernamePasswordAuthenticationToken) user);
        log.info("Hello {} with role {}", token.getName(), token.getAuthorities());
        return token;

    }

    @PostMapping(path = "/logout", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Principal logout(Principal user, HttpServletRequest request, HttpServletResponse response) {
        log.info("Logout user");
        CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(
                AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY
        );
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        cookieClearingLogoutHandler.logout(request, response, null);
        securityContextLogoutHandler.logout(request, response, null);


        return user;
    }


}
