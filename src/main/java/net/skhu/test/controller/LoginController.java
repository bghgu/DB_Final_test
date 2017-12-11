package net.skhu.test.controller;

import net.skhu.test.dto.User;
import net.skhu.test.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by ds on 2017-12-09.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    ExcelService excelService;

    //메인(로그인) 페이지
    @GetMapping(value = {"", "/login"})
    public String login(Model model) {
        return "login";
    }

    //회원 업로드 페이지
    @GetMapping(value = "upload")
    public String upload(Model model) {
        return "upload";
    }

    //회원 업로드
    @PostMapping("upload")
    public String uploading(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
        MultipartFile file = mhsr.getFile(mhsr.getFileNames().next());
        if(!file.isEmpty()) {
            List<User> users = excelService.excelUpload(file);
            model.addAttribute("users", users);

        }else {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('파일을 선택해 주세요.'); history.go(-1);</script>");
            out.flush();
        }
        return "upload";
    }

}
