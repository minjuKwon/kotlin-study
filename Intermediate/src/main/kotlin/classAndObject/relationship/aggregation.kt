package classAndObject.relationship

fun main() {

    /*집합 관계 : 연관 관계에서 소유 개념이 추가된 관계.
    즉, 서로 참조를 유지하며 객체의 생명주기가 유지됨.
    한 객체가 다른 객체를 포함함. 전체와 부분 관계*/
    val computer= Computer("Computer1")//Moniter 인스턴스가 필요하지만 생성 시 없어도 문제 없음
    val monitor=Monitor("Monitor1")//다른 Computer 객체에 사용 가능
    computer.monitor=monitor
    monitor.getInfo()
    computer.getInfo()

}

class Computer(_name:String, _monitor: Monitor){
    val name=_name
    var monitor=_monitor
    constructor(_name: String):this(_name, Monitor())
    fun getInfo(){
        println("Computer name : $name, Monitor name : ${monitor.name}")
    }
}

class Monitor{
    var name:String="Default"
    constructor()
    constructor(_name: String){
        name=_name
    }
    fun getInfo(){
        println("Monitor name : $name")
    }
}