package at.fh.swengb.sierpinskitriangle

import android.content.Context
import android.graphics.{Canvas, Color, Paint, Path}
import android.text.style.LineHeightSpan
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
    val paint = new Paint();
    //line color
    paint.setColor(Color.rgb(0, 0,0));
    //line width
    //paint.setStrokeWidth(2);
    //x...line (gleichseitig)
    val width = canvas.getWidth
    val height = Math.sqrt(width * width - width / 2 * width / 2).toFloat
    val x = 0
    val y=0

    drawSierpinski(x,y,width+x,height)

    def drawTriangle(x: Float, y: Float, width:Float, height:Float): Unit =
    {
        //definition of the lines
        //from left to right
        canvas.drawLine(x,y,width+x,y,paint)
        //from left to bottom
        canvas.drawLine(x,y,x+width/2,y+height,paint)
        //from bottom to right
        canvas.drawLine(width+x,y,x+width/2,y+height,paint)
    }
    def drawSierpinski(x: Float, y:Float, width:Float, height:Float):Unit=
    {
      drawTriangle(x, y, width, height)
      if (width <1){
        return
      }
      else {
        var subHeight = height / 2
        var subWidth = width / 2
        drawSierpinski(x, y, subWidth, subHeight)
        drawSierpinski(x + subWidth / 2, y + subHeight, subWidth, subHeight)
        drawSierpinski(x + subWidth, y, subWidth, subHeight)
      }
    }
  }
}
    /*
    drawTriangle(canvas,0,0,x,0,x/2,height,paint)
    def drawTriangle(canvas: Canvas,px1: Float, py1: Float, px2: Float, py2: Float, px3:Float, py3:Float,paint: Paint)={
      canvas.drawLines(Array(px1,py1,px2,py2,px2,py2,px3,py3,px3,py3,px1,py1),paint)
      //linkes kleines Dreieck
      subDrawTriangle(canvas,7,x/2,0,(x/2)/2,height/2,3*x/4,height/2)
      //rechtes kleines Dreieck
      subDrawTriangle(canvas,7,3*x/4,0,(x/2+x/8),height/4,(x/2+(3*x/8)),height/4)
      //unteres kleines Dreieck
      subDrawTriangle(canvas,7,x/2,height/2,x/2+x/8,height/2+height/4,x/2-x/8,height/2+height/4)
    }
    def subDrawTriangle(canvas: Canvas,depth:Int,px1: Float, py1: Float, px2: Float, py2: Float, px3:Float, py3:Float):Unit= {
      if (depth >0){
        canvas.drawLines(Array(px1,py1,px2,py2,px2,py2,px3,py3,px3,py3,px1,py1),paint)
        val newDepth = depth - 1
        val subPx1 = px1 / 2
        val subPy1 = py1 / 2
        val subPx2 = px2 / 2
        val subPy2 = py2 / 2
        val subPx3 = px3 / 2
        val subPy3 = py3 / 2
        subDrawTriangle(canvas,newDepth,subPx1,subPy1,subPx2,subPy2,subPx3,subPy3)
      }
    }
  /* old version => hard coded - first triangle
    val startx = 0
    val starty = 10
    val stopx = x
    val stopy = 10
    canvas.drawLine(startx,starty,x,10,paint)
    val startx1 = 0
    val starty1 = 10
    val stopx1 = canvas.getWidth/2
    val stopy1 = Math.sqrt(stopx * stopx - stopx/2 * stopx/2).toFloat +10
    canvas.drawLine(startx1,starty1,stopx1,stopy1,paint)
    val startx2 = canvas.getWidth
    val starty2 = 0+10
    val stopx2 = canvas.getWidth/2
    val stopy2 = Math.sqrt(stopx * stopx - stopx/2 * stopx/2).toFloat +10
    canvas.drawLine(startx2,starty2,stopx2,stopy2,paint)*/
    /*
    first subTriangle
    val startx = x/2
    val starty = 10
    val stopx = (x/2)/2
    val stopy = height/2
    canvas.drawLine(startx,starty,stopx,stopy,paint)
    val startx2 = (x/2)/2
    val starty2 = height/2
    val stopx2= 3*x/4
    val stopy2 = height/2
    canvas.drawLine(startx2,starty2,stopx2,stopy2,paint)
    val startx1 = x/2
    val starty1 = 10
    val stopx1 = 3*x/4
    val stopy1 = height/2
    canvas.drawLine(startx1,starty1,stopx1,stopy1,paint)*/
  }
}*/
