/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author PC
 */
@Controller
public class IndexController
{
    @GetMapping("/index")
    public String index()
    {
        return "index";
    }
}
