package com.stream

fun main() {

    for(a in 1..10){
        print("$a ")
    }
    println()
    for(a in 1..10) print("$a ")
    println()

    /*downTo : 하행 반복. 값을 감소하면서 반복될 때는 downTo 키워드 사용*/
    for(a in 10 downTo 1) print("$a ")
    println()

    /*범위를 step만큼 증가시켜줌*/
    for(a in 1..10 step 2) print("$a ")
    println()
    for(a in 2..10 step 2) print("$a ")
    println()

}