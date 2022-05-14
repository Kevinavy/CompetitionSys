package com.kevinavy.competitionsys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kevinavy.competitionsys.mapper.*;
import com.kevinavy.competitionsys.model.common.Response;
import com.kevinavy.competitionsys.model.po.*;
import com.kevinavy.competitionsys.model.vo.*;
import com.kevinavy.competitionsys.service.CompetitionService;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CompetitionServiceImpl implements CompetitionService {
    @Resource
    CompetitionMapper competitionMapper;

    @Resource
    GameMapper gameMapper;

    @Resource
    UserMapper userMapper;

    @Resource
    SignUpMapper signUpMapper;

    @Resource
    RoleMapper roleMapper;

    @Override
    public Response add(CompetitionVo competition) {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        Competition competitionData = new Competition(competition);
        competitionData.setCreateTime(currentTimestamp);
        competitionData.setApproveStatus(0);
        competitionData.setFinish(0);
        competitionData.setIsDelete(0);
        competitionData.setCreateTime(currentTimestamp);
        competitionData.setUpdateTime(currentTimestamp);
        competitionData.setApproveCommentInstitute("");
        competitionData.setApproveCommentSchool("");

        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getName, competition.getOrganizer());
        Optional<User> user = Optional.ofNullable(userMapper.selectOne(userLambdaQueryWrapper));
        user.ifPresent(userTemp -> {
            Role userRole = roleMapper.getRoleByUserId(userTemp.getId());
            if (userRole.getRoleCode() == 1003) {
                competitionData.setApproveStatus(1);
                competitionData.setApproveCommentInstitute("通过");
                competitionData.setApproveTimeInstitute(currentTimestamp);
            }
            else if (userRole.getRoleCode() == 1002) {
                competitionData.setApproveStatus(2);
                competitionData.setApproveCommentSchool("通过");
                competitionData.setApproveTimeSchool(currentTimestamp);
            }
        });

        competitionMapper.insert(competitionData);
        return Response.success("赛事申请成功", null);
    }

    @Override
    public Response delete(CompetitionVo competition) {
        // todo 撤销申请
        competitionMapper.updateIsDelete(competition.getId(), 1);
        return Response.success("赛事删除成功", null);
    }

    @Override
    public Response update(CompetitionVo competition) {
        return null;
    }

    @Override
    public Response getCompetitionList(Integer current, Integer size, String keyword) {
        QueryWrapper<Competition> queryWrapper =  new QueryWrapper<>();
        queryWrapper.orderByDesc("start_time");
        queryWrapper.eq("approve_status", 2);
        queryWrapper.eq("is_delete", 0);
        if (!StringUtils.isEmpty(keyword)) {
            queryWrapper.like("name", keyword);
        }
        Page<Competition> competitionPage = competitionMapper.selectPage(new Page<>(current, size), queryWrapper);
        List<CompetitionVo> competitionVoList = competitionPage.getRecords().stream()
                .map(CompetitionVo::new)
                .collect(Collectors.toList());
        return Response.success(competitionVoList);
    }

    @Override
    public Response getCompetitionDetails(Integer id) {
        LambdaQueryWrapper<Game> gameQueryWrapper = new LambdaQueryWrapper<>();
        gameQueryWrapper.eq(Game::getFatherCompetition, id);
        gameQueryWrapper.eq(Game::getIsDelete, 0);
        List<GameVo> gameVoList = gameMapper.selectList(gameQueryWrapper).stream()
                .map(GameVo::new)
                .collect(Collectors.toList());
        Map<String, Object> data = new HashMap<>();
        data.put("gameList", gameVoList);

        LambdaQueryWrapper<Competition> competitionQueryWrapper = new LambdaQueryWrapper<>();
        competitionQueryWrapper.eq(Competition::getId, id);
        Competition competition = competitionMapper.selectOne(competitionQueryWrapper);

        data.put("competitionInfo", new CompetitionVo(competition));

        return Response.success(data);
    }

    @Override
    public Response getCompetitionList(Integer id) {
        List<CompetitionVo> competitionVoList = competitionMapper.getCompetitionByUserId(id).stream()
                .map(CompetitionVo::new)
                .collect(Collectors.toList());
        return Response.success(competitionVoList);
    }

    @Override
    public Response getSignUpCompetitionList(Integer id) {
        List<SignUpCompetitionVo> signUpCompetitionVoList = competitionMapper.getSignUpCompetitionByUserId(id).stream()
                .map(SignUpCompetitionVo::new)
                .collect(Collectors.toList());
        return Response.success(signUpCompetitionVoList);
    }

    @Override
    public Response getSignUpPersonList(Integer id) {
        List<UserVo> userVoList = competitionMapper.getSignUpPersonList(id).stream()
                .map(UserVo::new)
                .collect(Collectors.toList());
        return Response.success(userVoList);
    }

    @Override
    public Response getHostCompetitionList(String name) {
        List<Integer> competitionIdListWhichHasApproveByOrganizer = competitionMapper.getCompetitionIdListWhichHasApproveByOrganizer(name);
        LambdaQueryWrapper<Competition> competitionQueryWrapper = new LambdaQueryWrapper<>();
        competitionQueryWrapper.eq(Competition::getOrganizer, name);
        competitionQueryWrapper.eq(Competition::getApproveStatus, 2);
        List<CompetitionVo> competitionVoList = competitionMapper.selectList(competitionQueryWrapper).stream()
                .map(competition -> {
                    CompetitionVo competitionVo = new CompetitionVo(competition);
                    competitionVo.setHasApprove(competitionIdListWhichHasApproveByOrganizer.stream()
                            .anyMatch(has -> competition.getId().equals(has)));
                    return competitionVo;
                })
                .collect(Collectors.toList());
        return Response.success(competitionVoList);
    }

    @Override
    public Response signUp(SignUpVo signUpVo) {
        LambdaQueryWrapper<SignUp> signUpCheckQueryWrapper = new LambdaQueryWrapper<>();
        signUpCheckQueryWrapper.eq(SignUp::getCompetitionId, signUpVo.getCompetitionId());
        signUpCheckQueryWrapper.eq(SignUp::getUserId, signUpVo.getUserId());
        signUpCheckQueryWrapper.ne(SignUp::getStatus, -1);
        SignUp signUp = signUpMapper.selectOne(signUpCheckQueryWrapper);
        if (!ObjectUtils.isEmpty(signUp) && signUp.getStatus() != -1) {
            return Response.error("您已经报名过该比赛");
        }
        signUpMapper.insert(new SignUp(signUpVo.getUserId(), signUpVo.getCompetitionId()));
        return Response.success("报名成功！", null);
    }

    @Override
    public Response getApproveList(Integer id) {
        LambdaQueryWrapper<SignUp> signUpLambdaQueryWrapper = new LambdaQueryWrapper<>();
        signUpLambdaQueryWrapper.eq(SignUp::getCompetitionId, id);
        signUpLambdaQueryWrapper.eq(SignUp::getIsDelete, 0);
        List<SignUpVo> approveList = signUpMapper.selectList(signUpLambdaQueryWrapper).stream()
                .map(signUp -> {
                    SignUpVo signUpVo = new SignUpVo(signUp);
                    LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
                    userLambdaQueryWrapper.eq(User::getId, signUp.getUserId());
                    signUpVo.setUsername(userMapper.selectOne(userLambdaQueryWrapper).getName());
                    return signUpVo;
                })
                .collect(Collectors.toList());
        return Response.success(approveList);
    }

    @Override
    public Response approve(SignUpVo signUpVo) {
        LambdaQueryWrapper<SignUp> signUpLambdaQueryWrapper = new LambdaQueryWrapper<>();
        signUpLambdaQueryWrapper.eq(SignUp::getId, signUpVo.getId());
        SignUp signUp = signUpMapper.selectOne(signUpLambdaQueryWrapper);
        signUp.setStatus(signUpVo.getStatus());
        signUp.setComment(signUpVo.getComment());
        signUp.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        int i = signUpMapper.updateById(signUp);
        if (i > 0) {
            return Response.success("审批成功！", null);
        }
        return Response.error("审批失败！");
    }

    @Override
    public Response signUpGroup(SignUpGroupVo signUpGroupVo) {
        Integer competitionId = signUpGroupVo.getCompetitionId();
        List<String> playerList = signUpGroupVo.getPlayerList();
        playerList.add(signUpGroupVo.getCharger());
        playerList = playerList.stream()
                .distinct()
                .collect(Collectors.toList());
        for (String playerId : playerList) {
            LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
            userLambdaQueryWrapper.eq(User::getUsername, playerId);
            User user = userMapper.selectOne(userLambdaQueryWrapper);
            if (ObjectUtils.isEmpty(user)) {
                return Response.error("队员'" + playerId + "'未注册油比赛");
            }
            LambdaQueryWrapper<SignUp> signUpCheckQueryWrapper = new LambdaQueryWrapper<>();
            signUpCheckQueryWrapper.eq(SignUp::getCompetitionId, signUpGroupVo.getCompetitionId());
            signUpCheckQueryWrapper.eq(SignUp::getUserId, user.getId());
            SignUp signUp = signUpMapper.selectOne(signUpCheckQueryWrapper);
            if (!ObjectUtils.isEmpty(signUp) && signUp.getStatus() != -1) {
                return Response.error("队员'" + playerId + "'已经报名过该比赛");
            }

            // todo 事务回滚
            SignUpVo signUpVo = new SignUpVo();
            signUpVo.setCompetitionId(competitionId);
            signUpVo.setUserId(user.getId());
            signUp(signUpVo);
        }
        return Response.success("报名成功！", null);
    }

    @Override
    public Response getApplyCompetitionList(String organizer) {
        LambdaQueryWrapper<Competition> competitionLambdaQueryWrapper = new LambdaQueryWrapper<>();
        competitionLambdaQueryWrapper.eq(Competition::getIsDelete, 0);
        competitionLambdaQueryWrapper.eq(Competition::getOrganizer, organizer);
        List<CompetitionVo> competitionVoList = competitionMapper.selectList(competitionLambdaQueryWrapper).stream()
                .map(CompetitionVo::new)
                .collect(Collectors.toList());
        return Response.success(competitionVoList);
    }

    @Override
    public Response getInstitutionApproveCompetitionList(String organizer) {
        List<CompetitionVo> competitionVoList = competitionMapper.getInstitutionApproveCompetitionList(organizer).stream()
                .map(CompetitionVo::new)
                .collect(Collectors.toList());
        return Response.success(competitionVoList);
    }

    @Override
    public Response getSchoolApproveCompetitionList(String organizer) {
        LambdaQueryWrapper<Competition> competitionLambdaQueryWrapper = new LambdaQueryWrapper<>();
        competitionLambdaQueryWrapper.eq(Competition::getApproveStatus, 1);
        List<CompetitionVo> competitionVoList = competitionMapper.selectList(competitionLambdaQueryWrapper).stream()
                .map(CompetitionVo::new)
                .collect(Collectors.toList());
        return Response.success(competitionVoList);
    }

    @Override
    public Response schoolApprove(ApproveVo approveVo) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        LambdaQueryWrapper<Competition> competitionLambdaQueryWrapper = new LambdaQueryWrapper<>();
        competitionLambdaQueryWrapper.eq(Competition::getId, approveVo.getCompetitionId());
        Competition competition = competitionMapper.selectOne(competitionLambdaQueryWrapper);
        competition.setApproveCommentSchool(approveVo.getComment());
        competition.setApproveTimeSchool(timestamp);
        competition.setUpdateTime(timestamp);
        competition.setApproveStatus(approveVo.getStatus());
        int i = competitionMapper.updateById(competition);
        if (i > 0) {
            return Response.success("审批成功！", null);
        }
        return Response.error("审批失败！");
    }

    @Override
    public Response institutionApprove(ApproveVo approveVo) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        LambdaQueryWrapper<Competition> competitionLambdaQueryWrapper = new LambdaQueryWrapper<>();
        competitionLambdaQueryWrapper.eq(Competition::getId, approveVo.getCompetitionId());
        Competition competition = competitionMapper.selectOne(competitionLambdaQueryWrapper);
        competition.setApproveCommentInstitute(approveVo.getComment());
        competition.setApproveTimeInstitute(timestamp);
        competition.setUpdateTime(timestamp);
        competition.setApproveStatus(approveVo.getStatus());
        int i = competitionMapper.updateById(competition);
        if (i > 0) {
            return Response.success("审批成功！", null);
        }
        return Response.error("审批失败！");
    }

    @Override
    public Response addGame(GameVo gameVo) {
        Game game = new Game(gameVo);
        game.setFinish(0);
        game.setIsDelete(0);
        game.setCreateTime(new Timestamp(System.currentTimeMillis()));
        int insert = gameMapper.insert(game);
        if (insert > 0) {
            return Response.success("添加成功！", null);
        }
        return Response.error("添加失败！");
    }

    @Override
    public Response editGameScore(ScoreVo scoreVo) {
        LambdaQueryWrapper<Game> gameLambdaQueryWrapper = new LambdaQueryWrapper<>();
        gameLambdaQueryWrapper.eq(Game::getId, scoreVo.getGameId());
        Game game = gameMapper.selectOne(gameLambdaQueryWrapper);
        game.setHomeScore(scoreVo.getHomeScore());
        game.setVisitScore(scoreVo.getVisitScore());
        if (0 < gameMapper.updateById(game)) {
            return Response.success("成绩录入成功！", null);
        }
        return Response.error("成绩录入失败！");
    }

    @Override
    public Response deleteGame(Integer id) {
        gameMapper.delete(id);
        return Response.success("删除成功！", null);
    }
}
