package classAndObject.constructor

/*내용이 비어있는 클래스 선언. */
//class Bird{}
//class Bird

class Bird1 {

    //프로퍼티(속성), 클래스 내부에 정의되어 있기에 멤버 변수라고도 함
    //생성자가 없으면 반드기 초기화 필요
    var name:String="crow"
    var size:Int=50
    var color:String="black"
    var feed:String="omnivorous diet"

    //메서드. 멤버 메서드라고도 함.
    fun body(cm:Int) =println("It is $size cm")
    fun eat() = println("It eat $feed")

}