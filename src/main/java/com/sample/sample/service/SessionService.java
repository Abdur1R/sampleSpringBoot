package com.sample.sample.service;

import com.sample.sample.Repository.UserDetailsRepo;
import com.sample.sample.configurations.HttpSessionConfig;
import com.sample.sample.model.Session;
import com.sample.sample.Repository.CustomSessionRepository;
import com.sample.sample.model.UserDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Calendar;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.List;

@Service
public class SessionService {

    @Autowired
    private CustomSessionRepository sessionRepository;

    @Autowired
    UserDetailsRepo userDetailsRepo;

    public static boolean DateActive(Date date){
        return !date.before((new Date()));
    }

    // Get all sessions for a specific user
    public boolean getUserSessions(String userId) {
        List<Session> activeSession=sessionRepository.findByUserId(userId);
        if (!activeSession.isEmpty()) {
            if(DateActive(activeSession.get(activeSession.size()-1).getExpirationTime())) {
                return true;
            }
            invalidateSession(userId);
        }
        return false;
    }

    public List<Session> getActiveSessions(String userId){
        return sessionRepository.findByUserId(userId);
    }

    // Invalidate a session by ID
    public void invalidateSession(String sessionId) {
        sessionRepository.deleteById(sessionId);
    }

    public static Date getDateThirtyMinutesFromNow() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 30);  // Add 30 minutes to the current time
        return calendar.getTime();
    }

    public void setSession(String userId){
        Session tempObj=new Session();
        UserDetailsDTO userDetails=userDetailsRepo.findByEmailId(userId);
        System.out.println("userDetails "+userDetails+" Date "+new Date());
        tempObj.setExpirationTime(getDateThirtyMinutesFromNow());
        tempObj.setUserId(userId);
        tempObj.setLastAccessedTime(new Date());
        sessionRepository.save(tempObj);
    }
}
