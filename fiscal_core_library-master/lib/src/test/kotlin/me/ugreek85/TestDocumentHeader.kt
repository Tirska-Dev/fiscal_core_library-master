package me.ugreek85

import me.ugreek85.document.common.IDocumentHeader
import me.ugreek85.document.common.InternalDocumentSubType
import me.ugreek85.document.common.InternalDocumentType
import me.ugreek85.document.common.impl.DocumentHeaderImpl
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

class TestDocumentHeader {

    private val uid = UUID.randomUUID().toString()

    private val documentTypeSale = InternalDocumentType.SALE
    private val documentSubTypeSale = InternalDocumentSubType.SALE

    private val companyName = "Test Company Name"
    private val pointName = "Test Point Name"
    private val pointAddress = "Test Point Address"
    private val cashierName = "Test Cashier Name"
    private val sellerId = "Seller ID"
    private val vatNumber = "Vat Number"
    private val date = "26022021"
    private val time = "002222"
    private val documentNumber = 2343L
    private val registrarLocalNumber = 1L
    private val registrarId = 3423423423342L
    private val fiscalNumberForReturn = "3402843"
    private val fiscalNumberForDelete = "234938742"
    private val revokeLastOnlineDocument = false
    private val comment = "Test Comment"
    private val version = 2
    private val fiscalNumber = "3049834098"
    private val revoked = true
    private val deleted = false
    private val offline = true
    private val previousDocumentHash = "Prev Doc Hash"

    private var header: IDocumentHeader = DocumentHeaderImpl()

    @BeforeEach
    fun setUp()
    {
        header.setCompanyName(companyName)
        header.setPointName(pointName)
        header.setPointAddress(pointAddress)
        header.setCashierName(cashierName)
        header.setInternalDocumentType(documentTypeSale)
        header.setInternalDocumentSubType(documentSubTypeSale)
        header.setUid(uid)
        header.setSellerId(sellerId)
        header.setVatNumber(vatNumber)
        header.setDate(date)
        header.setTime(time)
        header.setDocumentNumber(documentNumber)
        header.setRegistrarLocalNumber(registrarLocalNumber)
        header.setRegistrarId(registrarId)
        header.setFiscalNumberForReturn(fiscalNumberForReturn)
        header.setFiscalNumberForCancel(fiscalNumberForDelete)
        header.setRevokeLastOnlineDocument(revokeLastOnlineDocument)
        header.setComment(comment)
        header.setVersion(version)
        header.setFiscalNumber(fiscalNumber)
        header.setRevoked(revoked)
        header.setCanceled(deleted)
        header.setOffline(offline)
        header.setPreviousDocumentHash(previousDocumentHash)
    }

    @Test
    fun testHeaderValues() {

        assertEquals(header.getCompanyName(), companyName)
        assertEquals(header.getPointName(), pointName)
        assertEquals(header.getPointAddress(), pointAddress)
        assertEquals(header.getCashierName(), cashierName)
        assertEquals(header.getInternalDocumentType(), InternalDocumentType.SALE)
        assertEquals(header.getInternalDocumentSubType(), InternalDocumentSubType.SALE)
        assertEquals(header.getUid(),  uid)
        assertEquals(header.getSellerId(), sellerId)
        assertEquals(header.getVatNumber(), vatNumber)
        assertEquals(header.getDate(), date)
        assertEquals(header.getTime(), time)
        assertEquals(header.getDocumentNumber(), documentNumber)
        assertEquals(header.getRegistrarLocalNumber(), registrarLocalNumber)
        assertEquals(header.getRegistrarId(), registrarId)
        assertEquals(header.getFiscalNumberForReturn(), fiscalNumberForReturn)
        assertEquals(header.getFiscalNumberForCancel(), fiscalNumberForDelete)
        assertEquals(header.isRevokeLastOnlineDocument(), revokeLastOnlineDocument)
        assertEquals(header.getComment(), comment)
        assertEquals(header.getVersion(), version)
        assertEquals(header.getFiscalNumber(), fiscalNumber)
        assertEquals(header.isRevoked(), revoked)
        assertEquals(header.isCanceled(), deleted)
        assertEquals(header.isOffline(), offline)
        assertEquals(header.getPreviousDocumentHash(), previousDocumentHash)

    }
}