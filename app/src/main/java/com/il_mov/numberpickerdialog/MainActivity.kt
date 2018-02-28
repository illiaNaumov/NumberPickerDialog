package com.il_mov.numberpickerdialog

import android.content.res.Resources
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.NumberPicker
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_number_picker.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setNumberPickerTextColor(numberPicker, Color.parseColor("#58b947"))
        setDividerColor(numberPicker, Color.parseColor("#b7b7b7"))
        numberPicker.maxValue = 10

        val bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)
        bottomSheetBehavior.isHideable
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        showPickerButtonView.setOnClickListener {
            toggleBottomSheet(bottomSheetBehavior)
        }
    }

    private fun toggleBottomSheet(bottomSheetBehavior: BottomSheetBehavior<out View>) {
        if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        } else {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    private fun setNumberPickerTextColor(numberPicker: NumberPicker, color: Int): Boolean {
        val count = numberPicker.childCount
        for (i in 0 until count) {
            val child = numberPicker.getChildAt(i)
            if (child is EditText) {
                try {
                    val selectorWheelPaintField = numberPicker.javaClass
                            .getDeclaredField("mSelectorWheelPaint")
                    selectorWheelPaintField.isAccessible = true
                    (selectorWheelPaintField.get(numberPicker) as Paint).color = color
                    child.setTextColor(color)
                    numberPicker.invalidate()
                    return true
                } catch (e: NoSuchFieldException) {
                    Log.w("setNumberPickrTextColor", e)
                } catch (e: IllegalAccessException) {
                    Log.w("setNumberPickrTextColor", e)
                } catch (e: IllegalArgumentException) {
                    Log.w("setNumberPickrTextColor", e)
                }
            }
        }
        return false
    }

    private fun setDividerColor(picker: NumberPicker, color: Int) {

        val pickerFields = NumberPicker::class.java.declaredFields
        for (pf in pickerFields) {
            if (pf.name == "mSelectionDivider") {
                pf.isAccessible = true
                try {
                    val colorDrawable = ColorDrawable(color)
                    pf.set(picker, colorDrawable)
                } catch (e: IllegalArgumentException) {
                    e.printStackTrace()
                } catch (e: Resources.NotFoundException) {
                    e.printStackTrace()
                } catch (e: IllegalAccessException) {
                    e.printStackTrace()
                }

                break
            }
        }
    }
}