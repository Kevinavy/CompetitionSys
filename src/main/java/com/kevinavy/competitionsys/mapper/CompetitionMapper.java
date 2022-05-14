package com.kevinavy.competitionsys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kevinavy.competitionsys.model.dto.SignUpCompetitionDto;
import com.kevinavy.competitionsys.model.po.Competition;
import com.kevinavy.competitionsys.model.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

public interface CompetitionMapper extends BaseMapper<Competition> {
    @Update("UPDATE competition SET is_delete = #{deleteFlag} WHERE username = #{id}")
    void updateIsDelete(Integer id, Integer deleteFlag);

    @Select("SELECT" +
            "  A.* " +
            "FROM" +
            "  competition A" +
            "  JOIN sign_up B ON A.id = B.competition_id " +
            "WHERE" +
            "  B.user_id = #{id}" +
            "  AND A.is_delete = 0" +
            "  AND B.status = 1")
    List<Competition> getCompetitionByUserId(Integer id);

    @Select("SELECT" +
            "  A.*, " +
            "  B.create_time AS sign_up_time, " +
            "  B.status AS sign_up_status, " +
            "  B.id AS sign_up_id, " +
            "  B.comment AS sign_up_comment " +
            "FROM" +
            "  competition A" +
            "  JOIN sign_up B ON A.id = B.competition_id " +
            "WHERE" +
            "  B.user_id = #{id}" +
            "  AND B.is_delete = 0" +
            "  AND A.is_delete = 0")
    List<SignUpCompetitionDto> getSignUpCompetitionByUserId(Integer id);

    @Select("SELECT" +
            "  A.* " +
            "FROM" +
            "  user A" +
            "  JOIN sign_up B ON A.id = B.user_id " +
            "WHERE" +
            "  B.competition_id = #{id}" +
            "  AND B.status = 1")
    List<User> getSignUpPersonList(Integer id);

    @Select("SELECT" +
            "  B.id " +
            "FROM" +
            "  sign_up A" +
            "  JOIN competition B ON A.competition_id = B.id " +
            "WHERE" +
            "  B.organizer = #{organizer}" +
            "  AND A.status = 0")
    List<Integer> getCompetitionIdListWhichHasApproveByOrganizer(String organizer);

    @Select("SELECT" +
            "  A.*" +
            "FROM" +
            "  competition A" +
            "  JOIN user B ON A.organizer = B.name " +
            "WHERE" +
            "  A.organizer = #{organizer}" +
            "  AND A.is_delete = 0" +
            "  AND A.approve_status = 0")
    List<Competition> getInstitutionApproveCompetitionList(String organizer);

    @Select("SELECT" +
            "  A.*" +
            "FROM" +
            "  competition A" +
            "  JOIN user B ON A.organizer = B.name " +
            "WHERE" +
            "  A.is_delete = 0" +
            "  AND A.approve_status = 1")
    List<Competition> getSchoolApproveCompetitionList(String organizer);

}
