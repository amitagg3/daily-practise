package com.amit.javaPractise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/*
Java8 use of GroupingBy
 */

public class FilteringOnBasisOfTypeInClass {

    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Elephant", "J", "Black"));
        animals.add(new Animal("Lion", "J", "Orange"));
        animals.add(new Animal("Parrot", "P", "Green"));
        animals.add(new Animal("Dog", "P", "Black"));
        animals.add(new Animal("Bird", "P", "Green"));

        //Filter all Pet i.e type='P' animals
        //[Parrot, Dog, Bird]
        List<String> petAnimalList = animals.stream().filter(a -> a.getType().equals("P")).map(Animal::getName).collect(Collectors.toList());
        System.out.println(petAnimalList);

        //Group all the animals name based on type
        //{P=[Parrot, Dog, Bird], J=[Elephant, Lion]}
        Map<String, List<String>> groupByType = animals.stream().collect(groupingBy(Animal::getType, Collectors.mapping(Animal::getName, Collectors.toList())));
        System.out.println(groupByType);

        //Group all the animals based on type and color
        //{P={Black=[Dog], Green=[Parrot, Bird]}, J={Black=[Elephant], Orange=[Lion]}}
        Map<String, Map<String, List<String>>> collect1 = animals.stream().collect(groupingBy(Animal::getType, groupingBy(Animal::getColor,
                Collectors.mapping(Animal::getName, Collectors.toList()))));
        System.out.println(collect1);

    }
}

class Animal {
    String name;

    String type;

    String color;


    public Animal(String name, String type, String color) {
        this.name = name;
        this.type = type;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
