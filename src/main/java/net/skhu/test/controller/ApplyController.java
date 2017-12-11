package net.skhu.test.controller;

import net.skhu.test.dto.Apply;
import net.skhu.test.dto.Mentoring;
import net.skhu.test.service.ApplyService;
import net.skhu.test.service.AuthorizationService;
import net.skhu.test.service.FileUploadService;
import net.skhu.test.service.MentoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by ds on 2017-12-10.
 */
@Controller
public class ApplyController {

    @Autowired
    ApplyService applyService;

    @Autowired
    MentoringService mentoringService;

    @Autowired
    FileUploadService fileUploadService;

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
    public String mentorApply(Model model, HttpServletRequest request, @RequestParam(value = "a_id", defaultValue = "0", required = false) int a_id) {
        if (request.isRequestedSessionIdValid()) {
            //신청서 수정 페이지
            if (a_id != 0) {
                model.addAttribute("apply", applyService.findOne(a_id));
            } else {
                model.addAttribute("apply", new Apply());
            }
            model.addAttribute("user", AuthorizationService.getCurrentUser());
            return "mentor-apply";
        }
        return "redirect:login";
    }

    //멘토 신청
    @PostMapping(value = "mentor-apply")
    public String mentorApply2(Model model, HttpServletRequest request, Apply apply, String button, @RequestParam(value = "a_id", defaultValue = "0", required = false) int a_id) throws IOException {
        if (request.isRequestedSessionIdValid()) {
            String url = fileUploadService.upload(apply.getA_file());
            apply.setA_fileUrl((url == null) ? request.getParameter("a_fileUrl") : url);
            //신청서 작성
            if(a_id == 0) {
                apply.setID(AuthorizationService.getCurrentUser().getID());
                return "redirect:room?a_id=" + applyService.insert(apply);
            }
            //신청서 수정
            else {
                applyService.editOrDelete(button, apply);
                return "redirect:mentor-apply?a_id=" + a_id;
            }
        }
        return "redirect:login";
    }

    //나의 멘토방
    @GetMapping(value = "room")
    public String room(Model model, HttpServletRequest request, @RequestParam(value = "a_id", defaultValue = "0", required = false) int a_id) {
        if (request.isRequestedSessionIdValid()) {
            int result = applyService.checkMento(AuthorizationService.getCurrentUser().getID(), a_id);
            if(result > 0) {
                //멘토
                if(result == 1) {
                    model.addAttribute("auth", true);
                }
                //멘티
                else {
                    model.addAttribute("auth", false);
                }
                model.addAttribute("a_id", a_id);
                return "room";
            }else {
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
            int percent = mentoringService.showCount(a_id, mentoring.getA_num());
            model.addAttribute("percent", percent);
            model.addAttribute("check", mentoringService.check(a_id, AuthorizationService.getCurrentUser().getID(), percent));
            return "mentee-apply";
        }
        return "redirect:login";
    }

    //멘토링 신청
    @PostMapping(value = "mentee-apply")
    public String menteeApply2(Model model, HttpServletRequest request, @RequestParam(value = "a_id", defaultValue = "0", required = false) int a_id) {
        if(request.isRequestedSessionIdValid()) {
            mentoringService.register(a_id, AuthorizationService.getCurrentUser().getID());
            return "redirect:room?a_id=" + a_id;
        }
        return "redirect:login";
    }
}
