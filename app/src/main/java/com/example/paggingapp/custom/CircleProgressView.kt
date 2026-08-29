package com.example.paggingapp.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CircleProgressView(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {
    private val backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 20f
        color = Color.LTGRAY
        strokeCap = Paint.Cap.ROUND
    }

    private val progressPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 20f
        color = Color.BLUE
        strokeCap = Paint.Cap.ROUND
    }

    private var progress = 0f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2f
        val centerY = height / 2f

        val radius = minOf(width, height) / 2f - 20f

        canvas.drawCircle(
            centerX,
            centerY,
            radius,
            backgroundPaint
        )

        val rect = RectF(
            centerX - radius,
            centerY - radius,
            centerX + radius,
            centerY + radius
        )

        canvas.drawArc(
            rect,
            -90f,
            progress * 360f,
            false,
            progressPaint
        )
    }

    fun setProgress(value: Float) {
        progress = value.coerceIn(0f, 1f)
        invalidate()
    }
}