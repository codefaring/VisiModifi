package com.example.visimodifi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.visimodifi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 접근 제한자 테스트
        var child = Child()
        child.testVisi()

        var parent = Parent()
//        val testView1 = parent.prinum    // 참조불가
//        val testView2 = parent.pronum    // 참조불가
        val testView3 = parent.intenum
        val testView4 = parent.num

        var view =ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        view.btn.setOnClickListener{
            view.txt.text = "Parent클래스에 intenum 값은 ${testView3}"
        }
    }
}

open class Parent {
    private val prinum = 1
    protected val pronum = 2
    internal val intenum = 3
    val num = 4
}

class Child: Parent() {
    fun testVisi() {
        Log.d("접근제한자 상속테스트 시작", "==================")
//        Log.d("private", "prinum: ${prinum}") 문법에러
        Log.d("protected", "pronum 값은 ${pronum}")
        Log.d("internal", "intenum 값은 ${intenum}")
        Log.d("default", "intenum 값은 ${num}")
        Log.d("접근제한자 상속테스트 종료", "==================")
    }
}