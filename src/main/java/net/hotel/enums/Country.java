package net.hotel.enums;

public enum Country {
    USA("USA"),
    UKRAINE("Ukraine"),
    UK("UK");

    private String name;

    Country(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
}
