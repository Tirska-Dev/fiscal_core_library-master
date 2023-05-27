package me.ugreek85.extentions

import java.io.File
import java.nio.file.Files
import java.nio.file.attribute.BasicFileAttributes
import java.util.*

fun File.mkdirIfNotExists()
{
    if(!exists()) mkdir()
}

fun File.mkdirsIfNotExists()
{
    if(!exists()) mkdirs()
}