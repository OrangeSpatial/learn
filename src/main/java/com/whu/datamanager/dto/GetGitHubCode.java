package com.whu.datamanager.dto;

import lombok.Data;

@Data
public class GetGitHubCode {

    private String gitOauth;
    private String gitHub_clientID;
    private String gitHub_backUrl;
    private String scope;
    private String state;
}
