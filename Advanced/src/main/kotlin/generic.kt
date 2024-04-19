import kotlin.reflect.full.createInstance
import kotlin.reflect.full.functions

fun main() {

    /*제네릭 : 자료 타입을 인스턴스 생성할 때 정하게 해줌.
    의도한 타입만 명시 가능. 타입의 변경성이 있거나 예측이 어려울 때 사용.
    자료형을 컴파일할 때 검사하기 때문에 자료형의 안정성을 높임.
    또한 형변환 필요 감소로 변환하면서 발생할 수 있는 오류 방지.
    */

    val gen1:Gen<String> = Gen<String>()
    val gen2:Gen<Int> = Gen<Int>()

    val drink1:Drink<Int> = Drink<Int>(1)
    println(drink1.count)
    //자료형을 유추할 수 있으면 명시 필요 X
    val drink2=Drink("2")
    println(drink2.count)

    val drink3=Drink(3, "tall")
    println(drink3.count)
    println(drink3.size)
    println()

    /*제네릭 클래스는 기본적으로 형식 매개변수에 상하위 클래스 간 자료형이 변환되지 않음*/
    //val drink4:Juice<Drink<Int>> = Juice<Tea<Int>>()//자료형 불일치
    //val drink5:Juice<Tea<Int>> = Juice<Drink<Int>>()//자료형 불일치

    /*형식 매개변수는 null 허용*/
    drink3.isSame(1,2)
    val drink6=Drink<Int?>(1,null)
    drink6.isSame(null,3)
    //Any 타입일 때는 null 지정 불가능
    val drink7=Drink<Any>(1)
    //drink7.isSame(null)
    println()

    /*제네릭 메소드*/
    println(value(1))
    println(value("2"))
    println()

    /*람다식을 사용하면 제네릭에서도 연산 메소드 사용 가능*/
    val lam1={a:Int, b:Int->a+b}
    println(sum1(1,2,lam1))
    val lam2:(Int,Int)->Int={a,b->a+b}
    println(sum2(3,4,lam2))
    println()

    /*특정 자료형으로 제한*/
    val a1=A<Int>()
    println(a1.double(1))
    val a2=A<Long>()
    println(a2.double(2))
    //val a3=A<String>()
    println(sum3(5,6, lam1))
    //println(sum3("5","6", lam1))

    //다수 자료형 제한
    val color1=Color<Purple>()
    //val color2=Color<Pink>()//Red,Blue 모두 구현한 클래스만 허용
    //Int는 Number의 하위 클래스이며 Comparable 구현한 클래스기에 사용 가능
    println(isBigger(1,2))
    //String는 Comparable 구현하였지만 Number의 하위 클래스가 아니기에 오류 발생
    //println(isBigger(1,"2"))
    println()

    /*가변성 : 형식 매개변수가 클래스 계층에 주는 영향.
    Int는 클래스이면서 자료형. null을 가지는 Int?는 자료형. 클래스는 아님.
    Int는 Number의 하위 클래스. Int?는 Int의 하위 자료형.
    비슷하게 List는 클래스이지만 List<Int>는 자료형.
    기본적으로 제네릭에는 클래스간 상하위 개념 없이 서로 무관함.
    영향을 주려면 가변성의 공변성, 반공변성,무변성 사용해야됨.*/

    /*무변성 :  C<T>와 C<T'>는 아무 관계 없음. 생산자+소비자.
    Int는 Number의 하위 클래스이지만 C<Int>와 C<Number>는 아무 관계 없음.
    형식 매개변수에 in이나 out 지정하지 않으면 기본적으로 무변성으로 선언*/
    //val c1:C1<Any> = C1<Int>(1)//Any는 모든 타입의 조상
    //val c2:C1<Nothing> = C1<Int>(2)//Nothing는 모든 타입의 자손

    /*공변성 : T'가 T의 하위 자료형이면 C<T'>는 C<T>의 하위 자료형.
    생산자 입장의 out 성질. class C<out T>로 정의하면 C<Int>는 C<Number>의 하위 자료형
    인스턴스 자료형의 상하 관계가 그대로 형식 매개변수 관계형식로 이어지는 경우. get 때 out 지정되어야함.
    만약 Any 자료형 선언한 변수에 Any 상속받는 Int 자료형의 인스턴스를 할당한다고 했을 때, 같은 Any 상속 받은 String의 값으로
    변경할 수 있기 때문에 setter 불가능. getter만 가능해짐
    */
    val c3:C2<Any> = C2<Int>(3)//Any의 하위 클래는 Int이므로 할당 가능
    //val c4:C2<Nothing> = C2<Int>(4)//Nothing의 하위 클래스는 Int가 아니므로 할당 불가능
    val c5:C2<Int> = C2<Nothing>(5)

    /*반공변성 : T'가 T의 하위 자료형이면 C<T>는 C<T'>의 하위 자료형.
    소비자 입장의 in 성질. class C<in T>로 정의하면 C<Number>가 C<Int>의 하위 자료형.
    인스턴스와 자료형 상하 관계가 반대가 되는 경우. set 때 in 지정되어야함.
    결국 상위 클래스를 받기 때문에 getter 하면 추상적인 멤버를 받을 수도 있음.
    또한 String 자료형 선언한 변수에 Any 자료형의 인스턴스를 할당한다고 했을 때,
    인스턴스의 멤버를 얻을 때 String이 아닌 Any형이 되기에 형변환 과정에 오류 발생 가능함.
    */
    //val c6:C3<Any> = C3<Int>(6)// Any가 Int의 하위가 아니기에 할당 불가능
    val c7:C3<Int> = C3<Any>(7)
    val c68:C3<Nothing> = C3<Int>(8)

    val chocolate1:Snack<Cookie> = Snack<Chocolate>(Chocolate(1))
    println(chocolate1.num.count)
    //val chocolate2:Snack<Chocolate> = Snack<Cookie>(2)//할당 불가능

    /*선언 지점 변성 : 클래스를 선언할 때 가변성을 지정하는 방식. 클래스 전체적으로 지정.
    클래스를 사용할 때 별도의 선언이 필요 없다. 여태 앞에서 한 방식.*/

    /*사용 지점 변성 : 사용 위치에서 가변성을 지정하는 방식.
    메서드 매개변수 또는 제네릭 클래스 생성 때 지정*/
    val cookie:Snack<out Cookie> = Snack<Chocolate>(Chocolate(2))

    /*자료형 프로젝션 : 특정 자료형에 in 또는 out 지정하여 제한.
    값을 get 때는 out, set 때는 in 지정해야함. 자료 안정성 보장*/

    /*스타 프로젝션: in, out 정하지 않고 *를 통해 지정하는 방식.
    어떤 자료형도 가능하나 결정 후에는 자료형과 하위 자료형 요소만 허용 제한.
    in일 때 *받으면 Nothing으로 간주, out일 때는 Any?로 간주.
    Any는 최상위 자료형. Nothing는 최하위 자료형. 아무것도 존재하지 않는 값 표현.*/
    val inOut:InOut<String, Int> = InOut("In", 9)
    inOut.infoT("d")
    inOutStart(inOut)
    println()

    /*reified : 구체화. T같이 정하지 않는 제네릭의 형식 자료형은 컴파일에는 접근 가능하지만
    실행시간에는 삭제되기 때문에 T 자체에 접근 불가능. 접근하기 위해서는 c:Class<T>처럼 매개변수가 필요
    또는 reified 키워드 사용하면 실행시간에 접근 가능. 단, inline 함수에서만 사용 가능.
    inline는 호출될 때 본문이 복사가 되는데 이때 실제 자료형을 알 수 있기 때문
    */
    val result1:Float=funClassT<Float>(Float::class.java, 10)//별도의 매개변수 필요
    val result2:Float=funReified<Float>(10)
    println(result1)
    println(result2)
    println()

    /*Class<T>는 자바에서 .class 형태로 반환 받는 객체. 패키지 이름, 메서드, 필드 등 클래스에 대한 메타 데이터를 가짐. 즉, 리플렉션.
    코틀린에서는 KClass로 나타내며 Object::class로 표현. 자바의 Class와 코틀린의 KClass는 완전히 동일하지 않아 자바의 Class를 가지려면
    Object::class.java로 표현. KClass는 실행시간 시점에 사용되는 자신의 구조와 행위를 관리하고 수정.
    Type Introspection이라는 실행시간에 자료형을 결정할 수 있는 능력을 가짐.*/

    println(Object::class.isInner)//메타 데이터를 가지기에 클래스 타입 확인 가능

    //리플렉션을 통해 어떤 클래스로부터 함수 이름 직접 작성하지 않고 호출 가능
    val className1 = "Reflection1"
    val className2 = "Reflection2"
    val funName = "Fun"
    //Class.forName()를 통해 Class<T>, 클래스 타입 얻기
    val kClass1 = Class.forName(className1).kotlin
    val kClass2 = Class.forName(className2).kotlin
    //얻은 클래스 타입으로 함수 호출
    val instance1 = kClass1.createInstance()
    val instance2 = kClass2.createInstance()
    val function1 = kClass1.functions.find { it.name == funName }
    val function2 = kClass2.functions.find { it.name == funName }
    function1?.call(instance1)
    function2?.call(instance2)

}

/*T는 형식 매개변수 이름. 꼭 T로 명시할 필요 X
E(element),K(key),N(number),T(type),V(value) 주로 씀*/
class Gen<T>{
    /*클래스 내부 프로퍼티에 사용 X.
    자료형이 없어 인스턴스 생성이 불가능하기 때문
    초기화되거나 abstract 선언 시 사용 가능*/
    //val value:T
    fun info(t:T){}//메소드는 가능
}

/*주생성자나 부생성자에 형식 매개변수 사용 가능*/
open class Drink<T>(t:T){
    var count=t
    var size=t
    constructor(t:T, _size:T):this(t)  {
        count=t
        size=_size
    }
    fun isSame(arg1:T, arg2:T){
        println(arg1?.equals(arg2))
    }
}

/*제네릭에서는 상하관계 사용 불가능*/
class Tea<T>(t:T):Drink<T>(t)
class Juice<T>

/*제네릭 메소드*/
fun<T>value(arg:T):T{
    return arg
}
fun <K,V> find(key:K, value:V){}

/*제네릭 메소드 연산*/
//자료형을 알 수 없기에 연산 불가능
//fun <T>sum(num1:T, num1:T):T{
//    return num1+num1
//}
//람다식을 사용하면 람다식을 넘겨줄 때 내용이 전달되기에 연산 가능
fun <T>sum1(num1:T, num2:T, lam:(T,T)->T):T{
    return lam(num1, num2)
}
//typealias 키워드 사용으로 람다 매개변수 단순화 가능
typealias op<T> = (T,T)->T
fun <T>sum2(num1:T, num2:T, lam:op<T>):T{
    return lam(num1, num2)
}

/*자료형 제한*/
class A<T:Number>{
    fun double(num:T):Double{
        return num.toDouble()*2
    }
}
fun <T:Number>sum3(num1:T, num2:T, lam:op<T>):T{
    return lam(num1, num2)
}
//다수 형식 매개변수
interface Red
interface Blue
class Purple:Red,Blue
class Pink:Red
//여러 형식 매개변수를 받고 싶을 때는 where 키워드 사용
//지정된 자료형을 모두 포함한 경우만 허용
class Color<T> where T:Red, T:Blue
fun <T> isBigger(num1:T, num2:T):T where T:Number, T:Comparable<T>{
    return if(num1>num2) num1 else num2
}

/*가변성*/
//무변성
class C1<T>(val count:Int)
//공변성
class C2<out T>(val count:Int)
//반공변성
class C3<in T>(val count:Int)
//class C4<in T>(val count:T)
//반공변성에서는 public 안되기에 private 사용 필요
//외부에서 접근하여 값을 변경하여 타입 안정성을 해치기 때문.
class C4<in T>(private val count:T)

open class Cookie(val count:Int){
    fun cook()=println("Cooking")
}
class Chocolate(val quantity:Int):Cookie(2)
//out일 때는 반환 자료형에는 쓸 수 있지만 매개변수로는 사용 불가능
//또한 val만 허용. var 사용하려면 private 지정 필요
//주생서자에는 in, out 모두 사용 가능하지만 상하관계를 잘 고려해야함
class Snack<out T:Cookie>(val num:T){
    fun getN():T = num
//    fun set(value:T){
//        num=value
//    }
}

/*스타 프로젝션*/
class InOut<in T, out S>(t:T, _s:S){
    //val t:T=_t//in이기에 out위치인 할당 불가능
    val u:S=_s
    fun infoT(t:T){
        println(t)
    }
//    fun infoS(s:S){//out이기에 in위치인 매개변수로 사용 불가능
//        println(s)
//    }
}
fun inOutStart(value:InOut<*,*>){
    //value.infoT(1)//Nothing으로 처리되기에 오류 발생
    println(value.u)
}

/*reified*/
fun <T> funClassT(c: Class<T>, value:Number):T{
    println(c.javaClass)
    return when(c){
        Int::class.java->value.toInt() as T
        Float::class.java->value.toFloat() as T
        Double::class.java->value.toDouble() as T
        else -> throw Exception("지원하지 않는 자료형입니다.")
    }
}
inline fun<reified T> funReified(value:Number):T{
    //다만 타입은 결국 자바에서 가지고 오기 때문에
    //이 부분에서 T::class, T::class.java 는 내용상에서 차이가 없다.
    //그렇기에 둘 다 class java.lang.Float 출력.
    println(T::class)//KClass
    println(T::class.java)//Class
    return when(T::class){
        Int::class->value.toInt() as T
        Float::class->value.toFloat() as T
        Double::class->value.toDouble() as T
        else -> throw Exception("지원하지 않는 자료형입니다.")
    }
}

/*리플렉션*/
class Reflection1 {
    fun Fun() {
        println("Reflection1 - Fun")
    }
}
class Reflection2{
    fun Fun(){
        println("Reflection2 - Fun")
    }
}