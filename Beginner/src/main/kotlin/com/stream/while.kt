package com.stream

fun main() {

    var num1=0
    var result1=0
    while(num1 <=10){
        result1+=num1
        num1++
    }
    println(result1)

    do{
        print("숫자 입력:")
        val input= readLine()!!.toInt()
        println(input)
    }while (input!=0)
    println("0을 입력하여 종료합니다.")

}