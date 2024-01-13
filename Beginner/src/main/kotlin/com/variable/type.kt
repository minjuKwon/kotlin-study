package com.variable

import java.text.DecimalFormat

fun main() {

    /*자바와 달리 코틀린은 자료형을 참조형만을 사용
    컴파일에서 자동으로 기본형으로 변환*/

    /*명시적으로 타입 표현*/
    val number:Int

    /*자동으로 타입을 추론해줌*/
    val color="blue"//String 추론
    val num1=38765432123//int 범위에서 벗어나서 Long 추론
    val num2=12L//접미사 L로 Long 추론
    val num3=0x1//접두어 0x로 16진수, Int 추론
    val num4=0b10//접두어 0b로 2진수, Int 추론

    /*기본적으로 Int로 추론하기 때문에
     작은 범위인 Byte, Short는 명시적으로 표시해야됨*/
    val num5:Byte=123
    val num6:Short=321
    
    /*실수형은 기본적으로 Double로 추론하기 때문에
     Float는 접미사 F 명시적으로 표시해야됨*/
    val num7=3.14
    val num8:Float=3.1412F

    /*부호가 없는 자료형, unsigned는
     u접미사로 명시적으로 표시해야됨*/
    val uNum1:UInt=12u
    val uNum2=2u
    val uNum3:UByte=1u
    val uNum4:UShort=222u
    val uNum5:ULong=12323232u

    /*자료형 최소값과 최대값*/
    println("Byte - MIN : "+Byte.MIN_VALUE+", MAX : "+Byte.MAX_VALUE)
    println("Short - MIN : "+Short.MIN_VALUE+", MAX : "+Short.MAX_VALUE)
    println("Int - MIN : "+Int.MIN_VALUE+", MAX : "+Int.MAX_VALUE)
    println("Long - MIN : "+Long.MIN_VALUE+", MAX : "+Long.MAX_VALUE)
    println("Float - MIN : "+Float.MIN_VALUE+", MAX : "+Float.MAX_VALUE)
    println("Double - MIN : "+Double.MIN_VALUE+", MAX : "+Double.MAX_VALUE)

    /*언더스코어(_)를 이용하여
    값에 영향 없이 자리값을 구분할 수 있음*/
    val money=1_000_000_000
    val cash=0X123_321
    val coin=DecimalFormat("#,###")
    println(coin.format(money))//실제로 구분하려면 DecimalFormat 사용

    /*메모리 한계로 실수를 표현할 때는 부동 소수점 사용*/
    val pie1=3.14E-4
    val pie2=3.14e-4
    val pie3=3.14E4//+는 생략 가능
    val pie4=3.14E+4
    val pie5=3.14e+4
    println("3.14E-4 : "+pie1)
    println("3.14E+4 : "+pie4)
    //실제로는 실수를 정확하게 표현하지 않기에
    //0.1+0.2는 0.3이 아닌 0.30000000000000004이 나옴
    val dNum1=0.1
    val dNum2=0.2
    println(dNum1+dNum2)

    /*컴퓨터는 가산만 가능하기에 2의 보수 사용*/
    val complement1=2
    println("2를 2진수로 표현 : "+Integer.toBinaryString(complement1))//문자열 2진수로 변환
    val complement2=-2
    println("-2를 2진수로 표현 : "+Integer.toBinaryString(complement2))
    val complement3=127
    println("127를 2진수로 표현 : "+Integer.toBinaryString(complement3))
    val complement4=complement3+1
    println("127+1를 2진수로 표현 : "+Integer.toBinaryString(complement4))

    /*논리형*/
    val isTrue=true
    val isFake:Boolean

    /*문자형*/
    val ch1='김'
    val ch2='A'
    println("ch2+1 : "+(ch2+1))
    //코틀린에서는 Char에 아스키코드 번호를 저장하지 못해
    //Int 변수를 toChar()으로 변환 과정을 거쳐야됨
    val ch3=65
    val ch4=ch3.toChar()
    println("ch2 : "+ch2+"->"+ch2.toInt())

    /*문자열은 기본형으로 바뀌지 않는 자료형*/
    /*타입 명시적 or 추론*/
    val str1:String="Cat"
    val str2="Cat"
    val str3="Dog"

    /*$, ${}를 사용하면 문자열 안에 변수나 표현식 출력 가능*/
    val value=1
    println("value : $value")
    println("value+1 = ${value+1}")
    println("")

    /*기호 표현*/
    //이스케이프,\ 사용
    println("\"\$4\"")
    //${''} 사용
    println("${'"'}${'$'}4${'"'}")
    
    /*형식화된 다중 문자열*/
    val b=1
    val string= """
        val a=3
        val index="1"
        println(a+b) (b=${b}) 
    """
    println(string)

    /*typealias로 자료형 별명 붙임
    긴 클래스명 축약이나 명확하게 표시하고 싶을 때 사용
    * */
    val jun:Name="Jun"
    println(jun)

}

typealias Name=String