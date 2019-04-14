# frozen_string_literal: true

class FlattenArray
  class << self
    def flatten(array)
      array.each_with_object([]) do |value, acc|
        next if value.nil?

        if value.is_a?(Array)
          acc.concat(flatten(value))
        else
          acc << value
        end
      end
    end
  end
end
