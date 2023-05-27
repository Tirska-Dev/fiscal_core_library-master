package me.ugreek85.mocks

import io.mockk.every
import io.mockk.mockk
import me.ugreek85.storage.registrar_state.IRegistrarState

object RegistrarStateMock {

    private val registrarState: IRegistrarState = mockk()

    fun mock(): IRegistrarState
    {
        every { registrarState.getOfflineState().getSessionId() } returns "10832"
        every { registrarState.getOfflineState().getSeed() } returns "179625192271939"
        every { registrarState.getNextDocumentNumber() } returns 10
        every { registrarState.getOfflineState().getNextDocumentNumber() } returns 9

        return registrarState
    }
}