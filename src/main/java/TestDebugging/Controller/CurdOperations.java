package TestDebugging.Controller;

import TestDebugging.Dao.UserRepository;
import TestDebugging.Entity.User;
import TestDebugging.ServiceImpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("Curd")
@RestController
public class CurdOperations {

    @Autowired
    private UserServiceImpl userService;

    private static final Logger logger = LoggerFactory.getLogger(CurdOperations.class);
    @PostMapping("/save")
    private ResponseEntity<String> saveUser(@RequestBody User user)
    {
        User u=userService.saveData(user);
        logger.info("Data  Saved Sucessfully");
        return new ResponseEntity<String>("User  Id  Number"+u.getUserId()+"Sucessfully Inserted", HttpStatus.OK);
    }

    @PutMapping("/update")
    private ResponseEntity<String> updateData(@RequestBody User user){
       Integer u= userService.updateData(user);
       return new ResponseEntity<>("User Id Number  "+u+"updatedSucessfully",HttpStatus.OK);
    }


    @DeleteMapping("/delete/{uid}")
    private ResponseEntity<String> deleteData(@PathVariable("uid") Integer id){
        userService.deleteData(id);
        return new ResponseEntity<>("User In no"+id+"deleted sucessfully",HttpStatus.OK);
    }


    @GetMapping("/get/{uid}")
    private ResponseEntity<String> getById(@PathVariable("uid") Integer id){
   User user=     userService.getById(id);
   if(user==null){
       return new ResponseEntity<String>(user.getUserId()+"Not present in dataBase",HttpStatus.OK);
   }
   else{

       return new ResponseEntity<String>(user+"user Details",HttpStatus.OK);
   }
    }
    private ResponseEntity<List<User>> getAll(){
     List<User>  list=  userService.getAll();
     return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
