package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.squareup.picasso.Picasso

class InfoService : AppCompatActivity() {

    companion object{
        var positionService: Int = 0
        var arrayItem: InfoServices = InfoServices()
    }

    lateinit var serviceIcon: ImageView
    lateinit var serviceName: TextView
    lateinit var serviceDescription: TextView
    lateinit var serviceUrl: TextView
    lateinit var btnBack: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_service)

        serviceIcon = findViewById(R.id.iconService)
        serviceName = findViewById(R.id.nameServices)
        serviceDescription = findViewById(R.id.descriptionServices)
        serviceUrl = findViewById(R.id.urlServices)
        btnBack = findViewById(R.id.backMainActivity)
        val linkedText: String = String.format("<a href=\"%s\">${arrayItem.getUrlService()}</a> ", arrayItem.getUrlService())

        Picasso.with(baseContext).load(arrayItem.getIconService()).placeholder(R.drawable.download).error(R.drawable.error).into(serviceIcon)

        serviceName.text = arrayItem.getNameService()
        serviceDescription.text = arrayItem.getDescriptionService()
        serviceUrl.text = Html.fromHtml(linkedText)
        serviceUrl.movementMethod = LinkMovementMethod.getInstance()

        btnBack.setOnClickListener {
            val intent: Intent = Intent(baseContext, MainActivity::class.java)
            this.startActivity(intent)
            finish()
        }
    }
}