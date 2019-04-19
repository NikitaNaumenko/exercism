# frozen_string_literal: true

class Gigasecond
  class << self
    SECONDS = 10e8
    def from(time)
      time + SECONDS
    end
  end
end
