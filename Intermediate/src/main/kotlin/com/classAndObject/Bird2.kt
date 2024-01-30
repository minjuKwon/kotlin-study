package com.classAndObject

class Bird2 {

    var name:String
    var size:Int
    var color:String
    var feed:String

    //부생성자는 매개변수를 달리 하여 여러번 정의 가능
    //외부에서 매개변수, 초기값을 전달 받기 때문에 프로퍼티 초기화 필요 X
    //매개변수와 프로퍼티의 이름이 같아도 this 키워드로 구분함.
    //this는 이곳, 클래스 내 멤버 프로퍼티를 뜻 함
    constructor(name:String, size:Int, color:String, feed:String){
        this.name=name
        this.size=size
        this.color=color
        this.feed=feed
    }

    constructor(_name:String, _size:Int){
        name=_name//매개변수에 _를 사용하면 this 생략 가능
        size=_size
        color="black"
        feed="omnivorous diet"
    }

    fun body(cm:Int) =println("It is $size cm")
    fun eat() = println("It eat $feed")

}