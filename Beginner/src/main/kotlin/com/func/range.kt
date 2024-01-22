package com.func

fun main() {
    
    /*최상위 함수 : main() 또는 사용자 정의 함수. 선언 순서 영향 X*/
    a()
    c()

    /*지역 함수 : 함수 안에 함수 선언 및 구현한 함수. 선언 순서에 영향*/
    //e() //e()는 c()내 함수이기에 main()에서 호출 불가능
    
    /*전역 변수 : 최상위 변수. 프로그램의 라이크 사이클과 동일
    * 메모리 차지하기에 사용에 주의 필요.
    * 다른 함수(패키지)에서 접근이 가능하기에 동기화 작업 필요*/
    outside()
    outside()

    /*지역 변수 : 함수 내 변수. 함수가 종료되면 함께 소멸*/
    val value1=10
    val value2=30
    fun inside(){
        gobal++
        val value1=20
        println("outside() - global : $gobal, value1 : $value1, value2 : $value2")
    }
    inside()
    inside()
    
}

fun a()=b()
fun b(){
    println("b()")
}
fun c(){
    println("c()")
    fun e(){
        println("e()")
    }
    fun d()=e()
    //e()와 d()는 c()안에서 구현되었기에 c()안에서의 호출은 문제 X
    d()
    e()
}

var gobal =1
fun outside(){
    gobal++
    val value=1
    println("outside() - global : $gobal, value : $value")
}