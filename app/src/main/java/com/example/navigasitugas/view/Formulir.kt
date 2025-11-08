package com.example.navigasitugas.view

import androidx.compose.foundation.layout.Arrangement
import com.example.navigasitugas.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Formulir() {
    var txtNama by remember { mutableStateOf("") }
    var txtGender by remember { mutableStateOf("") }
    var txtStatus by remember { mutableStateOf("") }
    var txtAlamat by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    val jenis: List<String> = listOf("Laki - Laki", "Perempuan")
    val nikah: List<String> = listOf("Menikah", "Belum Menikah", "Janda/Duda")

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Formulir Pendaftaran",
            fontFamily = PlusJakartaSans,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.white)
        )
        ElevatedCard(
            modifier = Modifier
                .padding(top = 12.dp, start = 24.dp, end = 24.dp, bottom = 80.dp)
                .fillMaxSize()
                .align(Alignment.CenterHorizontally),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(
                colorResource(R.color.white))
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp,start = 20.dp, end = 20.dp),
                horizontalAlignment = Alignment.Start) {
                Column {
                    Text(text = "Nama Lengkap",
                        fontFamily = PlusJakartaSans,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(R.color.blue)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(value = txtNama,

                        singleLine = true,
                        onValueChange = { txtNama = it },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }

    }
}