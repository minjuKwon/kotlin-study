package com.func

fun main() {

    /*중위 함수 : 클래스 멤버 호출 시 '.' 연산자와 소괄호 생략. infix 키워드 사용
    * 단 멤머 메소드 또는 확장 함수에 사용가능, 하나의 매개변수를 가짐.
    * 이때 매개변수는 가변인자 불가, 기본 값 사용 불가능.
    * 연산자처럼 사용할 수 있고 적절히 사용 시 가독성 향상*/
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



