package propertyAndInit

fun main() {

    /*지연 초기화 : 초기화 작업을 나중으로 미룰 수 있음.
    * 객체 의존성 같이 객체 생성과 동시에 초기화하기 힘들 때 많이 사용.
    * 사용하지 않는데 초기화하여 메모리 낭비하는 것을 방지*/

    /*lateinit
    -var,non-null, 부생성자 사용가능(val X)
    -기본타입, 주생성자, getter,setter 사용 X
    -초기화 전에는 접근 불가능. 실행할 때 초기화 안되었으면 오류 발생.
    */
    val late=Late1()
    late.check()
    late.a="1"//이 시점에서 초기화 완료
    late.check()
    println(late.a)
    late2= Late2("2")
    println(late2.b)

    /*lazy
    -val,기본형, null, 지역변수 사용 가능(값 변경 불가능)
    -람다식 형태.호출시점에서 by lazy{}의 블록 부분 초기화
    -클래스 생성자, getter, setter 사용 X
    -스레드 동시성에 사용
    -주로 위임으로 사용.Lazy 객체 안에 field가 있기에 
    lazy 프로퍼티 직접적으로 변경 불가능
    */
    val lazy1=Lazy1()
    lazy1.check()

    var isInit=false
    val lazy2:Lazy2 by lazy{
        isInit=true
        Lazy2(3)
    }
    val lazy2_1= lazy { Lazy2(4) }
    println("Lazy2 init : $isInit")
    println("Lazy2_1 init : ${lazy2_1.isInitialized()}")
    println("Lazy2 d : ${lazy2.d}")
    println("Lazy2_1 d : ${lazy2_1.value.d}")
    println("Lazy2 init : $isInit")
    println("Lazy2_1 init : ${lazy2_1.isInitialized()}")

}

class Late1{
    lateinit var a:String
    //lateinit var b:Int//기본형인 int 사용 불가
    fun check(){
        if(!::a.isInitialized){//프로퍼티 참조를 위해 :: 사용
            println("초기화 전")
        }else{
            println("초기화 완료")
        }
    }
}
class Late2(var b:String)
lateinit var late2:Late2//초기화 지연

class Lazy1{
    val c by lazy{"초기화 완료"}
    fun check(){
        println("초기화 전")
        println("c : $c")//초기화 시점
        println("c : $c")//초기화된 값 사용
    }
}
class Lazy2(val d:Int)

