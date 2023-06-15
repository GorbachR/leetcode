package RotateArray

import (
	"reflect"
	"testing"
)

func TestRotate(t *testing.T) {

	input1 := []int{1, 2, 3, 4, 5, 6, 7}

	rotate(input1, 3)

	expected1 := []int{5, 6, 7, 1, 2, 3, 4}
	if !reflect.DeepEqual(input1, expected1) {
		t.Errorf("Test 1 failed, expected: %v, got: %v", expected1, input1)
	}

	input2 := []int{-1, -100, 3, 99}

	rotate(input2, 2)

	expected2 := []int{3, 99, -1, -100}
	if !reflect.DeepEqual(input2, expected2) {
		t.Errorf("Test 2 failed, expected: %v, got: %v", expected2, input2)
	}

	input3 := []int{1}

	rotate(input3, 0)

	expected3 := []int{1}
	if !reflect.DeepEqual(input3, expected3) {
		t.Errorf("Test 3 failed, expected: %v, got: %v", expected3, input3)
	}
}

func TestRotate2(t *testing.T) {

	input1 := []int{1, 2, 3, 4, 5, 6, 7}

	rotate2(input1, 3)

	expected1 := []int{5, 6, 7, 1, 2, 3, 4}
	if !reflect.DeepEqual(input1, expected1) {
		t.Errorf("Test 1 failed, expected: %v, got: %v", expected1, input1)
	}

	input2 := []int{-1, -100, 3, 99}

	rotate2(input2, 2)

	expected2 := []int{3, 99, -1, -100}
	if !reflect.DeepEqual(input2, expected2) {
		t.Errorf("Test 2 failed, expected: %v, got: %v", expected2, input2)
	}

	input3 := []int{1}

	rotate2(input3, 0)

	expected3 := []int{1}
	if !reflect.DeepEqual(input3, expected3) {
		t.Errorf("Test 3 failed, expected: %v, got: %v", expected3, input3)
	}
}

func TestRotate3(t *testing.T) {

	input1 := []int{1, 2, 3, 4, 5, 6, 7}

	rotate3(input1, 3)

	expected1 := []int{5, 6, 7, 1, 2, 3, 4}
	if !reflect.DeepEqual(input1, expected1) {
		t.Errorf("Test 1 failed, expected: %v, got: %v", expected1, input1)
	}

	input2 := []int{-1, -100, 3, 99}

	rotate3(input2, 2)

	expected2 := []int{3, 99, -1, -100}
	if !reflect.DeepEqual(input1, expected1) {
		t.Errorf("Test 2 failed, expected: %v, got: %v", expected2, input2)
	}

	input3 := []int{1}

	rotate3(input3, 0)

	expected3 := []int{1}
	if !reflect.DeepEqual(input3, expected3) {
		t.Errorf("Test 3 failed, expected: %v, got: %v", expected3, input3)
	}
}
