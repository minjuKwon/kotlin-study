package propertyAndInit

fun main() {

    /*object : 하위 클래스를 선언하지 않고 상위 클래스의 내용을
    조금 변경한 객체 생성할 때 사용. */

    /*object 선언 : 접근 시점에 객체가 생성.
    즉, 생성자 호출을 하지 않기에 주생성자, 부생성자 모두 사용 불가능
    그렇기에 필요한 경우 init 블록 사용. 클래스나 인터페이스 상속 가능. 싱글톤에 사용*/
    println(Worker.name)//객체 생성 없이 접근 가능
    Worker.name="Kwon"
    println(Worker.name)
    Worker.greeting()
    println(Worker.address.address)

    /*object 표현식 : 이름이 없음. 사용될 때마다 새로운 인스턴스 생성.
    자바의 익명 내부 클래스와 비슷. 싱글톤 X*/
    val runner=object:Sport(){
        override fun jump()=println("Jumping and Running")//하위 클래스 생성없이 오버라이딩
    }
    runner.run()
    runner.jump()

    //한번만 구현되는 인터페이스 사용에 유용
    val paint=object:Paint{
        override fun draw() {
            println("Draw painting");
        }
    }
    paint.draw()

    //상위 인터페이스나 클래스 없이 객체 사용 가능
    circle()

    //익명 객체는 로컬 영역, private에만 사용 가능
    //public에 사용하면 상위 자료형, 상위 자료형이 없으면 Any형
    val type=Type()
    println(type.x)

}

object Worker{
    init {println("init")}
    var name="Kim"
    val address=Address("Korea")
    fun greeting()=println("Hello everyone")
}
class Address(val address:String)

open class Sport{
    var power=0
    fun run(): () -> Unit ={
        power++//바로 바깥 변수 접근 가능
        println("Run")
    }
    open fun jump()=println("Jump")
}

interface Paint{
    fun draw(){}
}

fun circle(){
    val position=object{
        var x=2
        var y=5
    }
    println("x: ${position.x}, y: ${position.y}")
}

class Type{
    private fun anony()=object{
        val a="A"
    }
    fun any()=object{
        val b="B"
    }
    val x=anony().a//익명 객체 자료형이 반환
    //val y=any().b//Any 반환
}