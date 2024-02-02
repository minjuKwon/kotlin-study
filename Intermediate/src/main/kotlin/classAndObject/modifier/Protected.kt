package classAndObject.modifier

//최상위 클래스에는 protected 사용 불가능
/*protected open class Device {
}*/

open class Protected {
    //protected는 멤버에만 지정 가능
    protected var num=1
    protected fun changeNum(){
        num++
    }
    fun getMethod(){
        changeNum()
    }
    protected class N//내부 클래스에는 protected 사용 가능
}