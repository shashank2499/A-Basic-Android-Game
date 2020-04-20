package com.example.modigame

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
var score:Int=0
    var handler:Handler= Handler()
    var runnable:Runnable= Runnable {  }
    var imageArray=ArrayList<ImageView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        score = 0
        imageArray= arrayListOf(imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9)
        hide()
        object : CountDownTimer(10000, 1000) {
            override fun onFinish() {
                textView.text = "Time Up!"
                handler.removeCallbacks(runnable)
                for(i in imageArray)
                    i.visibility=View.INVISIBLE
            }

            override fun onTick(p0: Long) {
                textView.text = "Time: " + p0 / 1000
            }

        }.start()
    }

    fun increase(view: View)
    {
        score++
        textView2.text="SCORE= "+score
    }
    fun hide()
    {
        runnable= object: Runnable{
            override fun run() {

                for(image in imageArray)
                    image.visibility=View.INVISIBLE
                val random =java.util.Random()
                var index=random.nextInt(8-0)
                imageArray[index].visibility=View.VISIBLE
                handler.postDelayed(runnable,1000)


            }

        }
        handler.post(runnable)

    }
}
