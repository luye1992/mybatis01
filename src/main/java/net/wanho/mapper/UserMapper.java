package net.wanho.mapper;

import net.wanho.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2019/6/5.
 */
public interface UserMapper {
    List<User> getAllUser();
    User  getUserById( int id);
    void  addUser(User user);
    void  updateUser(User user);
    void  deleteUser(User user);

    void addUserReturnKey(User user);


List<User> getUserByName(String name);
List<User> getUserByName2(User user);




}
