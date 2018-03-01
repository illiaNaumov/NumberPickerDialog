package com.il_mov.numberpickerdialog

import android.content.Context
import android.util.AttributeSet
import android.support.constraint.ConstraintLayout
import kotlinx.android.synthetic.main.dialog_number_picker.view.*


class NumberPickerBottomDialog : ConstraintLayout {

    var numberPickerDialogListener: NumberPickerDialogListener? = null

    constructor(context: Context?) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        inflate(context, R.layout.dialog_number_picker, this)

        resetTextView.setOnClickListener { performReset() }
        doneTextTitleView.setOnClickListener { performDone() }
    }

    private fun performReset() {
        numberPickerDialogListener?.onCancelClicked()
    }

    private fun performDone() {
        numberPickerDialogListener?.onDoneClicked(numberPicker.value)
    }
}