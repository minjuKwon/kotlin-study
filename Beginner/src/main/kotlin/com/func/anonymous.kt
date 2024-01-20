package com.func

fun main() {
    
    /*익명 함수 : 이름 없는 일반함수*/
    fun(x:Int, y:Int):Int=x+y
    fun(x:Int, y:Int)=x+y
    //변수의 매개변수 타입 명시하여 함수의 매개변수 타입 생략
    val result:(Int,Int)->Int=fun(x,y)=x+y
    result(1,2)//변수를 함수처럼 사용 가능

    /*람다식에서 return 사용*/
    label1()
    label2()

}

/*익명 함수는 람다식과 비슷하지만
* 람다식에는 return, break 등을 사용하지 못함
* 람다식에서 사용하고 싶으면 라벨을 사용해야함
* C의 goto와 비슷*/
//코드 출처 : https://kotlinlang.org/docs/returns.html
fun label1(){
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // local return to the caller of the lambda - the forEach loop
        print("$it ")
    }
    println(" done with explicit label")
}
fun label2(){
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // local return to the caller of the lambda - the forEach loop
        print("$it ")
    }
    println(" done with implicit label")
}