# frozen_string_literal: true

class Gigasecond
  class << self
    def from(time)
      time + 10**9
    end
  end
end
