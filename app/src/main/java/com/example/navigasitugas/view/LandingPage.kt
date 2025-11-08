package com.example.navigasitugas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import com.example.navigasitugas.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val PlusJakartaSans = FontFamily(
    Font(R.font.plusjakartasans_extralight, FontWeight.ExtraLight),
    Font(R.font.plusjakartasans_light, FontWeight.Light),
    Font(R.font.plusjakartasans_regular, FontWeight.Normal),
    Font(R.font.plusjakartasans_medium, FontWeight.Medium),
    Font(R.font.plusjakartasans_semibold, FontWeight.SemiBold),
    Font(R.font.plusjakartasans_bold, FontWeight.Bold),
    Font(R.font.plusjakartasans_extrabold, FontWeight.ExtraBold)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandingPage(
    onBackButtonClick: () -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.blue)) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Selamat Datang",
                color = colorResource(id = R.color.white),
                fontFamily = PlusJakartaSans,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            val logo = painterResource(id = R.drawable.listdata)
            Image(painter = logo,
                contentScale = ContentScale.Fit,
                contentDescription = null,
                modifier = Modifier
                    .height(48.dp)
            )
            Column(modifier = Modifier
                .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Arya Bagas Saputra",
                    color = colorResource(id = R.color.white),
                    fontFamily = PlusJakartaSans,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Text("20230140029",
                    color = colorResource(id = R.color.white),
                    fontFamily = PlusJakartaSans,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.height(16.dp))
                val hover = remember { MutableInteractionSource() }
                ElevatedButton(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.orange),
                        contentColor = colorResource(id = R.color.white)
                    ),
                    modifier = Modifier
                        .width(240.dp),
                        //.hoverable(interactionSource = hover),
                    onClick = onBackButtonClick
                ) {
                    Text(text = "Masuk",
                        fontSize = 20.sp,
                        fontFamily = PlusJakartaSans,
                        fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}