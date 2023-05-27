package me.ugreek85.storage.registrar_state.impl.file

import me.ugreek85.extentions.mkdirIfNotExists
import me.ugreek85.extentions.mkdirsIfNotExists
import me.ugreek85.storage.TestData
import me.ugreek85.storage.document_info.impl.DocumentInfoStorageImplTest
import me.ugreek85.storage.document_info.impl.file.DocumentInfoStorageImpl
import me.ugreek85.storage.registrar_state.IRegistrarState
import me.ugreek85.storage.registrar_state.IRegistrarStateStorage
import me.ugreek85.storage.stored_document.impl.file.OnlineStoredDocumentStorageImpl
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File
import java.util.*

internal class RegistrarStateStorageImplTest {


    private val registrarStateStorage = RegistrarStateStorageImpl(TestData.rootDirectory)

    @Test
    fun newInstance()
    {
        assertDoesNotThrow{

            val state = registrarStateStorage.newInstance()
            assertNotNull(state)
        }

    }

    @Test
    fun get() {

        update()

        lateinit var state: IRegistrarState
        assertDoesNotThrow {
            state = registrarStateStorage.get(TestData.registrarId)!!
        }

        assertEquals(TestData.registrarId, state.getRegistrarId())
        assertEquals(true, state.isOfflineSupported())
        assertEquals(TestData.offlineSeed, state.getOfflineState().getSeed())
        assertEquals(TestData.offlineSessionId, state.getOfflineState().getSessionId())
        assertNull(registrarStateStorage.get(123456789))
    }

    @Test
    fun update() {

        val state = registrarStateStorage.newInstance()
        assertNotNull(state)
        state.setRegistrarId(TestData.registrarId)
        state.setOfflineSupported(true)
        state.getOfflineState().setSeed(TestData.offlineSeed)
        state.getOfflineState().setSessionId(TestData.offlineSessionId)

        assertDoesNotThrow{
            registrarStateStorage.update(state)
        }
    }
}