package com.classAndObject

/*//주 생성자 클래스 이름과 함께 생성자 정의
//constructor 키워드 생략 가능
class Bird3 constructor(_name:String, _size:Int, _color:String, _feed:String){

    var name:String=_name
    var size:Int=_size
    var color:String=_color
    var feed:String=_feed

    fun body(cm:Int) =println("It is $size cm")
    fun eat() = println("It eat $feed")
    
}*/

//생성자에 바로 선언하면 this 키워드 사용이나 매개변수에 _를 붙여 프로퍼티에 할당 할 필요 X
//매개변수에 기본값 부여 가능
class Bird3(var name:String, var size:Int, var color:String="black", var feed:String){

    //초기화할 수 있는 블록. 생성자에는 변수 초기화 말고 다른 작업을 하면 안됨.
    //따라서 특정한 기능을 클래스 생성시 바로 작업하고 싶으면 초기화 블록에 입력.
    init {
        println("=====초기화 블록 시작=====")
        println("name : $name")
        eat()
        println("=====초기화 블록 끝=====")
    }

    fun body(cm:Int) =println("It is $size cm")
    fun eat() = println("It eat $feed")

}