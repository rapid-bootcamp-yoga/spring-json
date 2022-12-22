package com.springjson.model;

import com.springjson.entity.SchoolsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolsModel {
    private String title;
    private String name;
    private String level;

    public SchoolsModel(SchoolsEntity entity){
        BeanUtils.copyProperties(entity, this);
    }
}
