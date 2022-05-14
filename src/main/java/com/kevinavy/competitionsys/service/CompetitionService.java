package com.kevinavy.competitionsys.service;

import com.kevinavy.competitionsys.model.common.Response;
import com.kevinavy.competitionsys.model.vo.*;

public interface CompetitionService {
    Response add(CompetitionVo competition);

    Response delete(CompetitionVo competition);

    Response update(CompetitionVo competition);

    Response getCompetitionList(Integer current, Integer size, String keyword);

    Response getCompetitionDetails(Integer id);

    Response getCompetitionList(Integer id);

    Response signUp(SignUpVo signUpVo);

    Response getSignUpCompetitionList(Integer id);

    Response getSignUpPersonList(Integer id);

    Response getHostCompetitionList(String name);

    Response getApproveList(Integer id);

    Response approve(SignUpVo signUpVo);

    Response signUpGroup(SignUpGroupVo signUpGroupVo);

    Response getApplyCompetitionList(String organizer);

    Response getInstitutionApproveCompetitionList(String organizer);

    Response getSchoolApproveCompetitionList(String organizer);

    Response schoolApprove(ApproveVo approveVo);

    Response institutionApprove(ApproveVo approveVo);

    Response addGame(GameVo gameVo);

    Response editGameScore(ScoreVo scoreVo);

    Response deleteGame(Integer id);
}
