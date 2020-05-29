/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etz.payoutlet.resourceserver.controllers;

import com.etz.payoutlet.resourceserver.models.AccessTokenMapper;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author afam.okonkwo
 */
@RestController
public class SimpleController {
    
    
    @GetMapping("/whoami")
    public String whoami(OAuth2Authentication authentication) {
        return authentication.getPrincipal().toString(); 
    }
    
    @GetMapping("/authorities")
    public Collection authorities(OAuth2Authentication authentication) {
        return authentication.getAuthorities();
    }
    
    @RequestMapping(value = "/api")
    public String success() {
        AccessTokenMapper accessTokenMapper = (AccessTokenMapper)
                ((OAuth2AuthenticationDetails)SecurityContextHolder.getContext().
                        getAuthentication().getDetails()).getDecodedDetails();
        System.out.println("UserId:: " + accessTokenMapper.getId() + " UserName:: "+accessTokenMapper.getUserName());
        
        return "SUCCESS";
    }
    
}
