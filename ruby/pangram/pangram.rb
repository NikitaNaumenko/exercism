# frozen_string_literal: true

class Pangram
  ALPHABET = %w[
    q w e r t y u i o p
    a s d f g h j k l
    z x c v b n m
  ].freeze

  def self.pangram?(sentence)
    sentence = sentence.downcase
    ALPHABET.all? { |letter| sentence.include?(letter) }
  end
end
