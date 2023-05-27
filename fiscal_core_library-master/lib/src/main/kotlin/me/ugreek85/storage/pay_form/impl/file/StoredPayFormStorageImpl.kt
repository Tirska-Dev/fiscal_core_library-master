package me.ugreek85.storage.pay_form.impl.file

import me.ugreek85.extentions.mkdirIfNotExists
import me.ugreek85.storage.common.IdItemAbility
import me.ugreek85.storage.common.SerializeUtil
import me.ugreek85.storage.pay_form.IStoredPayForm
import me.ugreek85.storage.pay_form.IStoredPayFormStorage
import java.io.File

class StoredPayFormStorageImpl(workingDirectory: File) :
    IStoredPayFormStorage,
    IdItemAbility<IStoredPayForm>(
        File(workingDirectory, "pay-forms").apply{ mkdirIfNotExists() },
        IStoredPayFormStorage::class.java
    ) {

    override fun loader(file: File) = SerializeUtil.load<StoredPayFormImpl>(file)
    override fun newInstance(): IStoredPayForm {
        return StoredPayFormImpl()
    }

    override fun getPaymentForms(): Array<IStoredPayForm> {
        return getRecords().values.toTypedArray()
    }

    override fun addPaymentForm(paymentForm: IStoredPayForm): Long {
        return addRecord(paymentForm)
    }

    override fun updatePaymentForm(paymentForm: IStoredPayForm): Boolean {
        return updateRecord(paymentForm)
    }

    override fun deletePaymentForm(id: Long): Boolean {
        return deleteRecord(id)
    }

    override fun getPaymentForm(id: Long): IStoredPayForm? {
        return getRecord(id)
    }

    override fun getPaymentFormByCode(code: String): IStoredPayForm? {
        return search { it.getCode() == code }
    }
}