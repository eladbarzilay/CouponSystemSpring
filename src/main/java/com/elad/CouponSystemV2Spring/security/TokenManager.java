package com.elad.CouponSystemV2Spring.security;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elad.CouponSystemV2Spring.exeptions.CouponSystemException;
import com.elad.CouponSystemV2Spring.login.ClientType;
import com.elad.CouponSystemV2Spring.service.ClientService;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Component
@Data
public class TokenManager {
    @Autowired
    private Map<String, Information> map;

    public String addToken(ClientService clientService, ClientType clientType, int clientId){
        removePreviewsTokenById(clientId);
        String token = UUID.randomUUID().toString();
        Information information = Information.builder().clientService(clientService).time(LocalDateTime.now()).clientType(clientType).build();
        map.put(token, information);
        return token;
    }

    public void removeToken(String token){
        map.remove(token);
    }

    public ClientService getService(String token){
        Information information = map.get(token);
        return information.getClientService();
    }

    public void isExist(String token) throws CouponSystemException {
        if (!map.containsKey(token)){
            throw new CouponSystemException("You are not welcome :)");
        }
    }

    public void isControllerAllowed(String token, com.elad.CouponSystemV2Spring.security.ClientType customer) throws CouponSystemException {
        Information information = map.get(token);
        if (!information.getClientType().equals(customer)) {
            throw new CouponSystemException("Wrong token... you should try again");
        }
    }

    public void removeExpired(){
        map.entrySet().removeIf(TokenManager::removeExpired30Minutes);
    }

    public void removePreviewsTokenById(int clientId) {
        map.entrySet().removeIf(valueToRemove -> valueToRemove.getValue().getClientId() == clientId);
    }

    public static boolean removeExpired30Minutes(Map.Entry<String,Information> entry){
        return entry.getValue().getTime().isBefore(LocalDateTime.now().minusMinutes(30));
    }
}