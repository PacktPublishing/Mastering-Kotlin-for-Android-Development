

interface ValueValidator {
    fun isValid(value: Any): Boolean
}

class GreaterThanValidator(private val target: Number) : ValueValidator {
    override fun isValid(value: Any): Boolean {
        if (value is Number) {
            return value.toDouble() > target.toDouble()
        }
        return false
    }
}

class LesserThanValidator(private val target: Number) : ValueValidator {
    override fun isValid(value: Any): Boolean {
        if (value is Number) {
            return value.toDouble() < target.toDouble()
        }
        return false
    }
}

class NotEqualToValidator(private val target: Int) : ValueValidator {
    override fun isValid(value: Any): Boolean {
        if (value is Int) {
            return value != target
        }
        return false
    }
}

class EqualToValidator(private val target: Int) : ValueValidator {
    override fun isValid(value: Any): Boolean {
        if (value is Int) {
            return value == target
        }
        return false
    }
}