package com.douzone.dzfinal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenPayload {
    private long exp;
    private String user_name;
    private List<String> authorities;
    private String jti;
    private String client_id;
    private List<String> scope;
}
