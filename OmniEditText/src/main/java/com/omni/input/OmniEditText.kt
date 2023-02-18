package com.omni.input

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class OmniEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet?
) : AppCompatEditText(context, attrs) {

    private var maxValue: Float? = null
    private var errorMessage: String? = null

    init {
        // Set the padding to 10dp
        val padding = resources.getDimensionPixelSize(R.dimen.p1)
        setPadding(padding, padding, padding, padding)
        setBackgroundResource(R.drawable.default_background)

        attrs?.let {
            val a = context.obtainStyledAttributes(attrs, R.styleable.OmniEditText)
            maxValue = a.getFloat(R.styleable.OmniEditText_omniMaxValue, Float.MAX_VALUE)
            errorMessage = a.getString(R.styleable.OmniEditText_omniErrorMessage)
            a.recycle()
        }

        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                // If a maximum value is set, validate the input and show an error if necessary
                if (maxValue != null) {
                    val input = s.toString().toFloatOrNull()
                    if (input != null && input > maxValue!!) {
                        setError(errorMessage)
                    } else {
                        clearError()
                    }
                }
            }
        })
    }

    // Method to show an error message and highlight the field with a red border
    private fun setError(errorMessage: String?) {
        error = errorMessage
        setBackgroundResource(R.drawable.error_background)
    }

    // Method to clear an error message
    private fun clearError() {
        error = null
        setBackgroundResource(R.drawable.default_background)
    }
}