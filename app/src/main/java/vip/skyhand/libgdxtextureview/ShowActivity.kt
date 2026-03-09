package vip.skyhand.libgdxtextureview

import android.annotation.SuppressLint
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
import vip.skyhand.libgdxtextureview.databinding.ActivitySpineTestBinding

class ShowActivity : AndroidApplication() {

    lateinit var mGdxAdapter: GdxAdapter
    lateinit var mGdxView: View
    private lateinit var binding: ActivitySpineTestBinding

    companion object {
        fun start(context: Context, useTextureView: Boolean, isTranlate: Boolean = true) {
            val intent = Intent(context, ShowActivity::class.java)
            intent.putExtra("USETEXTUREVIEW", useTextureView)
            intent.putExtra("ISTRANLATE", isTranlate)
            context.startActivity(intent)
        }
    }

    private var useTextureView = true
    private var isTranslate = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpineTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        useTextureView = intent.getBooleanExtra("USETEXTUREVIEW", true)
        isTranslate = intent.getBooleanExtra("ISTRANLATE", true)
        initGDX()
        initListener()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initListener() {
        binding.btnJump.setOnClickListener {
            mGdxAdapter.setAnimate("jump")
        }
        binding.btnWalk.setOnClickListener {
            mGdxAdapter.setAnimate("walk")
        }

        mGdxView.setOnTouchListener { _, event ->
            val action = event.action
            if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
                mGdxAdapter.setAnimate()
            }
            true
        }
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
            Toast.makeText(this, getString(R.string.toast_surface_view), Toast.LENGTH_SHORT).show()
            if (isTranslate) {
                (mGdxView as SurfaceView).holder.setFormat(PixelFormat.TRANSLUCENT)
                (mGdxView as SurfaceView).setZOrderOnTop(true)
            } else {
                (mGdxView as SurfaceView).setZOrderMediaOverlay(true)
            }
        } else if (mGdxView is TextureView) {
            Toast.makeText(this, getString(R.string.toast_texture_view), Toast.LENGTH_SHORT).show()
            //Log.e("@@", "当前是TextureView")
        }

        binding.mLayoutGdx.addView(mGdxView)

    }

}