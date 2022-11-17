package com.example.ecommerceconcept.presentation.fragments.detailsFragment

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.FragmentDetailsBinding
import com.example.ecommerceconcept.utills.APP_ACTIVITY_MAIN
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.math.abs

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val mViewModel: DetailsViewModel by viewModels()
    private var binding: FragmentDetailsBinding? = null
    private val mBinding get() = binding!!

    private lateinit var mTab: TabLayout
    private lateinit var mShopLayout: LinearLayout
    private lateinit var mDetailsLayout: LinearLayout
    private lateinit var mFeaturesLayout: LinearLayout

    @Inject
    lateinit var mAdapter: ImagesDetailAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        mBinding.apply {
            mTab = tabs
            mShopLayout = shopBox
            mDetailsLayout = detailsBox
            mFeaturesLayout = featuresBox
        }
        return mBinding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()

        initImageCarousel()
        mBinding.apply {
            mViewModel.details.observe(viewLifecycleOwner) {
                mAdapter.setList(it.images)
                titleDetails.text = it.title
                ratingDetails.rating = it.rating.toFloat()
                favoritesDetails.isSelected = it.isFavorites
                cpuText.text = it.CPU
                cameraText.text = it.camera
                ssdText.text = it.ssd
                sdText.text = it.sd
                price.text = "$" + it.price
                firstSize.text = it.capacity[0] + " " + getString(R.string.gb)
                firstSize.isSelected = true
                secondSize.text = it.capacity[1] + " " + getString(R.string.gb)
                firstColor.backgroundTintList = ColorStateList.valueOf(Color.parseColor(it.color[0]))
                firstColor.isSelected = true
                secondColor.backgroundTintList = ColorStateList.valueOf(Color.parseColor(it.color[1]))
            }
        }
        mViewModel.getDetails()
        initListeners()
        initTabLayout()
    }

    private fun initImageCarousel() {
        mBinding.apply {
            pagerImagesDetails.adapter = mAdapter
            pagerImagesDetails.clipToPadding = false
            pagerImagesDetails.clipChildren = false
            pagerImagesDetails.offscreenPageLimit = 3
            pagerImagesDetails.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            val compositePageTransformer = CompositePageTransformer()
            compositePageTransformer.addTransformer(MarginPageTransformer(100))
            compositePageTransformer.addTransformer { page, position ->
                val r = 1 - abs(position)
                page.scaleY = 0.85f + r * 0.15f
            }
            pagerImagesDetails.setPageTransformer(compositePageTransformer)
        }
    }

    private fun initListeners() {
        mBinding.apply {
            backPressed.setOnClickListener {
                APP_ACTIVITY_MAIN.onBackPressedDispatcher.onBackPressed()
                APP_ACTIVITY_MAIN.chipNavigationBar.visibility = View.VISIBLE
            }
            favoritesDetails.setOnClickListener {
                it.isSelected = !it.isSelected
            }
            firstSize.setOnClickListener {
                it.isSelected = true
                secondSize.isSelected = false
            }
            secondSize.setOnClickListener {
                it.isSelected = true
                firstSize.isSelected = false
            }
            firstColor.setOnClickListener {
                it.isSelected = true
                secondColor.isSelected = false
            }
            secondColor.setOnClickListener {
                it.isSelected = true
                firstColor.isSelected = false
            }
        }
    }

    private fun initTabLayout() {
        val shopTab = mTab.getTabAt(0)
        val detailsTab = mTab.getTabAt(1)
        val featuresTab = mTab.getTabAt(2)
        if (shopTab != null && detailsTab != null && featuresTab != null) {
            ResourcesCompat.getFont(APP_ACTIVITY_MAIN, R.font.mark_pro_bold)
                ?.let { setTabTypeFace(shopTab, it) }
            ResourcesCompat.getFont(APP_ACTIVITY_MAIN, R.font.mark_pro_regular)
                ?.let { setTabTypeFace(detailsTab, it) }
            ResourcesCompat.getFont(APP_ACTIVITY_MAIN, R.font.mark_pro_regular)
                ?.let { setTabTypeFace(featuresTab, it) }
        }
        mTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                ResourcesCompat.getFont(APP_ACTIVITY_MAIN, R.font.mark_pro_bold)
                    ?.let {
                        if (tab != null) {
                            setTabTypeFace(tab, it)
                        }
                    }
                tab?.position?.let { onTabTapped(it) }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                ResourcesCompat.getFont(APP_ACTIVITY_MAIN, R.font.mark_pro_regular)
                    ?.let {
                        if (tab != null) {
                            setTabTypeFace(tab, it)
                        }
                    }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                tab?.position?.let { onTabTapped(it) }
            }

        })
    }

    private fun onTabTapped(position: Int) {
        when (position) {
            0 -> {
                mShopLayout.visibility = View.VISIBLE
                mDetailsLayout.visibility = View.INVISIBLE
                mFeaturesLayout.visibility = View.INVISIBLE
            }
            1 -> {
                mShopLayout.visibility = View.INVISIBLE
                mDetailsLayout.visibility = View.VISIBLE
                mFeaturesLayout.visibility = View.INVISIBLE
            }
            2 -> {
                mShopLayout.visibility = View.INVISIBLE
                mDetailsLayout.visibility = View.INVISIBLE
                mFeaturesLayout.visibility = View.VISIBLE
            }
        }
    }

    private fun setTabTypeFace(tab: TabLayout.Tab, typeface: Typeface) {
        for (i in 0..tab.view.childCount) {
            val viewChild = tab.view.getChildAt(i)
            if (viewChild is TextView) {
                viewChild.typeface = typeface
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}