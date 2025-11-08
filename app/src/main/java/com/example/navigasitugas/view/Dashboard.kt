package com.example.navigasitugas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import com.example.navigasitugas.R
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard() {
    Scaffold(modifier = Modifier,
        topBar = {
            //Image(pointerResource(id = R.drawable.listdata))
            TopAppBar(
                title = { Text("Dashboard",
                    fontFamily = PlusJakartaSans,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp)
                }
            )
        }) {
        Frame->
        Column(modifier = Modifier.padding(Frame)) {

        }
    }
}