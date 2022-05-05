package com.lab8;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class City extends Land {

    private int id;
    private String name;
    private int country;
    private boolean capital;
    private float latitude;
    private float longitude;
}
