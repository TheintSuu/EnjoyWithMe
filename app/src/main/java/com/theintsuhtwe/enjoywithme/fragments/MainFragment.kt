package com.theintsuhtwe.enjoywithme.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.custom.sliderimage.logic.SliderImage
import com.google.android.material.tabs.TabLayout
import com.theintsuhtwe.enjoywithme.R
import com.theintsuhtwe.enjoywithme.adapters.*
import com.theintsuhtwe.enjoywithme.data.vos.MoviesVO
import com.theintsuhtwe.enjoywithme.mvp.presenters.MainPresenter
import com.theintsuhtwe.enjoywithme.mvp.presenters.MainPresenterImpl
import com.theintsuhtwe.enjoywithme.mvp.views.MainView
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.item_upcoming_view.view.*
import kotlinx.android.synthetic.main.view_pod_actor.*
import kotlinx.android.synthetic.main.view_pod_showcases.*
import kotlinx.android.synthetic.main.view_pod_tab_layout.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment(), MainView {

    private lateinit var mAdapter: MovieItemAdapter

    private lateinit var mShowCasedapter: ShowCaseMoviesAdapter

    private lateinit var mAcotradapter: ActorItemAdapter


    private lateinit var mCategoryAdapter: MovieItemAdapter

    private lateinit var mPresenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_main, container, false)


        mPresenter.onUiReady(this)

        // Create slider image component
        val sliderImage = SliderImage(activity!!)

        // add images URLs
        val images = listOf(
           "https://i.pinimg.com/564x/70/17/01/701701c76b0080701521be6130f1bbbb.jpg",
           "https://i.pinimg.com/564x/70/17/01/701701c76b0080701521be6130f1bbbb.jpg",
           "https://i.pinimg.com/564x/70/17/01/701701c76b0080701521be6130f1bbbb.jpg")

        // Add image URLs to sliderImage


        sliderImage.setItems(images)


        v.slider.setItems(images)

        v.slider.addTimerToSlide(2000)


        setUpPresenter()




        return v


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

        setUpShoweCaseRecyclerView()

        setUpActorRecyclerView()

        setUpViewPager()
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView() {
        mAdapter = MovieItemAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvPopularMovies.layoutManager = linearLayoutManager
        rvPopularMovies.adapter = mAdapter
    }


    private fun setUpViewPager() {
        mCategoryAdapter = MovieItemAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvCategoryMovie.layoutManager = linearLayoutManager
        rvCategoryMovie.adapter =  mCategoryAdapter



        tabLayoutProfile.addTab(tabLayoutProfile.newTab().setText("ACTION"))
        tabLayoutProfile.addTab(tabLayoutProfile.newTab().setText("ADVENTURE"))
        tabLayoutProfile.addTab(tabLayoutProfile.newTab().setText("CRIMIAL"))
        tabLayoutProfile.addTab(tabLayoutProfile.newTab().setText("DRAMA"))
        tabLayoutProfile.addTab(tabLayoutProfile.newTab().setText("ACTIONS"))



       tabLayoutProfile.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
           override fun onTabReselected(tab: TabLayout.Tab?) {

           }

           override fun onTabUnselected(tab: TabLayout.Tab?) {

           }

           override fun onTabSelected(tab: TabLayout.Tab?) {
               mPresenter.onTabSelected(this@MainFragment, tab!!.text.toString())
           }

       })
    }

    override fun displayMoviesList(newsList: List<MoviesVO>) {
        mAdapter.setData(newsList.toMutableList())
    }

    override fun navigateToMoviesDetails(newsId: Int) {

    }

    override fun displayMovieListByCaterogry(newsList: List<MoviesVO>) {

    }


    private fun setUpShoweCaseRecyclerView() {
        mShowCasedapter = ShowCaseMoviesAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvShowcases.layoutManager = linearLayoutManager
        rvShowcases.adapter = mShowCasedapter
    }


    private fun setUpActorRecyclerView() {
        mAcotradapter =  ActorItemAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvActors.layoutManager = linearLayoutManager
        rvActors.adapter =  mAcotradapter
    }

}