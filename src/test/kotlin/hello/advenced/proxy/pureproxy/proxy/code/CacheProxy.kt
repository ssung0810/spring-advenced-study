package hello.advenced.proxy.pureproxy.proxy.code

import hello.advenced.logInfo

class CacheProxy(
    private val target: Subject
) : Subject {
    private var cacheValue: String? = null

    override fun operation(): String {
        logInfo("프록시 호출")

        if (cacheValue == null) {
            cacheValue = target.operation()
        }

        return cacheValue!!
    }
}