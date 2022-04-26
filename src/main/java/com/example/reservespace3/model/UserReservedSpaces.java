package com.example.reservespace3.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class UserReservedSpaces {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Space> spaceList;

    public UserReservedSpaces(){
    }

    public UserReservedSpaces(User user){
        this.user=user;
        this.spaceList=new ArrayList<>();
    }
}
