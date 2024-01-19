package com.func

import java.util.concurrent.locks.ReentrantLock

fun main() {

    /*함수형 프로그래밍 : 순수 함수를 사용하여 부작용을 줄이는 기법
    * 함수형 프로그래밍에는 람다식과 고차함수 사용
    * 람다식 : 이름 없는 함수
    * 일급 객체 : 함수의 인자 또는 리턴 값에 사용, 변수에 할당하는 객체
    * 함수가 일급 객체면 일급 함수. 일급 함수에 이름이 없으면 람다식
    * 고차 함수 : 다른 함수를 인자 또는 결과 값으로 반환하는 함수*/

    /*고차 함수*/
    //인자값으로 함수 사용
    val result1=sub(sum(2,5),3)
    //sub 함수의 x인자 값을 sum()함수 사용
    //sum() 계산 후 결과 값이 sub()의 x인자 값이 되어 sub()연산
    println(result1)
    //리턴값으로 함수 사용
    println(getSum())//main()->getSum()->sum()->main()

    /*람다식*/
    // = 기준 왼쪽으로 람다식의 선언 자료형. 매개변수 자료형, 리턴 자료형 명시
    // = 기준 오른쪽으로 중괄호에 본문 내용 적시.
    // -> 왼쪽은 매개변수, 오른쪽은 본문 내용. 표현식이 여러줄이면 마지막 표현식 반환
    val sum1:(Int, Int)->Int = {x:Int, y:Int ->x+y}
    //선언 자료형 모두 명시했기에 매개변수 자료형 생략 가능
    val sum2:(Int, Int)->Int={x,y->x+y}
    //매개변수 자료형 명시했기에 선언 자료형 생략 가능
    val sum3={x:Int, y:Int ->x+y}
    val sum4={x:Int, y:Int ->
        println("sum")
        x+y}//두번째(마지막)줄의 x+y이 반환
    //반환 자료형이 없는 람다식
    val hi1:()->Unit={println("Hello World!")}
    val hi2={println("hello world")}
    hi2()//람다식을 변수에 할당하면 그 변수는 함수처럼 사용 가능
    val hi3=hi2
    hi3()
    //중첩 람다식
    val nested1:()->()->Unit={{println("nested1")}}
    val nested2={{println("nested2")}}
    val nested3=nested2()
    nested3()

    /*람다식을 사용한 고차 함수*/
    val result2= getSumLambda({x,y->x+y}, 1,2)
    println(result2)
    
    /*값에 의한 호출 : 코틀린에서는 함수를 호출할 때 인자 값만 복사*/
    //lambda의 리턴 값을 call1이 바로 받고 다시 그 값을 main에 반환
    val result3= call1(lambda())
    println(result3)
    //람다식 자체가 call2로 복사되어 call2에서 람다 호출
    val result4= call2(lambda)//람다식 이름으로 호출
    println(result4)

    /*일반 함수사용한 고차 함수*/
    //getSumLambda(sum, 1,2) //람다가 아니기에 이름만 호출 불가능
    //함수 앞에 ::사용하여 소괄호와 인자 생략 가능
    //단 인자 수와 자료형이 같아야 됨
    val result5=getSumLambda(::sum, 1,2)
    println(result5)
    val result6=::sum
    println(result6(2,4))
    
    /*매개변수 개수에 따른 람다식*/
    //매개변수 0개
    funLambda1({"Hi"})//매개변수가 없기에 -> 사용X
    funLambda1 { "Hello" }//소괄호 생략 가능
    //매개변수 1개
    funLambda2 ({x->"$x Kotlin"})
    funLambda2 {x->"$x Kotlin"}
    funLambda2 {"$it Kotlin"}//매개변수가 1개뿐이니 ->생략, it 키워드로 대체 사용가능
    //매개변수 여러개
    funLambda3({x,y->"$x $y world"})
    funLambda3{x,y->"$x $y world"}
    funLambda3{x,_->"$x world"}//특정 매개변수 사용하고 싶지 않을 때 _ 사용

    /*매개변수와 람다매개변수 같이 사용*/
    lambdaWithArgs("1","2",{a,b->"변수 $a $b"})
    //마지막 매개변수가 람다면 소괄호 밖으로 빼서 호출 가능
    lambdaWithArgs("1","2"){a,b->"변수 $a $b"}
    lambdas({a->"a:$a"},{x,y->" x:$x,y:$y"})
    lambdas({"a:$it"},{x,y->" x:$x,y:$y"})
    lambdas({"a:$it"}){x,y->" x:$x,y:$y"}

}

/*순수 함수 : 항상 같은 결과를 반환하여 부작용이 없어 예측 가능한 함수
* 외부 객체, 메소드 사용 or if 조건에 따라 결과가 달라지면 순수 함수 X*/
fun pure(x:Int, y:Int):Int{
    return x+y//동일한 인자를 받았을 때 항상 같은 결과인 x+y 반환, 예측 가능
}

/*일반 함수*/
fun sum(x: Int, y:Int)=x+y
fun sub(x:Int, y:Int)=x-y

/*고차 함수*/
fun getSum():Int{
    return sum(2,2)//리턴 값으로 함수 사용
}
//fun getSum():Int=sum(2,2)

/*람다식 사용 고차 함수*/
fun getSumLambda(sum:(Int, Int)->Int, a:Int, b:Int):Int{
    return sum(a,b)
}

/*값에 의한 호출*/
fun call1(num:Int):Int{
    println("call()1")
    return num
}
fun call2(num:()->Int):Int{
    println("call()2")
    return num()
}
val lambda:()->Int={
    println("lambda()")
    1
}

/*매개변수 개수에 따른 람다*/
fun funLambda1(str:()->String){
    println(str())
}
fun funLambda2(str:(String)->String){
    println(str("Hello"))
}
fun funLambda3(str:(String,String)->String){
    println(str("Hello","Kotlin"))
}

/*매개변수와 람다매개변수 같이 사용*/
fun lambdaWithArgs(a:String, b:String,str:(String,String)->String){
    println(str(a,b))
}
fun lambdas(one:(String)->String, two:(String,String)->String){
    println(one("Good"))
    println(two("Good","Day"))
}