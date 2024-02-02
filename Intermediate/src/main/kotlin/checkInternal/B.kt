package checkInternal

import classAndObject.modifier.Internal
//다른 패키지라도 같은 모듈안에 있기에 접근 가능
fun main() {
    val v= Internal()
    v.num
    v.changeNum()
    v.getMethod()
}