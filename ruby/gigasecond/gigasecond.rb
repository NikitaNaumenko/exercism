# frozen_string_literal: true

class Gigasecond
  class << self
    POWER = 10e8
    def from(time)
      time + POWER
    end
  end
end
