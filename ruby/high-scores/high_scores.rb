# frozen_string_literal: true

class HighScores
  def initialize(scores)
    @scores = scores
  end

  attr_reader :scores

  def latest
    scores.last
  end

  def personal_best
    scores.max
  end

  def personal_top_three
    scores.sort.reverse[0..2]
  end
end
