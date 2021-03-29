# NonEmptyCollections 
## Making the world a little more type-safe 🌍🏆

![Cover Image](https://user-images.githubusercontent.com/74978506/112829487-7d31b780-9091-11eb-8182-c5a12ff46a8e.png)

Reduce the need for emptiness checks and reduce unsafe APIs with **NonEmptyCollections**.

You can use `NonEmptyList`, `NonEmptySet` and `NonEmptyMap` to restrict the input of functions to make your code safer and avoid unnecessary runtime exceptions.

For a detailed explanation see our related article [Non-Empty Collections in Kotlin](https://quickbirdstudios.com/blog/non-empty-collections-kotlin).

This is an early version and work in progress. Do not hesitate to give feedback, ideas or improvements via an issue.

# Examples

## Average without exceptions

With the `NonEmptyList` type, we can make sure that at least one element is always a list. If we want to calculate the average of that list, it is impossible to compile a program where an invalid input is passed to our function. 

```kotlin
fun NonEmptyList<Int>.average() = sum() / size
```

```kotlin
nonEmptyListOf<Int>().average()   // This does not compile! ❌

nonEmptyListOf(1, 2, 3).average() // This does! ✅
```

## Non-empty Shopping-Cart

Let's imagine an online shop, where you can put articles into a shopping cart. If you have some articles in the shopping cart, you should be able to share the articles with your friends, save them for later on a wish list or directly buy them. But these three features just make sense if the shopping cart is not empty. Wouldn't it be cool to already prevent at compile-time that somebody tries these features with an empty set of articles?

```kotlin
sealed class ShoppingCart {
    object Empty : ShoppingCart()

    data class Filled(
        val articles: NonEmptySet<Article>
    ) : ShoppingCart() {

        fun buy(paymentType: PaymentType) = articles.buy(paymentType)
        fun share() = articles.share()
        fun saveTo(wishList: WishList) = articles.saveTo(wishList)
    }
}

fun NonEmptyCollection<Article>.buy(paymentType: PaymentType) { 💸 }

fun NonEmptyCollection<Article>.share() { 💬 }

fun NonEmptyCollection<Article>.saveTo(wishList: WishList) { 💾 }
```

The devs, who implement `buy`, `share` and `saveTo` don't have to handle the empty case. The consumers of these APIs don't have to think of exception handling, because they are forced by the compiler to provide a valid input. We would say, that's a win-win situation 🏆.

# 🏃 Library Setup
## 1. Add the repository
`build.gradle.kts`

```kotlin
allprojects {
    repositories {
    	 ...
        maven { url = uri("https://jitpack.io") }
    }
}
```

## 2. Add the dependency
`build.gradle.kts`

```kotlin
dependencies {
   implementation(project("com.quickbirdstudios:nonEmptyCollection:1.0.0"))
}
```

# 👤 Author
This Kotlin library is created with ❤️ by [QuickBird Studios](https://quickbirdstudios.com/).

# ❤️ Contributing
Open an issue if you need help, if you found a bug, or if you want to discuss a feature request.

Open a PR if you want to make changes to NonEmptyCollections.

# 📃 License
NonEmptyCollections is released under an MIT license. See [License](LICENSE) for more information.
