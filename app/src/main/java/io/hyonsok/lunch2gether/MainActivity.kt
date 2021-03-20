package io.hyonsok.lunch2gether

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.JsPromptResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myWebView: WebView = findViewById(R.id.webview)

        myWebView.settings.javaScriptEnabled = true


        myWebView.webChromeClient = object: WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
            }

            override fun onJsPrompt(
                view: WebView?,
                url: String?,
                message: String?,
                defaultValue: String?,
                result: JsPromptResult?
            ): Boolean {

                return super.onJsPrompt(view, url, message, defaultValue, result)
            }


        }



        myWebView.webViewClient = object: WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {

                progressBar.visibility = View.INVISIBLE

                super.onPageFinished(view, url)
            }
        }

        myWebView.loadUrl(
            "https://appsvc-dev-flunch2-aztech-kc.azurewebsites.net"
        )


    }
}