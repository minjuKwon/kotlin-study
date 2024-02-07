package classTypeAndInterface

fun main() {

    /*열거형 클래스 : 상수를 선언하여 조건에 따라 선택할 수 있는 클래스. enum 키워드 사용.
    실드 클래스와 비슷하나 여러 자료형을 다루지는 못함. 동일한 자료형 나열*/

    val month=Month.FEB
    println("지금은 ${month.num}월 입니다.")
    println(Month.FEB.season())

    println(info(Month.JAN))
    println(info(Month.MAR))
    println(info(Month.MAY))
    println(info(Month.JUL))
    println(info(Month.SEP))
    println(info(Month.NOV))

    println(Skill.ADVANCE.getStep())
    println(Skill.valueOf("INTERMEDIATE"))
    println(Skill.BEGINNER.order)

    for(s in Skill.values()){
        println("name : ${s.name}, order : ${s.order}")
    }

}

enum class RockPaperScissors{
    ROCK, PAPER, SCISSOR//상수 객체로 취급
}

//주 생성자 보유 가능
enum class Month(val num:Int){
    JAN(1), FEB(2), MAR(3), APR(4), MAY(5),
    JUN(6), JUL(7), AUG(8), SEP(9), OCT(10),
    NOV(11), DEC(12);//메소드를 추가할 경우 ;를 사용하여 상수 객체 끝을 알림
    fun season():String{
        var result="None"
        when(num){
            12,1,2->result="WINTER"
            3,4,5->result="SPRING"
            6,7,8->result="SUMMER"
            8,10,11->result="FAIL"
        }
        return result
    }
}

fun info(month:Month)= when(month){
    Month.JAN, Month.FEB ->month.name//이름 가져오기
    Month.MAR, Month.APR ->month.ordinal//순번
    Month.MAY, Month.JUN ->month.toString()//문자열 반환
    Month.JUL, Month.AUG ->month//기본값(문자열)
    Month.SEP, Month.OCT ->month.num
    Month.NOV, Month.DEC ->month.season()
}

//enum도 인터페이스 구현 가능
interface Step{
    fun getStep():Int
}
enum class Skill(val order:Int):Step{
    BEGINNER(1){
        override fun getStep(): Int =45
    },
    INTERMEDIATE(2){
        override fun getStep(): Int =70
    },
    ADVANCE(3){
        override fun getStep(): Int =100
    }
}