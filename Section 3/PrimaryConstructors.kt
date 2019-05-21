@file:Suppress("unused", "RemoveEmptyClassBody", "JoinDeclarationAndAssignment")

package classes


class FirstCar (val type: String, val productionYear: Int) {

}

class SecondCar (type: String, productionYear: Int) {
    val type: String
    val productionYear: Int

    init {
        this.type = type
        this.productionYear = productionYear
    }
}

class ThirdCar (type: String, productionYear: Int) {
    val type: String = type
    val productionYear: Int = productionYear
}




class EmptyCar

class InjectedCar @Inject constructor(val type: String)





annotation class Inject
