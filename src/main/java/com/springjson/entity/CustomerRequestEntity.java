package com.springjson.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "customerReq_tab")
public class CustomerRequestEntity {
    @Id
    @TableGenerator(name = "customerReq_id_generator", table = "json_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue = "customerReq_id", initialValue = 0, allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "customerReq_id_generator")
    private Long id;

    private List<CustomerEntity> customers;
}
