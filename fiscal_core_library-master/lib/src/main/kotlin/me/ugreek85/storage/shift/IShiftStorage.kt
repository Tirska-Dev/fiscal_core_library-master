package me.ugreek85.storage.shift

interface IShiftStorage {

    fun newInstance(): IShift
    fun update(shift: IShift)

    fun getLast(registrarId: Long): IShift?
    fun getAll(registrarId: Long): List<IShift>

    fun getById(registrarId: Long, shiftId: String): IShift?

//    fun removeAllShiftsOlderThan3Years(registrarId: Long)
//    fun removeAllShiftsOlderThan3Years()
}