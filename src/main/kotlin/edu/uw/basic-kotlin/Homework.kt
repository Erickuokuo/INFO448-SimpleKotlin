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
        val conversionRate = when (currency) {
            "USD" -> when (targetCurrency) {
                "GBP" -> 0.5
                "EUR" -> 0.75
                "CAN" -> 0.8333
                else -> 1.0
            }
            "GBP" -> when (targetCurrency) {
                "USD" -> 2.0
                "EUR" -> 1.5
                "CAN" -> 1.6666
                else -> 1.0
            }
            "EUR" -> when (targetCurrency) {
                "USD" -> 1.3333
                "GBP" -> 0.6666
                "CAN" -> 1.1111
                else -> 1.0
            }
            "CAN" -> when (targetCurrency) {
                "USD" -> 1.2
                "GBP" -> 0.6
                "EUR" -> 0.9
                else -> 1.0
            }
            else -> 1.0
        }

        val convertedAmount = (amount / conversionRate).toInt()
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

