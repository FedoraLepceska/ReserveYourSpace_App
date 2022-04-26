package com.example.reservespace3.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @Enumerated(value = EnumType.STRING)
    private SpaceType spaceType;

    @Column(length=1000000)
    String url;

    public Space(String name, String address, SpaceType spaceType, String url) {
        this.name = name;
        this.address = address;
        this.spaceType = spaceType;
        this.url = url;
    }

    public Space(String name, String address, SpaceType spaceType) {
        this.name = name;
        this.address = address;
        this.spaceType = spaceType;
    }

    public Space() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SpaceType getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(SpaceType spaceType) {
        this.spaceType = spaceType;
    }
}
