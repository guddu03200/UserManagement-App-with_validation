package com.Guddu.UserManagementApp.controller;

import com.Guddu.UserManagementApp.model.User;
import com.Guddu.UserManagementApp.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
public class UserController {

    @Autowired
    UserService userService;

    //post or adduser or users
    @PostMapping("user")    //addUser
    public String addUser(@Valid @RequestBody User u)
    {
        return userService.inputUser(u);
    }
    @PostMapping("users")
    public String addUsers(@RequestBody @Valid List<User>u)
    {
        return userService.inputUsers(u);
    }



    @GetMapping("users")  //getAllUser
    public List<User> getAllUsers()
    {
        return userService.getAllUser();
    }

    @GetMapping("user/{iD}") //getUser/{userid}

    public User getUserById(@PathVariable Integer iD)
    {
        return userService.getUser(iD);
    }


    //	updateUserInfo Phone and Address
    @PutMapping("user/{iD}/number/{num}")
    public String updateUserNumById(@PathVariable Integer iD,  @Size(min = 12,max = 12)
    @Pattern( regexp = "91[0-9]+") @PathVariable String num)
    {
        return userService.updateUserNumber(iD,num);
    }

    @PutMapping("user/{iD}/address/{address}")
    public String updateUserAddressById(@PathVariable Integer iD,@Email @PathVariable String email)
    {
        return userService.updateUserEmailAddress(iD,email);
    }



    //deleteUser
    @DeleteMapping("user/{iD}")
    public String deleteUserById(@PathVariable Integer iD)
    {
        return userService.deleteUser(iD);
    }
}
