/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etz.payoutlet.resourceserver;

import com.etz.payoutlet.resourceserver.models.AccessTokenMapper;
import java.util.Map;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
/**
 *
 * @author afam.okonkwo
 */
@Component
public class JwtConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer {

    @Override
    public void configure(JwtAccessTokenConverter converter) {
        converter.setAccessTokenConverter(this);
    }
    
    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
        
        OAuth2Authentication auth = super.extractAuthentication(map);
        AccessTokenMapper details = new AccessTokenMapper();
        if(map.get("id")!= null) {
            details.setId(Long.parseLong(Integer.toString((Integer)(map.get("id")))));
        }
        if(map.get("userName")!= null) {
            details.setUserName((String)map.get("userName"));
        }
        auth.setDetails(details);
        return auth;
    }
    
}
