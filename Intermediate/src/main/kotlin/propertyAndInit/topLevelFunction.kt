//최상위 함수는 역컴파일될 때 자동으로 생성된 클래스 안에 
//static 키워드가 붙여진 메소드로 생성된다.
//이때 생성된 클래스명은 파일이름+확장자 형태
//별도로 명시하고 싶을 때 @file:JvmName()사용
@file:JvmName("TopLevel")

package propertyAndInit

/*최상위 함수(패키지 레벨 함수) : 클래스 없이 만든 함수
JVM 실행위해 자동으로 static 붙어서 객체 생성 없이 사용 가능
정적 함수처럼 접근 가능*/
fun kotlinTopLevelFun(){
    println("Top level function in kotlin")
}

fun main() {
    kotlinTopLevelFun()
}