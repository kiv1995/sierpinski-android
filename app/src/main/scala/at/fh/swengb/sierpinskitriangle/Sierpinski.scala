package at.fh.swengb.sierpinskitriangle

import android.content.Context
import android.graphics.{Canvas, Color, Paint, Path}
import android.util.AttributeSet
import android.view.View

/**
  * Created by Kevin on 13.12.2016.
  */
class Sierpinski(val context: Context, val attrs: AttributeSet) extends View(context,attrs)
{
  val paint = new Paint()
  val depth = 7

  override protected def onDraw(canvas: Canvas)
  {
    super.onDraw(canvas)
    val paint=new Paint();
    paint.setColor(Color.rgb(255, 153, 51));
    paint.setStrokeWidth(10);
    val startx = 0
    val starty = 10
    val stopx = canvas.getWidth
    val stopy = 10
    canvas.drawLine(startx,starty,stopx,stopy,paint)
    val startx1 = 0
    val starty1 = 10
    val stopx1 = canvas.getWidth/2
    val stopy1 = Math.sqrt(stopx1 * stopx1 - stopx1/2 * stopx1/2).toFloat +10
    canvas.drawLine(startx1,starty1,stopx1,stopy1,paint)
    val startx2 = canvas.getWidth
    val starty2 = 0+10
    val stopx2 = canvas.getWidth/2
    val stopy2 = Math.sqrt(stopx1 * stopx1 - stopx1/2 * stopx1/2).toFloat +10
    canvas.drawLine(startx2,starty2,stopx2,stopy2,paint)
  }



}
