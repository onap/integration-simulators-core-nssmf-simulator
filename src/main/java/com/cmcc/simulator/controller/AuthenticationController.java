package com.cmcc.simulator.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cmcc.simulator.authmodule.AuthRequest;
import com.cmcc.simulator.authmodule.AuthResponse;

@RestController
@RequestMapping("/api/rest/securityManagement/v1")
public class AuthenticationController {

    @PostMapping("/oauth/token")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse nSSIChangeNotify(@RequestBody AuthRequest nSSIChangeNotify) { 	
        return new AuthResponse(UUID.randomUUID().toString().replaceAll("-",""), 1800);
    }

}
