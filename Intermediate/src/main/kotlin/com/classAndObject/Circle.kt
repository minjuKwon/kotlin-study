package com.classAndObject
//부생성자를 이용한 상속
class Circle:Shape {
    var r:Int//추가 프로퍼티. 자신만의 프로퍼티 추가 가능
    constructor(x:Int, y:Int, color:String, r:Int) :super(x,y,color){
        this.r=r
    }
    override fun figure() {
        println("It is Circle")
    }
    //추가 메서드. 자신만의 메서드 추가 가능
    fun radius(){
        println("The circle radius is $r")
    }
}