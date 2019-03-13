package vip.skyhand.libgdxtextureview

import android.app.Activity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_spine_test.*

/**
 * @author Skyhand
 */
class MainActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spine_test)

        mIVBack.visibility = View.GONE

        initListener()
    }

    private fun initListener() {
        btn_walk.text = "使用TextureView"
        btn_walk.setOnClickListener {
            ShowActivity.start(this, true)
        }

        btn_jump.text = "使用SurfaceView，不置顶"
        btn_jump.setOnClickListener {
            ShowActivity.start(this, false, false)
        }

        btn_run.text = "使用SurfaceView，透明置顶"
        btn_run.visibility = View.VISIBLE
        btn_run.setOnClickListener {
            ShowActivity.start(this, false)

        }
    }


}
