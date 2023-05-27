package me.ugreek85.view.xml.impl.document

import me.ugreek85.document.common.DocumentType
import me.ugreek85.document.common.IDocument
import me.ugreek85.utils.DocumentNameUtil
import me.ugreek85.utils.DocumentTypeUtil

abstract class XmlBaseDocument : IDocument {

    override fun isOfflineDocument(): Boolean {
        return getDocumentHeader().isOffline() ?: false
    }
}
