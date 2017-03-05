package com.kwang23

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll


/**
 * Created by jingwanggim on 2017. 3. 5..
 */
class MathSpec extends Specification {

    def setupSpec() {
        sql.execute("create table maxdata (id int primary key, a int, b int, c int)")
        sql.execute("insert into maxdata values (1, 3, 7, 7), (2, 5, 4, 5), (3, 9, 9, 9)")
    }

    def "maximum number of two numbers"(int a, int b, int c) {
        expect:
        Math.max(1,3) == 3
        Math.max(7,4) == 7
        Math.max(0,0) == 0
        Math.max(a,b) == c

        where:
        // If an iteration fails, the remaining iterations will nevertheless be executed
        a|b|c // header
        1|3|3 // iteration
        7|4|7
        0|0|0
        //expected outputs(||)
//        a|b||c // header
//        1|3||3 // iteration
//        7|4||7
//        0|0||0

        // single-column table
//        where:
//        a | _
//        1 | _
//        3 | _
//        7 | _
    }

    @Unroll
    def "maximum #a and #b is #c"() {
        expect:
        Math.max(a, b) == c

        where:
        a|b|c // header
        1|3|3 // iteration
        7|4|0
        0|0|0

    }

    @Unroll
    def "using data pipe maximum #a and #b is #c"() {
        expect:
        Math.max(a, b) == c

        where:
        // using data pipe
        a << [1,7,0]
        b << [3,4,0]
        c << [3,4,0]
    }

    @Shared sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

    def "using db maximum number of two numbers"() {
        expect:
        Math.max(a,b) == c

        where:
        [a,b,c] << sql.rows("select a,b,c from maxdata")
//        [a,b,_,c] << sql.rows("select * from maxdata") ignored '_'

//        row << sql.rows("select * from maxdata")
//        a = row.a
//        b = row.b
//        c = row.c
    }

    // property access
//    def "#person is #person.age years old"() {}
//    def "#person.name.toUpperCase()"() {} // zero-arg method call

    // invalid
//    def "#person.name.split(' ')[1]" {}  // cannot have method arguments
//    def "#person.age / 2" {}  // cannot use operators

    // complex expression
//    def "#lastName"() { // zero-arg method call
//        ...
//        where:
//        person << [new Person(age: 14, name: 'Phil Cole')]
//        lastName = person.name.split(' ')[1]
//    }
}