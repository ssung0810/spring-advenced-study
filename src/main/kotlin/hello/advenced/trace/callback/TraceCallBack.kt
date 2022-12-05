package hello.advenced.trace.callback

fun interface TraceCallBack<T> {
    fun call(): T
}