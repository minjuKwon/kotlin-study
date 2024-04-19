import java.lang.NumberFormatException
import java.util.*

fun main() {

    /*문자열 : 문자의 배열. 불변 값으로 생성되어 참조된 메모리 변경 불가능.
    즉, 새로운 값을 재할당하려면 새로운 메모리에 수정된 문자열이 할당. 기존 메모리는 GC에 의해 제거*/

    val greeting1="안녕하지 못한다"
    println(greeting1[2])
    var greeting2="오늘은 안녕한다"
    //greeting2[6]='하'//문자열 특정 인덱스 문자 변경 불가능
    greeting2="안녕하겠냐"//전체 문자열을 내부적으로 새로 생성하여 할당.
    println()

    /*추출*/
    println(greeting2.substring(2..4))//인덱스 범위 문자 추출
    //문자열은 메모리가 고정되어 특정 인덱스 수정 불가능.
    //기존 문자열에 특정 문자를 업데이트하고 병합하여 재할당하면 수정 가능
    //기존 문자열의 내용(안녕하겠냐)은 GC에 의해 제거됨
    greeting2=greeting2.substring(0..1)+" 후.. "+greeting2.substring(3..greeting2.length-1)
    println(greeting2)
    println()

    /*비교*/
    val str1="Cat"
    val str2="cat"
    println(str1.compareTo(str2))//왼값이 크면 양수, 적으면 음수, 같으면 0
    println(str1.compareTo(str2,true))//대소분자 구분 무시
    println()

    /*stringBuilder: 기존 문자열보다 메모리 공간이 더 큼. 그렇기에 특정 문자 변경 가능.
    단어 변경이 없으면 임시 공간인 메모리 낭비. 큰 문자열이 자주 변경되는 경우에 사용.
    문자열 + 연산자 사용할 때 내부적으로 stringBuilder 사용.*/
    val stringBuilder=StringBuilder("안녕하뭅니까")
    stringBuilder[3]='십'
    println(stringBuilder)
    stringBuilder.append(" 여러분")//문자열 추가.
    println(stringBuilder)
    stringBuilder.insert(0, "오늘도 ")//추가할 문자열 위치 인덱스 지정
    println(stringBuilder)
    stringBuilder.delete(6,10)//삭제할 문자열 위치 인덱스 지정. 두번째 인덱스는 포함 X
    println(stringBuilder)
    println()

    /*문자열 처리*/
    val s=" I want to go to bed "
    println(s)
    println(s.trim())//앞 뒤 공백 제거
    println(s.uppercase(Locale.getDefault()))//모든 문자열 대문자로 변경
    println(s.lowercase(Locale.getDefault()))//모든 문자열 소문자로 변경
    val list=s.split(" ")//문자열을 특정 단위로 잘라내어 리스트로 반환. 여기서는 공백
    println(list)
    val list2="010-1111-1111, 010-2222-2222".split("-",",")//
    println(list2)

    try{
        println("123".toInt())//숫자로만 이루어진 문자열 정수형으로 변환
    }catch (e:NumberFormatException){//문자열에 숫자가 아닌 값이 있을 수 있기에 오류 처리 필수
        println(e.printStackTrace())
    }
    println("456".toIntOrNull())//숫자가 아닌 값이 있으면 null를 반환하기에 오류 처리 불필요
    println("789!".toIntOrNull())
    println()

    /*리터럴 문자열*/
    println("\t \"\'oh\' hello\n 4\$\" ")
    println("\uAC00")//유니코드. 16진수
    ///3중 따옴표로 원본 문자열 그대로 표시 가능
    val test="""죽는 날까지 하늘을 우러러
        |한 점 부끄럼이 없기를
        |잎새에 이는 바람에도 
        |나는 괴로와 했다.
    """.trimMargin()//특정 문자 기준으로 공백 제거. |는 디폴트
    println(test)
    println()

    /*형식 문자 사용*/
    println("%.2f is perfect number. %s says, It is %b".format(3.1415,"Smith",true))

}