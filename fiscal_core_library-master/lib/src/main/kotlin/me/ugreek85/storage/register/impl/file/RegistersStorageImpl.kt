package me.ugreek85.storage.register.impl.file

import me.ugreek85.storage.common.IDocumentAbility
import me.ugreek85.storage.common.PathAbility
import me.ugreek85.storage.register.IExtractorOfRegisters
import me.ugreek85.storage.register.IRegisterRecord
import me.ugreek85.storage.register.IRegistersStorage
import me.ugreek85.storage.shift.IShiftStorage
import java.io.File

class RegistersStorageImpl(
    workingDirectory: File,
    private val shiftStorage: IShiftStorage,
    private val extractorOfRegisters: IExtractorOfRegisters
) : IRegistersStorage, PathAbility(workingDirectory), IDocumentAbility {

    override fun add(registrarId: Long, record: IRegisterRecord) {

    }

    override fun setCanceledByFiscalNumber(registrarId: Long, fiscalNumber: String) {

    }

    override fun getAll(registrarId: Long): Map<String, Double> {
        val shift = shiftStorage.getLast(registrarId) ?: return emptyMap()
        if(shift.getClosedAt() == null) return processDocuments(registrarId, shift.getShiftId())
        return emptyMap()
    }

    override fun reset(registrarId: Long) {
    }

    private fun processDocuments(registrarId: Long, shiftId: String): Map<String, Double>
    {
        val files = getDocuments(getRootPathForShift(registrarId, shiftId))

        if(files.isEmpty()) return emptyMap()

        val registers = mutableMapOf<String, Double>()
        files.forEach {

            mergeMaps(registers, extractorOfRegisters.fromDocument(it))
        }

        return registers
    }

    private fun mergeMaps(mainMap: MutableMap<String, Double>, map: Map<String, Double>)
    {
        map.forEach { (key, value) ->
            mainMap.merge(key, value) { v1, v2 -> v1 + v2 }
        }
    }
}