package com.kwang23;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by jingwanggim on 2017. 3. 4..
 */

@Data
@AllArgsConstructor
public class Pc {
    private String vendor;
    private int clockRate;
    private int ram;
    private String os;
}
