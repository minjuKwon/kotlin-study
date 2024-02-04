package propertyAndInit

fun main() {

    /*지역 변수 : 특정 코드 블록 안에서만 사용되는 변수.
    블록을벗어나면 메모리에서 삭제
    * 전역 변수 : 특정 코드 블록 밖에 있는 변수. 
     프로그램이 실행되는 동안 메모리에 유지*/

    /*정적 변수 : 동적인 초기화 없이 사용할 수 있는 변수
    즉, 객체 생성 없이, 인스턴스화 없이 사용 가능한 변수.
    프로그램이 실행할 때 고정적으로 가지는 메모리.
    독립적으로 값을 가져 어떤 객체라도 동일한 참조 값 가짐.
    동일한 정보를 필요할 때 하나의 변수만 사용할 수 있어 메모리 절약. 싱글톤에 사용
    static 키워드 대신 companion 사용*/

    println(Student.major)
    Student.major="Computer"
    println(Student.major)
    Student.study()
    
    //쉽게 자바의 static 멤버 접근 가능
    println(staticJava.NAME)
    staticJava.greeting()

}

class Student{
    companion object{
        var major:String="Math"

        //const : 컴파일 시점에 값이 할당. val은 실행 시간, 런타임에 할당
        //기본형와 String에만 사용 가능
        const val id=123

        @JvmField//자바에서 코틀린의 프로퍼티를 접근하게 해줌
        val grade=4

        @JvmField
        val job=Job()

       //자바에서 코틀린의 companion 접근하게 해주는 애노테이션(@)
        @JvmStatic fun study(){
            println("공부하는 중")
        }

        fun goSchool(){
            println("Walking")
        }

    }
}
class Job{var job="developer"}