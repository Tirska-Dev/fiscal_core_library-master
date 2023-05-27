package me.ugreek85.utils

import me.ugreek85.document.common.IDocumentHeader
import me.ugreek85.document.common.InternalDocumentSubType
import me.ugreek85.document.common.InternalDocumentType
import kotlin.test.assertEquals


object IDocumentHeaderTestUtil {

    private lateinit var mDocumentHeader: IDocumentHeader

    fun test(documentHeader: IDocumentHeader)
    {
        mDocumentHeader = documentHeader

        testInternalDocumentType()
        testInternalDocumentSubType()
    }

    private fun testInternalDocumentType()
    {
        mDocumentHeader.setInternalDocumentType(null)
        assertEquals(null, mDocumentHeader.getInternalDocumentType())

        mDocumentHeader.setInternalDocumentType(InternalDocumentType.OPEN_SHIFT)
        assertEquals(InternalDocumentType.OPEN_SHIFT, mDocumentHeader.getInternalDocumentType())
    }

    private fun testInternalDocumentSubType()
    {
        mDocumentHeader.setInternalDocumentSubType(null)
        assertEquals(null, mDocumentHeader.getInternalDocumentSubType())

        mDocumentHeader.setInternalDocumentSubType(InternalDocumentSubType.CANCEL)
        assertEquals(InternalDocumentSubType.CANCEL, mDocumentHeader.getInternalDocumentSubType())
    }



}