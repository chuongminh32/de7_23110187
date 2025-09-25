package vn.iotstar.controller;

import vn.iotstar.Services.CategoryService_23110187;
import vn.iotstar.Services.VideoService_23110187;
import vn.iotstar.entity.Category_23110187;
import vn.iotstar.entity.Video_23110187;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
//HomeController.java
@Controller
public class HomeController_23110187 {

 @Autowired
 private CategoryService_23110187 categoryService;

 @Autowired
 private VideoService_23110187 videoService;

 @GetMapping("/")
 public String index() {
     return "redirect:/home";
 }

 @GetMapping("/home")
 public String home(Model model) {
     List<Category_23110187> categories = categoryService.findAll()
             .stream()
             .filter(c -> Boolean.TRUE.equals(c.getStatus()))
             .toList();

     List<Video_23110187> videos = videoService.findAll()
             .stream()
             .filter(v -> Boolean.TRUE.equals(v.getActive()))
             .toList();

     model.addAttribute("categories", categories);
     model.addAttribute("videos", videos);

     return "web/home";
 }
}
