package me.ugreek85.storage.shift.impl.file

import me.ugreek85.extentions.mkdirIfNotExists
import me.ugreek85.storage.common.PathAndShiftAbility
import me.ugreek85.storage.common.SerializeUtil
import me.ugreek85.storage.shift.IShift
import me.ugreek85.storage.shift.IShiftStorage
import me.ugreek85.storage.shift.ShiftIndex
import java.io.File

class ShiftStorageImpl(
    workingDirectory: File
) : IShiftStorage, PathAndShiftAbility(workingDirectory) {

    private fun getFileName() = "info"

    private fun getPathToShiftInfo(registrarId: Long, shiftId: String, createIfNotExists: Boolean = false): File
    {
        return File(getRootPathForShift(registrarId, shiftId, createIfNotExists), getFileName())
    }

    private fun loadShiftInfo(shiftDirectory: File): IShift
    {
        return SerializeUtil.load<ShiftFileImpl>(File(shiftDirectory, getFileName()))
    }

    private fun getPathToShiftIndex(registrarId: Long, indexName: String): File
    {
        return File(getRootPathForShiftsIndexes(registrarId, true), indexName)
    }

    private fun createIndexIfNotExists(registrarId: Long, indexName: String, shiftId: String){

        val indexFile = getPathToShiftIndex(registrarId, indexName)
        if(indexFile.exists()) return
        SerializeUtil.save(indexFile, ShiftIndex(shiftId))
    }

    override fun newInstance(): IShift {
        return ShiftFileImpl()
    }

    override fun update(shift: IShift) {
        SerializeUtil.save(getPathToShiftInfo(shift.getRegistrarId(), shift.getShiftId(), true), shift)
        createIndexIfNotExists(shift.getRegistrarId(), shift.getIndexName(), shift.getShiftId())
    }

    override fun getLast(registrarId: Long): IShift? {
        return loadShiftInfo(getLastShift(registrarId) ?: return null)
    }

    override fun getAll(registrarId: Long): List<IShift> {
        return getShifts(registrarId).map {
            loadShiftInfo(it)
        }
    }

    override fun getById(registrarId: Long, shiftId: String): IShift? {
        val shiftInfoFile = getPathToShiftInfo(registrarId, shiftId)
        if(shiftInfoFile.exists()) return loadShiftInfo(shiftInfoFile.parentFile)
        return null
    }

}