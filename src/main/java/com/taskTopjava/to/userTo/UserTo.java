package com.taskTopjava.to.userTo;

import com.taskTopjava.to.BaseTo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

public class UserTo extends BaseTo implements Serializable {
    private static final long serialVersionUID = 4L;

    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @NotBlank
    @Size(min = 5, max = 32)
    private String password;

    private Integer voteId;

    private LocalDateTime voteTime;

    public UserTo() {}

    public UserTo(Integer id, String email, String password, Integer voteId, LocalDateTime voteTime) {
        super(id);
        this.email = email;
        this.password = password;
        this.voteId = voteId;
        this.voteTime = voteTime;
    }

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

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public LocalDateTime getVoteTime() {
        return voteTime;
    }

    public void setVoteTime(LocalDateTime voteTime) {
        this.voteTime = voteTime;
    }

    @Override
    public String toString() {
        return "UserTo{" +
                "email='" + email + '\'' +
                ", voteId=" + voteId +
                ", voteTime=" + voteTime +
                '}';
    }
}
