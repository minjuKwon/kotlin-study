package com.func

fun main() {

    /*확장 함수 : 기존 클래스에 필요한 함수를 추가해주는 함수*/
    println("안녕하세요".getLongerLen("코틀린"))
    println("bed".hashCode())

}

//기본 String 클래스에 사용자 정의 함수 추가
fun String.getLongerLen(target:String):String{
    if(this.length>target.length){
        return this
    }else{
        return target
    }
}

//확장 함수 생성시 동일한 이름의 멤버 함수가 이미 존재하면
// 기존 함수가 우선 호출
fun String.hashCode(a:String):String{
    return "hashCode()"
}