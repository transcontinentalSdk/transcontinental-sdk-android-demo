package com.tctranscontinental.android.digitalflyer.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.tctranscontinental.android.digitalflyer.DigitalFlyer
import com.tctranscontinental.android.digitalflyer.ui.Event
import com.tctranscontinental.android.digitalflyer.ui.FlyerStyle
import com.tctranscontinental.android.digitalflyer.ui.FlyerViewUI
import com.tctranscontinental.android.digitalflyer.ui.MastheadStyle
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val subscriptionKey = ""
    private val client = ""
    private val banner = ""
    private val storeId = ""
    private val myCustomStyle = FlyerStyle(masthead = MastheadStyle())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val digitalFlyer = DigitalFlyer(
            subscriptionKey = subscriptionKey,
            client = client,
            banner = banner,
        )

        lifecycleScope.launch {
            val publications = digitalFlyer.listPublications(storeId = storeId)

            setContent {
                FlyerViewUI(
                    digitalFlyer = digitalFlyer,
                    attributes = publications.first(),
                    flyerStyle = myCustomStyle,
                ) { event ->
                    when (event) {
                        is Event.Sku -> println(event.sku)
                        is Event.Url -> println(event.url)
                        else -> {}
                    }
                }
            }
        }
    }
}
