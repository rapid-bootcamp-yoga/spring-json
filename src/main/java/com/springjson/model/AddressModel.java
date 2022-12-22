package com.springjson.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressModel {

    private String name;
    private String address;
    private String village;
    private String district;
    private String city;
    private String province;

}
