package com.elad.CouponSystemV2Spring1.tasks;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

import com.elad.CouponSystemV2Spring1.security.TokenManager;

//@Component
@RequiredArgsConstructor
public class RemoveExpiredToken {
    private final TokenManager tokenManager;

    @Scheduled(fixedRate = 1800000)
    public void removeExpiredTokens() {
        tokenManager.removeExpired();
    }
}