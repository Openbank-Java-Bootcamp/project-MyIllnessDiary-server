package com.Ironhack.finalProjectserver.controller;

import com.Ironhack.finalProjectserver.DTO.RoleToUserDTO;
import com.Ironhack.finalProjectserver.DTO.UserVerifyDTO;
import com.Ironhack.finalProjectserver.model.Role;
import com.Ironhack.finalProjectserver.model.User;
import com.Ironhack.finalProjectserver.repository.RoleRepository;
import com.Ironhack.finalProjectserver.repository.UserRepository;
import com.Ironhack.finalProjectserver.service.impl.UserService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<User> search() {
        return userRepository.findAllByRoles_id();
    }
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable(name = "id") Long userId) {
        return userRepository.findById(userId).get();
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody @Valid User user) {
        return userService.saveUserAsPatient(user);
    }

    @GetMapping("/verify")
    @ResponseStatus(HttpStatus.OK)
    public String verifyToken(Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        User userFromDb = userRepository.findByEmail(email);
        //RoleToUserDTO roleToUserDTO = new RoleToUserDTO(userFromDb.getEmail(), userFromDb.getRoles());
        UserVerifyDTO userVerifyDTO= new UserVerifyDTO(userFromDb.getName(),userFromDb.getRoles().getName(),userFromDb.getId().toString());
        Gson gson = new Gson();
        String userDetails = gson.toJson(userVerifyDTO);
        return userDetails;
    }
}