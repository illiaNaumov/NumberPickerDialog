package com.il_mov.numberpickerdialog

interface NumberPickerDialogListener {
    fun onCancelClicked()
    fun onDoneClicked(numberPicked: Int)
}