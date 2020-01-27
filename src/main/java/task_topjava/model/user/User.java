package task_topjava.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Fetch;
import org.springframework.data.annotation.AccessType;
import task_topjava.model.HasEmail;
import task_topjava.model.HasId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")})
@AccessType(AccessType.Type.FIELD)
public class User implements HasId, HasEmail {
    private static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq_user", sequenceName = "global_seq_user", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq_user")
    private Integer id;

    @Column(name = "vote_id")
    private Integer voteId;

    @Column(name = "password", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "vote_time")
    private LocalDateTime voteTime;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Role role;

    public User() {}

    public User(Integer id, Integer voteId, String password, String email, LocalDateTime voteTime, Role role) {
        this.id = id;
        this.voteId = voteId;
        this.password = password;
        this.email = email;
        this.voteTime = voteTime;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getVoteTime() {
        return voteTime;
    }

    public void setVoteTime(LocalDateTime voteTime) {
        this.voteTime = voteTime;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", voteId=" + voteId +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", voteTime=" + voteTime +
                ", role=" + role +
                '}';
    }
}
