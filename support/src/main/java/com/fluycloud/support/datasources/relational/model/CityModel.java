package com.fluycloud.support.datasources.relational.model;

import javax.persistence.*;

@Entity
@Table(name = "CITY", schema = "PUBLIC")
public class CityModel {

    @Id
    @Column(name = "ID", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", length = 80, insertable = false, updatable = false)
    private String name;

    @Column(name = "STATE_ID", insertable = false, updatable = false)
    private Integer stateId;

    public Integer getId() {
        return id;
    }

    public CityModel setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CityModel setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getStateId() {
        return stateId;
    }

    public CityModel setStateId(Integer stateId) {
        this.stateId = stateId;
        return this;
    }
}
