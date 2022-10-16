defmodule Lasagna do
  @expected_minutes_in_oven 40
  @layer_prepare_minutes 2
  # Please define the 'expected_minutes_in_oven/0' function
  def expected_minutes_in_oven, do: @expected_minutes_in_oven
  def remaining_minutes_in_oven(timer) do
    @expected_minutes_in_oven - timer
  end

  def preparation_time_in_minutes(size) do
    @layer_prepare_minutes * size
  end

  def total_time_in_minutes(layers, minutes) do
    minutes + preparation_time_in_minutes(layers)
  end
  # Please define the 'total_time_in_minutes/2' function

  def alarm, do: "Ding!"
end
