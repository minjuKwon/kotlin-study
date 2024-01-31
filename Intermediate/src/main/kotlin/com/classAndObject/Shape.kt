package com.classAndObject
//open 키워드를 사용해야 상속 가능
open class Shape(var x:Int, var y:Int, var color:String) {
    //open 키워드로 하위 클래스에서 오버라이딩 가능.기본적으로 final
    open fun figure() =println("It is Shape")
    fun position() =println("The position - x: $x, y: $y")
}