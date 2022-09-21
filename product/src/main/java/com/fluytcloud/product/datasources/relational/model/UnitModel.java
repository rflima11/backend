package com.fluytcloud.product.datasources.relational.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UNIT", schema = "PUBLIC")
public class UnitModel {

    @Id
    @Column(name = "ID", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "INITIALS", length = 5, insertable = false, updatable = false)
    private String initials;

    @Column(name = "DESCRIPTION", length = 5, insertable = false, updatable = false)
    private String description;

    @Column(name = "INITIALS_NFE", length = 5, insertable = false, updatable = false)
    private String initialsNfe;

    public Integer getId() {
        return id;
    }

    public UnitModel setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getInitials() {
        return initials;
    }

    public UnitModel setInitials(String initials) {
        this.initials = initials;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UnitModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getInitialsNfe() {
        return initialsNfe;
    }

    public UnitModel setInitialsNfe(String initialsNfe) {
        this.initialsNfe = initialsNfe;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitModel unitModel = (UnitModel) o;

        return Objects.equals(id, unitModel.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
