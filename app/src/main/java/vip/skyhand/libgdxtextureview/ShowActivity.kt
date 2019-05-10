package vip.skyhand.libgdxtextureview

import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Bundle
import android.view.MotionEvent
import android.view.SurfaceView
import android.view.TextureView
import android.view.View
import android.widget.Toast
import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration
import kotlinx.android.synthetic.main.activity_spine_test.*

class ShowActivity : AndroidApplication() {

    lateinit var mGdxAdapter: GdxAdapter
    lateinit var mGdxView: View

    companion object {
        fun start(context: Context, useTextureView: Boolean, isTranlate: Boolean = true) {
            val intent = Intent(context, ShowActivity::class.java)
            intent.putExtra("USETEXTUREVIEW", useTextureView)
            intent.putExtra("ISTRANLATE", isTranlate)
            context.startActivity(intent)
        }
    }

    private var useTextureView = true
    private var isTranlate = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spine_test)
        useTextureView = intent.getBooleanExtra("USETEXTUREVIEW", true)
        isTranlate = intent.getBooleanExtra("ISTRANLATE", true)
        initGDX()
        initListener()
    }

    private fun initListener() {
        btn_jump.setOnClickListener {
            mGdxAdapter.setAnimate("jump")
        }
        btn_walk.setOnClickListener {
            mGdxAdapter.setAnimate("walk")
        }

        mGdxView.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View, event: MotionEvent): Boolean {
                val action = event.action
                if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
                    mGdxAdapter.setAnimate()
                }
                return true
            }
        })
    }


    private fun initGDX() {
        val cfg = AndroidApplicationConfiguration()

        cfg.useTextureView = useTextureView  //是否使用TextureView

        cfg.useImmersiveMode = true
        cfg.a = 8
        cfg.b = cfg.a
        cfg.g = cfg.b
        cfg.r = cfg.g
        mGdxAdapter = GdxAdapter()
        mGdxView = initializeForView(mGdxAdapter, cfg)

        if (mGdxView is SurfaceView) {
            //Log.e("@@", "当前是SurfaceView")
            Toast.makeText(this, "当前是SurfaceView", Toast.LENGTH_SHORT).show()
            if (isTranlate) {
                (mGdxView as SurfaceView).holder.setFormat(PixelFormat.TRANSLUCENT)
                (mGdxView as SurfaceView).setZOrderOnTop(true)
            } else {
                (mGdxView as SurfaceView).setZOrderMediaOverlay(true)
            }
        } else if (mGdxView is TextureView) {
            Toast.makeText(this, "当前是TextureView", Toast.LENGTH_SHORT).show()
            //Log.e("@@", "当前是TextureView")
        }

        mLayoutGdx.addView(mGdxView)

    }

}