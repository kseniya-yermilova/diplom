package net.hotel.enums;

public enum CityUk {
    BIRMINGHAM("Birmingham"),
    CAMBRIDGE("Cambridge"),
    CHESTER("Chester"),
    DERBY("Derby"),
    HEREFORD("Hereford"),
    LEEDS("Leeds");

    private String name;

    CityUk(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
}
