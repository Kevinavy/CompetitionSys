package com.kevinavy.competitionsys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kevinavy.competitionsys.model.po.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper extends BaseMapper<Role> {
    @Select("SELECT" +
            "  A.* " +
            "FROM" +
            "  role A" +
            "  JOIN user_role_relation B ON A.id = B.role_id " +
            "WHERE" +
            "  B.user_id = #{id}")
    Role getRoleByUserId(Integer id);
}
