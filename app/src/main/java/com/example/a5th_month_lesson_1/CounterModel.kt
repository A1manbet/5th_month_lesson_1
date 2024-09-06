package com.example.a5th_month_lesson_1

class CounterModel {
    private var count = 0

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }

    fun getCount() = count
}