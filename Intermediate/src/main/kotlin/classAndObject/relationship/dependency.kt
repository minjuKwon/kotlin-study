package classAndObject.relationship

fun main() {

    /*의존 관계 : 어느 클래스가 다른 클래스에 의존되어 영향을 주는 관계.
    의존 당하는 클래스가 먼저 생성되어야됨. 서로 클래스 참조 유지 X*/
    val car =Car("bobo",123)
    val driver=Driver("Kim",car)//Driver 생성하기 위해 Car 인스턴스 필요. Car에 의존적.
    car.getInfo(driver)
    driver.getInfo()

}

class Car(val name:String, val num:Int){
    fun getInfo(d:Driver){
        println("Car : $name, Driver : ${d.name}")
    }
}

class Driver(val name: String, val car:Car){
    fun getInfo(){
        println("Driver : $name, Car : ${car.name}")
        println("Car num : ${car.num}")
    }
}