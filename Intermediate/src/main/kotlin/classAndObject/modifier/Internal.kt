package classAndObject.modifier

internal class Internal {
    internal var num=1
    internal fun changeNum(){
        num++
    }
    fun getMethod(){
        changeNum()
    }
}