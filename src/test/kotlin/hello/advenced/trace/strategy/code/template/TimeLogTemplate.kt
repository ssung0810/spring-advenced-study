package hello.advenced.trace.strategy.code.template

import hello.advenced.logInfo

class TimeLogTemplate {
    fun execute(callBack: CallBack) {
        val startTime = System.currentTimeMillis()

        callBack.call()

        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        logInfo("resultTime=${resultTime}")
    }
}