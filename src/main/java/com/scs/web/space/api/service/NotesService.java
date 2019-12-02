package com.scs.web.space.api.service;


import com.scs.web.space.api.domain.dto.NotesDto;
import com.scs.web.space.api.domain.entity.Notes;
import com.scs.web.space.api.util.Result;

import java.util.List;

/**
 * @ClassName LogService
 * @Description 日志服务接口
 * @Author wf
 * @Date 2019/12/1
 **/
public interface NotesService {
    /**
     * 日志详情页
     * @param id
     * @return
     */
    Result getByUserId(int id);

    Result getNotesById(int id);

    Result insertNotes(NotesDto notesDto);

    Result updateNotes(NotesDto notesDto);

    Result deleteById(int id);

    Result batchDelete(List<Notes> list);
}
