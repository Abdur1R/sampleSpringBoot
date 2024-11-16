package com.sample.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.sample.model.Session;
import com.sample.sample.service.SessionService;

import java.util.List;

@Service
public class SessionControlService {

    private static final int MAX_CONCURRENT_SESSIONS = 3;

    @Autowired
    private SessionService sessionService;

    public void enforceSessionLimit(String userId) {
        List<Session> activeSessions = sessionService.getActiveSessions(userId);
        if (activeSessions.size() >= MAX_CONCURRENT_SESSIONS) {
            // Logic to remove the oldest session or alert the user
            Session oldestSession = activeSessions.get(0); // Assuming sessions are sorted by creationTime
            sessionService.invalidateSession(oldestSession.getUserId());
        }
    }
}

