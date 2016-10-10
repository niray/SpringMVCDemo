package com.niray.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
//@ResponseBody
    public String index() {
//   List<UserEntity> users = userRepository.findAll();
//      JSONObject jo = new JSONObject();
//      jo.put("Id", users.get(0).getId());
//      jo.put("Nickname", users.get(0).getNickname());
//      jo.put("Password", users.get(0).getPassword());
//      return jo.toString();
//     JSONArray ja = new JSONArray();
//     ja.addAll(users);
//      return "index";
//       return ja.toString();
//      return JSONArray.fromObject()
//        return "redirect:/user/users";
        return "index";
    }

}
