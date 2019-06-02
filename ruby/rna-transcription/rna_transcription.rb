# frozen_string_literal: true

class Complement
  DNA_TO_RNA = {
    'G' => 'C',
    'C' => 'G',
    'T' => 'A',
    'A' => 'U'
  }.freeze

  def self.of_dna(rna)
    rna.chars.map(&DNA_TO_RNA).join
  end
end
