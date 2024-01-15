package com.variable

fun main() {

    /*자바에서는, 기본형 값을 비교하기 위헤 ==사용하지만 참조형에서는 주소 값 비교.
     참조형에서 값을 비교하기 위해서는 equals()사용.
     코틀린에서는, 참조형 주소 값을 비교할 때 === 사용.
     즉 자바의 ==와 코틀린의 ===은 같은 역할*/

    //컴파일러가 기본형으로 변환해줌. 즉 스택에 실제 값 저장
    var x:Int = 128
    var y:Int = 128
    println("x == y : ${x==y}")
    println("x === y : ${x===y}") //기본형이기에 ===이라도 실제 값 비교

    var a:Int=128
    val b=a
    var c:Int?=a
    var d:Int?=a
    val e:Int?=c
    println("a == b : ${a==b}")
    println("c == d : ${c==d}")
    println("c === d : ${c===d}")//c와 d는 다른 객체, 즉 다른 주소를 가지기에 false
    println("c == e : ${c==e}")
    println("c === e : ${c===e}")
    println("c == b : ${c==b}")
    //int인 b에 초점을 맞추어져 비교하기에 true
    println("b === c : ${b===c}")
    //nullable인 c에 초점을 맞추어져 null이 될 수 없는 b와 비교하기에 false
    println("c === b : ${c===b}")
    //Int는 기본적으로 -128~127 범위를 캐시하기 때문에
    //범위가 작은 경우 ===로 비교하여도 true가 나올 수 있음
    a=1
    c=a
    d=a
    println("c === d : ${c===d}")

    /*컴파일에서 문자열을 할당하기 전, 같은 문자열을 존재하는지 확인
    이미 저장된 값을 활용하기 때문에 str3 값은 힙에 새롭게 할당되지 않음.
    같은 문자열을 가진 str1가 생성한 문자열를 가리킴
    즉, str1와 str3은 같은 주소 값을 가짐*/
    val str1="Pink"
    val str2="Red"
    val str3="Pink"
    println("str1 == str2 : ${str1==str2}")
    println("str1 == str3 : ${str1==str3}")
    println("str1 === str2 : ${str1===str2}")
    println("str1 === str3 : ${str1===str3}")
    //equals()는 값을 비교, ==로 대체 가능
    println("str1.equals(str2) : ${str1.equals(str2)}")
    println("str1.equals(str3) : ${str1.equals(str3)}")

}