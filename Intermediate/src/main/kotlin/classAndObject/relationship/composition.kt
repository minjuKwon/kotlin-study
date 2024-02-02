package classAndObject.relationship

fun main() {

    /*구성(합성) 관계 : 전체 객체와 부분 객체가 의존적인 관계.
    * 서로 참조를 유지하며 객체의 생명주기가 의존적 */

    val truck=Truck("Truck1")
    val wheel=Wheel("Wheel1")
    truck.getInfo()
    wheel.getInfo()

}

class Truck(val name:String){
    private val wheel=Wheel("Wheel2")//전체 클래스 안에서만 사용 가능
    fun getInfo(){
        println("Truck : $name, Wheel : ${wheel.name}")
    }
}

class Wheel(val name:String){
   fun getInfo(){
       println("Wheel : $name")
   }
}



