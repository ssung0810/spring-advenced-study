package hello.advenced.proxy.pureproxy.decorator.code

import hello.advenced.logInfo

class DecoratorPatternClient(
    private val component: Component
) {
    fun execute() {
        val result = component.operation()
        logInfo("result=${result}")
    }
}