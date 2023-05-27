package me.ugreek85.document.receipt

import me.ugreek85.document.common.IRow

interface IReceiptProduct : IRow {

    fun setCode(code: String?)
    fun getCode(): String?

    fun setBarCode(barCode: String?)
    fun getBarCode(): String?

    fun setNationalCode(nationalCode: String?)
    fun getNationalCode(): String?

    fun setName(name: String?)
    fun getName(): String?

    fun setDescription(description: String?)
    fun getDescription(): String?

    fun setUnitCode(unitCode: String?)
    fun getUnitCode(): String?

    fun setUnitName(unitName: String?)
    fun getUnitName(): String?

    fun setAmount(amount: Double?)
    fun getAmount(): Double?

    fun setPrice(price: Double?)
    fun getPrice(): Double?

    fun setTaxRateLetter(taxRateLetter: String?)
    fun getTaxRateLetter(): String?

    fun setCost(cost: Double?)
    fun getCost(): Double?

    fun setComment(comment: String?)
    fun getComment(): String?

    fun getPawnMoneyDirection(): PawnMoneyDirection?
    fun setPawnMoneyDirection(pawnMoneyDirection: PawnMoneyDirection?)

    fun setDiscountSum(discountSum: Double?)
    fun getDiscountSum(): Double?

    fun setExciseLabels(exciseLabels: List<IExciseLabel>?)
    fun getExciseLabels(): List<IExciseLabel>?
}