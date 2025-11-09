package com.example.navigasitugas.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formulir(
    onSubmitButtonClick: () -> Unit,
    onResetButtonClick: () -> Unit,
    onBackButtonClick: () -> Unit
) {
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
        Icons.Filled.ArrowDropUp
    else
        Icons.Default.ArrowDropDown

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
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = { expanded = it},
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextField(value = txtStatus,
                            onValueChange = {},
                            readOnly = true,
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .menuAnchor(),
                            label = { Text("Pilih Status")},
                            trailingIcon = {
                                IconButton(onClick = {}) {
                                    Icon(
                                        icon,
                                        contentDescription = null
                                    )
                                }
                            },
                        )
                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = {expanded = false}
                        ) {
                            nikah.forEach {
                                opsi ->
                                DropdownMenuItem(
                                    text = {Text(opsi)},
                                    onClick = {txtStatus = opsi
                                    expanded = false},
                                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Column {
                    Text(text = "Alamat",
                        fontFamily = PlusJakartaSans,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = colorResource(R.color.blue)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    TextField(
                        value = txtAlamat,
                        onValueChange = {txtAlamat = it},
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    )
                }
                Spacer(modifier = Modifier.height(208.dp))
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    OutlinedButton(
                        onClick = onResetButtonClick,
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(2.dp,colorResource(R.color.orange)),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = colorResource(R.color.white),
                            contentColor = colorResource(R.color.orange)
                        ),
                        modifier = Modifier
                            .width(140.dp)
                    ) {
                        Text(text = "Batal",
                            fontFamily = PlusJakartaSans,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                    Button(
                        modifier = Modifier.width(140.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.orange),
                            contentColor = colorResource(R.color.white)
                        ),
                        onClick = {
                            nama = txtNama
                            gender = txtGender
                            status = txtStatus
                            alamat = txtAlamat
                            onSubmitButtonClick
                        }
                    ) {
                        Text(text = "Simpan",
                            fontFamily = PlusJakartaSans,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }

    }
}