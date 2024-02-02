package com.classAndObject

import classAndObject.constructor.Bird1
import classAndObject.constructor.Bird2
import classAndObject.constructor.Bird3

fun main() {

    /*객체 지향 프로그램 : 객체를 모델링하여 객체 간 상호작용으로 표현 확장과 재활용에 유리.
    객체를 속성과 동작을 정의하며 추상화함. 과정대형 소프트웨어에 적합*/
    
    /*클래스 : 객체 생성 틀. 틀이기에 실제 메모리에 존재 X*/

    /*객체 생성으로 메모리에 할당. 구체화 또는 인스턴스화되었다고도 함.
    클래스로부터 만들어진 객체는 그 클래스의 인스턴스.
    .으로 객체의 멤버에 접근*/
    val bird1= Bird1()//생성자 호출
    bird1.color="gray"
    println("bird1.color : ${bird1.color}")
    bird1.body(55)
    bird1.eat()
    
    /*생성자 : 클래스를 통해 객체가 만들어질 때 자동으로 호출되는 메서드.
    * 주생성자와 부생정자가 있음*/
    val bird2= Bird2("crow2", 50, "black", "worm")
    bird2.color="white"
    println("bird2.color : ${bird2.color}")
    bird2.body(45)
    bird2.eat()

    val bird2_1= Bird2("crow3",48)

    val bird3= Bird3("crow4", 50, feed = "fruit")
    bird3.color="blue"
    println("bird3.color : ${bird3.color}")
    bird3.body(53)
    bird3.eat()

}