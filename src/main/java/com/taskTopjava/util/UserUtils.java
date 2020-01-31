package com.taskTopjava.util;

import com.taskTopjava.model.user.User;
import com.taskTopjava.to.userTo.UserTo;

public class UserUtils {

    private UserUtils() {}

    public static UserTo createTo(User user) {
        return new UserTo(user.id(), user.getEmail(), user.getPassword(), user.getVoteId(), user.getVoteTime());
    }

}
