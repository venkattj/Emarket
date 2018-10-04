package com.google.emarket;

class UserProfile {

    private String location;
    private String name;
    private String shop;

public     UserProfile()
    {}

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public UserProfile(String location, String name, String shop) {

        this.location = location;
        this.name = name;
        this.shop = shop;
    }
}
