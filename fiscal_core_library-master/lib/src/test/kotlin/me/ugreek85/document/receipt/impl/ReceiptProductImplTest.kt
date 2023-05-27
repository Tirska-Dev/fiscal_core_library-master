package me.ugreek85.document.receipt.impl

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ReceiptProductImplTest {

    private val mProduct = ReceiptProductImpl()

    @Test
    fun setCode() {
        val code = "Test Code"
        mProduct.setCode(code)
        assertEquals(mProduct.getCode(), code)
    }

    @Test
    fun setBarCode() {
        val barCode = "Test Bar Code"
        mProduct.setBarCode(barCode)
        assertEquals(mProduct.getBarCode(), barCode)
    }

    @Test
    fun setNationalCode() {

        val nationalCode = "Test National Code"
        mProduct.setNationalCode(nationalCode)
        assertEquals(mProduct.getNationalCode(), nationalCode)
    }

    @Test
    fun setName() {
        val name = "Test Name"
        mProduct.setName(name)
        assertEquals(mProduct.getName(), name)
    }


    @Test
    fun setDescription() {
        val description = "Test Description"
        mProduct.setDescription(description)
        assertEquals(mProduct.getDescription(), description)
    }

    @Test
    fun setUnitCode() {
        val unitCode = "Test Unit Code"
        mProduct.setUnitCode(unitCode)
        assertEquals(mProduct.getUnitCode(), unitCode)
    }

    @Test
    fun setUnitName() {
        val unitName = "Test Unint Name"
        mProduct.setUnitName(unitName)
        assertEquals(mProduct.getUnitName(), unitName)
    }


    @Test
    fun setAmount() {
        val amount = 342.3
        mProduct.setAmount(amount)
        assertEquals(mProduct.getAmount(), amount)
    }


    @Test
    fun setPrice() {
        val price = 3234.3
        mProduct.setPrice(price)
        assertEquals(mProduct.getPrice(), price)
    }


    @Test
    fun setCost() {
        val cost = 23409834.4
        mProduct.setCost(cost)
        assertEquals(mProduct.getCost(), cost)
    }

    @Test
    fun setDiscountSum() {
        val discountSum = 234.4
        mProduct.setDiscountSum(discountSum)
        assertEquals(mProduct.getDiscountSum(), discountSum)
    }

    @Test
    fun setComment() {
        val comment = "Test Comment"
        mProduct.setComment(comment)
        assertEquals(mProduct.getComment(), comment)
    }

}