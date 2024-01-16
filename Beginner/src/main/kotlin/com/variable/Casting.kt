package com.variable

fun main() {

    /*타입이 다른 변수에 재할당하면, 자동형변환이 이뤄지지 않음*/
    val a:Int=1
    //val b:Double=a
    val b:Double=a.toDouble()//형변환 메소드 사용 필요
    println("a의 자료형 : ${a.javaClass}")
    a.toDouble()
    println("a의 자료형 : ${a.javaClass}")
    println("b의 자료형 : ${b.javaClass}")

    /*표현식에서 다른 타입끼리 계산한다면, 범위가 큰 자료형으로 자동형변환하여 계산*/
    val c=1F+2

    /*스마트 캐스트 : 컴파일러가 자동으로 형변환 해주는 타입. 대표적으로 Number*/
    var num:Number=1
    println("num($num)의 자료형 : ${num.javaClass}")
    num=2L
    println("num($num)의 자료형 : ${num.javaClass}")
    num=3.14
    println("num($num)의 자료형 : ${num.javaClass}")
    num=4F
    println("num($num)의 자료형 : ${num.javaClass}")

    /*is로 자료형 검사. 검사 후 변수를 해당 자료형으로 변환*/
    if(num is Int){
        println("$num is Int")
    }else{
        println("$num is not Int")
    }
    if(num !is Long){
        println("$num is not Long")
    }

    /*Any : 최상위 기본 클래스. 자바의 Ojbect과 비슷*/
    var x:Any="바나나"
    if(x is String){
        println(x.length)//x는 Any형이었지만 is 검사 후 String으로 자동변환
    }

    /*as : 스마트 캐스트. 가능하지 않는 형변환이면 오류 발생*/
    var v1=2
    //var v2:Long =v1 as //Long 오류 발생
    var v2:Long?=v1 as? Long//캐스팅 실패 시 null로 초기화
    if(v2==null){
        println("v2는 null")
    }else{
        println("v2는 $v2")
    }

    /*묵시적 변환 : 언제든 필요한 자료형으로 자동형변환*/
    var casting:Any
    casting=1
    println("casting($casting)의 자료형 : ${casting.javaClass}")
    casting=3.14
    println("casting($casting)의 자료형 : ${casting.javaClass}")
    casting=false
    println("casting($casting)의 자료형 : ${casting.javaClass}")
    casting = A()
    println("casting : $casting , type : ${casting.javaClass}")
    println("casting : $casting , type : ${casting.javaClass.name}")
    println("casting : $casting , type : ${casting.javaClass.simpleName}")
    casting = number(2)
    println("casting : $num , type : ${casting.javaClass}")
    println("casting : $num , type : ${casting.javaClass.name}")
    println("casting : $num , type : ${casting.javaClass.simpleName}")

}

fun number(x:Int):Int{
    return x
}

class A {
}