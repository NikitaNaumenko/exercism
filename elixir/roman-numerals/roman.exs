defmodule Roman do
  @doc """
  Convert the number to a roman number.
  """
  @spec numerals(pos_integer) :: String.t()

  def numerals(number) when number >= 1000, do: convert(number, "M", 1000)
  def numerals(number) when number >= 900, do: convert(number, "CM", 900)
  def numerals(number) when number >= 500, do: convert(number, "D", 500)
  def numerals(number) when number >= 400, do: convert(number, "CD", 400)
  def numerals(number) when number >= 100, do: convert(number, "C", 100)
  def numerals(number) when number >= 90, do: convert(number, "XC", 90)
  def numerals(number) when number >= 50, do: convert(number, "L", 50)
  def numerals(number) when number >= 40, do: convert(number, "XL", 40)
  def numerals(number) when number >= 10, do: convert(number, "X", 10)
  def numerals(number) when number == 9 ,do: "IX"
  def numerals(number) when number >= 5, do: convert(number, "V", 5)
  def numerals(number) when number == 4, do: "IV"
  def numerals(number), do: String.duplicate("I", number)

  defp convert(number, roman, divider) do
    String.duplicate(roman, div(number, divider)) <> numerals(rem(number, divider))
  end
end
