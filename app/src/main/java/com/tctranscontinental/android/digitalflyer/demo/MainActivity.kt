package com.tctranscontinental.android.digitalflyer.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.tctranscontinental.android.digitalflyer.DigitalFlyer
import com.tctranscontinental.android.digitalflyer.Orientation
import com.tctranscontinental.android.digitalflyer.ui.Event
import com.tctranscontinental.android.digitalflyer.ui.xml.FlyerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val subscriptionKey = ""
    private val client = ""
    private val banner = ""
    private val storeId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val digitalFlyer = DigitalFlyer(
            subscriptionKey,
            client,
            banner
        )

        lifecycleScope.launch {
            val publications = digitalFlyer.listPublications(storeId)
            val publication = digitalFlyer.getPublication(
                publications.first(),
                orientation = Orientation.VERTICAL
            )

            val flyerView = findViewById<FlyerView>(R.id.flyer_view)
            flyerView.setActivePublication(publication) { event ->
                when (event) {
                    is Event.Sku -> println("SKU: ${event.sku}") // This will be called when an event is emitted
                    else -> TODO("Handle other events")
                }
            }
        }
    }
}