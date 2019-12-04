package com.scs.web.space.api.controller;

import com.scs.web.space.api.service.ImageService;
import com.scs.web.space.api.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wf
 * @ClassName ImageController
 * @Description TODO
 * @Date 2019/12/4
 */
@RestController
@RequestMapping(value = "/api/image")
public class ImageController {

    @Resource
    private ImageService imageService;
    @GetMapping(value = "/")
    Result getImage(){
        return imageService.listImage();
    }
}
