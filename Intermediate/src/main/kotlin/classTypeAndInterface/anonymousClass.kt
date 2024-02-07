package classTypeAndInterface

fun main() {
    
    /*익명 클래스 : 이름이 없고 object 키워드로 선언된 일회용 클래스
    object를 사용하기에 다중 인터페이스 구현 가능.
    다른 클래스에서의 사용이 적고 외부의 접근이 필요 없을 때 사용.*/

    val ball=BasketBall()
    ball.info()
    
}

interface Ball{
    fun color()
}

class BasketBall{
    val name="BasketBall"
    fun info(){
        println("$name")
        appearance.color()
    }
    //appearance는 프로퍼티 이름이고 객체 이름은 아님
    val appearance=object:Ball{
        //이 메소드 호출될 때마다 일회성 객체 인스턴스 생성
        override fun color() {
            println("color is orange")
        }
    }
}