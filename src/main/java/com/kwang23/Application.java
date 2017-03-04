package com.kwang23;

import lombok.AllArgsConstructor;

/**
 * Created by jingwanggim on 2017. 3. 4..
 */
@AllArgsConstructor
public class Application {
    private Service service;

    public void run(){
        service.start();
        service.doWork();
        service.stop();
    }
}
