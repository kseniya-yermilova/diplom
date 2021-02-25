package net.hotel.enums;

public enum CityUkraine {
    KYIV("Kyiv"),
    LVIV("Lviv"),
    KHARKIV("Kharkiv"),
    DNIPROPETROVSK("Dnipropetrovsk"),
    ODESA("Odesa"),
    DONETSK("Donetsk"),
    ZAPORIZHIA("Zaporizhia"),
    KRIVYIRIG("Krivyi Rih"),
    MYKOLAIV("Mykolaiv");

    private String name;

    CityUkraine(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
}
