package classTypeAndInterface

fun main() {
    
    /*지역 클래스 : 초기화 블록이나 메서드 내에 선언된 클래스. 블록을 벗어나면 사용 X
    다른 클래스에서의 사용이 적고 외부의 접근이 필요 없을 때 사용.*/

    val show=Show()
    show.schedule()
    
}

class Show{
    private val name="crimeScene"
    fun schedule(){
        class Season(val num:Int){
            fun info()=println("$name $num is coming")//외부 멤버 접근 가능
        }
        val season=Season(4)
        season.info()
    }
    //val season=Season(5)//schedule() 밖에서는 Season 클래스 사용 불가능
}