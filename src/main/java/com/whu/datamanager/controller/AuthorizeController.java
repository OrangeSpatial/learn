package com.whu.datamanager.controller;

import com.whu.datamanager.dto.AccessTokenDTO;
import com.whu.datamanager.dto.GetGitHubCode;
import com.whu.datamanager.dto.GitHubUser;
import com.whu.datamanager.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @Value("${gitHub.gitOauth}")
    private String gitOauth;
    @Value("${gitHub.gitHub_clientID}")
    private String gitHub_clientID;
    @Value("${gitHub.gitHub_backUrl}")
    private String gitHub_backUrl;
    @Value("${gitHub.scope}")
    private String scope;
    @Value("${gitHub.state}")
    private String state;
    @Value("${gitHub.client_secret}")
    private String client_secret;

    @RequestMapping("/gitHubLogin")
    public void gitHubLogin(HttpServletResponse response) throws IOException {
        response.sendRedirect(gitOauth+"?client_id="+gitHub_clientID+"&redirect_uri="+gitHub_backUrl+"&scope="+scope+"&state="+state);
    }

    @GetMapping("/back")
    public String callback(@RequestParam(name = "code") String code,@RequestParam(name="state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("cbf389702e8efba2684e");
        accessTokenDTO.setClient_secret("1401625efbaeeca820f96d762af9cd2c2227d1f5");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8989/back");
        accessTokenDTO.setState(state);
        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        GitHubUser user = gitHubProvider.getUser(accessToken);
        System.out.println(user);
        return "404";
    }





}
