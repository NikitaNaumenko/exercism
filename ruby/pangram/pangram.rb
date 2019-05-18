# frozen_string_literal: true

class Pangram
  ALPHABET = ('a'...'z').freeze

  def self.pangram?(string)
    ALPHABET.all? { |letter| string.downcase.include?(letter) }
  end
end
