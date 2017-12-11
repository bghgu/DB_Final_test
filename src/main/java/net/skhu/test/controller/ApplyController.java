package net.skhu.test.controller;

import net.skhu.test.dto.Apply;
import net.skhu.test.dto.Mentoring;
import net.skhu.test.service.ApplyService;
import net.skhu.test.service.AuthorizationService;
import net.skhu.test.service.MentoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ds on 2017-12-10.
 */
@Controller
public class ApplyController {

    @Autowired
    ApplyService applyService;

    @Autowired
    MentoringService mentoringService;

    //멘토링 리스트
    @GetMapping(value = "list")
    public String list(Model model, HttpServletRequest request) {
        if (request.isRequestedSessionIdValid()) {
            model.addAttribute("list", applyService.mentoringList());
            return "list";
        }
        return "redirect:login";
    }

    //멘토 신청
    @GetMapping(value = "mentor-apply")
    public String mentorApply(Model model, HttpServletRequest request) {
        if (request.isRequestedSessionIdValid()) {
            model.addAttribute("user", AuthorizationService.getCurrentUser());
            model.addAttribute("apply", new Apply());
            return "mentor-apply";
        }
        return "redirect:login";
    }

    @PostMapping(value = "mentor-apply")
    public String mentorApply2(Model model, HttpServletRequest request, Apply apply) {
        if (request.isRequestedSessionIdValid()) {
            System.out.println(apply.toString());
            return "mentor-apply";
        }
        return "redirect:login";
    }

    //나의 멘토방
    @GetMapping(value = "room")
    public String room(Model model, HttpServletRequest request, @RequestParam(value = "a_id", defaultValue = "0", required = false) int a_id) {
        if (request.isRequestedSessionIdValid()) {
            int result = applyService.checkMento(AuthorizationService.getCurrentUser().getID(), a_id);
            if(result > 0) {
                if(result == 1) {
                    System.out.println("멘토");
                }else {
                    System.out.println("멘티");
                }
                return "room";
            }else {
                System.out.println("멘토링 신청");
                return "redirect:mentee-apply?a_id="+ a_id;
            }
        }
        return "redirect:login";
    }

    //멘토링 신청
    @GetMapping(value = "mentee-apply")
    public String menteeApply(Model model, HttpServletRequest request, @RequestParam(value = "a_id", defaultValue = "0", required = false) int a_id) {
        if (request.isRequestedSessionIdValid()) {
            Mentoring mentoring = mentoringService.showMentoringInfo(a_id);
            model.addAttribute("mentolist", mentoring);
            model.addAttribute("percent", mentoringService.showCount(a_id, mentoring.getA_num()));
            model.addAttribute("check", mentoringService.check(a_id, AuthorizationService.getCurrentUser().getID()));
            return "mentee-apply";
        }
        return "redirect:login";
    }
}
