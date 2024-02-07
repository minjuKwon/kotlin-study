package classTypeAndInterface

fun main() {

    /*이너 클래스 : 외부 클래스 멤버와 연동하는 내부 클래스. inner 키워드 사용.
    중첩 클래스와 달리 외부 클래스 멤버 접근 가능. private이라도 가능.
    다른 클래스에서의 사용이 적고 외부의 접근이 필요 없을 때 사용.*/

    /*자바의 멤버 클래스와 비슷. 별다른 키워드 없음
     * class A{
     *   class B{
     *   }
     * }*/

    val box=Box()
    box.Key().open()

}

class Box{
    private val name="secret"
    fun lock()=println("You can't open")
    inner class Key{
        fun open(){
            println("Box : $name")//외부 private 멤버 접근
            lock()//외부 멤버 접근
            println("OPEN!")
        }
    }
}
