package com.example.reservespace3.bootstrap;

import com.example.reservespace3.model.*;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<Space> spaceList = new ArrayList<>();
    public static List<User> userList = new ArrayList<>();
    public static List<Rating> ratingList = new ArrayList<>();
    public static List<City> cityList = new ArrayList<>();
//
//    @PostConstruct
//    public void init(){
//        //String username, String password, String firstName, String lastName, Role role
//        userList.add(new User("flepceska", "123", "Fedora", "Lepceska", Role.USER));
//        userList.add(new User("admin", "123", "Admin", "Admin", Role.ADMIN));
//        userList.add(new User("owner", "123", "Owner", "Owner", Role.HOMEOWNER));
//
//        //String name, String address, SpaceType spaceType
//        spaceList.add(new Space("House", "Partizanski Odredi 2", SpaceType.HOUSE));
//        spaceList.add(new Space("Flat", "Partizanski Odredi 4", SpaceType.FLAT));
//        spaceList.add(new Space("Village", "Partizanski Odredi 6", SpaceType.VILLAGE));
//
//        //String name, String address
//        cityList.add(new City("Skopje"));
//        cityList.add(new City("Veles"));
//        cityList.add(new City("Shtip"));
//        cityList.add(new City("Kumanovo"));
//        cityList.add(new City("Ohrid"));
//        cityList.add(new City("Bitola"));
//
//    }

}
