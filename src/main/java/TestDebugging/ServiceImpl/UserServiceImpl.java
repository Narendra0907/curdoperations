package TestDebugging.ServiceImpl;

import TestDebugging.Dao.UserRepository;
import TestDebugging.Entity.User;
import TestDebugging.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;
    @Override
    public User saveData(User user) {
      User u=userRepo.save(user);
        return user ;
    }

    @Override
    public Integer updateData(User user) {
         User u= userRepo.save(user);
        return u.getUserId();
    }

    @Override
    public void deleteData(Integer id) {
userRepo.deleteById(id);
    }

    @Override
    public User getById(Integer id) {
      Optional<User> user= userRepo.findById(id);
      if(user.isPresent()){
          return  user.get();
      }else {
          return null;
      }
    }

    @Override
    public List<User> getAll() {
      List<User> list=  userRepo.findAll();
        return list;
    }
}
