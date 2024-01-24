package com.stream

fun main() {

    /*break: 가까운 블록을 빠져나옴*/
    for(i in 1..10){
        if(i==3)
            break
        print("$i ")
    }
    println()
    labelBreak1()
    labelBreak2()

    /*continue: 아래 내용을 실행하지 않고 바로 반복 조건으로 보냄*/
    for(i in 1..10){
        if(i==3)
            continue
        print("$i ")
    }
    println()
    labelContinue1()
    labelContinue2()

}

fun labelBreak1() {
    println("break 시작")
    for(i in 1..3){
        for(j in 1..3){
            if(j==2) break;
            print(" i : $i, j: $j|")
        }
        println()
    }
    println("break 끝")
}
fun labelBreak2() {
    println("break 시작")
    start@for(i in 1..3){
        for(j in 1..3){
            if(j==2) break@start;
            print(" i : $i, j: $j|")
        }
        println()
    }
    println("break 끝")
}

fun labelContinue1() {
    println("continue 시작")
    for(i in 1..3){
        for(j in 1..3){
            if(j==2) continue;
            print(" i : $i, j: $j|")
        }
        println()
    }
    println("continue 끝")
}
fun labelContinue2() {
    println("continue 시작")
    start@for(i in 1..3){
        for(j in 1..3){
            if(j==2) continue@start;
            print(" i : $i, j: $j|")
        }
        println()
    }
    println("continue 끝")
}
