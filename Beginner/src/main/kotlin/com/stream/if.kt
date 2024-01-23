package com.stream

fun main() {

    val x=1
    val y=2
    var max:Int
    if(x<y){
        max=y
        println("더 큰 수 : $max")
    }else{
        max=x
        println("더 큰 수 : $max")
    }
    max=if(x<y) y else x
    println("더 큰 수 : $max")
    max=if(x<y){
        println("y가 더 큽니다.")
        y//마지막 줄인 y가 max에 할당
    }else{
        println("x가 더 큽니다.")
        x
    }
    println("더 큰 수 : $max")

    val num=0
    val result=if(num>0) "양수" else if(num<0) "음수" else "0"
    println("result : $result")

    print("점수 : ")
    val score1= readLine()!!.toDouble()
    val grade1:Char
    if(score1>=90){
        grade1='A'
    }else if ((score1>=80)&&(score1<90)){
        grade1='B'
    }else if ((score1>=70)&&(score1<80)){
        grade1='C'
    }else if ((score1>=60)&&(score1<70)){
        grade1='D'
    }else{
        grade1='F'
    }
    println("점수 : $score1 -> 등급 : $grade1")

    print("점수 : ")
    val score2= readLine()!!.toDouble()
    val grade2 = if(score2>=90){
        'A'
    }else if ((score2>=80)&&(score2<90)){
        'B'
    }else if ((score2>=70)&&(score2<80)){
        'C'
    }else if ((score2>=60)&&(score2<70)){
        'D'
    }else{
        'F'
    }
    println("점수 : $score2 -> 등급 : $grade2")

    print("점수 : ")
    val score3= readLine()!!.toDouble()
    val grade3 = if(score3 in 90.0..100.0){
        'A'
    }else if (score3 in 80.0 .. 89.9){
        'B'
    }else if (score3 in 70.0 .. 79.9){
        'C'
    }else if (score3 in 60.0 .. 69.9){
        'D'
    }else{
        'F'
    }
    println("점수 : $score3 -> 등급 : $grade3")

}