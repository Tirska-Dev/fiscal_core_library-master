package me.ugreek85.view.json.impl.document

import com.google.gson.annotations.SerializedName
import me.ugreek85.document.common.*
import me.ugreek85.utils.CompanyNameUtil
import me.ugreek85.utils.CopyObjectUtil
import me.ugreek85.utils.DocumentNameUtil
import me.ugreek85.utils.DocumentTypeUtil
import org.simpleframework.xml.Element
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

open class JsonBaseDocument : IDocument, IDocumentHeader {

    // ************** Header Begin ************** //

    @SerializedName("shiftId")
    var shiftId: String = ""

    @SerializedName("documentType")
    private var _documentType: DocumentType? = null

    @SerializedName("dateTime")
    private var _dateTime: String? = null

    @SerializedName("test")
    private var _test: Boolean? = null

    @SerializedName("receiptLink")
    private var _receiptLink: String? = null

    // ************** Header Finish ************** //

    override fun getDocumentHeader(): IDocumentHeader {
        return this
    }

    override fun setDocumentHeader(documentHeader: IDocumentHeader) {
        println("JsonBaseDocument::setDocumentHeader() start")
        CopyObjectUtil.copyByInterface(IDocumentHeader::class.java, documentHeader, this)

        if(mCompanyName.isNotEmpty() && mSellerId.isNotEmpty()) {
            mCompanyName = CompanyNameUtil.getCorrectName(mCompanyName, mSellerId)
        }

        println("JsonBaseDocument::setDocumentHeader() end")
    }

    override fun isOfflineDocument(): Boolean {
        return getDocumentHeader().isOffline() ?: false
    }


    @Transient
    private var mInternalDocumentType: InternalDocumentType? = null

    @Transient
    private var mInternalDocumentSubType: InternalDocumentSubType? = null

    // output xml tag ("UID")
    @Transient
    private var mUid: String = ""

    // output xml tag ("TIN")
    @SerializedName("tin")
    private var mSellerId: String = ""

    // output xml tag ("IPN")
    @SerializedName("ipn")
    private var mVatNumber: String? = null

    // output xml tag ("ORGNM")
    @SerializedName("companyName")
    private var mCompanyName: String = ""

    // output xml tag ("POINTNM")
    @SerializedName("pointName")
    private var mPointName: String = ""

    // output xml tag ("POINTADDR")
    @SerializedName("pointAddress")
    private var mPointAddress: String = ""

    // output xml tag ("ORDERDATE")
    @Transient
    private var mDate: String = ""

    // output xml tag ("ORDERTIME")
    @Transient
    private var mTime: String = ""

    // output xml tag ("ORDERNUM")
    @SerializedName("receiptNumber")
    private var mDocumentNumber: Long = 0L

    // output xml tag ("CASHDESKNUM")
    @SerializedName("registrarLocalNumber")
    private var mRegistrarLocalNumber: Long = 0L

    // output xml tag ("CASHREGISTERNUM")
    @SerializedName("registrarId")
    private var mRegistrarId: Long = 0L

    // output xml tag ("ORDERRETNUM")
    @SerializedName("returnDocumentNumber")
    private var mFiscalNumberForReturn: String? = null

    // output xml tag ("ORDERSTORNUM")
    @Transient
    private var mFiscalNumberForDelete: String? = null

    // output xml tag ("REVOKELASTONLINEDOC")
    @Transient
    private var mRevokeLastOnlineDocument: Boolean? = null

    // output xml tag ("CASHIER")
    @SerializedName("cashierName")
    private var mCashierName: String? = null

    // output xml tag ("LOGOURL")
    @Transient
    private var mLogoUrl: String? = null

    // output xml tag ("COMMENT")
    @SerializedName("comment")
    private var mComment: String? = null

    // output xml tag ("VER")
    @Transient
    private var mVersion: Int = 0

    // output xml tag ("ORDERTAXNUM")
    @SerializedName("fiscalNumber")
    private var mFiscalNumber: String? = null

    // output xml tag ("REVOKED")
    @Transient
    private var mRevoked: Boolean? = null

    // output xml tag ("STORNED")
    @Transient
    private var mDeleted: Boolean? = null

    // output xml tag ("OFFLINE")
    @SerializedName("offline")
    private var mOffline: Boolean = false

    // output xml tag ("PREVDOCHASH")
    @SerializedName("checkNumber")
    private var mPreviousDocumentHash: String? = null

    // output xml tag ("TESTING")
    @SerializedName("test")
    private var mTest: Boolean? = null


    private fun updateDocumentType(){
        try {
            _documentType = getDocumentType()
        }
        catch (ignoredException: Exception){
        }
    }

    private fun updateDateTime(){
        if(mDate.isNotEmpty() && mTime.isNotEmpty()){
            val localDateTime = LocalDateTime.parse(mDate+mTime, DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"))
            _dateTime = localDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy"))
        }
    }

    private fun updateReceiptLink()
    {
        if(mDate.isEmpty()) return
        val localDate = LocalDate.parse(mDate, DateTimeFormatter.ofPattern("ddMMyyyy"))
        val date = localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
        _receiptLink = "https://cabinet.tax.gov.ua/cashregs/check?id=$mFiscalNumber&fn=$mRegistrarId&date=$date"
    }


    override fun setInternalDocumentType(internalDocumentType: InternalDocumentType?) {
        mInternalDocumentType = internalDocumentType
        updateDocumentType()
    }

    override fun getInternalDocumentType(): InternalDocumentType? {
        return mInternalDocumentType
    }

    override fun setInternalDocumentSubType(internalDocumentSubType: InternalDocumentSubType?) {
        mInternalDocumentSubType = internalDocumentSubType
        updateDocumentType()
    }

    override fun getInternalDocumentSubType(): InternalDocumentSubType? {
        return mInternalDocumentSubType
    }

    override fun getUid(): String {
        return mUid
    }

    override fun setUid(uid: String) {
        mUid = uid
    }

    override fun setSellerId(sellerId: String) {
        mSellerId = sellerId
    }

    override fun getSellerId(): String {
        return mSellerId
    }

    override fun setVatNumber(vatNumber: String?) {
        mVatNumber = vatNumber
    }

    override fun getVatNumber(): String? {
        return mVatNumber
    }

    override fun setCompanyName(companyName: String) {
        mCompanyName = companyName
    }

    override fun getCompanyName(): String {
        return mCompanyName
    }

    override fun setPointName(pointName: String) {
        mPointName = pointName
    }

    override fun getPointName(): String {
        return mPointName
    }

    override fun setPointAddress(pointAddress: String) {
        mPointAddress = pointAddress
    }

    override fun getPointAddress(): String {
        return mPointAddress
    }

    override fun setDate(date: String) {
        mDate = date
        updateDateTime()
        updateReceiptLink()
    }

    override fun getDate(): String {
        return mDate
    }

    override fun setTime(time: String) {
        mTime = time
        updateDateTime()
    }

    override fun getTime(): String {
        return mTime
    }

    override fun setDocumentNumber(documentNumber: Long) {
        mDocumentNumber = documentNumber
    }

    override fun getDocumentNumber(): Long {
        return mDocumentNumber
    }

    override fun setRegistrarLocalNumber(registrarLocalNumber: Long) {
        mRegistrarLocalNumber = registrarLocalNumber
    }

    override fun getRegistrarLocalNumber(): Long {
        return mRegistrarLocalNumber
    }

    override fun setRegistrarId(registrarId: Long) {
        mRegistrarId = registrarId
        updateReceiptLink()
    }

    override fun getRegistrarId(): Long {
        return mRegistrarId
    }

    override fun setFiscalNumberForReturn(fiscalNumberForReturn: String?) {
        mFiscalNumberForReturn = fiscalNumberForReturn
    }

    override fun getFiscalNumberForReturn(): String? {
        return mFiscalNumberForReturn
    }

    override fun setFiscalNumberForCancel(fiscalNumberForCancel: String?) {
        mFiscalNumberForDelete = fiscalNumberForCancel
    }

    override fun getFiscalNumberForCancel(): String? {
        return mFiscalNumberForDelete
    }

    override fun setRevokeLastOnlineDocument(revokeLastOnlineDocument: Boolean?) {
        mRevokeLastOnlineDocument = revokeLastOnlineDocument
    }

    override fun isRevokeLastOnlineDocument(): Boolean? {
        return mRevokeLastOnlineDocument
    }

    override fun setCashierName(cashierName: String?) {
        mCashierName = cashierName
    }

    override fun getCashierName(): String? {
        return mCashierName
    }

    override fun setLogoUrl(logoUrl: String?) {
        mLogoUrl = logoUrl
    }

    override fun getLogoUrl(): String? {
        return mLogoUrl
    }

    override fun setComment(comment: String?) {
        mComment = comment
    }

    override fun getComment(): String? {
        return mComment
    }

    override fun setVersion(version: Int) {
        mVersion = version
    }

    override fun getVersion(): Int {
        return mVersion
    }

    override fun setFiscalNumber(fiscalNumber: String?) {
        mFiscalNumber = fiscalNumber
        updateReceiptLink()
    }

    override fun getFiscalNumber(): String? {
        return mFiscalNumber
    }

    override fun setRevoked(revoked: Boolean?) {
        mRevoked = revoked
    }

    override fun isRevoked(): Boolean? {
        return mRevoked
    }

    override fun setCanceled(canceled: Boolean?) {
        mDeleted = canceled
    }

    override fun isCanceled(): Boolean? {
        return mDeleted
    }

    override fun setOffline(offline: Boolean?) {
        mOffline = offline ?: false
    }

    override fun isOffline(): Boolean? {
        return mOffline
    }

    override fun setPreviousDocumentHash(previousDocumentHash: String?) {
        mPreviousDocumentHash = previousDocumentHash
    }

    override fun getPreviousDocumentHash(): String? {
        return mPreviousDocumentHash
    }

    override fun setTest(test: Boolean?) {
        mTest = test
    }

    override fun isTest(): Boolean? {
        return mTest
    }
}
