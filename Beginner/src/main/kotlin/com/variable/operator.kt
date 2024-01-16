package com.variable

fun main() {

    /* % : 나머지 연산 */
    val n1=3
    if(n1%2==0){
        println("$n1 : 짝수")
    }else{
        println("$n1 : 홀수")
    }
    
    /* = : 대입 연산 */
    val n2 = 2//2가 n2에 대입
    val n3= n1+n2//n1+n2 연산 후 n3에 대입

    /*복합 대입 연산자*/
    var n4=1
    println("n4 : $n4")
    n4+=1
    println("n4 : $n4")
    n4-=1
    println("n4 : $n4")
    n4*=2
    println("n4 : $n4")
    n4/=2
    println("n4 : $n4")
    
    /*증감 연산자*/
    var n5=10
    var n6=10
    val result1=n5++
    val result2=++n6
    println("result1(n5++) : $result1")
    println("result2(++n6) : $result2")
    println("n5 : $n5")
    println("n6 : $n6")
    
    /*비교 연산자*/
    println("n5==n6 : ${n5==n6}")
    println("n5!=n6 : ${n5!=n6}")
    println("result1<result2 : ${result1<result2}")
    println("result1>result2 : ${result1>result2}")

    /*논리 연산자*/
    println("(1>2)&&(2<3) : ${(1>2)&&(2<3)}")//왼쪽항이 false, 오른항 검사X
    println("(1>2)||(2<3) : ${(1>2)||(2<3)}")//왼쪽항이 true, 오른항 검사X
    println("(1>2) : ${(1>2)}")
    println("!(1>2) : ${!(1>2)}")

    var char='c'.toInt()
    if((char>='A'.toInt())&&(char<='Z'.toInt())){
        println("$char : 대문자")
    }
    if((char>='a'.toInt())&&(char<='z'.toInt())){
        println("$char : 소문자")
    }
    
    /*비트 이동 연산자*/
    println("1*2 : ${1*2}")
    println("1.shl(1) : ${1.shl(1)}")
    println("1 shl 1 : ${1 shl 1}")
    println("8/2 : ${8/2}")
    println("8.shr(1) : ${8.shr(1)}")
    println("8 shr 1 : ${8 shr 1}")
    println("2 shr 1 : ${2 shr 1}")
    println("2 ushr 1 : ${2 ushr 1}")
    println("-2 shr 1 : ${-2 shr 1}")
    println("-2 ushr 1 : ${-2 ushr 1}")
    
    /*비트 연산자*/
    println("3 and 4 : ${3 and 4}")//논리곱
    println("3 or 4 : ${3 or 4}")//논리합
    println("3 xor 4 : ${3 xor 4}")//베타적합
    //xor을 사용하여 별도의 변수 없이 변수 값을 스왑 가능
    var num7=7
    var num8=8
    println("num7 : $num7")
    println("num8 : $num8")
    num7=num7 xor num8
    num8=num7 xor num8
    num7=num7 xor num8
    println("num7 : $num7")
    println("num8 : $num8")

    /* inv : 모든 비트를 반대로 뒤집음 */
    println("num8($num8).inv() : ${num8.inv()}")

}