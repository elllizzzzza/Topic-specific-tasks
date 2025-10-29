package com.expertsoft.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressInfo {

    public AddressInfo() {}

    private String country;
    private String city;
    private String street;
    private Integer houseNumber;
}
