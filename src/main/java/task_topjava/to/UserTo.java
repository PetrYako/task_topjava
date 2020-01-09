package task_topjava.to;

import org.hibernate.validator.constraints.SafeHtml;
import task_topjava.View;
import task_topjava.model.HasEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class UserTo extends BaseTo implements Serializable, HasEmail {
    private static final long serialVersionUID = 3L;

    @Email
    @NotBlank
    @Size(max = 100)
    @SafeHtml(groups = {View.Web.class})
    private String email;

    @NotBlank
    @Size(min = 5, max = 32, message = "length must be between 5 and 32 characters")
    private String password;

    public UserTo() {}

    public UserTo(Integer id, String email, String password) {
        super(id);
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserTo{" +
                "email=" + email;
    }
}
