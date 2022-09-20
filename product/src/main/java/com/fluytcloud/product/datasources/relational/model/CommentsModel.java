package com.fluytcloud.product.datasources.relational.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT_COMMENTS",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "UQ_PRODUCT_COMMENTS_NAME", columnNames = "NAME"
                )}
)
public class CommentsModel {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "ENABLE", nullable = false)
    private Boolean enable;

    public Integer getId() {
        return id;
    }

    public CommentsModel setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CommentsModel setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getEnable() {
        return enable;
    }

    public CommentsModel setEnable(Boolean enable) {
        this.enable = enable;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentsModel that = (CommentsModel) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
