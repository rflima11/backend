package com.fluytcloud.product.datasources.relational.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PRODUCT_GROUP",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "UQ_PRODUCT_GROUP_NAME", columnNames = {"NAME", "GROUP_ID"}
                )}
)
public class GroupModel {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private GroupModel group;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<GroupModel> subgroups = new HashSet<>();

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

    public GroupModel getGroup() {
        return group;
    }

    public GroupModel setGroup(GroupModel group) {
        this.group = group;
        return this;
    }

    public Set<GroupModel> getSubgroups() {
        return subgroups;
    }

    public GroupModel setSubgroups(Set<GroupModel> subgroups) {
        this.subgroups = subgroups;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupModel that = (GroupModel) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
