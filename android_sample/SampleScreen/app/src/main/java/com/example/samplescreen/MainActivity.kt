package com.example.samplescreen

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btClickButton = findViewById<Button>(R.id.btClick)
        // リスナをインスタンス化
        val listener = ButtonClickListener()
        // リスナを設定
        btClickButton.setOnClickListener(listener)
    }

    private inner class ButtonClickListener : View.OnClickListener {
        @SuppressLint("SetTextI18n")
        override fun onClick(v: View?) {
            // 入力・出力対象の画面部品を取得
            val input = findViewById<EditText>(R.id.EditText)
            val output = findViewById<TextView>(R.id.HelloOutput)

            // 入力値を読み込む
            val inputText = input.text.toString()

            // 入力値を画面に反映
            output.text = "入力値：$inputText"

        }
    }
}

