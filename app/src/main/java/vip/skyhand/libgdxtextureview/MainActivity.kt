package vip.skyhand.libgdxtextureview

import android.app.Activity
import android.os.Bundle
import android.view.View
import vip.skyhand.libgdxtextureview.databinding.ActivitySpineTestBinding

/**
 * @author Skyhand
 */
class MainActivity : Activity() {

    private lateinit var binding: ActivitySpineTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpineTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mIvBack.visibility = View.GONE

        initListener()
    }

    private fun initListener() {
        binding.btnWalk.text = getString(R.string.btn_texture_view)
        binding.btnWalk.setOnClickListener {
            ShowActivity.start(this, true)
        }

        binding.btnJump.text = getString(R.string.btn_surface_view_not_top)
        binding.btnJump.setOnClickListener {
            ShowActivity.start(this, false, false)
        }

        binding.btnRun.text = getString(R.string.btn_surface_view_top)
        binding.btnRun.visibility = View.VISIBLE
        binding.btnRun.setOnClickListener {
            ShowActivity.start(this, false)

        }
    }


}
