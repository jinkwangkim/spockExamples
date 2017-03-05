package com.kwang23

import org.reactivestreams.Publisher
import org.reactivestreams.Subscriber
import spock.lang.Shared
import spock.lang.Specification

/**
 * reference - https://github.com/spockframework/spock-example
 * Created by jingwanggim on 2017. 3. 1..
 */
class MyFirstSpecification extends Specification{
    // fields
    def setup(){
        // junit 의 @before
        stack = new Stack()
        assert stack.empty
    }

    // fixture methods
    Stack stack
    def cleanup(){
        // junit 의 @After
    }
    def setupSpec(){
        // junit 의 @BeforeClass
    }
    def cleanupSpec(){
        // junit 의 @AfterClass
    }

    // feature methods
    // helper methods
//    def obj = new ClassUnderSpecification()
//    def coll = new Collaborator()

//    @Shared res = new VeryExpensiveResouce()
    static final PI=3.141592

    def "pushing an element on the stack" () {
        setup:
        def stack = new Stack()
        def elem = "push me"

        when:
        stack.push(elem)

        then:
// One to five conditions is a good guideline.
// If you have more than that, ask yourself if you are specifying multiple unrelated features at once.
// If the answer is yes, break up the feature method in several smaller ones.
// If your conditions only differ in their values, consider using a data table.
        !stack.empty
        stack.size() == 1
        stack.peek() == elem
    }

    def "exception condition" () {
        when:
        stack.pop()

        then:
        thrown(EmptyStackException)
        stack.empty

//        def e = thrown(EmptyStackException)
//        e.cause == null

//        EmptyStackException e = thrown()
//        e.cause == null
    }

    def "HashMap accepts null key" () {
        setup:
        def map = new HashMap()

        when:
        map.put(null, "elem")

        then:
        notThrown(NullPointerException)
    }

    def "events are published to all subscribers"() {
//        def subscriber1 = Mock(Subscriber)
//        def subscriber2 = Mock(Subscriber)
//        def publisher = new Publisher()
//        publisher.add(subscriber1)
//        publisher.add(subscriber2)
//
//        when:
//        publisher.fire("event")
//
//        then:
//        1 * subscriber1.receive("event")
//        1 * subscriber2.receive("event")

        // Blocks
//        setup:
//        when:
//        then:
//        expect:
//        where:
//        cleanup:
    }

    def "computing the maximum of two numbers" () {
        expect:
        Math.max(a, b) == c

        where:
        a << [5, 3]
        b << [1, 9]
        c << [5, 9]
    }

    def "offered PC matches preferred configuration"() {
        setup:
        def shop = new Shop()

        when:
        def pc = shop.buyPc()

        then:
        matchesPreferredConfiguration(pc)
    }

    void matchesPreferredConfiguration(pc) {
        assert pc.vendor == "Sunny"
        assert pc.clockRate >= 2333
        assert pc.ram >= 4096
        assert pc.os == "Linux"
    }

    def "verify mock" () {
        def service = Mock(Service)
        def app  = Application(service)

        when:
        app.run()

        then:
        with(service) {
            1 * start()
            1 * doWork()
            1 * stop()
        }
    }

}
