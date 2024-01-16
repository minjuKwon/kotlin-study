package com.variable

import java.lang.System.`in`
import java.util.*

fun main() {

    /*Scanner : 사용자가 데이터 입력. 
    System.in이라는 InputStream 넣어서 생성한 인스턴스 이용 */

    val sc= Scanner(System. `in`)//in이 예약어이기 때문에 ``으로 감싸서 사용
    print("당신의 이름은?")
    val name=sc.next()//공백 전의 문자열 저장(단어 저장)
    print("당신의 나이는?")
    val age=sc.nextInt()
    print("오늘 하루는 어떠하였나요")
    sc.nextLine()//nextInt()후 개행을 받기 위해 추가 입력
    val content=sc.nextLine()//'\n'전의 문자열 저장(문장 저장)
    print("오늘의 행복 지수(%) : ")
    val happy=sc.nextDouble()
    println("이름 : $name")
    println("나이 : $age")
    println("행복지수 : $happy")
    println(content)

    print("배열의 크기 : ")
    //readLine()는 무조건 문자열로 받음. 
    //다른 타입으로 변환하면 null이 아님을 알려주는 !!와 함께 변환 메소드 사용
    val size= readLine()!!.toInt()
    //size 크기의 배열 요소를 입력받아 배열 생성
    val arr=Array<Int>(size){
        print("배열 요소 입력 : ")
        readLine()!!.toInt()
    }
    var sum=0
    for(a in arr){
        sum+=a
    }
    println("배열 요소의 합 : $sum")

    sc.close()//close()를 사용하여 리소스 낭비 방지

}