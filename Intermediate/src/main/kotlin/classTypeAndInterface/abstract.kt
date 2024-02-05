package classTypeAndInterface

fun main() {

    /*추상 클래스 : 공통의 기능과 설계를 명시하는 클래스.
    상속하는 하위클래스에서 구체화 필요. 오버라이딩하지 않으면 추상 클래스가 됨.
    멤버 프로퍼티와 멤버 메소드도 추상화 가능. 추상 멤버가 하나라도 있으면 클래스도 추상화로 선언
    반드시 가져야 할 멤버는 abstract 사용. 연관성이 높은 프로퍼티와 메소드는 일반 멤버로 미리 정의함.
    추상 클래스는 인스턴스화 불가능. open 사용 불필요.*/
    val vam=Vam("vam-12cdf98", "black", 110)
    vam.info()
    vam.option=2
    vam.info()
    vam.start()
    vam.stop()
    
    //추상클래스에서 하위 클래스를 생성하지 않고 단일 객체를 생성하고 싶으면 object 사용
    butterfly.fly()

}

abstract class Car(val model:String, val color:String){
    //프로퍼티를 abstract로 선언하면 값 할당 필요X. 선언만 할 수 있음
    abstract var speed:Int
    var option=0
    abstract fun start()
    abstract fun stop()
    fun info(){
        println("model : $model, color : $color, speed : $speed, option : $option.")
    }
}

class Vam(model:String, color:String, override var speed: Int)
    :Car(model, color){
    override fun start() {
        println("Car $model starting")
    }
    override fun stop() {
        println("Car $model stopping")
    }
}

abstract class Butterfly{
    abstract fun fly()
}
val butterfly=object:Butterfly(){
    override fun fly() {
        println("나비 날다")
    }
}