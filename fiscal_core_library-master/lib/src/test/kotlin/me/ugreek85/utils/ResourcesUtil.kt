package me.ugreek85.utils

import java.io.File


object ResourcesUtil {

    fun readBytes(fileName: String): ByteArray
    {
        println(File("src/test/resources", fileName).absolutePath)
        return File("src/test/resources", fileName).readBytes()
//        return ResourcesUtil::class.java.classLoader.getResource(fileName)!!.readBytes()
    }
}