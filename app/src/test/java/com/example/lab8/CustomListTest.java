package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */

    public CustomList MockCityList(){
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    @Test
    public void hasCityTest(){
        list = MockCityList();
        City searcher = new City("Vegreville", "AB");
        list.addCity(searcher);
        assert(list.getCount() > 0);
        assert(list.hasCity(searcher));
    }

    @Test
    public void deleteCityTest(){
        list = MockCityList();
        assert(list.getCount()==0);
        City deleter = new City("Mundare", "AB");
        list.addCity(deleter);
        assert(list.getCount() == 1);
        list.deleteCity(deleter);
        assert(list.getCount() == 0);
    }

    @Test
    public void getCountTest(){
        list = MockCityList();
        int currLen = list.getCount();
        City increase = new City("Lloydminster", "AB");
        list.addCity(increase);
        assertEquals(currLen+1, list.getCount());
        list.deleteCity(increase);
        assertEquals(0, list.getCount());
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size+1
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize+1);
    }
}

