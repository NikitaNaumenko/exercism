# frozen_string_literal: true

class Acronym
  def self.abbreviate(string)
    string.scan(/\b\w/).map(&:upcase).join('')
  end
end
