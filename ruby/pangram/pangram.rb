# frozen_string_literal: true

class Pangram
  ALPHABET = %w[a b c d e f g h i j k l m n o p q r s t u v w x y z].freeze

  def self.pangram?(sentence)
    downcased_sentence = sentence.downcase
    ALPHABET.all? { |letter| downcased_sentence.include?(letter) }
  end
end
