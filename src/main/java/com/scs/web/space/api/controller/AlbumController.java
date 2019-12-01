package com.scs.web.space.api.controller;

import com.scs.web.space.api.domain.dto.AlbumDto;
import com.scs.web.space.api.service.AlbumService;
import com.scs.web.space.api.util.Result;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/album")
public class AlbumController {
    @Resource
    private AlbumService albumService;

    @GetMapping(value = "/list")
    Result getAlbum(){
        return albumService.getAlbum();
    }

    @GetMapping(value = "/{id}")
    Result getByUserId(@PathVariable long id){
        return albumService.getByUserId(id);
    }

    @DeleteMapping(value = "/delete")
    Result deleteById(@RequestParam(name = "id") int id){
        return albumService.deleteByName(id);
    }

    @PostMapping(value = "/insert")
    Result insertAlbum(@RequestBody AlbumDto albumDto){
        return albumService.insertAlbum(albumDto);
    }

    @GetMapping(value = "/account/{id}")
    Result getAccountByUserId(@PathVariable long id){
        return albumService.getAccountByUserId(id);
    }
}
