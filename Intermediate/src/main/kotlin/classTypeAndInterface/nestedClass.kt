package classTypeAndInterface

fun main() {

    /*중첩 클래스 : 클래스 안의 클래스. 객체 생성 없이 사용 가능. 즉, 정적 클래스처럼 다뤄짐
    다른 클래스에서의 사용이 적고 외부의 접근이 필요 없을 때 사용.
    */

    /*자바의 정적 클래스와 비슷. static 키워드를 사용하여 외부 클래스 인스턴스화 없이 바로 사용 가능한 내부 클래스
    * class A{
    *   static class B{
    *   }
    * }*/

    Peel.Kernel().eat()//객체 생성 없이 바로 사용 가능

    //Peel.info() 외부 클래스는 객체 생성 필요
    val peel=Peel()
    peel.info()

    Peel.Kernel().appearance()//중첩 클래스에서 외부 클래스 companion 멤버 접근

}

class Peel{
    val name="apple"
    fun info(){
        println("$name - seed : ${Kernel().seed}")//중첩 클래스 프로퍼티 접근
        Kernel().eat()//중첩 클래스 메소드 접근
    }
    companion object{
        const val color="red"
        fun colour()=println("color : $color")
    }
    class Kernel{
        val seed=4
        fun eat(){
            println("Kernel - seed : $seed")
            //println("$name")//외부 클래스 멤버 접근 불가능
        }
        //companion일 때는 외부 클래스 멤버 접근 가능
        //companion도 static처럼 객체 생성 없이 고정적 메모리를 가지기 때문
        fun appearance(){
            println(color)
            colour()
        }
    }
}