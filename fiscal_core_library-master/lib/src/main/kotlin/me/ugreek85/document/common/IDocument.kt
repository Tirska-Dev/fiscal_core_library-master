package me.ugreek85.document.common

import me.ugreek85.utils.DocumentNameUtil
import me.ugreek85.utils.DocumentTypeUtil

interface IDocument {

    fun getDocumentHeader(): IDocumentHeader
    fun setDocumentHeader(documentHeader: IDocumentHeader)

//    fun getDocumentName(): String
//    fun getDocumentType(): DocumentType

    fun getDocumentName(): String {
        return DocumentNameUtil.getDocumentName(getDocumentType(), getDocumentHeader())
    }

    fun getDocumentType(): DocumentType {
        return DocumentTypeUtil.detectDocumentTypeByHeader(getDocumentHeader())
    }

    fun isOfflineDocument(): Boolean
}
