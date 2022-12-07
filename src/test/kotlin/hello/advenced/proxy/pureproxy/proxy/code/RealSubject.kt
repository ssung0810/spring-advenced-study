package hello.advenced.proxy.pureproxy.proxy.code

import hello.advenced.logInfo

class RealSubject : Subject {
    override fun operation(): String {
        logInfo("실제 객체 호출")
        Thread.sleep(1000)
        return "data"
    }
}