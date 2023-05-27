package me.ugreek85.storage.common

import me.ugreek85.extentions.sortByTimeCreation
import me.ugreek85.storage.shift.ShiftIndex
import java.io.File
import java.util.regex.Pattern

abstract class PathAndShiftAbility(
    workingDirectory: File
) : PathAbility(workingDirectory){

    private val shiftIdRegexValidator = Pattern.compile("\\d+|(\\d+\\.\\d+\\.\\d+)")
    private val shiftIndexRegexValidator = Pattern.compile("\\d{14}")

    private fun getShiftsIndexes(registrarId: Long): Array<File>
    {
        val shiftsIndexes = getRootPathForShiftsIndexes(registrarId).listFiles { file -> file.isFile && file.length() > 0 && isValidShiftIndex(file.name) } ?: emptyArray()
        return shiftsIndexes.asSequence().sortedBy { it.name }.toList().toTypedArray()
    }


    fun getShifts(registrarId: Long): Array<File>
    {
        val shifts = getRootPathForRegistrar(registrarId).listFiles { file -> file.isDirectory && isValidShiftId(file.name) } ?: emptyArray()
        shifts.sortByTimeCreation()
        return shifts
    }

    fun searchShift(shifts: Array<File>, shiftId: String): File?
    {
        if(shifts.isEmpty())  return null

        return if(shifts.last().name == shiftId) shifts.last()
        else {
            shifts.find { it.name == shiftId }
        }
    }

    fun getLastShift(registrarId: Long): File? {
        val shiftsIndexes = getShiftsIndexes(registrarId)
        if(shiftsIndexes.isEmpty()) return null
        val shiftIndex = SerializeUtil.load<ShiftIndex>(shiftsIndexes.last())
        return getRootPathForShift(registrarId, shiftIndex.shiftId)
    }

    private fun isValidShiftId(shiftId: String): Boolean {
        return shiftIdRegexValidator.matcher(shiftId).matches()
    }

    private fun isValidShiftIndex(shiftId: String): Boolean {
        return shiftIdRegexValidator.matcher(shiftId).matches()
    }
}