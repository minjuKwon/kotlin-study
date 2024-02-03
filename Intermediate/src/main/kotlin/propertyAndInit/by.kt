package propertyAndInit

import kotlin.properties.Delegates

fun main() {

    /*by : 위임. 특정 클래스를 확장하거나 이용할 수 있도록 함.
    위임된 클래스가 가지는 멤버를 참조 없이 호출 가능.
    */
    
    /*클래스 위임 : 코틀린에서는 기본적으로 final이기 때문에 필요한 경우
    * 위임을 통해 상속과 비슷한 기능 사용 가능*/
    val rectangle=Rectangle()
    //Rectangle에서 color()를 구현하지 않았지만
    // color를 구현한 Square를 위임받았기에 Square color() 사용 가능
    rectangle.color()
    //다형성 가능
    val book1=Literature("book1", Novel("novel"))
    val book2=Literature("book2", Essay("essay"))
    book1.info()
    book2.info()

    /*프로퍼티 위임 : 프로퍼티의 getter와 setter를 특정 객체에 위임하여 그 객체가 대신 수행
    * by lazy가 흔한 예시. lazy 람다식은 Lazy<T>인스턴스 반환. 이 람다식을 실행하며 getter 실행*/

    /*observable() : 표준 위임 구현 중 하나. 프로퍼티를 위임하는 Delegates로부터 사용
    * 프로퍼티를 감시하다가 변경이 발생할 때 호출. 특정 변경 이벤트에 호출되어 콜백이라고도함. 기본값 지정 필요
    * 기본값을 위한 initValue를 가지며 변경될 때 호출되는 콜백 onChange() 존재.*/
    var money:Int by Delegates.observable(5000){//프로퍼티를 Delegates.observable()에 위임
            property, oldValue, newValue ->//람다식 매개변수, 기존값, 새로운값
        println("$oldValue -> $newValue")
    }
    money=7000//변경 이벤트 발생
    money=10000//변경 이벤트 발생
    println(money)

    /*vetoable() : observable()와 동일하나 반환값에 따라 프로퍼티 변경 or 취소 가능
    * onChange() 람다식에 Boolean 가져 true-> 새로운 값, false->기존 값 유지 
    * 큰 데이터를 다룰 때 유용*/
    var salary by Delegates.vetoable(300){
        property, oldValue, newValue ->
        newValue>oldValue//true면 값 변경, false면 유지
    }
    salary=400
    println(salary)
    salary=300//새로 할당한 300이 기본 값보다 적어졌기에 300이 아닌 400 출력
    println(salary)

}

interface Shape{
    fun color(){}
}
class Square:Shape{
    override fun color() {
        println("Color is color")
    }
}
val square=Square()
class Rectangle:Shape by square

interface Book{
    fun getBookType():String
}
class Novel(val type:String):Book{
    override fun getBookType(): String ="Novel type is $type"
}
class Essay(val type:String):Book{
    override fun getBookType(): String ="Essay type is $type"
}
class Literature(val name:String, book:Book): Book by book{
    fun info(){
        println("$name - ${getBookType()}")//참조 없이 바로 getBookType() 접근 가능
    }
}