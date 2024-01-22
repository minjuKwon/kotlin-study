package com.func

fun main() {

    /*인라인 함수 : 함수 본문의 내용을 모두 복사하여 함수를 재호출하지 않고
    * 복사한 내용을 그대로 사용. 함수 본문이 짧을 때만 사용*/

    remember1(1){println("함수 첫 번째 호출 : $it")}
    remember1(2){println("함수 두 번째 호출 : $it")}

    //역컴파일하면 remember()가 본문에 복사된 것을 알 수 있음
    //Tools -> Kotlin->Show Kotlin Bytecode, Decompile 버튼
    remember2(1){println("inline 함수 첫 번째 호출 : $it")}
    remember2(2){println("inline 함수 두 번째 호출 : $it")}

    //매개변수 람다 또는 함수 본문 내용이 길면 성능 저하 문제 발생
    //noinline으로 부분적 인라인 처리 방지.
    remember3(1){println("noinline 함수 첫 번째 호출 : $it")}
    remember3(2){println("noinline 함수 두 번째 호출 : $it")}

    //비지역 반환 : 호출되지 않는 함수 코드 지역 발생
    //여기서는 str 람다식 이후 return 되어 str 람다식 다음 코드인
    //println("람다 호출 후")가 호출 X
    //inline 키워드가 없으면 return 사용 불가
 /*   remember2(3){
        println("inline 함수 첫 번째 호출 : $it")
        return
    }*/

    //crossinline : 비지역 반환 금지
    remember4(4){
        println("crossinline 함수 첫 번째 호출 : $it")
        //return
    }

    //reified : 제네릭에 사용
    remember6(5)

}

fun remember1(a:Int, str:(Int)->Unit){
    println("람다 호출 전")
    str(a)
    println("람다 호출 후")
}

inline fun remember2(a:Int, str:(Int)->Unit){
    println("람다 호출 전")
    str(a)
    println("람다 호출 후")
}

inline fun remember3(a:Int, noinline str:(Int)->Unit){
    println("람다 호출 전")
    str(a)
    println("람다 호출 후")
}

inline fun remember4(a:Int, crossinline str:(Int)->Unit){
    println("람다 호출 전")
    str(a)
    println("람다 호출 후")
}

inline fun <T> remember5(a:T){
    println("a : $a")
    //println("${T::class.simpleName}")
}//T가 무슨 타입인지 알 수 없음 -> reified 키워드 사용
inline fun <reified T> remember6(a:T){
    println("a : $a")
    println("${T::class.simpleName}")
}
