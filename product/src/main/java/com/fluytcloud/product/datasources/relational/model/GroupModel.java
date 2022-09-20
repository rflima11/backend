package com.fluytcloud.product.datasources.relational.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT_GROUP",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "UQ_GROUP_NAME", columnNames = "NAME"
                )}
)
public class GroupModel {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", length = 50)
    private String name;

    public Integer getId() {
        return id;
    }

    public GroupModel setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GroupModel setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupModel that = (GroupModel) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
