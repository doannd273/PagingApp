package com.example.paggingapp.custom


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.paggingapp.R

class CustomTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private var strokeColor = Color.BLACK
    private var isSquare = false

    // 1. Khai báo Paint để vẽ viền
    private val strokePaint = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = 8f // Độ dày viền (px)
        isAntiAlias = true
    }

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomTextView,
            0, 0
        ).apply {
            try {
                strokeColor = getColor(R.styleable.CustomTextView_strokeColor, Color.BLACK)
                isSquare = getBoolean(R.styleable.CustomTextView_isSquare, false)
            } finally {
                recycle()
            }
        }

        // 2. Cập nhật màu từ XML vào Paint
        strokePaint.color = strokeColor
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        // Nếu chọn isSquare = true, ép chiều cao bằng chiều rộng
        if (isSquare) {
            val size = Math.max(measuredWidth, measuredHeight)
            setMeasuredDimension(size, size)
        }
    }

    override fun onDraw(canvas: Canvas) {
        // 3. Tiến hành vẽ viền màu strokeColor lên Canvas
        val strokeWidth = strokePaint.strokeWidth
        canvas.drawRect(
            strokeWidth / 2,
            strokeWidth / 2,
            width.toFloat() - strokeWidth / 2,
            height.toFloat() - strokeWidth / 2,
            strokePaint
        )

        // Sau đó mới vẽ chữ lên trên
        super.onDraw(canvas)
    }
}