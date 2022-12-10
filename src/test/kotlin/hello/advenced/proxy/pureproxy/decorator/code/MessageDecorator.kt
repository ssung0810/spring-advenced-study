package hello.advenced.proxy.pureproxy.decorator.code

import hello.advenced.logInfo

class MessageDecorator(
    private val component: Component
) : Component {
    override fun operation(): String {
        logInfo("MessageDecorator 실행")

        val result = component.operation()
        val decoResult = "*****${result}*****"
        logInfo("MessageDecorator 꾸미기 적용전=${result}, 적용 후=${decoResult}")
        return decoResult
    }
}