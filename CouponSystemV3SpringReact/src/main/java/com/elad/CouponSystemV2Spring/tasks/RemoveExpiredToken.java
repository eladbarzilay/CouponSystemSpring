package com.elad.CouponSystemV2Spring.tasks;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.elad.CouponSystemV2Spring.security.TokenManager;

//@Component
@RequiredArgsConstructor
public class RemoveExpiredToken {
    private final TokenManager tokenManager;

    @Scheduled(fixedRate = 1800000)
    public void removeExpiredTokens() {
        tokenManager.removeExpired();
    }
}