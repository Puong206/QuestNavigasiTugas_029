package com.example.navigasitugas.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import com.example.navigasitugas.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

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

    var expanded by remember { mutableStateOf(false) }
    var ukrTextField by remember { mutableStateOf(Size.Zero) }
    val icon = if (expanded)
        Icons.Default.KeyboardArrowUp
    else
        Icons.Default.KeyboardArrowDown

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
                .padding(top = 20.dp, start = 20.dp, end = 20.dp),
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
                Spacer(modifier = Modifier.height(12.dp))
                Column {
                    Text(text = "Jenis Kelamin",
                        fontFamily = PlusJakartaSans,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(R.color.blue)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row {
                        jenis.forEach { item ->
                            Row(modifier = Modifier.selectable(
                                selected = txtGender == item,
                                onClick = { txtGender = item }
                            ), verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(
                                    selected = txtGender == item,
                                    onClick = { txtGender = item },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = colorResource(R.color.blue),
                                        unselectedColor = colorResource(R.color.blue)
                                    ),
                                    modifier = Modifier
                                        .width(12.dp)
                                        .height(12.dp)
                                        .padding(start = 8.dp)
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(item,
                                    fontFamily = PlusJakartaSans,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 14.sp,
                                    color = colorResource(R.color.blue))
                                Spacer(modifier = Modifier.width(20.dp))
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Column {
                    Text("Status Perkawinan",
                        fontFamily = PlusJakartaSans,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = colorResource(R.color.blue)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    TextField(value = txtStatus,
                        onValueChange = {},
                        readOnly = true,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned { coordinates ->
                                ukrTextField = coordinates.size.toSize()
                            }
                            .clickable(onClick = {expanded = !expanded}),
                        label = { Text("Pilih Status")},
                        trailingIcon = {
                            IconButton(onClick = {expanded = !expanded}) {
                                Icon(
                                    icon, contentDescription = null
                                )
                            }
                        }
                    )
                    DropdownMenu(
                        modifier = Modifier
                            .width(with(LocalDensity.current){ukrTextField.width.toDp()}),
                        expanded = expanded,
                        onDismissRequest = {expanded = false}
                    ) {
                        nikah.forEach { opsi ->
                            DropdownMenuItem(
                                text = {Text(opsi)},
                                onClick = {txtStatus = opsi
                                          expanded = false},
                                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                            )
                        }
                    }
                }
            }
        }

    }
}