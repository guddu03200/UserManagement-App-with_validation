package com.Guddu.UserManagementApp.service;

import com.Guddu.UserManagementApp.model.User;
import com.Guddu.UserManagementApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<User> getAllUser(){
        return userRepo.getUsers();
    }

    public String inputUsers(List<User> u) {

        List<User>users = getAllUser();
        users.addAll(u);
        return "Users added";
    }

    public String inputUser(User u) {

        List<User>users = getAllUser();
        users.add(u);
        return "User added";
    }


    public User getUser(Integer id) {


        List<User> users = getAllUser();

        for(User i:users)
        {
            if(id.equals(i.getUserId()))
            {
                return i;
            }
        }

        throw new IllegalStateException("id not found");
    }

    public String updateUserNumber(Integer iD,String num) {

        List<User> users = getAllUser();

        for(User i:users)
        {
            if(iD.equals(i.getUserId()))
            {
                i.setUserContactNo(num);
                return "User Contact No Updated. ";
            }
        }

        return "User with the "+iD+" Not found";
    }

    public String updateUserEmailAddress(Integer iD, String email) {
        List<User> users = getAllUser();

        for(User i:users)
        {
            if(iD.equals(i.getUserId()))
            {
                i.setUserEmail(email);
                return "User's Address Updated. ";
            }
        }

        return "User with the "+iD+" Not found";

    }

    public String deleteUser(Integer iD) {
        List<User> users = getAllUser();

        for(User i:users)
        {
            if(iD.equals(i.getUserId()))
            {
                users.remove(i);
                return "User's removed ";
            }
        }

        return "User with the "+iD+" Not found";
    }
}
