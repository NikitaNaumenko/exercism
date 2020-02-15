# frozen_string_literal: true

class Matrix
  def initialize(stringify_matrix)
    @rows = stringify_matrix.split("\n").map { |m| m.split(' ').map(&:to_i) }
    @columns = @rows.transpose
  end

  attr_reader :rows, :columns
end
