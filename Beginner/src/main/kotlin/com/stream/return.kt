package com.stream

fun main() {

    print1("Hello")
    print2("Hello")

    //return 이후 바로 종료하기에 return 이후 본문 내용 출력X. 비지역 반환 발생
    getLambda1()
    //라벨로 return 이후 내용도 출력
    getLambda2()
    //암묵적 라벨 : 람다식 명칭을 라벨로 사용
    getLambda3()
    //람다 대신 익명 함수 사용하면 라벨 사용 필요 X
    getAnnoy()

    val getNumber1=getNum@{ num:Int->
        if(num==1)
            return@getNum "1입니다"
        else if(num==2){
            return@getNum "2입니다"
        }else{
            "1,2이 아닙니다"
        }
    }
    val num=getNumber1(3)
    println(num)
    //return 값이 필요할 때는 람다 보다는 익명 함수가 return문 명확시 구별 가능
    val getNumber2=fun(a:Int):String{
        when (a) {
            1 -> return "1입니다"
            2 -> return "2입니다"
            else -> return "1,2이 아닙니다."
        }
    }
    val num2=getNumber2(3)
    println(num2)

}

fun print1(str:String):Unit{
    println(str)
    return Unit//아무것도 반환 값이 없을 때는 Unit 반환
}
fun print2(str:String){
    println(str)//Unit 리턴 생략 가능.
    //자바의 아무것도 반환하지 않는 void와 달리 Unit는 Unit이라는 자료형이 존재
}

inline fun setLambda(x:Int, y:Int, str:(Int,Int)->Unit){
    str(x,y);
}
fun getLambda1(){
    println("함수1 시작")
    setLambda(2,4){x,y->
        if((x+y)%2==0) return//일반 람다에서는 return 사용X. 인라인이기에 사용 가능
        println("홀수입니다")
    }
    println("함수1 종료")
}
fun getLambda2(){
    println("함수2 시작")
    setLambda(2,4)odd@{x,y->
        if((x+y)%2==0) return@odd//일반 람다에서는 return 사용X. 인라인이기에 사용 가능
        println("홀수입니다")
    }
    println("함수2 종료")
}
fun getLambda3(){
    println("함수3 시작")
    setLambda(2,4){x,y->
        if((x+y)%2==0) return@setLambda//일반 람다에서는 return 사용X. 인라인이기에 사용 가능
        println("홀수입니다")
    }
    println("함수3 종료")
}
fun setAnony(x:Int, y:Int, str:(Int,Int)->Unit){
    str(x,y);
}
fun getAnnoy(){
    println("익명 함수 시작")
    setAnony(2,4, fun(x,y){
        if((x+y)%2==0) return
        println("홀수입니다")
    })
    println("익명 함수 종료")
}
