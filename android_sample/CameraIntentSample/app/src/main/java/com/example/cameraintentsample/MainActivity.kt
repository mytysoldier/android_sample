package com.example.cameraintentsample

import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import android.view.View
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {
    // Cameraアクティビティを起動するためのランチャーオブジェクト
    private val _cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult(), ActivityResultCallbackFromCamera())
    // 保存された画像のURI
    private var _imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // 画像部分がタップされたときの処理メソッド
    fun onCameraImageClick(view: View) {
        // 日時データを「yyyyMMddHHmmss」の形式に整形するフォーマッタを生成
        val dataFormat = SimpleDateFormat("yyyyMMddHHmmss")
        // 現在の日時を取得
        val now = Date()
        // 取得した日時データを「yyyyMMddHHmmss」形式に整形した文字列を生成
        val nowStr = dataFormat.format(now)
        // ストレージに格納する画像のファイル名を生成。ファイル名の一意を確保するために
        // タイムスタンプの値を利用
        val fileName = "CameraIntentSamplePhoto_${nowStr}.jpg"

        // ContentValuesオブジェクトを生成
        val values = ContentValues()
        // 画像ファイル名を設定
        values.put(MediaStore.Images.Media.TITLE, fileName)
        // 画像ファイルの種類を設定
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")

        // ContentResolverを使ってURIオブジェクトを生成
        _imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        // Intentオブジェクトを生成
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        // Extra情報として_imageUriを設定
        intent.putExtra(MediaStore.EXTRA_OUTPUT, _imageUri)
        // アクティビティを起動
        _cameraLauncher.launch(intent)
    }

    // Cameraアクティビティから戻ってきたときの処理が記述されたコールバッククラス
    private inner class  ActivityResultCallbackFromCamera : ActivityResultCallback<ActivityResult> {

        override fun onActivityResult(result: ActivityResult) {
            // カメラアプリで撮影成功の場合
            if (result?.resultCode == RESULT_OK) {
                // 画像を表示するImageViewを取得
                val ivCamera = findViewById<ImageView>(R.id.ivCamera)
                // プロパティの画像URIをImageViewに設定
                ivCamera.setImageURI(_imageUri)
            }
        }
    }
}