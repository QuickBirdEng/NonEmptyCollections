package com.quickbirdstudios.nonEmptyCollection

interface NonEmptyCollection<out T> : Collection<T> {

    @Deprecated(
        level = DeprecationLevel.ERROR,
        message = "Is never null!",
        replaceWith = ReplaceWith("first()")
    )
    fun firstOrNull(): T = first()
}

@Deprecated(
    level = DeprecationLevel.ERROR,
    message = "Alternative is never used!",
    replaceWith = ReplaceWith("first()")
)
fun <T> NonEmptyCollection<T>.firstOr(alternative: () -> T): T = first()
