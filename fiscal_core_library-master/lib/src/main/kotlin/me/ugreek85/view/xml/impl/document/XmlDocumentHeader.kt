package me.ugreek85.view.xml.impl.document

import me.ugreek85.document.common.IDocumentHeader
import me.ugreek85.document.common.InternalDocumentSubType
import me.ugreek85.document.common.InternalDocumentType
import org.simpleframework.xml.Element

class XmlDocumentHeader : IDocumentHeader {

    @field:Element(name="DOCTYPE", required = false)
    private var mInternalDocumentType: InternalDocumentType? = null

    @field:Element(name="DOCSUBTYPE", required = false)
    private var mInternalDocumentSubType: InternalDocumentSubType? = null

    @field:Element(name="UID")
    private var mUid: String = ""

    @field:Element(name="TIN")
    private var mSellerId: String = ""

    @field:Element(name="IPN", required = false)
    private var mVatNumber: String? = null

    @field:Element(name="ORGNM")
    private var mCompanyName: String = ""

    @field:Element(name="POINTNM")
    private var mPointName: String = ""

    @field:Element(name="POINTADDR")
    private var mPointAddress: String = ""

    @field:Element(name="ORDERDATE")
    private var mDate: String = ""

    @field:Element(name="ORDERTIME")
    private var mTime: String = ""

    @field:Element(name="ORDERNUM")
    private var mDocumentNumber: Long = 0L

    @field:Element(name="CASHDESKNUM")
    private var mRegistrarLocalNumber: Long = 0L

    @field:Element(name="CASHREGISTERNUM")
    private var mRegistrarId: Long = 0L

    @field:Element(name="ORDERRETNUM", required = false)
    private var mFiscalNumberForReturn: String? = null

    @field:Element(name="ORDERSTORNUM", required = false)
    private var mFiscalNumberForDelete: String? = null

    @field:Element(name="REVOKELASTONLINEDOC", required = false)
    private var mRevokeLastOnlineDocument: Boolean? = null

    @field:Element(name="CASHIER", required = false)
    private var mCashierName: String? = null

    @field:Element(name="LOGOURL", required = false)
    private var mLogoUrl: String? = null

    @field:Element(name="COMMENT", required = false)
    private var mComment: String? = null

    @field:Element(name="VER")
    private var mVersion: Int = 0

    @field:Element(name="ORDERTAXNUM", required = false)
    private var mFiscalNumber: String? = null

    @field:Element(name="REVOKED", required = false)
    private var mRevoked: Boolean? = null

    @field:Element(name="STORNED", required = false)
    private var mDeleted: Boolean? = null

    @field:Element(name="OFFLINE", required = false)
    private var mOffline: Boolean? = null

    @field:Element(name="PREVDOCHASH", required = false)
    private var mPreviousDocumentHash: String? = null

    @field:Element(name="TESTING", required = false)
    private var mTest: Boolean? = null

    override fun setInternalDocumentType(internalDocumentType: InternalDocumentType?) {
        mInternalDocumentType = internalDocumentType
    }

    override fun getInternalDocumentType(): InternalDocumentType? {
        return mInternalDocumentType
    }

    override fun setInternalDocumentSubType(internalDocumentSubType: InternalDocumentSubType?) {
        mInternalDocumentSubType = internalDocumentSubType
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
    }

    override fun getDate(): String {
        return mDate
    }

    override fun setTime(time: String) {
        mTime = time
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
        mOffline = offline
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

    override fun toString(): String {
        return "XmlDocumentHeader(mInternalDocumentType=$mInternalDocumentType, mInternalDocumentSubType=$mInternalDocumentSubType, mUid='$mUid', mSellerId='$mSellerId', mVatNumber=$mVatNumber, mCompanyName='$mCompanyName', mPointName='$mPointName', mPointAddress='$mPointAddress', mDate='$mDate', mTime='$mTime', mDocumentNumber=$mDocumentNumber, mRegistrarLocalNumber=$mRegistrarLocalNumber, mRegistrarId=$mRegistrarId, mFiscalNumberForReturn=$mFiscalNumberForReturn, mFiscalNumberForDelete=$mFiscalNumberForDelete, mRevokeLastOnlineDocument=$mRevokeLastOnlineDocument, mCashierName='$mCashierName', mComment=$mComment, mVersion=$mVersion, mFiscalNumber=$mFiscalNumber, mRevoked=$mRevoked, mDeleted=$mDeleted, mOffline=$mOffline, mPreviousDocumentHash=$mPreviousDocumentHash, mTest=$mTest)"
    }
}
