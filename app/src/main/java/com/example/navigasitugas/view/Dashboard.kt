package com.example.navigasitugas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import com.example.navigasitugas.R
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class CardData(
    val nama: String,
    val gender: String,
    val status: String,
    val alamat: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard() {
    val items = listOf(
        CardData(
            nama = "Arya Bagas Saputra",
            gender = "Laki - Laki",
            status = "Belum Menikah",
            alamat = "Kebumen"
        ),
        CardData(
            nama = "M. Zaky Malika",
            gender = "Laki - Laki",
            status = "Belum Menikah",
            alamat = "Bengkulu"
        )
    )
    Scaffold(
        containerColor = colorResource(R.color.blue),
        topBar = {
            TopAppBar(
                title = {
                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center)
                    {
                        Text("List Daftar Peserta",
                            color = colorResource(R.color.orange),
                            fontFamily = PlusJakartaSans,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            modifier = Modifier.padding(top = 40.dp, bottom = 20.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.blue)
                )
            )
        }) {
        Frame->
        LazyColumn(modifier = Modifier
            .padding(Frame)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            items(items) { item ->
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    ),
                    modifier = Modifier
                        .size(width = 240.dp, height = 100.dp)
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(
                        colorResource(R.color.white)
                    )
                ){
                    Row(modifier = Modifier
                        .fillMaxWidth())
                    {
                        Column(
                            modifier = Modifier.padding(top = 4.dp, start = 8.dp),

                        ) {
                            Text(text = "NAMA LENGKAP",
                                fontSize = 16.sp,
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(R.color.blue))
                            Text("${item.nama}",
                                fontSize = 16.sp,
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Normal,
                                color = colorResource(R.color.blue))
                        }
                    }
                }
            }
        }
    }
}