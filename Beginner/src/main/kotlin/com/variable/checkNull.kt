package com.variable

fun main() {

    /*코틀린에서는 변수에 null 허용하지 않음
    null 할당을 허용하려면 자료형 뒤에 ?를 붙여야함*/
    var str1: String?
    str1=null
    var str2: String="포도"
    //str2=null
    //String?이 아니기에 오류 발생
    //String과 String? 타입은 서로 다른 타입임

    /*세이프 콜(?.) : null이 할당될 수 있는 변수를 검사하여 안전하게 호출*/
    println("str1($str1) length : ${str1?.length}")
    println("str2($str2) length : ${str2?.length}")

    /*non-null 단정 기호(!!) : 변수 할당 값이 null이 아님을 단정함
    별도의 null 검사를 진행하지 않기에 값이 null일 경우 오류 발생*/
    println("str2($str2) length : ${str2!!.length}")
    //printLen(str1) 오류 발생
    
    /*조건문으로 null 검사*/
    val len=if(str1!=null) str1.length else -1
    println("str1($str1) length : $len")

    /*엘비스 연산자(?:) : null 검사해주는 연산자
     null이면 오른쪽, null이 아니면 왼쪽 코드 실행*/
    println("str1($str1) length : ${str1?.length?:-1}")

    /*코틀린에는 삼항 연산자 지원 X*/

}

fun printLen(str:String?){
    val output:String=str!!
    println(output.length)
}

