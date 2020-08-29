package triangle

import (
	"math"
	"sort"
)

// Kind indicates whether a triangle is isosceles, scalane, etc.
type Kind int

const (
	NaT Kind = iota
	Equ
	Iso
	Sca
)

// KindFromSides should have a comment documenting it.
func KindFromSides(a, b, c float64) Kind {
	sides := [3]float64{a, b, c}
	sort.Float64s(sides[:])

	// sides must have valid lengths

	for _, f := range sides {
		if f <= 0 || math.IsNaN(f) || math.IsInf(f, 0) { //if nan or inf then invalid
			return NaT
		}
	}

	if sides[0]+sides[1] < sides[2] {
		return NaT
	}

	if sides[0] == sides[1] && sides[0] == sides[2] {
		return Equ
	}

	if sides[0] == sides[1] || sides[1] == sides[2] {
		return Iso
	}

	return Sca
}
