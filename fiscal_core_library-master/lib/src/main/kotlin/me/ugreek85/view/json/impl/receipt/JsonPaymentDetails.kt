package me.ugreek85.view.json.impl.receipt

import com.google.gson.annotations.SerializedName
import me.ugreek85.document.receipt.IPaymentDetails

class JsonPaymentDetails : IPaymentDetails {

    @SerializedName("paymentSystemName")
    private var mPaymentSystemName: String? = null

    @SerializedName("paymentProvider")
    private var mPaymentProvider: String? = null

    @SerializedName("transactionId")
    private var mTransactionId: String? = null

    @SerializedName("transactionDateTime")
    private var mTransactionDateTime: String? = null

    @SerializedName("receiptNumber")
    private var mReceiptNumber: String? = null

    @SerializedName("deviceId")
    private var mDeviceId: String? = null

    @SerializedName("personalAccountNumber")
    private var mPersonalAccountNumber: String? = null

    @SerializedName("authCode")
    private var mAuthCode: String? = null

    override fun getPaymentSystemName(): String? {
        return mPaymentSystemName
    }

    override fun setPaymentSystemName(paymentSystemName: String?) {
        mPaymentSystemName = paymentSystemName
    }

    override fun getPaymentProvider(): String? {
        return mPaymentProvider
    }

    override fun setPaymentProvider(paymentProvider: String?) {
        mPaymentProvider = paymentProvider
    }

    override fun getTransactionId(): String? {
        return mTransactionId
    }

    override fun setTransactionId(transactionId: String?) {
        mTransactionId = transactionId
    }

    override fun getTransactionDateTime(): String? {
        return mTransactionDateTime
    }

    override fun setTransactionDateTime(transactionDateTime: String?) {
        mTransactionDateTime = transactionDateTime
    }

    override fun getReceiptNumber(): String? {
        return mReceiptNumber
    }

    override fun setReceiptNumber(receiptNumber: String?) {
        mReceiptNumber = receiptNumber
    }

    override fun getDeviceId(): String? {
        return mDeviceId
    }

    override fun setDeviceId(deviceId: String?) {
        mDeviceId = deviceId
    }

    override fun getPersonalAccountNumber(): String? {
        return mPersonalAccountNumber
    }

    override fun setPersonalAccountNumber(personalAccountNumber: String?) {
        mPersonalAccountNumber = personalAccountNumber
    }

    override fun getAuthCode(): String? {
        return mAuthCode
    }

    override fun setAuthCode(authCode: String?) {
        mAuthCode = authCode
    }
}