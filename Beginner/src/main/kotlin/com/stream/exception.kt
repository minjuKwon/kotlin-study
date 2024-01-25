package com.stream

fun main() {

    try {
        val num1=1
        val num2=0
        val result=num1/num2
        println("result : $result")
    }catch (e : ArithmeticException){
        println("ArithmeticException 예외 발생 : ${e.message}")
        println(e.printStackTrace())
    }catch (e:Exception){
        println("예외 발생 : ${e.message}")
        println(e.printStackTrace())
    }finally {
        println("finally")
    }
    println()

    try {
        var str:String?
        str=null
        printLen(str)
    }catch (e : ArithmeticException){
        println("ArithmeticException 예외 발생 : ${e.message}")
        println(e.printStackTrace())
    }catch (e:Exception){
        println("예외 발생 : ${e.message}")
        println(e.printStackTrace())
    }finally {
        println("finally")
    }
    println()

    try{
        val amount=5
        checkAmount(amount)
    }catch (e:Exception){
        println("예외 발생 : ${e.message}")
    }
    println()

    try {
        val num=0
        checkZero(num)
    }catch (e:ZeroException){
        println("Zero 예외 발생 : ${e.message}")
        println(e.printStackTrace())
    }
    println()

}

fun printLen(str:String?){
    val output:String=str!!
    println(output.length)
}

/*throw: 예외를 의도적으로 발생 시킴*/
fun checkAmount(cash:Int){
    if(cash<1000){
        throw Exception("잔고가 1000이하 입니다. 현재 잔고: $cash")
    }
}

/*사용자 정의 예외 클래스*/
class ZeroException(message:String):Exception(message)
fun checkZero(num:Int){
    if(num==0){
        throw ZeroException("0입니다.")
    }
}