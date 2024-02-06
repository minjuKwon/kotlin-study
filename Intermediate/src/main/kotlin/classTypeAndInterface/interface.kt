package classTypeAndInterface

fun main() {

    /*인터페이스 : 설계 명시. 추생클래스와 비슷하지만 프로퍼티에 값 할당 불가능. 즉, 선언만 가능.
    추생 클래스와 달리 상위 클래스가 불완전해도 하위 클래스에서 영향을 받지 않음. 상속의 개념 보다는 구현.
    하위클래스 보다 구현 클래스로 칭함. 인터페이스는 구현 클래스와 약한 연관을 가짐(간접적 관계).
    인터페이스에 추상 메소드가 있으면 구현 클래스에서 구현 필요. 디폴트 메소드라는 구현된 메소드도 포함 가능.
    그렇기에 구현이 필요한 내용만 재정의 할 수 있음. 여러 인터페이스 상속 가능.
    */

    val bread=Bread(100, 170)
    bread.measure()
    println("yeast : ${bread.yeast}")
    bread.handRub()//인터페이스 내 기본 메소드
    bread.oven()
    println()

    val baguette=Baguette(250, 3,200)
    baguette.measure()
    baguette.handRub()
    baguette.oven()
    println()

    val patissier=Patissier(bread, baguette)//인터페이스 구현된 클래스 입력
    patissier.oven(bread)
    patissier.oven(baguette)
    patissier.making()

}

interface Knead{
    val flour:Int//기본적으로 abstract을 가짐. 값 할당은 불가능
    val yeast:Int
            get()=3//val인 경우 getter로 구현 가능
            //set(value) {} setter는 불가능
    /*var salt:Int
        get()=8*/ //var은 getter 구현 불가능
    fun measure()//기본적으로 abstract을 가짐
    fun handRub(){
        println("반죽을 주물럭거립니다")//구현부가 있는 일반메소드도 가능
    }
}

interface Baking{
    val temperature:Int
    fun oven()
}

class Bread(override val flour: Int, override val temperature: Int):Knead,Baking{//여러 인터페이스 구현
    override fun measure() {
        println("Bread : flour - $flour")
    }
    override fun oven() {
        println("Bread : bake in oven at $temperature")
    }
}

class Baguette(override val flour: Int, override val yeast: Int, override val temperature: Int):Knead, Baking{//여러 인터페이스 구현
    override fun measure() {
        println("Baguette : flour - $flour, yeast - $yeast")
    }
    override fun oven() {
        println("Baguette : bake in oven at $temperature")
    }
}

class Patissier(knead: Knead, baking: Baking): Knead by knead, Baking by baking{//인터페이스에서도 by 위임자 사용 가능
    //인터페이스의 다형성. 인터페이스를 구현한 클래스를 매개변수로 받을 수 있음
    fun oven(baking:Baking){
        println("${baking.temperature}도로 굽고 있습니다")
    }
    fun making(){
        measure()
        oven()
    }
}