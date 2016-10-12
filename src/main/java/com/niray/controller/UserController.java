package com.niray.controller;

import com.niray.model.UserEntity;
import com.niray.repository.UserRepository;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/user/json", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String userOfBlog() {

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
//        jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
//            public boolean apply(Object source, String name, Object value) {
//                //revert和user都是hibernate主外键关联的
//                if (name.equals("userById") || name.equals("blogById")) {
//                    return true;
//                } else {
//                    return false;
//                }
//            }
//        });
        List<UserEntity> users = userRepository.findAll();

        JSONArray json = JSONArray.fromObject(users, jsonConfig);
        return json.toString();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String users() {
        return "redirect:/user/users";
    }

    @RequestMapping(value = "/user/users", method = RequestMethod.GET)
    public String listOfUsers(ModelMap map) {
        List<UserEntity> users = userRepository.findAll();
        map.addAttribute("users", users);
        return "user/users";
    }

    /**
     * 添加用户
     *
     * @return
     */
    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String addUser() {
        return "user/addUser";
    }

    @RequestMapping(value = "/user/addP", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") UserEntity user) {
        userRepository.saveAndFlush(user);
        return "redirect:/user/users";
    }

    /**
     * 用户详情
     *
     * @param userId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/user/detail/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Integer userId, ModelMap modelMap) {
        UserEntity user = userRepository.findOne(userId);
        modelMap.addAttribute("user", user);
        return "user/detail";
    }

    /**
     * 修改用户
     */
    @RequestMapping(value = "/user/update/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") Integer userId, ModelMap modelMap) {
        UserEntity userEntity = userRepository.findOne(userId);
        modelMap.addAttribute("user", userEntity);
        return "user/update";
    }

    @RequestMapping(value = "/user/updateP", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("user") UserEntity user) {
        userRepository.updateUser(user.getId(), user.getNickname(), user.getPassword());
        userRepository.flush();
        return "redirect:/user/users";
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Integer userId) {
        userRepository.delete(userId);
        userRepository.flush();
        return "redirect:/user/users";
    }
}
