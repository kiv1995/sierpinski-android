package at.fh.swengb.sierpinskitriangle

import android.content.Context
import android.graphics.{Canvas, Paint, Path}
import android.view.View

/**
  * Created by Kevin on 13.12.2016.
  */
class Sierpinski(val context: Context) extends View(context)
{
  override protected def onDraw(canvas: Canvas): Unit = {
    super.onDraw(canvas)
    val x = canvas.getWidth
    val y = Math.sqrt(x * x - x / 2 * x / 2).toFloat

  }

}
