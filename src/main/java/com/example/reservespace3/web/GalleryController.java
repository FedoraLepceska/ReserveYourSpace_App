package com.example.reservespace3.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    @GetMapping
    public String getGallery(Model model){
        model.addAttribute("bodyContent", "gallery");
        return "master-template";
    }
}
