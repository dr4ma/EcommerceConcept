package com.example.ecommerceconcept.presentation.fragments.explorerFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.FragmentExplorerBinding
import com.example.ecommerceconcept.presentation.BottomSheetApp
import com.example.ecommerceconcept.presentation.fragments.adapterDelegates.MainListAdapter
import com.example.ecommerceconcept.utills.*
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ExplorerFragment : Fragment() {

    private var binding: FragmentExplorerBinding? = null
    private val mBinding get() = binding!!

    @Inject
    lateinit var mAdapter: MainListAdapter

    @Inject
    lateinit var mAdapterCategories: CategoriesAdapter

    @Inject
    lateinit var mAdapterSales: HotSalesAdapter

    private lateinit var mSpinner: Spinner
    private lateinit var mViewPagerHotSales: ViewPager2
    private lateinit var mRecyclerCategory: RecyclerView
    private lateinit var mRecyclerBestSeller: RecyclerView
    private lateinit var mFilter: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExplorerBinding.inflate(layoutInflater, container, false)
        mBinding.apply {
            mSpinner = spinnerLocation
            mRecyclerCategory = recyclerCategory
            mViewPagerHotSales = pagerHotSales
            mRecyclerBestSeller = bestSellerRecycler
            mFilter = showFilter
        }
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initFields()
        initCategories()
        initHotSales()
        initBestSeller()
    }

    private fun initFields() {
        mFilter.setOnClickListener {
            BottomSheetApp.create(BottomSheetSettings.FILTER_BOTTOM_SHEET)
        }
        val adapterSpinner = ArrayAdapter.createFromResource(
            APP_ACTIVITY_MAIN,
            R.array.array_location,
            R.layout.spinner_toolbar_layout
        )
        mSpinner.adapter = adapterSpinner
        mAdapterCategories.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        mAdapterSales.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }

    private fun initCategories() {
        mRecyclerCategory.adapter = mAdapterCategories
        mAdapterCategories.setList(createListCategory())
    }

    private fun initHotSales() {
        mViewPagerHotSales.adapter = mAdapterSales
        mAdapterSales.setList(HOT_SALES)
    }

    private fun initBestSeller() {
        val layout = GridLayoutManager(context, 2)
        mRecyclerBestSeller.layoutManager = layout
        mAdapter.setItems(BEST_SELLER){
            mRecyclerBestSeller.adapter = mAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY_MAIN.chipNavigationBar.visibility = View.VISIBLE
    }

    companion object {
        fun openDetails() {
            APP_ACTIVITY_MAIN.navController.navigate(R.id.action_explorerFragment_to_detailsFragment)
            APP_ACTIVITY_MAIN.chipNavigationBar.visibility = View.GONE
        }
    }
}