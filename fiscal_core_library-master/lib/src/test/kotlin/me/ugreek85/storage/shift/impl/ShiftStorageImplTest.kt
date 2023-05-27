package me.ugreek85.storage.shift.impl

import me.ugreek85.storage.TestData
import me.ugreek85.storage.shift.IShift
import me.ugreek85.storage.shift.impl.file.ShiftStorageImpl
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ShiftStorageImplTest {

    private val shiftStorage = ShiftStorageImpl(TestData.rootDirectory)

    @Test
    fun newInstance() {

        assertDoesNotThrow {
            assertNotNull(shiftStorage.newInstance())
        }
    }

    @Test
    fun update() {

        lateinit var shift: IShift
        assertDoesNotThrow {
            shift = shiftStorage.newInstance()
        }

        shift.setRegistrarId(TestData.registrarId)
        shift.setShiftId(TestData.shiftId)
        shift.setOpenedAt(TestData.dateCreation)

        assertDoesNotThrow{
            shiftStorage.update(shift)
        }

    }

    @Test
    fun getLast() {

        update()

        lateinit var shift: IShift
        assertDoesNotThrow {
            shift = shiftStorage.getLast(TestData.registrarId)!!
        }

        assertEquals(TestData.registrarId, shift.getRegistrarId())
        assertEquals(TestData.shiftId, shift.getShiftId())
        assertEquals(TestData.dateCreation, shift.getOpenedAt())
    }

    @Test
    fun getAll() {

        update()

        lateinit var shifts: List<IShift>
        assertDoesNotThrow {
            shifts = shiftStorage.getAll(TestData.registrarId)
        }

        assertEquals(1, shifts.size)

        val shift = shifts.first()
        assertEquals(TestData.registrarId, shift.getRegistrarId())
        assertEquals(TestData.shiftId, shift.getShiftId())
        assertEquals(TestData.dateCreation, shift.getOpenedAt())
    }

    @Test
    fun getById() {

        update()

        lateinit var shift: IShift
        assertDoesNotThrow {
            shift = shiftStorage.getById(TestData.registrarId, TestData.shiftId)!!
        }

        assertEquals(TestData.registrarId, shift.getRegistrarId())
        assertEquals(TestData.shiftId, shift.getShiftId())
        assertEquals(TestData.dateCreation, shift.getOpenedAt())

        assertNull(shiftStorage.getById(TestData.registrarId, TestData.shiftIdNotFound))
    }
}