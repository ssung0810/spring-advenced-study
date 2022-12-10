package hello.advenced.proxy.pureproxy.concreteproxy.code

import hello.advenced.logInfo

class TimeProxy(
    private val concreteLogic: ConcreteLogic
) : ConcreteLogic() {
    override fun operation(): String {
        logInfo("TimeDecorator 실행")
        val startTime = System.currentTimeMillis()

        val result = concreteLogic.operation()

        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        logInfo("TimeDecorator 종료 resultTime=${resultTime}ms")
        return result
    }
}