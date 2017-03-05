package com.kwang23

import spock.lang.Specification


/**
 * Created by jingwanggim on 2017. 3. 5..
 */
class PublisherSpec extends Specification {
    Publisher publisher = new Publisher();
    Subscriber subscriber = Mock()
    Subscriber subscriber2 = Mock()

    def setup() {
        publisher.subscribers << subscriber
        publisher.subscribers << subscriber2
    }

    def "should send messges to all subscribers"() {
        when:
        publisher.send("Hello")

        then:
        1 * subscriber.receive("Hello")
        1 * subscriber2.receive("Hello")

        // cardinality
//        1 * subscriber.receive("hello")      // exactly one call
//        0 * subscriber.receive("hello")      // zero calls
//        (1..3) * subscriber.receive("hello") // between one and three calls (inclusive)
//        (1.._) * subscriber.receive("hello") // at least one call
//        (_..3) * subscriber.receive("hello") // at most three calls
//        _ * subscriber.receive("hello")      // any number of calls, including zero
        // (rarely needed; see 'Strict Mocking')

        // method constraint
//        1 * subscriber./r.*e/("hello")  // a method whose name matches the given regular expression
                                          // (here: method name starts with 'r' and ends in 'e

//        1 * subscriber.status // same as: 1 * subscriber.getStatus()
//        1 * subscriber.setStatus("ok") // NOT: 1 * subscriber.status = "ok"

        // Argument Constraints
//        1 * subscriber.receive("hello")     // an argument that is equal to the String "hello"
//        1 * subscriber.receive(!"hello")    // an argument that is unequal to the String "hello"
//        1 * subscriber.receive()            // the empty argument list (would never match in our example)
//        1 * subscriber.receive(_)           // any single argument (including null)
//        1 * subscriber.receive(*_)          // any argument list (including the empty argument list)
//        1 * subscriber.receive(!null)       // any non-null argument
//        1 * subscriber.receive(_ as String) // any non-null argument that is-a String
//        1 * subscriber.receive({ it.size() > 3 }) // an argument that satisfies the given predicate
                                                    // (here: message length is greater than 3)
    }

}