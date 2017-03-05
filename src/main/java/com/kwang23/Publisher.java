package com.kwang23;

import org.reactivestreams.*;
import org.springframework.cglib.core.CollectionUtils;

import java.util.*;

/**
 * Created by jingwanggim on 2017. 3. 5..
 */
public class Publisher {
    List<Subscriber> subscribers = new ArrayList<>();
    void send(String message){
        subscribers.stream().forEach(sub -> sub.receive(message));
    }
}
