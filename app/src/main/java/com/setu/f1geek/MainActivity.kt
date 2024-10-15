package com.setu.f1geek

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.setu.f1geek.model.Brand
import com.setu.f1geek.model.Car
import com.setu.f1geek.model.seedDriverStore
import com.setu.f1geek.ui.theme.F1GeekTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var selectedBrand: Brand? = null
        setContent {
            F1GeekTheme {
                val driverStore = seedDriverStore()
                var currentScreen by remember { mutableStateOf("") }
                val clickOnBrand = { brand: Brand ->
                    println("Selected ${brand.name}")
                    selectedBrand = brand
                    currentScreen = "car"
                }
                val goHome = { currentScreen = "" }
                if (currentScreen === "car") {
                    println(selectedBrand?.name)
                    val cars = driverStore.cars.filter { it.brand.name === selectedBrand?.name }
                    CarList(
                        cars = cars,goHome, Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    )
                } else {
                    BrandList(
                        brands = driverStore.brands, clickOnBrand, Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    )
                }

            }
        }
    }
}


@Composable
fun BrandList(brands: List<Brand>, onClickHandler: (Brand) -> Unit, modifier: Modifier = Modifier) {
    Column(modifier) {
        brands.forEachIndexed { index, brand ->
            val backgroundColor = if (index % 2 == 0) Color.LightGray else Color.White
            Text(
                text = brand.name,
                modifier = modifier
                    .background(backgroundColor)
                    .clickable { onClickHandler(brand) },
                )
        }
    }
}

@Composable
fun CarList(cars: List<Car>,onClickHandler: () -> Unit, modifier: Modifier = Modifier) {
    println(cars)
    Column(modifier) {
        Button(onClick = { onClickHandler() }, modifier = modifier) {
            Text("Home")
        }
        cars.forEachIndexed { index, brand ->
            val backgroundColor = if (index % 2 == 0) Color.LightGray else Color.White
            Text(
                text = brand.name,
                modifier = modifier.background(backgroundColor)
            )
        }
    }
}