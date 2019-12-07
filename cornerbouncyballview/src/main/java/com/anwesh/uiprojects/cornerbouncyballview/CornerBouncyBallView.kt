package com.anwesh.uiprojects.cornerbouncyballview

/**
 * Created by anweshmishra on 07/12/19.
 */

import android.view.View
import android.view.MotionEvent
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Color
import android.app.Activity
import android.content.Context

val nodes : Int = 5
val balls : Int = 4
val scGap : Float = 0.02f
val strokeFactor : Int = 90
val sizeFactor : Float = 2.9f
val foreColor : Int = Color.parseColor("#009688")
val backColor : Int = Color.parseColor("#BDBDBD")
val rFactor : Float = 3.2f

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()
fun Float.cosify() : Float = 1f - Math.sin(Math.PI / 2 + (this) * Math.PI / 2).toFloat()

fun Canvas.drawCornerBouncyBall(i : Int, scale : Float, size : Float, paint : Paint) {
    val r : Float = size / rFactor
    val sf : Float = scale.sinify()
    val sc : Float = scale.divideScale(1, 2).cosify()
    save()
    rotate(90f * i)
    drawLine(0f, 0f, size * sf, size * sf, paint)
    drawCircle(size * sc, size * sc, r, paint)
    restore()
}

fun Canvas.drawCornerBouncyBalls(scale : Float, size : Float, paint : Paint) {
    for (j in 0..(balls - 1)) {
        save()
        rotate(90f * j)
        drawCornerBouncyBall(j, scale, size, paint)
        restore()
    }
}

fun Canvas.drawCBBNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = h / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.color = foreColor
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    paint.strokeCap = Paint.Cap.ROUND
    save()
    translate(w / 2, gap * (i + 1))
    drawCornerBouncyBalls(scale, size, paint)
    restore()
}


class CornerBouncyBallView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}