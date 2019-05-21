@file:Suppress("unused")

class ValidationContext<in T, out V>(val valueFactory: (T) -> V) {
    val validators = ArrayList<ValueValidator>()
    var errorMessage = emptyString
}

data class ValidationResult(val isValid: Boolean, val errorMessage: String?)

class Validator<T>(private val validatedObject: T) {

    internal var context: ValidationContext<T, Any>? = null

    fun validate(): ValidationResult {
        val ctx = context ?: throw UninitializedPropertyAccessException("You have to set rules on the validator first")
        val value = ctx.valueFactory.invoke(validatedObject)
        ctx.validators.forEach { v ->
            if (!v.isValid(value)) {
                return ValidationResult(false, ctx.errorMessage)
            }
        }
        return ValidationResult(true, null)
    }

    infix fun <V : Any> forValue(valueFactory: (T) -> V): RuleBuilder<T, V> {
        context = ValidationContext(valueFactory)
        return RuleBuilder(this)
    }

    companion object {
        infix fun <T> validates(value: T): Validator<T> {
            return Validator(value)
        }
    }
}

class RuleBuilder<T, V> internal constructor(internal val validator: Validator<T>) {

    infix fun greaterThan(target: Int): RuleBuilder<T, V> {
        validator.context?.validators?.add(GreaterThanValidator(target))
        return this
    }

    infix fun lesserThan(target: Int): RuleBuilder<T, V> {
        validator.context?.validators?.add(LesserThanValidator(target))
        return this
    }

    infix fun equalTo(target: Int): RuleBuilder<T, V> {
        validator.context?.validators?.add(EqualToValidator(target))
        return this
    }

    infix fun notEqualTo(target: Int): RuleBuilder<T, V> {
        validator.context?.validators?.add(NotEqualToValidator(target))
        return this
    }
}

infix fun <T, V> RuleBuilder<T, V>.withRules(init: (RuleBuilder<T, V>) -> Unit): ErrorBuilder<T> {
    init(this)
    return ErrorBuilder(this.validator)
}

class ErrorBuilder<T> internal constructor(private val validator: Validator<T>) {
    infix fun onError(msg: String): Validator<T> {
        this.validator.context?.errorMessage = msg
        return this.validator
    }
}

