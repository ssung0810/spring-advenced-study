package hello.advenced.proxy.pureproxy.concreteproxy

import hello.advenced.proxy.pureproxy.concreteproxy.code.ConcreteClient
import hello.advenced.proxy.pureproxy.concreteproxy.code.ConcreteLogic
import hello.advenced.proxy.pureproxy.concreteproxy.code.TimeProxy
import org.junit.jupiter.api.Test

class ConcreteProxyTest {
    @Test
    fun addProxy() {
        val concreteLogic = ConcreteLogic()
        val timeProxy = TimeProxy(concreteLogic)
        val concreteClient = ConcreteClient(timeProxy)
        concreteClient.execute()
    }
}