package hello.advenced.proxy.pureproxy.decorator.code

import hello.advenced.logInfo

class TimeDecorator(
    private val component: Component
) : Component {
    override fun operation(): String {
        logInfo("TimeDecorator 실행")
        val startTime = System.currentTimeMillis()

        val result = component.operation()

        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        logInfo("TimeDecorator 종료 resultTime=${resultTime}ms")
        return result
    }
}