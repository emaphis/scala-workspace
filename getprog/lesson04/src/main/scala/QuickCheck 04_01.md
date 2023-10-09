# Quick Check 4

## 4.1 Can you use the += operator with a value of type Int? What about the operator -=?

No, vals are immutable so += and -= can't update them

## Quick Check 4.2 Which of these expressions are valid? Use the REPL to validate your hypotheses. 

1. val test: Double = 2.0  - valid
2. val test: Int = 2.0   - invalid
3. val test: Any = 2.0   - valid

## 4.3 Can you use the += operator with a var of type String? What about the operator -=?

Yes. vars are mutable so can be updated.
