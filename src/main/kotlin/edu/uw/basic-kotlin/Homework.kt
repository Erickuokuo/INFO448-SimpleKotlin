package edu.uw.basickotlin

class Library {
    // This is just here as a placeholder, to make sure tests run and pass
    // before you add any code
    fun someLibraryMethod(): Boolean {
        return true
    }
}

// write a "whenFn" that takes an arg of type "Any" and returns a String
    fun whenFn(args: Any): String {
    return when (args) {
        "Hello" -> "world"
        is String -> "I don't understand"
        0 -> "zero"
        1 -> "one"
        in 2..10 -> "low number"
        is Number -> "a number"
        else -> "I don't understand"
    }
    }

    // write an "add" function that takes two Ints, returns an Int, and adds the values
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    // write a "sub" function that takes two Ints, returns an Int, and subtracts the values
    fun sub(a: Int, b: Int): Int {
        return a - b
    }

    // write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
    fun mathOp(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }

// write a class "Person" with first name, last name and age
    class Person(val firstName: String, val lastName: String, val age: Int) {
        val debugString: String
            get() = "[Person firstName:$firstName lastName:$lastName age:$age]"
    }
// write a class "Money" with amount and currency, and define a convert() method and the "+" operator
class Money(var amount: Int, var currency: String) {
    init {
        require(amount >= 0) { "Amount cannot be less than zero." }
        require(currency in setOf("USD", "EUR", "CAN", "GBP")) { "Invalid currency." }
    }
    fun convert(targetCurrency: String): Money {
        val convertedAmount = when (currency) {
            "USD" -> when (targetCurrency) {
                "GBP" -> amount / 2
                "EUR" -> amount * 3 / 2
                "CAN" -> amount * 5 / 4
                else -> amount
            }
            "GBP" -> when (targetCurrency) {
                "USD" -> amount * 2
                "EUR" -> amount * 3
                "CAN" -> amount * 5 / 2
                else -> amount
            }
            "EUR" -> when (targetCurrency) {
                "USD" -> amount * 2 / 3
                "GBP" -> amount / 3
                "CAN" -> amount * 5 / 6
                else -> amount
            }
            "CAN" -> when (targetCurrency) {
                "USD" -> amount * 4 / 5
                "GBP" -> amount * 2 / 5
                "EUR" -> amount * 6 / 5
                else -> amount
            }
            else -> amount
        }
        return Money(convertedAmount, targetCurrency)
    }


    operator fun plus(other: Money): Money {
        if (currency == other.currency) {
            return Money(amount + other.amount, currency)
        } else {
            val convertedOther = other.convert(currency)
            return Money(amount + convertedOther.amount, currency)
        }
    }
    override fun toString(): String {
        return "$amount $currency"
    }
}

