import kotlin.math.abs

fun main() {

    /*연산자 오버로딩: 내부적으로 연산자를 오버로딩한 함수를 사용. 즉, 특정 연산자를 정의한 함수를 다른 의미로 작동 부여 가능.
    함수 앞에 operator 키워드 사용. 클래스 내부에서 연산자 오버로딩 가능하지만 클래스 외부에서는 확장 함수로 사용.
    확장할 클래스를 명시하기 위해 함수 이름 앞에 클래스 참조가 필요.
    */

    /*invoke(): 함수 호출할 때 함수 이름 옆에 괄호로 표기하는 방법을 invoke()으로 사용.
    즉 sum()->sum.invoke(), sum(a)->sum.invoke(a).
    */

    //내부적으로 1.plus(2) 호출. 기본적으로 다양한 자료형 처리 위한 오버로딩되어있음.
    println(1+2)

    //원하는 형태로 연산자 오버로딩 가능
    val position1=Position(1,2)
    //다른 메서드 호출 없이 바로 invoke()에 정의한 내용 처리 가능.
    position1()
    position1.inc().invoke()
    val position2=position1.dec()
    position2.dec()()
    val position3=position1.minus(Position(2,3))
    position3.invoke()
    (!position3).invoke()
    (!position3)()

    //접근 연산자도 operator fun 형태.
    val arr=arrayOf(1,2,3)
    arr.get(0)
    arr.set(1,0)

    //범위 연산자도 operator fun 형태.
    arr.contains(1)

    //대입 연산자. +의 plus()를 오버로딩하면 +=도 자동으로 구현.
    //+=인 plusAssign() 오버로딩 필요 없음. 동시에 오버로딩하면 동작이 애매해짐.

    //비교 연산자도 operator fun 형태.
    //내부적으로 정수 반환하는 a.compareTo(b) 호출
    println(1>2)

    //동등 연산자인 ==는 equals()로 변경. Any 안에 operator 키워드 붙인 채 구현되어 있어
    //하위 클래스에서 operator 키워드 없이 오버라이딩 가능 그렇기에 확장 함수 구현 불가능
    //상속 받은 equals가 확장 함수보다 우선순위가 높기 때문.
    // ===와 !==는 오버로딩 불가능. ==와 다른 참조 비교 연산자이기 때문.

}

class Position(var x:Int, var y:Int){
    //산술 연산자
    operator fun minus(p:Position):Position{
        return Position(abs(x-p.y), abs(y-p.y))
    }
    //호출 연산자
    operator fun invoke(){
        println("x: $x, y: $y")
    }
    //증감 연산자
    operator fun dec():Position{
        return if(x==0||y==0){
            Position(0,0)
        }else{
            Position(--x, --y)
        }
    }
    //단일 연산자
    operator fun not():Position=Position(x*-1,y*-1)
}
//클래스 외부에서도 가능
operator fun Position.inc()=Position(++x,++y)