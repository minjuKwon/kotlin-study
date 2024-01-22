package com.func

fun main() {

    /*중위 함수 : 클래스 멤버 호출 시 . 연산자와 소괄호 생략
    * 단 멤머 메소드 또는 확장 함수, 하나의 매개변수, infix 키워드 사용*/
    println(1.hap(2))
    println(1 hap 3)

}

/*일반적인 함수에는 infix 사용 불가
infix fun hap(x:Int):Int{
    return this + x
}*/

infix fun Int.hap(x:Int):Int{
    return this + x
}



