package com.ganarstudio.orderfoodappkotlin.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.asksira.loopingviewpager.LoopingViewPager
import com.ganarstudio.orderfoodappkotlin.Adapter.MyBestDealsAdapter
import com.ganarstudio.orderfoodappkotlin.Adapter.MyPopularCategoriesAdapter
import com.ganarstudio.orderfoodappkotlin.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    var recyclerView: RecyclerView ?= null
    var viewPager:LoopingViewPager ?= null

    var layoutAnimationControlListener:LayoutAnimationController ?= null

    var unbinder:Unbinder ?= null

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        initView(root)
        //bind data
        homeViewModel.popularList.observe(this, Observer {
            val listData = it
            val adapter = MyPopularCategoriesAdapter(context!!, listData)
            recyclerView!!.adapter = adapter
            recyclerView!!.layoutAnimation = layoutAnimationControlListener
        })
        homeViewModel.bestDeaList.observe(this, Observer {
            val adapter = MyBestDealsAdapter(context!!, it, false)
            viewPager!!.adapter = adapter
        })
        return root
    }

    private fun initView(root: View) {
        layoutAnimationControlListener = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_item_from_left)
        viewPager = root.findViewById(R.id.viewpager) as LoopingViewPager
        recyclerView = root.findViewById(R.id.recycler_popular) as RecyclerView
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    }

    override fun onResume() {
        super.onResume()
        viewPager!!.resumeAutoScroll()
    }

    override fun onPause() {
        super.onPause()
        viewPager!!.pauseAutoScroll()
    }
}