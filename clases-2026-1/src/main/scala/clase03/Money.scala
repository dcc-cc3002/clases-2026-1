package clase03

class Money(val amount: Int, val currency: String):
  def add(other: Money): Money =
    // if(currency == other.currency)
    new Money(amount + other.amount, currency)

  override def equals(other: Any): Boolean =
    if (other.isInstanceOf[Money]) {
      val otherMoney = other.asInstanceOf[Money]
      amount == otherMoney.amount && currency == otherMoney.currency
    } else false

  override def toString: String = s"Money($amount, $currency)"
