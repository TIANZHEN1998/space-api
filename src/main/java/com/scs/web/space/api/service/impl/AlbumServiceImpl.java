package com.scs.web.space.api.service.impl;

import com.scs.web.space.api.domain.dto.AlbumDto;
import com.scs.web.space.api.domain.entity.Album;
import com.scs.web.space.api.mapper.AlbumMapper;
import com.scs.web.space.api.service.AlbumService;
import com.scs.web.space.api.util.Result;
import com.scs.web.space.api.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    private Logger logger = LoggerFactory.getLogger(AlbumServiceImpl.class);

    @Resource
    private AlbumMapper albumMapper;

    @Override
    public Result insertAlbum(AlbumDto albumDto) {
     try {
         Album album = new Album();
         album.setUserId(albumDto.getUserId());
         album.setName(albumDto.getName());
         album.setCover(albumDto.getCover());
         album.setCreateTime(LocalDateTime.now());
         albumMapper.insertAlbum(album);
     }catch (SQLException e){
         logger.error("新增相册异常");
         return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
     }
        return Result.success();
    }

    @Override
    public Result getAlbum() {
        List<Album> albumList = new ArrayList<>();
        try {
            albumList = albumMapper.getAlbum();
        } catch (SQLException e) {
            logger.error("相册查询异常");
        }
        if(albumList != null){
            return Result.success(albumList);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result getAccountByUserId(long id) {
        List<Album> albumList = new ArrayList<>();
        try {
            albumList = albumMapper.getByUserId(id);
        } catch (SQLException e) {
            logger.error("查询个人相册异常");
        }
        if(albumList != null){
            return Result.success(albumList.size());
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result getByUserId(long id) {
        List<Album> albumList = new ArrayList<>();
        try {
            albumList = albumMapper.getByUserId(id);
        } catch (SQLException e) {
            logger.error("查询个人相册异常");
        }
        if(albumList != null){
            return Result.success(albumList);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result deleteByName(int id) {
        int n = 0;
        try {
            n = albumMapper.deleteByName(id);
        } catch (SQLException e) {
            logger.error("删除相册异常");
        }
        if(n != 0){
            return Result.success();
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }
}
