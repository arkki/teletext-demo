package com.olliniinioja.demo.yle.TeleText.controller;

import com.olliniinioja.demo.yle.TeleText.model.Image;
import com.olliniinioja.demo.yle.TeleText.repository.ImageRepository;
import com.olliniinioja.demo.yle.TeleText.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class ImagesRestController {

    @Autowired
    private ImageRepository repository;

    @GetMapping("/{page}/{subpage}.{ext}")
    @ResponseBody
    public ResponseEntity<InputStreamResource> getPageAndSubpage(
            @PathVariable String page,
            @PathVariable String subpage,
            @PathVariable String ext,
            @RequestParam(required = false) String time) throws BadRequestException, FileNotFoundException {
        if (!StringUtils.equalsIgnoreCase(ext, "png")) {
            throw new BadRequestException("Requested extension has to be png, was: " + ext);
        }

        Optional<Image> image;
        Instant date = DateUtil.getUTCFromEpoch(time);
        if (date != null) {
            image = repository.findOneByPageAndTime(Integer.parseInt(page), Integer.parseInt(subpage), date);
        } else {
            image = repository.findOneByPage(Integer.parseInt(page), Integer.parseInt(subpage));
        }

        if (image.isEmpty()) {
            throw new FileNotFoundException(String.format("Could not find records with page: %s, subpage: %s, time: %s",
                    page, subpage, date != null ? date.toString() : ""));
        }

        try {
            File file = ResourceUtils.getFile("classpath:" + image.get().url);
            InputStream in = new FileInputStream(file);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(new InputStreamResource(in));
        } catch (IOException e) {
            throw new FileNotFoundException("Could not find file in system: " + image.get().url);
        }
    }
}
