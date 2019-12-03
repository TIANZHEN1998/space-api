package com.scs.web.space.api.controller;

import com.scs.web.space.api.domain.entity.Album;
import com.scs.web.space.api.service.AlbumService;
import com.scs.web.space.api.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName AlbumController
 * @Description 相册控制层
 * @Author wf
 * @Date 2019/12/1
 **/
@RestController
@RequestMapping(value = "/api/album")
public class AlbumController {
    @Resource
    private AlbumService albumService;

    @GetMapping(value = "/")
    Result selectAll() {
        return albumService.selectAll();
    }


    @PostMapping(value = "/")
    Result insertAlbum(@RequestBody Album album) {
        return albumService.insert(album);
    }

    @GetMapping(value = "/{id}")
    Result selectByUserId(@PathVariable int id) {
        return albumService.selectByUserId(id);
    }

    @DeleteMapping(value = "/{id}")
    Result delete(@PathVariable int id) {
        return albumService.delete(id);
    }

}
