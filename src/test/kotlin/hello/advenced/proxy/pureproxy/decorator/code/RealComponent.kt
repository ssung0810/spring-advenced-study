package hello.advenced.proxy.pureproxy.decorator.code

import hello.advenced.logInfo

class RealComponent : Component {
    override fun operation(): String {
        logInfo("RealComponent 실행")
        Thread.sleep(1000)
        return "data"
    }
}