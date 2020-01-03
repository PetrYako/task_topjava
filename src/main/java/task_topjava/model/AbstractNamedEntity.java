package task_topjava.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class AbstractNamedEntity extends AbstractBaseEntity {

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "name", nullable = false)
    protected String name;

    protected AbstractNamedEntity() {}

    protected AbstractNamedEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String name) { this.name = name; }

    public String getName() { return name; }

    @Override
    public String toString() {
        return super.toString() + '(' + name + ')';
    }
}
