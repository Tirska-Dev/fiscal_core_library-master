package me.ugreek85.builder

interface IBaseBuilder<BT> {
    fun build(): BT
}