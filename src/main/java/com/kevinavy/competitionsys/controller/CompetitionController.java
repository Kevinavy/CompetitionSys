package com.kevinavy.competitionsys.controller;

import com.kevinavy.competitionsys.model.common.Response;
import com.kevinavy.competitionsys.model.vo.*;
import com.kevinavy.competitionsys.service.CompetitionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/competition")
public class CompetitionController {
    @Resource
    CompetitionService competitionService;

    @PostMapping("/add")
    public Response add(@RequestBody CompetitionVo competition) {
        return competitionService.add(competition);
    }

    @PostMapping("/delete")
    public Response delete(@RequestBody CompetitionVo competition) {
        return competitionService.delete(competition);
    }

    @PostMapping("/update")
    public Response update(@RequestBody CompetitionVo competition) {
        return competitionService.update(competition);
    }

    @GetMapping("/getCompetitionList/{current}/{size}/{keyword}")
    public Response getCompetitionList(@PathVariable Integer current, @PathVariable Integer size, @PathVariable String keyword) {
        return competitionService.getCompetitionList(current, size, keyword);
    }

    @GetMapping("/getCompetitionList/{current}/{size}")
    public Response getCompetitionList(@PathVariable Integer current, @PathVariable Integer size) {
        return competitionService.getCompetitionList(current, size, null);
    }

    @GetMapping("/getCompetitionList/{id}")
    public Response getCompetitionList(@PathVariable Integer id) {
        return competitionService.getCompetitionList(id);
    }

    @GetMapping("/getApplyCompetitionList/{organizer}")
    public Response getApplyCompetitionList(@PathVariable String organizer) {
        return competitionService.getApplyCompetitionList(organizer);
    }

    @GetMapping("/getHostCompetitionList/{name}")
    public Response getHostCompetitionList(@PathVariable String name) {
        return competitionService.getHostCompetitionList(name);
    }

    @GetMapping("/getInstitutionApproveCompetitionList/{organizer}")
    public Response getInstitutionApproveCompetitionList(@PathVariable String organizer) {
        return competitionService.getInstitutionApproveCompetitionList(organizer);
    }

    @GetMapping("/getSchoolApproveCompetitionList/{organizer}")
    public Response getSchoolApproveCompetitionList(@PathVariable String organizer) {
        return competitionService.getSchoolApproveCompetitionList(organizer);
    }

    @GetMapping("/getSignUpCompetitionList/{id}")
    public Response getSignUpCompetitionList(@PathVariable Integer id) {
        return competitionService.getSignUpCompetitionList(id);
    }

    @GetMapping("/getCompetitionDetails/{id}")
    public Response getCompetitionDetails(@PathVariable Integer id) {
        return competitionService.getCompetitionDetails(id);
    }

    @PostMapping("/signUp")
    public Response signUp(@RequestBody SignUpVo signUpVo) {
        return competitionService.signUp(signUpVo);
    }

    @PostMapping("/signUpGroup")
    public Response signUpGroup(@RequestBody SignUpGroupVo signUpGroupVo) {
        return competitionService.signUpGroup(signUpGroupVo);
    }

    @GetMapping("/getSignUpPersonList/{id}")
    public Response getSignUpPersonList(@PathVariable Integer id) {
        return competitionService.getSignUpPersonList(id);
    }

    @GetMapping("/getApproveList/{id}")
    public Response getApproveList(@PathVariable Integer id) {
        return competitionService.getApproveList(id);
    }

    @PostMapping("/approve")
    public Response approve(@RequestBody SignUpVo signUpVo) {
        return competitionService.approve(signUpVo);
    }

    @PostMapping("/schoolApprove")
    public Response schoolApprove(@RequestBody ApproveVo approveVo) {
        return competitionService.schoolApprove(approveVo);
    }

    @PostMapping("/institutionApprove")
    public Response institutionApprove(@RequestBody ApproveVo approveVo) {
        return competitionService.institutionApprove(approveVo);
    }

    @PostMapping("/addGame")
    public Response addGame(@RequestBody GameVo gameVo) {
        return competitionService.addGame(gameVo);
    }

    @PostMapping("/editGameScore")
    public Response editGameScore(@RequestBody ScoreVo scoreVo) {
        return competitionService.editGameScore(scoreVo);
    }

    @GetMapping("/deleteGame/{id}")
    public Response deleteGame(@PathVariable Integer id) {
        return competitionService.deleteGame(id);
    }




}
