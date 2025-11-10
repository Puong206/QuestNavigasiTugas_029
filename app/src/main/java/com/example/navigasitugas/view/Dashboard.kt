package com.example.navigasitugas.view

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

data class CardData(
    val nama: String,
    val gender: String,
    val status: String,
    val alamat: String
)

@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
){
    val glassBrush = Brush.radialGradient(
        colors = listOf(
            Color.White.copy(0.4f),
            Color.White.copy(0.15f)
        )
    )
    val glassBorder = Brush.linearGradient(
        colors = listOf(
            Color.White.copy(0.6f),
            Color.White.copy(0.2f)
        )
    )
    val cornerRadius = 16.dp
    Card(
        modifier = modifier
            .background(glassBrush)
            .border(
                width = 2.dp,
                brush = glassBorder,
                shape = RoundedCornerShape(cornerRadius)
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            content = content
        )
    }
}

fun Modifier.shimmerLoading(
    isLoading: Boolean,
    durationMillis: Int = 1000,
): Modifier = composed {
    if (!isLoading) {
        return@composed this
    }
    val transition = rememberInfiniteTransition(label = "")

    val translateAnimation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 500f,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = durationMillis,
                easing = LinearEasing,
                ),
            repeatMode = RepeatMode.Restart
        ),
        label = "",
    )

    return@composed drawBehind {
        drawRect(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color.LightGray.copy(alpha = 0.2f),
                    Color.LightGray.copy(alpha = 1.0f),
                    Color.LightGray.copy(alpha = 0.2f),
                ),
                start = Offset(x = translateAnimation, y = translateAnimation),
                end = Offset(x = translateAnimation + 100f, y = translateAnimation + 100f)
            )
        )
    }
}

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
//    val interactionSource = remember { MutableInteractionSource() }
//    val press by interactionSource.collectIsPressedAsState()
    var isLoading by remember { mutableStateOf(true) }
    LaunchedEffect(key1 = true) {
        delay(2000)
        isLoading = false
    }

    val logo = painterResource(id = R.drawable.listdata)

    Box(modifier = Modifier.fillMaxSize())
    {
        Scaffold(
            containerColor = colorResource(R.color.blue),
            topBar = {
                TopAppBar(
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        )
                        {
                            Text(
                                "List Daftar Peserta",
                                color = colorResource(R.color.orange),
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                                modifier = Modifier
                                    .padding(top = 20.dp,bottom = 20.dp)
                                    .shimmerLoading(isLoading)
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
                    containerColor = colorResource(R.color.blue)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        ElevatedButton(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.orange),
                                contentColor = colorResource(id = R.color.white)),
                            modifier = Modifier
                                .width(160.dp),
                            onClick = onExitButtonClick,
                        ) {
                            Text(
                                text = "Keluar",
                                fontSize = 20.sp,
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        ElevatedButton(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.orange),
                                contentColor = colorResource(id = R.color.white)),
                            modifier = Modifier
                                .width(160.dp),
                            onClick = onFormButtonClick
                        ) {
                            Text(
                                text = "Formulir",
                                fontSize = 20.sp,
                                fontFamily = PlusJakartaSans,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            })
        { frame ->
            val blurRadius = 5.dp
            Box(modifier = Modifier
                .padding(frame)
                .fillMaxSize()) {
                Box(modifier = Modifier
                    .height(400.dp)
                    .width(400.dp)
                    .blur(blurRadius)
                    .align(Alignment.Center)) {
                    Image(painter = logo,
                        contentScale = ContentScale.Fit,
                        contentDescription = null,
                        modifier = Modifier
                            .size(200.dp)
                            //.blur(blurRadius)
                            .align(Alignment.Center)
                    )
                }
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(items) { item ->
                        GlassCard(
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                        )
                        {
                            Row(
                                modifier = Modifier
                                    .padding(top = 8.dp, start = 8.dp, end = 8.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            )
                            {
                                Column {
                                    Text(
                                        text = "NAMA LENGKAP",
                                        fontSize = 16.sp,
                                        fontFamily = PlusJakartaSans,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(R.color.white),
                                        modifier = Modifier.shimmerLoading(isLoading)
                                    )
                                    Text(
                                        item.nama,
                                        fontSize = 16.sp,
                                        fontFamily = PlusJakartaSans,
                                        fontWeight = FontWeight.Normal,
                                        color = colorResource(R.color.white),
                                        modifier = Modifier.shimmerLoading(isLoading)
                                    )
                                }
                                Column {
                                    Text(
                                        text = "JENIS KELAMIN",
                                        fontSize = 16.sp,
                                        fontFamily = PlusJakartaSans,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(R.color.white),
                                        modifier = Modifier.shimmerLoading(isLoading)
                                    )
                                    Text(
                                        item.gender,
                                        fontSize = 16.sp,
                                        fontFamily = PlusJakartaSans,
                                        fontWeight = FontWeight.Normal,
                                        color = colorResource(R.color.white),
                                        modifier = Modifier.shimmerLoading(isLoading)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(12.dp))
                            Row(
                                modifier = Modifier
                                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            )
                            {
                                Column {
                                    Text(
                                        text = "STATUS PERKAWINAN",
                                        fontSize = 16.sp,
                                        fontFamily = PlusJakartaSans,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(R.color.white),
                                        modifier = Modifier
                                            .width(120.dp)
                                            .shimmerLoading(isLoading)
                                    )
                                    Text(
                                        item.status,
                                        fontSize = 16.sp,
                                        fontFamily = PlusJakartaSans,
                                        fontWeight = FontWeight.Normal,
                                        color = colorResource(R.color.white),
                                        modifier = Modifier.shimmerLoading(isLoading)
                                    )
                                }
                                Column {
                                    Text(
                                        text = "ALAMAT",
                                        fontSize = 16.sp,
                                        fontFamily = PlusJakartaSans,
                                        fontWeight = FontWeight.Bold,
                                        color = colorResource(R.color.white),
                                        modifier = Modifier.width(120.dp)
                                            .shimmerLoading(isLoading)
                                    )
                                    Text(
                                        item.alamat,
                                        fontSize = 16.sp,
                                        fontFamily = PlusJakartaSans,
                                        fontWeight = FontWeight.Normal,
                                        color = colorResource(R.color.white),
                                        modifier = Modifier.shimmerLoading(isLoading)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}