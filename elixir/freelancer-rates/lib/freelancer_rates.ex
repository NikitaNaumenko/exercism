defmodule FreelancerRates do
  def daily_rate(hourly_rate) do
    8.0 * hourly_rate
  end

  def apply_discount(before_discount, discount) do
    discount = before_discount * discount / 100
    before_discount - discount
  end

  def monthly_rate(hourly_rate, discount) do
    rate = daily_rate(hourly_rate) * 22

    apply_discount(rate, discount)
    |> ceil()
  end

  def days_in_budget(budget, hourly_rate, discount) do
    rate =
      daily_rate(hourly_rate)
      |> apply_discount(discount)

    (budget / rate)
    |> Float.floor(1)
  end
end
