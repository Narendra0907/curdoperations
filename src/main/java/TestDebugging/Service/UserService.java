package TestDebugging.Service;

import TestDebugging.Entity.User;

import java.util.List;

public interface UserService {

    public User saveData(User user);
    public Integer updateData(User user);
    public void deleteData(Integer id);
    public User getById(Integer id);
    public List<User> getAll();

 }
