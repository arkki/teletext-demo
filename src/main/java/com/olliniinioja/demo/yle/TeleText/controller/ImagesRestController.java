package com.olliniinioja.demo.yle.TeleText.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class ImagesRestController {

    @GetMapping("/{page}/{subpage}")
    public String getPageAndSubpage(
            @PathVariable String page,
            @PathVariable String subpage,
            @RequestParam(required = false) String time) {
        String response = "Requested page: " + page + ", Subpage: " + subpage;

        if (time != null) {
            response += ", Time: " + time;
        }

        return response;
    }
}
