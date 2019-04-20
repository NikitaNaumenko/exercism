# frozen_string_literal: true

class Acronym
  def self.abbreviate(string)
    string.tr('-', ' ').split(' ').map(&:chr).map(&:upcase).join('')
  end
end
