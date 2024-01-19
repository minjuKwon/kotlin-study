package com.variable

fun main() {

    /*main에서 sum1함수에 1과 2의 인자를 전달하며 함수 호출
    전달한 인자가 함수의 매개변수로 복사되어 덧셈 연산
    연산 값을 return으로 반환, 함수 실행 종료
    반환 값을 변수 value으로 받음*/
    val value1=sum1(1,2)
    println(value1)

    /*프로그램은 main()함수 본문을 제일 처음에 실행
    *main()함수 안의 지역변수(num1,num2..)가 첫번째 스택 프레임이 들어감
    * 지역변수는 함수가 종료될 때 스택 프레임과 함께 삭제되는 변수
    * main()에서 sum2() 호출하여 두번째 스택 프레임에 들어감
    * 두번째 프레임 지역변수에는 매개변수와 sum2()에 선언된 변수가 들어감
    * sum2() 본문 실행 완료 후, 리턴하면서 두번째 스택 프레임에 사라짐
    * main() 본문 실행 완료 후, 첫번째 스택 프레임 사라짐
    * */
    val num1=1
    val num2=1
    val value2=sum2(num1, num2)
    println(value2)

    /*함수 매개변수에도 default 값 적용 가능*/
    information("Kim")
    //매개변수 명을 지정하여 전달 가능.
    //명시적으로 어떤 변수에 어떤 값을 주는지 알 수 있음
    information(name="Lee")

    /*가변인자를 통해 여러 개수 인자 사용 가능*/
    nums(1,2,3,4)
    nums(8,9)

}

/*함수 요소 생략*/
//int형의 a와 int형의 b를 매개변수로 가지고 Int값을 리턴
//이때 리턴값은 a+b의 합의 결과인 result
fun sum1(a:Int, b:Int):Int{
    val result=a+b
    return result
}
//sum1함수롤 sum2와 같이 줄일 수 있음
fun sum2(a:Int, b:Int):Int{
    return a+b
}
//함수 본문 내용이 1줄일 경우 중괄호와 return문 생략가능
//return문 생략 대신 = 사용
fun sum3(a:Int, b:Int):Int = a+b
//매개변수가 모두 Int이니 결과 값도 Int로 추론 가능하여 리턴 타입 생략 가능.
fun sum4(a:Int, b:Int)=a+b

/*반환값 없는 함수*/
//반환값이 없을 때 Unit 사용, 자바의 void와 비슷
fun print1(a:Int, b:Int): Unit{
    println("a: $a, b: $b")
    return //return할 값이 없기에 return 생략하여 사용 가능
}
//반환값이 없기에 반환 유형 명시하지 않아도 됨
fun println2(a:Int, b:Int){
    println("a: $a, b: $b")
}

/*default 인자값 설정 가능*/
fun information(name: String, phone: String="None"){
    println("name : $name , phone number : $phone")
}

/*가변인자를 통해 매개변수 개수 지정하지 않으며 사용 가능*/
fun nums(vararg num:Int){
    for(a in num){
        print("$a ")
    }
    println()
}