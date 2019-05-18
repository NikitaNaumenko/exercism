# frozen_string_literal: true

class Complement
  MAP = {
    'G' => 'C',
    'C' => 'G',
    'T' => 'A',
    'A' => 'U'
  }.freeze

  def self.of_dna(rna)
    rna.split('').map { |r| MAP[r] }.join
  end
end
