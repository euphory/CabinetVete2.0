/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.impl;

import com.models.User;
import com.models.security.PasswordResetToken;
import com.repositories.PasswordResetTokenRepository;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService{
    
    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;
    
    @Override
    public PasswordResetToken getPasswordResetToken(final String token){
        return passwordResetTokenRepository.findByToken(token);
    }
    @Override
    public void createPasswordResetTokenForUser(final User user, final String token){
        final PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordResetTokenRepository.save(myToken); 
    }
    
}
