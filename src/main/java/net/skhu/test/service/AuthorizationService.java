package net.skhu.test.service;

import net.skhu.test.dto.MyAuthenticaion;
import net.skhu.test.dto.User;
import net.skhu.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by ds on 2017-12-09.
 */
@Service
public class AuthorizationService {

    @Autowired
    UserMapper userMapper;

    public User login(String id, String password) {
        User user = userMapper.findByUid(id);
        if(user == null) return null;
        if(user.getU_password().equals(password) == false) return null;
        return user;
    }

    public static User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof MyAuthenticaion)
            return ((MyAuthenticaion) authentication).getUser();
        return null;
    }

    public static void setCurrentUser(User user) {
        ((MyAuthenticaion)
                SecurityContextHolder.getContext().getAuthentication()).setUser(user);
    }

}
