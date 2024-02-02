package classAndObject.modifier

fun main() {

    /*캡슐화 : 자세한 내부 구조를 숨김. 정보 은닉*/

    /*가시성 지시자 : 접근 범위를 정해줌. 변수, 클래스, 메소드, 인터페이스 등에 사용 가능
    * private - 선언 요소 내에서만 접근 가능
    * protected - 하위 상속 요소 내에서만 접근 가능
    * internal - 같은 모듈 내에서만 접근 가능
    * public - 어디서든 접근 가능(기본 값)*/

    //같은 모듈에 있기에 자유롭게 접근 가능
    //현재 하나의 모듈을 가지기에 프로젝트 전체가 접근 범위라고 볼 수 있음
    val v= Internal()
    v.num
    v.changeNum()
    v.getMethod()

}

class InternalExample(){
    //val v1=Internal()//public형이라 internal 접근 불가능
    internal val v2= Internal()
    //v2.num
    //v2.getMethod()
    fun check(){
        //로컬 영역에서 사용 가능
        v2.num
        v2.changeNum()
        v2.getMethod()
    }
}

fun a(){
    val v= Internal()
    v.num
    v.changeNum()
    v.getMethod()
}

//주생성자 접근자가 public 이 외일 때는 constructor 생략 불가능
//class c5 internal(var a:Int)
class c4 internal constructor(var a:Int)