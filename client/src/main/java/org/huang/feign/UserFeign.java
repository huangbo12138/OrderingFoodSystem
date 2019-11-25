package org.huang.feign;

import org.huang.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user")
public interface UserFeign {
       @GetMapping("/user/findAll/{index}/{limit}")
        public List<User> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

       @PostMapping("/user/save")
        public void save(@RequestBody User user);

       @DeleteMapping("/user/deleteById/{id}")
       public void deleteById(@PathVariable("id") long id);

       @GetMapping("/user/count")
       public int count();
}
