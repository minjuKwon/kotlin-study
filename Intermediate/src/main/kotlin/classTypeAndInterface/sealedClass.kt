package classTypeAndInterface

fun main() {

    /*실드 클래스 : 미리 생성한 자료형들을 묶어서 제공하는 클래스. sealed 키워드 사용
    추상클래스처럼 객체 생성 불가. 생성자는 기본으로 private이기 때문에 다른 접근 제어자 사용 불가능.
    다른 파일에서 상속 불가능. 제한된 유형만을 제공하고 싶을 때 사용*/

    val preStart=ProgressA.PreStartA(0)
    val result=result(preStart)
    println(result)

}

//여러 클래스를 묶어서 제공
sealed class ProgressA{
    open class PreStartA(val startTime:Int):ProgressA()
    class EndA(val endTime:Int):ProgressA()
}
class InProgressA():ProgressA()//같은 파일 내서라면 실드 클래스 밖에서도 상속 가능
class StartA:ProgressA.PreStartA(0)//실드 클래스 내부 클래스 상속

//다른 방식으로 실드 클래스 선언
sealed class ProgressB
open class PreStartB(val startTime:Int):ProgressB()
class EndB(val endTime:Int):ProgressB()
class InProgressB():ProgressB()
class StartB:PreStartB(0)//상속 구현할 때 . 표기 없이 내부 클래스 접근 가능

//sealed 클래스 내에 정의된 타입들이 있어 모든 경우의 수 판단 가능
//즉, 필요한 경우의 수 직접 지정 가능.그렇기에 모든 조건이 나열되었기에 else 필요 없음.
fun result(progress:ProgressA):Int=
    when(progress){
    is InProgressA -> 5
    is ProgressA.PreStartA->progress.startTime
    is ProgressA.EndA->progress.endTime
}

