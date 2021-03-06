# Coding: Kata09_Checkout

This is a Java application. A framework 'Easy Rules' as a Java rules engine is used. 

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
Completely the task 'Kata09: Back to the Checkout' is here:

```
http://codekata.com/kata/kata09-back-to-the-checkout/

```

## What is Easy Rules?
Easy Rules is a Java rules engine inspired by an article called "Should I use a Rules Engine?" of Martin Fowler in which Martin says:

```
You can build a simple rules engine yourself. All you need is to create a bunch of objects with conditions and actions, store them in a collection, and run through them to evaluate the conditions and execute the actions.

```

This is exactly what Easy Rules does, it provides the Rule abstraction to create rules with conditions and actions, and the RulesEngine API that runs through a set of rules to evaluate conditions and execute actions.

## How to run

* Clone this repository 
* Make sure you are using JDK 1.8 and Maven 3.x
* You can build the project and run the tests by running:

```
mvn clean package

```
