package com.springjson.model;

import com.springjson.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

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

    public AddressModel(AddressEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
