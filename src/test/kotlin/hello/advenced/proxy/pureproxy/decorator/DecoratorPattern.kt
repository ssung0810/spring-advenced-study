package hello.advenced.proxy.pureproxy.decorator

import hello.advenced.proxy.pureproxy.decorator.code.DecoratorPatternClient
import hello.advenced.proxy.pureproxy.decorator.code.RealComponent
import org.junit.jupiter.api.Test

class DecoratorPattern {
    @Test
    fun noDecorator() {
        val realComponent = RealComponent()
        val client = DecoratorPatternClient(realComponent)
        client.execute()
    }
}