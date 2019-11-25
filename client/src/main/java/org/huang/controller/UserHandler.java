package org.huang.controller;

import org.huang.entity.User;
import org.huang.entity.UserVO;
import org.huang.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserFeign userFeign;


    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit;
        UserVO userVO = new UserVO();
        userVO.setCode(0);
        userVO.setMsg("");
        userVO.setCount(userFeign.count());
        userVO.setData(userFeign.findAll(index,limit));
        return userVO;
    }
    @GetMapping("/redirect/{location}")//前端
    public String redirect(@PathVariable("location") String location){

        return location;
    }

    @PostMapping("/save")
    public String save(User user){
      user.setRegisterdate(new Date());
        userFeign.save(user);
        return "redirect:/user/redirect/user_manage";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id)
    {
        userFeign.deleteById(id);
        return "redirect:/user/redirect/user_manage";
    }
}
