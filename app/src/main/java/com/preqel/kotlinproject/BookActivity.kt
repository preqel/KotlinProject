package com.preqel.kotlinproject

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.preqel.kotlinproject.adapter.BookAdpater
import com.preqel.kotlinproject.data.*
import com.preqel.kotlinproject.module.BookModule
import com.preqel.kotlinproject.module.DaggerBookComponent
import kotlinx.android.synthetic.main.activity_book.*
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.lang.kotlin.subscribeBy
import rx.schedulers.Schedulers
import rx.schedulers.Schedulers.test
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by preqel on 2018/9/28.
 */

class BookActivity:AppCompatActivity {
    constructor() : super()

    @Inject
    lateinit var mBookObservable: Observable<Weather>

    @Inject
    lateinit var mCityObservable: Observable<Array<City>>

    lateinit var btn_Query: Button

    lateinit var tv_title:TextView

    lateinit var mlistview: RecyclerView

    var list: Array<ForeCast>? = null

    var list_city: Array<City>? = null

   var list_city_name :Array<String>?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        DaggerBookComponent.builder().bookModule(BookModule()).build().inject(this)
        initObservable()
        initView()
        mlistview = findViewById(R.id.mlistview);
        mlistview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
    }

    private fun initView() {
        btn_Query= findViewById(R.id.btn_query)
        btn_Query.setOnClickListener {

            if(list_city == null || list_city!!.size<= 0  ){
                return@setOnClickListener
            }

            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setIcon(R.drawable.ic_launcher_background)
            builder.setTitle("选择一个城市")
            list_city_name = Array(list_city!!.size, { i -> list_city!!.get(i).city_name })
            builder.setItems(list_city_name, DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
                et_city.setText(list_city_name!![which])
                val observable: Observable<Weather> = ServcieFactory.getRetrofit(WeatherApi::class.java).getWeather(list_city!!.get(which).city_code)
                refreshDate(observable)
            }).show()

        }
        tv_title = findViewById(R.id.tv_book)
        tv_title.isBold()
        tv_title.isRed()
        tv_title.invalidate()

        tv_title.requestLayout()
        tv_title.setJText()


    }

    private fun queryByCity(text:String) {
        mCityObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy({
                    list_city = it
                    it.forEach {
                        list_city_name
                        it.city_name }
                    Log.d("TAG", " mCityObservable Success")
                }, {
                    Log.d("TAG", "mCityObservable failed ${it.message}")
                })
    }


    private fun initObservable() {
        queryByCity("")
        refreshDate(mBookObservable)
    }

    private fun refreshDate(observable: Observable<Weather>) {
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy({
                    Log.d("TAG", "on success executed ${it.time}")
                    Log.d("TAG", "on success executed ${it.cityInfo.city}")
                    list = it.data.forecast
                    it.data.forecast.forEach {
                        Log.d("TAG", "接下来5天的天气 ${it.date} ,最高温度:${it.hign} z最低温度也 ${it.low}")
                    }
                    var bookadapter = BookAdpater(this, list)
                    mlistview.adapter = bookadapter
                    bookadapter.notifyDataSetChanged()
                }, {
                    Log.d("TAG", "on failed executed ${it.message}")
                })

    }

    //kotlin扩展函数
    private fun TextView.isBold() = this.apply() {
        paint.isFakeBoldText = true;
        this.setTextColor(resources.getColor(android.R.color.black))
    }

    private fun TextView.isRed() = this.apply {
        paint.color = Color.BLACK;
    }

    private fun TextView.setJText() = this.let {
        it.setText("hello");
    }

}