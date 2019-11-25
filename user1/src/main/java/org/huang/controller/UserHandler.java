package org.huang.controller;


import org.huang.entity.User;
import org.huang.entity.UserVO;
import org.huang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        return userRepository.findAll(index,limit);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
      //  user.setRegisterdate(new Date());
        userRepository.save(user);
    }
    @GetMapping("/count")
    public int count(){
        return userRepository.count();
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userRepository.deleteById(id);
    }
}
