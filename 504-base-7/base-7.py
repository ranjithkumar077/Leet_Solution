class Solution:

  def convertToBase7(self, num: int) -> str:
    if num == 0:
      return "0"

    n = abs(num)
    digits = []

    while n > 0:
      digits.append(str(n % 7))
      n //= 7

    if num < 0:
      digits.append("-")

    return "".join(reversed(digits))