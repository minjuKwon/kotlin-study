package com.classAndObject

fun main() {

    /*super : 상위 클래스를 가리키는 키워드. 상위 클래스 주소를 가짐. 현재 클래스와 상위 클래스를 구분해줌.
    * this : 현재 클래스를 가리키는 키워드*/
    val b1=B()
    val c1=C()
    println("B - num: ${b1.num}")
    println("C - num: ${c1.num}")//상위 클래스 B의 num을 받아 가공하여 할당된 값
    println()

    //매개 변수 1개 생성자 호출->this로 2개의 매개변수 생성자 호출->super로 상위 클래스 매개변수 2개의 생성자 호출
    //즉 상위 클래스 매개변수 2개 생성자 출력->현재 클래스 매개변수 2개 생성자 출력->현재 클래스 매개변수 1개 생성자 출력
    val c2=C(1)
    println()

    //부생성자 호출->this로 주생성자 호출->본문 내 람다 호출->init 블록 호출->부생성자 본문 호출(부생성자 본문은 마지막에 호출됨)
    val e1=E(2, 3)
    println()
    //주생성자 호출->본문 내 람다 호출->init 블록 호출
    val e2=E(4)
    println()

    //C 클래스 내부 클래스 E의 info() 호출
    val c3=C()
    c3.E().info()
    println()
    //C 클래스의 info() 호출
    c3.info()
    println()

}