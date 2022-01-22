package hamming

import (
	"errors"
	"strings"
)

func Distance(a, b string) (int, error) {
	if len(a) != len(b) {
		err := errors.New("Not the same length")
		return 0, err
	}

	firstDNA := strings.Split(a, "")
	secondDNA := strings.Split(b, "")

	var result int
	for i := 0; i < len(firstDNA); i++ {
		if firstDNA[i] != secondDNA[i] {
			result++
		}
	}
	return result, nil
}
