package com.classAndObject
//open 키워드를 사용하지 않았기에 최종 클래스가 됨. 즉, 다른 클래스가 Rectangle 상속 불가능
//주생성자를 이용한 상속
class Rectangle(x:Int, y:Int, color:String):Shape(x,y,color) {
    //오버라이딩 : 상위 클래스 메서드 재정의. override 키워드 사용
    //오버라이딩에도 final, open 키워드 중복 사용 가능
    override fun figure() {
        super.figure()
        println("It is rectangle $x")
    }
    //기존 기본 메서드도 오버라이딩 가능
    override fun toString(): String {
        return "${super.toString()}: $x, $y, $color"
    }
    //오버로딩 : 동일 이름의 메서드를 매개변수만 달리 하여 여러 번 정의
    //반환값은 동일하거나 다름. 구현 동작은 대부분 동일
    //클래스 내 메서드뿐만 아니라 일반 함수도 오버로딩 가능
    //다양한 자료형의 연산에서 많이 사용
    //같은 이름으로 다양한 매개변수를 다를 수 있어 쉽게 메서드 확장 가능
    fun area():Int{
        return x*y
    }
    fun area(height:Int, width:Int):Int{
        return (height-x)*(width-y)
    }
}