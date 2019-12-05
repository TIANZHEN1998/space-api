package com.scs.web.space.api.controller;

import com.scs.web.space.api.util.Result;
import com.scs.web.space.api.util.ResultCode;
import com.scs.web.space.api.util.VerifyUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @ClassName CodeController
 * @Description TODO
 * @Author 田震
 * @Date 2019/12/3
 **/

@RestController
@RequestMapping(value = "/api/code")
public class CodeController {
    private static final long serialVersionUID = 3398560501558431737L;
    @RequestMapping(value="/authImage",method= RequestMethod.GET)
    public String authImage() {
        return "authImage";
    }
    /**
     * 获取验证码照片
     * @param request
     * @param response
     * @throws IOException
     */

    @RequestMapping(value="/getImage",method=RequestMethod.GET)
    public void CodeController (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        // 生成随机字串
        String verifyCode = VerifyUtil.generateVerifyCode(6);
        // 存入会话session
        HttpSession session = request.getSession(true);
        // 删除以前的
        session.removeAttribute("verCode");
        session.removeAttribute("codeTime");
        session.setAttribute("verCode", verifyCode.toLowerCase());
        session.setAttribute("codeTime", LocalDateTime.now());
        // 生成图片
        int w = 100, h = 30;
        OutputStream out = response.getOutputStream();
        VerifyUtil.outputImage(w, h, out, verifyCode);
    }

    /**
     * 核对验证码
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value="/validImage",method= RequestMethod.GET)
    public String validImage(HttpServletRequest request, HttpSession session) {
        String code = request.getParameter("code");
        Object verCode = session.getAttribute("verCode");
        if (null == verCode) {
            request.setAttribute("errmsg", "验证码已失效，请重新输入");
            return "验证码已失效，请重新输入";
        }
        String verCodeStr = verCode.toString();
        LocalDateTime localDateTime = (LocalDateTime) session.getAttribute("codeTime");
        long past = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        if (verCodeStr == null || code == null || code.isEmpty() || !verCodeStr.equalsIgnoreCase(code)) {
            request.setAttribute("errmsg", "验证码错误");
            return "验证码错误";
        } else if ((now - past) / 1000 / 60 > 5) {
            request.setAttribute("errmsg", "验证码已过期，重新获取");
            return "验证码已过期，重新获取";
        } else {
            //验证成功，删除存储的验证码
            session.removeAttribute("verCode");
            return "200";
        }
    }
}