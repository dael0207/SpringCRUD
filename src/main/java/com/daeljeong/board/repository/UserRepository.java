package com.daeljeong.board.repository;

import com.daeljeong.board.dto.UserDTO;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    static public ArrayList<UserDTO> users;

    static {
        //Db    연동
        users = new ArrayList<>();
        users.add(new UserDTO("Jeong","Test1", "1111"));
        users.add(new UserDTO("Da","Test2", "2222"));
        users.add(new UserDTO("El","Test3", "3333"));
    }

    public UserDTO insertUser(UserDTO user){
        users.add(user);
        return user;
    } //insert

    public List<UserDTO> getAllUsers(){
        return users;
    }

    public UserDTO getUserByUserId(String userId) {
        return users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO("","",""));
    }

    public void updateUserPw(String userId, UserDTO user) {
        users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO("","",""))
                .setUserPW(user.getUserPW());
    }

    public void deleteUser(String userId){
        users.removeIf(userDTO -> userDTO.getUserId().equals(userId));
    }



}
