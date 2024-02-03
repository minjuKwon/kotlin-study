package propertyAndInit

import java.lang.AssertionError

fun main() {

    /*프로퍼티 : 클래스 내에 선언된 변수. 필드+세터+게터
    * 자바와 달리 자동으로 접근자 생성.
    * 접근자를 통해 필요할 때만 읽거나 쓸 수 있어, 데이터의 무결성과 보안 유지*/

    /*field : 프로퍼티를 참조하는 변수. 보조필드라고도 함
    * field라고 이름이 정해졌기에 필드명 수정 불가능*/

    /*value : setter의 매개변수. 외부로부터 전달된 값 저장
    * 다른 필드명으로 표현해도 됨. value 명 사용 권장*/

    val p=Person(1,"Kim",28,"student","123@email.com","play")
    println("name : ${p.id}, ${p.age}")

    val pId=p.id//getter를 통해 값 얻기
    //p.id=12 //val 이기에 값 수정 불가능
    p.age=29//var이기에 값 수정 가능
    println("name : $pId, ${p.age}")

    p.job="Office Worker"
    //p.email=""//setter가 private으로 선언되어 수정 불가능
    println("job : ${p.job}")
    println("email : ${p.email}")

    println("hobby : ${p.hobby}")

    val two=Two()
    println("a : ${two.a}, b : ${two.b}")
    two.a=6
    println("a : ${two.a}, b : ${two.b}")//오버라이딩한 a값 출력

}

class Person(_id:Int,_name:String, _age:Int, _job:String, _email:String, _hobby:String?){

    val id=_id//val 값 변경 불가능. 즉 읽기 전용이기에 getter만 제공

    var name=_name//var이기에 getter, setter 모두 제공
        get(){
            return field
        }
        set(value){
            field=value
        }

    var age=_age
       /* get(){
            return temp //field 외 표현하면 오류 발생
        }*/
       //바로 프로퍼티를 할당하면 다시 get()를 호출하여
       //무한 재귀에 빠짐. 스택 오버플로 발생. 그래서 임시적 보조필드 사용
       //get()=age
        set(temp){
            field=temp//value 외 다른 이름으로 표현 가능
           //age=temp->this.setAge(temp).스택 오버플로우 발생
           //age=temp
        }

    var job=_job
        set(value){//setter 수정가능
            field=value.toLowerCase()
        }

    var email=_email
        get(){//getter 수정가능
            return "Email : $field"
        }
        private set//외부에서 email 값 수정 불가능

    //field 키워드가 아닌 내부 임시 변수 사용 가능
    //변경 가능한 프로퍼티지만 외부에 값을 변경하고 싶지 않을 때 사용가능
    //Backing property라고도 함.
    private var temp:String?=null
    var hobby=_hobby
        get(){
            if(temp==null){
                temp="None"
            }
            return temp?:throw AssertionError("Nothing")
        }

}

open class One{
    open val a:Int=1
    open var b:Int=2
    val c:Int=3
}
class Two:One(){
    //상위 클래스 val-> 하위 클래스 var로 수정 가능
    override var a: Int=4
        get(){
            return field*10//프로퍼티도 오버라이딩하여 접근자도 수정 가능
        }
        set(value){
            field=when{//조건문도 사용 가능
                value in 1..5->value
                value>5-> value+1
                else ->value-1
            }
        }
    //상위 클래스 var-> 하위 클래스 val로 수정 불가능
    // override val b: Int
    //override val c:Int //open 표시안하면 final이 기본이라 오버라이딩 불가
}