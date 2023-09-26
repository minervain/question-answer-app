package com.project.aou.Controller;

import com.project.aou.Entites.User;
import com.project.aou.Repository.UserRepository;
import com.project.aou.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserRepository userRepository) {
        this.userService = userService;
    }

    @GetMapping
    public List <User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.saveOneUser(newUser);
    }
    @GetMapping("/{userId}")
    public  User getOneUser(@PathVariable Long userId){

        //Custom exception
        return userService.getOneUser(userId);

    }
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser){

        return userService.updateOneUser(userId,newUser);

    }


    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){

        userService.deleteById(userId);

    }

}
