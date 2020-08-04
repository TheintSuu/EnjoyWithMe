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
import com.theintsuhtwe.enjoywithme.activites.MovieDetailActivity
import com.theintsuhtwe.enjoywithme.adapters.*
import com.theintsuhtwe.enjoywithme.data.vos.*
import com.theintsuhtwe.enjoywithme.mvp.presenters.MainPresenter
import com.theintsuhtwe.enjoywithme.mvp.presenters.MainPresenterImpl
import com.theintsuhtwe.enjoywithme.mvp.views.MainView
import com.theintsuhtwe.enjoywithme.utils.IMAGE_BASE_URL
import com.theintsuhtwe.enjoywithme.views.viewholders.TopRatedViewHolder
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.item_upcoming_view.*
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

    private lateinit var mPopularAdapter: PopularMoiveAdapter

    private lateinit var mShowCasedapter: ShowCaseMoviesAdapter

    private lateinit var mAcotradapter: ActorItemAdapter


    private lateinit var mTopRatedTabAdapter: TopRatedAdapter

    private lateinit var mSliderAdapter: MovieSliderAdapter

    private lateinit var mPresenter: MainPresenter

    private var tabLayoutTitleList : List<String> ?= null


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


        setUpPresenter()


        mPresenter.onUiReady(this)

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

        mSliderAdapter = MovieSliderAdapter(mPresenter)
        upcomingMovieLayout.setSliderAdapter(mSliderAdapter)


        mPopularAdapter = PopularMoiveAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvPopularMovies.layoutManager = linearLayoutManager
        rvPopularMovies.adapter = mPopularAdapter
    }


    private fun setUpViewPager() {
        mTopRatedTabAdapter = TopRatedAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvCategoryMovie.layoutManager = linearLayoutManager
        rvCategoryMovie.adapter =  mTopRatedTabAdapter

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
              // mPresenter.onTabSelected(this@MainFragment, tab!!.text.toString())
           }

       })
    }

    override fun displayMoviesList(newsList: List<MoviesVO>) {
        val news = newsList.take(5)
       mSliderAdapter.setData(news.toMutableList())
    }

    override fun navigateToMoviesDetails(newsId: Int) {
        startActivity(MovieDetailActivity.newItent(activity!!, newsId))

    }

    override fun displayAcotrList(newList: List<ActorVO>) {
        mAcotradapter.setData(newList.toMutableList())
    }

    override fun displayMovieListByCaterogry(newsList: List<TopRatedVO>) {
       mTopRatedTabAdapter.setData(newsList.toMutableList()!!)
    }

    override fun dispalyShowCaseMovieList(newsList: List<NowPlayingVO>) {
       mShowCasedapter.setData(newsList.toMutableList()!!)
    }

    override fun dispalyPopularMovieList(newsList: List<PopularMoviesVO>) {
       mPopularAdapter.setData(newsList.toMutableList())
    }

    override fun displayGenersList(newList: List<GenersVO>) {
        setTabLayoutTitle(newList.toMutableList()!!)
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

    private fun setTabLayoutTitle(it : List<GenersVO>){
        //tabLayoutTitleList = it.toMutableList()
        it.forEach {
            tabLayoutProfile.addTab(tabLayoutProfile.newTab().setText(it.name))
        }
    }



}