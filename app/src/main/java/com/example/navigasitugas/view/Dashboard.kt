package com.example.navigasitugas.view

import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
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
fun Dashboard(
    onExitButtonClick: () -> Unit,
    onFormButtonClick: () -> Unit
) {
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
            status = "Menikah",
            alamat = "Bengkulu"
        ),
        CardData(
            nama = "Sascha Danu",
            gender = "Laki - Laki",
            status = "Belum Menikah",
            alamat = "Sukoharjo"
        ),
        CardData(
            nama = "Nabil Nasruddin",
            gender = "Laki - Laki",
            status = "Belum Menikah",
            alamat = "Sidoarjo"
        ),
        CardData(
            nama = "M. Refky Syahrin",
            gender = "Laki - Laki",
            status = "Menikah",
            alamat = "Tasikmalaya"
        )
    )
    val interactionSource = remember { MutableInteractionSource() }
    val press by interactionSource.collectIsPressedAsState()

    Scaffold(
//        containerColor = colorResource(R.color.blue),
        modifier = Modifier.fillMaxSize(),
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
                            modifier = Modifier
                                .padding(bottom = 20.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.blue)
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = colorResource(R.color.blue),
                modifier = Modifier
                    .height(70.dp)
                    //.padding(bottom = 20.dp)
            ) {
                    Row(modifier = Modifier
                        .fillMaxWidth(),
//                        .padding(top = 60.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        ElevatedButton(
                            colors = (if (press) ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.white),
                                contentColor = colorResource(id = R.color.orange))
                                    else ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.orange),
                                contentColor = colorResource(id = R.color.white))
                            ),
                            modifier = Modifier
                                .width(160.dp)
                                .hoverable(interactionSource = interactionSource),
                            onClick = onExitButtonClick
                        ) {
                            Text(text = "Keluar",
                                fontSize = 20.sp,
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Bold)
                        }
                        ElevatedButton(
                            colors = (if (press) ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.white),
                                contentColor = colorResource(id = R.color.orange))
                            else ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.orange),
                                contentColor = colorResource(id = R.color.white))
                                    ),
                            modifier = Modifier
                                .width(160.dp),
                            //.hoverable(interactionSource = hover),
                            onClick = onFormButtonClick
                        ) {
                            Text(text = "Formulir",
                                fontSize = 20.sp,
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Bold)
                        }
                    }
                }
        })
    {
        frame->
        LazyColumn(modifier = Modifier
            .padding(frame),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            items(items) { item ->
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    ),
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(
                        colorResource(R.color.white)
                    )
                ){
                    Row(modifier = Modifier
                        .padding(top = 12.dp, start = 16.dp, end = 20.dp)
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween)
                    {
                        Column {
                            Text(text = "NAMA LENGKAP",
                                fontSize = 16.sp,
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(R.color.blue))
                            Text(item.nama,
                                fontSize = 16.sp,
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Normal,
                                color = colorResource(R.color.blue))
                        }
                        Column {
                            Text(text = "JENIS KELAMIN",
                                fontSize = 16.sp,
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(R.color.blue))
                            Text(item.gender,
                                fontSize = 16.sp,
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Normal,
                                color = colorResource(R.color.blue))
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(modifier = Modifier
                        .padding(start = 16.dp, end = 20.dp, bottom = 12.dp)
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween)
                    {
                        Column {
                            Text(text = "STATUS PERKAWINAN",
                                fontSize = 16.sp,
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(R.color.blue),
                                modifier = Modifier.width(120.dp))
                            Text(item.status,
                                fontSize = 16.sp,
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Normal,
                                color = colorResource(R.color.blue))
                        }
                        Column {
                            Text(text = "ALAMAT",
                                fontSize = 16.sp,
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(R.color.blue),
                                modifier = Modifier.width(120.dp))
                            Text(item.alamat,
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