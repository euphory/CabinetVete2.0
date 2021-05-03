/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.models.User;
import com.models.security.PasswordResetToken;

/**
 *
 * @author PC
 */
public interface UserService {
    
    PasswordResetToken getPasswordResetToken(final String token);
    
    void createPasswordResetTokenForUser(final User user, final String token);
    
    
}
