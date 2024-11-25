package com.example.cardseimagenesjavier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.cardseimagenesjavier.ui.theme.CardsEImagenesJAVIERTheme
import com.example.cardseimagenesjavier.R
import kotlin.random.Random
import androidx.compose.ui.tooling.preview.Preview as Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CardsEImagenesJAVIERTheme {
                Scaffold(
                    topBar = { TopBarComponent()},
                    bottomBar = { BottomBarComponent()},

                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier
                        .padding(innerPadding)
                        .background(Color(0xFF212121))
                        .fillMaxSize()
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.verticalScroll(rememberScrollState())
                        ) {
                            val imageUrls =  listOf(
                                "https://cdn.shopify.com/s/files/1/0490/7496/2599/collections/Real_madrid.jpg?v=1717615171",
                                "https://img.bolaskor.com/media/fd/19/89/fd1989d7a28bbe0e88257891156aaa5f.jpg",
                                "https://i.pinimg.com/originals/45/01/2d/45012d5be2751a61da62f927aabd74db.jpg",
                                "https://www.sportphotogallery.com/content/images/cmsfiles/product/10148/10148-zoom.jpg",
                                "https://i.pinimg.com/736x/61/a5/44/61a5447c4d0c74d70730ce53bb32b8cb.jpg",
                                "https://storage.googleapis.com/static.elsoldemexico.com.mx/elesto/nota-zizu-volea-e1434057484349.jpg",
                                "https://c.files.bbci.co.uk/10413/production/_100697566_hi045932006.jpg"
                            )
                                ImageCard(imageUrls)
                            }

                        }

                    }
                }
            }
        }
    }


@Composable
fun ImageCard(imageUrls:List<String>) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)) {
            imageUrls.forEach {imageUrl ->
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().height(500.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(){
    TopAppBar({Text(stringResource(R.string.app_name), color = Color.White)},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.DarkGray
        )
    )
}

@Composable
fun BottomBarComponent(){
    BottomAppBar(containerColor = Color.DarkGray) {
        IconButton(onClick = {}) {
            Icon(Icons.Filled.Home, contentDescription = "Inicio", tint = Color.White)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(Icons.Filled.Search, contentDescription = "Buscar", tint = Color.White)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Agregar", tint = Color.White)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(Icons.Filled.PlayArrow, contentDescription = "Reproducir", tint = Color.White)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {}) {
            Icon(Icons.Filled.Person, contentDescription = "Perfil", tint = Color.White)
        }

    }

}


