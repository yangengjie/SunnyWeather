package com.example.sunnyweather

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun fibTest() {
        println(fib3(45))
        println(fib(45))
        println(fib2(45))

        println(TestClass().fib(45))

    }

    fun fib2(n: Int): Int {
        if (n <= 1) return n
        var first = 0
        var second = 1
        var sum: Int
        for (i in 0 until n - 1) {
            sum = (first + second) % 1000000007
            first = second
            second = sum
        }
        return second
    }

    //0    1    1    2    3    5    8    13    21    34
    fun fib(n: Int): Int {
        if (n <= 1) return n
        var first = 0
        var second = 1
        for (i in 1 until n) {
            var result = (first + second) % 1000000007
            first = second
            second = result
        }
        return second
    }

    fun fib3(n: Int): Int {
        if (n <= 1) return n
        var first = 0
        var second = 1
        for (i in 1 until n) {
            var result = (first + second) % 1000000007
            first = second
            second = result
        }
        return second
    }
}