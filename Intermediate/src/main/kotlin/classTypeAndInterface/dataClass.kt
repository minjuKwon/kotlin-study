package classTypeAndInterface

fun main() {

    /*DTO(Data Transfer Object) : 데이터 전달을 위한 객체. 구현 로직 X
    속성과 속성 접근자, 데이터 표현하거나 비교하는 메소드 제공
    DTO는 데이터를 주고 받는 표준 방법이 되기어 어떤 요소든 데이터를 쉽게 다룰 수 있음*/

    /*데이터 클래스 : 데이터 저장을 위해서만 사용되는 클래스. 그렇기에 구현부는 없음.
    DTO를 위한 몇 가지 메서드를 내부적으로 제공함. abstract, open, sealed inner 키워드 사용X
    val, var로 지정된 최소한 하나의 매개변수를 가지는 주 생성자를 가져야됨.부생성자나 init 불록 사용 가능*/

    val exercise1=Exercise("run",60)
    val exercise2=Exercise("run",60)
    println("exercise1==exercise2 : ${exercise1==exercise2}")
    println("exercise1.equals(exercise2) : ${exercise1.equals(exercise2)}")//값 내용이 같은지 비교
    println("exercise1.hashCode() : ${exercise1.hashCode()}")//객체 구별하기 위한 고유 정수 값 생성
    println("exercise2.hashCode() : ${exercise2.hashCode()}")//값 내용이 같아 hashcode()가 같음

    val exercise3=exercise2.copy(time=40)//특정 프로퍼티값만 변경하여 객체 복사
    println(exercise1.toString())//데이터 객체를 문자열로 변환
    println(exercise3.toString())
    println("exercise3.hashCode() : ${exercise3.hashCode()}")

    //디스트럭처링 : 객체의 각 프로퍼티를 분해하여 별도의 각 변수로 할당
    val(name:String, time1:Int)=exercise1
    println("name1 : $name, time1 : $time1")
    val(_, time2:Int)=exercise2//불필요한 프로퍼티는 _ 사용하여 제외
    println("time2 : $time2")
    val name3=exercise3.component1()//componentN()로 프로퍼티 분해, 할당
    val time3=exercise3.component2()
    println("name3 : $name3, time3 : $time3")
    //for문 사용하여 디스트럭처링
    val exercises= listOf(exercise1, exercise2, exercise3)
    for((name, time) in exercises){
        println("name : $name, time : $time")
    }
    //람다를 이용하여 디스트럭처링
    val lam={
        (name, time):Exercise->
        println("name : $name, time : $time")
    }
    lam(exercise3)

}

data class Exercise(val name:String, var time:Int){
    var spot="Gym"
    constructor(name: String, time: Int, _spot:String):this(name, time){
        spot=_spot
    }
    init {
        println("EXERCISE!!!")
    }
}

