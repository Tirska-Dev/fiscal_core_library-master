package me.ugreek85.document.common.impl

import me.ugreek85.document.common.IDocumentHeader
import me.ugreek85.document.common.InternalDocumentSubType
import me.ugreek85.document.common.InternalDocumentType

class DocumentHeaderImpl : IDocumentHeader {

    // output xml tag ("DOCTYPE")
    private var mInternalDocumentType: InternalDocumentType? = null

    // output xml tag ("DOCSUBTYPE")
    private var mInternalDocumentSubType: InternalDocumentSubType? = null

    // output xml tag ("UID")
    private var mUid: String = ""

    // output xml tag ("TIN")
    private var mSellerId: String = ""

    // output xml tag ("IPN")
    private var mVatNumber: String? = null

    // output xml tag ("ORGNM")
    private var mCompanyName: String = ""

    // output xml tag ("POINTNM")
    private var mPointName: String = ""

    // output xml tag ("POINTADDR")
    private var mPointAddress: String = ""

    // output xml tag ("ORDERDATE")
    private var mDate: String = ""

    // output xml tag ("ORDERTIME")
    private var mTime: String = ""

    // output xml tag ("ORDERNUM")
    private var mDocumentNumber: Long = 0L

    // output xml tag ("CASHDESKNUM")
    private var mRegistrarLocalNumber: Long = 0L

    // output xml tag ("CASHREGISTERNUM")
    private var mRegistrarId: Long = 0L

    // output xml tag ("ORDERRETNUM")
    private var mFiscalNumberForReturn: String? = null

    // output xml tag ("ORDERSTORNUM")
    private var mFiscalNumberForDelete: String? = null

    // output xml tag ("REVOKELASTONLINEDOC")
    private var mRevokeLastOnlineDocument: Boolean? = null

    // output xml tag ("CASHIER")
    private var mCashierName: String? = null

    // output xml tag ("LOGOURL")
    private var mLogoUrl: String? = null

    // output xml tag ("COMMENT")
    private var mComment: String? = null

    // output xml tag ("VER")
    private var mVersion: Int = 0

    // output xml tag ("ORDERTAXNUM")
    private var mFiscalNumber: String? = null

    // output xml tag ("REVOKED")
    private var mRevoked: Boolean? = null

    // output xml tag ("STORNED")
    private var mDeleted: Boolean? = null

    // output xml tag ("OFFLINE")
    private var mOffline: Boolean? = null

    // output xml tag ("PREVDOCHASH")
    private var mPreviousDocumentHash: String? = null

    // output xml tag ("TESTING")
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
}
