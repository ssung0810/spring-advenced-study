package hello.advenced.proxy.pureproxy.concreteproxy.code

import hello.advenced.logInfo

open class ConcreteLogic {
    open fun operation(): String {
        logInfo("ConcreteLogic 실행")
        return "data"
    }
}