# Coding: Kata09_Checkout

This is a Java  application.

## Code problem details:

Back to the supermarket. This week, we’ll implement the code for a checkout system that handles pricing schemes such as “apples cost 50 cents, three apples cost $1.30.”

Way back in KataOne we thought about how to model the various options for supermarket pricing. We looked at things such as “three for a dollar,” “$1.99 per pound,” and “buy two, get one free.”

This week, let’s implement the code for a supermarket checkout that calculates the total price of a number of items. In a normal supermarket, things are identified using Stock Keeping Units, or SKUs. In our store, we’ll use individual letters of the alphabet (A, B, C, and so on). Our goods are priced individually. In addition, some items are multipriced: buy n of them, and they’ll cost you y cents. For example, item ‘A’ might cost 50 cents individually, but this week we have a special offer: buy three ‘A’s and they’ll cost you $1.30. In fact this week’s prices are:

```
  Item   Unit      Special
         Price     Price
  --------------------------
    A     50       3 for 130
    B     30       2 for 45
    C     20
    D     15
```