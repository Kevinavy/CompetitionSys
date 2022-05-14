package com.kevinavy.competitionsys.service;

import com.kevinavy.competitionsys.model.common.Response;
import com.kevinavy.competitionsys.model.vo.UserVo;

public interface UserService {
    Response register(UserVo user);

    Response login(UserVo user);

    Response logout();

    Response deleteUser(UserVo user);

    Response updateUser(UserVo user);
}
