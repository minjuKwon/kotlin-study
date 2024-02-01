package com.classAndObject
//인터페이스는 클래스가 어떻게 구현해야하는지 알려주는 가이드 역할
//인터페이스 자체로는 객체가 아니라 이를 클래스에서 구현해야됨
//한 클래스가 여러 인터페이스 구현 가능
interface A{
    fun a()=println("A Interface a()")
    fun b()=println("A Interface b()")
}

open class B{
    open val num:Int=1
    constructor()
    constructor(x:Int, y:Int){
        println("B - x: $x, y: $y")
    }
    open fun b()=println("B Class b()")
    fun c()=println("B Class c()")
    open fun d()=println("B Class d()")
}

class C:A,B{
    override val num:Int=super.num+1//현재 클래스에 상위 클래스 num에 1을 더한 값을 할당
    constructor() : super() {

    }
    constructor(x:Int):this(x, 2){//현재 클래스에서 두 개의 매개변수를 가진 생성자 호출
        println("C - x: $x")
    }
    constructor(x:Int, y:Int):super(x, y){//상위 클래스에서 두 개의 매개변수를 가진 생성자 호출
        println("C - x: $x, y: $y")
    }
    override fun b() {
        println("C Class b()")
    }
    override fun d() {
        super.d()
        println("C Class d()")
    }
    fun info(){
        b()
        c()
        super<A>.b()//구현할 인터페이스 A와 상속 받은 B클래스의 메서드명이 동일하여 <>로 구분
        super<B>.b()
    }
    inner class E{
        fun b()=println("Inner Class E b()")
        fun info(){
            b()//현재 클래스 b() 호출
            C().b()//바로 바깥 클래스 C 클래스 b() 호출
            super<B>@C.b()//바깥 클래스 C의 상위 클래스 B b() 호출
            println("Inner super@Child.num : ${super<B>@C.num}")//바깥 클래스 C의 상위 클래스 B num 호출
            println("Inner C().num : ${C().num}")//바깥 클래스 C num 호출
        }
    }
}

class E(e:Int, say:Unit=println("Primary Constructor")){
    val f=println("Body1 - e: $e")
    init {
        println("Init")//람다식이 없었다면 본문에서 제일 먼저 호출
    }
    val h=println("Body2")
    //보조생성자는 항상 주생성자를 호출해야됨
    constructor(e:Int, g:Int,say:Unit=println("Secondary Constructor")):this(e){
        println("Secondary Constructor Body - e: $e, g: $g")
    }
}

