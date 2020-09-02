package com.ganarstudio.orderfoodappkotlin.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ganarstudio.orderfoodappkotlin.R
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.fragment_category.*

class MenuFragment : Fragment() {

    private lateinit var menuViewModel: MenuViewModel
    private lateinit var dialog: android.app.AlertDialog
    private lateinit var layoutAnimationController:LayoutAnimationController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        menuViewModel =
            ViewModelProviders.of(this).get(MenuViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_category, container, false)

        initViews()

        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    private fun initViews() {
        dialog = SpotsDialog.Builder().setContext(context)
            .setCancelable(false).build()
        dialog.show()
        layoutAnimationController = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_item_from_left)
        recycler_menu!!.setHasFixedSize(true)

    }
}