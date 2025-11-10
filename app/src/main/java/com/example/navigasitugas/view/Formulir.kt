package com.example.navigasitugas.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import com.example.navigasitugas.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

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

    val icon = if (expanded)
        Icons.Filled.ArrowDropUp
    else
        Icons.Default.ArrowDropDown

    fun clearData() {
        txtNama = ""
        txtGender = ""
        txtStatus = ""
        txtAlamat = ""
    }

    var showDialog by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(true) }
    LaunchedEffect(key1 = true) {
        delay(2000)
        isLoading = false
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            containerColor = colorResource(R.color.white),
            icon = {Icon(Icons.Filled.TaskAlt,
                null,
                modifier = Modifier
                    .size(64.dp),
                tint = colorResource(R.color.orange),)},
            title = {
                Column(modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Berhasil", fontFamily = PlusJakartaSans, fontWeight = FontWeight.Bold, fontSize = 24.sp, color = colorResource(R.color.blue))
                    Text(text = "Data berhasil disimpan", fontFamily = PlusJakartaSans, fontWeight = FontWeight.Normal, fontSize = 16.sp, color = colorResource(R.color.blue))
                }
            },
            text = {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Nama", fontFamily = PlusJakartaSans, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = colorResource(R.color.blue))
                    Text(text = nama, fontFamily = PlusJakartaSans, fontWeight = FontWeight.Medium, fontSize = 16.sp, color = colorResource(R.color.blue))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Jenis Kelamin", fontFamily = PlusJakartaSans, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = colorResource(R.color.blue))
                    Text(text = gender, fontFamily = PlusJakartaSans, fontWeight = FontWeight.Medium, fontSize = 16.sp, color = colorResource(R.color.blue))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Status Perkawinan", fontFamily = PlusJakartaSans, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = colorResource(R.color.blue))
                    Text(text = status, fontFamily = PlusJakartaSans, fontWeight = FontWeight.Medium, fontSize = 16.sp, color = colorResource(R.color.blue))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Alamat", fontFamily = PlusJakartaSans, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = colorResource(R.color.blue))
                    Text(text = alamat, fontFamily = PlusJakartaSans, fontWeight = FontWeight.Medium, fontSize = 16.sp, color = colorResource(R.color.blue))
                }
            },
            confirmButton = {
                Button(onClick = {
                    showDialog = false
                    clearData()
                },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.blue),
                        contentColor = colorResource(R.color.white)
                    )) {
                    Text("Ok", fontFamily = PlusJakartaSans, fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)

                }
            }
        )
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(R.color.blue)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Formulir Pendaftaran",
                fontFamily = PlusJakartaSans,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = if (isLoading) Color.Transparent else colorResource(R.color.white),
                modifier = Modifier.shimmerLoading(isLoading)
            )
            GlassCard(
                modifier = Modifier
                    .padding(top = 12.dp, start = 24.dp, end = 24.dp, bottom = 80.dp)
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, start = 20.dp, end = 20.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column {
                            Text(
                                text = "Nama Lengkap",
                                fontFamily = PlusJakartaSans,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if (isLoading) Color.Transparent else colorResource(R.color.white),
                                modifier = Modifier.shimmerLoading(isLoading)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            TextField(
                                value = txtNama,
                                singleLine = true,
                                onValueChange = { txtNama = it },
                                shape = RoundedCornerShape(12.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedTextColor = colorResource(id = R.color.white),
                                    unfocusedTextColor = colorResource(id = R.color.white),
                                    focusedContainerColor = colorResource(R.color.blue),
                                    unfocusedContainerColor = Color.Transparent,
                                    disabledContainerColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    disabledIndicatorColor = Color.Transparent,
                                    cursorColor = colorResource(id = R.color.white)
                                ),
                                modifier = Modifier
                                    .border(width = 2.dp,
                                        color = colorResource(id = R.color.white),
                                        shape = RoundedCornerShape(12.dp))
                                    .fillMaxWidth()
                                    .shimmerLoading(isLoading)
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Column {
                            Text(
                                text = "Jenis Kelamin",
                                fontFamily = PlusJakartaSans,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if (isLoading) Color.Transparent else colorResource(R.color.white),
                                modifier = Modifier.shimmerLoading(isLoading)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Row {
                                jenis.forEach { item ->
                                    Row(
                                        modifier = Modifier.selectable(
                                            selected = txtGender == item,
                                            onClick = { txtGender = item }
                                        ), verticalAlignment = Alignment.CenterVertically) {
                                        RadioButton(
                                            selected = txtGender == item,
                                            onClick = { txtGender = item },
                                            colors = RadioButtonDefaults.colors(
                                                selectedColor = colorResource(R.color.white),
                                                unselectedColor = colorResource(R.color.white)
                                            ),
                                            modifier = Modifier
                                                .width(12.dp)
                                                .height(12.dp)
                                                .padding(start = 8.dp)
                                        )
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Text(
                                            item,
                                            fontFamily = PlusJakartaSans,
                                            fontWeight = FontWeight.Medium,
                                            fontSize = 14.sp,
                                            color = if (isLoading) Color.Transparent else colorResource(R.color.white),
                                            modifier = Modifier.shimmerLoading(isLoading)
                                        )
                                        Spacer(modifier = Modifier.width(20.dp))
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Column {
                            Text(
                                "Status Perkawinan",
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = if (isLoading) Color.Transparent else colorResource(R.color.white),
                                modifier = Modifier.shimmerLoading(isLoading)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            ExposedDropdownMenuBox(
                                expanded = expanded,
                                onExpandedChange = { expanded = it },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                TextField(
                                    value = txtStatus,
                                    onValueChange = {},
                                    readOnly = true,
                                    shape = RoundedCornerShape(12.dp),
                                    colors = TextFieldDefaults.colors(
                                        focusedTextColor = colorResource(id = R.color.white),
                                        unfocusedTextColor = colorResource(id = R.color.white),
                                        focusedContainerColor = colorResource(R.color.blue),
                                        unfocusedContainerColor = Color.Transparent,
                                        disabledContainerColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        disabledIndicatorColor = Color.Transparent,
                                        cursorColor = colorResource(id = R.color.white)
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .border(width = 2.dp,
                                            color = colorResource(id = R.color.white),
                                            shape = RoundedCornerShape(12.dp))
                                        .menuAnchor(),
                                    label = { Text("Pilih Status") },
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
                                    onDismissRequest = { expanded = false }
                                ) {
                                    nikah.forEach { opsi ->
                                        DropdownMenuItem(
                                            text = { Text(opsi) },
                                            onClick = {
                                                txtStatus = opsi
                                                expanded = false
                                            },
                                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                        )
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Column {
                            Text(
                                text = "Alamat",
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = if (isLoading) Color.Transparent else colorResource(R.color.white),
                                modifier = Modifier.shimmerLoading(isLoading)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            TextField(
                                value = txtAlamat,
                                onValueChange = { txtAlamat = it },
                                colors = TextFieldDefaults.colors(
                                    focusedTextColor = colorResource(id = R.color.white),
                                    unfocusedTextColor = colorResource(id = R.color.white),
                                    focusedContainerColor = colorResource(R.color.blue),
                                    unfocusedContainerColor = Color.Transparent,
                                    disabledContainerColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    disabledIndicatorColor = Color.Transparent,
                                    cursorColor = colorResource(id = R.color.white)
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .border(width = 2.dp,
                                        color = colorResource(id = R.color.white),
                                        shape = RoundedCornerShape(12.dp)),
                                shape = RoundedCornerShape(12.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        OutlinedButton(
                            onClick = onBackButtonClick,
                            shape = RoundedCornerShape(16.dp),
                            border = BorderStroke(2.dp, if (isLoading) Color.Transparent else colorResource(R.color.orange)),
                            colors = (if (isLoading) ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Transparent
                            )
                            else ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.white),
                                contentColor = colorResource(id = R.color.orange)
                            )),
                            modifier = Modifier
                                .width(120.dp)
                                .shimmerLoading(isLoading)
                        )
                        {
                            Text(
                                text = "Batal",
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }
                        Button(
                            modifier = Modifier
                                .width(120.dp)
                                .shimmerLoading(isLoading),
                            shape = RoundedCornerShape(16.dp),
                            colors = (if (isLoading) ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Transparent
                            )
                            else ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.orange),
                                contentColor = colorResource(id = R.color.white)
                            )),
                            enabled =
                                txtNama.isNotEmpty() &&
                            txtGender.isNotEmpty() &&
                            txtStatus.isNotEmpty() &&
                            txtAlamat.isNotEmpty(),
                            onClick = {
                                nama = txtNama
                                gender = txtGender
                                status = txtStatus
                                alamat = txtAlamat
                                showDialog = true
                            }
                        ) {
                            Text(
                                text = "Simpan",
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                modifier = Modifier.shimmerLoading(isLoading),
                                color = if (isLoading) Color.Transparent else colorResource(R.color.white)
                            )
                        }
                    }
                }
            }
        }
    }
}