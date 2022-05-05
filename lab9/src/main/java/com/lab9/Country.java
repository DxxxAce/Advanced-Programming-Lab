package com.lab9;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Country extends Land {

    private int id;
    private String name;
    private int continent;
    private String code;
}
