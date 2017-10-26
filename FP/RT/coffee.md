```scala
// Side Effect
class Cafe {
    def buyCoffee(cc: CreditCard): Coffee = { // Method of class is determined with def
        val cup = new Coffee()
        cc.charge(cup.price) // Side Effect!
        cup // Scala doesn't need return
    }
}

// Reduced Side Effect
class Cafe {
    def buyCoffee(cc: CreditCard, p: Payments): Coffee = {
        val cup = new Coffee()
        p.charge(cc, cup.price)
        cup
    }
}

//FP
class Cafe {
    def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
        val cup = new Coffee()
        (cup, Charge(cc, cup.price)) // No Side Effect!
    }
}

case class Charge(cc: CreditCard, amount: Double) { // Case Class is composed of primary constructor
    def combine(other: Charge): Charge =
        if (cc == other.cc)
            Charge(cc, amount + other.amount) // Case Class need not 'new' keywords
        else
            throw new Exception("Can't combine charges to different cards")
}
```