package me.ugreek85.storage.pay_form.impl.file

import me.ugreek85.storage.TestData
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class StoredPayFormStorageImplTest {

    var storage = StoredPayFormStorageImpl(TestData.rootDirectory)

    @BeforeEach
    fun init()
    {
        TestData.rootDirectory.deleteRecursively()
        storage = StoredPayFormStorageImpl(TestData.rootDirectory)
    }

    @Test
    fun newInstance() {

        assertDoesNotThrow {
            assertNotNull(storage.newInstance())
        }
    }

    @Test
    fun getPaymentForms() {

        addPaymentForm()

        assertDoesNotThrow {

            assertEquals(4, storage.getPaymentForms().size)
        }
    }

    @Test
    fun addPaymentForm() {

        assertDoesNotThrow {
            var code: Int = 0
            assertTrue(storage.addPaymentForm(storage.newInstance().apply{
                setCode(code++.toString())
                setName("Готівка")
            }) > 0)

            assertTrue(storage.addPaymentForm(storage.newInstance().apply{
                setCode(code++.toString())
                setName("Банківська картка")
            }) > 0)

            assertTrue(storage.addPaymentForm(storage.newInstance().apply{
                setCode(code++.toString())
                setName("Попередня оплата")
            }) > 0)

            assertTrue(storage.addPaymentForm(storage.newInstance().apply{
                setCode(code++.toString())
                setName("Кредит")
            }) > 0)
        }
    }

    @Test
    fun updatePaymentForm() {

        addPaymentForm()

        assertDoesNotThrow {

            assertTrue(storage.updatePaymentForm(storage.getPaymentForm(1)!!.apply {
                setName("Updated")
            }))

            assertEquals("Updated", storage.getPaymentForm(1)!!.getName())
        }
    }

    @Test
    fun deletePaymentForm() {

        addPaymentForm()

        assertDoesNotThrow {

            assertTrue(storage.deletePaymentForm(4))
            assertEquals(3, storage.getPaymentForms().size)
        }
    }

    @Test
    fun getPaymentForm() {

        addPaymentForm()

        assertDoesNotThrow {
            assertNotNull(storage.getPaymentForm(4))
        }
    }

    @Test
    fun getPaymentFormByCode() {

        addPaymentForm()

        assertDoesNotThrow {
            assertNotNull(storage.getPaymentFormByCode("0"))
            assertEquals("Готівка", storage.getPaymentFormByCode("0")!!.getName())
        }
    }
}