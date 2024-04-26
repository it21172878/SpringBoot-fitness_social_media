package com.fitness_social_media.fitness_social_media.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness_social_media.fitness_social_media.config.JwtProvider;
import com.fitness_social_media.fitness_social_media.models.User;
import com.fitness_social_media.fitness_social_media.repository.UserRepository;
import com.fitness_social_media.fitness_social_media.request.LoginRequest;
import com.fitness_social_media.fitness_social_media.response.AuthResponse;
import com.fitness_social_media.fitness_social_media.service.CustomerUserDetailsService;
import com.fitness_social_media.fitness_social_media.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;

    // auth/signup
    @PostMapping("/signup")
    public AuthResponse createUser(@RequestBody User user) throws Exception{

        User isExist=userRepository.findByEmail(user.getEmail());
        if(isExist!=null){
            throw new Exception("this email already used with another accouunt");
        }

        User newUser=new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser=userRepository.save(newUser);

        Authentication authentication=new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
        String token = JwtProvider.generateToken(authentication);

        AuthResponse res=new AuthResponse(token,"Register Successfully");

        return res;
    }

    // auth/signin
    @PostMapping("/signin")
    public AuthResponse signin(@RequestBody LoginRequest loginRequest){
        Authentication authentication =  authenticate(loginRequest.getEmail(),loginRequest.getPassword());

        String token=JwtProvider.generateToken(authentication);

        AuthResponse res=new AuthResponse(token,"Login Successfully");
        return res;
    }

    private Authentication authenticate(String email, String password) {
        UserDetails userDetails=customerUserDetailsService.loadUserByUsername(email);
        if(userDetails==null){
            throw new BadCredentialsException("Invalid username");
        }
        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Invalid password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }
}
