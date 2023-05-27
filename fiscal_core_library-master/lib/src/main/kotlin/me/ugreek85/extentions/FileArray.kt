package me.ugreek85.extentions

import java.io.File
import java.nio.file.Files
import java.nio.file.attribute.BasicFileAttributes
import java.util.*

fun Array<File>.sortByTimeCreation(): Array<File>
{
    Arrays.sort(
        this
    )
    { f1, f2 ->

        val attr1 = Files.readAttributes(f1.toPath(), BasicFileAttributes::class.java)
        val attr2 = Files.readAttributes(f2.toPath(), BasicFileAttributes::class.java)

        attr1.creationTime().toMillis().compareTo(attr2.creationTime().toMillis())
    }

    return this
}

fun Array<File>.sortByTimeModification(): Array<File>
{
    Arrays.sort(
        this
    )
    { f1, f2 ->
        f1.lastModified().compareTo(f2.lastModified())
    }

    return this
}

fun Array<File>.sortByName(): Array<File>
{
    Arrays.sort(
        this
    )
    { f1, f2 ->

        f1.name.compareTo(f2.name)
    }

    return this
}