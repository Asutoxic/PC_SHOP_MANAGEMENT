package com.cg.controller;

import com.cg.model.User;
import com.cg.model.dto.UserDTO;
import com.cg.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    private String getPrincipalName() {

        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            Optional<User> currentUser = userService.findByUsername(username);
            username = currentUser.get().getFullName();
        } else {
            username = principal.toString();
        }

        return username;
    }

    private UserDTO getPrincipal() {
        UserDTO userDTO;
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        username = ((UserDetails) principal).getUsername();
        Optional<User> currentUser = userService.findByUsername(username);
        userDTO = currentUser.get().toUserDTO();
        return userDTO;
    }


    @GetMapping
    public ModelAndView showUserList() {
        ModelAndView modelAndView = new ModelAndView("/user-management/list");
        modelAndView.addObject("username", getPrincipalName());
        return modelAndView;
    }

    @GetMapping("/admins")
    public ModelAndView showAdminList() {
        ModelAndView modelAndView = new ModelAndView("/admin-management/list");
        modelAndView.addObject("username", getPrincipalName());
        return modelAndView;
    }
}

