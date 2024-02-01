package com.classAndObject

fun main() {

    /*캡슐화 : 자세한 내부 구조를 숨김. 정보 은닉*/

    /*가시성 지시자 : 접근 범위를 정해줌. 변수, 클래스, 메소드, 인터페이스 등에 사용 가능
    * private - 선언 요소 내에서만 접근 가능
    * protected - 하위 상속 요소 내에서만 접근 가능
    * internal - 같은 모듈 내에서만 접근 가능
    * public - 어디서든 접근 가능(기본 값)*/

    val a=Private()
    //a.num //private 멤버 접근 불가능
    a.getMethod()

}

private class Private{
    private var num=1
    private fun changeNum(){
        num++
    }
    fun getMethod(){changeNum()}//같은 클래스 내이므로 접근 가능
}

class PrivateExample{
    //기본 값이 public 이라서 private 클래스 접근 불가능
    //val value=Private()
    private val value=Private()//같은 private이기에 private 클래스에 접근 가능
    //멤버 호출은 불가능
    //value.num 
    //value.getMethod()
    fun check(){
        val p=Private()//로컬 변수이기에 private 클래스이라도 접근 가능
        //p.num //private 멤머 호출 불가능
        p.getMethod()
    }
}

//외부 함수에서도 private 클래스 생성과 메소드 접근 가능하기만 
//private 멤버는 접근 불가능
fun function(){
    val p=Private()//로컬 변수이기에 생성 가능
    //p.num
    p.getMethod()
}

//주생성자 접근자가 public 이 외일 때는 constructor 생략 불가능
//class c private(var a:Int)
class c1 private constructor(var a:Int)