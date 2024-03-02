package collection

fun main() {

    /*IndexedValue: 인덱스 값을 갖는 index 속성과 인덱스의 데이터 값을 갖는 value 속성을 가지는 데이터 클래스
    Iterable 인터페이스 확장 함수 withIndex() 으로 IndexedValue 인스턴스 자동 생성. 주로 컬렉션과 함께 사용*/

    val list=listOf(1,2,3,4)
    list.withIndex().forEach { print("$it ") }
    println()
    list.withIndex().forEach { print("${it.index}: ${it.value} ") }
    println()

    val set=setOf(1,2,3,4,5)
    val lv=set.withIndex().filter {it.index%2==0 }
    println(lv)

}