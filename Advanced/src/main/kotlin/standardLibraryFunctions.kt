import java.io.File
import java.io.FileOutputStream
import java.io.PrintWriter
import kotlin.random.Random
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

fun main() {

    /*let(): 함수 호출 객체 T를 람다인 block 인자에 넘기고 결과 값 R 반환. 즉, 람다식 결과 부분을 그대로 반환.
    호출한 객체를 인자로 받아 이를 통해 다른 메서드 수행 또는 연산 수행에 사용. 객체를 it로 받아 생략 불가능. 제네릭 확장 함수. */
    val num1:Int?=1
    //일반적 null 검사
    if(num1!=null){
        println("num: $num1")
    }
    //let 사용 null 검사
    //null일 경우 람다식 실행 X
    num1?.let { println("num: $num1") }
    //null이라도 string 형태의 "null" 되기 때문에 ?. 사용 X
    println(num1.let { it.toString() })

    var num2:Int?=2
    val num3=5
    if(num2!=null){
        println("num2*num3=${num2*num3}")
    }else{
        println("num2 is null")
    }
    num2?.let {println("num2*num3=${it * num3}") }?:println("num2 is null")

    num2=num2?.let { it*10 }?.let {
        val result= it/num3
        result//마지막 식 변환
    }
    println(num2)
    println()

    /*also(): 함수 호출 객체 T를 람다인 block 인자에 넘기고 객체 T 반환.
    수행 결과와 상환 없이 T 반환. 객체를 it로 받아 생략 불가능. */
    var num4=4
    num4=num4.also { it+1 }
    //also 연산 값이 아닌 원본 값 출력
    println("num4: $num4")
    //makeDir2()
    println()

    /*apply(): 함수 호출 객체 T를 람다인 block 인자에 넘기고 객체 T 반환. 수행 결과와 상환 없이 T 반환.
    단, also()와 달리 객체 T를 it로 멤버에 접근 하는 것이 아닌 this로 받아 생략한 채 멤버 이름만 사용 가능.
    객체를 생성하면서 초기화 코드가 있는 경우 사용. 람다식이 확장 함수로 처리.*/
    val student1=Student("Mina",21)
    val result1=student1.apply {
        this.name="Nima"//student를 this로 받아와 접근. 원본 객체에 반영되고
                        // 다시 이 객체를 this로 접근 가능
        age=22//this 생략하여 접근 가능. 초기화에 편리
        "End"
    }
    println("apply : $result1")
    //makeDir3()
    println()

    /*run(): 인자 없는 익명 함수처럼 동작하는 형태, 객체에서 호출하는 형태 2가지 존재.
    람다인 block 인자에서 R반환 또는 함수 호출 객체 T를 람다인 block 인자에 넘기고 R 반환*/
    //객체 접근 없이 독립적으로 사용 가능. 특정 값을 반환할 수도 안 할 수도 있음.
    var num5=5
    num5= run {
        val n=num5+6
        n
    }
    println("num: $num5")
    //객체를 this로 받아 멤버 접근 가능. apply와 달리 마지막 문단 리턴 가능
    val student2 = Student("Smith",34)
    val result2=student2.run {
        this.name="Swan"
        age=32
        "End"
    }
    println("run : $result2")
    println()

    /*with(): 인자로 받은 객체를 람다인 block 인자에 넘기고 R 반환.
    run()와 달리 객체를 인자로 받음. 세이프콜(?.) 지원하지 않기에 필요 시 let()과 함께 사용.*/
    val student3=Student("John",17)
    val result3=with(student3){
        name="Jun"
        age=19
        "End"
    }
    println(result3)
    println()

    /*use(): 객체를 사용한 후 자동으로 close() 호출.
    예외 오류 발생 상관없이 close() 호출 보장*/
    val path="D:\\Study\\Kotlin\\use.txt"
    PrintWriter(FileOutputStream(path)).use {
        it.println("Hello Kotlin")
    }
    val file=File(path)
    file.bufferedReader().use { println(it.readText()) }

    /*takeIf(): 람다식이 true, 결과 반환. takeUnless(): 람다식이 false, 결과 반환*/
    val num6=6
    val result4= num6.takeIf { it>6 }
    val result5=num6.takeUnless { it>6 }
    println("takeIf: $result4, takeUnless: $result5")
    println()

    /*시간 측정*/
    val result6= measureTimeMillis {
        for(i in 0..1000){
            for(j in 0..1000){

            }
        }
    }
    println("Millis: $result6 ms")
    val result7= measureNanoTime {
        for(i in 0..1000){
            for(j in 0..1000){

            }
        }
    }
    println("Nano: $result7 ns")
    println()
    
    /*난수 측정*/
    println("난수: ${Random.nextInt(10)}")//0~10 난수

}

data class Student(var name:String, var age:Int)

/*also*/
fun makeDir1(path:String):File{
    val result=File(path)
    result.mkdirs()
    return result
}
//also 사용하면 단순히 파일을 리턴할 수 있음.
//let 사용 시 mkdirs() 리턴하였을 것.
fun makeDir2(path:String)= File(path).also { it.mkdirs() }

/*apply*/
//File(path)결과를 it 대신 this로 받음. 단 this 생략 가능.
//also 비슷하게 객체 this 리턴
fun makeDir3(path:String)= File(path).apply { mkdirs() }