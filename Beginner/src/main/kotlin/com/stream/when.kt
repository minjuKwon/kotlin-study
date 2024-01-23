package com.stream

fun main() {
    
    /*코틀린에서는 switch 제공X, 대신 when 제공*/

    val num1=1
    when(num1){
        1->println("num1는 1")
        2->println("num1는 2")
        else-> println("num1는 1도 2도 아님")
    }

    val num2=2
    when(num2){
        1,2->println("num2는 2이하 양의 정수")
        else -> println("num2 값을 알 수 없음")
    }

    val num3=3
    print("숫자 : ")
    when(num3){
        Integer.parseInt(readLine()) -> println("입력 값은 3")
        else -> println("입력 값은 3이 아님")
    }

    print("점수 : ")
    val score1= readLine()!!.toDouble()
    val grade1:Char
    when(score1){
        in 90.0 .. 100.0 ->grade1='A'
        in 80.0..89.9->grade1='B'
        in 70.0..79.9->grade1='C'
        in 60.0..69.9->grade1='D'
        in 0.0..59.9->grade1='F'
        else-> {
            println("잘못된 입력 값입니다")
            grade1='#'
        }
    }
    println("점수 : $score1 -> 등급 : $grade1")

    print("점수 : ")
    val score2= readLine()!!.toDouble()
    val grade2:Char
    when{//인자 값이 없으면 좀 더 자유롭게 조건 표현 가능
        score2 >= 100 ->grade2='A'
        score2 in 80.0..89.9->grade2='B'
        (score2>=70)&&(score2<80)->grade2='C'
        score2 in 60.0..69.9->grade2='D'
        score2 in 0.0..59.9->grade2='F'
        else-> {
            println("잘못된 입력 값입니다")
            grade2='#'
        }
    }
    println("점수 : $score2 -> 등급 : $grade2")

    val value=10
    val result=when(value){
        is Int ->"Int형 입니다"
        else -> "Int형이 아닙니다"
    }
    println(result)

    checkType(1)
    checkType(20L)
    checkType('a')
    checkType(println())

}

fun checkType(value:Any){
    when(value){
        1 -> println("Int 1입니다.")
        !is Long ->println("Long 아닙니다.")
        else -> println("알 수 없습니다.")
    }
}