package net.hotel.enums;

public enum CityUsa {
    NEWYORK("New York"),
    LOSANGELES("Los Angeles"),
    CHICAGO("Chicago"),
    PHILADELPHIA("Philadelphia"),
    PHOENIX("Phoenix"),
    DALLAS("Dallas");

    private String name;

    CityUsa(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
}

