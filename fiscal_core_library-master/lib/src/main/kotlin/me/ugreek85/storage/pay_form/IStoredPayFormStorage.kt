package me.ugreek85.storage.pay_form

interface IStoredPayFormStorage {

    fun newInstance(): IStoredPayForm
    fun getPaymentForms(): Array<IStoredPayForm>
    fun addPaymentForm(paymentForm: IStoredPayForm): Long
    fun updatePaymentForm(paymentForm: IStoredPayForm): Boolean
    fun deletePaymentForm(id: Long): Boolean
    fun getPaymentForm(id: Long): IStoredPayForm?
    fun getPaymentFormByCode(code: String): IStoredPayForm?
}