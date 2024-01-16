package org.techtown.uns_recyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.techtown.uns_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val tag: String = javaClass.simpleName

    lateinit var testAdapter: TestAdapter

    private val testDummyList = arrayListOf(
        TestData(id = "1", time = "15:46", title = "이집트", contents = "아프리카에 있다"),
        TestData(id = "2", time = "12:14", title = "영국", contents = "유럽에 있다"),
        TestData(id = "3", time = "13:26", title = "한국", contents = "아시아에 있다"),
        TestData(id = "4", time = "18:44", title = "네덜란드", contents = "유럽에 있다"),
        TestData(id = "5", time = "12:54", title = "아르헨티나", contents = "아메리카에 있다"),
        TestData(id = "6", time = "15:46", title = "탄자니아", contents = "아프리카에 있다"),
        TestData(id = "7", time = "12:14", title = "이탈리아", contents = "유럽에 있다"),
        TestData(id = "8", time = "13:26", title = "대만", contents = "아시아에 있다"),
        TestData(id = "9", time = "18:44", title = "프랑스", contents = "유럽에 있다"),
        TestData(id = "10", time = "12:54", title = "칠레", contents = "아메리카에 있다"),
        TestData(id = "11", time = "15:46", title = "콩고", contents = "아프리카에 있다"),
        TestData(id = "12", time = "12:14", title = "독일", contents = "유럽에 있다"),
        TestData(id = "13", time = "13:26", title = "베트남", contents = "아시아에 있다"),
        TestData(id = "14", time = "18:44", title = "스위스", contents = "유럽에 있다"),
        TestData(id = "15", time = "12:54", title = "미국", contents = "아메리카에 있다"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        AppData.debug(tag, "tag: $tag")
        initRecyclerView()

        setData()
    }

    private fun initRecyclerView() {
        val method: String = Thread.currentThread().stackTrace[2].methodName
        AppData.debug(tag, "$method called")

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.testRecyclerView.layoutManager = layoutManager

        testAdapter = TestAdapter()
        binding.testRecyclerView.adapter = testAdapter

        testAdapter.listener = object : OnTestItemClickListener {
            override fun onItemClick(holder: TestAdapter.ViewHolder?, view: View?, position: Int) {
                val testData = testAdapter.items[position]
                AppData.showToast(this@MainActivity, "아이템 선택됨: ${testData.time} ${testData.title} ${testData.contents}")
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setData() {
        testAdapter.items = testDummyList
        testAdapter.notifyDataSetChanged()
    }

}