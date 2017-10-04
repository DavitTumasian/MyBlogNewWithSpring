package com.example.controller;

import com.example.model.CategoryEntity;
import com.example.model.PostEntity;
import com.example.repository.CategoryRepository;
import com.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    CategoryRepository categoryRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect: /client/home";
    }

    @RequestMapping(value = "/client/home", method = RequestMethod.GET)
    public String home(ModelMap modelMap) {
        List<PostEntity> allPosts = postRepository.findAll();
        List<CategoryEntity> allCategories = categoryRepository.findAll();
        modelMap.addAttribute("allPosts", allPosts);
        modelMap.addAttribute("allCategories", allCategories);
        return "/client/home";
    }

    @RequestMapping(value = "/admin/admin", method = RequestMethod.GET)
    public String admin(ModelMap modelMap) {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        modelMap.addAttribute("categoryEntityList", categoryEntityList);
        return "/admin/admin";
    }

    @RequestMapping(value = "/admin/admin/addCategory", method = RequestMethod.POST)
    public String adminAddCategory(@ModelAttribute("add_category") CategoryEntity categoryEntity, ModelMap modelMap) {
        categoryRepository.saveAndFlush(categoryEntity);
        modelMap.addAttribute("categoryMessage", "Category is added");
        return "redirect: /admin/admin";
    }

    @RequestMapping(value = "/admin/admin/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/admin/admin/addPost", method = RequestMethod.POST)
    public String addPost(@ModelAttribute("add_post") PostEntity postEntity){
//    public String addPost(@ModelAttribute("add_post") PostEntity postEntity, @RequestParam("image") MultipartFile image) throws IOException {
//        //upload file
//        File dir = new File("D:\\myblog");
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }
//        // Create the file on server
//        String postPic = System.currentTimeMillis() + "_" + image.getOriginalFilename();
//        File serverFile = new File(dir.getAbsolutePath() + "\\" + postPic);
//        BufferedOutputStream stream = new BufferedOutputStream(
//                new FileOutputStream(serverFile));
//        stream.write(image.getBytes());
//        stream.close();
//        postEntity.setImage(postPic);
        postRepository.saveAndFlush(postEntity);
        return "redirect: /admin/admin";
    }
}
