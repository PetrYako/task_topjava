package task_topjava;

import org.springframework.security.core.GrantedAuthority;
import task_topjava.model.User;
import task_topjava.to.UserTo;
import task_topjava.util.UserUtil;

import java.util.Collection;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    private UserTo userTo;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.getRoles());
        this.userTo = UserUtil.asTo(user);
    }

    public int getId() { return userTo.id(); }

    public void update(UserTo userTo) { this.userTo = userTo; }

    public UserTo getUserTo() { return userTo; }

    @Override
    public String toString() {
        return userTo.toString();
    }
}
