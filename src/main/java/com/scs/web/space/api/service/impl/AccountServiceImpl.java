package com.scs.web.space.api.service.impl;

import com.scs.web.space.api.domain.entity.Account;
import com.scs.web.space.api.mapper.AccountMapper;
import com.scs.web.space.api.service.AccountService;
import com.scs.web.space.api.util.Result;
import com.scs.web.space.api.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wf
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @Date 2019/12/4
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;
    private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Override
    public Result getUserAccounts(int id) {
        Map map = new HashMap();
        try {
            map = accountMapper.getUserAccount(id);
        } catch (SQLException e) {
            logger.error("查询用户account异常");
        }
        if(map != null){
            return Result.success(map);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }
}
