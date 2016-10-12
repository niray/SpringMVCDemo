package com.niray.controller;

import com.niray.model.BlogEntity;
import com.niray.model.UserEntity;
import com.niray.repository.BlogRepository;
import com.niray.repository.UserRepository;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mac on 16/10/10.
 */
@Controller
public class BlogController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BlogRepository blogRepository;


    @RequestMapping(value = "/blog/json", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String jsonOfBlog() {
        List<BlogEntity> blogs = blogRepository.findAll();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        JSONArray json = JSONArray.fromObject(blogs, jsonConfig);
        return json.toString();
    }

    @RequestMapping(value = "/blog/blogs", method = RequestMethod.GET)
    public String listOfBlog(ModelMap map) {
        List<BlogEntity> blogs = blogRepository.findAll();
        map.addAttribute("blogs", blogs);
        return "blog/blogs";
    }

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public String blogRoot() {
        return "redirect:/blog/blogs";
    }

    @RequestMapping(value = "/blog/add", method = RequestMethod.GET)
    public String addBlog(ModelMap modelMap) {
        List<UserEntity> users = userRepository.findAll();
        modelMap.addAttribute("users", users);
        return "blog/add";
    }

    @RequestMapping(value = "/blog/addP", method = RequestMethod.POST)
    public String addBlogPost(@ModelAttribute("blog") BlogEntity blogEntity) {
        // 打印博客标题
        System.out.println(blogEntity.getTitle());
        // 打印博客作者
        System.out.println(blogEntity.getUserById().getNickname());
        blogRepository.saveAndFlush(blogEntity);
        return "redirect:/blog/blogs";
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//    }

    /**
     * 查看详情
     */
    @RequestMapping(value = "/blog/detail/{id}", method = RequestMethod.GET)
    public String showDetail(@PathVariable("id") Integer id, ModelMap modelMap) {
        BlogEntity blogEntity = blogRepository.findOne(id);
        modelMap.addAttribute("detail", blogEntity);
        return "blog/detail";
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/blog/update/{id}", method = RequestMethod.GET)
    public String updateBlog(@PathVariable("id") Integer id, ModelMap modelMap) {
        BlogEntity blogEntity = blogRepository.findOne(id);
        List<UserEntity> userList = userRepository.findAll();
        modelMap.addAttribute("blog", blogEntity);
        modelMap.addAttribute("users", userList);
        return "blog/update";
    }

    @RequestMapping(value = "/blog/updateP", method = RequestMethod.POST)
    public String updateBlogPost(@ModelAttribute("blogP") BlogEntity blogEntity) {
        blogRepository.updateBlog(blogEntity.getTitle(), blogEntity.getContent(), blogEntity.getUserById().getId(), blogEntity.getPubDate(), blogEntity.getId());
        blogRepository.flush();
        return "redirect:/blog/blogs";
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/blog/delete/{id}", method = RequestMethod.GET)
    public String deleteBlog(@PathVariable("id") Integer id) {
        blogRepository.delete(id);
        blogRepository.flush();
        return "redirect:/blog/blogs";
    }
}
