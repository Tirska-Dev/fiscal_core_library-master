package me.ugreek85

import freemarker.cache.FileTemplateLoader
import freemarker.template.Configuration
import freemarker.template.Template
import me.ugreek85.builder.document.base.impl.DocumentFactoriesImpl
import me.ugreek85.document.report.IReportDocument
import me.ugreek85.utils.ResourcesUtil
import me.ugreek85.view.xml.impl.XmlDeserializer
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.io.Writer
import java.util.*
import kotlin.collections.HashMap


class TestRadix {


    @Test
    fun test32() {

        val v = 315360154139L
        println(v.toString(36))

        val v2 = 4000066879
        println(v2.toString(36))
    }


}