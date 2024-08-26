package com.example.rickandmorty.ui.theme.screens.character_detail_screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rickandmorty.ui.theme.dataClass.characters_entity.CharacterDetail
import com.example.rickandmorty.ui.theme.screens.home_screen.LoadImage
import com.example.rickandmorty.ui.theme.viewModels.CharacterDetailViewModel

@Composable

fun CharacterDetailScreen() {
    val characterDetailViewModel: CharacterDetailViewModel = hiltViewModel()
    val characterDetail = characterDetailViewModel.characterDetail.collectAsState()
    val configuration = LocalConfiguration.current
    if (characterDetail.value == CharacterDetail.empty()) {
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
    } else {
        Box(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = Color(0xFF046064))
                .padding(10.dp)
        ) {

            when (configuration.orientation){
                Configuration.ORIENTATION_PORTRAIT -> {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        LoadImage(
                            image = characterDetail.value.image, modifier = Modifier
                                .size(150.dp)
                                .clip(shape = CircleShape)
                        )
                        Spacer(modifier = Modifier.height(15.dp))

                        Card(
                            modifier = Modifier
                                .fillMaxWidth(), colors = CardDefaults.cardColors(
                                containerColor = Color.Black.copy(alpha = 0.2f)
                            )
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                            ) {
                                SetText(
                                    text = characterDetail.value.name,
                                    18,
                                    FontWeight.W600
                                )
                                Spacer(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(Color.White)
                                )
                                Margin(size = 10)

                                BasicDetails(key = "Gender", value = characterDetail.value.gender)
                                Margin(size = 10)

                                BasicDetails(key = "Species", value = characterDetail.value.species)
                                Margin(size = 10)
                                BasicDetails(key = "Origin", value = characterDetail.value.origin.name)
                                Margin(size = 10)
                                BasicDetails(key = "Status", value = characterDetail.value.status)
                                Margin(size = 10)
                                BasicDetails(key = "Location", value = characterDetail.value.location.name)


                            }
                        }

                        Margin(size = 10)

                        Card(
                            modifier = Modifier
                                .fillMaxWidth(), colors = CardDefaults.cardColors(
                                containerColor = Color.Black.copy(alpha = 0.2f)
                            )
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                            ) {
                                SetText(
                                    text = "Episodes",
                                    18,
                                    FontWeight.W600
                                )
                                Spacer(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(Color.White)
                                )
                                Margin(size = 10)

                                LazyRow(modifier = Modifier.fillMaxWidth()) {
                                    items(characterDetail.value.episode) {
                                        EpisodeItem(characterDetail.value.episode.indexOf(it) + 1)
                                    }

                                }


                            }
                        }

                    }

                }
                Configuration.ORIENTATION_LANDSCAPE -> {

                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Row {
                            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                                LoadImage(
                                    image = characterDetail.value.image, modifier = Modifier
                                        .size(200.dp)
                                        .clip(shape = CircleShape)
                                )
                            }
                            Card(
                                modifier = Modifier
                                    .weight(1.3f)
                                    .fillMaxWidth(), colors = CardDefaults.cardColors(
                                    containerColor = Color.Black.copy(alpha = 0.2f)
                                )
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp)
                                ) {
                                    SetText(
                                        text = characterDetail.value.name,
                                        18,
                                        FontWeight.W600
                                    )
                                    Spacer(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(1.dp)
                                            .background(Color.White)
                                    )
                                    Margin(size = 10)

                                    BasicDetails(key = "Gender", value = characterDetail.value.gender)
                                    Margin(size = 10)

                                    BasicDetails(key = "Species", value = characterDetail.value.species)
                                    Margin(size = 10)
                                    BasicDetails(key = "Origin", value = characterDetail.value.origin.name)
                                    Margin(size = 10)
                                    BasicDetails(key = "Status", value = characterDetail.value.status)
                                    Margin(size = 10)
                                    BasicDetails(key = "Location", value = characterDetail.value.location.name)


                                }
                            }
                        }


                        Margin(size = 10)

                        Card(
                            modifier = Modifier
                                .fillMaxWidth(), colors = CardDefaults.cardColors(
                                containerColor = Color.Black.copy(alpha = 0.2f)
                            )
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                            ) {
                                SetText(
                                    text = "Episodes",
                                    18,
                                    FontWeight.W600
                                )
                                Spacer(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(Color.White)
                                )
                                Margin(size = 10)

                                LazyRow(modifier = Modifier.fillMaxWidth()) {
                                    items(characterDetail.value.episode) {
                                        EpisodeItem(characterDetail.value.episode.indexOf(it) + 1)
                                    }

                                }


                            }
                        }

                    }
                }

            }
        }
    }


}

@Composable
fun EpisodeItem(index: Int) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.2f)
        )
    ) {
        SetText(text = "Episode $index", size = 20, fontWeight = FontWeight.W500, padding = 15)
    }

}

@Composable
fun SetText(text: String, size: Int, fontWeight: FontWeight, padding: Int = 0) {
    Text(
        text = text,
        color = Color.White,
        fontSize = size.sp,
        fontWeight = fontWeight,
        fontFamily = FontFamily.SansSerif,
        modifier = Modifier.padding(padding.dp)
    )
}

@Composable
fun BasicDetails(key: String, value: String) {

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        SetText(text = "$key :", size = 16, fontWeight = FontWeight.W400)
        SetText(text = value, size = 16, fontWeight = FontWeight.W400)

    }
}

@Composable
fun Margin(size: Int) {
    Spacer(
        modifier = Modifier
            .height(size.dp)

    )
}