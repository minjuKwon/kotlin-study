package classAndObject.modifier

fun main() {

    /*캡슐화 : 자세한 내부 구조를 숨김. 정보 은닉*/

    /*가시성 지시자 : 접근 범위를 정해줌. 변수, 클래스, 메소드, 인터페이스 등에 사용 가능
    * private - 선언 요소 내에서만 접근 가능
    * protected - 하위 상속 요소 내에서만 접근 가능
    * internal - 같은 모듈 내에서만 접근 가능
    * public - 어디서든 접근 가능(기본 값)*/

    val p= Protected()
    //p.num //protected 멤버 접근 불가능
    p.getMethod()//public이기에 접근 가능

}

//상속 받지 않았기에 멤버 접근 불가능
class Example{
  /*  fun check(){
        num
        changeNum()
        getMethod()
    }*/
}

class ProtectedExample: Protected(){
    //getMethod() //상속받아도 본문에 바로 사용 불가능
    fun check(){
        //로컬 영역에서 사용 가능
        num
        changeNum()
        getMethod()
    }
}

//주생성자 접근자가 public 이 외일 때는 constructor 생략 불가능
//class c protected(var a:Int)
class c2 protected constructor(var a:Int)