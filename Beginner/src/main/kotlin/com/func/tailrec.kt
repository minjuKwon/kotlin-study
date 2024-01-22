package com.func

import java.math.BigInteger

fun main() {
    
    /*꼬리 재귀 : 재귀 함수를 컴파일 때 반복문,while로 변경. tailrec 사용
    * 스택 오버플로우에 안전*/

    println(factorial1(10L))
    println(factorial2(10L))

    //println(fibonacci1(10000, BigInteger("0"),BigInteger("1")))
    println(fibonacci2(10000, BigInteger("0"),BigInteger("1")))

}

fun factorial1(n:Long):Long{
    return if(n==1L)n else n* factorial1(n-1)
}
tailrec fun factorial2(n:Long, result:Long=1L):Long{
    return if(n==1L) result.toLong() else factorial2(n-1,result*n)
}

//일반 피보나치는 많은 연산에 스택 오버 플로우 발생
fun fibonacci1(range:Int, num1: BigInteger, num2:BigInteger):BigInteger{
    return if(range<=0) num1 else fibonacci1(range-1, num2, num1+num2)
}
tailrec fun fibonacci2(range:Int, num1: BigInteger, num2:BigInteger):BigInteger{
    return if(range<=0) num1 else fibonacci2(range-1, num2, num1+num2)
}