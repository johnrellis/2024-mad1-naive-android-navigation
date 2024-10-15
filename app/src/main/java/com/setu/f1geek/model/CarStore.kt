package com.setu.f1geek.model

class CarStore(
    val cars: List<Car> = mutableListOf(),
    val brands: List<Brand> = mutableListOf()
)

fun seedDriverStore(): CarStore {
    // TODO: add 5 drivers to a mutable list and return an initialised driver store
    val ford = Brand(name = "ford")
    val nissan = Brand(name = "nissan")

    val focus = Car(name = "focus", brand = ford)
    val skyline = Car(name = "skyline", brand = nissan)

    val brands = listOf(ford, nissan)

    val cars = listOf(focus, skyline)

    return CarStore(cars = cars, brands = brands)
}