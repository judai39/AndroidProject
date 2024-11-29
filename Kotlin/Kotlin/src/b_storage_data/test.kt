package b_storage_data

class Test {
}

fun main() {
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = SUPPORTED.contains(requested)
    println("Support for $requested: $isSupported")
}