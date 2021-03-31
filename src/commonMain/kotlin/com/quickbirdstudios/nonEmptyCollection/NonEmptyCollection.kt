package com.quickbirdstudios.nonEmptyCollection

interface NonEmptyCollection<T> : Collection<T> {

    @Deprecated(
        level = DeprecationLevel.ERROR,
        message = "Is never null!",
        replaceWith = ReplaceWith("first()")
    )
    fun firstOrNull(): T = first()

    @Deprecated(
        level = DeprecationLevel.ERROR,
        message = "Alternative is never used!",
        replaceWith = ReplaceWith("first()")
    )
    fun firstOr(alternative: () -> T): T = first()
}
