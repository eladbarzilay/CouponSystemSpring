package com.elad.CouponSystemV3Spring.security;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.elad.CouponSystemV3Spring.login.ClientType;
import com.elad.CouponSystemV3Spring.service.ClientService;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Information {
    private int clientId;
    private LocalDateTime time;
    private ClientType clientType;
    private ClientService clientService;
}