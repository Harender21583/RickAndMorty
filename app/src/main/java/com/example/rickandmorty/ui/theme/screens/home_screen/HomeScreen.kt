package com.example.rickandmorty.ui.theme.screens.home_screen

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.example.rickandmorty.R
import com.example.rickandmorty.ui.theme.dataClass.characters_entity.Result
import com.example.rickandmorty.ui.theme.viewModels.CharacterViewModel

@Composable
fun HomeScreen(onClick: (id: String) -> Unit) {

    val characterViewModel: CharacterViewModel = hiltViewModel()
    val characterList = characterViewModel.characters.collectAsState()
    if (characterList.value.results.isNotEmpty()) {
        val configuration = LocalConfiguration.current
        Box(
            Modifier
                .fillMaxSize()
                .background(color = Color(0xFF046064))
        ) {

            when (configuration.orientation) {
                Configuration.ORIENTATION_PORTRAIT -> {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "RICK AND MORTY CHARACTERS",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W500,
                            fontFamily = FontFamily.Cursive
                        )
                        Image(
                            painter = painterResource(id = R.drawable.under_line),
                            contentDescription = null
                        )
                        Image(
                            painter = painterResource(id = R.drawable.app_icon),
                            contentDescription = null
                        )

                        Text(
                            text = "CHARACTERS",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W500,
                            fontFamily = FontFamily.Cursive
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(15.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(color = Color(0xFF046064))
                                .border(
                                    border = BorderStroke(5.dp, Color(0xFF23BCC2)),
                                    shape = RoundedCornerShape(20.dp)
                                )
                        ) {
                            LazyVerticalGrid(
                                columns = GridCells.Fixed(3), contentPadding = PaddingValues(8.dp),
                                verticalArrangement = Arrangement.SpaceAround,
                            ) {
                                items(characterList.value.results) {
                                    CharactersDetail(result = it, onClick)
                                }
                            }
                        }


                    }
                }

                Configuration.ORIENTATION_LANDSCAPE -> {

                    Row(modifier = Modifier.fillMaxSize()) {

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "RICK AND MORTY CHARACTERS",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.W500,
                                fontFamily = FontFamily.Cursive
                            )
                            Image(
                                painter = painterResource(id = R.drawable.under_line),
                                contentDescription = null
                            )
                            Image(
                                painter = painterResource(id = R.drawable.app_icon),
                                contentDescription = null
                            )
                        }
                        Column(
                            modifier = Modifier
                                .weight(1.5f)
                                .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "CHARACTERS",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.W500,
                                fontFamily = FontFamily.Cursive
                            )

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .padding(15.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(color = Color(0xFF046064))
                                    .border(
                                        border = BorderStroke(5.dp, Color(0xFF23BCC2)),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                            ) {
                                LazyVerticalGrid(
                                    columns = GridCells.Fixed(3),
                                    contentPadding = PaddingValues(8.dp),
                                    verticalArrangement = Arrangement.SpaceAround,
                                ) {
                                    items(characterList.value.results) {
                                        CharactersDetail(result = it, onClick)
                                    }
                                }
                            }

                        }
                    }


                }
            }


        }

    } else {
        Box(
            Modifier
                .fillMaxSize()
                .background(color = Color(0xFF046064)),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
            ) {
                CircularProgressIndicator()
            }
        }
    }
}


@Composable
fun CharactersDetail(result: Result, onClick: (id: String) -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(5.dp)
            .clickable {
                onClick(result.id.toString())
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.2f)
        )
    )
    {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LoadImage(
                image = result.image,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
            )
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = result.name,
                fontSize = 12.sp,
                color = Color.White,
                fontWeight = FontWeight.W400,
                fontFamily = FontFamily.SansSerif
            )

        }

    }
}


@Composable
fun LoadImage(image: String, modifier: Modifier) {
    Box(
        modifier = modifier
    )
    {
        SubcomposeAsyncImage(
            model = image,
            contentDescription = null,
            loading = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            },
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )
    }
}