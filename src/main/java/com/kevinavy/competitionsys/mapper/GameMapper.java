package com.kevinavy.competitionsys.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kevinavy.competitionsys.model.po.Game;
import org.apache.ibatis.annotations.Update;

public interface GameMapper extends BaseMapper<Game> {
    @Update("UPDATE game SET is_delete = 1 WHERE id = #{id}")
    void delete(Integer id);
}
