package task_topjava.model.restaurant;

import org.springframework.data.annotation.AccessType;
import task_topjava.model.HasId;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
@AccessType(AccessType.Type.FIELD)
public class AbstractBaseEntity implements HasId {
    private static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq_restaurant", sequenceName = "global_seq_restaurant", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq_restaurant")
    protected Integer id;

    protected AbstractBaseEntity() {}

    protected AbstractBaseEntity(Integer id) { this.id = id; }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractBaseEntity that = (AbstractBaseEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id;
    }
}
