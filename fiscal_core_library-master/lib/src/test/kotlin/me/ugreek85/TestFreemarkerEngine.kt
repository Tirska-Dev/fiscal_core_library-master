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


class TestFreemarkerEngine {

    private val xmlDeserializer = XmlDeserializer()

    private fun getTemplateConfiguration(): Configuration{
        // Конфигурация
        val cfg = Configuration(Configuration.VERSION_2_3_31)
        val ftl1 = FileTemplateLoader(File("src/test/resources"))
        cfg.templateLoader = ftl1;
        return cfg
    }

    fun processTemplate(temp: Template, data: Map<String, Any>)
    {
        // обработка шаблона и модели данных

//        val out: Writer = OutputStreamWriter(System.out)
        val out: Writer = OutputStreamWriter(FileOutputStream("tmp/result.html"))
        // вывод в консоль
        temp.process(data, out)
    }

    @Test
    fun testTemplate() {

        val cfg = getTemplateConfiguration()

        // модель данных
        val root: MutableMap<String, Any> = HashMap()
        root["name"] = "Freemarker"
        // шаблон

        val temp: Template = cfg.getTemplate("test.ftl")
        processTemplate(temp, root)
    }

    @Test
    fun testTemplate2() {

        val cfg = getTemplateConfiguration()

        // модель данных
        val root: MutableMap<String, Any> = HashMap()
        root["name"] = "Freemarker"
        root["father"] = Arrays.asList("Alexander", "Petrov", 47);

        // шаблон
        val temp: Template = cfg.getTemplate("test2.ftl")
        processTemplate(temp, root)
    }

    @Test
    fun testTemplate3() {

        val cfg = getTemplateConfiguration()



        val reportInputBytes = ResourcesUtil.readBytes("report_pwn.xml")
        val reportDocument = xmlDeserializer.deserialize(reportInputBytes, DocumentFactoriesImpl())

        // модель данных
        val root: MutableMap<String, Any> = HashMap()
        root["document"] = reportDocument
        root["documentName"] = "Z-ЗВІТ"
        root["documentDateTime"] = "12.12.12 11:11:11"
        root["shiftId"] = "11111"

//        (reportDocument as IReportDocument).setServiceInputSum(12.0)
//        root["name"] = "Freemarker"
//        root["father"] = Arrays.asList("Alexander", "Petrov", 47);

        // шаблон
        val temp: Template = cfg.getTemplate("z-report.ftl")
        processTemplate(temp, root)
    }


}
