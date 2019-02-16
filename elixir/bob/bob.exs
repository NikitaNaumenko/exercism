defmodule Bob do
  def hey(input) do
    cond do
      String.trim(input) == "" -> "Fine. Be that way!"
      String.upcase(input) == input -> "Whoa, chill out!"
      String.ends_with?(input, "?") -> "Sure."
      String.upcase(input) == input && String.ends_with?(input, "?") -> " Calm down, I know what I'm doing!"
      true -> "Whatever."
    end
  end
end
