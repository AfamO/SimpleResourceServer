/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etz.payoutlet.resourceserver.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author afam.okonkwo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessTokenMapper {
    private Long id;
    private String userName;
    private String accessToken;
    
}
