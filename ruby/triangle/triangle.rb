# frozen_string_literal: true

class Triangle
  def initialize(side_lengths)
    @side_lengths = side_lengths
  end

  attr_reader :side_lengths

  def equilateral?
    return unless triangle?

    side_lengths.uniq.count == 1
  end

  def isosceles?
    return unless triangle?

    side_lengths.uniq.count <= 2
  end

  def scalene?
    return unless triangle?

    side_lengths.uniq.count == 3
  end

  private

  def triangle?
    side_lengths.max > 0 && triangle_inequality_holds?
  end

  def triangle_inequality_holds?
    side_lengths.permutation(3).all? { |(a, b, c)| a <= b + c }
  end
end
