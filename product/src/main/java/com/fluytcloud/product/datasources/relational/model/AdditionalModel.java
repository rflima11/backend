package com.fluytcloud.product.datasources.relational.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT_ADDITIONAL",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "UQ_PRODUCT_ADDITIONAL_NAME", columnNames = "NAME"
                )}
)
public class AdditionalModel {

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

    public AdditionalModel setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AdditionalModel setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getEnable() {
        return enable;
    }

    public AdditionalModel setEnable(Boolean enable) {
        this.enable = enable;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdditionalModel that = (AdditionalModel) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
