package com.example.paggingapp.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class LineView(
    context: Context
): View(context) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //canvas.drawLine(0f, 0f, width / 2f, height / 2f, paint)

        canvas.drawLine(0f, height / 2f, width / 2f, height / 2f, paint)
    }

    fun updateColor() {
        paint.color = Color.BLACK
        invalidate()
    }

    fun updateColorAndSize() {
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 15f
        paint.strokeCap = Paint.Cap.BUTT

        postInvalidate()
    }
}