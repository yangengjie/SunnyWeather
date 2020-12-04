package com.example.sunnyweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timeCount(10, this::fib1)
        timeCount(10, this::fib2)
    }


    //0 1 1
    //0 1 2
    fun fib1(n: Int): Long {
        if (n == 0)
            return 0
        else if (n == 1)
            return 1
        return fib1(n - 1) + fib1(n - 2)
    }


    fun fib2(n: Int): Long {
        var first = 0L
        var second = 1L
        var result = 0L
        for (i in 2..n) {
            result = first + second
            first = second
            second = result
        }
        return result
    }


    fun timeCount(n: Int, block: (Int) -> Long) {
        val start = System.currentTimeMillis()
        val result = block(n)
        println("运行结果：$result")
        val end = System.currentTimeMillis()
        println("${(end - start) / 1000}秒")
    }
}